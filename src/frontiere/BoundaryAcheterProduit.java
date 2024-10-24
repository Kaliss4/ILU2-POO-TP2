package frontiere;

import java.util.Iterator;
import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu= controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!nomAcheteurConnu) {
			System.out.println("Je suis desolee "+ nomAcheteur+ " mais il faut etre un habitant de notre village pour commercer ici.");
		}
		else {
			trouverVendeur(nomAcheteur);
		}
		
		// TODO à completer
	}
	private void trouverVendeur (String nomAcheteur) {
		StringBuilder questionProduit = new StringBuilder();
		questionProduit.append("Quel produit voulez-vous acheter ?");
		String produit = Clavier.entrerChaine(questionProduit.toString());
		Gaulois[] vendeur =controlAcheterProduit.trouverProduit(produit);
		if (vendeur==null) {
			System.out.println("Desole, personne ne vend ce produit au marche.");
		}
		else {
			StringBuilder questionVendeur = new StringBuilder();
			questionVendeur.append("Chez quel commercant voulez-vous acheter des "+produit+" ? \n");
			
			for (int i = 0; i < vendeur.length; i++) {
				int indice = i+1;
				questionVendeur.append(indice+" - "+ vendeur[i].getNom()+"\n");
			}
			int choixVendeur =0;
			do {
				choixVendeur =Clavier.entrerEntier(questionVendeur.toString());
				System.out.println("Vous devez choisir un etal proposé");
			}while (choixVendeur<1 || choixVendeur>vendeur.length);
			
				System.out.println(nomAcheteur+" se deplace jusqu'a l'etal du vendeur "+ vendeur[choixVendeur-1].getNom()+ "\n Bonjour "+ nomAcheteur+ "\n");
				StringBuilder questionQtte = new StringBuilder();
				questionQtte.append("Combien de "+produit+" voulez-vous acheter ?");
				int choixQtte =Clavier.entrerEntier(questionQtte.toString());
				acheterVendeur(nomAcheteur,vendeur[choixVendeur-1],produit,choixQtte);
				
			
			
			
		}
	}
	private void acheterVendeur(String nomAcheteur, Gaulois vendeur,String produit,int qtte) {
		Etal etalVendeur = controlAcheterProduit.trouverEtal(vendeur);
		if (etalVendeur.getQuantite()==0) {
			System.out.println(nomAcheteur+ " veut acheter "+qtte+ " "+produit+", malheureusement il n'y en a plus !");
		}else {
			if (etalVendeur.getQuantite()<qtte){
				System.out.println(nomAcheteur+ " veut acheter "+qtte+ " "+produit+", malheureusement "+ vendeur.getNom()+ " n'en a plus que "+ etalVendeur.getQuantite()+ ". "+ nomAcheteur+ " achete tout le stock de "+ vendeur.getNom()+ ".");
			}else {	
				System.out.println(nomAcheteur+ " achete "+ qtte +" " +produit +" a " +vendeur.getNom()+"." );
			}
			controlAcheterProduit.acheter(etalVendeur, qtte);
		}
	}
	
}
