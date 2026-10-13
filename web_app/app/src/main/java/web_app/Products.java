package main.java.web_app;

public class Products {
  private int id;
  private String name;
  private double price;
  private String branch;
  
  public Products(int id, String name, double price, String branch) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.branch = branch;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getPrice() {
    return price;
  }
  public void setPrice(double price) {
    this.price = price;
  }
  public String getBranch() {
    return branch;
  }
  public void setBranch(String branch) {
    this.branch = branch;
  }



  
}
