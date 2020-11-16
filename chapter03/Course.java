
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Alex Chorlton
 * @version 0.1
 */
public class Course
{
    public static final int MAX_MODULES = 4;
    
    private String courseNumber;
    private String courseName;
    
    private int totalMark;
    private int meanMark;
    private int noModules;
    private int totalCredits;
    
    
    private boolean complete;
    
    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;

    /**
     * Constructor for objects of class Course
     */
    public Course(String codeNo, String name)
    {
        this.courseNumber = codeNo;
        this.courseName = name;
        
        noModules = 0;
        totalMark = 0;
        totalCredits = 0;
        complete = false;
    }

    /**
     * Add up to 4 different modules into a course.
     */
    public void addModule(int number, Module module)
    {
        if((number >= 1) && (number <= MAX_MODULES)) noModules++;
        
        switch(number)
        {
            case 1: module1 = module; break;
            case 2: module2 = module; break;
            case 3: module3 = module; break;
            case 4: module4 = module; break;
        }
    }
    
    /**
     * This prints out the detais of the course so that the user is able to view them.
     */
    public void print()
    {
        // put your code here
        System.out.println("Course " + courseNumber + " - " + courseName);
        System.out.println();
        
        printModules();
    }
    
    /**
     * This prints out all the modules that exist in this course as well as their details.
     */
    private void printModules()
    {
        if(module1 != null) module1.print();
        if(module2 != null) module2.print();
        if(module3 != null) module3.print();
        if(module4 != null) module4.print();
    }
    
   public void printGrade()
   {
       if(noModules == MAX_MODULES)
       {
           totalMark = 0;
           
           addMark(module1);
           addMark(module2);
           addMark(module3);
           addMark(module4);
           
           if(totalCredits == MAX_MODULES *  Module.CREDIT)
           {
               System.out.println("Your final  mark is " + meanMark + 
                                  " your final grade is " + calculateGrade());
           }
           else
           {
               System.out.println("You have not completed the course yet!");
            }
       }
   }
   
   private void addMark(Module module)
   {
       if(module.isComplete())
       {
           totalMark = totalMark + module.getMark();
           totalCredits += module.CREDIT;
       }
   }
   
   private String calculateGrade()
   {
       meanMark = totalMark / MAX_MODULES;
       
       if(meanMark <= 40)
       {
           return "F";
       }
       else if(meanMark <= 50)
       {
           return "D";
       }
       else if(meanMark <= 60)
       {
           return "C";
       }
       else if(meanMark <= 70)
       {
           return "B";
       }
       else return "A";
   }
}
