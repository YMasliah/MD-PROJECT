package logic;

import main.AngryBirds;

public class GameCore{
	public enum Status {
		playable, processing, try_again, game_over
	}
	
	private static GameCore INSTANCE;
	
	double velocityX, velocityY; // informations relatives à l'oiseau
	double gravity; // gravité
	String message; // message à afficher en haut de l'écran
	Status status;
	int score; // nombre de fois où le joueur a gagné
	
	// constructeur
	private GameCore() {
		status = Status.playable;
		gravity = 0.1;
		score = 0;
		start();
	}

	public synchronized static GameCore getGameCore() {
		if (INSTANCE == null) {
			INSTANCE = new GameCore();
		}
		return INSTANCE;
	}
	

	// début de partie
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
}