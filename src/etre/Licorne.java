package etre;

public class Licorne extends Monstre {
	
	public Licorne() {
		
		id = ++nbm;
		att = 10;
		mag = 35;
		esp = 50;
		arm = 10;
		hp = 20;
		hp_max = 20;
		mp = 30;
		mp_max = 30;
		exp_gagne=12;
	}

	@Override
	public String toString() {
		return "Fee [id=" + id + ", hp=" + hp + ", mp=" + mp + ", att=" + att + ", mag=" + mag + ", esp=" + esp
				+ ", arm=" + arm + "]";
	}
	
}
