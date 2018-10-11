//Задание: Формирование подарка
//Реализовано:
//1. Вывод на консоль общего веса
//2. Вывод на консоль общей цены
//3. Вывод на консоль всех сладостей в подарке
//4. Добавлена реализация добавления конфет в подарок и перерасчет общих параметров
//5. Добавлено удаление сладостей по одной из списка
//6. Добавлены аннотации к сладостям и вывод в консоль с помощью аннотаций

package com.company;


import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    interface SweetFactory<S extends Sweet> {
        S create(String name, Float weight, Float price);
    }

    interface MarmeladFactory<M extends Marmelad> {
        M create(String color, String string, String name);
    }

    interface ChocolateFactory<C extends Chocolate> {
        C create(Integer percengeOfChocolate, String name, Float price);
    }

    public static void main(String[] args) {

        SweetFactory<Sweet> sweetSweetFactory = Sweet::new;
        MarmeladFactory<Marmelad> marmeladMarmeladFactory = Marmelad::new;
        ChocolateFactory<Chocolate> chocolateChocolateFactory = Chocolate::new;


        List<Sweet> list1 = new ArrayList<>();
        list1.add(sweetSweetFactory.create("LollyPop", 30f, 450f));
        list1.add(chocolateChocolateFactory.create(40, "Milky", 500f));
        list1.add(chocolateChocolateFactory.create(20, "Wilky", 100f));
        list1.add(chocolateChocolateFactory.create(60, "Vilky", 200f));
        list1.add(chocolateChocolateFactory.create(90, "Pilky", 900f));
        list1.add(marmeladMarmeladFactory.create("Orange", "something", "Sun"));
        list1.add(marmeladMarmeladFactory.create("Purple", "something", "Plum"));
        list1.add(marmeladMarmeladFactory.create("Aqua", "something", "River"));
        list1.add(marmeladMarmeladFactory.create("White", "something", "Snow"));

        //Как выводить уникальные параметры из наследников Sweet?

        Map<String, String> mp = list1.stream().collect(Collectors.toMap(
                Sweet::getName,
                o -> o.getName() + " " + o.getPrice() + " " + o.getWeight()
        ));
//        list.stream().collect(Collectors.toMap(o -> o.getFirstName() + "aa", Person::getLastName));
        System.out.println(mp);

        System.out.println("______________________________\n");

        list1.stream().sorted(Comparator.comparing(Sweet::getName)).forEach(Sweet::print);

        System.out.println(Sweet.class.getPackage().getClass().getClasses());

        Marmelad marmelad = new Marmelad();
//        marmelad.setName("PinkBubble");
        marmelad.name = "PinkBubble";
        marmelad.price = 300.0f;
        marmelad.weight = 0.1f;
//        marmelad.color = "red";

        marmelad.getClass().getAnnotation(UnicColor.class).color();//как поменять цвет именно в этом marmelad?

        try {
            Field field = marmelad.getClass().getDeclaredField("string");
            field.setAccessible(true);
            System.out.println((String) field.get(marmelad));
            //как вытащить здесь же аннотацию с помощью рефлексии?
            //С помощью setter. В цикле найти метод который обратится к параметру и сделать его доступным. :/
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        JellyBelly jellyBelly = new JellyBelly("long");
        jellyBelly.name = "CandyCrush";
        jellyBelly.price = 450.0f;
        jellyBelly.weight = 0.5f;
//        jellyBelly.size = "long";

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

        System.out.println(marmelad.getClass().getAnnotation(UnicColor.class).color());
        System.out.println(jellyBelly.getClass().getAnnotation(UnicSize.class).size());
        System.out.println(chupaChups.getClass().getAnnotation(UnicWithGum.class).withGum());
        System.out.println(chocolate.getClass().getAnnotation(UnicPercentage.class).percengeOfChocolate());

        Sweet[] sweets = new Sweet[]{marmelad, jellyBelly, chupaChups, chocolate};

        HashMap<Integer, Sweet> list = new HashMap<Integer, Sweet>();
        list.put(1, marmelad);
        list.put(2, jellyBelly);
        list.put(3, chupaChups);
        list.put(4, chocolate);

        System.out.println("Do You want to add sweet to present? (Yes/No)\n" +
                "If you want to remove sweet from present, please enter any value");

        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("Yes")) {
            addSweets(list);
        }
        System.out.println("Do You want to remove sweet from present? (Yes/No)\n");
        Scanner scanner1 = new Scanner(System.in);
        if (scanner1.nextLine().equals("Yes")) {
            removeSweets(list);
        }

//        System.out.println("All weight = " + getAllWeight(sweets));
        System.out.println("All weight collection = " + getAllWeightCollection(list));
//        System.out.println("All price = " + getAllPrice(sweets));
        System.out.println("All price collection = " + getAllPriceCollection(list));
//        System.out.println("Present contains: " + getAllNames(sweets));
        System.out.println("Present contains: " + getAllNamesCollection(list));

    }
    //        return sweets;
    //        sweets.name = scanner2.nextLine();
    //        Scanner scanner2 = new Scanner(System.in);
    //        System.out.println("Enter name of " + sweets.getClass().getSimpleName().toString());
    //        sweets.price = scanner1.nextFloat();
    //        Scanner scanner1 = new Scanner(System.in);
    //        System.out.println("Enter price of " + sweets.getClass().getSimpleName().toString());
    //        sweets.weight = scanner.nextFloat();
    //        Scanner scanner = new Scanner(System.in);
    //        System.out.println("Enter weight of " + sweets.getClass().getSimpleName().toString());
    //
