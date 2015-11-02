import java.util.Scanner;

public class NameAgeAndSalary {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String name;
		int age;
		double salary;

		System.out.println("Hello. What is your name?");
		name = sc.nextLine();

		System.out.println("Hi, " + name + "! How old are you?");
		age = sc.nextInt();

		System.out.println("So you're " + age + ", eh? That's not old at all!" + 
			"\nHow much do you make, " + name + "?");
		salary = sc.nextDouble();

		System.out.println(salary + "! I hope that's per hour and not per year! LOL!");

	}
}