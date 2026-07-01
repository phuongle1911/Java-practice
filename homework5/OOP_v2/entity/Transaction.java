package homework5.OOP_v2.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import homework5.OOP_v2.enums.TransactionTypeEnums;

public class Transaction {
  private String cardNum;
  private LocalDateTime transTime;
  private TransactionTypeEnums type;
  private BigDecimal amount;

  public Transaction(String cardNum, LocalDateTime transTime, TransactionTypeEnums type,
      BigDecimal amount) {
    this.cardNum = cardNum;
    this.transTime = transTime;
    this.type = type;
    this.amount = amount;
  }

  public String getCardNum() {
    return cardNum;
  }

  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }

  public LocalDateTime getTransTime() {
    return transTime;
  }

  public void setTransTime(LocalDateTime transTime) {
    this.transTime = transTime;
  }

  public TransactionTypeEnums getType() {
    return type;
  }

  public void setType(TransactionTypeEnums type) {
    this.type = type;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  // public void transDescription() {
  //   System.out.println("Card number: " + cardNum + "; Transaction: " + type + " " + amount + " at " + transTime);
  // }

  // public String formatTransInfo() {
  //   return (cardNum + ";" + type + ";" + amount + ";" + transTime + "\n")
  // }
}





