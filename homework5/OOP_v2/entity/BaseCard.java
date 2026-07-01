package homework5.OOP_v2.models;

import java.math.BigDecimal;

public class BaseCard {
  protected String cardNum;
  protected String bank;
  protected BigDecimal balance;
  protected BigDecimal minDeposit;
  protected BigDecimal maxWithdraw;
  protected String username;

  
  // public BaseCard(String cardNum, String bank, BigDecimal balance, BigDecimal minDeposit, BigDecimal maxWithdraw, String username) {
  //   this.cardNum = cardNum;
  //   this.bank = bank;
  //   this.balance = balance;
  //   this.minDeposit = minDeposit;
  //   this.maxWithdraw = maxWithdraw;
  //   this.username = username;
  // }

  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }

  public String getCardNum() {
    return cardNum;
  }


  public String getBank() {
    return bank;
  }

  public void setBank(String bank) {
    this.bank = bank;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public BigDecimal getMinDeposit() {
    return minDeposit;
  }

  public void setMinDeposit(BigDecimal minDeposit) {
    this.minDeposit = minDeposit;
  }

  public BigDecimal getMaxWithdraw() {
    return maxWithdraw;
  }

  public void setMaxWithdraw(BigDecimal maxWithdraw) {
    this.maxWithdraw = maxWithdraw;
  }

  // public BigDecimal getMinBalance() {
  //   return minBalance;
  // }

  // public void setMinBalance(BigDecimal minBalance) {
  //   this.minBalance = minBalance;
  // }
  

  // public void showCardInfo() {
  //   System.out.println("Your balance in " + cardNum + " on " + bank + " bank is " + String.format("%.2f", balance));
  // }

  // public String formatCardDetail() {
  //   String cardDetail = cardNum + ";" + bank + ";" + balance + ";" + minDeposit + ";" + maxWithdraw + ";" + username + "\n";
  //   return cardDetail;
  // }


}
