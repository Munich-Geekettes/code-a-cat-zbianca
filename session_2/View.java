import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View {
  private Cat cat;

  //TODO 1: Declare HTTPClient
  private HTTPClient client;

  JFrame frame = new JFrame();
  JLabel imageLabel = new JLabel();
  ImageIcon icon;

  public View(Cat cat) {
    this.cat = cat;
    this.icon = cat.image;

    //TODO 2: Instantiate HTTPClient with the baseURI you found
    this.client = new HTTPClient("https://cataas.com/");
  }

  // Explain why we need to extract Jframe out of setup()
  public void setup() {

    JButton yesButton = showYesButton();
    frame.add(yesButton);

    JButton noButton = showNoButton();
    frame.add(noButton);

    JLabel textLabel = showDescription();
    frame.add(textLabel);

    //TODO 3: Call getCatImage() using the client and replace icon = this.cat.image
    //icon = this.cat.image;
    //icon = client.getCatImage();
    icon = client.getCatImageWith(cat.getDescription());
    ImageIcon scaledImage = scaleImage(icon);

    imageLabel = new JLabel(scaledImage);
    imageLabel.setVerticalAlignment(JLabel.TOP);
    frame.add(imageLabel);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setSize(500, 500);
    frame.setVisible(true);
  }

  //Helper Methods

  private JLabel showDescription() {
    String description = this.cat.getDescription();
    JLabel textLabel = new JLabel("Is this your cat?  " + description);
    textLabel.setBounds(50, 375, 400, 50);
    return textLabel;
  }

  private ImageIcon scaleImage(ImageIcon icon) {
    double max = Math.max(icon.getIconWidth(), icon.getIconHeight());
    double ratio = 375 / max;
    int newHeight = (int) (ratio * icon.getIconHeight());
    int newWidth = (int) (ratio * icon.getIconWidth());

    ImageIcon scaledImage = new ImageIcon(icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT));
    return scaledImage;
  }

  private JButton showYesButton() {
    JButton yesButton = new JButton("YES");
    yesButton.setBounds(55, 430, 65, 35);
    // Session 2
    yesButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println("YES pressed");
        cat.image = icon;
        cat.save();
      }
    });
    return yesButton;
  }

  private JButton showNoButton() {
    JButton noButton = new JButton("NO");
    noButton.setBounds(375, 430, 65, 35);
    noButton.addActionListener(new ActionListener() {
      // Session 2
      public void actionPerformed(ActionEvent e) {
        System.out.println("NO pressed");
        icon = client.getCatImage();
        imageLabel.setIcon(scaleImage(icon));
      }
    });
    return noButton;
  }
}
