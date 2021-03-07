import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.imageio.ImageIO;
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

//Helper methods

//Saves the cat's image as a .jpg file
  public void save() {
    BufferedImage bufferedImage = new BufferedImage(
            image.getIconWidth(),
            image.getIconHeight(),
            BufferedImage.TYPE_INT_RGB);
    Graphics2D g = bufferedImage.createGraphics();
    g.drawImage(image.getImage(), 0, 0, null);
    g.dispose();
    File outputFile = new File("cat.jpg");
    try {
        ImageIO.write(bufferedImage, "jpg", outputFile);
    } catch (IOException e) {
        e.printStackTrace();
    }


}
}