package combat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import etre.Monstre;
import etre.PJ;

public class Combat {
	
	List<PJ> joueur;
	List<Monstre> monstres;
	double tour=1;
	
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
	
	public void deroulementCombat(ArrayList<String> ordre)
	{
		System.out.println("Debut du tour "+tour);
		if(!joueur.isEmpty()&!monstres.isEmpty())
		{
			for(int i=0;i<joueur.size();i++)
			{
				String[] separer=ordre.get(i).split(";");
				deroulementCombatTourJ(separer);	
			}
			System.out.println(monstres);
			ArrayList<String> temp = new ArrayList<String>();
			temp=ordreMonstre(monstres.size());
			for(int j=0;j<monstres.size();j++)
			{
				String[] separer=temp.get(j).split(";");
				deroulementCombatTourM(separer);	
			}
		}
	}
	
	public ArrayList<String> ordreMonstre(int taille)
	{
		ArrayList<String> ordreM =new ArrayList<String>();
		for(int i=0;i<taille;i++)
		{
			String test=new String();
			int competence_alea= 1 + (int)(Math.random() * ((4 - 1) + 1));
			if(competence_alea==1||competence_alea==2)
			{
				int adversaire_choisi= (int)(Math.random() * ((joueur.size()-1) + 1));	
				if(competence_alea==1) test=i+";Attaque;joueur "+adversaire_choisi;
				else test=i+";Magie;joueur "+adversaire_choisi;
			}
			else if(competence_alea==3)
			{
				int allie_choisi= (int)(Math.random() * ((joueur.size()-1) + 1));	
				test=i+";Soin;monstre "+allie_choisi;
			}
			else test=i+";Défense";
			ordreM.add(test);
		}
		System.out.println(ordreM);
		return ordreM;
	}
	
	public void deroulementCombatTourJ(String[] separer)
	{
		int i1=0,i2=0;
		joueur.forEach(item->item.setBouclier(0));
		if(!monstres.isEmpty())
		{
			System.out.println(separer[0]);
			switch(separer[0])
			{
			case "cac":i1=0;break;
			case "tank":i1=1;break;
			case "sorcier":i1=2;break;
			case "pretre":i1=3;break;
			}
			int numero_competence=0;
			switch(separer[1])
			{
			case "Attaque":numero_competence=1;break;
			case "Magie":numero_competence=2;break;
			case "Soin":numero_competence=3;break;
			case "Défense":numero_competence=4;break;
			}
			
			if(numero_competence==1||numero_competence==2) 
			{
				switch(separer[2])
				{
				case "monstre 0":i2=0;break;
				case "monstre 1":i2=1;break;
				case "monstre 2":i2=2;break;
				case "monstre 3":i2=3;break;
				}
				if(i2>monstres.size()-1)i2=0;
				this.deroulementCombatAttaqueJ(i1,i2, numero_competence);
			}
			else if(numero_competence==3)
			{
				switch(separer[2])
				{
				case "cac":i2=0;break;
				case "tank":i2=1;break;
				case "sorcier":i2=2;break;
				case "pretre":i2=3;break;
				}
				if(i2>joueur.size()-1)i2=0;
				this.deroulementCombatSoinJ(i1,i2, numero_competence);
			}
			else if(numero_competence==4)
			{
				joueur.get(i1).setBouclier(joueur.get(i1).calcul_competence(numero_competence));
			}
		}
	}
	
