import java.util.Scanner;

public class Car {
	// declare car variables
	private String carBrand;
	private String carModel;
	private int carID;
	private double carDebit = 0;
	private double carCredit = 0;
	private double carSolde = 0;
	public static int carIDCounter = 0;

	Scanner input2 = new Scanner(System.in);

	// Constructor
	public Car() {
		// increment car Id and assign it to the new Car
		carIDCounter++;
		carID = carIDCounter;
		// Ask the user for information about the car and assign them to the dedicated
		// variables
		System.out.print("Car Brand " + carIDCounter + " : ");
		this.carBrand = input2.nextLine();
		// check if a valid string was entered
		while (true) {
			if (carBrand.isBlank() || carBrand.isEmpty()) {
				System.out.println("Please enter a valid Car Brand! ");
				System.out.print("Car Brand " + carIDCounter + " : ");
				this.carBrand = input2.nextLine();
			} else {
				break;
			}
		}
		System.out.print("Car Model " + carIDCounter + " : ");
		this.carModel = input2.nextLine();
		// check if a valid string was entered
		while (true) {
			if (carModel.isBlank() || carModel.isEmpty()) {
				System.out.println("Please enter a valid Car Model! ");
				System.out.print("Car Model " + carIDCounter + " : ");
				this.carModel = input2.nextLine();
			} else {
				break;
			}
		}
	}

	// Method for showing the car's informations
	public void showCarInfo() {
		System.out.println("********************************");
		System.out.println("Info about " + carBrand + " " + carModel);
		System.out.println("********************************");		
		System.out.println(" Car Brand : " + carBrand);
		System.out.println(" Car Model : " + carModel);
		System.out.println(" Car ID : " + carID);
		System.out.println(" Total cost : " + carDebit);
		System.out.println(" Already paid " + carCredit);
		System.out.println(" Left to pay: " + String.format("%.2f", carSolde));
	}

	// check if there any action has been taken on the car
	public void checkCar() {
		System.out.print("Has any action been taken for this car? (Y for yes/N for no) : ");
		String carHasActions = ValidInputYN();
		// Test the validity of the input value
		if (carHasActions.equalsIgnoreCase("y")) {
			// check if the car has been inspected and how much the inspections cost
			System.out.print("Have the car been inspected? :");
			String carInspection = ValidInputYN();
			if (carInspection.equalsIgnoreCase("y")) {
				System.out.print("How much did the inspections cost? : $");
				Double carInspectionCOost = ValidInputDouble();
				carDebit = carDebit + carInspectionCOost;
			}			
			// check if the car has been repaired and how much the repairs cost
			System.out.print("Have the car been repaired? :");
			String carReparation = ValidInputYN();
			if (carReparation.equalsIgnoreCase("y")) {
				System.out.print("How much did the repairs cost? : $");
				Double carReparationCost = ValidInputDouble();
				carDebit = carDebit + carReparationCost;
			}
			// check if the car has been cleaned and how much the cleaning cost
			System.out.print("Have the car been cleaned? :");
			String carCleaning = ValidInputYN();
			if (carCleaning.equalsIgnoreCase("y")) {
				System.out.print("How much did the cleaning cost? : $");
				Double carCleaningCost = ValidInputDouble();
				carDebit = carDebit + carCleaningCost;
			}
			// check if the customer has paid
			if (carDebit > 0) {
				System.out.print("Did the customer payed? : ");
				String clientPaied = ValidInputYN();
				if (clientPaied.equalsIgnoreCase("y")) {
					System.out.print("How much did the customer payed? : $");
					Double clientPaiedValue = ValidInputDouble();
					carCredit = carCredit + clientPaiedValue;
				}
			}
			carSolde = carDebit - carCredit;
		} else {
			System.out.println("No action was recorded on " + carBrand + " " + carModel);
		}
	}

	// function for checking if the user input is "y" or "n" (no case sensitive)
	private String ValidInputYN() {
		String InputYorN;
		while (true) {
			InputYorN = input2.nextLine();
			// check if Y or N (no case sensitive)
			if (!(InputYorN.equalsIgnoreCase("y")) && !(InputYorN.equalsIgnoreCase("n"))) {
				System.out.println("Please enter Y or N. Any other values are forbiden! ");
			} else {
				break;
			}
		}
		return InputYorN;
	}

	// function for checking if the user input contain a valid double value
	private Double ValidInputDouble() {
		String checkDouble;
		while (true) {
			checkDouble = input2.nextLine();
			try {
				Double.parseDouble(checkDouble);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid numerical value!");
				System.out.print("How much was the reparations ? : $");
			}
		}
		return Double.parseDouble(checkDouble);

	}
}
