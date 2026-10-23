public class User {
    private String userName;
    private String password;

public User(String userName, String password){

    if (userName.length() > 50) {
        throw new IllegalArgumentException("Username is too long, try something shorter");
    }

    String emailRegex = "^[a-zA-Z0-9.%+-]+@[a-zA-Z0-9][a-zA-Z0-9.-]*\\.[a-zA-Z]{2,}$";
    if (!userName.matches(emailRegex)) {
        throw new IllegalArgumentException("Please enter a valid Email as username");
    }

    if (password.length() < 8) {
        throw new IllegalArgumentException("Your password is too short, add more characters");
    }
    if (password.length() > 12) {
        throw new IllegalArgumentException("Your password is too long, try a shorter one");
    }

    String passwordRegex = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]).+$";
    if (!password.matches(passwordRegex)) {
        throw new IllegalArgumentException("Please enter a valid password");
    }

    this.userName = userName;
    this.password = password;
}

    public String getName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }
}