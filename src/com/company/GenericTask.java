//Необходимо используя generics сделать:
//Класс в котором будет метод printArray
//выводящий в консоль содержимое массива вне зависимости что в нем хранится
//( примеры для вывода int , double, String)
//Добавить метод возвращаемый максимальное значение из массива
//вне зависимости что в нем хранится ( int или double)

package com.company;

public class GenericTask {

    public static <E> void printArray(E[] elements) {
        for (E element : elements) {
            System.out.println(element);
        }
    }

    public static void main(String args[]) {
        String[] stringArray = {"say", "my", "name"};
        Double[] doubleArray = {8.9, 6.3, 0.2, 00.1};
        Integer[] intArray = {25, 987, 2, 21, 897};
        Character[] charArray = {'C', 'h', 'a', 'r', 'A', 'r', 'r'};

        System.out.println("Printing String Array");
        printArray(stringArray);
        System.out.println("Printing Double Array");
        printArray(doubleArray);
        System.out.println("Printing Integer Array");
        printArray(intArray);
        System.out.println("Printing Character Array");
        printArray(charArray);

    }

}

