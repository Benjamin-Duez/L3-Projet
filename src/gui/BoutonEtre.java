package gui;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BoutonEtre extends Bouton  {

	protected String nom;
	public ImageView pointer;
	protected boolean vivant;
	protected boolean occ;
	
	
	public BoutonEtre(Pane root, String text, int x, int y,String nom) {
		super(root, text, x, y);
		vivant=true;
		occ=false;
		this.nom=nom;
	}
	
	public void prendDegat(String degat) {
	}
	
	public void setup() {
		occ=false;
	}
	
	public void Meurt() {
		vivant=false;
	}
	
	public boolean isVivant() {
		return vivant;
	}
	
	@Override
	public void mousePressed() {
		b=true;
	}
	
	public boolean isOccupe() {
		return occ;
	}
	@Override
	public void mouseReleased() {
		System.out.println(t.getText());
	}
	
	@Override
	public void mouseEnter() {
		pointer.setOpacity(1);
	}
	
	@Override
	public void mouseExited() {
		pointer.setOpacity(0);
	}
	
	public String getNom() {
		return nom;
	}

}
