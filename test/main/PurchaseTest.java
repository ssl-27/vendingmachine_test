package main;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class PurchaseTest {

	@Test
    public void testInsert1CoinAndPurchase() {
        String input = "Insert 1\nBuy Pepsi";
        String expectedOutput = "Inserted a $1 coin. $1 in total.\nNot enough credits to buy Pepsi! Inserted $1 but needs $5.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
    public void testInsert3CoinsAndPurchase() {
        String input = "Insert 10\nInsert 2\nInsert 1\nBuy Pepsi";
        String expectedOutput = "Inserted a $10 coin. $10 in total.\nInserted a $2 coin. $12 in total.\nInserted a $1 coin. $13 in total.\nDropped Pepsi. Paid $13. Your change: $1, $2, $5.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
    public void testPurchaseNoChange() {
        String input = "Insert 2\nInsert 2\nBuy Cocacola";
        String expectedOutput = "Inserted a $2 coin. $2 in total.\nInserted a $2 coin. $4 in total.\nDropped Cocacola. Paid $4. No change.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
	public void testPurchaseNoInsert() {
        String input = "Buy Cocacola";
        String expectedOutput = "Not enough credits to buy Cocacola! Inserted $0 but needs $4.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
	public void testNormalPurchase() {
        String input = "Insert 2\nInsert 2\nInsert 1\nBuy Pepsi";
        String expectedOutput = "Inserted a $2 coin. $2 in total.\nInserted a $2 coin. $4 in total.\nInserted a $1 coin. $5 in total.\nDropped Pepsi. Paid $5. No change.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
    public void testPurchaseNoStock() {
        String input = "Insert 2\nInsert 2\nBuy Cocacola\nInsert 2\nInsert 2\nBuy Cocacola";
        String expectedOutput = "Inserted a $2 coin. $2 in total.\nInserted a $2 coin. $4 in total.\nDropped Cocacola. Paid $4. No change.\nInserted a $2 coin. $2 in total.\nInserted a $2 coin. $4 in total.\n Cocacola is out of stock!\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
	public void testPurchaseCoinChanger() {
        String input = "Insert 2\nInsert 2\nInsert 10\nInsert 2\nInsert 1\nInsert 5\nBuy pepsi";
        String expectedOutput = "Inserted a $2 coin. $2 in total.\nInserted a $2 coin. $4 in total.\nInserted a $10 coin. $14 in total.\nInserted a $2 coin. $16 in total.\nInserted a $1 coin. $17 in total.\nInserted a $5 coin. $22 in total.\nDropped Pepsi. Paid $22. Your change: $1, $2, $5, $10.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
}