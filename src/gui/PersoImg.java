package gui;

import java.io.File;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PersoImg {
	
	private String imgUrl;
	private Case c;
	private boolean b;
	private String nom;
	private ImageView imgV;
	
	public PersoImg(String nom) {
		String dossierURL = System.getProperty("user.dir") ;
		this.nom=nom;
		imgUrl=new File(dossierURL+"/perso/"+this.nom).toURI().toString();
		c= new Case(0,0);
		c.setColor();
		b=true;
	}
	
	public PersoImg(String nom, Case c) {
		String dossierURL = System.getProperty("user.dir") ;
		this.nom=nom;
		imgUrl=new File(dossierURL+"/perso/"+nom).toURI().toString();
		this.c = new Case(c.getX(),c.getY());
		c.setColor();
		b=true;
	}
	
	public void setCase(Case c) {
		this.c=c;
	}
	
	public Case getCase() {
		return c;
	}
	
	public void switchB(){
		b=!b;
	}
	
	public boolean getB() {
		return b;
	}
	
	@Override
	public String toString() {
		return (nom+": [X="+c.getX()+" Y="+c.getY()+"]");
	}

	public ImageView getDeplacement() {
		String Url= new File(imgUrl+"/deplacement.png").toString();
		Image img=new Image(Url);
		imgV= new ImageView(img);
		imgV.setX(c.getX());imgV.setY(c.getY());
		return imgV;
	}
	
	public ImageView getBasG() {
		Rectangle2D r=new Rectangle2D(0,0,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	public ImageView getBas() {
		Rectangle2D r=new Rectangle2D(48,0,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	public ImageView getBasD() {
		Rectangle2D r=new Rectangle2D(48*2,0,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	
	public ImageView getGaucheG() {
		Rectangle2D r=new Rectangle2D(0,48,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	public ImageView getGauche() {
		Rectangle2D r=new Rectangle2D(48,48,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	public ImageView getGaucheD() {
		Rectangle2D r=new Rectangle2D(48*2,48,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	
	public ImageView getDroiteG() {
		Rectangle2D r=new Rectangle2D(0,48*2,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	public ImageView getDroite() {
		Rectangle2D r=new Rectangle2D(48,48*2,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	public ImageView getDroiteD() {
		Rectangle2D r=new Rectangle2D(48*2,48*2,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	
	public ImageView getHautG() {
		Rectangle2D r=new Rectangle2D(0,48*3,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	public ImageView getHaut() {
		Rectangle2D r=new Rectangle2D(48,48*3,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
	public ImageView getHautD() {
		Rectangle2D r=new Rectangle2D(48*2,48*3,48,48);
		ImageView imgV= getDeplacement();
		imgV.setViewport(r);
		return imgV;
	}
}
