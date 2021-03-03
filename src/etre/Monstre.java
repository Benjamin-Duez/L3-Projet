package etre;

public abstract class Monstre extends Etre_Vivant {

	int id;
	int exp_gagne;

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
			degats_soins_bouclier=(att/10)*9;
			break;
		case 2:
			degats_soins_bouclier=(mag/10)*9;
			break;
		case 3:
			degats_soins_bouclier=((esp/10)*8)*((mag/10)*1);
			break;
		case 4:
			degats_soins_bouclier=(arm/2)*(esp/2);
			break;
		}	
		System.out.println("calcul de la competence " + degats_soins_bouclier);
		return degats_soins_bouclier;
	}
	
}
