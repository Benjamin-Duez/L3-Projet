package application;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.image.ImageView;

public abstract class AnimMort extends Transition {

	protected ImageView imgV;
	
	public void lancerAnim() {
		setInterpolator(Interpolator.LINEAR);
		setCycleCount(Animation.INDEFINITE);
        play();
	}
	
}
