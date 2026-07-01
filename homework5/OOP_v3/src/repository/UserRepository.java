package repository;

import java.time.LocalDate;
import java.util.ArrayList;
import entity.User;
import repository.FileHandling;

public class UserRepository implements BaseRepository {
  private String userFile = "users.txt";
  FileHandling<User> userFileHandler = new FileHandling<User>(userFile);

  // private String[] users() {
  //   // FileHandling<User> userFileHandler = new FileHandling<User>(userFile);
  //   userFileHandler.filePath = userFile;
  //   String[] userArr = userFileHandler.fileRead(); 
  //   return userArr; 
  // };

  public void create(String firstName, String lastName, LocalDate dob, String username, String password) {
    ArrayList<User> userList = new ArrayList<User>();
    userList.add(new User(firstName, lastName, dob, username, password));
    userFileHandler.saveToFile(userList,true);
  };

  public ArrayList<String> readAll() {
    return userFileHandler.readFiletoArrayList(); 
  }

  public String getByName(String searchText) {
    ArrayList<String> userList = new ArrayList<String>();
    userList = readAll();
    for (int i=0; i<userList.size(); i++) {
      String line = userList.get(i).toString().toLowerCase();
      String[] parts = line.split(";");
      String readName = parts[0].trim()+parts[1].trim();
      if (readName.contains(searchText.toLowerCase())) {
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
