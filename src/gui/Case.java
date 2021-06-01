package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Case extends Rectangle{
	
	private boolean disponible;

    /**@param x centre x
     * @param y centre y
     * @param rayon rayon!
     * */
	
	public Case(double x, double y) {
        super(48, 48, Color.RED);
        setX(x);setY(y);
        setOpacity(0);
        disponible=true;
    }
}
