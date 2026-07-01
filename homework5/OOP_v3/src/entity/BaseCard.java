package entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseCard implements BaseEntity {
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
  

  // public void showCardInfo() {
  //   System.out.println("Your balance in " + cardNum + " on " + bank + " bank is " + String.format("%.2f", balance));
  // }
  @Override
  public String formatData() {
    String cardDetail = this.cardNum + ";" + this.bank + ";" + this.balance + ";" + this.minDeposit + ";" + this.maxWithdraw + ";" + this.username + "\n";
    return cardDetail;
  }


}
