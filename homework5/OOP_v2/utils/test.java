import java.io.FileWriter;
import java.io.IOException;

public class test {
      public static void main(String[] args) {
        String[] a = {"asd","phuong","jake"};
        a[1]="change";
    
    try (FileWriter writer = new FileWriter("test.txt", false)) {
      for (String word:a) {
        writer.write(word + "\n");
      }
    } catch(IOException e) {
      System.out.println("error occurred when writing on file!");
    }
    
    
        
    }

}
