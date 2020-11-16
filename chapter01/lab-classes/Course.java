
/**
 * Write a description of class Course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Course
{
    // instance variables - replace the example below with your own
    private String courseName;
    private String courseID;

    /**
     * Constructor for objects of class Course
     */
    public Course(String courseName, String courseID)
    {
        // initialise instance variables
        this.courseName = courseName;
        this.courseID = courseID;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void print()
    {
        // put your code here
        System.out.println("course "+ courseName +" ID "+courseID);
    }
}
