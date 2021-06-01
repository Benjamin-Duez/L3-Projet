package gui;

import java.io.File;

import animation.AnimDegat;
import animation.AnimMort;
import animation.AnimMortM;
import etre.Etre_Vivant;
import etre.Monstre;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BoutonMonstre extends BoutonEtre {
	
	private static int i;
	private String type;
	protected Monstre m;

	public BoutonMonstre(Pane root,int x, int y, String type, Monstre m) {
		super(root, type, x, y,"monstre "+i);
		this.type=type;
		this.m=m;
		i+=1;
		pointer=new ImageView(new Image(new File(dossierURL+"/img/Interface/pointer2.png").toURI().toString()));
		imgV.setImage(new Image(new File(dossierURL+"/img/mob/"+this.type+".png").toURI().toString(),100,100,false,false));
		imgV.setOpacity(1);
		root.getChildren().add(pointer);
		pointer.setMouseTransparent(true);
		pointer.setOpacity(0);pointer.setX(x+25);pointer.setY(y-50);
		t.setOpacity(0);
		vivant=true;occ=false;
	}
	
	public Monstre getM() {
		return m;
	}
	
	@Override
	public void prendDegat(String degat) {
		AnimDegat anim=new AnimDegat(root,degat,imgV,"monstre");
		anim.lancerAnim();
	}
	
	public void statMAJ() {
		if(m.getHp()<=0) {
			AnimMort anim;
			anim=new AnimMortM(imgV);
			anim.lancerAnim();
			Meurt();
		}
	}
	
	@Override
	public void mouseReleased() {
		pointer.setOpacity(0);
		System.out.println(nom+": "+t.getText());
	}
	
	@Override
	public void Meurt() {
		AnimMortM anim=new AnimMortM(imgV);
		anim.lancerAnim();
		vivant=false;
	}
}
