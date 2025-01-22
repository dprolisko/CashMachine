import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory {
    private static Map <String, CurrencyManipulator> hashMap = new HashMap<>();

    public CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode (String CurrencyCode) {
        CurrencyCode = CurrencyCode.toLowerCase();
        if (!hashMap.containsKey(CurrencyCode)){
            CurrencyManipulator manipulator = new CurrencyManipulator(CurrencyCode);
            hashMap.put(manipulator.getCurrencyCode(),manipulator);

        }
        return hashMap.get(CurrencyCode);

    }
}
