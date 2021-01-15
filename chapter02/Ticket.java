import java.util.Date;
/**
 * Write a description of class Ticket here.
 *
 * @author (Alex Chorlton)
 * @version (0.1)
 */
public class Ticket
{
    public int price;
    public String destination;
    private Date currentDate=new Date();
    
    /**
     * Constructor for objects of class Ticket
     */
    public Ticket(String dest, int price)
    {
        this.price = price;
        this.destination = destination;
    }
    
    public int getPrice()
    {
        // put your code here
        return price;
    }
    
    public String getDestination()
    {
        return destination;
    }
    
    public Date getDate()
    {
        return currentDate;
    }
}
