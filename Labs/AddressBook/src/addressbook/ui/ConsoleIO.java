package addressbook.ui;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Damien Marble
 */
public class ConsoleIO {

    private final Scanner in;
    private final PrintStream out;

    public ConsoleIO(InputStream in, OutputStream out) {
        this.in = new Scanner(in);
        this.out = new PrintStream(out);
    }

    public ConsoleIO() {
        this(System.in, System.out);
    }

    /**
     * Prompts the user to enter an [code]int[/code]. Prints the given String
     * message and waits for the user to enter a value, which it will parse and
     * return.
     * <br>
     * This class makes no attempt to ensure that the user input is valid and
     * will throw NumberFormatException if input that cannot be parsed is given;
     * It is the responsibility of the calling class to decide how to handle
     * invalid input.
     *
     * @param message the prompt message
     * @return the entered int
     */
    public int promptForInt(String message)
            throws NumberFormatException {
        println(message);
        return Integer.parseInt(in.nextLine());
    }

    /**
     * Prompts the user to enter an [code]int[/code] within the given range.
     * Prints the given String message and waits for the user to enter a value,
     * which it will parse and return.
     * <br>
     * If the value entered by the user falls outside the given range, an error
     * message is printed and the user is prompted again.
     * <br>
     * This class makes no attempt to ensure that the user input is valid beyond
     * that, if it can be parsed, it will fall within the given range, and will
     * throw NumberFormatException if input that cannot be parsed is given; It
     * is the responsibility of the calling class to decide how to handle
     * invalid input.
     *
     * @param message the prompt message
     * @return the entered int
     */
    public int promtForIntInRange(String message, int min, int max) throws NumberFormatException {
        int input = min - 1;
        println(message);
        input = Integer.parseInt(in.nextLine());
        while (input < min || input > max) {
            println(String.format("Your number needs to be between %d and %d.", min, max));
            input = Integer.parseInt(in.nextLine());
        }
        return input;
    }

    /**
     * Prompts the user to enter a [code]String[/code]. Prints the given string
     * message and waits for the user to enter a value, which it will return.
     *
     * @param message the prompt message
     * @return the entered string
     */
    public String promptForString(String message) {
        println(message);
        return in.nextLine();
    }

    /**
     * Prompts the user to enter a [code]float[/code]. Prints the given string
     * message and waits for the user to enter a value, which it will parse and
     * return.
     * <br>
     * This class makes no attempt to ensure that the user input is valid and
     * will throw NumberFormatException if input that cannot be parsed is given;
     * It is the responsibility of the calling class to decide how to handle
     * invalid input.
     *
     * @param message the prompt message
     * @return the entered float
     */
    public float promptForFloat(String message) throws NumberFormatException {
        println(message);
        return Float.parseFloat(in.nextLine());
    }

    /**
     * Prompts the user to enter a [code]float[/code] within the given range.
     * Prints the given string message and waits for the user to enter a value,
     * which it will parse and return.
     * <br>
     * If the value entered by the user falls outside the given range, an error
     * message is printed and the user is prompted again.
     * <br>
     * This class makes no attempt to ensure that the user input is valid and
     * will throw NumberFormatException if input that cannot be parsed is given;
     * It is the responsibility of the calling class to decide how to handle
     * invalid input.
     *
     * @param message the prompt message
     * @return the entered float
     */
    public float promptForFloatInRange(String message, float min, float max) throws NumberFormatException {
        println(message);
        float result = Float.parseFloat(in.nextLine());
        while (result < min || result > max) {
            println(String.format("Your number needs to be between %d and %d.", min, max));
            result = Float.parseFloat(in.nextLine());
        }
        return result;
    }

    /**
     * Prompts the user to enter a [code]double[/code]. Prints the given string
     * message and waits for the user to enter a value, which it will parse and
     * return.
     * <br>
     * This class makes no attempt to ensure that the user input is valid and
     * will throw NumberFormatException if input that cannot be parsed is given;
     * It is the responsibility of the calling class to decide how to handle
     * invalid input.
     *
     * @param message the prompt message
     * @return the entered float
     */
    public double promptForDouble(String message) throws NumberFormatException {
        println(message);
        return Double.parseDouble(in.nextLine());
    }

    /**
     * Prompts the user to enter a [code]double[/code] within the given range.
     * Prints the given string message and waits for the user to enter a value,
     * which it will parse and return.
     * <br>
     * If the value entered by the user falls outside the given range, an error
     * message is printed and the user is prompted again.
     * <br>
     * This class makes no attempt to ensure that the user input is valid and
     * will throw NumberFormatException if input that cannot be parsed is given;
     * It is the responsibility of the calling class to decide how to handle
     * invalid input.
     *
     * @param message the prompt message
     * @return the entered float
     */
    public double promptForDoubleInRange(String message, float min, float max) throws NumberFormatException {
        println(message);
        double result = Double.parseDouble(in.nextLine());
        while (result < min || result > max) {
            println(String.format("Your number needs to be between %d and %d.", min, max));
            result = Float.parseFloat(in.nextLine());
        }
        return result;
    }

    /**
     * Prints out the given message followed by a new line.
     *
     * @param message the message to print
     */
    public void println(String message) {
        out.println(message);
    }

    /**
     * Prints out the given message.
     *
     * @param message the message to print
     */
    public void print(String message) {
        out.print(message);
    }
}
