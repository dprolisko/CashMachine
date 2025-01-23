import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void WriteMessage (String message){
        System.out.println(message);
    }
    public static String ReadString (){
        try {
            String s = bufferedReader.readLine();
        }
        catch (IOException Ignored) {

        }
        return null;

    }
    public static String askCurrencyCode (){
        while (true){
            ConsoleHelper.WriteMessage("Пожалуйста, выберите код валюты, например, USD");
            String valut = ConsoleHelper.ReadString();
            if (valut==null || valut.length() != 3){
                ConsoleHelper.WriteMessage("Пожалуйста, укажите правильные данные");
                continue;
            }
            return valut.toUpperCase();

        }
    }
    public static String[] getValidTwoDigits(String CurrencyCode){
        while (true){
            ConsoleHelper.WriteMessage(String.format("Пожалуйста, введите число номинации и количество валюты. Например, 10 BYN"));
            String s = ConsoleHelper.ReadString();
            String [] array = null;
            if (s==null || (array = s.split(" ")).length!=2){
                ConsoleHelper.WriteMessage("Пожалуйста, введите правильные данные.");

            }
            else {
                try{
                   if(Integer.parseInt(array[0])<=0 || Integer.parseInt(array[1])<=0){
                       ConsoleHelper.WriteMessage("Пожалуйста, укажите правильные данные");

                   }
                }
                catch (NumberFormatException e){
                    ConsoleHelper.WriteMessage("Пожалуйста, укажите правильные данные");

                }
                return array;
            }
        }
    }

}
