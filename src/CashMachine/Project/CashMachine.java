package CashMachine.Project;


import CashMachine.Project.Operation;

import java.util.Locale;

public class CashMachine {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        try{
            Operation operation;
            do{
                operation= ConsoleHelper.askOperation();
                CommandExecuter.execute(operation);



            }
            while (operation!= Operation.EXIT);


        }
        catch (InterruptOperationException sds){
            ConsoleHelper.WriteMessage("Terminated");
        }

    }}