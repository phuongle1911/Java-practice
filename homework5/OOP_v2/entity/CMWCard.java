package homework5.OOP_v2.models;

import java.math.BigDecimal;

public class CMWCard extends BaseCard {
  private static final int MIN_DEPOSIT = 5;
  private static final int MAX_WITHDRAW = 3000;
  private static final String BANK = "CMW";

  
  public CMWCard() {
    super.minDeposit = new BigDecimal(MIN_DEPOSIT);
    super.maxWithdraw = new BigDecimal(MAX_WITHDRAW);
    super.bank = BANK;
  }
  

}
