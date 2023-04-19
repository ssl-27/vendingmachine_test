package main;


public class CmdInsertCoin implements Command {

  @Override
  public String execute(VendingMachine v, String cmdPart) {
    Integer c = Integer.valueOf(cmdPart);
    int total = 0;
    // Add the coin to Coin Slot
    v.insertCoin(c);
    // Do something
    total = v.getCoins();
    // return something. Format: "Inserted a $x coin. $y in total."
    return "Inserted a $" + c + " coin. $" + total + " in total.";
  }
  
}