package uni;

import java.util.ArrayList;

public class PresentedCourse {

    public int id;
    public static ArrayList<PresentedCourse> presentedCourseList = new ArrayList<>();
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIds;
    public int studentCounter = 0;

    public PresentedCourse(int courseID, int professorID, int maxCapacity) {

        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = maxCapacity;
        studentIds = new ArrayList<>(capacity);
        presentedCourseList.add(this);
        id = presentedCourseList.size();


    }

    public static PresentedCourse findByID(int ID) {
        for (PresentedCourse presentedCourse : presentedCourseList) {
            if (presentedCourse.id == ID) {
                return presentedCourse;
            }
        }
        System.out.println("No presented course found with ID: " + ID);
        return null;
    }

    public void addStudent(int newStudentID) {
        if (studentCounter <= capacity)
            studentIds.add(newStudentID);
        else
            System.out.println("The capacity has been completed.");
        studentCounter++;

    }


}
