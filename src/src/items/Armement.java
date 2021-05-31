package items;

import java.util.LinkedList;
import java.util.List;

public class Armement extends Item{

	String nom;
	int hp_max;
	int mp_max;
	int att; //attaque
	int mag; //magie
	int esp; //soins + armure magique
	int arm; //armure physique
	List<Armes> armes;
	List<Armures> armures;
	List<Accessoires> accessoires;	
	
	public void ajoutArmure(Armures armure)
	{
		if(armures==null)armures=new LinkedList<Armures>();
		armures.add(armure);
	}
	
	public void ajoutArme(Armes arme)
	{
		if(armes==null)armes=new LinkedList<Armes>();
		armes.add(arme);
	}
	
	public void ajoutAccessoires(Accessoires accessoire)
	{
		if(accessoires==null)accessoires=new LinkedList<Accessoires>();
		accessoires.add(accessoire);
	}
	
}
