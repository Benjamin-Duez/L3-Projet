package application;

import java.io.File;

import gui.Case;
import gui.PersoImg;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
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

    private double widthStep;
    private double heightStep;
    
    private Pane root;
    
    Anim animation;
    
    boolean go = false;
    
    Timeline littleCycle;
    
    final private String dossierURL = System.getProperty("user.dir") ;
	private Case[][] tab = new Case[17][13];
	
	private PersoImg p;
	
	public void start(Stage primaryStage) {
		height=624;
		width=816;
		dimh=13;
		dimw=17;
		d="";
		afficheMap(primaryStage);
    }
	
	void afficheMap(Stage primaryStage) {
		
		root=new Pane();

		String imageURL=new File(dossierURL+"/Map/Map001.png").toURI().toString();
		Image image = new Image(imageURL);
		ImageView imageview=new ImageView(image);
		root.getChildren().setAll(imageview);
		
		Scene scene= new Scene(root,width,height);
		
		placeCase();
		ajoutPersonne();
		
		ImageView imgV=p.getDeplacement();
		animation=new Anim(imgV,p,d);
		
        root.getChildren().add(animation.getImageView());
		
		/*Case c=p.getCase();
		c.setBleu();
		c.setOpacity(1);
		
		root.getChildren().add(c);*/
		scene.setOnKeyTyped(e->annimation(e.getCharacter()));
		scene.setOnKeyReleased(e2->stop());
		primaryStage.setResizable(false); 
		primaryStage.setTitle("MyFantasy");
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
	
	void annimation(String t) {
		animation.lancerAnim(t);
	}
	
	public void stop() {
		animation.pause();
	}
	
	public static void main(String[] args) {
		launch(args);
    }

}
