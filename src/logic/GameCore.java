package logic;

import java.util.ArrayList;

import bean.Gravity;
import bean.Pig;
import logic.GameCore.Status;
import main.AngryBirds;

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
public class GameCore {
	public enum Status {
		playable, processing, try_again, game_over
	}

	private static GameCore INSTANCE;

	private double velocityX, velocityY; // informations relatives � l'oiseau
	private Gravity gravity;
	private String message; // message � afficher en haut de l'�cran
	private Status status;
	private int score; // nombre de fois o� le joueur a gagn�

	// constructeur
	private GameCore() {
		gravity = new Gravity();
		gravity.setGravity(0.1);
		this.score = 0;
		start();
	}

	public synchronized static GameCore getGameCore() {
		if (INSTANCE == null) {
			INSTANCE = new GameCore();
		}
		return INSTANCE;
	}

	// d�but de partie
	public void start() {
		setStatus(Status.playable);
		velocityX = 0;
		velocityY = 0;
		message = "Choisissez l'angle et la vitesse.";
	}

	// fin de partie
	void stop() {
		velocityX = 0;
		velocityY = 0;
		setStatus(Status.game_over);

	}

	public void launchBird(int x, int y) {
		velocityX = (AngryBirds.GAMEMODE.getBird().getPosX() - x) / 20.0;
		velocityY = (AngryBirds.GAMEMODE.getBird().getPosY() - y) / 20.0;
		status = Status.processing;
		message = "L'oiseau prend sont envol";
	}

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

	public double getVelocityX() {
		return velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public Gravity getGravity() {
		return gravity;
	}

	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setScore(int score) {
		this.score = score;
	}

}