package application;

import gui.PersoImg;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class Anim extends Transition {
	
	private ImageView imageView;
	private String direction;
	private PersoImg p;
	private int count=4;
	private int lastIndex;
	
	public Anim (ImageView imageView,PersoImg p,String d){
		this.imageView=imageView;
		this.p=p;
		direction=d;
		System.out.println(this.p);
		setCycleDuration(Duration.millis(750));
        setInterpolator(Interpolator.LINEAR);
	}
	public void setDirection(String d) {
		direction=d;
	}
	
	protected void interpolate(double k) {
	       int index = Math.min((int) Math.floor(k * count), count - 1);
	       Rectangle2D r;
	       if (index != lastIndex) {
	           switch(direction) {
	           	case "z":
	           		switch(index) {
	           		case 0:
	           			r=new Rectangle2D(48,48*3,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setY(p.getCase().getY()-6);
	           			imageView.setY(p.getCase().getY());
	           			break;
	           		case 1:
	           			r=new Rectangle2D(48*2,48*3,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setY(p.getCase().getY()-6);
	           			imageView.setY(p.getCase().getY());
	           			break;
	           		case 2:
	           			r=new Rectangle2D(48,48*3,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setY(p.getCase().getY()-6);
	           			imageView.setY(p.getCase().getY());
	           			break;
	           		case 3:
	           			r=new Rectangle2D(0,48*3,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setY(p.getCase().getY()-6);
	           			imageView.setY(p.getCase().getY());
	           			break;
	           		}
	           		break;
	           	case "s":
	           		switch(index) {
	           		case 0:
	           			r=new Rectangle2D(48,0,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setY(p.getCase().getY()+6);
	           			imageView.setY(p.getCase().getY());
	           			break;
	           		case 1:
	           			r=new Rectangle2D(48*2,0,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setY(p.getCase().getY()+6);
	           			imageView.setY(p.getCase().getY());
	           			break;
	           		case 2:
	           			r=new Rectangle2D(48,0,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setY(p.getCase().getY()+6);
	           			imageView.setY(p.getCase().getY());
	           			break;
	           		case 3:
	           			r=new Rectangle2D(0,0,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setY(p.getCase().getY()+6);
	           			imageView.setY(p.getCase().getY());
	           			break;
	           		}
	           		break;
	           	case "q":
	           		switch(index) {
	           		case 0:
	           			r=new Rectangle2D(48,48,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setX(p.getCase().getX()-6);
	           			imageView.setX(p.getCase().getX());
	           			break;
	           		case 1:
	           			r=new Rectangle2D(48*2,48,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setX(p.getCase().getX()-6);
	           			imageView.setX(p.getCase().getX());
	           			break;
	           		case 2:
	           			r=new Rectangle2D(48,48,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setX(p.getCase().getX()-6);
	           			imageView.setX(p.getCase().getX());
	           			break;
	           		case 3:
	           			r=new Rectangle2D(0,48,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setX(p.getCase().getX()-6);
	           			imageView.setX(p.getCase().getX());
	           			break;
	           		}
	           		break;
	           	case "d":
	           		switch(index) {
	           		case 0:
	           			r=new Rectangle2D(48,48*2,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setX(p.getCase().getX()+6);
	           			imageView.setX(p.getCase().getX());
	           			break;
	           		case 1:
	           			r=new Rectangle2D(48*2,48*2,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setX(p.getCase().getX()+6);
	           			imageView.setX(p.getCase().getX());
	           			break;
	           		case 2:
	           			r=new Rectangle2D(48,48*2,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setX(p.getCase().getX()+6);
	           			imageView.setX(p.getCase().getX());
	           			break;
	           		case 3:
	           			r=new Rectangle2D(0,48*2,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setX(p.getCase().getX()+6);
	           			imageView.setX(p.getCase().getX());
	           			break;
	           		}
	           		break;
	           		default:
	           			r=new Rectangle2D(48,0,48,48);
	           			imageView.setViewport(r);
	           			p.getCase().setX(p.getCase().getX()+6);
	           			break;
	           }
	           lastIndex = index;
	       }
	   }

	public ImageView getImageView() {
		return imageView;
	}
	
	public int getIndex() {
		return lastIndex;
	}
	
	public void lancerAnim(String t) {
		direction=t;
		setInterpolator(Interpolator.LINEAR);
		setCycleCount(Animation.INDEFINITE);
        play();
	}
}
