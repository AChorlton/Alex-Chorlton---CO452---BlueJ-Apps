import java.util.Random;

/**
 * Demonstrate the StockManager and Item classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Alex Chorlton
 * @version 10th January 2021
 */
public class StockDemo
{
    public static final int FIRST_ID = 200;
    public static final int LAST_ID = 209;
    
    // The stock manager.
    private StockManager manager;
    
    private Random randomGenerator;

    /**
     * Create a StockManager and populate it with
     * 10 sample items.
     */
    public StockDemo(StockManager manager)
    {
        randomGenerator = new Random();
        this.manager = manager;
        
        addTestData();
        demoDeliverItems();
    }
    
    public void addTestData()
    {
        int id = FIRST_ID;
        manager.addItem(new Item(id,"Intl Core I9-10900k"));
        
        id++; 
        manager.addItem(new Item(id,"AMD Ryzen 9 5950x"));
        
        id++; 
        manager.addItem(new Item(id,"NVIDIA RTX 3090"));
        
        id++; 
        manager.addItem(new Item(id,"AMD Radeon RX 6900 XT"));
        
        id++; 
        manager.addItem(new Item(id,"Corsair ICUE 4000x RGB"));
        
        id++; 
        manager.addItem(new Item(id,"Cooler Master MB520"));
        
        id++; 
        manager.addItem(new Item(id,"AMD Ryzen 5 5600x"));
        
        id++; 
        manager.addItem(new Item(id,"Intel Core I5-10400F"));
    }
    
    public void runDemo()
    {
       manager.printAllItems();
       demoDeliverItems();
       manager.printAllItems();
       demoSellItems();
       manager.printAllItems();
       
       manager.removeItem(102);
       
       manager.renameItem(103, "Intel Core I9-10900k");
       //manager.restockLowItems(3);
       manager.searchItem("Corsiar");
    }
    
    private void demoDeliverItems()
    {
       for(int id = FIRST_ID; id < LAST_ID; id++)
       {
           int quantity = randomGenerator.nextInt(6) + 1;
           manager.takeDelivery(id, quantity);
       }
    }
   
   
    /**
     * Demonstrate that the StockManager can sell all
     * different quantities of all of the items
     */
    private void demoSellItems()
    {
        manager.printAllItems();
        
        for(int id = FIRST_ID; id < LAST_ID; id++ )
        {
            int quantity = randomGenerator.nextInt(6) + 1;
            manager.sellItem(id, quantity);
        }
        
        manager.printAllItems();
    }
}
