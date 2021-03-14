package com.waterhydroxyl.paixu;

public class maopao {
    public static void main(String[] args) {
        int[] array = {2, -2, 5, 3, 7};
        insert(array);
        print(array);
    }
    public  static void insert(int[] array) {
        int minIndex = 0;
        int minValue = array[minIndex];
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j <array.length ; j++) {
                if (array[j] < minValue) {
                    minIndex = j;
                    minValue = array[j];
                }
            }
            if (minValue != array[i]) {
                array[minIndex] = array[i];
                array[i] = minValue;
            }
        }
    }

    public static void paixu(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void print(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}
