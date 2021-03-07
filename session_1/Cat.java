import java.awt.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.ImageIcon;

// Task 1
public class Cat {
  private String name;
  private String description = "";
  public ImageIcon image = new ImageIcon("Hello-Geekette-2.jpeg");

  public Cat(String name) {
    this.name = name;
    setDescription();
  }

  public void setDescription(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter cat description: ");
    String description = scanner.nextLine();
    System.out.println(description);
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }

  public void meow(){
    System.out.println("meow meow");
  }

}