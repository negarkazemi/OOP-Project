package uni;

import java.util.ArrayList;


public class Major {
    public int id;
    public static ArrayList<Major> majorList = new ArrayList<>();
    public String name;
    public final int capacity;
    public int numberOfStudents = 0;


    public Major(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        majorList.add(this);
        this.id = majorList.size();
    }


    public static Major findByID(int ID) {
        for (Major major : majorList) {
            if (major.id == ID) {
                return major;
            }
        }
        System.out.println("No major found with ID: " + ID);
        return null;
    }


    public void addStudent() {
        if (this.numberOfStudents <= this.capacity)
            numberOfStudents++;
        else
            System.out.println("The capacity has been completed");
    }

}
