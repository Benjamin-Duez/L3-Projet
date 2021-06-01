package application;

import java.io.File;
import java.util.ArrayList;

import animation.Anim;
import animation.AnimDegat;
import animation.AnimMort;
import animation.AnimMortM;
import combat.Combat;
import etre.CaC;
import etre.Licorne;
import etre.Loup;
import etre.Pretre;
import etre.Sorcier;
import etre.Sorciere;
import etre.Squelette;
import etre.Tank;
import gui.Bouton;
import gui.BoutonMonstre;
import gui.BoutonPerso;
import gui.Case;
import gui.PersoImg;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MyFantasy extends Application{
	
    private double height;
    private double width;
    private int dimh;
    private int dimw;
    private String d;
    private int phase;
    
    private Pane root;
    
    Anim animation;
    
    boolean go = false;
    
    Timeline littleCycle;
    
    PersoImg p;
    
    final private String dossierURL = System.getProperty("user.dir") ;
	private Case[][] tab = new Case[17][13];
	
	private ArrayList <Bouton> tabB;
	private ArrayList <BoutonMonstre> tabM;
	private ArrayList <BoutonPerso> tabP;
	
	Combat combat;
	
	public void start(Stage primaryStage) {
		height=624;
		width=816;
		dimh=13;
		dimw=17;
		d="";
		primaryStage.setTitle("MyFantasy");
		primaryStage.getIcons().add(new Image(new File(dossierURL+"/img/Interface/icon.png").toURI().toString()));
		//afficheMap(primaryStage);
		afficheCombat(primaryStage);
    }
	
	void afficheMap(Stage primaryStage) {
		
		root=new Pane();

		String imageURL=new File(dossierURL+"/img/Map/map/Map001.png").toURI().toString();
		Image image = new Image(imageURL);
		ImageView imageview=new ImageView(image);
		root.getChildren().setAll(imageview);
		imageURL=new File(dossierURL+"/img/Interface/pointer.png").toURI().toString();
		Image pointer =new Image(imageURL);
		
		Scene scene= new Scene(root,width,height);
		scene.setOnMouseEntered(e->scene.setCursor(new ImageCursor(pointer)));
		
		placeCase();
		ajoutPersonne();
		
		ImageView imgV=p.getDeplacement();
		animation=new Anim(imgV,p,d);
		
        root.getChildren().add(animation.getImageView());
        
		scene.setOnKeyPressed(e->animation(e.getCharacter()));
		scene.setOnKeyReleased(e2->stopAnim());
		primaryStage.setResizable(false); 
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	void afficheCombat(Stage primaryStage) {
		
		root=new Pane();
		
		String imageURL=new File(dossierURL+"/img/Map/battle/donjon001.png").toURI().toString();
		Image image = new Image(imageURL);
		ImageView imageview=new ImageView(image);
		root.getChildren().setAll(imageview);
		tabB=new ArrayList<Bouton>();
		tabM=new ArrayList<BoutonMonstre>();
		tabP=new ArrayList<BoutonPerso>();
		
		ArrayList<String> recap=new ArrayList<String>();
		
		Scene scene= new Scene(root,width,height);
		imageURL=new File(dossierURL+"/img/Interface/pointer.png").toURI().toString();
		Image p =new Image(imageURL);
		scene.setOnMouseEntered(e->scene.setCursor(new ImageCursor(p)));
		phase=0;
		
		combat=new Combat();
		afficheUI();

		scene.setOnMouseReleased(e->Action(recap));
		//scene.setOnKeyTyped(e1->Tue(e1.getCharacter())); //test des animations de mort
		
		primaryStage.setResizable(false); 
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	void placeCase() {
		for(int i=0;i<dimh;i++) {
			double y=48*i;
			for(int j=0;j<dimw;j++) {
				double x=48*j;
				tab[j][i]=new Case(x,y);
				root.getChildren().add(tab[j][i]);
			}
		}
	}
	
	void ajoutPersonne() {
		Case c= new Case(tab[16][6].getX(),tab[16][6].getY());
		p=new PersoImg("cac",c);
	}
	
	void animation(String t) {
		animation.lancerAnim(t);
	}
	
	public void stopAnim() {
		animation.pause();
	}
	
	void afficheUI() {
		String imageURL=new File(dossierURL+"/img/Interface/ui2.png").toURI().toString();
		Image image = new Image(imageURL,816,124,false,false);
		ImageView imageview=new ImageView(image);
		imageview.setY(500);
		root.getChildren().add(imageview);
		
		CaC cac = new CaC();
		cac.attributionStats();
		cac.creationAttaques();
		BoutonPerso p=new BoutonPerso(root,500,336,270,509,"cac",cac);
		cac.setBouton(p);
		tabP.add(p);
		combat.addJoueur(cac);
		
		Tank tank = new Tank();
		tank.attributionStats();
		tank.creationAttaques();
		p=new BoutonPerso(root,500,400,270,536,"tank",tank);
		tank.setBouton(p);
		tabP.add(p);
		combat.addJoueur(tank);
		
		Sorcier sorcier = new Sorcier();
		sorcier.attributionStats();
		sorcier.creationAttaques();
		p=new BoutonPerso(root,550,310,270,563,"sorcier",sorcier);
		sorcier.setBouton(p);
		tabP.add(p);
		combat.addJoueur(sorcier);
		
		Pretre pretre = new Pretre();
		pretre.attributionStats();
		pretre.creationAttaques();
		p=new BoutonPerso(root,550,426,270,590,"pretre",pretre);
		pretre.setBouton(p);
		tabP.add(p);
		combat.addJoueur(pretre);
		
		Bouton b=new Bouton(root,"Attaque",25,509);
		tabB.add(b);
		b=new Bouton(root,"Magie",25,536);
		tabB.add(b);
		b=new Bouton(root,"Soin",25,563);
		tabB.add(b);
		b=new Bouton(root,"Défense",25,590);
		tabB.add(b);
		
		Loup loup = new Loup();
		BoutonMonstre m=new BoutonMonstre(root, 200, 300, "warg",loup);
		loup.setBouton(m);
		tabM.add(m);
		combat.addMonstre(loup);
		
		Squelette sque = new Squelette();
		m=new BoutonMonstre(root, 200, 400, "skully",sque);
		sque.setBouton(m);
		tabM.add(m);
		combat.addMonstre(sque);
		
		Licorne uni = new Licorne();
		m=new BoutonMonstre(root, 100, 300, "unicorn",uni);
		uni.setBouton(m);
		tabM.add(m);
		combat.addMonstre(uni);
		
		Sorciere sorc = new Sorciere();
		m=new BoutonMonstre(root, 100, 400, "watch",sorc);
		sorc.setBouton(m);
		tabM.add(m);
		combat.addMonstre(sorc);
	}
	
	private String s;
	
	public void Action(ArrayList<String> recap) {
		if(phase==0) {
			s=new String();
		}
		if(phase==0) {
			BoutonPerso b=null;
			for(BoutonPerso val:tabP){
				if(val.isPressed())b=val;
			}
			if(b!=null) {
					for(Bouton val:tabB){
						val.setMouseTransparent(false);
					}
					for(BoutonPerso val:tabP) {
						val.setMouseTransparent(true);
					}
					phase=1;
					b.setOccupe(true);
					s=b.getNom()+";";
			}
		}
		else if(phase==1) {
				Bouton b=null;
				for(Bouton val:tabB){
					if(val.isPressed())b=val;
				}
				if(b!=null) {
					switch (b.getText()) {
					case "Attaque":
						for(BoutonMonstre val:tabM){
							if(val.isVivant())val.setMouseTransparent(false);
						}
						for(Bouton val:tabB) {
							val.setMouseTransparent(true);
						}
						phase=2;
						s=s+b.getText()+";";
						break;
					case "Magie":
						for(BoutonMonstre val:tabM){
							if(val.isVivant())val.setMouseTransparent(false);
						}
						for(Bouton val:tabB) {
							val.setMouseTransparent(true);
						}
						phase=2;
						s=s+b.getText()+";";
						break;
						
					case "Soin":
						for(BoutonPerso val:tabP){
							if(val.isVivant())val.setMouseTransparent(false);
						}
						for(Bouton val:tabB) {
							val.setMouseTransparent(true);
						}
						phase=3;
						s=s+b.getText()+";";
						break;
						
					case "Défense":
						for(BoutonPerso val:tabP){
							if(val.isVivant())if(!val.isOccupe())val.setMouseTransparent(false);
						}
						for(Bouton val:tabB) {
							val.setMouseTransparent(true);
						}
						phase=0;
						s=s+b.getText();
						recap.add(s);
						
						boolean bool=false;
						for(BoutonPerso val:tabP)
							if(!val.isOccupe())bool=true;
						if(!bool)lancerCombat(recap);
						break;
					}
				}
		}
		else if(phase==2) {
				BoutonMonstre b=null;
				for(BoutonMonstre val:tabM){
					if(val.isPressed())b=val;
				}
				if(b!=null) {
						for(BoutonPerso val:tabP){
							if(val.isVivant())if(!val.isOccupe())val.setMouseTransparent(false);
						}
						for(BoutonMonstre val:tabM) {
							val.setMouseTransparent(true);
						}
						phase=0;
						s=s+b.getNom();
						recap.add(s);
						
						boolean bool=false;
						for(BoutonPerso val:tabP)
							if(!val.isOccupe())bool=true;
						if(!bool)lancerCombat(recap);
				}
		}
		else if(phase==3) {
			BoutonPerso b=null;
			for(BoutonPerso val:tabP){
				if(val.isPressed())b=val;
			}
			if(b!=null) {
					for(BoutonPerso val:tabP){
						val.setMouseTransparent(true);
					}
					for(BoutonPerso val:tabP){
						if(val.isVivant() && !val.isOccupe())val.setMouseTransparent(false);
					}
					phase=0;
					s=s+b.getNom();
					recap.add(s);
					
					boolean bool=false;
					for(BoutonPerso val:tabP)
						if(!val.isOccupe())bool=true;
					if(!bool)lancerCombat(recap);
			}
		}
	}
	
	public void Tue(String c) {
		AnimMort anim;
		AnimDegat anim2;
		switch (c)
		{
		case "m":
			anim=new AnimMortM(tabM.get(0).getImgV());
			anim2=new AnimDegat(root,"-9999",tabM.get(0).getImgV(),"monstre");
			anim2.lancerAnim();
			anim.lancerAnim();
			tabM.get(0).Meurt();
			break;
		case "p":
			anim2=new AnimDegat(root,"-9999",tabP.get(1).getImgV(),"perso");
			tabP.get(1).getPerso().setHp(tabP.get(1).getPerso().getHp()-9999);
			tabP.get(1).statMAJ();
			anim2.lancerAnim();
			break;
		}
	}
	
	public void lancerCombat(ArrayList<String> recap) {
		System.out.println("Début du Combat");
		System.out.println("");
		combat.deroulementCombat(recap);
		combat.start();
	}
	
	public static void main(String[] args) {
		launch(args);
    }

}
