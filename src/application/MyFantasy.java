package application;

import java.io.File;

import gui.Case;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MyFantasy extends Application{
	
    private double height;
    private double width;
    private int dimh;
    private int dimw;

    private double widthStep;
    private double heightStep;
    
    private Group root;
    
    final private String dossierURL = System.getProperty("user.dir") ;
	
	public void start(Stage primaryStage) {
		afficheMap(primaryStage);    
    }
	
	void afficheMap(Stage primaryStage) {
		height=624;
		width=816;
		dimh=13;
		dimw=17;
		
		root=new Group();

		String imageURL=new File(dossierURL+"/Map/Map001.png").toURI().toString();
		Image image = new Image(imageURL);
		ImageView imageview=new ImageView(image);
		root.getChildren().setAll(imageview);
		
		placeCase();
		
		Scene scene= new Scene(root,width,height);
		
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
				Case c=new Case(x,y);
				root.getChildren().add(c);
			}
		}
	}
	
	public static void main(String[] args) {
		launch(args);
    }

}
