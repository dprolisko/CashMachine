package CashMachine.Project.command;

import CashMachine.Project.Operation;

import java.util.HashMap;
import java.util.Map;

public class CommandExecuter {
    private static final Map<Operation, Command> commands = new HashMap<>();

    static {
        commands.put(Operation.DEPOSIT, new DepositCommand());
        commands.put(Operation.WITHDRAW, new WithDrawCommand());
        commands.put(Operation.INFO, new InfoCommand());
        commands.put(Operation.EXIT, new ExitCommand());
    }

    private void CommandExecutor() {}

    public static final void execute(Operation op){
        commands.get(op).execute();
    }
}
