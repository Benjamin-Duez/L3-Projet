package etre;

public class Fee extends Monstre {
	
	public Fee() {
		
		id = ++nbm;
		att = 10;
		mag = 35;
		esp = 50;
		arm = 10;
		hp = 20;
		mp = 30;
		
	}

	@Override
	public String toString() {
		return "Fee [id=" + id + ", hp=" + hp + ", mp=" + mp + ", att=" + att + ", mag=" + mag + ", esp=" + esp
				+ ", arm=" + arm + "]";
	}
	
}
