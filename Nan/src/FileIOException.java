/**
 * FileIOException is a custom exception class that extends the Exception class.
 * It is used to handle exceptions that occur when reading or writing to a file.
 */
public class FileIOException extends Exception {
    public FileIOException(String message) {
        super(message);
    }
}

