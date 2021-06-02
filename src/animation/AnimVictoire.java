package animation;

import java.util.List;

import etre.PJ;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AnimVictoire extends Transition {
	
	List<PJ> joueur;
	private Text t;
	private int count=3;
	private int LastIndex,index;

	public AnimVictoire(List<PJ> joueur) {
		this.joueur=joueur;
		index=0;
		Pane root=joueur.get(0).getBouton().getRoot();
		
		t= new Text();
		t.setText("Victoire");
		t.setFont(Font.font(200));
		t.setFill(Color.WHITE);
		t.setOpacity(0);
		DropShadow ds = new DropShadow();
		t.setMouseTransparent(true);
		ds.setColor(Color.GOLD);
		t.setEffect(ds);
		t.setX(75);t.setY(200);
		root.getChildren().add(t);
		
		setCycleDuration(Duration.millis(500));
        setInterpolator(Interpolator.LINEAR);
	}

	@Override
	protected void interpolate(double k) {
		index = Math.min((int) Math.floor(k * count), count - 1);
		if(index!=LastIndex) {
		joueur.forEach(item->item.getBouton().lanceVictoire());
		if(t.getOpacity()<=1)t.setOpacity(t.getOpacity()+0.02);
		LastIndex=index;
		}

	}
	
	public void lancerAnim() {
		setInterpolator(Interpolator.LINEAR);
		setCycleCount(Animation.INDEFINITE);
        play();
	}

}
