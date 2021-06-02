package animation;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AnimDegat extends Transition {

	private Text t;
	private ImageView imgV;
	private boolean b;
	private int count=3;
	private int index;
	
	public AnimDegat(Pane root,String degat,ImageView imgV,String type,boolean b) {
		this.imgV=imgV;
		index=0;
		t= new Text();
		t.setText(degat);
		t.setFont(Font.font(30));
		t.setFill(Color.SNOW);
		t.setOpacity(1);
		DropShadow ds = new DropShadow();
		t.setMouseTransparent(true);
		switch (type) {
		case "monstre":
			t.setX(imgV.getX()+100);t.setY(imgV.getY()+50);
			break;
		case "perso":
			t.setX(imgV.getX()-32);t.setY(imgV.getY()+32);
		}
		if(b)ds.setColor(Color.RED);
		else {ds.setColor(Color.GREEN);this.b=false;}
		t.setEffect(ds);
		
		root.getChildren().add(t);
		setCycleDuration(Duration.millis(10000));
        setInterpolator(Interpolator.LINEAR);
	}

	@Override
	protected void interpolate(double k) {
		if(t.getOpacity()<=0) {
			stop();
		}
		else {
			t.setOpacity(t.getOpacity()-0.02);
			if(index!=count-1)index+=1;
			else index=0;
		}
	}
	
	public void lancerAnim() {
		setInterpolator(Interpolator.LINEAR);
		setCycleCount(Animation.INDEFINITE);
        play();
	}

}
