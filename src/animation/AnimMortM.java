package animation;

import javafx.animation.Interpolator;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimMortM extends AnimMort {
	
	private ColorAdjust blackout;

	public AnimMortM(ImageView imgV) {
		blackout = new ColorAdjust();
		this.imgV=imgV;
		imgV.setMouseTransparent(true);
		imgV.setEffect(blackout);
		setCycleDuration(Duration.millis(1000));
        setInterpolator(Interpolator.LINEAR);
	}

	@Override
	protected void interpolate(double k) {
		double d=blackout.getBrightness();
  	  	double d2=imgV.getOpacity();
  	  	if(d2==0)stop();
  	  	blackout.setBrightness(d-0.05);
  	  	imgV.setOpacity(d2-0.05);
	}
}
