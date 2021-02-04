package etre;

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
		hp = 25 + (int)(Math.random() * ((35 - 25) + 1));
		mp = 50 + (int)(Math.random() * ((60 - 50) + 1));
	}

	public void levelUp()
	{
		int alea= 5 + (int)(Math.random() * ((10 - 5) + 1));
		System.out.println("Valeur de alea " + alea);
		switch(alea) {
		case 5:
			mag+=2;hp+=1;mp+=1;esp+=1;
			break;
		case 6:
			mag+=2;hp+=1;mp+=2;esp+=1;
			break;
		case 7:
			mag+=2;hp+=1;mp+=2;esp+=1;arm+=1;
			break;
		case 8:
			mag+=3;hp+=1;mp+=2;esp+=1;arm+=1;
			break;
		case 9:
			mag+=3;hp+=1;mp+=2;esp+=2;arm+=1;
			break;
		case 10:
			mag+=3;hp+=2;mp+=2;esp+=2;arm+=1;
			break;
		}
		exp=0;
		lvl++;
		exp_limit*=Math.exp(1);
	}
	
	@Override
	public String toString() {
		return "Sorcier [id=" + id + ", exp=" + exp + ", exp_limit=" + exp_limit + ", lvl=" + lvl + ", argent=" + argent
				+ ", hp=" + hp + ", mp=" + mp + ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm=" + arm + "]";
	}
	
	
}
