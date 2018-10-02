package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Marmelad marmelad = new Marmelad();
        marmelad.name = "PinkBubble";
        marmelad.price = 300.0f;
        marmelad.weight = 0.1f;
        marmelad.color = "red";

        JellyBelly jellyBelly = new JellyBelly();
        jellyBelly.name = "CandyCrush";
        jellyBelly.price = 450.0f;
        jellyBelly.weight = 0.5f;
        jellyBelly.size = "long";

        ChupaChups chupaChups = new ChupaChups();
        chupaChups.name = "Worms";
        chupaChups.price = 150.0f;
        chupaChups.weight = 0.3f;
        chupaChups.withGum = true;

        Chocolate chocolate = new Chocolate();
        chocolate.name = "Babaevsky";
        chocolate.price = 500.0f;
        chocolate.weight = 0.6f;
        chocolate.percengeOfChocolate = 70;

        Sweets[] sweets = new Sweets[]{marmelad, jellyBelly, chupaChups, chocolate};

//        for (Sweets curSweet: sweets
//             ) {
//            System.out.println("Enter weight of " + curSweet.getClass().getSimpleName().toString());
//            Scanner scanner = new Scanner(System.in);
//            curSweet.weight = scanner.nextFloat();
//            System.out.println("Enter price of " + curSweet.getClass().getSimpleName().toString());
//            Scanner scanner1 = new Scanner(System.in);
//            curSweet.price = scanner1.nextFloat();
//        }

        System.out.println("All weight = " + getAllWeight(sweets));
        System.out.println("All price = " + getAllPrice(sweets));
        System.out.println("Present contains: " + getAllNames(sweets));

    }

    private static float getAllWeight(Sweets[] sweets) {

        Float allWeight = 0.0f;

        for (Sweets currentSweet : sweets) {
            allWeight += currentSweet.weight;
        }
        return allWeight;
    }

    private static float getAllPrice(Sweets[] sweets) {

        Float allPrice = 0.0f;

        for (Sweets currentSweet : sweets) {
            allPrice += currentSweet.price * currentSweet.weight;
        }
        return allPrice;
    }

    private static String getAllNames(Sweets[] sweets) {

        String allNames = " ";

        for (Sweets currentSweet : sweets) {
            allNames += currentSweet.name + " ";
        }
        return allNames;
    }
}
