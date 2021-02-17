package etre;

import combat.Combat;

public class Tests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorcier sorcier = new Sorcier();
		sorcier.attributionStats();
		System.out.println(sorcier);
		Pretre pretre = new Pretre();
		pretre.attributionStats();
		System.out.println(pretre);
		CaC cac = new CaC();
		cac.attributionStats();
		System.out.println(cac);
		Tank tank = new Tank();
		tank.attributionStats();
		tank.creationAttaques();
		System.out.println(tank);
		cac.levelUp();
		System.out.println(cac);
		Squelette sque = new Squelette();
		System.out.println(sque);
		Sorciere sorc = new Sorciere();
		System.out.println(sorc);
		Combat comb=new Combat();
		comb.addJoueur(tank);
		comb.addJoueur(sorcier);
		comb.addMonstre(sque);
		System.out.println(comb);
		comb.deroulementCombat(tank.getId(),sque.getId(),1);
		System.out.println(comb);
		comb.deroulementCombatTour();
	}

}
