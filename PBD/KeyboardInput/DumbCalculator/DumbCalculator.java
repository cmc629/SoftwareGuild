import java.util.Scanner;

public class DumbCalculator {
	public static void main(String[] args) {

		double first, second, third, answer;

		Scanner keyboard = new Scanner(System.in);

		System.out.print("What is your first number? ");
		first = keyboard.nextDouble();

		System.out.print("What is your second number? ");
		second = keyboard.nextDouble();

		System.out.print("What is your third number? ");
		third = keyboard.nextDouble();

		answer = (first + second + third)/2;

		System.out.println("( " + first + " + " + second + " + " +
			third + " ) / 2 is... " + answer);

	}
}