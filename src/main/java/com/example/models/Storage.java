package com.example.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Storage {
    public static List<User> readContent() {
        try {
            return tryReadContent();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<User> tryReadContent() throws FileNotFoundException {
        List<User> userList = new ArrayList<>();
        File file = new File("users.txt");
        try (Scanner sc = new Scanner(file)) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(":");
                User user = new User();
                user.setUser(parts[0]);
                user.setPass(parts[1]);
                user.setRole(parts[2]);
                userList.add(user);
            }
        }
        return userList;
    }

    public static void writeContent(List<User> userList) {
        try {
            tryWriteContent(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void tryWriteContent(List<User> userList) throws IOException {
        FileWriter fileWriter = new FileWriter("users.txt");

        String header = "username:password:role";
        fileWriter.write(header + "\n");

        for(User user: userList) {
            String line = 
            user.getUser() + ":" +
            user.getPass() + ":" +
            user.getRole() + "\n";
            fileWriter.write(line);
        }
        

        fileWriter.close();

    }
}
