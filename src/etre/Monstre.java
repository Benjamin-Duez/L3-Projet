package etre;

import gui.BoutonMonstre;

public abstract class Monstre extends Etre_Vivant {

	int id;
	int exp_gagne;
	private BoutonMonstre b;
	
	public void setBouton(BoutonMonstre bouton) {
		b=bouton;
	}
	
	public BoutonMonstre getBouton() {
		return b;
	}

	public int getId() {
		return id;
	}

	public int getExp_gagne() {
		return exp_gagne;
	}
	
	public int calcul_competence(int choix)
	{
		int degats_soins_bouclier=0;
		switch(choix)
		{
		case 1:
			degats_soins_bouclier=att/2;
			break;
		case 2:
			degats_soins_bouclier=mag/2;
			break;
		case 3:
			degats_soins_bouclier=(esp/4)+(mag/4);
			break;
		case 4:
			degats_soins_bouclier=(arm/3)+(esp/3);
			break;
		}	
		return degats_soins_bouclier;
	}
	
}
