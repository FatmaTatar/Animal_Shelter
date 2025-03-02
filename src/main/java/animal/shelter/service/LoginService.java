package animal.shelter.service;

import animal.shelter.model.LoginDTO;
import animal.shelter.model.User;
import animal.shelter.repository.UserRepository;
import animal.shelter.utility.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Authenticates the user and generates a JWT token if the credentials are valid.
    public LoginDTO login(LoginDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();
        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            User user = userOptional.get();
            String token = JWTUtil.generateToken(user.getIdUser(), user.getRole(), user.getEmail());
            return new LoginDTO(email, password, user.getRole(), token, false);
        }

        return null;
    }
//
//    public LoginDTO blockUser (LoginDTO loginDTO){
//        userRepository.findByEmail(loginDTO.getEmail());
//        Optional<User> userOptional = userRepository.findByEmail();
//    }

    // Registers a new user if the email is not already in use.
    public String register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return "User already exists";
        }

        userRepository.saveUser(user);
        return "Registration successful";
    }
}
