package homework5.OOP_v2.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataValidation {

  public static LocalDate validateDate(String inputDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     
    try {
      LocalDate date = LocalDate.parse(inputDate, formatter);
      return date;
    } catch (DateTimeParseException e) {
      System.err.println("Invalid date format! Date must be in format dd/MM/yyyy");
      return null;
    }
  }
}
