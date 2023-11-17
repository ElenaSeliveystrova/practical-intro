package org.tasks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.*;

public class PracticalIntro {
    public static final String PAPER = "Paper";
    public static final String SCISSORS = "Scissors";
    private static final Scanner scanner = new Scanner(System.in);
    public static final String ROCK = "Rock";
    private static final String UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String CHARACTER = " !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";


    public static void main(String[] args) {
        calculateFinalPrice();
        calculateAverageTemperature();
        countVowels();
        determineEvenOrOdd();
        getGrade();
        ageClassifier();
        interestsCalculator();
        simpleGame();
        passwordGenerator();
        scanner.close();
    }

    // task 1
    public static void calculateFinalPrice() {
        System.out.println("Enter you price excluding VAT");
        double price = scanner.nextDouble();
        double priceVAT = (price / 5) + price;
        BigDecimal result = new BigDecimal(priceVAT);
        BigDecimal priceVATRounded = result.setScale(2, RoundingMode.CEILING);
        System.out.print("Your price: " + price + " hrn. \nFinal cost including VAT (20%): " + priceVATRounded + "  hrn.");
    }

    //task 2
    public static void calculateAverageTemperature() {
        float summ = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter temperature (" + i + " day)");
            float temperature = scanner.nextFloat();
            summ = summ + temperature;
        }
        System.out.println("Average temperature is " + summ / 5 + " degrees celsius");

    }

    //task 3
    public static void countVowels() {
        System.out.println("Enter your string");
        String st = scanner.nextLine().toLowerCase();
        int count = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == 'a' || st.charAt(i) == 'e'
                    || st.charAt(i) == 'i' || st.charAt(i) == 'o'
                    || st.charAt(i) == 'u') {
                count++;
            }
        }
        System.out.println(count);

    }

    // task 4
    public static void determineEvenOrOdd() {
        System.out.println("Please enter your number");
        int number = scanner.nextInt();
        if (number % 2 == 0) {
            System.out.println("Your number is Even");
        } else {
            System.out.println("Your number is Odd");
        }

    }

    // task 5
    public static void getGrade() {
        System.out.println("Please enter your numerical score");
        int score = scanner.nextInt();
        if (score >= 90 && score <= 100) {
            System.out.println("A");
        } else if (score >= 80 && score < 90) {
            System.out.println("B");
        } else if (score >= 70 && score < 80) {
            System.out.println("C");
        } else if (score >= 60 && score < 70) {
            System.out.println("D");
        } else if (score >= 50 && score < 60) {
            System.out.println("F");
        } else if (score <= 49 && score > 0) {
            System.out.println("Exem didn't pass!!!");
        } else {
            System.out.println("Incorrect score!!!");
        }

    }

    // task 6
    public static void ageClassifier() {
        System.out.println("Please, enter your age!");
        int age = scanner.nextInt();
        if (age >= 0 && age <= 12) {
            System.out.println("Child");
        } else if (age >= 13 && age <= 19) {
            System.out.println("Teenager");
        } else if (age >= 20 && age < 60) {
            System.out.println("Adult");
        } else if (age >= 60) {
            System.out.println("Senior");
        } else {
            System.out.println("Incorrect data!!!");
        }
    }

    //task 7
    public static void interestsCalculator() {
        System.out.println("The initial amount of money");
        double deposit = scanner.nextDouble();
        System.out.println("The annual interest rate (decimal)");
        double rate = scanner.nextDouble();
        System.out.println("Time the money is invested for, in years");
        int years = scanner.nextInt();

        double sumBegininngYear = deposit;

        for (int i = 1; i <= years; i++) {
            double sumPercent = sumBegininngYear * rate;
            sumBegininngYear = sumPercent + sumBegininngYear;

            System.out.println("income of the " + i + "th year is " + sumPercent);
            System.out.println(sumBegininngYear);
        }
        double finalAmount = deposit * Math.pow((1 + rate), years);
        System.out.println("The amount of money accumulated after " + years + " year, including interest is " + sumBegininngYear);
        System.out.println("The amount of money by formula for calculating the final amount of a bank deposit using compound interest is" + finalAmount);
    }


    //task 8
    public static void simpleGame() {
        String userChoice = "";
        Random select = new Random();
        String[] arr = {ROCK, PAPER, SCISSORS};
        int appScore = 0;
        int userScore = 0;

        System.out.println("Enter your choice (\"Rock\", \"Paper\", \"Scissors\") or quit (the end game)");
        userChoice = scanner.nextLine();

        while (!userChoice.equals("quit")) {

            int appChoice = select.nextInt(arr.length);
            System.out.println(arr[appChoice]);

            if (arr[appChoice].equals(ROCK) && userChoice.equals(PAPER)) {
                userScore++;
            } else if (arr[appChoice].equals(PAPER) && userChoice.equals(ROCK)) {
                appScore++;
            } else if (arr[appChoice].equals(ROCK) && userChoice.equals(SCISSORS)) {
                appScore++;
            } else if (arr[appChoice].equals(SCISSORS) && userChoice.equals(ROCK)) {
                userScore++;
            } else if (arr[appChoice].equals(SCISSORS) && userChoice.equals(PAPER)) {
                appScore++;
            } else if (arr[appChoice].equals(PAPER) && userChoice.equals(SCISSORS)) {
                userScore++;
            }
            System.out.println("user: " + userScore + " app: " + appScore);

            System.out.println("Enter your choice (\"Rock\", \"Paper\", \"Scissors\") or quit (the end game)");
            userChoice = scanner.nextLine();
        }
    }

    // task 9
    public static void passwordGenerator() {
        System.out.println("Length");
        int length = scanner.nextInt();

        while (length < 8) {
            System.out.println("Length can't be < 8");
            length = scanner.nextInt();
        }

        System.out.println("Exclude specific types of characters? (true or false)");
        boolean excludeSpecificCharacters = scanner.nextBoolean();

        StringBuilder password = getStringBuilder(length, excludeSpecificCharacters);

        if (password.length() != length) {
            password.delete(length, password.length());
        }

        System.out.println("Password " + password);

    }

    private static StringBuilder getStringBuilder(int length, boolean excludeSpecificCharacters) {
        StringBuilder password = new StringBuilder(length);
        Random random = new SecureRandom();
        int x;
        if (excludeSpecificCharacters) {
            x = (int) Math.ceil((double) length / 3);
        } else {
            x = (int) Math.ceil((double) length / 4);
        }

        for (int i = 0; i < x; i++) {
            if (!excludeSpecificCharacters) {
                char characterResult = CHARACTER.charAt(random.nextInt(CHARACTER.length()));
                password.append(characterResult);
            }
            char upperResult = UPPER_ALPHABET.charAt(random.nextInt(UPPER_ALPHABET.length()));
            char lowerResult = LOWER_ALPHABET.charAt(random.nextInt(LOWER_ALPHABET.length()));
            char digitsResult = DIGITS.charAt(random.nextInt(DIGITS.length()));

            password.append(upperResult);
            password.append(lowerResult);
            password.append(digitsResult);
        }
        return password;
    }

}