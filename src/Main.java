import base.Person;
import uni.*;

public class Main {
    public static void main(String[] args) {
        Person gholi = new Person("Gholi", "1");
        Person akram = new Person("Akram", "2");
        Person asghar= new Person("Asghar", "3");
        Person mahin = new Person("Mahin", "4");
        Person karim = new Person("Karim", "5");

        Major CS = new Major("Computer Science", 45);
        Major EE = new Major("Electrical Engineering", 80);

        System.out.println("STUDENTS IDS  ------------------------------------------------------\n");

        Major major1 = Major.findByID(1);
        Major major2 = Major.findByID(2);

        Student gholiStudent = new Student(1, 402, 1);
        major1.addStudent();
        Student akramStudent = new Student(2, 402, 1);
        major1.addStudent();
        Student asgharStudent = new Student(3, 401, 2);
        major2.addStudent();


            for (int i = 1; i <= major1.numberOfStudents + major2.numberOfStudents; i++) {
                Person person = Person.findByID(i);
                Student student = Student.findByID(i);
                if (person != null && student != null) {
                    System.out.println(person.name + "'s Student ID: ");
                    student.setStudentCode();
                }
            }

        System.out.println("\n\n");


        System.out.println("PROFESSORS ----------------------------------------------------------\n");

        Professor mahinProfessor = new Professor(4,1);
        Professor karimProfessor = new Professor(5,2);

        for (int i = 1; i <= Professor.professorList.size(); i++) {
            Professor professor = Professor.findByID(i);

            if (professor != null) {
                int personalNumber = professor.personID;
                Person person = Person.findByID(personalNumber);

                if (person != null) {
                    System.out.println(person.name + ",         Professor ID: " + professor.id);
                } else {
                    System.out.println("Warning: No person found with ID " + personalNumber);
                }
            } else {
                System.out.println("Warning: No professor found with ID " + i);
            }
        }

        System.out.println("\n\n");

        Course AP = new Course("Advanced Programing", 4);
        Course DS = new Course("Data Structure", 4);
        Course EC = new Course("Electrical Circuits", 3);

        PresentedCourse PresentedAP = new PresentedCourse(1, 1, 25);
        PresentedCourse PresentedDS = new PresentedCourse(2, 1, 30);
        PresentedCourse PresentedEC = new PresentedCourse(3, 2, 60);


        PresentedCourse.findByID(1).addStudent(1);
        PresentedCourse.findByID(1).addStudent(2);
        PresentedCourse.findByID(2).addStudent(1);
        PresentedCourse.findByID(2).addStudent(2);
        PresentedCourse.findByID(2).addStudent(3);
        PresentedCourse.findByID(3).addStudent(3);


        Transcript gholiTranscript = new Transcript(1);
        Transcript akramTranscript = new Transcript(2);
        Transcript asgharTranscript = new Transcript(3);

        gholiTranscript.setGrade(AP.id, 19.25);
        gholiTranscript.setGrade(DS.id, 18);

        akramTranscript.setGrade(AP.id, 17);
        akramTranscript.setGrade(DS.id, 16.75);

        asgharTranscript.setGrade(DS.id, 18.88);
        asgharTranscript.setGrade(EC.id, 16);

        System.out.println("TRANSCRIPTS  ---------------------------------------------------------\n");

        gholiTranscript.printTranscript();
        double gholiGPA = gholiTranscript.getGPA();
        System.out.println("Weighted GPA: " + gholiGPA + "\n");
        akramTranscript.printTranscript();
        double akramGPA = akramTranscript.getGPA();
        System.out.println("Weighted GPA: " + akramGPA + "\n");
        asgharTranscript.printTranscript();
        double asgharGPA = asgharTranscript.getGPA();
        System.out.println("Weighted GPA: " + asgharGPA + "\n");



    }
}