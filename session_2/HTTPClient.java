import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.*;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class HTTPClient {
    //TODO 1: Declare a baseURI(String) and client(HttpClient) as attributes
    private String baseURI;
    private HttpClient client;

    //TODO 2: Define a constructor for HTTPClient that receives a String as a parameter, and instantiates baseURI(String) and client(HttpClient) 
    public HTTPClient(String baseURI) {
      this.baseURI = baseURI;
      this.client = HttpClient.newHttpClient();
    }

    public ImageIcon getCatImage() {
      //TODO 3: Define GET endpoint
      String catEndpoint = baseURI + "cat";

      
      try {
        //TODO 4: Create a new HttpRequest object using .newBuilder() and the defined getCatEndpoint
        HttpRequest request = HttpRequest.newBuilder()
              .uri(URI.create(catEndpoint))
              .build();

        /*TODO 5: Specify HttpResponse type as byte[] array
        and send the HttpRequest using the client:  specify the content of the HttpResponse using “BodyHandlers” class */
        HttpResponse<byte[]> response = client.send(request,
              HttpResponse.BodyHandlers.ofByteArray());

        //TODO 6: Store the content of the HttpResponse (i.e. body) in an array
        byte[] data = response.body();

        //TODO 7: Convert byte[] array to ImageIcon using the helper method provided below
        ImageIcon icon = convertToImageIcon(data);
        //TODO 8: Return the converted image
        return icon;
      } catch (Exception e) {
        return new ImageIcon("Hello-Geekette-2.jpeg");
      }
      
    }

    public ImageIcon getCatImageWith(String description) {
        //TODO 3: Define GET endpoint
        String catEndpoint = baseURI + "cat/says/";
        String encodedDescription = encodeValue(description);
        String encodedCatEndpoint = catEndpoint + encodedDescription;

        try {
            //TODO 4: Create a new HttpRequest object using .newBuilder() and the defined getCatEndpoint
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(encodedCatEndpoint))
                    .build();

        /*TODO 5: Specify HttpResponse type as byte[] array
        and send the HttpRequest using the client:  specify the content of the HttpResponse using “BodyHandlers” class */
            HttpResponse<byte[]> response = client.send(request,
                    HttpResponse.BodyHandlers.ofByteArray());

            //TODO 6: Store the content of the HttpResponse (i.e. body) in an array
            byte[] data = response.body();

            //TODO 7: Convert byte[] array to ImageIcon using the helper method provided below
            ImageIcon icon = convertToImageIcon(data);
            //TODO 8: Return the converted image
            return icon;
        } catch (Exception e) {
            return new ImageIcon("Hello-Geekette-2.jpeg");
        }

    }

//Helper Methods

    //Converts a byte array into an image, throws an Exception if the conversion fails
    private ImageIcon convertToImageIcon(byte[] byteArray) throws IOException {
        InputStream is = new ByteArrayInputStream(byteArray);
        BufferedImage image = ImageIO.read(is);
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }

    // Encode a string value using `UTF-8` encoding scheme
    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString()).replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex.getCause());
        }
    }
}
