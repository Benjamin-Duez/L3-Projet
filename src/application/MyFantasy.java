package application;

import java.io.File;
import java.util.ArrayList;

import gui.Bouton;
import gui.Case;
import gui.PersoImg;
import javafx.animation.Timeline;
import javafx.application.Application;
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
	
	
	public void start(Stage primaryStage) {
		height=624;
		width=816;
		dimh=13;
		dimw=17;
		d="";
		primaryStage.setTitle("MyFantasy");
		afficheCombat(primaryStage);
    }
	
	void afficheMap(Stage primaryStage) {
		
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
	}
	
	void afficheCombat(Stage primaryStage) {
		
		root=new Pane();
		
		String imageURL=new File(dossierURL+"/img/Map/battle/donjon001.png").toURI().toString();
		Image image = new Image(imageURL);
		ImageView imageview=new ImageView(image);
		root.getChildren().setAll(imageview);
		tabB=new ArrayList<Bouton>();
		
		Scene scene= new Scene(root,width,height);
		phase=0;
		afficheUI();

		scene.setOnMousePressed(e->Action());
		
		primaryStage.setResizable(false); 
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void Action() {
		if(phase==0) {
			System.out.println("phase 0 passée");
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
				String s=b.getText();
				b.getImgV().setOnMouseReleased(e->System.out.println(s));
			}
		}
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
	
	void annimation(String t) {
		animation.lancerAnim(t);
	}
	
	public void stop() {
		animation.pause();
	}
	
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
		b=new Bouton(root,"Défense",25,590);
		tabB.add(b);
		
	}
	
	public static void main(String[] args) {
		launch(args);
    }

}
