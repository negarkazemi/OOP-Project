package uni;

import base.Person;

import java.util.ArrayList;

public class Student {
    public int id;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public int personID;
    public final int entranceYear;
    public int majorID;
    public String studentID;

    public Student(int personID, int entranceYear, int majorID) {
        this.personID = personID;
        this.entranceYear = entranceYear;
        this.majorID = majorID;
        studentList.add(this);
        this.id = studentList.size();
    }

    public void setStudentCode() {
        String entranceYearString = String.valueOf(this.entranceYear);
        String majorIdString = String.valueOf(this.majorID);
        String idString = String.valueOf(this.id);
        this.studentID = entranceYearString + "0" + majorIdString + "0" + idString;
        Person person = Person.findByID(id);

        if (person == null) {
            System.out.println("Error: No student found with ID " + id);
            return;
        }
        System.out.println(this.studentID);
    }


    public static Student findByID(int ID) {
        for (Student student : studentList) {
            if (student.id == ID) {
                return student;
            }
        }
        System.out.println("No person found with ID: " + ID);
        return null;
    }
}
