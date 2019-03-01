package com.minotaur.match;

/**
 * ********************************
 * Created by minotaur on 2018/8/23. *
 * ********************************
 */
public class IntegerArray {

    public static void main(String[] args) {
        int[] array = { 1, 0, 2, 1, 2, 1 };
        int[] arrayB = { 2, 2, 2, 1, 1, 0, 0 };
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
        for (int i = 0; i < arrayB.length; i++) {
            System.out.print(arrayB[i]);
        }
        arrayB = array;
        System.out.println();
        for (int i = 0; i < arrayB.length; i++) {
            System.out.print(arrayB[i]);
        }

    }
}
