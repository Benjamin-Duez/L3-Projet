package etre;

public abstract class Etre_Vivant {

	static int nbm;
	static int nbh;
	int hp;
	int hp_max;
	int mp;
	int mp_max;
	int att; //attaque
	int mag; //magie
	int esp; //soins + armure magique
	int arm; //armure physique
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setMp(int mp) {
		this.mp = mp;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public void setMag(int mag) {
		this.mag = mag;
	}
	public void setEsp(int esp) {
		this.esp = esp;
	}
	public void setArm(int arm) {
		this.arm = arm;
	}
	public int getHp() {
		return hp;
	}
	public int getMp() {
		return mp;
	}
	public int getAtt() {
		return att;
	}
	public int getMag() {
		return mag;
	}
	public int getEsp() {
		return esp;
	}
	public int getArm() {
		return arm;
	}
	
}
