package gui;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BoutonMonstre extends BoutonEtre {
	
	private static int i;
	private String type;

	public BoutonMonstre(Pane root,int x, int y, String type) {
		super(root, type, x, y,"monstre "+i);
		this.type=type;
		i+=1;
		pointer=new ImageView(new Image(new File(dossierURL+"/img/Interface/pointer2.png").toURI().toString()));
		imgV.setImage(new Image(new File(dossierURL+"/img/mob/"+this.type+".png").toURI().toString(),100,100,false,false));
		imgV.setOpacity(1);
		root.getChildren().add(pointer);
		pointer.setMouseTransparent(true);
		pointer.setOpacity(0);pointer.setX(x+25);pointer.setY(y-50);
		t.setOpacity(0);
	}
	
	@Override
	public void mouseReleased() {
		System.out.println(nom+": "+t.getText());
	}
}
