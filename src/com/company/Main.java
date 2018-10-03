//Задание: Формирование подарка
//Реализовано:
//1. Вывод на консоль общего веса
//2. Вывод на консоль общей цены
//3. Вывод на консоль всех сладостей в подарке
//4. Добавлена реализация добавления конфет в подарок и перерасчет общих параметров

package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Sweets> addSweets(ArrayList<Sweets> sweets) {

        boolean exitFlag = false;
        while (!exitFlag) {
            System.out.println("Choose the number of the sweet \n" +
                    "1. Marmelad \n" +
                    "2. JellyBelly \n" +
                    "3. ChupaChups \n" +
                    "4. Chocolate \n" +
                    "5. Exit \n");
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1: {
                    Marmelad marmelad = new Marmelad();
                    System.out.println("Enter the color:");
                    Scanner scanner1 = new Scanner(System.in);
//                    TODO add exception handler
                    marmelad.color = scanner1.nextLine();
                    System.out.println("Enter weight(in kg) of marmelad\n");
                    Scanner scanner2 = new Scanner(System.in);
                    marmelad.weight = scanner2.nextFloat();
                    System.out.println("Enter price(for kg) of marmelad\n");
                    Scanner scanner3 = new Scanner(System.in);
                    marmelad.price = scanner3.nextFloat();
                    System.out.println("Enter name of marmelad\n");
                    Scanner scanner4 = new Scanner(System.in);
                    marmelad.name = scanner4.nextLine();
                    sweets.add(marmelad);
                    break;
                }
                case 2: {
                    JellyBelly jellyBelly = new JellyBelly();
                    System.out.println("Enter the size (in cm):");
                    Scanner scanner1 = new Scanner(System.in);
//                    TODO add exception handler
                    jellyBelly.size = scanner1.nextLine();
                    System.out.println("Enter weight(in kg) of jellyBelly\n");
                    Scanner scanner2 = new Scanner(System.in);
                    jellyBelly.weight = scanner2.nextFloat();
                    System.out.println("Enter price(for kg) of jellyBelly\n");
                    Scanner scanner3 = new Scanner(System.in);
                    jellyBelly.price = scanner3.nextFloat();
                    System.out.println("Enter name of jellyBelly\n");
                    Scanner scanner4 = new Scanner(System.in);
                    jellyBelly.name = scanner4.nextLine();
                    sweets.add(jellyBelly);
                    break;
                }
                case 3: {
                    ChupaChups chupaChups = new ChupaChups();
                    System.out.println("Do you want with gum(enter true if yes; enter false if not)? \n");
                    Scanner scanner1 = new Scanner(System.in);
//                    TODO add exception handler
                    chupaChups.withGum = scanner1.nextBoolean();
                    System.out.println("Enter weight(in kg) of chupaChups\n");
                    Scanner scanner2 = new Scanner(System.in);
                    chupaChups.weight = scanner2.nextFloat();
                    System.out.println("Enter price(for kg) of chupaChups\n");
                    Scanner scanner3 = new Scanner(System.in);
                    chupaChups.price = scanner3.nextFloat();
                    System.out.println("Enter name of chupaChups\n");
                    Scanner scanner4 = new Scanner(System.in);
                    chupaChups.name = scanner4.nextLine();
                    sweets.add(chupaChups);
                    break;
                }
                case 4: {
                    Chocolate chocolate = new Chocolate();
                    System.out.println("Enter the percent of chocolate: \n");
                    Scanner scanner1 = new Scanner(System.in);
//                    TODO add exception handler
                    chocolate.percengeOfChocolate= scanner1.nextInt();
                    System.out.println("Enter weight(in kg) of chocolate\n");
                    Scanner scanner2 = new Scanner(System.in);
                    chocolate.weight = scanner2.nextFloat();
                    System.out.println("Enter price(for kg) of chocolate\n");
                    Scanner scanner3 = new Scanner(System.in);
                    chocolate.price = scanner3.nextFloat();
                    System.out.println("Enter name of chocolate\n");
                    Scanner scanner4 = new Scanner(System.in);
                    chocolate.name = scanner4.nextLine();
                    sweets.add(chocolate);
                    break;
                }

                case 5:
                    exitFlag = true;
                    break;
                default:
                    exitFlag = true;
                    break;
            }

        }
        return sweets;
    }

//    public static Sweets chooseParameters(Sweets sweets) {
//
//        System.out.println("Enter weight of " + sweets.getClass().getSimpleName().toString());
//        Scanner scanner = new Scanner(System.in);
//        sweets.weight = scanner.nextFloat();
//        System.out.println("Enter price of " + sweets.getClass().getSimpleName().toString());
//        Scanner scanner1 = new Scanner(System.in);
//        sweets.price = scanner1.nextFloat();
//        System.out.println("Enter name of " + sweets.getClass().getSimpleName().toString());
//        Scanner scanner2 = new Scanner(System.in);
//        sweets.name = scanner2.nextLine();
//        return sweets;
//    }

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

        ArrayList<Sweets> list = new ArrayList<Sweets>();
        list.add(marmelad);
        list.add(jellyBelly);
        list.add(chupaChups);
        list.add(chocolate);

        System.out.println("Do You want to add sweet to present? (Yes/No)\n");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("Yes")) {
            addSweets(list);
        }

//        System.out.println("All weight = " + getAllWeight(sweets));
        System.out.println("All weight collection = " + getAllWeightCollection(list));
//        System.out.println("All price = " + getAllPrice(sweets));
        System.out.println("All price collection = " + getAllPriceCollection(list));
//        System.out.println("Present contains: " + getAllNames(sweets));
        System.out.println("Present contains: " + getAllNamesCollection(list));

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

    private static float getAllWeightCollection(ArrayList<Sweets> sweets) {

        Float allWeight = 0.0f;

        for (Sweets currentSweet : sweets) {
            allWeight += currentSweet.weight;
        }
        return allWeight;
    }

    private static float getAllPriceCollection(ArrayList<Sweets> sweets) {

        Float allPrice = 0.0f;

        for (Sweets currentSweet : sweets) {
            allPrice += currentSweet.price * currentSweet.weight;
        }
        return allPrice;
    }

    private static String getAllNamesCollection(ArrayList<Sweets> sweets) {

        String allNames = " ";

        for (Sweets currentSweet : sweets) {
            allNames += currentSweet.name + " ";
        }
        return allNames;
    }
}
