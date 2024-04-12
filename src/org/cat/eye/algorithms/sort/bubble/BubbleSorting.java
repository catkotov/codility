package org.cat.eye.algorithms.sort.bubble;

import java.util.Arrays;

/**
 * Пузырьковая сортировка
 */
public class BubbleSorting {

    public void sorting(int[] input) {

        boolean swapped = true;

        int idx = input.length - 1;

        while (swapped) {
            swapped = false;
            for (int i = 0; i < idx; i++) {
                if (input[i] > input[i + 1]) {
                    int tmp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = tmp;
                    swapped = true;
                }
            }
            idx--;
        }
    }

    public static void main(String[] argv) {

        BubbleSorting bubbleSorting = new BubbleSorting();
        int[] forSorting = {2,0,5,1,7,3,1,3,9,7,8};
        System.out.println(Arrays.toString(forSorting));
        bubbleSorting.sorting(forSorting);
        System.out.println(Arrays.toString(forSorting));
    }

}
