/**
 * To implement
 */

package shield;

import java.io.IOException;
import java.util.Collection;
import java.time.LocalDateTime;

public class ShieldingIndividualClientImp implements ShieldingIndividualClient {

  /**
   * The string representation of the base server endpoint (a HTTP address)
   */
  private String endpoint;

  /**
   * Details of the shielding individual
   */
  private String CHI;
  private boolean isRegistered = false;

  /**
   * Constructor for the Shielding Individual Class.
   *
   * @param endpoint the base server endpoint
   */
  public ShieldingIndividualClientImp(String endpoint) {
    this.endpoint = endpoint;

  }

  /**
   * Registers a shielding individual and returns true if operation occurred correctly.
   *
   * @param CHI CHI number of the individual
   * @return true or false depending on success of registration
   */
  @Override
  public boolean registerShieldingIndividual(String CHI) {
    assert CHI != null;
    String request = "registerShieldingIndividual?CHI=" + CHI;

    try{
      String response = ClientIO.doGETRequest(this.endpoint + request);
      if (response.equals("registered new") || response.equals("already registered")) {
        this.CHI = CHI;
        this.isRegistered = true;
        return true;
      }
    } catch (IOException e) {
      e.printStackTrace();

    }
    return false;
  }

  @Override
  public Collection<String> showFoodBoxes(String dietaryPreference) {
    return null;
  }

  @Override
  public boolean placeOrder(LocalDateTime deliveryDateTime) {
    return false;
  }

  @Override
  public boolean editOrder(int orderNumber) {
    return false;
  }

  @Override
  public boolean cancelOrder(int orderNumber) {
    return false;
  }

  @Override
  public boolean requestOrderStatus(int orderNumber) {
    return false;
  }

  // **UPDATE**
  @Override
  public Collection<String> getCateringCompanies() {
    return null;
  }

  // **UPDATE**
  @Override
  public float getDistance(String postCode1, String postCode2) {
    return 0;
  }

  @Override
  public boolean isRegistered() {
    return false;
  }

  @Override
  public String getCHI() {
    return null;
  }

  @Override
  public int getFoodBoxNumber() {
    return 0;
  }

  @Override
  public String getDietaryPreferenceForFoodBox(int foodBoxId) {
    return null;
  }

  @Override
  public int getItemsNumberForFoodBox(int foodBoxId) {
    return 0;
  }

  @Override
  public Collection<Integer> getItemIdsForFoodBox(int foodboxId) {
    return null;
  }

  @Override
  public String getItemNameForFoodBox(int itemId, int foodBoxId) {
    return null;
  }

  @Override
  public int getItemQuantityForFoodBox(int itemId, int foodBoxId) {
    return 0;
  }

  @Override
  public boolean pickFoodBox(int foodBoxId) {
    return false;
  }

  @Override
  public boolean changeItemQuantityForPickedFoodBox(int itemId, int quantity) {
    return false;
  }

  @Override
  public Collection<Integer> getOrderNumbers() {
    return null;
  }

  @Override
  public String getStatusForOrder(int orderNumber) {
    return null;
  }

  @Override
  public Collection<Integer> getItemIdsForOrder(int orderNumber) {
    return null;
  }

  @Override
  public String getItemNameForOrder(int itemId, int orderNumber) {
    return null;
  }

  @Override
  public int getItemQuantityForOrder(int itemId, int orderNumber) {
    return 0;
  }

  @Override
  public boolean setItemQuantityForOrder(int itemId, int orderNumber, int quantity) {
    return false;
  }

  @Override
  public LocalDateTime getDeliveryTimeForOrder(int orderNumber) {
    return null;
  }

  // **UPDATE**
  @Override
  public String getClosestCateringCompany() {
    return null;
  }
}
