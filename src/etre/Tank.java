package etre;

import java.util.*;

public class Tank extends PJ{
	
	public Tank()
	{
		id=++nbh;
		exp=0;
		argent=10;
		lvl=1;
		exp_limit=10;
	}
	
	public void attributionStats()
	{
		att = 25 + (int)(Math.random() * ((35 - 25) + 1));
		mag = 15 + (int)(Math.random() * ((25 - 15) + 1));
		arm = 45 + (int)(Math.random() * ((55 - 45) + 1));
		esp = 25 + (int)(Math.random() * ((35 - 25) + 1));
		hp_max = 55 + (int)(Math.random() * ((65 - 55) + 1));
		mp_max = 20 + (int)(Math.random() * ((30 - 20) + 1));
		hp=hp_max;
		mp=mp_max;
	}

	public void levelUp()
	{
		int alea= 5 + (int)(Math.random() * ((10 - 5) + 1));
		System.out.println("Valeur de alea " + alea);
		switch(alea) {
		case 5:
			arm+=1;hp_max+=1;att+=1;mp_max+=1;esp+=1;
			break;
		case 6:
			arm+=2;hp_max+=1;att+=1;mp_max+=1;esp+=1;
			break;
		case 7:
			arm+=2;hp_max+=1;att+=1;mp_max+=1;esp+=1;mag+=1;
			break;
		case 8:
			arm+=2;hp_max+=2;att+=1;mp_max+=1;esp+=1;mag+=1;
			break;
		case 9:
			arm+=2;hp_max+=2;att+=1;mp_max+=1;esp+=2;mag+=1;
			break;
		case 10:
			arm+=3;hp_max+=2;att+=1;mp_max+=1;esp+=2;mag+=1;
			break;
		}
		lvl++;
		exp_limit*=Math.exp(1);
	}

	public void creationAttaques()
	{
		if(attaques==null)attaques=new TreeMap<Integer,Integer>();
		attaques.put(1, 4);
		attaques.put(2, 2);
		attaques.put(3, 2);
		attaques.put(4, 5);
	}
	
	@Override
	public String toString() {
		return "Tank [id=" + id + ", exp=" + exp + ", exp_limit=" + exp_limit + ", lvl=" + lvl + ", bouclier="
				+ bouclier + ", attaques=" + attaques + ", argent=" + argent + ", hp=" + hp + ", hp_max=" + hp_max
				+ ", mp=" + mp + ", mp_max=" + mp_max + ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm="
				+ arm + "]";
	}
	
}
