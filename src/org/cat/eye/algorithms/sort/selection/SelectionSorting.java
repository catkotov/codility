package org.cat.eye.algorithms.sort.selection;

import java.util.Arrays;

/**
 * Сортировка выбором
 */
public class SelectionSorting {

    public void sorting(int[] input) {

        for (int j = 0; j < input.length - 1; j++) {

            int minIdx = j;

            for (int i = j + 1; i < input.length; i++) {
                if (input[i] < input[minIdx]) {
                    minIdx = i;
                }
            }

            if (minIdx != j) {
                int tmp = input[j];
                input[j] = input[minIdx];
                input[minIdx] = tmp;
            }
        }
    }

    public static void main(String[] argv) {

        SelectionSorting selectionSorting = new SelectionSorting();
        int[] forSorting = {2,0,5,1,7,3,1,3,9,7,8};
        System.out.println(Arrays.toString(forSorting));
        selectionSorting.sorting(forSorting);
        System.out.println(Arrays.toString(forSorting));
    }

}
