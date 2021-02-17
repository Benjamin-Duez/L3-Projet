package etre;

import java.util.TreeMap;

public class Pretre extends PJ {

	public Pretre()
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
		mag = 30 + (int)(Math.random() * ((40 - 30) + 1));
		arm = 15 + (int)(Math.random() * ((25 - 15) + 1));
		esp = 50 + (int)(Math.random() * ((60 - 50) + 1));
		hp = 25 + (int)(Math.random() * ((35 - 25) + 1));
		mp = 40 + (int)(Math.random() * ((50 - 40) + 1));
	}

	public void levelUp()
	{
		int alea= 5 + (int)(Math.random() * ((10 - 5) + 1));
		System.out.println("Valeur de alea " + alea);
		switch(alea) {
		case 5:
			esp+=1;hp+=1;mag+=1;mp+=1;arm+=1;
			break;
		case 6:
			esp+=2;hp+=1;mag+=1;mp+=1;arm+=1;
			break;
		case 7:
			esp+=2;hp+=1;mag+=1;mp+=1;arm+=1;att+=1;
			break;
		case 8:
			esp+=2;hp+=2;mag+=1;mp+=1;arm+=1;att+=1;
			break;
		case 9:
			esp+=2;hp+=2;mag+=1;mp+=2;arm+=1;att+=1;
			break;
		case 10:
			esp+=3;hp+=2;mag+=2;mp+=2;arm+=1;
			break;
		}
		exp=0;
		lvl++;
		exp_limit*=Math.exp(1);
	}
	
	public void creationAttaques()
	{
		if(attaques==null)attaques=new TreeMap<Integer,Integer>();
		attaques.put(1, 15);
		attaques.put(2, 25);
		attaques.put(3, 35);
		attaques.put(4, 45);
	}
	
	@Override
	public String toString() {
		return "Pretre [id=" + id + ", exp=" + exp + ", exp_limit=" + exp_limit + ", lvl=" + lvl + ", argent=" + argent
				+ ", hp=" + hp + ", mp=" + mp + ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm=" + arm + "]";
	}
	
	public int calcul_degats_infliges_phys(int choix)
	{
		return attaques.get(choix)*att/9;
		
	}
}
