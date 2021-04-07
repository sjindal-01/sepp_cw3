/**
 * Catering Company Client class implementation
 * Uses HTTP protocol to communicate with server API
 */

package shield;

import java.io.IOException;

public class CateringCompanyClientImp implements CateringCompanyClient {

  /**
   * The string representation of the base server endpoint (a HTTP address)
   */
  private String endpoint;
  /**
   * Details of the catering company
   */
  private String name;
  private String postCode;
  private boolean isRegistered = false;

  /**
   * Constructor for the Catering Company Class.
   *
   * @param endpoint the base server endpoint
   */
  public CateringCompanyClientImp(String endpoint) {
    assert endpoint != null;
    this.endpoint = endpoint;
  }

  /**
   * Registers a supermarket and returns true if operation occurred correctly.
   *
   * @param name name of the business
   * @param postCode postcode of the business
   * @return true or false depending on success of registration
   */
  @Override
  public boolean registerCateringCompany(String name, String postCode) {
    assert name != null;
    assert postCode != null;

    String request =
            "registerCateringCompany?business_name=" + name + "&postcode=" + postCode;

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
   * Updates an order status and returns true if operation occurred correctly.
   *
   * @param orderNumber the order number
   * @param status new status of the order for the requested number
   * @return true or false depending on success of status update
   */
  @Override
  public boolean updateOrderStatus(int orderNumber, String status) {
    assert status != null;

    String request = "updateOrderStatus?orderID=" + orderNumber + "&newStatus=" + status;

    try {
      String response = ClientIO.doGETRequest(this.endpoint + request);
      if (response.equals("True")) {
        return true;
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return false;
  }

  /**
   * Checks if the catering company is registered.
   *
   * @return true or false depending on registration status
   * of the catering company
   */
  @Override
  public boolean isRegistered() {
    return this.isRegistered;
  }

  /**
   * Gets the name of the catering company
   *
   * @return name of the catering company
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * Gets the postcode of the catering company.
   *
   * @return postcode of the catering company
   */
  @Override
  public String getPostCode() {
    return this.postCode;
  }
}
