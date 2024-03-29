package etre;

import java.util.TreeMap;

public class CaC extends PJ {

	public CaC()
	{
		id=++nbh;
		exp=0;
		argent=10;
		lvl=1;
		exp_limit=10;
	}
	
	public void attributionStats()
	{
		att = 50 + (int)(Math.random() * ((60 - 50) + 1));
		mag = 15 + (int)(Math.random() * ((25 - 15) + 1));
		arm = 30 + (int)(Math.random() * ((40 - 30) + 1));
		esp = 15 + (int)(Math.random() * ((25 - 15) + 1));
		hp_max = 35 + (int)(Math.random() * ((45 - 35) + 1));
		mp_max = 25 + (int)(Math.random() * ((35 - 25) + 1));
		hp=hp_max;
		mp=mp_max;
	}

	public void levelUp()
	{
		int alea= 5 + (int)(Math.random() * ((10 - 5) + 1));
		System.out.println("Valeur de alea " + alea);
		switch(alea) {
		case 5:
			att+=1;hp_max+=1;arm+=1;mp_max+=1;esp+=1;hp=hp_max;mp=mp_max;
			break;
		case 6:
			att+=2;hp_max+=1;arm+=1;mp_max+=1;esp+=1;hp=hp_max;mp=mp_max;
			break;
		case 7:
			att+=2;hp_max+=2;arm+=1;mp_max+=1;esp+=1;hp=hp_max;mp=mp_max;
			break;
		case 8:
			att+=2;hp_max+=2;arm+=2;mp_max+=1;esp+=1;hp=hp_max;mp=mp_max;
			break;
		case 9:
			att+=2;hp_max+=2;arm+=2;mp_max+=2;esp+=1;hp=hp_max;mp=mp_max;
			break;
		case 10:
			att+=3;hp_max+=2;arm+=2;mp_max+=2;esp+=1;hp=hp_max;mp=mp_max;
			break;
		}
		lvl++;
		exp_limit*=Math.exp(1);
	}
	
	public void creationAttaques()
	{
		if(attaques==null)attaques=new TreeMap<Integer,Integer>();
		attaques.put(1, 5);
		attaques.put(2, 2);
		attaques.put(3, 2);
		attaques.put(4, 4);
	}
	
	@Override
	public String toString() {
		return "CaC [id=" + id + ", exp=" + exp + ", exp_limit=" + exp_limit + ", lvl=" + lvl + ", attaques=" + attaques
				+ ", bouclier=" + bouclier + ", argent=" + argent + ", hp=" + hp + ", hp_max=" + hp_max + ", mp=" + mp + ", mp_max=" + mp_max
				+ ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm=" + arm + "]";
	}
	
}
