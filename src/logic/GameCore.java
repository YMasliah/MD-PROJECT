package logic;

import java.util.ArrayList;

import bean.animal.Bird;
import bean.animal.Pig;
import bean.withgravity.Oven;

/**
 * 
 * 
 * @author Arthur
 *
 *         abstract class
 * 
 *         Faire un builder de cette classe , qui s'occupe de tout les
 *         paramètres envoyés au thread , gravité , nombre d'animaux regrouper
 *         init et start car il sont appelé au meme moment pour faire la meme
 *         chose KAppa
 * 
 * 
 * 
 */
public abstract class GameCore {
	public enum Status {
		playable, processing, try_again, game_over
	}

	private final int velocityXPower = 20;
	private final int velocityYPower = 20;

	private Bird bird;
	private ArrayList<Pig> pigs = new ArrayList<>();
	private ArrayList<Oven> ovens = new ArrayList<>();
	private String message; // message � afficher en haut de l'�cran
	private Status status;
	private int score; // nombre de fois o� le joueur a gagn�

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getScore() {
		return score;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getVelocityXPower() {
		return velocityXPower;
	}

	public int getVelocityYPower() {
		return velocityYPower;
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

	public void setOvens(ArrayList<Oven> ovens) {
		this.ovens = ovens;
	}
}