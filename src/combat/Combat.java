package combat;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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
	
	public void deroulementCombatTour()
	{
		int i=0,j=0;
		while(!joueur.isEmpty()&!monstres.isEmpty())
		{
			for(i=0;i<joueur.size();i++)
			{
				System.out.println("Qui voulez-cous attaquez?");
				Scanner scanner = new Scanner(System.in);
				int adversaire_allie=scanner.nextInt();
				System.out.println("Avec quelle attaque?");
				int numero_attaque=scanner.nextInt();
				this.deroulementCombat(i,adversaire_allie, numero_attaque);
				System.out.println(monstres);
			}
		}
	}
	
	public void deroulementCombat(int indexJ,int indexM,int attaque_choisi)
	{
		switch(attaque_choisi)
		{
		case 1:
			if(monstres.get(indexM).getArm()>=joueur.get(indexJ).getAtt())
			{
				monstres.get(indexM).setHp(monstres.get(indexM).getHp()-joueur.get(indexJ).calcul_degats_infliges(attaque_choisi));
			}
			else monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(2*joueur.get(indexJ).calcul_degats_infliges(attaque_choisi)));
			break;
		case 2:
			if(monstres.get(indexM).getEsp()>=joueur.get(indexJ).getMag())
			{
				monstres.get(indexM).setHp(monstres.get(indexM).getHp()-joueur.get(indexJ).calcul_degats_infliges(attaque_choisi));
			}
			else monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(2*joueur.get(indexJ).calcul_degats_infliges(attaque_choisi)));
			break;
		case 3:
			
		}
		if(monstres.get(indexM).getHp()<=0)
		{
			for(int i=0;i<joueur.size();i++)
			{
				joueur.get(i).setExp(monstres.get(indexM).getExp_gagne());
				if(joueur.get(i).getExp()>=joueur.get(i).getExp_limit())joueur.get(i).levelUp();
			}
			removeMonstre(indexM);
		}
	}

	@Override
	public String toString() {
		return "Combat [joueur=" + joueur + ", monstres=" + monstres + "]";
	}
	
}
