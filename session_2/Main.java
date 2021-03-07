import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException, InterruptedException {
    Cat cat = new Cat("Cat");
    cat.meow();

    View view = new View(cat);
    view.setup();
  }
}