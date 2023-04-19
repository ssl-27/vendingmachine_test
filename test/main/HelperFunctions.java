package main;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;



public class HelperFunctions {
	static String addExitCommand(String command) {
    	String result;
    	result = command+"\nExit";
    	return result;
    }
    static String addWelcomeAndGoodbyeMessage(String message) {
    	message = "Welcome to COMP2396 Assignment 2 - Vending Machine\n" + message +"Bye";
    	return message;
    }

    static String runVendingMachine(String input) {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        InputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        Main.main(new String[]{});
        return outContent.toString().trim();

    }
}    
