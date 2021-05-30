package gui;

import java.io.File;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BoutonPerso extends BoutonEtre {	
	
	protected ImageView inter;
	
	public BoutonPerso(Pane root, int x, int y,int x2 ,int y2, String nom) {
		super(root, nom, x, y,nom);
		pointer=new ImageView(new Image(new File(dossierURL+"/img/Interface/pointer2.png").toURI().toString()));
		inter=new ImageView(new Image(new File(dossierURL+"/img/Interface/button3.png").toURI().toString()));
		imgV.setImage(new Image(new File(dossierURL+"/img/perso/"+nom+"/combat.png").toURI().toString()));
		imgV.setViewport(new Rectangle2D(0,0,64,64));
		imgV.setOpacity(1);
		setMouseTransparent(false);
		root.getChildren().add(pointer);
		root.getChildren().add(inter);
		inter.setOpacity(0);inter.setX(x2);inter.setY(y2);
		pointer.setMouseTransparent(true);
		pointer.setOpacity(0);pointer.setX(x+12);pointer.setY(y-50);
		t.setOpacity(0);
		vivant=true;o=false;
	}

	@Override
	public void mouseReleased() {
		System.out.println(t.getText());
		inter.setImage(new Image(new File(dossierURL+"/img/Interface/button3.png").toURI().toString()));
	}
	
	@Override
	public void mouseEnter() {
		pointer.setOpacity(1);
		inter.setOpacity(1);
	}
	
	@Override
	public void mouseExited() {
		pointer.setOpacity(0);
		inter.setOpacity(0);
	}
	
	@Override
	public void mousePressed() {
		b=true;
		inter.setImage(new Image(new File(dossierURL+"/img/Interface/button4.png").toURI().toString()));
	}
	
	public void setOccupe(boolean bool) {
		o=bool;
	}
}
