package CashMachine.Project.command;

public class DepositCommand implements Command {
    @Override
    public void execute() {
        ConsoleHelper.WriteMessage("depositing");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true) {
            String[] split = ConsoleHelper.getValidTwoDigits(currencyCode);
            try {
                int denomination = Integer.parseInt(split[0]);
                int count = Integer.parseInt(split[1]);
                manipulator.add(denomination, count);
                ConsoleHelper.WriteMessage(String.format("%d %s vas deposited success", (denomination * count), currencyCode));
                break;
            } catch (NumberFormatException e) {
                ConsoleHelper.WriteMessage("please valid data");
            }
        }


    }
}
