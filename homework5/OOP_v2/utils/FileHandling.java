package homework5.OOP_v2.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandling {
  public String filePath;

  public void fileWrite(String content) {
    try (FileWriter writer = new FileWriter(filePath, true)) {
      writer.write(content);
    } catch(IOException e) {
      System.out.println("error occurred when writing on file!");
    }
  };

  public String[] fileRead() {
    File fileToRead = new File(filePath);
    ArrayList<String> arrlist = new ArrayList<String>();

    try (Scanner fileReader = new Scanner(fileToRead)) {
      while (fileReader.hasNextLine()) {
        String data = fileReader.nextLine();
        arrlist.add(data);
      }
      String arr[] = new String[arrlist.size()];
      arr = arrlist.toArray(arr);    
      
    } catch (FileNotFoundException e) {
        System.err.println("file not found!");
    }
    return arr;
  }

  public void updateFileContent(String oldLine, String newLine) {
    try (FileWriter writer = new FileWriter(filePath, false);) {
      String[] lines = fileRead(); 

      for (int i = 0; i < lines.length; i++) {
        if (lines[i].equals(oldLine)) {
          lines[i] = newLine;
        }
        writer.write(lines[i] + "\n");
      }
      System.out.println("file updated successfully!");

    } catch (IOException e) {
      System.out.println("Error occurred when updating content in file!");
    }
  }
}
