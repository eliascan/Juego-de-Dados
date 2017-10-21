
public class JeuCraps {

	/* LES ATTRIBUTS */
	private int deLancer1, deLancer2, deLancer3, deLancer4;
	private char score;
	private boolean premLancer;
	
	/* LE CONSTRUCTEUR QUI INITIALISE LES ATTRIBUTS */
	public JeuCraps() {
		this.deLancer1 = 0;
		this.deLancer2 = 0;
		this.deLancer3 = 0;
		this.deLancer4 = 0;
		this.premLancer = true;
	}

	/* LES METHODES D'ACCESS */
	public void setDeLancer1(int deLancer1) {
		this.deLancer1 = deLancer1;
	}

	public void setDeLancer2(int deLancer2) {
		this.deLancer2 = deLancer2;
	}
	
	public void setDeLancer3(int deLancer3) {
		this.deLancer3 = deLancer3;
	}

	public void setDeLancer4(int deLancer4) {
		this.deLancer4 = deLancer4;
	}
	
	public void setScore(char score) {
		this.score = score;
	}
	
	public void setPremLancer(boolean premLancer) {
		this.premLancer = premLancer;
	}
	
	public int getDeLancer1() {
		return deLancer1;
	}
	
	public int getDeLancer2() {
		return deLancer2;
	}

	public int getDeLancer3() {
		return deLancer3;
	}

	public int getDeLancer4() {
		return deLancer4;
	}

	public char getScore() {
		return score;
	}

	public boolean isPremLancer() {
		return premLancer;
	}

	/* LES METHODES */
	
	public void jouer() {
		int somme1 = 0; //Variable pour obtenir les sommes des lancers
		
		/* PREMIER LANCER */
		if (isPremLancer() == true) {
			setDeLancer1(lancer());
			setDeLancer2(lancer());
			somme1 = getDeLancer1() + getDeLancer2();

			/* POUR LE SCORE */
			if (somme1 == 7 || somme1 == 11) {
				setScore('G');
			} else if (somme1 == 2 || somme1 == 3 || somme1 == 12) {
				setScore('P');
			} else {
				setScore('D');
			}
			
		} 
		
		/* SI IL FAUT RELANCER */
		if (isPremLancer() == false){
				setDeLancer3(lancer());
				setDeLancer4(lancer());
		}
	}

	public int lancer(){
		int de;
		double temp;
		temp = Math.random() * 6;
		de = (int) Math.floor(temp) + 1;
		return de;
	}
	
	public boolean aGagner() {
		return getScore() == 'G';
	}
	
	public boolean estRelance() {
		return getScore() == 'D';
	}	
}
