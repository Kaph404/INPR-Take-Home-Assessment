import java.util.Scanner;

/**
 * Complete  the Menu class that displays a menu of options to the user and allows the user to interact with the
 * Students class.
 * Add methods / code to support all the options below.
 * The code should loop until the user chooses to exit.
 */
public class Menu {
    private final String[] menuItems = {
            "1.Add student",
            "2.Print students",
            "3.Save students to file",
            "4.Load students from file",
            "5.Select random student with no repeats",
            "6.Search for student by name",
            "7.Exit"
    };

    /**
     * Method that allow the user to use the menu to operate the system
     * Will not accept invalid input
     * @param students
     */
    public void showMenu(Students students) {
        while(true){
            for(String menuItem : menuItems) {
                System.out.println(menuItem);
            }
            int choice = Input.getValidInt("Please enter your choice: ");
            boolean exit = false;
            switch(choice) {
                case 1:
                    students.add(
                            new Student(
                                    Input.getName("Enter student first name"),
                                    Input.getName("Enter student last name"),
                                    Input.getAge("Enter student age"),
                                    Input.getValidString("Enter student group"),
                                    Input.getCountry("Enter student country")
                            )
                    );
                    break;
                case 2:
                    students.printStudents();
                    break;
                case 3:
                    students.saveStudentsToFile();
                    break;
                case 4:
                    //initialize the list with a double check
                    students.initialize();
                    break;
                case 5:
                    //print the format name instead of printing the whole message
                    System.out.println(students.getRandomStudentNoRepeats().getStudentName());
                    break;
                case 6:
                    students.searchStudentByName(Input.getName("Enter student name"));
                    break;
                case 7:
                    exit = true;
                    break;
                //avoid invalid input
                default:
                    System.out.println("Invalid input.");
                    break;
            }
            if(exit) {
                System.out.println("System closed");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        Students students = new Students();
        students.addStudentsFromFile();
        menu.showMenu(students);
    }
}
