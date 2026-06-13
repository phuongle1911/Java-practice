package homework5.OOP_v2.models;

import java.math.BigDecimal;

public class ANZCard extends BaseCard {
  private static final int MIN_DEPOSIT = 10;
  private static final int MAX_WITHDRAW = 1000;
  private static final String BANK = "ANZ";

  
  public ANZCard(String cardNum, BigDecimal balance, String username) {
    super(cardNum, BANK, balance, new BigDecimal(MIN_DEPOSIT), new BigDecimal(MAX_WITHDRAW), username);
  }
  

}
