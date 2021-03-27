/**
 *
 */

package shield;

import java.io.IOException;

public class SupermarketClientImp implements SupermarketClient {

  // fields of the supermarket client
  private String endpoint;
  private String name;
  private String postCode;
  private boolean isRegistered = false;

  /**
   * Constructor for the supermarket class.
   *
   * @param endpoint address of remote server
   */
  public SupermarketClientImp(String endpoint) {
    assert endpoint != null;
    this.endpoint = endpoint;
  }

  /**
   * Method to use server API to register supermarket.
   *
   * @param name name of the business
   * @param postCode postcode of business
   * @return true or false depending on success of registration
   */
  @Override
  public boolean registerSupermarket(String name, String postCode) {
    assert name != null;
    assert postCode != null;

    String request =
            "registerSupermarket?business_name=" + name + "&postcode=" + postCode;

    try {
      String response = ClientIO.doGETRequest(endpoint + request);
      if (response.equals("registered new") || response.equals("already registered")) {
        this.name = name;
        this.isRegistered = true;
        this.postCode = postCode;
        return true;
      }

    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }

    return false;
  }

  /**
   * Method to use server API to
   * update an order status.
   *
   * @param orderNumber the order number
   * @param status status of the order for the requested number
   * @return rue or false depending on success of registration
   */
  @Override
  public boolean updateOrderStatus(int orderNumber, String status) {
    assert status != null;

    String updateOrderstatusEndpoint =
            this.endpoint + "updateOrderStatus?orderID=" + orderNumber + "&newStatus=" + status;

    try {
      String response = ClientIO.doGETRequest(updateOrderstatusEndpoint);
      if (response.equals("True")) {
        return true;
      }

    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }

    return false;
  }

  /**
   * Checks if the supermarket is registered.
   *
   * @return true or false depending on registration status
   * of the supermarket
   */
  @Override
  public boolean isRegistered() {
    return this.isRegistered;
  }

  /**
   * Gets the name of the supermarket
   *
   * @return name of the supermarket
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Gets the postcode of the supermarket.
   *
   * @return postcode of the supermarket
   */
  @Override
  public String getPostCode() {
    return this.postCode;
  }
}
