package etre;

public class Pretre extends PJ {

	public Pretre()
	{
		id=++nbh;
		exp=0;
		argent=10;
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

	@Override
	public String toString() {
		return "Pretre [id=" + id + ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm=" + arm + ", exp=" + exp
				+ ", argent=" + argent + ", hp=" + hp + ", mp=" + mp + "]";
	}
}
