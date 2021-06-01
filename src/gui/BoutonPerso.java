package gui;

import java.io.File;

import animation.AnimDegat;
import animation.AnimMort;
import animation.AnimMortP;
import etre.PJ;
import javafx.geometry.Rectangle2D;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class BoutonPerso extends BoutonEtre {	
	
	protected ImageView inter;
	protected Text nomImg,hpImg,mpImg;
	protected PJ perso;
	
	public BoutonPerso(Pane root, int x, int y,int x2 ,int y2, String nom, PJ perso) {
		super(root, nom, x, y,nom);
		this.perso=perso;
		pointer=new ImageView(new Image(new File(dossierURL+"/img/Interface/pointer2.png").toURI().toString()));
		inter=new ImageView(new Image(new File(dossierURL+"/img/Interface/button3.png").toURI().toString()));
		imgV.setImage(new Image(new File(dossierURL+"/img/perso/"+nom+"/combat.png").toURI().toString()));
		imgV.setViewport(new Rectangle2D(0,0,64,64));
		imgV.setOpacity(1);
		DropShadow ds = new DropShadow();
		
		nomImg=new Text(nom+": ");
		nomImg.setEffect(ds);
		nomImg.setOpacity(1);
		nomImg.setFont(Font.font(20));
		nomImg.setFill(Color.WHITE);
		nomImg.setX(x2+15);nomImg.setY(y2+19);
		nomImg.setMouseTransparent(true);
		
		hpImg=new Text(perso.getHp()+"/"+perso.getHp_max()+" Hp");
		hpImg.setEffect(ds);
		hpImg.setOpacity(1);
		hpImg.setFont(Font.font(20));
		hpImg.setFill(Color.WHITE);
		hpImg.setX(x2+170);hpImg.setY(y2+19);
		hpImg.setMouseTransparent(true);
		
		mpImg=new Text(perso.getMp()+"/"+perso.getMp_max()+" Mp");
		mpImg.setEffect(ds);
		mpImg.setOpacity(1);
		mpImg.setFont(Font.font(20));
		mpImg.setFill(Color.WHITE);
		mpImg.setX(x2+370);mpImg.setY(y2+19);
		mpImg.setMouseTransparent(true);
		
		setMouseTransparent(false);
		
		root.getChildren().add(pointer);
		root.getChildren().add(inter);
		root.getChildren().add(nomImg);
		root.getChildren().add(hpImg);
		root.getChildren().add(mpImg);
		
		inter.setOpacity(0);inter.setX(x2);inter.setY(y2);
		pointer.setMouseTransparent(true);
		pointer.setOpacity(0);pointer.setX(x+12);pointer.setY(y-50);
		t.setOpacity(0);
		vivant=true;occ=false;
		
		inter.setOnMouseEntered(e5->mouseEnter());
		inter.setOnMouseExited(e6->mouseExited());
		inter.setOnMousePressed(e7->mousePressed());
		inter.setOnMouseReleased(e8->mouseReleased());
	}
	
	public void setup() {
		occ=false;
		setMouseTransparent(false);
	}
	
	public void statMAJ() {
		if(perso.getHp()<=0) {
			AnimMort anim;
			anim=new AnimMortP(imgV);
			anim.lancerAnim();
			Meurt();
		}
		hpImg.setText(perso.getHp()+"/"+perso.getHp_max()+" Hp");
		mpImg.setText(perso.getMp()+"/"+perso.getMp_max()+" Mp");
	}
	
	@Override
	public void prendDegat(String degat) {
		AnimDegat anim=new AnimDegat(root,degat,imgV,"perso");
		anim.lancerAnim();
	}
	
	public PJ getPerso() {
		return perso;
	}
	
	public void setMouseTransparent(boolean b) {
		imgV.setMouseTransparent(b);
		inter.setMouseTransparent(b);
	}

	@Override
	public void mouseReleased() {
		pointer.setOpacity(0);
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
		occ=bool;
	}
}
