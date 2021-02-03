package etre;

import java.util.Map;

import items.Armures;
import items.Type_Armure;

public abstract class PJ extends Humain {

	int id;
	int exp; //exp�rience obtenue par le personnage pour la progression de celui-ci
	int exp_limit; //Si l'exp�rience d�passe cette variable alors le niveau du personnage augmente
	int lvl; //Niveau du personnage
	Map<Type_Armure,Armures> equipement;
	
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
	
	public abstract void levelUp();
	
}
