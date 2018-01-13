package logic;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import graphic.GraphicCore;

public class Core implements Runnable {

	public enum Status {
		playable, processing, game_over
	}

	private Status status = Status.playable;
	private static GraphicCore gCore = GraphicCore.getGraphicCore();
	private static Core INSTANCE = new Core();

	double birdX, birdY, velocityX, velocityY; // informations relatives à l'oiseau
	double pigX, pigY; // informations relatives au cochon
	double gravity; // gravité
	String message; // message à afficher en haut de l'écran

	public String getMessage() {
		return message;
	}

	int score; // nombre de fois où le joueur a gagné

	// calcule la distance entre deux points
	static double distance(double x1, double y1, double x2, double y2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		return Math.sqrt(dx * dx + dy * dy);
	}

	// constructeur
	Core() {
		gravity = 0.1;
		score = 0;
		init();
		new Thread(this).start();
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

	// début de partie
	public void init() {
		setStatus(Status.playable);
		birdX = 100;
		birdY = 400;
		velocityX = 0;
		velocityY = 0;
		pigX = Math.random() * 500 + 200; // position aléatoire pour le cochon
		pigY = 480;
		message = "Choisissez l'angle et la vitesse.";
	}

	// fin de partie
	void stop() {
		velocityX = 0;
		velocityY = 0;
		setStatus(Status.game_over);
	}

	// boucle qui calcule la position de l'oiseau en vol, effectue l'affichage et
	// teste les conditions de victoire
	public void run() {
		while (true) {
			// un pas de simulation toutes les 10ms
			try {
				Thread.currentThread();
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}

			if (status == Status.processing) {

				// moteur physique
				birdX += velocityX;
				birdY += velocityY;
				velocityY += gravity;

				// conditions de victoire
				if (distance(birdX, birdY, pigX, pigY) < 35) {
					stop();
					message = "Gagné : cliquez pour recommencer.";
					score++;
				} else if (birdX < 20 || birdX > 780 || birdY < 0 || birdY > 480) {
					stop();
					message = "Perdu : cliquez pour recommencer.";
				}

				// redessine
				gCore.repaint();
			}
		}
	}

	// taille de la fenêtre
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}

	// met le jeu dans une fenêtre
	public static void main(String args[]) {
		Frame frame = new Frame("Oiseau pas content");
		final GraphicCore obj = gCore;
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		frame.add(obj);
		frame.pack();
		frame.setVisible(true);
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
}