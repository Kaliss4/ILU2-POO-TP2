package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolé "+ nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour "+ nomVendeur+ ", je vais regarder si je peux vous trouvez un etal.");
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if (!etalDisponible) {
				System.out.println("Desolee "+ nomVendeur+ " je n'ai plus d'etal qui ne soit pas deja occupe.");
			}
			else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un etal pour vous !");
		System.out.println("Il me faudrait quelque renseignements : ");
		
		StringBuilder questionProduit = new StringBuilder();
		questionProduit.append("Quel produit souhaitez-vous vendre ?");
		String produit = null;
		produit =Clavier.entrerChaine(questionProduit.toString());
		
		StringBuilder questionNbProduit = new StringBuilder();
		questionNbProduit.append("Combien souhaitez-vous en vendre ?");
		int nbProduit = -1;
		nbProduit = Clavier.entrerEntier(questionNbProduit.toString());
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit)+1;
		
		if (numeroEtal !=-1) {
			System.out.println("Le vendeur "+nomVendeur+ " s'est installe a l'etal n°"+numeroEtal+ ".");
		}
	}
}
