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
		scene.setOnKeyTyped(e->annimation(e.getCharacter()));
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
		
		Scene scene= new Scene(root,width,height);
		imageURL=new File(dossierURL+"/img/Interface/pointer.png").toURI().toString();
		Image p =new Image(imageURL);
		scene.setOnMouseEntered(e->scene.setCursor(new ImageCursor(p)));
		phase=0;
		afficheUI();

		scene.setOnMousePressed(e->Action());
		
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
		
		Bouton b=new Bouton(root,"Attaque",25,509);
		tabB.add(b);
		b=new Bouton(root,"Magie",25,536);
		tabB.add(b);
		b=new Bouton(root,"Soin",25,563);
		tabB.add(b);
		b=new Bouton(root,"D�fense",25,590);
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
	
	public void Action() {
		if(phase==0) {
			System.out.println("phase 0 pass�e");
			for(Bouton val:tabB){
				val.setMouseTransparent(false);
			}
			phase+=1;
		}
		else if(phase==1) {
		Bouton b=null;
		for(Bouton val:tabB){
			if(val.isPressed())b=val;
		}
		if(b!=null) {
				for(Bouton val:tabM){
					val.setMouseTransparent(false);
				}
				phase+=1;
			}
		}
		else if(phase==2) {
		Bouton b=null;
		for(Bouton val:tabM){
			if(val.isPressed())b=val;
		}
		if(b!=null) {
				phase+=1;
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
    }

}
