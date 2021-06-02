package combat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import animation.AnimVictoire;
import etre.Monstre;
import etre.PJ;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Combat{
	
	List<PJ> joueur;
	List<Monstre> monstres;
	ArrayList<String> ordreJ;
	List<String> ordreM;
	Timeline littleCycle;	
	boolean phase;

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
	public void ordreMonstre(int taille)
	{
		ordreM =new ArrayList<String>();
		for(int i=0;i<taille;i++)
		{
			String test=new String();
			int competence_alea= 1 + (int)(Math.random() * ((4 - 1) + 1));
			if(competence_alea==1||competence_alea==2)
			{
				int adversaire_choisi= (int)(Math.random() * ((joueur.size()-1) + 1));	
				if(competence_alea==1) test="monstre "+i+";Attaque;joueur "+adversaire_choisi;
				else test="monstre "+i+";Magie;joueur "+adversaire_choisi;
			}
			else if(competence_alea==3)
			{
				int allie_choisi= (int)(Math.random() * ((joueur.size()-1) + 1));	
				test="monstre "+i+";Soin;monstre "+allie_choisi;
			}
			else test="monstre "+i+";Défense";
			ordreM.add(test);
		}
	}
	
	public void deroulementCombat(ArrayList<String> ordre)
	{
		this.ordreJ=ordre;
		littleCycle = new Timeline(new KeyFrame(Duration.millis(1000),
                event -> {
                	
                	if(!joueur.isEmpty()&&!monstres.isEmpty())
                	{
	                	if(!phase) {
							if(!ordre.isEmpty()) {
								String[] separer=this.ordreJ.get(0).split(";");
								this.ordreJ.remove(0);
								deroulementCombatTourJ(separer);	
								}
							else {
								ordreMonstre(monstres.size());
								phase=true;
								}
	                	}
	                	else {
	        				if(!ordreM.isEmpty()) 
	        				{
	        					String[] separer=ordreM.get(0).split(";");
	        					ordreM.remove(0);
	        					deroulementCombatTourM(separer);
	        				}
	        				else {
	        					joueur.forEach(item->item.getBouton().setup());
	        					monstres.forEach(item->item.getBouton().setup());
	        					phase=false;
	        					littleCycle.stop();
	        				}
	        			}
        			}
                	else {
                		if(monstres.isEmpty()) {
                			littleCycle.stop();
                			System.out.println("Vous avez gagné");
                			AnimVictoire anim=new AnimVictoire(joueur);
                			anim.lancerAnim();
                		}
                		
                	}
                }));
        littleCycle.setCycleCount(Timeline.INDEFINITE);
	}
	
	public void start() {
		phase=false;
		littleCycle.play();
	}
	
	public void deroulementCombatTourJ(String[] separer)
	{
		int i1=-1,i2=-1,k=0,numero_competence=0;
		joueur.forEach(item->item.setBouclier(0));
		if(!monstres.isEmpty())
		{
			System.out.println(separer[0]);
			switch(separer[0])
			{
			case "cac":
				while(k<joueur.size())
				{
					if(joueur.get(k).getClass()==etre.CaC.class)i1=k++;
					else k++;
				}
				k=0;
				break;
			case "tank":
				while(k<joueur.size())
				{
					if(joueur.get(k).getClass()==etre.Tank.class)i1=k++;
					else k++;
				}
				k=0;
				break;
			case "sorcier":
				while(k<joueur.size())
				{
					if(joueur.get(k).getClass()==etre.Sorcier.class)i1=k++;
					else k++;
				}
				k=0;
				break;
			case "pretre":
				while(k<joueur.size())
				{
					if(joueur.get(k).getClass()==etre.Pretre.class)i1=k++;
					else k++;
				}
				k=0;
				break;
			}
			switch(separer[1])
			{
			case "Attaque":numero_competence=1;joueur.get(i1).getBouton().incanteAttaque();break;
			case "Magie":numero_competence=2;joueur.get(i1).getBouton().incanteMagie();break;
			case "Soin":numero_competence=3;joueur.get(i1).getBouton().incanteSoin();break;
			case "Défense":numero_competence=4;joueur.get(i1).getBouton().incanteDéfense();break;
			}
			
			if(numero_competence==1||numero_competence==2) 
			{
				switch(separer[2])
				{
				case "monstre 0":
					while(k<monstres.size())
					{
						if(monstres.get(k).getClass()==etre.Loup.class)i2=k++;
						else k++;
					}
					k=0;
					break;
				case "monstre 1":
					while(k<monstres.size())
					{
						if(monstres.get(k).getClass()==etre.Squelette.class)i2=k++;
						else k++;
					}
					k=0;
					break;
				case "monstre 2":
					while(k<monstres.size())
					{
						if(monstres.get(k).getClass()==etre.Licorne.class)i2=k++;
						else k++;
					}
					k=0;
					break;
				case "monstre 3":
					while(k<monstres.size())
					{
						if(monstres.get(k).getClass()==etre.Sorciere.class)i2=k++;
						else k++;
					}
					k=0;
					break;
				}
				if((i2>monstres.size()-1)||(i2==-1))i2=0;
				this.deroulementCombatAttaqueJ(i1,i2, numero_competence);
			}
			else if(numero_competence==3)
			{
				switch(separer[2])
				{
				case "cac":
					while(k<joueur.size())
					{
						if(joueur.get(k).getClass()==etre.CaC.class)i2=k++;
						else k++;
					}
					k=0;
					break;
				case "tank":
					while(k<joueur.size())
					{
						if(joueur.get(k).getClass()==etre.Tank.class)i2=k++;
						else k++;
					}
					k=0;
					break;
				case "sorcier":
					while(k<joueur.size())
					{
						if(joueur.get(k).getClass()==etre.Sorcier.class)i2=k++;
						else k++;
					}
					k=0;
					break;
				case "pretre":
					while(k<joueur.size())
					{
						if(joueur.get(k).getClass()==etre.Pretre.class)i2=k++;
						else k++;
					}
					k=0;
					break;
				}
				if((i2>joueur.size()-1)||(i2==-1))i2=0;
				this.deroulementCombatSoinJ(i1,i2, numero_competence);
			}
			else if(numero_competence==4)
			{
				joueur.get(i1).setBouclier(joueur.get(i1).calcul_competence(numero_competence));
				joueur.get(i1).getBouton().lanceDéfense();
			}
		}
	}
	
	public void deroulementCombatTourM(String[] separer)
	{
		int competence_alea=0,j1=-1,j2=-1,k=0;
		monstres.forEach(item->item.setBouclier(0));
		if(!joueur.isEmpty())
		{
			switch(separer[0])
			{
			case"monstre 0":
				while(k<monstres.size())
				{
					if(monstres.get(k).getClass()==etre.Loup.class)j1=k++;
					else k++;
				}
				k=0;
			case"monstre 1":
				while(k<monstres.size())
				{
					if(monstres.get(k).getClass()==etre.Squelette.class)j1=k++;
					else k++;
				}
				k=0;
			case"monstre 2":
				while(k<monstres.size())
				{
					if(monstres.get(k).getClass()==etre.Licorne.class)j1=k++;
					else k++;
				}
				k=0;
			case"monstre 3":
				while(k<monstres.size())
				{
					if(monstres.get(k).getClass()==etre.Sorciere.class)j1=k++;
					else k++;
				}
				k=0;
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
				case "joueur 0":
					while(k<joueur.size())
					{
						if(joueur.get(k).getClass()==etre.CaC.class)j2=k++;
						else k++;
					}
					k=0;
					break;
				case "joueur 1":
					while(k<joueur.size())
					{
						if(joueur.get(k).getClass()==etre.Tank.class)j2=k++;
						else k++;
					}
					k=0;
					break;
				case "joueur 2":
					while(k<joueur.size())
					{
						if(joueur.get(k).getClass()==etre.Sorcier.class)j2=k++;
						else k++;
					}
					k=0;
					break;
				case "joueur 3":
					while(k<joueur.size())
					{
						if(joueur.get(k).getClass()==etre.Pretre.class)j2=k++;
						else k++;
					}
					k=0;
					break;
				}
				if((j2>joueur.size()-1)||(j2==-1))j2=0;
				this.deroulementCombatAttaqueM(j1,j2, competence_alea);
			}
			else if(competence_alea==3)
			{
				switch(separer[2])
				{
				case "monstre 0":
					while(k<monstres.size())
					{
						if(monstres.get(k).getClass()==etre.Loup.class)j2=k++;
						else k++;
					}
					k=0;
					break;
				case "monstre 1":
					while(k<monstres.size())
					{
						if(monstres.get(k).getClass()==etre.Squelette.class)j2=k++;
						else k++;
					}
					k=0;
					break;
				case "monstre 2":
					while(k<monstres.size())
					{
						if(monstres.get(k).getClass()==etre.Licorne.class)j2=k++;
						else k++;
					}
					k=0;
					break;
				case "monstre 3":
					while(k<monstres.size())
					{
						if(monstres.get(k).getClass()==etre.Sorciere.class)j2=k++;
						else k++;
					}
					k=0;
					break;
				}
				if((j2>monstres.size()-1)||(j2==-1))j2=0;
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
		int temp=(joueur.get(indexJ).calcul_competence(competence_choisi));
		switch(competence_choisi)
		{
		case 1:
			joueur.get(indexJ).getBouton().lanceAttaque();
			if(monstres.get(indexM).getArm()>=joueur.get(indexJ).getAtt())
			{
				if(monstres.get(indexM).getBouclier()>(temp/2))
				{
					monstres.get(indexM).setBouclier(monstres.get(indexM).getBouclier()-(temp/2));
					monstres.get(indexM).getBouton().prendDegat("Bloqué");
				}
				else if(monstres.get(indexM).getBouclier()!=0)
				{
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(temp/2-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).getBouton().statMAJ();
					monstres.get(indexM).getBouton().prendDegat("-"+(temp/2-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).setBouclier(0);
				}
				else 
				{
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(temp/2));
					monstres.get(indexM).getBouton().prendDegat("-"+temp/2);
					monstres.get(indexM).getBouton().statMAJ();
				}
			}
			else 
			{
				if(monstres.get(indexM).getBouclier()>temp)
				{
					monstres.get(indexM).setBouclier(monstres.get(indexM).getBouclier()-temp);
					monstres.get(indexM).getBouton().prendDegat("Bloqué");
				}
				else if(monstres.get(indexM).getBouclier()!=0)
				{
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(temp-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).getBouton().statMAJ();
					monstres.get(indexM).getBouton().prendDegat("-"+(temp/2-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).setBouclier(0);
				}
				else 
				{
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-temp);
					monstres.get(indexM).getBouton().prendDegat("-"+temp/2);
					monstres.get(indexM).getBouton().statMAJ();
				}
			}
			break;
		case 2:
			joueur.get(indexJ).getBouton().lanceMagie();
			if(monstres.get(indexM).getEsp()>=joueur.get(indexJ).getMag())
			{
				if(monstres.get(indexM).getBouclier()>(temp/2))
				{
					monstres.get(indexM).setBouclier(monstres.get(indexM).getBouclier()-(temp/2));
					monstres.get(indexM).getBouton().prendDegat("Bloqué");
				}
				else if(monstres.get(indexM).getBouclier()!=0)
				{
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(temp/2-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).getBouton().statMAJ();
					monstres.get(indexM).getBouton().prendDegat("-"+(temp/2-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).setBouclier(0);
				}
				else 
				{
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(temp/2));
					monstres.get(indexM).getBouton().prendDegat("-"+temp/2);
					monstres.get(indexM).getBouton().statMAJ();
				}
			}
			else 
			{
				if(monstres.get(indexM).getBouclier()>temp)
				{
					monstres.get(indexM).setBouclier(monstres.get(indexM).getBouclier()-temp);
					monstres.get(indexM).getBouton().prendDegat("Bloqué");
				}
				else if(monstres.get(indexM).getBouclier()!=0)
				{
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-(temp-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).getBouton().statMAJ();
					monstres.get(indexM).getBouton().prendDegat("-"+(temp/2-monstres.get(indexM).getBouclier()));
					monstres.get(indexM).setBouclier(0);
				}
				else 
				{
					monstres.get(indexM).setHp(monstres.get(indexM).getHp()-temp);
					monstres.get(indexM).getBouton().prendDegat("-"+temp/2);
					monstres.get(indexM).getBouton().statMAJ();
				}
			}
			break;
			}
		if(monstres.get(indexM).getHp()<=0) //Mort d'un monstre
		{
			monstres.get(indexM).getBouton().Meurt();
			for(int i=0;i<joueur.size();i++)
			{
				if((monstres.get(indexM).getExp_gagne()+joueur.get(i).getExp())>=joueur.get(i).getExp_limit())
				{
					joueur.get(i).setExp(monstres.get(indexM).getExp_gagne()-joueur.get(i).getExp_limit());
					joueur.get(i).levelUp();
					joueur.get(i).getBouton().statMAJ();
				}
				else
				{
					joueur.get(i).setExp(monstres.get(indexM).getExp_gagne());
				}
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
					joueur.get(indexJ).getBouton().prendDegat("Bloqué");
				}
				else if(joueur.get(indexJ).getBouclier()!=0)
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-(temp-joueur.get(indexJ).getBouclier()));
					joueur.get(indexJ).setBouclier(0);
					joueur.get(indexJ).getBouton().statMAJ();
					joueur.get(indexJ).getBouton().prendDegat("-"+(temp/2-monstres.get(indexM).getBouclier()));
					if(joueur.get(indexJ).getHp()<=0) 
					{
						joueur.get(indexJ).setHp(0);
						joueur.get(indexJ).getBouton().Meurt();
						removeJoueur(indexJ); //Mort d'un héros
					}
				}
				else 
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-temp);
					joueur.get(indexJ).getBouton().statMAJ();
					joueur.get(indexJ).getBouton().prendDegat("-"+(temp));
					if(joueur.get(indexJ).getHp()<=0) 
					{
						joueur.get(indexJ).setHp(0);
						joueur.get(indexJ).getBouton().Meurt();
						removeJoueur(indexJ); //Mort d'un héros
					}
				}
			}
			else 
			{
				if(joueur.get(indexJ).getBouclier()>temp)
				{
					joueur.get(indexJ).setBouclier(joueur.get(indexJ).getBouclier()-temp);
					joueur.get(indexJ).getBouton().prendDegat("Bloqué");
				}
				else if(joueur.get(indexJ).getBouclier()!=0)
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-(temp-joueur.get(indexJ).getBouclier()));
					joueur.get(indexJ).setBouclier(0);
					joueur.get(indexJ).getBouton().statMAJ();
					joueur.get(indexJ).getBouton().prendDegat("-"+(temp/2-monstres.get(indexM).getBouclier()));
					if(joueur.get(indexJ).getHp()<=0) 
					{
						joueur.get(indexJ).setHp(0);
						joueur.get(indexJ).getBouton().Meurt();
						removeJoueur(indexJ); //Mort d'un héros
					}
				}
				else  
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-temp);
					joueur.get(indexJ).getBouton().statMAJ();
					joueur.get(indexJ).getBouton().prendDegat("-"+(temp));
					if(joueur.get(indexJ).getHp()<=0) 
					{
						joueur.get(indexJ).setHp(0);
						joueur.get(indexJ).getBouton().Meurt();
						removeJoueur(indexJ); //Mort d'un héros
					}
				}
			}
			break;
		case 2:
			if(joueur.get(indexJ).getEsp()>=monstres.get(indexM).getMag())
			{
				temp/=2;
				if(joueur.get(indexJ).getBouclier()>temp)
				{
					joueur.get(indexJ).setBouclier(joueur.get(indexJ).getBouclier()-temp);
					joueur.get(indexJ).getBouton().prendDegat("Bloqué");
				}
				else if(joueur.get(indexJ).getBouclier()!=0)
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-(temp-joueur.get(indexJ).getBouclier()));
					joueur.get(indexJ).setBouclier(0);
					joueur.get(indexJ).getBouton().statMAJ();
					joueur.get(indexJ).getBouton().prendDegat("-"+(temp/2-monstres.get(indexM).getBouclier()));
					if(joueur.get(indexJ).getHp()<=0) 
					{
						joueur.get(indexJ).setHp(0);
						joueur.get(indexJ).getBouton().Meurt();
						removeJoueur(indexJ); //Mort d'un héros
					}
				}
				else 
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-temp);
					joueur.get(indexJ).getBouton().statMAJ();
					joueur.get(indexJ).getBouton().prendDegat("-"+(temp));
					if(joueur.get(indexJ).getHp()<=0) 
					{
						joueur.get(indexJ).setHp(0);
						joueur.get(indexJ).getBouton().Meurt();
						removeJoueur(indexJ); //Mort d'un héros
					}
				}
			}
			else 
			{
				if(joueur.get(indexJ).getBouclier()>temp)
				{
					joueur.get(indexJ).setBouclier(joueur.get(indexJ).getBouclier()-temp);
					joueur.get(indexJ).getBouton().prendDegat("Bloqué");
				}
				else if(joueur.get(indexJ).getBouclier()!=0)
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-(temp-joueur.get(indexJ).getBouclier()));
					joueur.get(indexJ).setBouclier(0);
					joueur.get(indexJ).getBouton().statMAJ();
					joueur.get(indexJ).getBouton().prendDegat("-"+(temp/2-monstres.get(indexM).getBouclier()));
					if(joueur.get(indexJ).getHp()<=0) 
					{
						joueur.get(indexJ).setHp(0);
						joueur.get(indexJ).getBouton().Meurt();
						removeJoueur(indexJ); //Mort d'un héros
					}
				}
				else  
				{
					joueur.get(indexJ).setHp(joueur.get(indexJ).getHp()-temp);
					joueur.get(indexJ).getBouton().statMAJ();
					joueur.get(indexJ).getBouton().prendDegat("-"+(temp));
					if(joueur.get(indexJ).getHp()<=0) 
					{
						joueur.get(indexJ).setHp(0);
						joueur.get(indexJ).getBouton().Meurt();
						removeJoueur(indexJ); //Mort d'un héros
					}
				}
			}
			break;
		}
	}

	
	public void deroulementCombatSoinJ(int indexJ1,int indexJ2,int competence_choisi)
	{
		int temp;
		joueur.get(indexJ1).getBouton().lanceSoin();
		if(joueur.get(indexJ2).getHp()+joueur.get(indexJ1).calcul_competence(competence_choisi)>joueur.get(indexJ2).getHp_max()) 
		{
			temp=joueur.get(indexJ2).getHp_max()-joueur.get(indexJ2).getHp();
			joueur.get(indexJ2).setHp(joueur.get(indexJ2).getHp_max());
			joueur.get(indexJ2).getBouton().statMAJ();
			joueur.get(indexJ2).getBouton().prendSoin("+"+(temp));
		}
		else {
			temp=joueur.get(indexJ1).calcul_competence(competence_choisi);
			joueur.get(indexJ2).setHp(joueur.get(indexJ2).getHp()+temp);
			joueur.get(indexJ2).getBouton().statMAJ();
			joueur.get(indexJ2).getBouton().prendSoin("+"+(temp));
		}
	}
	
	public void deroulementCombatSoinM(int indexM1,int indexM2,int competence_alea)
	{
		int temp;
		if(monstres.get(indexM2).getHp()+monstres.get(indexM1).calcul_competence(competence_alea)>monstres.get(indexM2).getHp_max()) 
		{
			temp=monstres.get(indexM2).getHp_max()-monstres.get(indexM2).getHp();
			monstres.get(indexM2).setHp(monstres.get(indexM2).getHp_max());
			monstres.get(indexM2).getBouton().statMAJ();
			monstres.get(indexM2).getBouton().prendSoin("+"+(temp));
		}
		else {
			temp=monstres.get(indexM1).calcul_competence(competence_alea);
			monstres.get(indexM2).setHp(monstres.get(indexM2).getHp()+temp);
			monstres.get(indexM2).getBouton().statMAJ();
			monstres.get(indexM2).getBouton().prendSoin("+"+(temp));
		}
	}
	
	@Override
	public String toString() {
		return "Combat [joueur=" + joueur + ", monstres=" + monstres + "]";
	}
	
}
