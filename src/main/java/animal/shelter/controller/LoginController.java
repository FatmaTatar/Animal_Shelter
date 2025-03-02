package animal.shelter.controller;

import animal.shelter.model.LoginDTO;
import animal.shelter.model.User;
import animal.shelter.service.LoginService;
import animal.shelter.utility.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    // Validates the user credentials and generates a JWT token if valid.
    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginDTO) {
        LoginDTO responseDTO = loginService.login(loginDTO);
        if (responseDTO != null) {
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

    }


    // Endpoint for user registration.
    // Registers a new user with the role of "user".
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        user.setRole("user");
        String result = loginService.register(user);
        if (result.equals("Registration successful")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
