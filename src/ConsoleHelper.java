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
}
