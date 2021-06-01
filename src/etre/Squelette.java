package etre;

public class Squelette extends Monstre {
	
	public Squelette() {
		
		id = ++nbm;
		att = 25;
		mag = 25;
		esp = 30;
		arm = 50;
		hp = 50;
		mp = 20;
		exp_gagne=17;
	}

	@Override
	public String toString() {
		return "Squelette [id=" + id + ", hp=" + hp + ", mp=" + mp + ", att=" + att + ", mag=" + mag + ", esp=" + esp
				+ ", arm=" + arm + "]";
	}
	
}
