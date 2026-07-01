package repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.BaseEntity;
import enums.EntityEnums;
import repository.BaseRepository;

public class FileHandling<T extends BaseEntity> {
  public String filePath;

  public FileHandling(String filePath) {
    this.filePath = filePath;
  }

  private String mapObjectToString(ArrayList<T> list) {
    return list
      .stream()
      .map(item -> item.formatData())
      .reduce("", (obj1, obj2) -> obj1 + "/n" + obj2);
  }

  public void saveToFile(ArrayList<T> data, boolean append) {
    try (FileWriter writer = new FileWriter(filePath, append)) {
      writer.write(mapObjectToString(data));
    } catch(IOException e) {
      System.out.println("error occurred when save to file!");
    }
  };


  public ArrayList<T> readFile() {
    File fileToRead = new File(filePath);
    // ArrayList<String> stringlist = new ArrayList<String>();
    ArrayList<T> dataList = new ArrayList<>();
    
    try (Scanner fileReader = new Scanner(fileToRead)) {
      while (fileReader.hasNextLine()) {
        String data = fileReader.nextLine();
        // T.mapStringToObject(data);
        
        
        dataList.add(mapStringToObject(data));
      } 
      
    } catch (FileNotFoundException e) {
        System.err.println("file not found!");
    }
    return dataList;
  }

  // public void updateFile(ArrayList<T> oldList, ArrayList<T>  newList) {
  //   try (FileWriter writer = new FileWriter(filePath, false);) {
  //     String[] lines = fileRead(); 

  //     for (int i = 0; i < lines.length; i++) {
  //       if (lines[i].equals(oldLine)) {
  //         lines[i] = newLine;
  //       }
  //       writer.write(lines[i] + "\n");
  //     }
  //     System.out.println("file updated successfully!");

  //   } catch (IOException e) {
  //     System.out.println("Error occurred when updating content in file!");
  //  }
  // }
}
