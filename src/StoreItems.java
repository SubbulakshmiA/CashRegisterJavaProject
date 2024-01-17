import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StoreItems {
   static   ArrayList<Item> listOfItems = new ArrayList<>();
    static ArrayList<PurchaseHistory> listOfPH = new ArrayList<>();
    static  PurchaseHistory  addHistoryList;

    static double totalAmt= 0.0;
    static String timeOfPurchase;
    public static void main(String[] args) {

        Item pants = new Item("Pants",100.0,10);
        Item shirts = new Item("shirts",99.0,50);
        Item shoes = new Item("shoes",400.0,40);
        listOfItems.add(pants);
        listOfItems.add(shirts);
        listOfItems.add(shoes);
    //    listOfItems.add(socks);

        System.out.println("Welcome to Cash Register");
        showMenu();



     //   System.out.println("listOfItems "+listOfItems.get(1).getItemName() +" "+listOfItems.get(1).getPrice()+ " "+listOfItems.get(1).getQuantity());
    }
    public static void showMenu(){

        System.out.println("Items available in the store:");
     //   System.out.println("choose 1 for 10 Pants at $100");

        StringBuffer menu=new StringBuffer();
        menu.append("choose 1 for 10 Pants at $100");
        menu.append("\n");
        menu.append("choose 2 for 50 Shirts at $99");
        menu.append("\n");
        menu.append("choose 3 for 40 Shoes at $400 ");
        menu.append("\n");
        menu.append("4 : Exit");
        menu.append("\n");
//        menu.append("choose 5 for manager options");
//        menu.append("\n");
//        menu.append("5 : This Help Menu");
//        PurchaseHistory addHistoryList = new PurchaseHistory();
        while (true){

            System.out.println(menu.toString());
            Scanner scan = new Scanner(System.in) ;
            int choice = scan.nextInt();
            // printing history when 5 is pressed
           if(choice ==5){
//               System.out.println("App exit");
                showHistory();
                break;
            }
//            System.out.println(" "+listOfItems.get(choice-1).getItemName() +" "+listOfItems.get(choice-1).getPrice()+ " "+listOfItems.get(choice-1).getQuantity());
          System.out.println("How many "+listOfItems.get(choice-1).getItemName() + " would you like to purchase?");
            int purchaseQuantity = scan.nextInt();
           totalAmt += totalCost(listOfItems.get(choice-1).getPrice() ,purchaseQuantity);
           timeOfPurchase = getPurchaseTime();
           listOfItems.get(choice-1).setQuantity(updateQuantity(listOfItems.get(choice-1).getQuantity(), purchaseQuantity));
            System.out.println(" "+listOfItems.get(choice-1).getItemName() +" "+listOfItems.get(choice-1).getPrice()+ " "+listOfItems.get(choice-1).getQuantity());
            System.out.println("totalAmt "+totalAmt);
//            addHistoryList = new PurchaseHistory(timeOfPurchase,listOfItems.get(choice-1).getQuantity(),listOfItems.get(choice-1).getItemName(),totalAmt);
            addHistoryList = new PurchaseHistory(timeOfPurchase,totalCost(listOfItems.get(choice-1).getPrice() ,purchaseQuantity),listOfItems.get(choice-1).getItemName(),totalAmt);

            listOfPH.add(addHistoryList);
        }
    }
    public static Double totalCost(double price, int purchaseQuantity){
    totalAmt = price * purchaseQuantity;
       return totalAmt;
    }

    public static int updateQuantity(int existingQuantity, int purchaseQuantity){
       return existingQuantity -=purchaseQuantity;
    }

     public  static String getPurchaseTime(){
         LocalDateTime now = LocalDateTime.now();

         // You can format the LocalDateTime if needed
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         String formattedTimestamp = now.format(formatter);

         System.out.println("Timestamp: " + formattedTimestamp);
        return formattedTimestamp;
     }
    public static void showHistory(){
        // history list includes time, amount of item purchased, item name, total amount(sum of all item price)
        System.out.println("History of Purchase ");
        for(int i=0; i<listOfPH.size();i++){
            System.out.println( listOfPH.get(i).getTimeOfPurchase()+"   "+listOfPH.get(i).getCurrentAmt()+"  "+
                    listOfPH.get(i).getItemName()+"  "+listOfPH.get(i).getTotalAmt());
        }
    }

}
