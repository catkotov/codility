package org.cat.eye.yandex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */
public class ATM {

    private final Map<Integer, Integer> banknoteMap;

    private Integer balance = 0;

    public ATM(Map<Integer, Integer> initial) {
        banknoteMap = initial;
        initial.keySet().stream().map(key -> key * initial.get(key)).forEach(s -> balance += s);
    }

    public Map<Integer, Integer> getSum(int required) throws Exception {

        if (required > balance)
            throw new Exception();

        Map<Integer, Integer> result = new HashMap<>();

        List<Integer> nominals = banknoteMap.keySet().stream().sorted((a, b) -> b - a).toList();

        for (Integer nom : nominals) {

            if (required >= nom) {

                Integer intPart = required / nom;
                int ost = required % nom;

                if (banknoteMap.get(nom) <= intPart) {
                    result.put(nom, banknoteMap.get(nom));
                    intPart = intPart - banknoteMap.get(nom);
                    required = intPart * nom + ost;
                } else {
                    result.put(nom, intPart);
                    required = ost;
                }

                if (required == 0)
                    break;
            }
        }

        if (required != 0)
            throw new Exception("");

        balanceUpdate(result, banknoteMap);

        return result;
    }

    public void balanceUpdate(Map<Integer, Integer> res, Map<Integer, Integer> bank) {

        Set<Integer> nom = res.keySet();

        bank.keySet().stream().filter(nom::contains).forEach(key -> {
                    Integer ost = banknoteMap.get(key) - res.get(key);
                    banknoteMap.put(key, ost);
                }
        );
    }

}
