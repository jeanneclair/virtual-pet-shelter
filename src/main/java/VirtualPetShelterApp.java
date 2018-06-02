import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		VirtualPetShelter shelter = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet("Junebug", "friendly tuxedo cat", 30, 40, 50);
		VirtualPet pet2 = new VirtualPet("Rainbow", "fiesty calico cat", 35, 45, 45);
		VirtualPet pet3 = new VirtualPet("Copper", "shy tabby cat", 40, 35, 40);
		VirtualPet pet4 = new VirtualPet("Louie", "snobby Russian blue cat", 33, 44, 55);

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
				shelter.petSinglePet(name);
				shelter.tick();
				System.out.println("Meow!");
				
				break;
				
//			case "4":
//				
//				System.out.println("Who would you like to adopt?");
//				 = input.next();
//				shelter.adoptPet(pet);
//				System.out.println("Meow!");
//				
//				break;
//			
//			case "5":
//				
//				System.out.println("Who would you like to admit?");
//				 = input.next();
//				shelter.addPet(pet);
//				System.out.println("Meow!");
//				
//				break;
				
			case "6":
				
				System.out.println("You have left the shelter! Goodbye!");
				System.exit(0);
				
				break;

			default:
				
				System.out.println("Not a valid action. Goodbye.");
				hasQuit = true;
				input.close();
				break;
			}
			
		} while (!hasQuit);
		
	}


	private static void petMenu() {
		System.out.println("\nWhat would you like to do now?\n");
		System.out.println("1. Feed the pets.");
		System.out.println("2. Water the pets.");
		System.out.println("3. Play with the pets.");
		System.out.println("4. Adopt a pet.");
		System.out.println("5. Admit a pet.");
		System.out.println("6. Quit.");
		// Scanner input = new Scanner(System.in);
		// Object menuChoice = input.nextLine();

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
