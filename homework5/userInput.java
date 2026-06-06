package homework5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class userInput {
  public static void main(String[] args) {

    Scanner option = new Scanner(System.in);
    System.out.println("Select options: 1. Register; 2. View registered users; 3. Login");

    int selection = option.nextInt();
    option.nextLine();
    // selection 1
    if (selection == 1) {
      try (FileWriter inputWriter = new FileWriter("userinput.txt", true)){
        System.out.println("Enter first name: ");
        String fName = option.nextLine();
        System.out.println("Enter last name: ");
        String lName = option.nextLine();
        System.out.println("Enter DOB in format DD/MM/YYYY: ");
        String dob = option.nextLine();
        System.out.println("Enter username: ");
        String username = option.nextLine();
        System.out.println("Enter password: ");
        String pw = option.nextLine();
        inputWriter.write(fName + ";" + lName + ";" + dob + ";" + username + ";" + pw + "\n");
      } catch(IOException e) {
        System.out.println("error occurred");
      }
  // selection 2 or 3
    } else if (selection == 2 || selection == 3) {
      File userFile = new File("userinput.txt");

      try (Scanner fileReader = new Scanner(userFile)) {
        // selection 2
        if (selection == 2) {
          System.out.println("Select options: 1. Show all; 2. Find by name");
          int selection2 = option.nextInt();
          option.nextLine();
          switch (selection2) {
            case 1:
                while (fileReader.hasNextLine()) {
                  String data = fileReader.nextLine();
                  System.out.println(data);
                }
              break;
            case 2:
              System.out.println("Search user:");
              String searchText = option.nextLine().trim().toLowerCase();
              while (fileReader.hasNext()) {
                String line = fileReader.nextLine().toLowerCase().toString();
                String[] parts = line.split(";");
                String readName = parts[0].trim()+parts[1].trim();
                if (readName.contains(searchText)) {
                  System.out.println(line);
                }
              }

              System.out.println("User not found!");
              break;
          
            default:
              System.out.println("Error! Only input 1 or 2 accepted!");
              break;
          }
          // selection 3
        } else {
          int count = 0;
          boolean find = true;
          while (count < 3 && find) {
            System.out.println("Username:");
            String usernameLogin = option.nextLine();
            System.out.println("Password:");
            String pwLogin = option.nextLine();
            System.out.println(usernameLogin + ";" + pwLogin);

            while (fileReader.hasNext()) {
              String line = fileReader.nextLine().toString();
              String[] parts = line.split(";");
              String readUsername = parts[3];
              String readPw = parts[4];
              if (readUsername.equals(usernameLogin) && readPw.equals(pwLogin)) {
                System.out.println("Login successfully!");
                find = false;
                break;
              }
            }
            count += 1;
          }
          
          if (count >=3) {
            System.out.println("Account locked!");
          }
        }
      } catch (FileNotFoundException e) {
        System.out.println("file not found!");
      }

      // others
    } else {
        System.out.println("Error! Input needs to be 1, 2 or 3!");
      }

      option.close();

  }

}
