package homework5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class userController {
  String filePath;

  userController(String filePath) {
    this.filePath = filePath;
  }

  public void register() {
    Scanner input = new Scanner(System.in);
    try (FileWriter inputWriter = new FileWriter(filePath, true)){
      System.out.println("Enter first name: ");
      String fName = input.nextLine();
      System.out.println("Enter last name: ");
      String lName = input.nextLine();
      System.out.println("Enter DOB in format DD/MM/YYYY: ");
      String dob = input.nextLine();
      System.out.println("Enter username: ");
      String username = input.nextLine();
      System.out.println("Enter password: ");
      String pw = input.nextLine();
      inputWriter.write(fName + ";" + lName + ";" + dob + ";" + username + ";" + pw + "\n");
    } catch(IOException e) {
      System.out.println("error occurred");
    }
    input.close();
  }

  public void showAll() {
    File userFile = new File(filePath);
    try (Scanner fileReader = new Scanner(userFile)) {
      while (fileReader.hasNextLine()) {
        String data = fileReader.nextLine();
        System.out.println(data);
      }
    } catch (FileNotFoundException e) {
        System.out.println("file not found!");
    }
  }

  public String searchUser(String searchText) {
    File userFile = new File(filePath);
    try (Scanner fileReader = new Scanner(userFile)) {
      while (fileReader.hasNext()) {
        String line = fileReader.nextLine().toLowerCase().toString();
        String[] parts = line.split(";");
        String readName = parts[0].trim()+parts[1].trim();
        if (readName.contains(searchText)) {
          return line;
        }
      }

      return ("User not found!");

    } catch (FileNotFoundException e) {
        return ("file not found!");
    }
  }

  public boolean login(String usernameLogin, String pwLogin) {
    File userFile = new File(filePath);
    try (Scanner fileReader = new Scanner(userFile)) {
      while (fileReader.hasNext()) {
        String line = fileReader.nextLine().toString();
        String[] parts = line.split(";");
        String readUsername = parts[3];
        String readPw = parts[4];
        if (readUsername.equals(usernameLogin) && readPw.equals(pwLogin)) {
          System.out.println("Login successfully!");
          return true;
        }
      }
      return false;
    } catch (FileNotFoundException e) {
      System.out.println("file not found!");
      return false;
    }
  }
}
