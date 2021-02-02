package etre;

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
		System.out.println(tank);
		tank.levelUp();
		System.out.println(tank);
		tank.levelUp();
		System.out.println(tank);
	}

}
