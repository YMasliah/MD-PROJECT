/**
 * 
 */
package logic;

import logic.GameCore.Status;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class GameMode {
	double birdX, birdY;
	double pigX, pigY; // informations relatives au cochon
	
	private static GameMode INSTANCE;
	
	GameMode(){
		init();
		new Thread(new Runner()).start();
	}
	
	/**
	 * faut mettre syncrhonized sinon sa marche pas.
	 * parce que une classe runnable sa bug a la creation singleton sinon
	 * @return
	 */
	public synchronized static GameMode getGameMode() {
		if (INSTANCE == null) {
			INSTANCE = new GameMode();
		}
		return INSTANCE;
	}

	// début de partie
	public void init() {
		AngryBirds.CORE.init();
		birdX = 100;
		birdY = 400;
		pigX = Math.random() * 500 + 200; // position aléatoire pour le cochon
		pigY = 480;
	}
	
	void work() {
		if (AngryBirds.CORE.getStatus() == Status.processing) {

			// moteur physique
			birdX += AngryBirds.CORE.velocityX;
			birdY += AngryBirds.CORE.velocityY;
			AngryBirds.CORE.velocityY += AngryBirds.CORE.gravity;

			// conditions de victoire
			if (GameCore.distance(birdX, birdY, pigX, pigY) < 35) {
				AngryBirds.CORE.stop();
				AngryBirds.CORE.message = "Gagné : cliquez pour recommencer.";
				AngryBirds.CORE.score++;
			} else if (birdX < 20 || birdX > 780 || birdY < 0 || birdY > 480) {
				AngryBirds.CORE.stop();
				AngryBirds.CORE.message = "Perdu : cliquez pour recommencer.";
			}

			// redessine
			AngryBirds.GCORE.repaint();
		}
	}
	
	public double getBirdX() {
		return birdX;
	}

	public void setBirdX(double birdX) {
		this.birdX = birdX;
	}

	public double getBirdY() {
		return birdY;
	}

	public void setBirdY(double birdY) {
		this.birdY = birdY;
	}

	public double getPigX() {
		return pigX;
	}

	public void setPigX(double pigX) {
		this.pigX = pigX;
	}

	public double getPigY() {
		return pigY;
	}

	public void setPigY(double pigY) {
		this.pigY = pigY;
	}

}
