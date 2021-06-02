package animation;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class AnimPerso extends Transition {
	
	private ImageView imgV;
	private String action;
	private int count=3;
	private int LastIndex,index;
	private String etat;

	public AnimPerso(ImageView imgV) {
		this.imgV=imgV;
		action="base";
		etat="normal";
		
		setCycleDuration(Duration.millis(500));
        setInterpolator(Interpolator.LINEAR);
	}

	@Override
	protected void interpolate(double k) {
		index = Math.min((int) Math.floor(k * count), count - 1);
		if(index!=LastIndex) {
			switch (action) {
			case "base":
				switch (etat) {
				case "normal":
					imgV.setViewport(new Rectangle2D((index)*64,0*64,64,64));
					break;
				case "blessé":
					imgV.setViewport(new Rectangle2D((index+6)*64,4*64,64,64));
					break;
				case "mort":
					imgV.setViewport(new Rectangle2D((index+6)*64,5*64,64,64));
					break;
				}
				break;
			case "attaque":
				imgV.setViewport(new Rectangle2D((index+3)*64,0*64,64,64));
				if(index==count-1)action="base";
				break;
			case "magie":
				imgV.setViewport(new Rectangle2D((index+3)*64,2*64,64,64));
				if(index==count-1)action="base";
				break;
			case "défense":
				imgV.setViewport(new Rectangle2D((index+3)*64,3*64,64,64));
				if(index==count-1)action="base";
				break;
			case  "soin":
				imgV.setViewport(new Rectangle2D((index+3)*64,5*64,64,64));
				if(index==count-1)action="base";
				break;
			case "incantationMagie":
				imgV.setViewport(new Rectangle2D((index)*64,2*64,64,64));
				break;
			case "incantationDéfense":
				imgV.setViewport(new Rectangle2D((index)*64,3*64,64,64));
				break;
			case  "incantationSoin":
				imgV.setViewport(new Rectangle2D((index)*64,6*64,64,64));
				break;
			case "degat":
				switch (etat) {
				case "normal":
					imgV.setViewport(new Rectangle2D((index)*64,4*64,64,64));
					if(index==count-1)action="base";
					break;
				case "blessé":
					imgV.setViewport(new Rectangle2D((index+6)*64,2*64,64,64));
					if(index==count-1)action="base";
					break;
				}
				break;
			case "victoire":
				imgV.setViewport(new Rectangle2D((index+6)*64,64,64,64));
				break;
			}
		LastIndex=index;
		}
	}
	
	public void setIndex() {
		index=0;
	}
	
	public void setAction(String action) {
		this.action=action;
	}
	
	public void setEtat(String etat) {
		this.etat=etat;
	}
	
	public void lancerAnim() {
		setInterpolator(Interpolator.LINEAR);
		setCycleCount(Animation.INDEFINITE);
        play();
	}

}
