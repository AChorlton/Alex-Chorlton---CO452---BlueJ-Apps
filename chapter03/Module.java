
/**
 * A Module is part of a course that a Student
 * will complete.  When complete a Module is awarded
 * a mark and providing it is a pass mark students
 * gain credit for completing the Module
 *
 * @author Alex Chorlton
 * @version 0.1
 */
public class Module
{
    public static final int CREDIT = 30;
    
    private String moduleCode;
    private String moduleName;
    
    private int mark;
    private boolean complete;
    
   
    public Module(String code, String title)
    {
        this.moduleCode = code;
        this.moduleName = title;
        
        complete = false;
        mark = -1;
    }

    /**
     * This will present to the user the studednts mark which will be between 0 and 100.
     */
    public int getMark()
    {
        // put your code here
        return mark;
    }
    
    public boolean isComplete()
    {
        return complete;
    }
    
    public void print()
    {
        System.out.print("\tModule " + moduleCode);
        System.out.print(" " + moduleName);
           
        if(isComplete())
        {
            System.out.println(" mark = " + mark);
        }
        else
        {
            System.out.println(" is not completed yet!");
        }
    }
    
    public void awardMark(int mark)
    {
        if((mark >= 0) && (mark <= 100))
        {
            this.mark = mark;
            complete = true;
        }
    }
}
