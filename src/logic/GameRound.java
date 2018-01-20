/**
 * 
 */
package logic;

import java.util.ArrayList;

import bean.IGravity;
import bean.animal.Bird;
import bean.animal.Pig;
import bean.withgravity.GameGravity;
import bean.withgravity.Oven;
import bean.withgravity.Vent;
import logic.GameCore.Status;

/**
 * @author masliah yann
 *
 */
public class GameRound {

	private int lives;
	private int score; // nombre de fois o� le joueur a gagn�
	private ArrayList<Oven> ovens = new ArrayList<>();
	private ArrayList<IGravity> gravity_list = new ArrayList<>();
	
	private Bird bird;
	private ArrayList<Pig> pigs = new ArrayList<>();
	
	public GameRound(int lives) {
		this.lives = lives;
		score = 0;
		gravity_list.add(new GameGravity(0.1)); //
		gravity_list.add(new Vent(0.1)); //
	}
	
	/**
	 * debut de partie
	 * a refaire
	 */
	public Status processing() {
		if(getPigs().size() == 0) {
			return Status.processing;
		}
		else if(lives==0){
			return Status.game_over;
		}
		else {
			return Status.try_again;
		}
	}
	
	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}

	public ArrayList<Pig> getPigs() {
		return pigs;
	}

	public void setPigs(ArrayList<Pig> pigs) {
		this.pigs = pigs;
	}

	public ArrayList<Oven> getOvens() {
		return ovens;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public ArrayList<IGravity> getGravity_list() {
		return gravity_list;
	}

	public void setGravity_list(ArrayList<IGravity> gravity_list) {
		this.gravity_list = gravity_list;
	}

	public void setOvens(ArrayList<Oven> ovens) {
		this.ovens = ovens;
	}
}
