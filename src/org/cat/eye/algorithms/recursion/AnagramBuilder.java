package org.cat.eye.algorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramBuilder {

    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a word: ");
        String input = getString();
        size = input.length();
        count = 0;

        for (int j = 0; j < size; j++) {
            arrChar[j] = input.charAt(j);
        }

        doAnagram(size);
    }

    public static void doAnagram(int newSize) {
        if (newSize == 1)
            return;

        for (int j = 0; j < newSize; j++) {
            doAnagram(newSize - 1);
            if (newSize == 2)
                displayWord();
            rotate(newSize);
        }
    }

    public static void rotate(int newSize) {
        int j;
        int position = size - newSize;
        char tmp = arrChar[position];
        for (j = position + 1; j < size; j++) {
            arrChar[j - 1] = arrChar[j];
        }
        arrChar[j - 1] = tmp;
    }

    public static String getString() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        return br.readLine();
    }

    public static void displayWord() {
        if (count < 99) System.out.print(" ");
        if (count < 9) System.out.print(" ");

        System.out.print(++count + " ");

        for (int j = 0; j < size; j++) {
            System.out.print(arrChar[j]);
        }

        System.out.print("   ");
        System.out.flush();

        if (count % 6 == 0) {
            System.out.println();
        }
    }

}
