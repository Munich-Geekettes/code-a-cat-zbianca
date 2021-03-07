import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View {
  private Cat cat;

  JFrame frame = new JFrame();

  public View(Cat cat) {
    this.cat = cat;
  }

  public void setup() {
    //TASK 3: Show cat image
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(500, 500);
    frame.setVisible(true);
  }

  //TASK 2: Create  showDescription() method

  //TASK 4: Add two new methods that show a Yes and a No button

  //Helper Methods
  private ImageIcon scaleImage(ImageIcon icon) {
    double max = Math.max(icon.getIconWidth(), icon.getIconHeight());
    double ratio = 375 / max;
    int newHeight = (int) (ratio * icon.getIconHeight());
    int newWidth = (int) (ratio * icon.getIconWidth());

    ImageIcon scaledImage = new ImageIcon(icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT));
    return scaledImage;
  }
}
