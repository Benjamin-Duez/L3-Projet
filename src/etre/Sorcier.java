package etre;

import java.util.TreeMap;

public class Sorcier extends PJ {

	public Sorcier()
	{
		id=++nbh;
		exp=0;
		argent=10;
		lvl=1;
		exp_limit=10;
	}
	
	public void attributionStats()
	{
		att = 10 + (int)(Math.random() * ((20 - 10) + 1));
		mag = 55 + (int)(Math.random() * ((65 - 55) + 1));
		arm = 15 + (int)(Math.random() * ((25 - 15) + 1));
		esp = 35 + (int)(Math.random() * ((45 - 35) + 1));
		hp_max = 25 + (int)(Math.random() * ((35 - 25) + 1));
		mp_max = 50 + (int)(Math.random() * ((60 - 50) + 1));
		hp=hp_max;
		mp=mp_max;
	}

	public void levelUp()
	{
		int alea= 5 + (int)(Math.random() * ((10 - 5) + 1));
		System.out.println("Valeur de alea " + alea);
		switch(alea) {
		case 5:
			mag+=2;hp_max+=1;mp_max+=1;esp+=1;
			break;
		case 6:
			mag+=2;hp_max+=1;mp_max+=2;esp+=1;
			break;
		case 7:
			mag+=2;hp_max+=1;mp_max+=2;esp+=1;arm+=1;
			break;
		case 8:
			mag+=3;hp_max+=1;mp_max+=2;esp+=1;arm+=1;
			break;
		case 9:
			mag+=3;hp_max+=1;mp_max+=2;esp+=2;arm+=1;
			break;
		case 10:
			mag+=3;hp_max+=2;mp_max+=2;esp+=2;arm+=1;
			break;
		}
		exp=0;
		lvl++;
		exp_limit*=Math.exp(1);
	}
	
	public void creationAttaques()
	{
		if(attaques==null)attaques=new TreeMap<Integer,Integer>();
		attaques.put(1, 2);
		attaques.put(2, 15);
		attaques.put(3, 10);
		attaques.put(4, 2);
	}
	
	@Override
	public String toString() {
		return "Sorcier [id=" + id + ", exp=" + exp + ", exp_limit=" + exp_limit + ", lvl=" + lvl + ", attaques="
				+ attaques + ", argent=" + argent + ", hp=" + hp + ", hp_max=" + hp_max + ", mp=" + mp + ", mp_max="
				+ mp_max + ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm=" + arm + "]";
	}
	
	public int calcul_degats_infliges(int choix)
	{
		int degats_soins=0;
		switch(choix)
		{
		case 1:
			degats_soins=attaques.get(choix)*((att/10)*9);
			break;
		case 2:
			degats_soins=attaques.get(choix)*((mag/10)*9);
			break;
		case 3:
			degats_soins=attaques.get(choix)*((esp/10)*8)*((mag/10)*1);
			break;
		case 4:
			
			break;
		}	
		System.out.println(degats_soins);
		return degats_soins;
	}
	
}
