
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock items
 *
 * @author Alex Chorlton
 * @version 10th January 2021
 */
public class StockApplication
{
    public static final String DELIVER = "Deliver Item";
    public static final String REMOVE = "Remove Item";
    public static final String PRINT_LOW_STOCK = "Print Low Stock";
    public static final String PRINT_ALL = "Print All Items";
    public static final String SELL = "Sell Item";
    public static final String ADD = "Add Item";
    public static final String SEARCH = "Search for Item";
    public static final String QUIT = "Quit";
    
    private InputReader reader;
    
    private StockManager manager;
    
    private String[] menuChoices;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApplication()
    {
        menuChoices = new String[] 
        { 
            ADD, DELIVER, SELL,
            SEARCH, REMOVE, PRINT_LOW_STOCK,
            PRINT_ALL, QUIT
        };

        manager = new StockManager();
        StockDemo demo = new StockDemo(manager);
        
        reader = new InputReader();
        
    }
    
    /**
     * Call on methods of the StockManager to
     * execute the selected menu choice
     */
    private boolean executeIntChoice(int choice)
    {
        
        switch(choice)
        {
            case 1: addItem(); break;
            case 2: deliverItem(); break;
            case 3: sellItem(); break;
            case 4: searchItems(); break;
            case 5: removeItem(); break;
            case 6: printLowStock(); break;
            case 7: manager.printAllItems(); break;
            case 8: return true;
            
            default: System.out.println(
                "    Please enter a choice between 1 and " + menuChoices.length);
        }
        
        return false;
    }
    
    private boolean executeStringChoice(String choice)
    {
        if(choice.equals(ADD.toLowerCase()))
        {
            addItem();
        }
        else if(choice.equals(REMOVE.toLowerCase()))
        {
            removeItem();
        }  
        else if(choice.equals(SELL.toLowerCase()))
        {
            sellItem();
        }  
        else if(choice.equals(DELIVER.toLowerCase()))
        {
            deliverItem();
        }          
        else if(choice.equals(PRINT_ALL.toLowerCase()))
        {
            manager.printAllItems();
        }           
        else if(choice.equals(QUIT.toLowerCase()))
        {
            return true;
        }
        
        return false;
    }
    
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();

            int choice = Menu.getIntChoice(menuChoices);
            //String choice = Menu.getStringChoice(menuChoices);
            
            finished = executeIntChoice(choice);
            //finished = executeStringChoice(choice);
        }
    }
    
    private void addItem()
    {
        System.out.println(" Adding a new Item\n");
        
        String prompt = "\n Please enter the item ID number > ";
        int id = reader.getInt(prompt);

        prompt = "\n Please enter the item name > ";
        String name = reader.getString(prompt);    
        
        Item item = new Item(id, name);
        manager.addItem(item);
        manager.takeDelivery(id,1);
        
        System.out.println("\n" + item + " added!\n");
        
    }

    /**
     * This method will ask the user to input a item id
     * and it will look for the item and if found will then
     * remove it from stock.
     */
    private void deliverItem()
    {
        System.out.println(" Deliver an amount of an existing Item\n");
        Item Item = getItem();
        
        if(Item != null)
        {
            String prompt = "\n Please enter the order quantity > ";
            int quantity = reader.getInt(prompt);
            
            manager.takeDelivery(Item.getID(), quantity);
            System.out.println("\n" + quantity + " of " + 
                Item + " delivered!\n");
        }
    }

    /**
     * This method will ask the user to input a item id
     * and it will look for the item and if found will then
     * remove it from stock.
     */
    private void removeItem()
    {
        System.out.println(" Removing an old Item\n");
        Item item = getItem();
        
        if(item != null)
        {
            manager.removeItem(item.getID());
            System.out.println("\n" + item + " removed!\n");
        }
    }
    
    /**
     * This method will ask the user to input a item id
     * and it will look for the item and if found will then
     * remove it from stock.
     */
    private void sellItem()
    {
        System.out.println(" Deliver an amount of an existing Item\n");
        Item item = getItem();
        
        if(item != null)
        {
            String prompt = "\n    Please enter the order quantity > ";
            int quantity = reader.getInt(prompt);
        
            manager.sellItem(item.getID(), quantity);
            System.out.println("\n    " + item + " " + quantity + " sold!\n");
        }
    }
    
    /**
     * This method will ask the user to input a item id
     * and it will look for the item and if found will then
     * remove it from stock.
     */
    private void printLowStock()
    {
        String prompt = "\n Please enter the minimum stock level > ";
        int minimum = reader.getInt(prompt);
        
        System.out.println(" Printing Stock with levels lower than " 
                           + minimum + "\n");
                           
        manager.printLowStockitems(minimum);
    }
    
    /**
     * This method will ask the user to input a item id
     * and it will look for the item and if found will then
     * remove it from stock.
     */
    private void searchItems()
    {
        String prompt = "\n Please enter search term > ";
        String target = reader.getString(prompt);
        
        System.out.println(" Printing items matching " 
                           + target + "\n");
                           
        manager.searchItem(target);
    }

    
    private Item getItem()
    {
        String prompt = "\n Please enter the item ID number > ";
        
        int id = reader.getInt(prompt);
        Item item = manager.findItem(id);
        
        if(item == null)
            System.out.println("    Item " + id + " not found!");
            
        return item;
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:         Add a new item");
        System.out.println("    Deliver:     Deliver a item");
        System.out.println("    Sell  :      Sell a item");
        System.out.println("    Search:      Search items by name");
        System.out.println("    Remove:      Remove an old item");
        System.out.println("    Low Stock:   Print low stock items");
        System.out.println("    Print:       Print all items");
        System.out.println("    Quit:        Quit the program");
        System.out.println();
    }
    
    /**
     * Print the title of the item and the authors name
     */
    private void printHeading()
    {
        // System.out.print(ConsoleColours.ANSI_BRIGHT_GREEN + 
                         // ConsoleColours.ANSI_BRIGHT_BG_YELLOW + "  Colours  ");
                           
        System.out.println("    ******************************");
        System.out.println("     Stock Management Application ");
        System.out.println("       App05: by Alex Chorlton");
        System.out.println("    ******************************\n");
    }
}
