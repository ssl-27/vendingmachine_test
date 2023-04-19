package main;


import java.util.ArrayList;
import java.util.Collections;

public class CmdRejectCoins implements Command{
	String response = "Rejected ";
	public String execute(VendingMachine v, String cmdPart) {
		ArrayList<Integer> coinsList = v.getCoinsList();
		Collections.sort(coinsList);
		for (int i = 0 ; i < v.getCoinsList().size(); i++) {
			if (i != v.getCoinsList().size() - 1) {
				response +="$" + coinsList.get(i) + ", ";
			}
			else {
				response +="$" + coinsList.get(i) + ". ";
			}
		}
		response += "$" + v.getCoins() + " in total.";
		v.setEmptyCoinsList();
		if (coinsList.size() == 0) {
			response = "Rejected no coin!";
		}
		return response;
	}

}
