public class VariablesAndNames {
	public static void main(String[] args) {
		int cars, drivers, passengers, cars_not_driven, cars_driven;
		double space_in_a_car, carpool_capacity, average_passengers_per_car;
		//100 cars
		cars = 100;
		//amount of space in car
		space_in_a_car = 4.0;
		//number of drivers
		drivers = 30;
		//number of passengers
		passengers = 90;
		//available cars
		cars_not_driven = cars - drivers;
		//driven cars
		cars_driven = drivers;
		//number for carpool capacity
		carpool_capacity = cars_driven * space_in_a_car;
		//average passengers per car
		average_passengers_per_car = passengers / cars_driven;

		System.out.println("There are " + cars + " cars available.");
		System.out.println("There are only " + drivers + " drivers available.");
		System.out.println("There will be " + cars_not_driven + " empty cars today.");
		System.out.println("We can transport " + carpool_capacity + " people today.");
		System.out.println("We have " + passengers + " to carpool today.");
		System.out.println("We need to put about " + average_passengers_per_car + " in each car.");

	}
}