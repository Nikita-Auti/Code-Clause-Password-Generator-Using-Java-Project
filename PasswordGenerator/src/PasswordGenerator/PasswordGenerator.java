package PasswordGenerator;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_-+=<>?";

    public static void main(String[] args) {
        int length = 12; // Specify the desired length of the password
        
        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) {
        StringBuilder sb = new StringBuilder(length);
        SecureRandom random = new SecureRandom();

        // Add at least one character from each category
        sb.append(getRandomCharacter(UPPER, random));
        sb.append(getRandomCharacter(LOWER, random));
        sb.append(getRandomCharacter(DIGITS, random));
        sb.append(getRandomCharacter(SPECIAL, random));

        // Fill the remaining length with random characters
        int remainingLength = length - 4;
        for (int i = 0; i < remainingLength; i++) {
            String allCharacters = UPPER + LOWER + DIGITS + SPECIAL;
            sb.append(getRandomCharacter(allCharacters, random));
        }

        return sb.toString();
    }

    private static char getRandomCharacter(String characters, SecureRandom random) {
        int index = random.nextInt(characters.length());
        return characters.charAt(index);
    }
}
