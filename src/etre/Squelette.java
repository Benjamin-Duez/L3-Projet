package etre;

public class Squelette extends Monstre {
	
	public Squelette() {
		
		id = ++nbm;
		att = 40;
		mag = 15;
		esp = 20;
		arm = 30;
		hp = 35;
		hp_max= 35;
		mp = 15;
		mp_max = 15;
		exp_gagne=30;
		
	}
	
	@Override
	public String toString() {
		return "Squelette [id=" + id + ", hp=" + hp + ", mp=" + mp + ", att=" + att + ", mag=" + mag + ", esp=" + esp
				+ ", arm=" + arm + "]";
	}
	
}
