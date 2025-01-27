package CashMachine.Project.command;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        CashMachine.Project.command.ConsoleHelper.WriteMessage("Information");
        for (CashMachine.Project.command.CurrencyManipulator i: CashMachine.Project.command.CurrencyManipulatorFactory.getAll()){
            if (i.hasMoney()){
                boolean money = true;
                CashMachine.Project.command.ConsoleHelper.WriteMessage(("\t" + i.getCurrencyCode() + " - " + i.get()));
            }


        }
        if (true){
            CashMachine.Project.command.ConsoleHelper.WriteMessage("no money");
        }

    }
}
