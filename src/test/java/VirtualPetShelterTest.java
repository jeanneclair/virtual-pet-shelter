import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter shelter = new VirtualPetShelter();

	@Test // should work, but I'm using a random number
	public void shouldReturnTrueWhenFeedAllPet() {
		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Jupiter", new VirtualPet("Jupiter", "grey cat", 50, 50, 50));
		testPetShelter.feedAllPets();

		assertThat(50, equalTo(testPetShelter.getAPet("Jupiter").getHunger()));
	}

	@Test // should work, but I'm using a random number
	public void shouldReturnTrueWhenWaterAllPet() {
		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Jupiter", new VirtualPet("Jupiter", "grey cat", 50, 50, 50));
		testPetShelter.waterAllPets();

		assertThat(50, equalTo(testPetShelter.getAPet("Jupiter").getThirst()));
	}

	@Test // passed
	public void shouldReturnTrueWhenAddHappinesstoSinglePet() {

		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Jupiter", new VirtualPet("Jupiter", "grey cat", 50, 50, 50));
		testPetShelter.petSinglePet("Jupiter");

		assertThat(45, equalTo(testPetShelter.getAPet("Jupiter").getHappiness()));
	}

	@Test // passed
	public void shouldReturnTrueWhenSubtractTickOf2toHappiness() {

		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Jupiter", new VirtualPet("Jupiter", "grey cat", 50, 50, 50));
		testPetShelter.tick();

		assertThat(48, equalTo(testPetShelter.getAPet("Jupiter").getHappiness()));
	}

	@Test // passed
	public void shouldReturnTrueWhenGetAllPetsReturnsSize() {

		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Jupiter", new VirtualPet("Jupiter", "fat cat", 50, 50, 50));
		testPetShelter.addPet("Saturn", new VirtualPet("Saturn", "striped cat", 50, 50, 50));
		testPetShelter.getPets();

		assertThat(2, equalTo(testPetShelter.getPets().size()));

	}

	@Test // returning "place in memory" (?) rather than the name
	public void shouldReturnTrueWhenGetAPetReturnsTheName() {

		String name = "Jupiter";
		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		testPetShelter.addPet("Jupiter", new VirtualPet("Jupiter", "fat cat", 50, 50, 50));
		testPetShelter.addPet("Saturn", new VirtualPet("Saturn", "striped cat", 50, 50, 50));
		testPetShelter.getAPet("Jupiter");

		assertThat("Jupiter", equalTo(testPetShelter.getAPet(name)));

	}

	@Test //wants me to import for Matchers... but it's imported!?!
	public void shouldReturnTrueWhenAdoptAPetReturnsSizeof1() {

		VirtualPetShelter testPetShelter = new VirtualPetShelter();
		VirtualPet pet = new VirtualPet("Jupiter", "fat cat", 50, 50, 50);
		testPetShelter.addPet("Jupiter", new VirtualPet("Jupiter", "fat cat", 50, 50, 50));
		testPetShelter.adoptPet(pet);

		assertThat("Junebug", equalTo(testPetShelter.adoptPet(pet)));

	}

}
