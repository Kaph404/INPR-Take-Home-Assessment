import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Students {
    private ArrayList<Student> students;
    private HashSet<Student> studentSet;

    /**
     * Constructor for the Students class
     */
    public Students() {
        students = new ArrayList<>();
        studentSet = new HashSet<>();
    }

    /**
     * Adds a student to the list
     * @param studentData a CSV String of the relevant student data to add
     */
    public void add(String studentData){
        students.add(new Student(studentData));
    }

    /**
     * Adds a student to the list uses polymorphism
     * @param student the student to add
     */
    public void add(Student student) {
        students.add(student);
    }

    /**
     * Returns a list of students as a list of strings
     * @return the aan Array List of students
     */
    public ArrayList<String> getStudentList() {
        ArrayList<String> register = new ArrayList<>();
        for (Student student : students) {
            register.add(student.toString());
        }
        return register;
    }

    /**
     * Reads the list of students from a CSV file
     */
    public void addStudentsFromFile()  {
        try {
            ArrayList<String> studentList = FileIO.readDataFromFile(FileIO.DATA_FILE);
            for (String studentData : studentList) {
                add(studentData);
            }
        } catch (FileIOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method for the 4th feature in the menu
     * It will initialize the whole list by the file, with a double check
     * Clear the list at first and then load the data from the file
     */
    public void initialize(){
        System.out.println("Are you sure you want to initialize the data?");
        while (true){
            int initialize = Input.getValidInt("Enter 1 to continue or enter 2 to cancel: ");
            if(initialize == 1) {
                //initialize part
                students.clear();
                addStudentsFromFile();
                break;
            }else if (initialize == 2) {
                break;
            }else {
                System.out.println("Invalid input");
            }
        }
    }

    /**
     * Prints the list of students
     */
    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Searching method
     * Check the data for all the students, whenever the first name and last name matches the name or partial name,
     * print the student and make a count
     * After finished, show how many matches are there in this searching
     * @param name - the name or partial name to search for
     * @return null  Because this method will work without returning anything
     */
    public Student searchStudentByName(String name) {
        int counter = 0;
        for (Student student: students) {
            String[] data = student.toString().split(",");
            if ((data[0] + data[1]).toLowerCase().contains(name.replace(" ", "").toLowerCase()) ) {
                System.out.println(student);
                //count the matches
                counter++;
            }
        }
        //For grammar
        if (counter < 2) {
            System.out.println("There is " + counter + " match");
        }else {
            System.out.println("There are " + counter + " matches");
        }
        return null;
    }

    /**
     * Saves the current list of students to a CSV file
     */
    public void saveStudentsToFile() {
        try {
            FileIO.writeDataToFile(FileIO.DATA_FILE, this);
        } catch (FileIOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method that selects a random student from the list with no repeats,
     * every time after generating random students, show how many students left in the list that haven't been selected
     * Once all students have been selected - print "All students have been selected, starting for a new round",
     * then start the new round
     * @return the random student
     */
    public Student getRandomStudentNoRepeats() {
        //Using hash set to keep the students that have been selected

        while (true) {
            boolean repeated = false;
            Student RandomStudent = students.get(new Random().nextInt(students.size()));
            for (Student student : studentSet) {
                if (student.equals(RandomStudent)) {
                    repeated = true;
                    break;
                }
            }
            //Hash set will not accept a same data again
            studentSet.add(RandomStudent);
            if (!repeated) {
                int left = students.size()-studentSet.size();
                System.out.println("There are " + left + " students haven't been selected");
                if(students.size()==studentSet.size()){
                    System.out.println("All students have been selected, starting for a new round");
                    studentSet.clear();
                }
                return RandomStudent;
            }
        }
    }
}
