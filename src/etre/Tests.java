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
		Squelette sque = new Squelette();
		Sorciere sorc = new Sorciere();
		Trent trent = new Trent();
		Fee fee = new Fee();
		Combat comb=new Combat();
		comb.addJoueur(cac);
		comb.addJoueur(tank);
		comb.addJoueur(sorcier);
		comb.addJoueur(pretre);
		comb.addMonstre(sque);
		comb.addMonstre(sorc);
		comb.addMonstre(fee);
		comb.addMonstre(trent);
		System.out.println(comb);
		ArrayList<String>test=new ArrayList<String>();
		test.add("cac;Défense");
		test.add("tank;Défense");
		test.add("sorcier;Défense");
		test.add("pretre;Défense");
		comb.deroulementCombatTour(test);
		System.out.println(comb);
	}
}