	public void deroulementCombatTourM(String[] separer)
	{
		int competence_alea=0,j1=0,j2=0;
		monstres.forEach(item->item.setBouclier(0));
		if(!joueur.isEmpty())
		{
			switch(separer[0])
			{
			case"0":j1=0;break;
			case"1":j1=1;break;
			case"2":j1=2;break;
			case"3":j1=3;break;
			}
			switch(separer[1])
			{
			case "Attaque":competence_alea=1;break;
			case "Magie":competence_alea=2;break;
			case "Soin":competence_alea=3;break;
			case "Défense":competence_alea=4;break;
			}
			if(competence_alea==1||competence_alea==2) 
			{
				switch(separer[2])
				{
				case "joueur 0":j2=0;break;
				case "joueur 1":j2=1;break;
				case "joueur 2":j2=2;break;
				case "joueur 3":j2=3;break;
				}	
				if(j2>joueur.size()-1)j2=0;
				this.deroulementCombatAttaqueM(j1,j2, competence_alea);
			}
			else if(competence_alea==3)
			{
				switch(separer[2])
				{
				case "monstre 0":j2=0;break;
				case "monstre 1":j2=1;break;
				case "monstre 2":j2=2;break;
				case "monstre 3":j2=3;break;
				}
				if(j2>monstres.size()-1)j2=0;
				this.deroulementCombatSoinM(j1,j2, competence_alea);
			}
			else if(competence_alea==4)
			{
				monstres.get(j1).setBouclier(monstres.get(j1).calcul_competence(competence_alea));
			}
		}
	}
	
