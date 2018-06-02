import java.io.ObjectInputStream.GetField;
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

		String menuChoice = "";

		Boolean hasQuit = false;
		do {

			hasQuit = false;
			petStatus(shelter);
			petMenu();
			menuChoice = input.nextLine();

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
				String name = input.nextLine();
				name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
				shelter.petSinglePet(name);
				shelter.tick();
				System.out.println("Meow!\n");

				break;

			case "4":

				System.out.println("Who would you like to adopt?");
				for (VirtualPet pet : shelter.getPets()) {

					System.out.println(pet.getName() + "\t|" + pet.getDescription());
				}

				String nameAdopt = input.next();
				VirtualPet pet = shelter.getAPet(nameAdopt);
				shelter.adoptPet(pet);
				System.out.println("Congratulations! You just adopted " + nameAdopt);

				break;

			case "5":

				System.out.println("Who would you like to admit?");
				String admitName = input.nextLine();
				System.out.println("Please describe your pet.");
				String admitDesc = input.nextLine();
				VirtualPet admitPet = new VirtualPet(admitName, admitDesc);
				shelter.addPet(admitPet);
				System.out.println("Thank you for admitting " + admitName + "!");

				break;

			case "6":

				System.out.println("Thank you for visiting the shelter! Goodbye!");
				System.exit(0);

				break;

			default:

				menuChoice = input.nextLine();

				break;
			}

		} while (!hasQuit);

	}

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
