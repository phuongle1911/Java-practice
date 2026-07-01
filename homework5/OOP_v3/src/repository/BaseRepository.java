package repository;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BaseRepository {

  // public void save();
  // public void load();


  public LocalDate formatStringToDate(String dateData) {
    try {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
      LocalDate date = LocalDate.parse(dateData, formatter);
      return date;
    } catch(Exception err) {
      System.err.println("Incorrect date format! Must be in format dd/MM/yyyy");
      return null;
    }
  }

  
}
