package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initaliserSituation() {
		System.out.println("Initialisation : ");
		village = new Village("le village des irréductibles",10,5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage=new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage,"Constructeur ne renvoi pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		Gaulois bonemine = new Gaulois("Bonemine", 10);
		village.ajouterHabitant(bonemine);
		Druide panoramix = new Druide("Panoramix", 9, 5, 8);
		village.ajouterHabitant(panoramix);
		ControlAfficherVillage controlAfficherVillage=new ControlAfficherVillage(village);
		String [] liste =controlAfficherVillage.donnerNomsVillageois();
		assertNotNull(liste,"Liste n'est pas vide");
	}
	
	@Test
	void testDonnerNomsSansVillageois() {
		ControlAfficherVillage controlAfficherVillage=new ControlAfficherVillage(village);
		String[] liste =controlAfficherVillage.donnerNomsVillageois();
		assertEquals(1,liste.length);
	}
	

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage=new ControlAfficherVillage(village);
		String nom = controlAfficherVillage.donnerNomVillage();
		assertEquals("le village des irréductibles", nom); //est ce que je peux faire ça où il faut notnull ?
		
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage=new ControlAfficherVillage(village);
		int nbEtal = controlAfficherVillage.donnerNbEtals();
		assertEquals(5, nbEtal);
	}

}
