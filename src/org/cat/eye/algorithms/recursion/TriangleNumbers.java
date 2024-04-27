package org.cat.eye.algorithms.recursion;

public class TriangleNumbers {

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

    public static void main(String[] args) {
        int n = 6;
        System.out.println("Cycle Triangle number of N: " + n + " will be " + TriangleNumbers.triangleNumberWithoutRecursion(n));
        System.out.println("Recursion Triangle number of N: " + n + " will be " + TriangleNumbers.triangleNumberWithRecursion(n));
    }

}
