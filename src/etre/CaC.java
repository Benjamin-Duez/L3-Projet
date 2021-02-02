package etre;

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
		mag = 20 + (int)(Math.random() * ((25 - 20) + 1));
		arm = 30 + (int)(Math.random() * ((40 - 30) + 1));
		esp = 15 + (int)(Math.random() * ((25 - 15) + 1));
		hp = 35 + (int)(Math.random() * ((45 - 35) + 1));
		mp = 25 + (int)(Math.random() * ((35 - 25) + 1));
	}

	public void levelUp()
	{
		int alea= 5 + (int)(Math.random() * ((10 - 5) + 1));
		System.out.println("Valeur de alea " + alea);
		switch(alea) {
		case 5:
			att+=1;hp+=1;arm+=1;mp+=1;esp+=1;
			break;
		case 6:
			att+=2;hp+=1;arm+=1;mp+=1;esp+=1;
			break;
		case 7:
			att+=2;hp+=2;arm+=1;mp+=1;esp+=1;
			break;
		case 8:
			att+=2;hp+=2;arm+=2;mp+=1;esp+=1;
			break;
		case 9:
			att+=2;hp+=2;arm+=2;mp+=2;esp+=1;
			break;
		case 10:
			att+=3;hp+=2;arm+=2;mp+=2;esp+=1;
			break;
		}
		exp=0;
		lvl++;
		exp_limit*=Math.exp(1);
	}
	
	@Override
	public String toString() {
		return "CaC [id=" + id + ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm=" + arm + ", exp=" + exp
				+ ", argent=" + argent + ", hp=" + hp + ", mp=" + mp + "]";
	}
	
}
