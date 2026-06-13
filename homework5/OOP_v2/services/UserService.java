package homework5.OOP_v2.services;

import java.time.LocalDate;
import java.util.Scanner;

import homework5.OOP_v2.controllers.UserController;
import homework5.OOP_v2.models.User;
import homework5.OOP_v2.utils.DataValidation;

public class UserService {
  public void userService() {

    Scanner input = new Scanner(System.in);
    System.out.println("Select options: 1. Register; 2. View registered users; 3. Login");
    int selection = input.nextInt();
    input.nextLine();

    switch (selection) {
      case 1: {
        System.out.println("Enter first name: ");
        String fName = input.nextLine();
        System.out.println("Enter last name: ");
        String lName = input.nextLine();
        System.out.println("Enter DOB in format dd/MM/yyyy: ");
        String dob = input.nextLine();
        System.out.println("Enter username: ");
        String username = input.nextLine();
        System.out.println("Enter password: ");
        String pw = input.nextLine();

        input.close();

        LocalDate validatedDOB = DataValidation.validateDate(dob); 
        User inputUser = new User(fName,lName,validatedDOB,username,pw);
        UserController registerUser = new UserController();
        registerUser.register(inputUser.formatUser());

        break;
      }
      case 2:
        System.out.println("Select options: 1. Show all; 2. Find by name");
        int selection2 = input.nextInt();
        input.nextLine();

        UserController showUser = new UserController();

        switch (selection2) {
          case 1:
            showUser.showUsers();
            break;

          case 2:
            System.out.println("Search user:");
            String searchText = input.nextLine().trim().toLowerCase(); 
            System.out.println(showUser.searchUser(searchText));
            break;

          default:
            System.out.println("Invalid input! Only enter option 1/2!");
            break;
        }
        break;

      case 3:
        int count = 1;
        while (count <= 3) {
          System.out.println("Username:");
          String usernameLogin = input.nextLine();
          System.out.println("Password:");
          String pwLogin = input.nextLine();        

          UserController login = new UserController();
          boolean loginStatus = login.validateUser(usernameLogin, pwLogin);
          if (loginStatus) {
            System.out.println("Login successfully!");
            break;
          } else {
            System.out.println("try again!");
            count += 1;
          }
        }

        if (count >=3) {
          System.out.println("Account locked!");
        }        
        break;
    
      default:
        System.out.println("Invalid input! Only enter option 1/2/3!");
        break;
    }

  }
}
