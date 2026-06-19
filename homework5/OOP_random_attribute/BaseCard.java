package OOP_random_attribute;

import java.math.BigDecimal;

public class BaseCard {
  private final String cardNum;
  private final String bank;
  private final String username;
  private final String password;
  private final String email;
  private final BigDecimal balance;
  private final BigDecimal minDeposit;
  private final BigDecimal maxWithdraw;


  public BaseCard(CardBuilder builder) {
    this.cardNum = builder.cardNum;
    this.bank = builder.bank;
    this.username = builder.username;
    this.password = builder.password;
    this.email = builder.email;
    this.balance = builder.balance;
    this.minDeposit = builder.minDeposit;
    this.maxWithdraw = builder.maxWithdraw;
  }
  




  public String getCardNum() {
    return cardNum;
  }





  public String getBank() {
    return bank;
  }





  public String getUsername() {
    return username;
  }





  public String getPassword() {
    return password;
  }





  public String getEmail() {
    return email;
  }





  public BigDecimal getBalance() {
    return balance;
  }





  public BigDecimal getMinDeposit() {
    return minDeposit;
  }





  public BigDecimal getMaxWithdraw() {
    return maxWithdraw;
  }





  public static class CardBuilder {
    private String cardNum;
    private String bank;
    private String username;
    private String password;
    private String email;
    private BigDecimal balance;
    private BigDecimal minDeposit;
    private BigDecimal maxWithdraw;


    public CardBuilder buildcardNum(String cardNum) {
      this.cardNum = cardNum;
      return this;
    }

    public CardBuilder buildbank(String bank) {
      this.bank = bank;
      return this;
    }

    public CardBuilder buildusername(String username) {
      this.username = username;
      return this;
    }

    public CardBuilder buildpassword(String password) {
      this.password = password;
      return this;
    }

    public CardBuilder buildemail(String email) {
      this.email = email;
      return this;
    }

    public CardBuilder buildbalance(BigDecimal balance) {
      this.balance = balance;
      return this;
    }

    public CardBuilder buildminDeposit(BigDecimal minDeposit) {
      this.minDeposit = minDeposit;
      return this;
    }

    public CardBuilder buildmaxWithdraw(BigDecimal maxWithdraw) {
      this.maxWithdraw = maxWithdraw;
      return this;
    }

    public BaseCard build() {
      return new BaseCard(this);
    }


  }
  
}
