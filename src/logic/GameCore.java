package logic;

import main.AngryBirds;

public class GameCore{
	public enum Status {
		playable, processing, try_again, game_over
	}
	
	private static GameCore INSTANCE;
	double velocityX, velocityY; // informations relatives � l'oiseau
	double gravity; // gravit�
	String message; // message � afficher en haut de l'�cran
	Status status = Status.playable;
	int score; // nombre de fois o� le joueur a gagn�
	
	// constructeur
	private GameCore() {
		gravity = 0.1;
		score = 0;
		init();
	}

	/**
	 * faut mettre syncrhonized sinon sa marche pas.
	 * parce que une classe runnable sa bug a la creation singleton sinon
	 * @return
	 */
	public synchronized static GameCore getGameCore() {
		if (INSTANCE == null) {
			INSTANCE = new GameCore();
		}
		return INSTANCE;
	}
	
	// calcule la distance entre deux points
	static double distance(double x1, double y1, double x2, double y2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		return Math.sqrt(dx * dx + dy * dy);
	}

	// d�but de partie
	public void init() {
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
		velocityX = (AngryBirds.GMODE.getBirdX() - x) / 20.0;
		velocityY = (AngryBirds.GMODE.getBirdY() - y) / 20.0;
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