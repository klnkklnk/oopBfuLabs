package bfu.oop.lab5;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("users.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Файл users.txt создан.");
            } else {
                System.out.println("Файл users.txt уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла users.txt.");
            e.printStackTrace();
        }
        File currentUserFile = new File("currentUser.txt");
        try {
            if (currentUserFile.createNewFile()) {
                System.out.println("Файл currentUser.txt создан.");
            } else {
                System.out.println("Файл currentUser.txt уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла currentUser.txt.");
            e.printStackTrace();
        }
        
        FileCurrentUserRepository currentUserRepository = new FileCurrentUserRepository(currentUserFile.getPath());
        IUserRepository userRepository = new FileUserRepository(file.getPath());
        UserManager userManager = new UserManager(userRepository, currentUserRepository);
        
        // Пример использования методов
        User user1 = new User(1, "user1", "password1", "User 1");
        User user2 = new User(2, "user2", "password2", "User 2");
        
        try
        {
            System.out.println("Is authorized: " + userManager.isAuthorized() + " -- " + currentUserRepository.getUser().getLogin());
        }
        catch (NullPointerException e)
        {
            System.out.println("Not authorized");
        }
        
        userManager.signIn(user1);
        System.out.println("Is authorized: " + userManager.isAuthorized()); // Output: true

        userManager.signOut(user1);
        System.out.println("Is authorized: " + userManager.isAuthorized()); // Output: false

        userManager.signIn(user2);
        System.out.println("Is authorized: " + userManager.isAuthorized()); // Output: true

        User retrievedUser = userRepository.getById(1);
        if (retrievedUser != null) {
            System.out.println("Retrieved user: " + retrievedUser.getName());
        } else {
            System.out.println("User not found.");
        }

    }
}
