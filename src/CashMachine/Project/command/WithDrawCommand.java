package CashMachine.Project.command;

import CashMachine.Project.exception.NotMoneyException;

import java.util.Map;

public class WithDrawCommand implements Command {
    @Override
    public void execute() {
        CashMachine.Project.command.ConsoleHelper.WriteMessage("Withdrawing...");

        String currencyCode = CashMachine.Project.command.ConsoleHelper.askCurrencyCode();
        CashMachine.Project.command.CurrencyManipulator manipulator = CashMachine.Project.command.CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true) {
            try {
                CashMachine.Project.command.ConsoleHelper.WriteMessage("Please specify integer amount for withdrawing.");
                String s = CashMachine.Project.command.ConsoleHelper.ReadString();
                if (s == null) {
                    CashMachine.Project.command.ConsoleHelper.WriteMessage("Please specify valid positive integer amount for withdrawing.");
                } else {
                    try {
                        int amount = Integer.parseInt(s);
                        boolean isAmountAvailable = manipulator.isAmountAvailable(amount);
                        if (isAmountAvailable) {
                            Map<Integer, Integer> denominations = manipulator.withdrawAmount(amount);
                            for (Integer item : denominations.keySet()) {
                                CashMachine.Project.command.ConsoleHelper.WriteMessage("\t" + item + " - " + denominations.get(item));
                            }

                            CashMachine.Project.command.ConsoleHelper.WriteMessage(String.format("%d %s was withdrawn successfully", amount, currencyCode));
                            break;
                        } else {
                            CashMachine.Project.command.ConsoleHelper.WriteMessage("Not enough money on your account, please try again");
                        }
                    } catch (NumberFormatException e) {
                        CashMachine.Project.command.ConsoleHelper.WriteMessage("Please specify valid positive integer amount for withdrawing.");
                    }
                }
            } catch (NotMoneyException e) {
                CashMachine.Project.command.ConsoleHelper.WriteMessage("Exact amount is not available");
            }
        }
    }
}

