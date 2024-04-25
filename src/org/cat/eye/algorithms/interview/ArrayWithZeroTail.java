package org.cat.eye.algorithms.interview;

import java.util.Arrays;

/**
 * Преобразовать массив вида {0,5,3,0,7,0} к виду {5,3,7,0,0,0}.
 * Переместить все нули в конец массива.
 */
public class ArrayWithZeroTail {

    public static int[] arrayReordering(int[] input) {

        int idx0 = 0;

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == 0) {
                if (input[i + 1] != 0) {
                    input[idx0] = input[i + 1];
                    input[i + 1] = 0;
                    idx0++;
                }
            }
        }

        return input;
    }

    public static void main(String[] argv) {

        int[] input = {0,0,5,3,0,0,0,7,0};

        System.out.println("Result: " + Arrays.toString(ArrayWithZeroTail.arrayReordering(input)));
    }

}
