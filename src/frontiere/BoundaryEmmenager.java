package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide "+ nomVisiteur);
		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Quelle est votre force");
		int forceDruide = -1;
		forceDruide = Clavier.entrerEntier(questionForce.toString());
		
		int effetPotionMin = -1;
		int effetPotionMax = -1;
		
		do {
			StringBuilder questionPotionMin = new StringBuilder();
			questionPotionMin.append("Quelle est la force la plus faible que vous produisez");
			
			effetPotionMin = Clavier.entrerEntier(questionPotionMin.toString());
			
			StringBuilder questionPotionMax = new StringBuilder();
			questionPotionMax.append("Quelle est la force la plus forte que vous produisez");
			
			effetPotionMax = Clavier.entrerEntier(questionPotionMax.toString());
			if (effetPotionMax< effetPotionMin) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le min");
			}
		} while (effetPotionMax<effetPotionMin);
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
	private void emmenagerGaulois (String nomVisteur) {
		System.out.println("Bienvenue villageois "+nomVisteur);
		StringBuilder questionForce = new StringBuilder();
		questionForce.append("Quelle est votre force");
		int force = -1;
		force = Clavier.entrerEntier(questionForce.toString());
		controlEmmenager.ajouterGaulois(nomVisteur, force);
	}
}