	public void deroulementCombatAttaqueJ(int indexJ,int indexM,int competence_choisi) //Perte de vie d'un monstre
	{
		switch(competence_choisi)
		{
		case 1:
			if(monstres.get(indexM).getArm()>=joueur.get(indexJ).getAtt())
			{
				if(monstres.get(indexM).getBouclier()>((joueur.get(indexJ).calcul_competence(competence_choisi))/2))
				{
					monstres.get(indexM).setBouclier(monstres.get(indexM).getBouclier()-(joueur.get(indexJ).calcul_competence(competence_choisi))/2);
				}
				else if(monstres.get(indexM).getBouclier()!=0)
				{
					int temp=(joueur.get(indexJ).calcul_competence(competence_choisi))/2;
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(temp-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).setBouclier(0);
				}
				else monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(joueur.get(indexJ).calcul_competence(competence_choisi))/2);
			}
			else monstres.get(indexM).setHp(monstres.get(indexM).getHp()-joueur.get(indexJ).calcul_competence(competence_choisi));
			break;
		case 2:
			if(monstres.get(indexM).getEsp()>=joueur.get(indexJ).getMag())
			{
				if(monstres.get(indexM).getBouclier()>((joueur.get(indexJ).calcul_competence(competence_choisi))/2))
				{
					monstres.get(indexM).setBouclier(monstres.get(indexM).getBouclier()-(joueur.get(indexJ).calcul_competence(competence_choisi))/2);
				}
				else if(monstres.get(indexM).getBouclier()!=0)
				{
					int temp=(joueur.get(indexJ).calcul_competence(competence_choisi))/2;
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(temp-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).setBouclier(0);
				}
				else monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(joueur.get(indexJ).calcul_competence(competence_choisi))/2);
			}
			else 
			{
				if(monstres.get(indexM).getBouclier()>joueur.get(indexJ).calcul_competence(competence_choisi))
				{
					monstres.get(indexM).setBouclier(monstres.get(indexM).getBouclier()-joueur.get(indexJ).calcul_competence(competence_choisi));
				}
				else if(monstres.get(indexM).getBouclier()!=0)
				{
					int temp=joueur.get(indexJ).calcul_competence(competence_choisi);
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(temp-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).setBouclier(0);
				}
				else monstres.get(indexM).setHp(monstres.get(indexM).getHp()-joueur.get(indexJ).calcul_competence(competence_choisi));
				monstres.get(indexM).setHp(monstres.get(indexM).getHp()-joueur.get(indexJ).calcul_competence(competence_choisi));
			}
			break;
		}
		if(monstres.get(indexM).getHp()<=0) //Mort d'un monstre
		{
			for(int i=0;i<joueur.size();i++)
			{
				if((monstres.get(indexM).getExp_gagne()+joueur.get(i).getExp())>=joueur.get(i).getExp_limit())
				{
					joueur.get(i).setExp(monstres.get(indexM).getExp_gagne()-joueur.get(i).getExp_limit());
					joueur.get(i).levelUp();
				}
				else joueur.get(i).setExp(monstres.get(indexM).getExp_gagne());
			}
			removeMonstre(indexM);
		}
	}

	public void deroulementCombatAttaqueM(int indexM,int indexJ,int competence_alea) //perte de vie d'un héros
	{
		int temp=monstres.get(indexM).calcul_competence(competence_alea);
		switch(competence_alea)
		{
		case 1:
			if(joueur.get(indexJ).getArm()>=monstres.get(indexM).getAtt())
			{
				temp/=2;
				if(joueur.get(indexJ).getBouclier()>temp)
				{
					joueur.get(indexJ).setBouclier(joueur.get(indexJ).getBouclier()-temp);
				}
				else if(joueur.get(indexJ).getBouclier()!=0)
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-(temp-joueur.get(indexJ).getBouclier()));
					joueur.get(indexJ).setBouclier(0);
				}
				else joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-temp);
			}
			else 
			{
				if(joueur.get(indexJ).getBouclier()>temp)
				{
					joueur.get(indexJ).setBouclier(joueur.get(indexJ).getBouclier()-temp);
				}
				else if(joueur.get(indexJ).getBouclier()!=0)
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-(temp-joueur.get(indexJ).getBouclier()));
					joueur.get(indexJ).setBouclier(0);
				}
				else joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-temp);
			}
			break;
		case 2:
			if(joueur.get(indexJ).getEsp()>=monstres.get(indexM).getMag())
			{
				temp/=2;
				if(joueur.get(indexJ).getBouclier()>temp)
				{
					joueur.get(indexJ).setBouclier(joueur.get(indexJ).getBouclier()-temp);
				}
				else if(joueur.get(indexJ).getBouclier()!=0)
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-(temp-joueur.get(indexJ).getBouclier()));
					joueur.get(indexJ).setBouclier(0);
				}
				else joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-temp);
			}
			else 
			{
				if(joueur.get(indexJ).getBouclier()>temp)
				{
					joueur.get(indexJ).setBouclier(joueur.get(indexJ).getBouclier()-temp);
				}
				else if(joueur.get(indexJ).getBouclier()!=0)
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-(temp-joueur.get(indexJ).getBouclier()));
					joueur.get(indexJ).setBouclier(0);
				}
				else joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-temp);
			}
			break;
		}
		if(joueur.get(indexJ).getHp()<=0) 
			{
				joueur.get(indexJ).setHp(0);
				removeJoueur(indexJ); //Mort d'un héros
			}
	}

	
	public void deroulementCombatSoinJ(int indexJ1,int indexJ2,int competence_choisi)
	{
		if(joueur.get(indexJ2).getHp()+joueur.get(indexJ1).calcul_competence(competence_choisi)>joueur.get(indexJ2).getHp_max()) 
		{
			joueur.get(indexJ2).setHp(joueur.get(indexJ2).getHp_max());
		}
		else {
			joueur.get(indexJ2).setHp(joueur.get(indexJ2).getHp()+joueur.get(indexJ1).calcul_competence(competence_choisi));
		}
	}
	
	public void deroulementCombatSoinM(int indexM1,int indexM2,int competence_alea)
	{
		if(monstres.get(indexM2).getHp()+monstres.get(indexM1).calcul_competence(competence_alea)>monstres.get(indexM2).getHp_max()) 
		{
			monstres.get(indexM2).setHp(monstres.get(indexM2).getHp_max());
		}
		else {
			monstres.get(indexM2).setHp(monstres.get(indexM2).getHp()+monstres.get(indexM1).calcul_competence(competence_alea));
		}
	}
	
	@Override
	public String toString() {
		return "Combat [joueur=" + joueur + ", monstres=" + monstres + "]";
	}
	
}
