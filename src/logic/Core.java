package logic;

import java.awt.Dimension;
import main.AngryBirds;

public class Core{
	public enum Status {
		playable, processing, game_over
	}
	
	private static Core INSTANCE = new Core();
	double birdX, birdY, velocityX, velocityY; // informations relatives � l'oiseau
	double pigX, pigY; // informations relatives au cochon
	double gravity; // gravit�
	String message; // message � afficher en haut de l'�cran
	Status status = Status.playable;
	int score; // nombre de fois o� le joueur a gagn�
	
	// constructeur
	Core() {
		gravity = 0.1;
		score = 0;
		init();
		new Thread(new Runner()).start();
	}

	/**
	 * faut mettre syncrhonized sinon sa marche pas.
	 * parce que une classe runnable sa bug a la creation singleton sinon
	 * @return
	 */
	public synchronized static Core getCore() {
		if (INSTANCE == null) {
			INSTANCE = new Core();
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
		birdX = 100;
		birdY = 400;
		velocityX = 0;
		velocityY = 0;
		pigX = Math.random() * 500 + 200; // position al�atoire pour le cochon
		pigY = 480;
		message = "Choisissez l'angle et la vitesse.";
	}

	// fin de partie
	void stop() {
		velocityX = 0;
		velocityY = 0;
		setStatus(Status.game_over);
	}

	void work() {
		if (status == Status.processing) {

			// moteur physique
			birdX += velocityX;
			birdY += velocityY;
			velocityY += gravity;

			// conditions de victoire
			if (distance(birdX, birdY, pigX, pigY) < 35) {
				stop();
				message = "Gagn� : cliquez pour recommencer.";
				score++;
			} else if (birdX < 20 || birdX > 780 || birdY < 0 || birdY > 480) {
				stop();
				message = "Perdu : cliquez pour recommencer.";
			}

			// redessine
			AngryBirds.GCORE.repaint();
		}
	}
	
	// taille de la fen�tre
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}



	public void launchBird(int x, int y) {
		velocityX = (birdX - x) / 20.0;
		velocityY = (birdY - y) / 20.0;
		status = Status.processing;
		message = "L'oiseau prend sont envol";
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public double getBirdX() {
		return birdX;
	}

	public double getBirdY() {
		return birdY;
	}

	public double getPigX() {
		return pigX;
	}

	public double getPigY() {
		return pigY;
	}

	public int getScore() {
		return score;
	}
	
	public String getMessage() {
		return message;
	}
}