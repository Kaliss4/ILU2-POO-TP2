package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	
	public String[] trouverProduit(String produit) {
		Gaulois[] vendeursProduit =village.rechercherVendeursProduit(produit);
		String[]vendeur=new String[vendeursProduit.length];
		for (int i = 0; i < vendeursProduit.length; i++) {	
			vendeur[i]=vendeursProduit[i].getNom();
		}
		return vendeur;
	}
	
	public int trouverEtal (String nomVendeur) {
		Etal etal =controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.getQuantite();
	}
	
	public boolean verifierIdentite(String nomAcheteur) {
		controlVerifierIdentite.verifierIdentite(nomAcheteur);
		return nomAcheteur!=null;
	}
	
	public void acheter (String nomVendeur, int qtte) {
		Etal etal =controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		etal.acheterProduit(qtte);
		
	}
	
}

