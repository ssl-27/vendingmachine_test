package main;


import java.util.ArrayList;

public class CmdPurchase implements Command{
	public int findItemIndex(VendingMachine v, String cmdPart) {
		int index = 0;
		for (int i =  0; i < v.getProductList().size(); i++) {
			if (v.getProductList().get(i).getName().equals(cmdPart)) {
				index = i;
			}
		}
		return index;
	}
	
	public String execute(VendingMachine v, String cmdPart) {
		String response = "";
		String option = cmdPart;
		int change, change1, change2, change5, change10;
		ArrayList <Integer> changeList = new ArrayList<Integer>();
		int index = findItemIndex(v, option);
		Product targetProduct = v.getProductList().get(index);
		if (v.getCoins() < targetProduct.getPrice()) {
			response = "Not enough credits to buy " + targetProduct.getName() + "! Inserted $" + v.getCoins() + " but needs $" + targetProduct.getPrice() + ".";
		}
		else if (targetProduct.getQuantity() == 0) {
			response = targetProduct.getName() + " is out of stock!";
		}
		else {
			change = v.getCoins() - targetProduct.getPrice();
			change10 = change / 10;
			change5 = (change % 10) / 5;
			change2 = ((change % 10) % 5) / 2;
			change1 = ((change % 10) % 5) % 2;
			for (int i = 0; i < change1; i++ ) {
				changeList.add(1);
			}
			for (int i = 0; i < change2; i++ ) {
				changeList.add(2);
			}
			for (int i = 0; i < change5; i++ ) {
				changeList.add(5);
			}
			for (int i = 0; i < change10; i++ ) {
				changeList.add(10);
			}
			response = "Dropped " + targetProduct.getName() + ". Paid$" + v.getCoins();
			if (changeList.size() > 0) {
				response += "Your change: ";
				for (int i = 0 ; i < changeList.size(); i++) {
					if (i == changeList.size() - 1) {
						response += "$" + changeList.get(i) + ".";
					}
					else {
						response += "$" + changeList.get(i) + ", ";
	 				}
				}
			}
			else {
				response += "No change.";
			}

			targetProduct.setReduceQuantity();
			v.setEmptyCoinsList();
			
		}
		return response;
	}


}
