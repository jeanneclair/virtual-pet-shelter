import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();
	Collection<VirtualPet> petValues = pets.values();

	public Collection<VirtualPet> getPets() {

		return pets.values();
	}

	public VirtualPet getAPet(String name) {

		return pets.get(name);
	}

	public void addPet(VirtualPet pet) {

		pets.put(pet.getName(), pet);
	}

	public void adoptPet(VirtualPet pet) {

		pets.remove(pet.getName(), pet);
	}

	public void feedAllPets() {

		for (VirtualPet pet : petValues) {
			pet.feed(-Math.floor(Math.random() * 10));
			pet.addHappiness();

		}
	}

	public void waterAllPets() {

		for (VirtualPet pet : petValues) {
			pet.water(Math.floor(Math.random() * 10));
			pet.addHappiness();

		}
	}

	public void petSinglePet(String name) {

		VirtualPet pet = pets.get(name);
		pet.addHappiness();

		// happiness += petted;

	}
	
	public void tick() {
		
		for (VirtualPet pet : petValues) {
			pet.feed(-2);
			pet.water(-2);
			pet.pet(2);
				
		}
	}
 }
