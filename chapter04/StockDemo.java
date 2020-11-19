import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * 
 * @modified by Alex Chorlton
 * @version 1.0
 */
public class StockDemo
{
    public static final int FIRST_ID = 100;
    public static final int LAST_ID = 109;
    
    // The stock manager.
    private StockManager manager;
    
    private Random randomGenerator;

    /**
     * Create a StockManager and populate it with
     * 10 examplar products.
     */
    public StockDemo(StockManager manager)
    {
        randomGenerator = new Random();
        this.manager = manager;
        
        int id = FIRST_ID;
        manager.addProduct(new Product(id,"AMD Ryzen 5 5600x"));
        
        id++;
        manager.addProduct(new Product(id,"AMD Ryzen 9 5950x"));
        
        id++; 
        manager.addProduct(new Product(id,"Intel I5 10500k"));
        
        id++; 
        manager.addProduct(new Product(id,"Intel I9 10900k"));
        
        id++; 
        manager.addProduct(new Product(id,"NVIDIA RTX 3070"));
        
        id++; 
        manager.addProduct(new Product(id,"NVIDIA RTX 3080"));
        
        id++; 
        manager.addProduct(new Product(id,"AMD RADEON RX 6800"));
        
        id++; 
        manager.addProduct(new Product(id,"AMD RADEON RX 6900xt"));
        
        id++; 
        manager.addProduct(new Product(id,"Corsair Vengeance DDR4 8GB 3200MHz"));
        
        id++; 
        manager.addProduct(new Product(id,"Corsair Vengeance DDR4 16GB 3200MHz"));
    }
    
    public void runDemo()
    {
       manager.printAllProducts();
       demoDeliverProducts();
       manager.printAllProducts();
       demoSellProducts();
       manager.printAllProducts();
       
       manager.removeProduct(102);
       
       manager.renameProduct(103, "NVIDIA RTX 3080");
       //manager.restockLowProducts(3);
       manager.searchProducts("NVIDIA");
    }
   
    /**
     * Show that the StockManager can sell a number of 
     * different quantities of all of the products
     */
    private void demoSellProducts()
    {
        manager.printAllProducts();
        
        for(int id = FIRST_ID; id < LAST_ID; id++ )
        {
            int quantity = randomGenerator.nextInt(6) + 1;
            manager.sellProduct(id, quantity);
        }
        
        manager.printAllProducts();
    }
    
    private void demoDeliverProducts()
    {
       for(int id = FIRST_ID; id < LAST_ID; id++)
       {
           int quantity = randomGenerator.nextInt(6) + 1;
           manager.takeDelivery(id, quantity);
       }
    }
}
