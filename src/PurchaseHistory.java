import java.util.Date;

public class PurchaseHistory {
    private String timeOfPurchase;
    private double currentAmt;
    private String itemName;
    private double totalAmt;

    public double getTotalAmt() {
        return totalAmt;
    }

    public PurchaseHistory(String timeOfPurchase, double currentAmt, String itemName, double totalAmt) {
    this.timeOfPurchase = timeOfPurchase;
    this.currentAmt = currentAmt;
    this.itemName = itemName;
    this.totalAmt = totalAmt;
    }

    public double getCurrentAmt() {
        return currentAmt;
    }

    public void setCurrentAmt(double currentAmt) {
        this.currentAmt = currentAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }

//    PurchaseHistory(Date timeOfPurchase,int quantity,String itemName,Double totalAmt){
//        this.timeOfPurchase = timeOfPurchase;
//        this.
//    }

    public String getTimeOfPurchase() {
        return timeOfPurchase;
    }

    public void setTimeOfPurchase(String timeOfPurchase) {
        this.timeOfPurchase = timeOfPurchase;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
