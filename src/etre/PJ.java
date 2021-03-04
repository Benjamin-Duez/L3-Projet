package etre;

import java.util.Map;
import java.util.TreeMap;

import items.Armes;
import items.Armures;
import items.Type_Armure;

public abstract class PJ extends Humain {

	int id;
	int exp; //exp�rience obtenue par le personnage pour la progression de celui-ci
	int exp_limit; //Si l'exp�rience d�passe cette variable alors le niveau du personnage augmente
	int lvl; //Niveau du personnage
	Map<Type_Armure,Armures> equipement;
	Armes arme;
	Map<Integer,Integer> attaques;
	
	public abstract void attributionStats();
	
	public abstract void levelUp();

	public int getId() {
		return id;
	}
	
	public void ajoutEquipement() 
	{
		if(equipement==null)equipement=new TreeMap<Type_Armure,Armures>();
		equipement=
	}
	
	public Map<Integer, Integer> getAttaques() {
		return attaques;
	}

	public abstract void creationAttaques();
	
	public int calcul_competence(int choix)
	{
		int degats_soins_bouclier=0;
		switch(choix)
		{
		case 1:
			degats_soins_bouclier=attaques.get(choix)*((att/10)*9);
			break;
		case 2:
			degats_soins_bouclier=attaques.get(choix)*((mag/10)*9);
			break;
		case 3:
			degats_soins_bouclier=attaques.get(choix)*((esp/10)*8)*((mag/10)*1);
			break;
		case 4:
			degats_soins_bouclier=attaques.get(choix)*(arm/2)*(esp/2);
			break;
		}	
		System.out.println("calcul de la competence " + degats_soins_bouclier);
		return degats_soins_bouclier;
	}

	public int getExp() {
		return exp;
	}

	public int getExp_limit() {
		return exp_limit;
	}

	public void setExp(int exp) {
		this.exp += exp;
	}

	public int getBouclier() {
		return bouclier;
	}

	public void setBouclier(int bouclier) {
		this.bouclier = bouclier;
	}
	
}
