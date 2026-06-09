package homework5.OOP_v2.models;


public class Card {
  private String cardNum;
  private String bank;
  private double balance;


  public Card(String cardNum, String bank, double balance) {

    this.cardNum = cardNum;
    this.bank = bank;
    this.balance = balance;
  };

  public String getCardNum() {
    return cardNum.substring(5,9);
  };



}