//    public static Sweet chooseParameters(Sweet sweets) {

//    }
    //        return ret;
    //        ret.put(section,res);
    //        HashMap<Integer, String> ret = new HashMap<>();
    //        String res = sc.next();
    //        int section = sc.nextInt();
    //        }
    //            {flag = true; break;}
    //            if(menu.keySet().contains(section))
    //            int section = sc.nextInt();
    //        while (!flag){
    //        int section = -1;
    //        boolean flag = true;
    //        Scanner sc = new Scanner(System.in);
    //        }
    //            System.out.println(m.getKey() + "" + m.getValue());
    //        for (Map.Entry m: menu.entrySet()){
    //
    //        menu.put(2, "input weight");
    //        menu.put(1, "input price");
    //        HashMap<Integer, String> menu = new HashMap<>();
    //
//    public void goMenu(){

//    }


    public static HashMap<Integer, Sweet> addSweets(HashMap<Integer, Sweet> sweets) {

        sweets.keySet();
        boolean exitFlag = false;
        int i = 1;
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
                    sweets.put(4 + i, marmelad);
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
                    sweets.put(4 + i, jellyBelly);
                    break;
                }
                case 3: {
                    ChupaChups chupaChups = new ChupaChups();
                    System.out.println("Do you want with gum (enter true if yes; enter false if not)? \n");
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
                    sweets.put(4 + i, chupaChups);
                    break;
                }
                case 4: {
                    Chocolate chocolate = new Chocolate();
                    System.out.println("Enter the percent of chocolate: \n");
                    Scanner scanner1 = new Scanner(System.in);
//                    TODO add exception handler
                    chocolate.percengeOfChocolate = scanner1.nextInt();
                    System.out.println("Enter weight(in kg) of chocolate\n");
                    Scanner scanner2 = new Scanner(System.in);
                    chocolate.weight = scanner2.nextFloat();
                    System.out.println("Enter price(for kg) of chocolate\n");
                    Scanner scanner3 = new Scanner(System.in);
                    chocolate.price = scanner3.nextFloat();
                    System.out.println("Enter name of chocolate\n");
                    Scanner scanner4 = new Scanner(System.in);
                    chocolate.name = scanner4.nextLine();
                    sweets.put(4 + i, chocolate);
                    break;
                }

                case 5:
                    exitFlag = true;
                    break;
                default:
                    exitFlag = true;
                    break;
            }
            i++;

        }
        return sweets;
    }

    private static HashMap<Integer, Sweet> removeSweets(HashMap<Integer, Sweet> sweets) {

        boolean flag = false;
        while (!flag) {
            System.out.println("Which number of sweet do you want to remove? (ex. '1')\n");
            for (Map.Entry<Integer, Sweet> currentSweet : sweets.entrySet()) {
                System.out.println(currentSweet.getKey().toString() + ". " + currentSweet.getValue().name);
            }
            Scanner scanner = new Scanner(System.in);
            Integer input = scanner.nextInt();
            sweets.remove(input);
            System.out.println("Do you want quit? (Yes/No)");
            Scanner scanner1 = new Scanner(System.in);
            String input1 = scanner1.nextLine();
            if (input1.equals("Yes")) {
                flag = true;
            }
        }

        for (Map.Entry<Integer, Sweet> currentSweet : sweets.entrySet()) {
            System.out.println(currentSweet.getKey().toString() + ". " + currentSweet.getValue().name);
        }

        return sweets;
    }

    private static float getAllWeightCollection(HashMap<Integer, Sweet> sweets) {

        Float allWeight = 0.0f;

        for (Map.Entry<Integer, Sweet> currentSweet : sweets.entrySet()) {
            Sweet sweet = currentSweet.getValue();
            allWeight += sweet.weight;
        }
        return allWeight;
    }

    private static float getAllPriceCollection(HashMap<Integer, Sweet> sweets) {

        Float allPrice = 0.0f;

        for (Map.Entry<Integer, Sweet> currentSweet : sweets.entrySet()) {
            Sweet sweet = currentSweet.getValue();
            allPrice += sweet.price * sweet.weight;
        }
        return allPrice;
    }

    private static String getAllNamesCollection(HashMap<Integer, Sweet> sweets) {

        String allNames = " ";

        for (Map.Entry<Integer, Sweet> currentSweet : sweets.entrySet()) {
            Sweet sweet = currentSweet.getValue();
            allNames += sweet.name + " ";
        }
        return allNames;
    }
//    private static float getAllWeight(Sweet[] sweets) {
//
//        Float allWeight = 0.0f;
//
//        for (Sweet currentSweet : sweets) {
//            allWeight += currentSweet.weight;
//        }
//        return allWeight;
//    }
//
//    private static float getAllPrice(Sweet[] sweets) {
//
//        Float allPrice = 0.0f;
//
//        for (Sweet currentSweet : sweets) {
//            allPrice += currentSweet.price * currentSweet.weight;
//        }
//        return allPrice;
//    }
//
//    private static String getAllNames(Sweet[] sweets) {
//
//        String allNames = " ";
//
//        for (Sweet currentSweet : sweets) {
//            allNames += currentSweet.name + " ";
//        }
//        return allNames;
//    }
/////////////////////////////Преобразовать строку в integer
//    String[]str = "1;2;3".split(";");
//    List<Integer> i = new ArrayList<>();
//    for(String val: str){
//        i.add(Integer.valueOf(val));
//    }

}
