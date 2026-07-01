package entity;

import java.math.BigDecimal;

public class ANZCard extends BaseCard {
  private static final int MIN_DEPOSIT = 10;
  private static final int MAX_WITHDRAW = 1000;
  private static final String BANK = "ANZ";

  
  public ANZCard() {
    super.minDeposit = new BigDecimal(MIN_DEPOSIT);
    super.maxWithdraw = new BigDecimal(MAX_WITHDRAW);
    super.bank = BANK;
  }
  

}
