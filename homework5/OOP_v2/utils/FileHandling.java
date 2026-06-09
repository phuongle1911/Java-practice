package homework5.OOP_v2.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandling {
  public String filePath;

  // fileHandler(String filePath) {
  //   this.filePath = filePath;
  // };

  public void fileWrite(String content) {
    try (FileWriter writer = new FileWriter(filePath, true)) {
      writer.write(content);
    } catch(IOException e) {
      System.out.println("error occurred when writing on file!");
    }
  };

  public Object[] fileRead() {
    File fileToRead = new File(filePath);
    ArrayList<String> arrlist = new ArrayList<String>();
    Object[] arr = new Object[0];

    try (Scanner fileReader = new Scanner(fileToRead)) {
      while (fileReader.hasNextLine()) {
        String data = fileReader.nextLine();
        arrlist.add(data);
      }
      arr = arrlist.toArray();    
      
    } catch (FileNotFoundException e) {
        System.err.println("file not found!");
    }
    return arr;
  }
}
