package main;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class InsertCoinTest {

	@Test
    public void testInsert1Coin() {
        String input = "Insert 1";
        String expectedOutput = "Inserted a $1 coin. $1 in total.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
    public void testInsert2Coins() {
        String input = "Insert 1\nInsert 2";
        String expectedOutput = "Inserted a $1 coin. $1 in total.\nInserted a $2 coin. $3 in total.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
    public void testInsert3Coins() {
        String input = "Insert 10\nInsert 2\nInsert 1";
        String expectedOutput = "Inserted a $10 coin. $10 in total.\nInserted a $2 coin. $12 in total.\nInserted a $1 coin. $13 in total.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	

}
