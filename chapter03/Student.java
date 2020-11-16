import java.util.*;
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Alex Chorlton
 * @version 1.0
 */
public class Student
{
    private String studentName;
    private String idNumber;
    
    private int credits;
    private Course course;

    /**
     * Create a new student with a full name a school ID number.
     */
    public Student(String fullName, String studentID)
    {
        studentName = fullName;
        idNumber = studentID;
        credits = 0;
    }

    /**
     * This will present the name of the student to the user of the system.
     */
    public String getName()
    {
        return studentName;
    }

    /**
     * Change the pre-existing name of a student to a new one.
     */
    public void changeName(String replacementName)
    {
        studentName = replacementName;
    }

    /**
     * This will present the ID number of the student to the user of the system.
     */
    public String getStudentID()
    {
        return idNumber;
    }

    /**
     * Add some credits to the individual students which have been selected.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }

    public void enrolOnCourse(Course course)
    {
        this.course = course;
    }
    
    /**
     * This will present the number of credits of an individual student to the user of the system.
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * This will present to the user the login details of a student, this is a combination of the students first 4 characters
     * of the students name and the first 3 characters of the students ID number.
     */
    public String getLoginName()
    {
        return studentName.substring(0,4) + idNumber.substring(0,3);
    }
    
    /**
     * This will present to the user the individual students name and ID number as well as their number of credits.
     */
    public void print()
    {
        System.out.println(studentName + ", student ID: " + idNumber + ", credits: " + credits);
        course.print();
    }
    
    public void printCourse()
    {
        course.print();
        course.printGrade();
    }
    
}
