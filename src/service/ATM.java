package service;
import enums.Nominals;
import java.util.HashMap;
import java.util.Map;

/**
 * Банкомат.
 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 * При выдаче купюры списываются с баланса банкомата.
 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */
public class ATM {

    Map<Nominals, Integer> map = new HashMap<>();

    public Map<Nominals, Integer> refreshBalanceATM (Integer giveMoney) {
        if (giveMoney % 50 != 0) {
            System.out.println("Input another sum");
            return map;
        }
        if (getAllCashATM(map) < giveMoney) {
            System.out.println("There is no enough money");
            return map;
        }

        int ostatokMoney = giveMoney;

        for(Map.Entry<Nominals, Integer>  entry : map.entrySet()){
            Nominals nominal = entry.getKey();
            int nominalNumeric = nominal.getValue();
            int quantity = entry.getValue();

            int givenQuantity = ostatokMoney / nominalNumeric;
            if (givenQuantity < quantity) {
                ostatokMoney = ostatokMoney % nominalNumeric;
                quantity -= givenQuantity;
                map.put(nominal, quantity);
            }
        }
        return map;
    }

    public Map<Nominals, Integer> reloadATM (Integer rub_50_quantity,
                                             Integer rub_100_quantity,
                                             Integer rub_500_quantity,
                                             Integer rub_1000_quantity,
                                             Integer rub_5000_quantity){

        map.put(Nominals.RUB_50, rub_50_quantity);
        map.put(Nominals.RUB_100, rub_100_quantity);
        map.put(Nominals.RUB_500, rub_500_quantity);
        map.put(Nominals.RUB_1000, rub_1000_quantity);
        map.put(Nominals.RUB_5000, rub_5000_quantity);
        return map;
    }

    public int getAllCashATM (Map<Nominals, Integer> map){
        int sum = 0;
        for(Map.Entry<Nominals, Integer>  entry : map.entrySet()){
            Nominals nominal = entry.getKey();
            int nominalNumeric = nominal.getValue();
            int quantity = entry.getValue();
            sum += quantity*nominalNumeric;
        }
        return sum;
    }

}


