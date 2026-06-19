package OOP_random_attribute;

import java.math.BigDecimal;


// set up random attributes (customised) in class using builder design, the other attributes are not selected will be null
// final code: Basecard c = ...

public class main {
  public static void main(String[] args) {
    BaseCard newCard = new BaseCard.CardBuilder()
    .buildbalance(new BigDecimal(20))
    .buildcardNum("123 124")
    .build();
    // use newCard as needed

    System.out.println(newCard.getCardNum());
    System.out.println(newCard.getBalance());
  }
}
