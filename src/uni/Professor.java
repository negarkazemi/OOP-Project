package uni;

import java.util.ArrayList;

public class Professor {
    public int id;
    public static ArrayList<Professor> professorList = new ArrayList<>();
    public int personID;
    public int majorID;

    public Professor(int personID, int majorID) {
        this.personID = personID;
        this.majorID = majorID;
        professorList.add(this);
        this.id = professorList.size();
    }

    public static Professor findByID(int ID) {
        for (Professor professor : professorList) {
            if (professor.id == ID) {
                return professor;
            }
        }
        System.out.println("No professor found with ID: " + ID);
        return null;
    }


}
