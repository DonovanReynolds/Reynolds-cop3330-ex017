package org.example;

import java.util.Scanner;

/*
 *   UCF COP 3330 Fall 2021 Assignment 17 Solution
 *   Copyright 2021 Donovan Reynolds
 */
public class App 
{
    public static void main( String[] args )
    {
        String alcoholText = inputOutput("How much alcohol was consumed in ounces?");
        int alcohol = stringToInt(alcoholText, "How much alcohol was consumed in ounces?");
        String weightText = inputOutput("What is your weight in pounds?");
        int weight = stringToInt(weightText,"What is your weight in pounds?");
        String genderText = inputOutput("What is your gender? Enter Male or Female.");
        double gender = findGender(genderText,"What is your gender? Enter Male or Female.");
        String hoursText = inputOutput("How many hours has it been since your last drink?");
        int hours = stringToInt(hoursText,"What is your gender? Enter Male or Female.");





        double bac = (alcohol * 5.14 / weight * gender) - .015 * hours;

        System.out.printf("Your BAC is %.6f\n", bac);
        isLegal(bac);



    }

    public static String inputOutput(String textToSay)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(textToSay);
        return input.nextLine();
    }

    public static int stringToInt(String text, String error)
    {
        int temp = 0;
        boolean check = false;
        while(!check)
        {
            try
            {
                temp = Integer.parseInt(text);
                check = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("You entered a value that is not a number. Please try again.");
                text = inputOutput(error);

            }
        }
        return temp;
    }

    public static double stringToDouble (String text, String error)
    {
        double temp = 0.0;
        boolean check = false;
        while(!check)
        {
            try
            {
                temp = Double.parseDouble(text);
                check = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("You entered a value that is not a number. Please try again.");
                text = inputOutput(error);
            }
        }
        return temp;
    }

    public static double findGender(String input,String error) {

        while (true) {
            char temp = input.toLowerCase().charAt(0);
            if (temp == 'f')
                return .66;
             else if (temp == 'm')
                return .73;
             else
             {
                System.out.println("Please enter a valid response of Male or Female.");
                input = inputOutput(error);
             }
        }
    }

    public static void isLegal(double bac)
    {
        if (bac < .08)
        {
            System.out.println("It is legal for you to drive");
        }
        else
            System.out.println("It is not legal for you to drive");
    }

}
