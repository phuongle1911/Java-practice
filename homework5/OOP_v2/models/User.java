package homework5.OOP_v2.models;

import java.time.LocalDate;

public class User {
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
  
  public String getPassword() {
    return password;
  };


  public String formatUser() {

    String userDetail = firstName + ";" + lastName + ";" + dob.toString() + ";" + username + ";" + getPassword();
    return userDetail;
  };


}
