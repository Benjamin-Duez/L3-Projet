package application;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AnimDegat extends Transition {

	private Text t;
	
	public AnimDegat(Pane root,String degat,ImageView imgV,String type) {
		t= new Text();
		t.setText(degat);
		t.setFont(Font.font(30));
		t.setFill(Color.WHITE);
		t.setOpacity(1);
		DropShadow ds = new DropShadow();
		t.setEffect(ds);
		t.setMouseTransparent(true);
		switch (type) {
		case "monstre":
			t.setX(imgV.getX()+100);t.setY(imgV.getY()+50);
			break;
		case "perso":
			t.setX(imgV.getX()-64);t.setY(imgV.getY()+32);
			
		}
		root.getChildren().add(t);
		setCycleDuration(Duration.millis(500));
        setInterpolator(Interpolator.LINEAR);
	}

	@Override
	protected void interpolate(double arg0) {
		if(t.getOpacity()<=0)stop();
		else {
			t.setOpacity(t.getOpacity()-0.03);
		}
	}
	
	public void lancerAnim() {
		setInterpolator(Interpolator.LINEAR);
		setCycleCount(Animation.INDEFINITE);
        play();
	}

}
