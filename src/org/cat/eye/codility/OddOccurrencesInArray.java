package org.cat.eye.codility;

public class OddOccurrencesInArray {

    public static int solution(int[] A) {
        int result = 0;

        for (var i : A) {
            result = result ^ i;
        }
        return result;
    }

    public static void main(String[] argv) {

        int[] tst = {22, 5, 4, 22, 4, 11, 33, 22, 33, 11, 22};

        System.out.println("result: " + solution(tst));
    }
}
