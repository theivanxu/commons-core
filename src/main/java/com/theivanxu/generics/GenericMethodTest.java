package com.theivanxu.generics;

/**
 * Created by xushaonan on 2017/12/6.
 **/
public class GenericMethodTest
{
    public static void main(String[] args) {

        Integer[] integerArray = {1, 2, 3, 5, 6, 7, 8};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8};
        Character[] charArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        System.out.println("打印整型数组:");
        printArray(integerArray);

        System.out.println("打印浮点型数组:");
        printArray(doubleArray);

        System.out.println("打印字符型数组:");
        printArray(charArray);



    }

    public static <E> void printArray(E[] array){
        if (array != null){
            for (E element :
                    array) {
                System.out.printf("%s ", element);
            }
            System.out.println();
        }
    }
}
