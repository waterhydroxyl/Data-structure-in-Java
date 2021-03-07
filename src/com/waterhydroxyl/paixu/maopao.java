package com.waterhydroxyl.paixu;

public class maopao {
    public static void main(String[] args) {
        int[] array = {2, -2, 5, 3, 7};
        paixu(array);
        print(array);
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
