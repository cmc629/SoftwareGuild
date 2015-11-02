import java.util.Scanner;

public class BMICalc {

	public static void main(String[] args) {

		int feet, inches, pounds;

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Your height (feet only): ");
		feet = keyboard.nextInt();

		System.out.print("Your height (inches): ");
		inches = keyboard.nextInt();

		System.out.print("Your weight in pounds: ");
		pounds = keyboard.nextInt();

		double m = (12 * feet + inches) * 0.0254;
		double kg = pounds * 0.453592;
		double bmi = kg / (m * m);

		System.out.println("\nYour BMI is " + bmi);
	}
}