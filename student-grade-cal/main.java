// package student-grade-cal;
import java.util.Scanner;

public class main {

  public static void main(String[] args) {
    Scanner points = new Scanner(System.in);
    double mathPoint;
    double engPoint;
    double litPoint;
    double avg;
    String grade;
    String rank;
    
    do {
      System.out.println("Enter Math average point betweem 0 and 10:");
      while (!points.hasNextDouble()) {
        System.out.println("Invalid input. Please enter a number!");
        points.next();
      }
      mathPoint = points.nextDouble();
      } while((mathPoint<0) || (mathPoint>10)) ;



    do {
      System.out.println("Enter English average point betweem 0 and 10:");
      while (!points.hasNextDouble()) {
        System.out.println("Invalid input. Please enter a number!");
        points.next();
      }
      engPoint = points.nextDouble();
      } while((engPoint<0) || (engPoint>10)) ;

    do {
      System.out.println("Enter Literature average point betweem 0 and 10:");
      while (!points.hasNextDouble()) {
        System.out.println("Invalid input. Please enter a number!");
        points.next();
      }
      litPoint = points.nextDouble();
      } while((litPoint<0) || (litPoint>10)) ;

    points.close();

    avg = (mathPoint + engPoint + litPoint)/3;

    double firstMin = Math.min(mathPoint,engPoint);
    double minPoint = Math.min(firstMin,litPoint);

    if ((mathPoint<5) || (engPoint<5) || (litPoint<5)) {
      grade = "F";
    } else if (avg<5) {
      grade = "F";
    } else if (avg<6) {
      grade = "D";
    } else if (avg<7) {
      grade = "C";
    } else if (avg<8) {
      if (minPoint<6) {
        grade = "C";
      } else {
        grade = "B";
      }
    } else if (avg<9) {
      if(minPoint<6) {
        grade = "C";
      } else if (minPoint<7) {
        grade = "B";
      } else {
        grade = "A";
      }
    } else {
      if (minPoint<8) {
        grade = "A";
      } else {
        grade = "S";
      }
    }

    switch (grade) {
      case "F":
        rank = "fail";
        break;
      case "D":
        rank = "not bad";
        break;
      case "C":
        rank = "average";
        break;
      case "B":
        rank = "normal";
        break;
      case "A":
        rank = "good";
        break;
      default:
        rank = "excellent";
        break;
    }

    String roundedAvg = String.format("%.2f", avg);

    System.out.println("Math average point:"+mathPoint);
    System.out.println("English average point:"+engPoint);      
    System.out.println("Literature average point:"+litPoint);      
    System.out.println("Average point of all subjects:"+ roundedAvg + "(" + grade + ")");   
    System.out.println("Student rank:" + rank + " " + "student!"); 
  }
  }
