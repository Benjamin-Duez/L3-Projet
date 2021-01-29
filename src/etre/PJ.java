package etre;

public abstract class PJ extends Humain {

	int id;
	int att; //attaque
	int mag; //magie
	int esp; //soins + armure magique
	int arm; //armure physique
	int exp; //exp�rience obtenue par le personnage pour la progression de celui-ci
	
	/**
	 * pour l'instant c'est du brouillon
	 * 
	 * attaque physique = (0.9*ATT + r�ussite(PRE)) * ATT(Spell)		PRE = pr�cision de l'arme
	 * attaque magique = (0.8*MAG + 0.1*ESP + r�ussite(PRE)) * MAG(Spell)
	 * 
	 *  soins prodigu�s = (0.85*ESP + 0.05 MAG) * ESP(Spell)
	 *  
	 *  d�gats re�us physique = si (d�gats re�us < ARM) alors HP = HP - 0.5 * d�gats re�uts
	 *  						sinon HP = HP - 0.9 * d�gats re�us
	 *  
	 *  pareil pour les d�gats re�us magique mais par rapport � ESP
	 */
	
	public abstract void attributionStats();
	
}
