import java.util.Scanner;

public class MoreUserInputOfData {
	
	public static void main(String[] args) {

		String first, last, login;
		int grade, id;
		double gpa;

		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please enter the following information so I can sell it for a profit!");

		System.out.print("\nFirst name: ");
		first = keyboard.next();

		System.out.print("Last Name: ");
		last = keyboard.next();

		System.out.print("Grade (9-12): ");
		grade = keyboard.nextInt();

		System.out.print("Student ID: ");
		id = keyboard.nextInt();

		System.out.print("Login: ");
		login = keyboard.next();

		System.out.print("GPA (0.0-4.0): ");
		gpa = keyboard.nextDouble();

		System.out.println("Your information:");
		System.out.println("Login: " + login);
		System.out.println("ID: " + id);
		System.out.println("Name: " + last + ", " + first);
		System.out.println("GPA: " + gpa);
		System.out.println("Grade: " + grade);
	}
}