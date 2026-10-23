import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class UsersApp {

    public static void main(String[] args) {

        ArrayList<User> validUsers = new ArrayList<>();

        try {
            File readFile = new File("users.txt");
            Scanner reader = new Scanner(readFile);

            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");

                if (parts.length >= 2) {
                    try {
                        User newUser = new User(parts[0], parts[1]);
                        validUsers.add(newUser);
                    } catch (IllegalArgumentException e) {
                        System.out.println(line + " | " + e.getMessage());
                    }

                }
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println("An error occurred while reading the file.");
        }
        Collections.sort(validUsers, (u1, u2) -> u1.getName().compareTo(u2.getName()));

        for (User u : validUsers) {
            System.out.println(u.getName() + " " + u.getPassword());
        }

    }
}
