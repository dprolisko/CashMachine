import java.util.Map;
import java.util.TreeMap;

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
}
