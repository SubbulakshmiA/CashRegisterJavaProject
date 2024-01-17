public class Item {
    private String itemName;
    private Double price;
    private int quantity;

    public Item(String itemName,Double price, int quantity){
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
