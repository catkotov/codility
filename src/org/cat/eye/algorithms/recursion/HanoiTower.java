package org.cat.eye.algorithms.recursion;

public class HanoiTower {

    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }

    public static void towerOfHanoi(char from, char to, char other, int n) {
        // рекурсивно перемещаем верхние n-1 дисков с колышка колышка 'from' на колышек 'other'
        if (n > 1)
            towerOfHanoi(from, other, to, n - 1);
        System.out.println("Disk " + n + " from " + from + " to " + to);
        // рекурсивно перемещаем верхние n-1 дисков с колышка колышка 'other' на колышек 'to'
        if (n > 1)
            towerOfHanoi(other, to, from, n - 1);
    }

    public static void main(String[] args) {
        doTowers(4, 'A', 'B', 'C');
        System.out.println();
        towerOfHanoi('A', 'C', 'B', 4);
    }

}
