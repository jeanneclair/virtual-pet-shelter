import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPetShelter shelter = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet("Junebug", "friendly tuxedo cat", 30, 40, 35);
		VirtualPet pet2 = new VirtualPet("Rainbow", "fiesty calico cat", 35, 45, 40);
		VirtualPet pet3 = new VirtualPet("Copper", "shy tabby cat", 40, 35, 38);
		VirtualPet pet4 = new VirtualPet("Louie", "beautiful Russian blue cat", 33, 44, 38);

		shelter.pets.put("Junebug", pet1);
		shelter.pets.put("Rainbow", pet2);
		shelter.pets.put("Copper", pet3);
		shelter.pets.put("Louie", pet4);

		String menuChoice;

		Boolean gameRunning = false;
		
		String intro = "Welcome to the Virtual Pet Shelter. Thank you for volunteering. Please feed and water all the cats. "
				+ "\nSome of them may be tired or busy playing with their friends. So don't worry so much if they don't eat or drink a lot."
				+ "\nWe encourage you to play with the cats one at a time. It will make them happy!\n";

		System.out.println(intro);
		while (gameRunning = true) {

			do {

				petStatus(shelter);
				petMenu();
				menuChoice = input.nextLine();

			} while (!menuChoice.equals("1") && !menuChoice.equals("2") & !menuChoice.equals("3")
					&& !menuChoice.equals("4") && !menuChoice.equals("5") && !menuChoice.equals("6"));

			switch (menuChoice) {
			case "1":
				shelter.feedAllPets();
				shelter.tick();
				System.out.println("Yum!\n");

				break;

			case "2":
				shelter.waterAllPets();
				shelter.tick();
				System.out.println("Slurp!\n");

				break;

			case "3":

				System.out.println("Who would you like to play with?");
				String playName = input.nextLine();
				playName = playName.substring(0, 1).toUpperCase() + playName.substring(1).toLowerCase();
				shelter.petSinglePet(playName);
				shelter.tick();
				System.out.println("\nMeow! Thanks for playing with " + playName + "!\n");

				break;

			case "4":

				System.out.println("\nWho would you like to adopt?\n");
				for (VirtualPet pet : shelter.getPets()) {

					System.out.println(pet.getName() + "\t|" + pet.getDescription());
				}

				String adoptName = input.next();
				adoptName = adoptName.substring(0, 1).toUpperCase() + adoptName.substring(1).toLowerCase();
				VirtualPet pet = shelter.getAPet(adoptName);
				shelter.adoptPet(pet);
				System.out.println("\nCongratulations! You just adopted " + adoptName + "!\n");

				break;

			case "5":

				System.out.println("\nWho would you like to admit?\n");
				String admitName = input.nextLine();
				admitName = admitName.substring(0, 1).toUpperCase() + admitName.substring(1).toLowerCase();
				System.out.println("\nPlease describe your pet.\n");
				String admitDesc = input.nextLine();
				System.out.println("How hungry is your pet?");
				int admitHunger = input.nextInt();
				System.out.println("How thirsty is your pet?");
				int admitThirst = input.nextInt();
				System.out.println("How happy is your pet?");
				int admitHappiness = input.nextInt();
				VirtualPet admitPet = new VirtualPet(admitName, admitDesc, admitHunger, admitThirst, admitHappiness);
				shelter.addPet(admitName, admitPet);
				System.out.println("\nThank you for admitting " + admitName + "!\n");

				break;

			case "6":

				System.out.println("\nThank you for visiting the shelter! Goodbye!");
				System.exit(0);

				break;

			} // end switch statement

		} //end while loop
		input.close();


	} // end main method

	private static void petMenu() {
		System.out.println("\nWhat would you like to do now?\n");
		System.out.println("1. Feed the pets.");
		System.out.println("2. Water the pets.");
		System.out.println("3. Play with a pet.");
		System.out.println("4. Adopt a pet.");
		System.out.println("5. Admit a pet.");
		System.out.println("6. Quit.");

	}

	private static void petStatus(VirtualPetShelter shelter) {
		System.out.println("This is the status of your pets:\n");
		System.out.println("Name \t|Hunger |Thirst |Happiness");
		System.out.println("----------------------------------");

		for (VirtualPet pet : shelter.getPets()) {

			System.out.println(
					pet.getName() + "\t|" + pet.getHunger() + "\t|" + pet.getThirst() + "\t|" + pet.getHappiness());

		}
	}

}
