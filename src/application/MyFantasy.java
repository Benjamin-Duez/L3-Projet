package application;

import java.io.File;
import java.util.ArrayList;

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
    private double widthStep;
    private double heightStep;
    
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
	
	
	public void start(Stage primaryStage) {
		height=624;
		width=816;
		dimh=13;
		dimw=17;
		d="";
		primaryStage.setTitle("MyFantasy");
		primaryStage.getIcons().add(new Image(new File(dossierURL+"/img/Interface/icon.png").toURI().toString()));
		afficheCombat(primaryStage);
    }
	
/*	void afficheMap(Stage primaryStage) {
		
		root=new Pane();

		String imageURL=new File(dossierURL+"/img/Map/map/Map001.png").toURI().toString();
		Image image = new Image(imageURL);
		ImageView imageview=new ImageView(image);
		root.getChildren().setAll(imageview);
		
		Scene scene= new Scene(root,width,height);
		
		placeCase();
		ajoutPersonne();
		
		ImageView imgV=p.getDeplacement();
		animation=new Anim(imgV,p,d);
		
        root.getChildren().add(animation.getImageView());
		scene.setOnKeyPressed(e->annimation(e.getCharacter()));
		scene.setOnKeyReleased(e2->stop());
		primaryStage.setResizable(false); 
		primaryStage.setScene(scene);
		primaryStage.show();
	}*/
	
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
		afficheUI();

		scene.setOnMouseReleased(e->Action(recap));
		scene.setOnKeyTyped(e1->Tue(e1.getCharacter()));
		
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
		p=new PersoImg("perso1",c);
	}
	
/*	void annimation(String t) {
		animation.lancerAnim(t);
	}
	
	public void stop() {
		animation.pause();
	}*/
	
	void afficheUI() {
		String imageURL=new File(dossierURL+"/img/Interface/ui2.png").toURI().toString();
		Image image = new Image(imageURL,816,124,false,false);
		ImageView imageview=new ImageView(image);
		imageview.setY(500);
		root.getChildren().add(imageview);
		
		BoutonPerso p=new BoutonPerso(root,500,336,270,509,"cac");
		tabP.add(p);
		p=new BoutonPerso(root,500,400,270,536,"tank");
		tabP.add(p);
		p=new BoutonPerso(root,550,310,270,563,"sorcier");
		tabP.add(p);
		p=new BoutonPerso(root,550,426,270,590,"pretre");
		tabP.add(p);
		
		Bouton b=new Bouton(root,"Attaque",25,509);
		tabB.add(b);
		b=new Bouton(root,"Magie",25,536);
		tabB.add(b);
		b=new Bouton(root,"Soin",25,563);
		tabB.add(b);
		b=new Bouton(root,"Défense",25,590);
		tabB.add(b);
		
		BoutonMonstre m=new BoutonMonstre(root, 200, 300, "warg");
		tabM.add(m);
		m=new BoutonMonstre(root, 200, 400, "skully");
		tabM.add(m);
		m=new BoutonMonstre(root, 100, 300, "unicorn");
		tabM.add(m);
		m=new BoutonMonstre(root, 100, 400, "watch");
		tabM.add(m);
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
		switch (c)
		{
		case "m":
			anim=new AnimMortM(tabM.get(0).getImgV());
			anim.lancerAnim();
			tabM.get(0).Meurt();
			break;
		case "p":
			anim=new AnimMortP(tabP.get(1).getImgV());
			anim.lancerAnim();
			tabP.get(1).Meurt();
			break;
		}
	}
	
	public void lancerCombat(ArrayList<String> recap) {
		System.out.println("Début du Combat" + recap);
		for(String val:recap)
			System.out.println(val);
	}
	
	public static void main(String[] args) {
		launch(args);
    }

}
