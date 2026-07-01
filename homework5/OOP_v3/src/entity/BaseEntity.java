package entity;

import enums.EntityEnums;
import java.util.ArrayList;

public interface BaseEntity {

  public String formatData();

  public BaseEntity mapStringToObject(String data);

  // public static BaseEntity createService(EntityEnums entity) {
  //   switch(entity) {
  //     case ANZCard:
  //       return new ANZCard();
  //     case NABCard:
  //       return new NABCard();
  //     case CMWCard:
  //       return new CMWCard();
  //     case User:
  //       return new User();
  //     default:
  //       return new Transaction();
  //   }
  // }
  
} 
