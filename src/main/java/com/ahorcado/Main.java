package com.ahorcado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("");
        System.out.println("***************************");
        System.out.println("");
        System.out.println("Welcome to Hangman!");
        System.out.println("Press any letter to start");
        System.out.println("");
        System.out.println("***************************");
        System.out.println("");

        // Input of the user
        Scanner input = new Scanner(System.in);

        // Create an ArrayList with name wordsList
        ArrayList<String> wordsList = new ArrayList<>();

        // Add items to ArrayList
        Collections.addAll(wordsList, "banano", "manzana", "uva", "fresa", 
        "sandia", "durazno", "pera", "mandarina", "naranja", "guanabana");

        // Select a random word from wordsList
        String hiddenText = wordsList.get((int) (Math.random() * wordsList.size()));
        char[] textArray = hiddenText.toCharArray();

        char[] myAnswers = new char[textArray.length];

        for (int i = 0; i < textArray.length; i++) {
            myAnswers[i] = '_';
        }

        boolean finished = false;
        int lives = 3;

        while (!finished) {
            System.out.print("Enter a letter: ");
            String letter = input.next().toLowerCase();

            // Checks for valid input
            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Error input - Try Again");
                letter = input.next().toLowerCase();
            }

            // Check if letter is in the word
            boolean found = false;
            for (int i = 0; i < textArray.length; i++) {
                if (letter.charAt(0) == textArray[i]) {
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }

            if (!found) {
                lives--;
                System.out.println("");
                System.out.println("------- WRONG LETTER -------");
                System.out.println("");
            }

            // Display current progress
            for (int i = 0; i < myAnswers.length; i++) {
                System.out.print(" " + myAnswers[i]);
            }
            System.out.println("\nLives left: " + lives);
            drawHangman(lives);

            // Check if the game ends
            if (new String(myAnswers).equals(hiddenText)) {
                System.out.println("Congrats! You found the word: " + hiddenText);
                finished = true;
            }

            if (lives <= 0) {
                System.out.println("You are dead! The word was: " + hiddenText);
                finished = true;
            }
        }

        input.close();
    }

    public static void drawHangman(int lives) {
        switch (lives) {
            case 3:
                System.out.println("");
                System.out.println("|----------");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("");
                break;
            case 1:
                System.out.println("");
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|-");
                System.out.println("|    |");
                System.out.println("|");
                System.out.println("|");
                System.out.println("|");
                System.out.println("");
                break;
            default:
                System.out.println("");
                System.out.println("|----------");
                System.out.println("|    O");
                System.out.println("|   -|-");
                System.out.println("|    |");
                System.out.println("|   / \\");
                System.out.println("|");
                System.out.println("|");
                System.out.println("");
                break;
        }
    }
}
