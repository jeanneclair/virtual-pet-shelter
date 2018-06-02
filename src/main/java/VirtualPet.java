
public class VirtualPet {
	
	private String name;
	private String description;
	private int hunger;
	private int thirst;
	private int happiness;
	
	
	
	public String getName() {
		return name;
	}



	public String getDescription() {
		return description;
	}



	public int getHunger() {
		return hunger;
	}



	public int getThirst() {
		return thirst;
	}



	public int getHappiness() {
		return happiness;
	}



	public VirtualPet(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}



	public VirtualPet(String name, String description, int hunger, int thirst, int happiness) {
		super();
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.happiness = happiness;
	}
	


	public int feed(double fed) {

		hunger -= Math.floor(Math.random() * 10);
		thirst += .10*thirst;
		happiness += .10*happiness;

		if (hunger < 0) {
			
			return hunger = 0;
			
		} else {
			
			return hunger;
		}

	}

	public int water(double watered) {

		thirst -= Math.floor(Math.random() * 10);
		happiness += .10*happiness;

		if (thirst < 0) {

			return thirst = 0;

		} else {

			return thirst;
		}

	}

	public int pet(int petted) {

		happiness += Math.floor(Math.random() * 10);

		if (happiness > 100) {

			return happiness = 100;

		} else if (happiness < 0) {
			
			return happiness = 0;
			
		} else {

			return happiness;
		}

	}

	public void addHappiness() {
		
		if (hunger >= 50 || thirst >= 50) {
			
			happiness -= 50;
			
		} else {

			happiness += Math.floor(Math.random() * 5);
		}
		
	}
	
}

