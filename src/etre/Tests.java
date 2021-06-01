package etre;

import java.util.ArrayList;

import combat.Combat;

public class Tests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorcier sorcier = new Sorcier();
		sorcier.attributionStats();
		sorcier.creationAttaques();
		Pretre pretre = new Pretre();
		pretre.attributionStats();
		pretre.creationAttaques();
		CaC cac = new CaC();
		cac.attributionStats();
		cac.creationAttaques();
		Tank tank = new Tank();
		tank.attributionStats();
		tank.creationAttaques();
		Loup loup = new Loup();
		Sorciere sorc = new Sorciere();
		Squelette sque = new Squelette();
		Licorne uni = new Licorne();
		Combat comb=new Combat();
		comb.addJoueur(cac);
		comb.addJoueur(tank);
		comb.addJoueur(sorcier);
		comb.addJoueur(pretre);
		comb.addMonstre(loup);
		comb.addMonstre(sorc);
		comb.addMonstre(uni);
		comb.addMonstre(sque);
		System.out.println(comb);
		ArrayList<String>test=new ArrayList<String>();
		test.add("cac;Attaque;monstre 0");
		test.add("tank;Défense");
		test.add("sorcier;Défense");
		test.add("pretre;Défense");
		comb.deroulementCombat(test);
		System.out.println(comb);
	}
}
