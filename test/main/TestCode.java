package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
public class TestCode {
	
    private static final String MAIN_FILE_NAME = "Main.java";
    private static final String COMMAND_FILE_NAME = "Command.java";
    private static final String VENDINGMACHINE_FILE_NAME = "VendingMachine.java";
    private static final String PRODUCT_FILE_NAME = "Product.java";
    private static final String CMDINSERTCOIN_FILE_NAME = "CmdInsertCoin.java";
    private static final String CMDPURCHASE_FILE_NAME = "CmdPurchase.java";
    private static final String CMDREJECTCOINS_FILE_NAME = "CmdRejectCoins.java";

    public static boolean isCompleteSubmission(String folderPath) {
    	File folder = new File(folderPath);
        File[] submissionFiles = folder.listFiles();
        boolean hasMain = false;
        boolean hasCommand = false;
        boolean hasVendingMachine = false;
        boolean hasProduct = false;
        boolean hasCmdInsert = false;
        boolean hasCmdPurchase = false;
        boolean hasCmdRejectCoins = false;

        for (File file : submissionFiles) {
            if (file.getName().equalsIgnoreCase(MAIN_FILE_NAME)) {
                hasMain = true;
            } else if (file.getName().equalsIgnoreCase(COMMAND_FILE_NAME)) {
                hasCommand = true;
            } else if (file.getName().equalsIgnoreCase(VENDINGMACHINE_FILE_NAME)) {
                hasVendingMachine = true;
            } else if (file.getName().equalsIgnoreCase(PRODUCT_FILE_NAME)) {
                hasProduct = true;
            } else if (file.getName().equalsIgnoreCase(CMDINSERTCOIN_FILE_NAME)) {
                hasCmdInsert = true;
            } else if (file.getName().equalsIgnoreCase(CMDPURCHASE_FILE_NAME)) {
                hasCmdPurchase = true;
            } else if (file.getName().equalsIgnoreCase(CMDREJECTCOINS_FILE_NAME)) {
                hasCmdRejectCoins = true;
            }
            if (containsSystemOutPrintln(file) == true && (file.getName().equalsIgnoreCase(MAIN_FILE_NAME) == false) && (file.getName().equalsIgnoreCase(COMMAND_FILE_NAME) == false)) {
            	System.out.println(file.getName());
            	return false;
            }
        }

        return hasMain && hasCommand && hasCommand && hasVendingMachine && hasProduct && hasCmdInsert && hasCmdPurchase && hasCmdRejectCoins;
    }
    
    private static boolean containsSystemOutPrintln(File file) {
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            String fileContentString = new String(fileContent, StandardCharsets.UTF_8);
            return fileContentString.contains("System.out.println(");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

	@Test
	void test() {
		assertTrue(isCompleteSubmission("src/main/main"));
	}

}
