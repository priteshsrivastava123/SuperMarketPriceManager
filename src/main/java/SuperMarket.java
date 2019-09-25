import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperMarket {

    List<Cart> myCart = new ArrayList<>();
    List<Inventory> inventoryList = new ArrayList<>();
    List<Promotions> promoList = new ArrayList<>();
    BigDecimal cartPrice = BigDecimal.ZERO;
    BigDecimal individualItemPrice = BigDecimal.ZERO;
    BigDecimal promoPrice = BigDecimal.ZERO;
    int receiptNo = 1;

    public List<Inventory> initializeInventory() {
        return inventoryList;
    }

    public void addItemToInventory(Inventory inventory) {
        boolean hasSerialNo = (inventory.serialNumber != "" || inventory.serialNumber != null);
        if (hasSerialNo && inventory.itemPrice > 0 && inventory.storeQty > 0 && inventory.itemPrice > 0) {
            inventoryList.add(inventory);
        }
    }

    public void addPromo(Promotions promotions) {
        if (promotions.promoPrice > 0 && promotions.promoQty > 0) {
            promoList.add(promotions);
        }
    }

    public BigDecimal totalValueOfCart() {
        cartPrice = BigDecimal.valueOf(0d);
        for (int i = 0; i < myCart.size(); i++) {
            for (int j = 0; j < inventoryList.size(); j++) {
                if (myCart.get(i).itemName.equals(inventoryList.get(j).itemName)) {
                        individualItemPrice = BigDecimal.valueOf((inventoryList.get(j).itemPrice) * (myCart.get(i).qty));
                        cartPrice = cartPrice.add(individualItemPrice);
                    }
                }
            }
        return cartPrice;
    }

    private BigDecimal calculatePromotion() {
        return cartPrice;
    }

    public Integer itemsInTheInventory() {
        return inventoryList.size();
    }

    public Integer itemsInTheCart() {
        return myCart.size();
    }

    public String generateReceipt() {
        if (inventoryList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            String headAndtail = "--------------------";
            String boundary = "|                  |";
            sb.append(headAndtail + "\n");
            for (int i = 0; i <= 4; i++) {
                sb.append(boundary + "\n");
            }
            sb.append(headAndtail);
            return sb.toString();
        }         return null;
    }

    public void addItemsToTheCart(Inventory itemName, int qty) {
        myCart.add(new Cart(itemName, qty));
    }
}