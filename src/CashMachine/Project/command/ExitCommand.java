package CashMachine.Project.command;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        CashMachine.Project.command.ConsoleHelper.WriteMessage("Do you really want to exit? <y,n>");
        String s = CashMachine.Project.command.ConsoleHelper.ReadString();
        if (s!=null&& "y".equals(s.toLowerCase()));
        CashMachine.Project.command.ConsoleHelper.WriteMessage("Thank you for visiting cash machine. Good luck.");

    }
}
