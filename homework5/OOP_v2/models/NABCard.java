package homework5.OOP_v2.models;

import java.math.BigDecimal;

public class NABCard extends BaseCard {
  private static final int MIN_DEPOSIT = 10;
  private static final int MAX_WITHDRAW = 2000;
  private static final String BANK = "NAB";

  
  public NABCard(String cardNum, BigDecimal balance, String username) {
    super(cardNum, BANK, balance, new BigDecimal(MIN_DEPOSIT), new BigDecimal(MAX_WITHDRAW), username);
  }
}
