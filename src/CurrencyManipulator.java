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
}
