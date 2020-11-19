/**
 * Model some details of a product sold by a company.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * 
 * @Modified by Alex Chorlton
 * @Version 1.0
 */
public class Product
{
    // An identifying number for this product.
    private int id;
    // The name of this product.
    private String name;
    // The quantity of this product in stock.
    private int amount;

    /**
     * Constructor for objects of class Product.
     * The initial stock quantity is zero.
     * @param id The item's identification number.
     * @param name The item's name.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        amount = 0;
    }

    /**
     * @return The product's identification number
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return The product's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The quantity in stock.
     */
    public int getQuantity()
    {
        return amount;
    }

    /**
     * @return The id, name and quantity in stock.
     */
    public String toString()
    {
        return id + ": " +  name + " stock level: " + amount;
    }

    /**
     * Restock with the given amount of this product.
     * The current quantity is incremented by the given amount.
     * @param amount The number of new items added to the stock.
     *               This must be greater than zero.
     */
    public void increaseQuantity(int amount)
    {
        if(amount > 0) 
        {
            amount += amount;
        }
        else 
        {
            System.out.println("Attempt to restock " + name +
                               " with a non-positive amount: " + amount);
        }
    }

    /**
     * Sell one of these products.
     * An error is reported if there appears to be no stock.
     */
    public boolean sellOne()
    {
        if(amount > 0) 
        {
            amount--;
            return true;
        }
        else 
        {
            System.out.println(
                "Attempt to sell an out of stock item: " + id + ":" + name);
            
                return false;
        }
    }
    
    /**
     * The products name should only be changed if there is
     * a spelling mistake, otherwise it will cause confusion
     */
    public void setName(String newName)
    {
        name = newName;
    }
}
