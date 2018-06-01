import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

public class VirtualPetShelterTest {
	
	VirtualPetShelter shelter = new VirtualPetShelter();
	
//	@Test
//	public void shouldReturnTrueWhenHungryAndGivenFood() {
//		int underTest = pet.feed(10);
//
//		Assert.assertEquals(40, underTest);
//	}
	
//	@Test
//	public Collection<VirtualPet>getPetsShouldReturnAllPets();
//	
//		underTest.add
	
	@Test
	public void shouldReturnTrueWhenHungryAndGivenFood() {
		int underTest = shelter.feed(10);

		Assert.assertEquals(40, underTest);
	}

}
