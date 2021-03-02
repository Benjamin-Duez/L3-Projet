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
		int tour=1,i=0,j=0;
		while(!joueur.isEmpty()&!monstres.isEmpty())
		{
			System.out.println("Debut du tour " + tour);
			joueur.forEach(item->item.setBouclier(0));
			for(i=0;i<joueur.size();i++)
			{
				if(!monstres.isEmpty())
				{
					System.out.println("Quelle competence voulez-vous utilisez?");
					Scanner scanner = new Scanner(System.in);
					int numero_competence=scanner.nextInt();
					if(numero_competence==1||numero_competence==2) 
					{
						System.out.println("Qui voulez-vous attaquez?");
						int adversaire=scanner.nextInt();
						this.deroulementCombatAttaque(i,adversaire, numero_competence);
					}
					else if(numero_competence==3)
					{
						System.out.println("Qui voulez-vous soignez?");
						int allie=scanner.nextInt();
						this.deroulementCombatSoin(i,allie, numero_competence);
					}
					else if(numero_competence==4)
					{
						joueur.get(i).setBouclier(joueur.get(i).calcul_competence(numero_competence));
					}
					System.out.println(monstres);
					
				}
			}
		}
	}
	
	public void deroulementCombatAttaque(int indexJ,int indexM,int competence_choisi)
	{
		switch(competence_choisi)
		{
		case 1:
			if(monstres.get(indexM).getArm()>=joueur.get(indexJ).getAtt())
			{
				monstres.get(indexM).setHp(monstres.get(indexM).getHp()-joueur.get(indexJ).calcul_competence(competence_choisi));
			}
			else monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(2*joueur.get(indexJ).calcul_competence(competence_choisi)));
			break;
		case 2:
			if(monstres.get(indexM).getEsp()>=joueur.get(indexJ).getMag())
			{
				monstres.get(indexM).setHp(monstres.get(indexM).getHp()-joueur.get(indexJ).calcul_competence(competence_choisi));
			}
			else monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(2*joueur.get(indexJ).calcul_competence(competence_choisi)));
			break;
		}
		if(monstres.get(indexM).getHp()<=0)
		{
			for(int i=0;i<joueur.size();i++)
			{
				if(monstres.get(indexM).getExp_gagne()+joueur.get(i).getExp()>=joueur.get(i).getExp_limit())
				{
					joueur.get(i).setExp((monstres.get(indexM).getExp_gagne()+joueur.get(i).getExp())-joueur.get(i).getExp_limit());
					System.out.println(monstres.get(indexM).getExp_gagne());
					joueur.get(i).levelUp();
				}
				else joueur.get(i).setExp(monstres.get(indexM).getExp_gagne()+joueur.get(i).getExp());
			}
			removeMonstre(indexM);
		}
	}

	public void deroulementCombatSoin(int indexJ1,int indexJ2,int competence_choisi)
	{
		if(joueur.get(indexJ2).getHp()+joueur.get(indexJ1).calcul_competence(competence_choisi)>joueur.get(indexJ2).getHp_max()) 
		{
			joueur.get(indexJ2).setHp(joueur.get(indexJ2).getHp_max());
		}
		else {
			joueur.get(indexJ2).setHp(joueur.get(indexJ2).getHp()+joueur.get(indexJ1).calcul_competence(competence_choisi));
		}
	}
	
	@Override
	public String toString() {
		return "Combat [joueur=" + joueur + ", monstres=" + monstres + "]";
	}
	
}
