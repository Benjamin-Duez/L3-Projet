package gui;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class BoutonEtre extends Bouton  {

	protected String nom;
	public ImageView pointer;
	protected boolean vivant;
	protected boolean o;
	
	public BoutonEtre(Pane root, String text, int x, int y,String nom) {
		super(root, text, x, y);
		vivant=true;
		o=false;
		this.nom=nom;
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
		return o;
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
