import java.io.IOException;
/**
 * This class creates an instance of the StockApp
 * and then calls on its run method.
 *
 * @author Alex Chorlton
 * @version 10th January 2021
 */
public class Program
{
    private static StockApplication app;

    /**
     * This class creates and runs an instance of
     * the StockApp class
     */
    public static void main() throws IOException
    {
        char escCode = 0x1B;
        int row = 10, col = 20;
        System.out.print(String.format("%c[%d;%df",escCode,row, col));
        System.out.println("XXX");
        
        // app = new StockApplication();
        // app.run();
        
        // InputReader reader = new InputReader();
        // System.out.println("Character = " + letter);
        // //char c = reader.getChar();
        // int letter = System.in.read();
        
        
    }
}
