package etre;

public class Tank extends PJ{
	
	public Tank()
	{
		id=++nbh;
		exp=0;
		argent=10;
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

	@Override
	public String toString() {
		return "Tank [id=" + id + ", att=" + att + ", mag=" + mag + ", esp=" + esp + ", arm=" + arm + ", exp=" + exp
				+ ", argent=" + argent + ", hp=" + hp + ", mp=" + mp + "]";
	}
	
}
