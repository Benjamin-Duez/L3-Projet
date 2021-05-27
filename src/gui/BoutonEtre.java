package gui;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class BoutonEtre extends Bouton  {

	protected String nom;
	public ImageView pointer;
	
	public BoutonEtre(Pane root, String text, int x, int y,String nom) {
		super(root, text, x, y);
		this.nom=nom;
	}
	
}
