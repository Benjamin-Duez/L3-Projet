package etre;

import java.util.Map;

import items.Armures;
import items.Type_Armure;

public abstract class PJ extends Humain {

	int id;
	int exp; //expérience obtenue par le personnage pour la progression de celui-ci
	int exp_limit; //Si l'expérience dépasse cette variable alors le niveau du personnage augmente
	int lvl; //Niveau du personnage
	Map<Type_Armure,Armures> equipement;
	Map<Integer,Integer> attaques;
	
	public abstract void attributionStats();
	
	public abstract void levelUp();

	public int getId() {
		return id;
	}
	
	public Map<Integer, Integer> getAttaques() {
		return attaques;
	}

	public abstract void creationAttaques();
	
	public abstract int calcul_degats_infliges_phys(int i);
	
}
