package homework5.OOP_v1;

import java.util.Scanner;

public class userInput {
  public static void main(String[] args) {
    userController user = new userController("user.txt");

    Scanner option = new Scanner(System.in);
    System.out.println("Select options: 1. Register; 2. View registered users; 3. Login");
    int selection = option.nextInt();
    option.nextLine();

    // selection 1
    if (selection == 1) {
      user.register();
  
    } else if (selection == 2) {   // selection 2
      System.out.println("Select options: 1. Show all; 2. Find by name");
      int selection2 = option.nextInt();
      option.nextLine();

      switch (selection2) {
        case 1:
          user.showAll();
          break;

        case 2:
          System.out.println("Search user:");
          String searchText = option.nextLine().trim().toLowerCase(); 
          System.out.println(user.searchUser(searchText));                
          break;
      }

     } else if (selection == 3) { // selection 3
        int count = 1;
        while (count <= 3) {
          System.out.println("Username:");
          String usernameLogin = option.nextLine();
          System.out.println("Password:");
          String pwLogin = option.nextLine();        

          if (user.login(usernameLogin, pwLogin) == true) {
            break;
          } else {
            System.out.println("try again!");
            count += 1;
          };
        }
        if (count >=3) {
          System.out.println("Account locked!");
        }        
      }


      option.close();

  }

}
