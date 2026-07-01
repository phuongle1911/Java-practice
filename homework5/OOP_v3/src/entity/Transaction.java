package entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import enums.TransactionTypeEnums;
import lombok.Getter;
import lombok.Setter;;

@Getter
@Setter
public class Transaction implements BaseEntity {
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

  // public void transDescription() {
  //   System.out.println("Card number: " + cardNum + "; Transaction: " + type + " " + amount + " at " + transTime);
  // }

  public String formatData() {
    return (this.cardNum + ";" + this.type + ";" + this.amount + ";" + this.transTime);
  }
}





