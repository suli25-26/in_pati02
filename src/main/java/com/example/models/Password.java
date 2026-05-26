package com.example.models;

import java.util.Random;

public class Password {
    public static boolean isValid(String password) {
        boolean valid = true;
        String reg = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[=()#\\[\\]\\?;:\\*\\$\\+]).{3,}$";
        if (!password.matches(reg)) {
            valid = false;
        }
        return valid;
    }

    public static String generate(boolean[] setup, int passLength) {
        String smallChars = "abcdefghijklmnopqrstuxyvwz";
        String largeChars = "ABCDEFGHIJKLMNOPQRSTUXYVWZ";
        String numbers = "0123456789";
        String symbols = "=()#[]?;:*$+";
        StringBuilder newText = new StringBuilder();
        Random random = new Random();

        while (newText.toString().length() < passLength) {
            int selected = -1;
            if (setup[0] && newText.toString().length() < passLength) {
                selected = random.nextInt(smallChars.length());
                newText.append(smallChars.charAt(selected));
            }

            if (setup[1] && newText.toString().length() < passLength) {
                newText.append(largeChars.charAt(selected));
            }

            if (setup[2] && newText.toString().length() < passLength) {
                selected = random.nextInt(10);
                newText.append(numbers.charAt(selected));
            }

            if (setup[3] && newText.toString().length() < passLength) {
                selected = random.nextInt(symbols.length());
                newText.append(symbols.charAt(selected));
            }

        }

        return newText.toString();
    }
}
