package combat;

import java.util.LinkedList;
import java.util.List;

import etre.Monstre;
import etre.PJ;

public class Combat {
	
	List<PJ> joueur;
	List<Monstre> monstres;
	
	public void addJoueur(PJ player)
	{
		if(joueur==null)joueur=new LinkedList<PJ>();
		joueur.add(player);
	}
	
	public void addMonstre(Monstre monster)
	{
		if(monstres==null)monstres=new LinkedList<Monstre>();
		monstres.add(monster);
	}
	
	public void removeJoueur(int index)
	{
		joueur.remove(index);
	}
	
	public void removeMonstre(int index)
	{
		monstres.remove(index);
	}
	

	/**
	 * pour l'instant c'est du brouillon
	 * 
	 * attaque physique = (0.9*ATT + réussite(PRE)) * ATT(Spell)		PRE = précision de l'arme
	 * attaque magique = (0.8*MAG + 0.1*ESP + réussite(PRE)) * MAG(Spell)
	 * 
	 *  soins prodigués = (0.85*ESP + 0.05 MAG) * ESP(Spell)
	 *  
	 *  dégats reçus physique = si (dégats reçus < ARM) alors HP = HP - 0.5 * dégats reçuts
	 *  						sinon HP = HP - 0.9 * dégats reçus
	 *  
	 *  pareil pour les dégats reçus magique mais par rapport à ESP
	 */
	
	public void deroulementCombat(int idJ,int idM)
	{
		int indexJ=0,indexM=0;
		boolean j=false,m=false;
		while(j==false)
		{
			if(joueur.get(indexJ).getId()==idJ)j=true;
			else indexJ++;
		}
		while(m==false)
		{
			if(monstres.get(indexM).getId()==idM)m=true;
			else indexM++;
		}
		if(monstres.get(indexM).getArm()>=joueur.get(indexJ).getAtt())
		{
			if((joueur.get(indexJ).getAtt()%2)==0)monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(joueur.get(indexJ).getAtt()/2+joueur.get(indexJ).getAttaques().get(1)));
			else monstres.get(indexM).setHp(monstres.get(indexM).getHp()-((joueur.get(indexJ).getAtt()-1)/2+joueur.get(indexJ).getAttaques().get(1)));
		}
		else monstres.get(indexM).setHp(monstres.get(indexM).getHp()-joueur.get(indexJ).getAtt()-joueur.get(indexJ).getAttaques().get(1));
		if(monstres.get(indexM).getHp()<=0)removeMonstre(indexM);
	}

	@Override
	public String toString() {
		return "Combat [joueur=" + joueur + ", monstres=" + monstres + "]";
	}
	
}
