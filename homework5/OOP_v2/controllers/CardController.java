package homework5.OOP_v2.controllers;

import java.math.BigDecimal;

import homework5.OOP_v2.models.ANZCard;
import homework5.OOP_v2.models.BaseCard;
import homework5.OOP_v2.models.CMWCard;
import homework5.OOP_v2.models.NABCard;
import homework5.OOP_v2.utils.FileHandling;

public class CardController {
  private String cardFile = "cards.txt";
  private static final int MIN_BALANCE = 20;


  private String[] allCards() {
    FileHandling cardFileHandler = new FileHandling();
    cardFileHandler.filePath = cardFile;
    String[] cardArr = cardFileHandler.fileRead(); 
    return cardArr; 
  };

  private String searchCard(String inputCardNum) {
    for (String line:allCards()) {
      String[] parts = line.toString().split(";");
      String readCardNum = parts[0].trim();

      if (readCardNum.equals(inputCardNum.trim())) {
        return line.toString();
      }
    }
    return null;
  }

  public void updateNewInfo(String oldInfo, String newInfo) {
    FileHandling cardFileHandler = new FileHandling();
    cardFileHandler.filePath = cardFile;
    cardFileHandler.updateFileContent(oldInfo, newInfo);
  }

  
  public void registerCard(String inputCardNum, String inputBank, String username) {
    String cardDetail = null;

    if (searchCard(inputCardNum)!= null) {
        System.out.println("Card already exists!");
        return;
    }
    FileHandling cardFileHandler = new FileHandling();
    cardFileHandler.filePath = cardFile;

    switch (inputBank.toUpperCase()) {
      case "ANZ":
        ANZCard newANZCard = new ANZCard(inputCardNum,new BigDecimal(MIN_BALANCE), username);
        cardDetail = newANZCard.formatCardDetail();
        break;

      case "CMW":
        CMWCard newCMWCard = new CMWCard(inputCardNum,new BigDecimal(MIN_BALANCE), username);
        cardDetail = newCMWCard.formatCardDetail();
        break;

      case "NAB":
        NABCard newNABCard = new NABCard(inputCardNum,new BigDecimal(MIN_BALANCE), username);
        cardDetail = newNABCard.formatCardDetail();
        break;

      default:
        System.out.println("Invalid card! Card must be NAB/ANZ/CMW");
        break;
    }

    cardFileHandler.fileWrite(cardDetail);
    System.out.println("Card registered successfully!");

  };



  public deposit(String inputCardNum, BigDecimal depositAmount) {
    if (searchCard(inputCardNum) == null) {
      System.out.println("This card does not exist, please register card first!");
    } else {
      String matchedCard = searchCard(inputCardNum);
      String[] parts = matchedCard.split(";");

      if (depositAmount.compareTo(new BigDecimal(parts[3])) == ) {
        System.out.println("Deposit amount must be higher than " + parts[3]);
      } else {

      }
      BigDecimal currentBalance = new BigDecimal(parts[2]);
      BigDecimal newBalance = currentBalance.add(depositAmount);
      BaseCard newBalanceInfo = new BaseCard(parts[0], parts[1], newBalance) 
      updateNewInfo(matchedCard,newCardInfo);
    }
  };

  public withdraw() {

  }

  public viewBalance() {

  }

  public viewTrans() {

  }
}
