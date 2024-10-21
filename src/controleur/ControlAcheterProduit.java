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
	
	
	public Gaulois[] trouverProduit(String Produit) {
		return village.rechercherVendeursProduit(Produit);
		
	}
	
	public Etal trouverEtal (Gaulois vendeur) {
		return village.rechercherEtal(vendeur);
	}
	
	public boolean verifierIdentite(String nomAcheteur) {
		controlVerifierIdentite.verifierIdentite(nomAcheteur);
		return nomAcheteur!=null;
	}
	
	public void acheter (Etal etal, int qtte) {
		etal.acheterProduit(qtte);
		
	}
	
	//TODO a completer
}

