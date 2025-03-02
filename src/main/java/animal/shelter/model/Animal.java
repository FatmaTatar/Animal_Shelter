package animal.shelter.model;

public class Animal {

    //Attribute
    private int idAnimal;
    private String name;
    private String species;
    private int age;
    private String gender;
    private String description;
    private String status;
    private  String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //Constructors
    public Animal(int idAnimal, String name, String species, int age, String gender, String description, String status, String  color) {
        this.idAnimal = idAnimal;
        this.name = name;
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.status = status;
        this.color = color;

    }

    public Animal() {
    }

    // Returns a string representation of the animal.
    @Override
    public String toString() {
        return String.format("%s", name);
    }

    // Getters & Setters
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
