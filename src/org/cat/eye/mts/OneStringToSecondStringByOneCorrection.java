package org.cat.eye.mts;

/**
 * Проверить можно ли получить одну строку из второй,
 * применив не более одного исправления (вставка/удаление или замена символа)
 */
public class OneStringToSecondStringByOneCorrection {

    public static boolean check(String one, String second) {

        if (one == null || second == null)
            return false;

        if (Math.abs(one.length() - second.length()) > 1)
            return false;

        if (one.length() >= second.length())
            return checkPrepared(one, second);
        else {
            return checkPrepared(second, one);
        }
    }

    private static boolean checkPrepared(String one, String second) {

        if (one.isEmpty() || second.isEmpty())
            return true;

        int correctionCount = 0;

        if (one.length() == second.length()) {
            for (int i = 0; i < one.length(); i++) {
                if (one.charAt(i) != second.charAt(i)) {
                    correctionCount ++;
                    if (correctionCount > 1) {
                        return false;
                    }
                }
            }
        } else {
            for (int i = 0, j = 0; i < one.length(); i++) {
                if (one.charAt(i) != second.charAt(j)) {
                    correctionCount++;
                    if (correctionCount > 1) {
                        return false;
                    }
                } else {
                    if (++j == second.length())
                        return true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String one = "s12w";
        String second = "s12";

        System.out.println(check(one, second));
    }

}
