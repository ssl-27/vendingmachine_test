package main;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class RejectCoinTest {

	@Test
    public void testInsert1CoinAndReject() {
        String input = "Insert 1\nReject";
        String expectedOutput = "Inserted a $1 coin. $1 in total.\nRejected $1. $1 in total.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
    public void testInsert2CoinsAndReject() {
        String input = "Insert 1\nInsert 2\nReject";
        String expectedOutput = "Inserted a $1 coin. $1 in total.\nInserted a $2 coin. $3 in total.\nRejected $1, $2. $3 in total.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
    public void testInsert3CoinsAndReject() {
        String input = "Insert 10\nInsert 2\nInsert 1\nReject";
        String expectedOutput = "Inserted a $10 coin. $10 in total.\nInserted a $2 coin. $12 in total.\nInserted a $1 coin. $13 in total.\nRejected $1, $2, $10. $13 in total.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
    public void testInsert3CoinsInOrderAndReject() {
        String input = "Insert 1\nInsert 2\nInsert 10\nReject";
        String expectedOutput = "Inserted a $1 coin. $1 in total.\nInserted a $2 coin. $3 in total.\nInserted a $10 coin. $13 in total.\nRejected $1, $2, $10. $13 in total.\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	@Test
    public void MultipleReject() {
        String input = "Reject\nReject";
        String expectedOutput = "Rejected no coin!\nRejected no coin!\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
    public void MultipleRejectWithInsert() {
        String input = "Insert 10\nInsert 2\nInsert 1\nReject\nReject";
        String expectedOutput = "Inserted a $10 coin. $10 in total.\nInserted a $2 coin. $12 in total.\nInserted a $1 coin. $13 in total.\nRejected $1, $2, $10. $13 in total.\nRejected no coin!\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
	@Test
    public void MultipleRejectWithInsertTwoTimes() {
        String input = "Insert 10\nInsert 2\nInsert 1\nReject\nReject\nInsert 10\nInsert 2\nInsert 1\nReject\nReject";
        String expectedOutput = "Inserted a $10 coin. $10 in total.\nInserted a $2 coin. $12 in total.\nInserted a $1 coin. $13 in total.\nRejected $1, $2, $10. $13 in total.\nRejected no coin!\nInserted a $10 coin. $10 in total.\nInserted a $2 coin. $12 in total.\nInserted a $1 coin. $13 in total.\nRejected $1, $2, $10. $13 in total.\nRejected no coin!\n";
        input = HelperFunctions.addExitCommand(input);
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
	
}
