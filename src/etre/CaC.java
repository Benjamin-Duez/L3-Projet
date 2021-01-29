package etre;

public class CaC extends PJ {

	public CaC()
	{
		id=++nbh;
		exp=0;
		argent=10;
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

	@Override
	public String toString() {
		return "CaC [id=" + id + ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm=" + arm + ", exp=" + exp
				+ ", argent=" + argent + ", hp=" + hp + ", mp=" + mp + "]";
	}
	
}
