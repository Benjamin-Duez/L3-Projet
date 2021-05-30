package gui;

import java.io.File;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Bouton {

	final protected String dossierURL = System.getProperty("user.dir") ;
	protected ImageView imgV;
	protected Image enter;
	protected Image pressed;
	protected Text t;
	protected int x,y;
	protected boolean b;
	
	public Bouton(Pane root,String text, int x, int y) {
		this.x=x;this.y=y;
		String imageURL=new File(dossierURL+"/img/Interface/button1.png").toURI().toString();
		enter = new Image(imageURL);
		imageURL=new File(dossierURL+"/img/Interface/button2.png").toURI().toString();
		pressed = new Image(imageURL);
		t= new Text(text);
		DropShadow ds = new DropShadow();
		imgV=new ImageView(enter);
		imgV.setOpacity(0);
		imgV.setY(this.y);imgV.setX(this.x);
		t.setY(this.y+19);t.setX(this.x+15);
		t.setFont(Font.font(20));
		t.setFill(Color.WHITE);
		t.setEffect(ds);t.setMouseTransparent(true);
		imgV.setMouseTransparent(true);
		b=false;
		
		root.getChildren().add(imgV);
		root.getChildren().add(t);
		mouseEvent();
	}
	
	protected void mouseEvent() {
		imgV.setOnMouseEntered(e->mouseEnter());
		imgV.setOnMouseExited(e2->mouseExited());
		imgV.setOnMousePressed(e3->mousePressed());
		imgV.setOnMouseReleased(e4->mouseReleased());
	}
	
	public void mouseEnter() {
		imgV.setImage(enter);
		imgV.setOpacity(1);
	}
	
	public void mouseExited() {
		imgV.setOpacity(0);
		imgV.setImage(enter);
	}
	
	public void mousePressed() {
		imgV.setImage(pressed);
		b=true;
	}
	
	public void mouseReleased() {
		System.out.println(t.getText());
		imgV.setImage(enter);
	}
	
	public boolean isPressed() {
		if(b) {b=false;return true;}
		else return false;
	}
	
	public ImageView getImgV() {
		return imgV;
	}
	
	public String getText() {
		return t.getText();
	}
	
	public void setMouseTransparent(boolean b) {
		imgV.setMouseTransparent(b);
	}
}
