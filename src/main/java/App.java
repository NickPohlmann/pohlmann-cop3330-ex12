/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

import java.util.Scanner;
import java.lang.Math;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        String principalString = myApp.readInput("Enter the principal: ");
        String interestRateString = myApp.readInput("Enter the rate of interest: ");
        String yearsString = myApp.readInput("Enter the number of years: ");
        float principal = myApp.convertInputToFloat(principalString);
        float interestRatePercentage = myApp.convertInputToFloat(interestRateString);
        int years = myApp.convertInputToInt(yearsString);
        float interestRateDecimal = myApp.computeInterestRateDecimal(interestRatePercentage);
        float interest = myApp.computeInterest(principal, interestRateDecimal, years);
        String outputString = myApp.generateOutputStatement(years, interestRatePercentage, interest);
        myApp.printOutputStatement(outputString);
    }

    private String generateOutputStatement(int years, float interestRatePercentage, float interest) {
        return ("After " + years + " years at " + interestRatePercentage + "%, the investment will be worth $" + interest);
    }

    private void printOutputStatement(String output) { System.out.println(output); }

    private String readInput(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }

    private int convertInputToInt(String inputString) {
        int input = Integer.parseInt(inputString);
        return input;
    }

    private float convertInputToFloat(String inputString) {
        float input = Float.parseFloat(inputString);
        return input;
    }

    private float computeInterestRateDecimal(float interestRatePercentage) {
        float interestRateDecimal =  interestRatePercentage / 100;
        return interestRateDecimal;
    }

    private float computeInterest(float principal, float interestRateDecimal, int years) {
        float interest = principal * (1+(interestRateDecimal*years));
        interest = (float) ((Math.floor(interest*100))/100);
        return interest;
    }
}