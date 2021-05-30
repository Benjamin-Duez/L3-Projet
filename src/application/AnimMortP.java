package application;

import javafx.animation.Interpolator;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimMortP extends AnimMort {
	
	private int count=6;	
	private int lastIndex;

	public AnimMortP(ImageView imgV) {
		this.imgV=imgV;
		imgV.setViewport(new Rectangle2D(6*64,4*64,64,64));
		setCycleDuration(Duration.millis(500));
        setInterpolator(Interpolator.LINEAR);
	}

	@Override
	protected void interpolate(double k) {
		int index = Math.min((int) Math.floor(k * count), count - 1);
		if (index != lastIndex) {
			switch(index) {
			case 0:
				imgV.setViewport(new Rectangle2D(6*64,4*64,64,64));
				break;
			case 1:
				imgV.setViewport(new Rectangle2D(7*64,4*64,64,64));
				break;
			case 2:
				imgV.setViewport(new Rectangle2D(8*64,4*64,64,64));
				break;
			case 3:
				imgV.setViewport(new Rectangle2D(6*64,5*64,64,64));
				break;
			case 4:
				imgV.setViewport(new Rectangle2D(7*64,5*64,64,64));
				break;
			case 5:
				imgV.setViewport(new Rectangle2D(8*64,5*64,64,64));
				stop();
				break;
			}
		}
	}

}
