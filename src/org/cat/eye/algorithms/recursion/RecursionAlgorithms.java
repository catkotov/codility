package org.cat.eye.algorithms.recursion;

public class RecursionAlgorithms {

    public static int triangleNumberWithoutRecursion(int n) {
        int triangle = 0;

        while (n > 0) {
            triangle += n;
            n--;
        }

        return triangle;
    }

    public static int triangleNumberWithRecursion(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + triangleNumberWithRecursion(n - 1);
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Cycle Triangle number of N: " + n + " will be " + RecursionAlgorithms.triangleNumberWithoutRecursion(n));
        System.out.println("Recursion Triangle number of N: " + n + " will be " + RecursionAlgorithms.triangleNumberWithRecursion(n));

        System.out.println("Factorial " + n + "! will be " + RecursionAlgorithms.factorial(n));
    }

}
