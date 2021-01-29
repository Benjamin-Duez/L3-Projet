package etre;

public class Sorcier extends PJ {

	public Sorcier()
	{
		id=++nbh;
		exp=0;
		argent=10;
	}
	
	public void attributionStats()
	{
		att = 10 + (int)(Math.random() * ((20 - 10) + 1));
		mag = 55 + (int)(Math.random() * ((65 - 55) + 1));
		arm = 15 + (int)(Math.random() * ((25 - 15) + 1));
		esp = 35 + (int)(Math.random() * ((45 - 35) + 1));
		hp = 20 + (int)(Math.random() * ((30 - 20) + 1));
		mp = 50 + (int)(Math.random() * ((60 - 50) + 1));
	}

	@Override
	public String toString() {
		return "Sorcier [id=" + id + ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm=" + arm + ", exp=" + exp
				+ ", argent=" + argent + ", hp=" + hp + ", mp=" + mp + "]";
	}
	
	
}
