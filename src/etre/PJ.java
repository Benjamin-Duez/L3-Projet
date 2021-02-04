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
	
	public abstract void attributionStats();
	
	public abstract void levelUp();

	public int getId() {
		return id;
	}
	
}
