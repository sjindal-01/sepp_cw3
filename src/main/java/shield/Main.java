/*
 * main program
 *
 */

package shield;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println("running!");
    String response = ClientIO.doGETRequest("http://127.0.0.1:5000/showFoodBox?orderOption=catering&dietaryPreference=none");
    System.out.println(response);
    return;
  }
}
