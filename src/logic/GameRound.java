/**
 * 
 */
package logic;

import java.util.ArrayList;

import bean.CollidableObject;
import bean.ObjectWithGravityAura;
import bean.animal.Bird;
import bean.withgravity.GameGravity;
import bean.withgravity.Oven;
import bean.withgravity.Vent;

/**
 * @author masliah yann
 *
 */
public class GameRound {

	public enum RoundStatus {
		try_again, round_win, round_lost
	}
	
	private int lives;
	private int score; // nombre de fois o� le joueur a gagn�
	private ArrayList<ObjectWithGravityAura> gravity_list = new ArrayList<>();
	
	private Bird bird;
	private ArrayList<CollidableObject> pigs = new ArrayList<>();
	private ArrayList<CollidableObject> otherObjects = new ArrayList<>();
	
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
	public RoundStatus processing() {
		if(getPigs().size() == 0) {
			return RoundStatus.round_win;
		}
		else if(lives==0){
			return RoundStatus.round_lost;
		}
		else {
			return RoundStatus.try_again;
		}
	}
	
	public Bird getBird() {
		return bird;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}

	public ArrayList<CollidableObject> getPigs() {
		return pigs;
	}

	public void setPigs(ArrayList<CollidableObject> pigs) {
		this.pigs = pigs;
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

	public ArrayList<ObjectWithGravityAura> getGravity_list() {
		return gravity_list;
	}

	public void setGravity_list(ArrayList<ObjectWithGravityAura> gravity_list) {
		this.gravity_list = gravity_list;
	}

	public void addOven(Oven oven) {
		gravity_list.add(oven);
	}

	public ArrayList<CollidableObject> getOtherObjects() {
		return otherObjects;
	}

	public void addOtherObjects(CollidableObject otherObjects) {
		this.otherObjects.add(otherObjects);
	}
	
	public void setOtherObjects(ArrayList<CollidableObject> otherObjects) {
		this.otherObjects = otherObjects;
	}
}
