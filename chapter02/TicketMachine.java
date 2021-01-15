
import java.text.SimpleDateFormat;
/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author Alex Chorlton
 * @version 1.0
 */
public class TicketMachine
{
   //This is the cost and location of the first ticket.
   public static final Ticket AYLESBURY_TICKET = new Ticket("Aylesbury", 220);
   //This is the cost and location of the second ticket.
   public static final Ticket AMERSHAM_TICKET = new Ticket("Amersham", 300);
   //This is the cost and location of the third ticket.
   public static final Ticket HIGH_WYCOMBE_TICKET = new Ticket("High Wycombe", 330);
    
   //This is the amount of money entered by the customer to pay for the ticket.
   private int balance;
   //This is the amount of money within the machine.
   private int total;
   //This is the cost of the ticket the user is paying for.
   private int price;
   
   private Ticket currentTicket;
   /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine()
   {
      currentTicket=null;
      balance = 0;
      total = 0;
   }

   public void addAylesbury()
   {
      currentTicket=AYLESBURY_TICKET;
   }
   
   public void addAmersham()
   {
      currentTicket=AMERSHAM_TICKET;
   }
   
   public void addHighWycombe()
   {
      currentTicket=HIGH_WYCOMBE_TICKET;
   }
    
   public void balanceUpdate(int cash)
   {
      balance=balance +cash;
        
        
      System.out.println("cash in" +cash);
      displayBalance();
   }
   
   public void displayBalance()
    {
        System.out.println("Balance"+balance);
    }

   public void insert10()
    {
        balanceUpdate(10);
    }
    
   public void insert20()
    {
        balanceUpdate(20);
    }
    
   public void insert100()
    {
        balanceUpdate(100);
    }
    
   public void insert200()
    {
        balanceUpdate(200);
    }
    
   public void insertCoin(Coin aCoin)
    {
        balanceUpdate(aCoin.getValue());
    }
    
   public int getPrice()
    {
        if(currentTicket != null)
        {
            return currentTicket.getPrice();
        }
        else
        {
            System.out.println("You must select a destination");
            return 0;
        }
    }
    
   /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    } 
    
    public int getBalance()
    {
        return balance;
    }
    
    private void printHeading()
    {
        System.out.println();
        System.out.println(" ##################################");
        System.out.println(" #      Chorlton Trains");
        System.out.println(" # Train Tickets - Pay Here");
        System.out.println(" ##################################");
        System.out.println();
        
    }
    
    public void printDestination()
    {
        printHeading();
        System.out.println();
        
        System.out.print(" Avalailable to " + AYLESBURY_TICKET.getDestination());
        System.out.println(" cost " + AYLESBURY_TICKET.getPrice());
        
        System.out.print(" Avalailable to " + AMERSHAM_TICKET.getDestination());
        System.out.println(" cost " + AMERSHAM_TICKET.getPrice());
        
        System.out.print(" Avalailable to " + HIGH_WYCOMBE_TICKET.getDestination());
        System.out.println(" cost " + HIGH_WYCOMBE_TICKET.getPrice());
        
        
    }
   
   /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
   public void printTicket()
    {
        int price = currentTicket.getPrice();
        
        String date = formatter.format(currentTicket.getDate());
        String destination = currentTicket.getDestination();
        if(balance >= price) {
            printHeading();
            // Simulate the printing of a ticket.
            System.out.println(" Your Train Ticket For");
            System.out.println(destination);
            System.out.println("On Date: " + date);
            System.out.println("Price: " + price + "pence");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more pence.");
                    
        }
    }

   /**
     * Return the money in the balance.
     * The balance is reset.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
