package base;

import java.util.ArrayList;


public class Person {
    public int id;
    public static ArrayList<Person> personList = new ArrayList<>();
    public String name;
    public String nationalID;

    public Person(String name, String nationalID) {
        this.name = name;
        this.nationalID = nationalID;
        personList.add(this);
        this.id = personList.size();

    }


    public static Person findByID(int ID) {
        for (Person person : personList) {
            if (person.id == ID) {
                return person;
            }
        }
        System.out.println("No person found with ID: " + ID);
        return null;
    }

}
