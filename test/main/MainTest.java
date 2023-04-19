package main;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;


public class MainTest {


    @Test
    public void testExitCommand() {
        String input = "Exit";
        String expectedOutput = "";
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }

    @Test
    public void testUnknownCommand() {
        String input = "Invalid";
        input = HelperFunctions.addExitCommand(input);
        String expectedOutput = "Unknown input.\n";
        expectedOutput = HelperFunctions.addWelcomeAndGoodbyeMessage(expectedOutput);
        assertEquals(expectedOutput, HelperFunctions.runVendingMachine(input));
    }
    

    

    }

