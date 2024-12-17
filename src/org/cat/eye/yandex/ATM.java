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
    // текущий набор банкнот в банкомате (key -> номинал банкноты, value -> количество банкнот)
    private final Map<Integer, Integer> banknoteMap;
    // текущий баланс банкомата
    private Integer balance = 0;

    public ATM(Map<Integer, Integer> initial) {
        banknoteMap = initial;
        initial.keySet().stream().map(key -> key * initial.get(key)).forEach(s -> balance += s);
    }

    public Map<Integer, Integer> getSum(int required) throws Exception {

        // в банкомате нет требуемой суммы
        if (required > balance)
            throw new Exception("Банкомат не может выдать запрошенную сумму");

        // здесь будем хранить набор банкнот, подготовленных к выдаче клиенту
        Map<Integer, Integer> result = new HashMap<>();
        // отсортируем банкноты в банкомате по убыванию
        List<Integer> nominals = banknoteMap.keySet().stream().sorted((a, b) -> b - a).toList();
        // для каждого номинала банкнот выполним следующее ...
        for (Integer nom : nominals) {
            // если требуемая сумма больше текущего номинала, то пробуем набрать ее из банкнот текущего номинала
            if (required >= nom) {
                // требуемое кол-во банкнот
                Integer intPart = required / nom;
                // остаток от деления
                int ost = required % nom;

                if (banknoteMap.get(nom) <= intPart) {            // если кол-во требуемых банкнот не достаточно
                    // помещаем в результат все доступные банкноты
                    result.put(nom, banknoteMap.get(nom));
                    // высчитываем кол-во недостающих банкнот
                    intPart = intPart - banknoteMap.get(nom);
                    // обновляем требуемую сумму
                    required = intPart * nom + ost;
                } else {                                          // при условии достаточности требуемых банкнот
                    // помещаем в результат необходимое кол-во банкнот
                    result.put(nom, intPart);
                    // обновляем требуемую сумму
                    required = ost;
                }
                // выходим из цикла если набрали требуемую сумму
                if (required == 0)
                    break;
            }
        }
        // если не получилось набрать требуемую сумму сообщаем об этом клиенту
        if (required != 0)
            throw new Exception("Банкомат не может выдать запрошенную сумму");
        // обновляем баланс банкомата
        balanceUpdate(result, banknoteMap);

        return result;
    }

    /**
     * Обновление баланса банкомата
     *
     * @param res - банкноты и их кол-во к выдаче клиенту
     * @param bank - текущий набор банкнот в банкомате
     */
    private void balanceUpdate(Map<Integer, Integer> res, Map<Integer, Integer> bank) {
        // номинал каких банкнот будем выдавать?
        Set<Integer> nom = res.keySet();
        // для каждого номинала банкнот к выдаче клиенту обновляем их кол-во в банкомате
        bank.keySet().stream().filter(nom::contains).forEach(key -> {
                    Integer ost = banknoteMap.get(key) - res.get(key);
                    banknoteMap.put(key, ost);
                }
        );
    }

}
