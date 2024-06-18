package com.ahorcado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        
        // Welcome
        System.out.println("***************************");
        System.out.println("");
        System.out.println("Welcome to Hangman!");
        System.out.println("Press any letter for start");
        System.out.println("");
        System.out.println("***************************");

        // input of the user
        Scanner input = new Scanner(System.in);

        // Create a ArrayList with name wordsList
        ArrayList<String> wordsList = new ArrayList<>();

        // Add the items to ArrayList
        Collections.addAll(wordsList, "banano", "manzana", "uva", "fresa", 
        "sandia", "durazno", "pera", "mandarina", "naranja", "guanabana");

        // Select a random word from wordsList
        String hidden_text = wordsList.get((int)(Math.random() * wordsList.size()));
        char[] textArray = hidden_text.toCharArray();

        char[] myAnswers = new char[textArray.length];

        for(int i = 0; i < textArray.length; i++){
            myAnswers[i] = '?';
        }

        boolean finished = false;
        int lives = 6;

        while (finished == false) {
            String letter = input.next();
            // Checks for valid input

            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Error input - Try Again");
                letter = input.next();
            }

            // check if letter is in the word
            boolean found = false;
            for(int i = 0; i < textArray.length; i++){
                if(letter.charAt(0) == textArray[i]) {
                    myAnswers[i] = textArray[i];
                    found = true;
                }
            }
            
            if(!found){
                lives--;
                System.out.println("WRONG LETTER");
            }

            boolean done = true;
            for(int i = 0; i < myAnswers.length; i++){
                if(myAnswers[i] == '?'){
                    System.out.println(" _");   
                    done = false;
                }else{
                    System.out.println(" " + myAnswers[i]);
                }
            }

            System.out.println("\n" + "Lives left: " + lives);
            drawHangman(lives);

            // check if the game ends
            if(done){
                System.out.println("Congrats You Found the Word");
                finished = true;
            }

            if(lives <= 0){
                System.out.println("You are dead!");
                finished = true;
            }
        }
    }

    public static void drawHangman(int l) {
        if(l == 3) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 1){
            
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else{
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|    |");
            System.out.println("|   /l");
            System.out.println("|");
            System.out.println("|");
        }
    }    
}
