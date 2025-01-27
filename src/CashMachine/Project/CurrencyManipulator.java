package CashMachine.Project;



import CashMachine.Project.exception.NotMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String CurrencyCode;
    private Map <Integer, Integer> Denomination;

    public String getCurrencyCode() {
        return CurrencyCode;
    }

    public CurrencyManipulator(String currencyCode) {
        this.CurrencyCode = CurrencyCode;
        this.Denomination = new TreeMap <> ();
    }
    public void add (int denomination, int count) {
        if (Denomination.containsKey(denomination)){
            Denomination.put(denomination, Denomination.get(denomination)+count);
        }
        else {
            Denomination.put(denomination, count);
        }
    }
    public int get () {
        int totalAmount = 0;
        for (Integer denomination : Denomination.keySet()) {
            totalAmount += denomination * Denomination.get(denomination);
        }
        return totalAmount;
    }
    public boolean hasMoney() {
        return !Denomination.isEmpty();
    }
    public boolean isAmountAvailable(int expectedAmount) {
        return expectedAmount <= get();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotMoneyException, NotMoneyException {
        int sum = expectedAmount;
        HashMap<Integer, Integer> copyDenominations = new HashMap<>(Denomination);

        ArrayList<Integer> keys = new ArrayList<>(this.Denomination.keySet());

        Collections.sort(keys);
        Collections.reverse(keys);

        TreeMap<Integer, Integer> resultMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (Integer denomination : keys) {
            final int key = denomination;
            int value = copyDenominations.get(key);
            while (true) {
                if (sum < key || value == 0) {
                    copyDenominations.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (resultMap.containsKey(key))
                    resultMap.put(key, resultMap.get(key) + 1);
                else
                    resultMap.put(key, 1);
            }
        }

        if (sum > 0)
            throw new CashMachine.Project.exception.NotMoneyException();
        else {
            this.Denomination.clear();
            this.Denomination.putAll(copyDenominations);
        }
        return resultMap;
    }
}
