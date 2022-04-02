import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		//Ask the user to enter the number of cars to be created + create them
		Scanner input1 = new Scanner(System.in);
		String numberOfCars;
		// Test the validity of the input value
		while (true) {
			System.out.print("Enter the number of the new cars: ");
			numberOfCars = input1.nextLine();
			// check if numeric 
			if (!numberOfCars.matches("-?\\d+(\\.\\d+)?")) {
				System.out.println("Please enter a positive numeric value!");
			}
			// check if positive 
			else if (Integer.valueOf(numberOfCars) < 0) {
				System.out.println("Please enter a positive numeric value!");
			} else {
				break;
			}
		}
		// Create a new object for each car
		Car[] newCar = new Car[Integer.valueOf(numberOfCars)];
		int carIndex = 0;
		while (Integer.valueOf(numberOfCars) > carIndex) {
			newCar[carIndex] = new Car();
			// ask the user if any action has been taken on the car
			newCar[carIndex].checkCar();
			carIndex++;			
		}
		// Print cars informations
		System.out.println();
		System.out.println("*************************************");
		System.out.println("Number of cars enterd " + numberOfCars);
		System.out.println("*************************************");
		for (int i = 0; i < newCar.length; i++) {
			newCar[i].showCarInfo();
		}
		input1.close();
	}
}
