package etre;

public class Sorciere extends Monstre {
	
	public Sorciere() {
		
		id = ++nbm;
		att = 15;
		mag = 45;
		esp = 35;
		arm = 20;
		hp = 30;
		mp = 45;
		
	}

	@Override
	public String toString() {
		return "Sorciere [id=" + id + ", hp=" + hp + ", mp=" + mp + ", att=" + att + ", mag=" + mag + ", esp=" + esp
				+ ", arm=" + arm + "]";
	}
	
}
