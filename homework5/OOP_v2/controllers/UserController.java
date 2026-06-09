package homework5.OOP_v2.controllers;

import homework5.OOP_v2.utils.FileHandling;

public class UserController {
  private String userFile;

  public UserController(String userFile) {
    this.userFile = userFile;
  };

  private Object[] users() {
    FileHandling userFileHandler = new FileHandling();
    userFileHandler.filePath = userFile;
    Object[] userArr = userFileHandler.fileRead(); 
    return userArr; 
  };

  public void register(String userDetail) {
    FileHandling userFileHandler = new FileHandling();
    userFileHandler.filePath = userFile;
    userFileHandler.fileWrite(userDetail);
  };

  public void showUsers() {
    for (int i=0; i<users().length; i++) {
      System.out.println(users()[i]);
    }
  }

  public String searchUser(String searchText) {
    for (int i=0; i<users().length; i++) {
      String line = users()[i].toString().toLowerCase();
      String[] parts = line.split(";");
      String readName = parts[0].trim()+parts[1].trim();
      if (readName.contains(searchText)) {
        return line;
      }
    }
    return("User not found!");
  }

  public boolean validateUser(String username, String pw) {
    for (int i=0; i<users().length; i++) {
      String line = users()[i].toString().toLowerCase();
      String[] parts = line.split(";");
      String readUsername = parts[3];
      String readPw = parts[4];
      if (readUsername.equals(username) && readPw.equals(pw)) {
        return true;
      }    
    }
    return false;
  }
}
