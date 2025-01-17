import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
/**
 * A helper class to handle read and write CSV file data.
 */
public class FileIO {
    //Path of file to read from in project directory
    public static final String DATA_FILE = "data/fakeClass.csv";
    /**
     * Writes a list of strings to a file, each string on a new line.
     *
     * @param fileName The name of the file to write to.
     * @param students The list of strings to write to the file.
     */
public static void writeDataToFile(String fileName, Students students) throws FileIOException {
    try {
        // Path is used here to create directories if they don't exist
        // converts the string to a Path object
        Path filePath = Path.of(fileName);
        // method createDirectories creates all directories in the path
        // if they don't exist
        Files.createDirectories(filePath.getParent());
        ArrayList<String> registerData = students.getStudentList();
        List<String> lines = new ArrayList<>(registerData);
        Files.write(filePath, lines);
    } catch (IOException e) {
        throw new FileIOException(fileName + " file can't be written to. Error: " + e.getMessage());
    }
}

public static ArrayList<String> readDataFromFile(String fileName) throws FileIOException {
    ArrayList<String>  students = new ArrayList<>();
    try {
        List<String> lines = Files.readAllLines(Path.of(fileName));
        students.addAll(lines);
    } catch (IOException e) {
        throw new FileIOException(fileName + " file can't be read. Error: " + e.getMessage());
    }
    return students;
}
}
