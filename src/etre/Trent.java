package etre;

public class Trent extends Monstre {

	int id;
	
	public Trent() {
		
		id = ++nbm;
		att = 25;
		mag = 25;
		esp = 30;
		arm = 50;
		hp = 50;
		mp = 20;
		
	}

	@Override
	public String toString() {
		return "Trent [id=" + id + ", hp=" + hp + ", mp=" + mp + ", att=" + att + ", mag=" + mag + ", esp=" + esp
				+ ", arm=" + arm + "]";
	}
	
}
