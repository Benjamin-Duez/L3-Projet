package etre;

public class Tank extends PJ{
	
	public Tank()
	{
		id=++nbh;
		exp=0;
		argent=10;
		lvl=1;
		exp_limit=10;
		type_arme = Arme_Equipable.Epee_Bouclier;
	}
	
	public void attributionStats()
	{
		att = 25 + (int)(Math.random() * ((35 - 25) + 1));
		mag = 15 + (int)(Math.random() * ((25 - 15) + 1));
		arm = 45 + (int)(Math.random() * ((55 - 45) + 1));
		esp = 25 + (int)(Math.random() * ((35 - 25) + 1));
		hp = 55 + (int)(Math.random() * ((65 - 55) + 1));
		mp = 20 + (int)(Math.random() * ((30 - 20) + 1));
	}

	public void levelUp()
	{
		int alea= 5 + (int)(Math.random() * ((10 - 5) + 1));
		System.out.println("Valeur de alea " + alea);
		switch(alea) {
		case 5:
			arm+=1;hp+=1;att+=1;mp+=1;esp+=1;
			break;
		case 6:
			arm+=2;hp+=1;att+=1;mp+=1;esp+=1;
			break;
		case 7:
			arm+=2;hp+=1;att+=1;mp+=1;esp+=1;mag+=1;
			break;
		case 8:
			arm+=2;hp+=2;att+=1;mp+=1;esp+=1;mag+=1;
			break;
		case 9:
			arm+=2;hp+=2;att+=1;mp+=1;esp+=2;mag+=1;
			break;
		case 10:
			arm+=3;hp+=2;att+=1;mp+=1;esp+=2;mag+=1;
			break;
		}
		exp=0;
		lvl++;
		exp_limit*=Math.exp(1);
	}

	@Override
	public String toString() {
		return "Tank [id=" + id + ", exp=" + exp + ", exp_limit=" + exp_limit + ", lvl=" + lvl + ", argent=" + argent
				+ ", hp=" + hp + ", mp=" + mp + ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm=" + arm + "]";
	}
	
}
