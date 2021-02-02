package etre;

public abstract class PJ extends Humain {

	int id;
	int exp; //expérience obtenue par le personnage pour la progression de celui-ci
	int exp_limit; //Si l'expérience dépasse cette variable alors le niveau du personnage augmente
	int lvl; //Niveau du personnage
	
	/**
	 * pour l'instant c'est du brouillon
	 * 
	 * attaque physique = (0.9*ATT + réussite(PRE)) * ATT(Spell)		PRE = précision de l'arme
	 * attaque magique = (0.8*MAG + 0.1*ESP + réussite(PRE)) * MAG(Spell)
	 * 
	 *  soins prodigués = (0.85*ESP + 0.05 MAG) * ESP(Spell)
	 *  
	 *  dégats reçus physique = si (dégats reçus < ARM) alors HP = HP - 0.5 * dégats reçuts
	 *  						sinon HP = HP - 0.9 * dégats reçus
	 *  
	 *  pareil pour les dégats reçus magique mais par rapport à ESP
	 */
	
	public abstract void attributionStats();
	
	public abstract void levelUp();
	
}
