import java.util.Scanner;

/**
 * A helper class to handle user input.
 */
public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Darren gave us this two methods，but I didn't use it, for preventing some bugs.
     * @param prompt input prompt to tell users what to enter
     * @return the int input
     */
    public static int getInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt);
            scanner.next();
        }
        return scanner.nextInt();
    }

    /**
     * Darren gave us this two methods，but I didn't use it, for preventing some bugs.
     * @param prompt input prompt to tell users what to enter
     * @return the String input
     */
    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }


    /**
     * Method to get the String input
     * Won't accept empty input
     * @param prompt input prompt to tell users what to enter
     * @return the String input without any blanks
     */
    public static String getValidString(String prompt) {
        while (true) {
            System.out.println(prompt);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.replace(" ", "").isEmpty()) {
                System.out.println("Invalid input.\n");
            } else {
                return input.replace(" ", "");
            }
        }
    }


    /**
     * Method to get the int input
     * Won't accept empty input
     * Only accept the input with letters and "-"
     * @param prompt input prompt to tell users what to enter
     * @return the Name input without any blanks
     */
    public static int getValidInt(String prompt) {
        while(true){
            System.out.println(prompt);
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if(choice.trim().matches("[0-9]+")){
                return Integer.parseInt(choice.trim());
            }else{
                System.out.println("Invalid input.");
            }
        }
    }


    /**
     * Method to get the name input
     * Won't accept empty input
     * Only accept the input with letters and "-"
     * @param prompt input prompt to tell users what to enter
     * @return the Name input without any blanks
     */
    public static String getName(String prompt) {
        String name = getValidString(prompt);
        while (!name.matches("[a-zA-Z- ]+")){
            System.out.println("Invalid input.");
            name = getValidString(prompt);
        }
        return name;
    }

    /**
     * Method to get the country input
     * Won't accept empty input
     * Only accept the input with letters
     * @param prompt input prompt to tell users what to enter
     * @return the country input without any blanks
     */
    public static String getCountry(String prompt) {
        String country = getValidString(prompt);
        while(!country.trim().matches("[A-Za-z]+")) {
            System.out.println("Invalid input.");
            country = getValidString(prompt);
        }
        return country;
    }


    /**
     * Method to get the Age input
     * Won't accept empty input
     * Only accept the integer input
     * Age should be in the range of [0,122], because the eldest people in the world is 122 years old
     * @param prompt input prompt to tell users what to enter
     * @return the Name input without any blanks
     */
    public static int getAge(String prompt) {
        int input = getValidInt(prompt);
        while(input<0||input>122) {
            System.out.println("Invalid input. ");
            input = getValidInt(prompt);
        }
        return input;
    }
}