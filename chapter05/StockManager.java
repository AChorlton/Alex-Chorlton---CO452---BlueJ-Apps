import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Items.
 * 
 * @author Alex Chorlton 
 * @version 10th January 2021
 */
public class StockManager
{
    // A list of the items within the system.
    private ArrayList<Item> stock;
    
     /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a Item to the list.
     * @param item The item to be added.
     */
    public void addItem(Item item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular item.
     * Increase the quantity of the item by the given amount.
     * @param id The ID of the item.
     * @param amount The amount to increase the quantity by.
     */
    public void takeDelivery(int id, int amount)
    {
        Item item = findItem(id);
        
        if(item == null)
        {
            System.out.println("\n    Item ID" + id + " not found! \n"); 
        }
        else
        {
            System.out.println("    " + item);
            item.increaseQuantity(amount);
            System.out.println("    Re-stocking by " + amount);
            System.out.println();
        }
    }
    
    /**
     * Try to find a item in the stock with the given id.
     * @return The identified item, or null if there is none
     *         with a matching ID.
     */
    public Item findItem(int id)
    {
        int index = 0;
        boolean found = false;
        Item item = null;
        
        while(!found && index < stock.size())
        {
           item = stock.get(index);
           if(item.getID() == id)
           {
               found = true;
           }
           else index++;
        }
        
        return item;
    }
    
    public void searchItem(String targetPhrase)
    {
        int count = 0;
        targetPhrase.toLowerCase();
        
        System.out.println("\nSearching for " + targetPhrase + "\n");
        
        for(Item item : stock)
        {
            if(item.getName().toLowerCase().contains(targetPhrase))
            {
                System.out.println(item);
                count++;
            }
        }
        
        System.out.println("\nThere are " + count + " items containing " + 
                            targetPhrase + " in their name!\n");
    }
    
    /**
     * Print details of all the items.
     */
    public void printAllItems()
    {
        for(Item items : stock)
        {
            System.out.println("    " + items);
        }
        
        System.out.println();
    }
    
    /**
    *  Print all items with zero quantity
    */
    public ArrayList<Item> printLowStockitems(int minimum)
    {
        ArrayList<Item> lowStock = new ArrayList<Item>();
        int count = 0;
        
        System.out.println(" Printing all out of stock items");
        System.out.println();
        
        for(Item item : stock)
        {
            if(item.getQuantity() <= minimum)
            {
                count++;
                lowStock.add(item);
                System.out.println(item);
            }
        }
        
        System.out.println();
        System.out.println("There were " + count + 
                           " stock items with less than " + minimum +
                           " items\n");
        return lowStock;
    }
    
    /**
     * Increase the quantity of stock for all items in the lowStock
     * ArrayList.
     */
    public void restockLowItems(int minimum)
    {
       ArrayList<Item> lowStock = printLowStockitems(minimum);
       
       System.out.println("\nRe-Stocking to a minimum level of " + 
                          minimum + "\n");
                          
       for(Item item : lowStock)
       {
          item.increaseQuantity(minimum - item.getQuantity()); 
       }
    }
    
    /**
     * If the item exists that matches the id
     * remove that item from the list.
     */
    public void removeItem(int id)
    {
        Item item = findItem(id);
        
        if(item == null)
        {
            System.out.println("\n Item ID " + id + " NOT FOUND!\n");
        }
        else
        {
            stock.remove(item);
            System.out.println("\n Item ID " + id + " REMOVED!\n");            
        }
    }
    
    public void renameItem(int id, String newName)
    {
        Item item = findItem(id);
        
        if(item == null)
        {
            System.out.println(" Item id = " + id + " not found!");
        }
        else
        {
            System.out.println(item);
            item.setName(newName);
            System.out.println("***RENAMED***");
            System.out.println(item);
        }
    }
    
    /**
     * If the item exists that matches the id
     * remove that item from the list.
     */
    public void sellItem(int id, int amount)
    {
        Item item = findItem(id);
        
        if(item == null)
        {
            System.out.println("\n Item ID " + id + " NOT FOUND!\n");
        }
        else
        {
            item.sell(amount);
            System.out.println("\n Item ID " + id + " sold!\n");            
        }
    }    
}
