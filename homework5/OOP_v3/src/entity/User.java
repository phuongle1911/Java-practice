package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


import lombok.Getter;
import lombok.Setter;
import repository.DataHandling;

@Getter
@Setter
public class User implements BaseEntity, DataHandling {
  private String firstName;
  private String lastName;
  private LocalDate dob;
  private String username;
  private String password;

  public User(String firstName, String lastName, LocalDate dob, String username, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dob = dob;
    this.username = username;
    this.password = password;
  }




  public String formatData() {

    String userDetail = this.firstName + ";" + this.lastName + ";" + this.dob.toString() + ";" + this.username + ";" + this.password;
    return userDetail;
  };

  public User mapStringToObject(String data) {
    String[] parts = data.split(";");
    DataHandling date = new DataHandling();
    return new User(parts[0], parts[1], date.formatStringToDate(parts[2]), parts[3], parts[4]);

  }

}
