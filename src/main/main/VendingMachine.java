package main;

import java.util.ArrayList;

public class VendingMachine {
  // ArrayList of Integers represents inserted coins in Coin Slot
  private ArrayList<Integer> insertedCoins;
	
  // ArrayList of Product represents inventories of products
  private ArrayList<Product> products;

  public VendingMachine() {
    insertedCoins = new ArrayList<Integer>();
    products = new ArrayList<Product>();
  }

  public void addProduct(Product p) {
    products.add(p);
  }
	
  public void insertCoin(Integer c) {
    insertedCoins.add(c);
  }	
  
  public int getCoins(){ //sum of coins
	  int c = 0;
	  for (int i = 0; i < insertedCoins.size(); i++) {
		  c += insertedCoins.get(i);
	  }
	  return c;
  }
  
  public int getIndividualCoins(int index) {
	  int response = 0;
	  response = insertedCoins.get(index);
	  return response;
  }
  
  public ArrayList<Integer> getCoinsList() { //get the array list of coins
	return insertedCoins;  
  }

  public void setEmptyCoinsList(){
	  insertedCoins = new ArrayList<Integer>();
	  
  }
  
  public ArrayList<Product> getProductList(){
	  return products;
  }
  
  /* You may add other properties and methods */
}
