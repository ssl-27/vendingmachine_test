package main;

public class Product {

  private String name;
  private int price;
  private int quantity;

  public Product(String name, int price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }
  
  public int getPrice() {
	  return price;
  }
  
  public String getName() {
	  return name;
  }
  
  public int getQuantity () {
	  return quantity;
  }
  
  public void setReduceQuantity() {
	  quantity -= 1;
  }
	
  /* You may add other properties and methods */
}