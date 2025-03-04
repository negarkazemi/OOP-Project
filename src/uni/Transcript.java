package uni;

import base.Person;

import java.util.HashMap;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript;

    public Transcript(int studentID) {
        this.studentID = studentID;
        transcript = new HashMap<>();
    }

    public void setGrade(int presentedCourseID, double grade) {
        PresentedCourse presentedCourse = PresentedCourse.findByID(presentedCourseID);
        if (presentedCourse!=null && presentedCourse.studentIds.contains(studentID))
            transcript.put(presentedCourseID, grade);
        else
            System.out.println("Student is not registered for this course.");
    }

    public void printTranscript() {
        Person person = Person.findByID(studentID);
        Student student = Student.findByID(studentID);
        if (person != null && student != null) {
            System.out.println("Name: " + person.name);
            System.out.println("Student ID: " + student.studentID);
        }

        for (int courseID : transcript.keySet()) {
            Course course = Course.findByID(courseID);
            if (course != null) {
                System.out.println("Course: " + course.title + ",      Grade: " + transcript.get(courseID));
            }
        }
    }

    public double getGPA() {
        double gradeSum = 0;
        int totalUnits = 0;
        for (int courseID : transcript.keySet()) {
            Course course = Course.findByID(courseID);
            if (course != null) {
                gradeSum = gradeSum + transcript.get(courseID) * course.units;
                totalUnits = totalUnits + course.units;
            }
        }

        return gradeSum / totalUnits;


    }
}
