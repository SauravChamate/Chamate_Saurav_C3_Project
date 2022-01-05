import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        if(getCurrentTime().isAfter(openingTime) && getCurrentTime().isBefore(closingTime)){
        return true;
        }
        return false;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        if(menu.size()!=0){
            return menu;
        }
        return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
    }

    Item findItemByName(String itemName)throws itemNotFoundException{
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        throw new itemNotFoundException("item not found");
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

    //Method to get the price of the item using item_name
    int getPriceofItem(String itemName) throws itemNotFoundException {
        int price = findItemByName(itemName).getPrice();
        return price;
    }
    //Method to getTotalbill by making the list of the items needed by the user
    int getTotalbill(List<Item> list){
        int price=0;
        for(Item i : list){
            price+=i.getPrice();
        }
        return price;

    }

}
