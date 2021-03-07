import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Cat {
  //TODO: Copy from session 1

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