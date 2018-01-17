/**
 * 
 */
package logic;

import bean.Animal;
import logic.GameCore.Status;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class GameMode {

	Animal bird;
	Animal pig;
	private static GameMode INSTANCE;

	GameMode() {
		init();
		new Thread(new Runner()).start();
	}

	/**
	 * faut mettre syncrhonized sinon sa marche pas. parce que une classe
	 * runnable sa bug a la creation singleton sinon
	 * 
	 * @return
	 */
	public synchronized static GameMode getGameMode() {
		if (INSTANCE == null) {
			INSTANCE = new GameMode();
		}
		return INSTANCE;
	}

	// d�but de partie
	public void init() {
		AngryBirds.GAMECORE.start();
		bird = new Animal(100, 400);
		pig = new Animal();
		pig.setPosX(Math.random() * 500 + 200); // position al�atoire pour le
		// cochon
pig.setPosY(480);
	}

	void work() {
		if (AngryBirds.GAMECORE.getStatus() == Status.processing) {

			// moteur physique
			bird.setPosX(AngryBirds.GAMECORE.getVelocityX() + bird.getPosX());
			bird.setPosY(AngryBirds.GAMECORE.getVelocityY() + bird.getPosY());
			AngryBirds.GAMECORE.setVelocityY(AngryBirds.GAMECORE.getVelocityY() + AngryBirds.GAMECORE.getGravity().getGravity());

			// conditions de victoire
			if (Animal.distance(bird, pig) < 35) {
				AngryBirds.GAMECORE.stop();
				AngryBirds.GAMECORE.setMessage("Gagn� : cliquez pour recommencer.");
				AngryBirds.GAMECORE.setScore(AngryBirds.GAMECORE.getScore() + 1);
			} else if (bird.getPosX() < 20 || bird.getPosX() > 780 || bird.getPosY() < 0 || bird.getPosY() > 480) {
				AngryBirds.GAMECORE.stop();
				AngryBirds.GAMECORE.setMessage("Perdu : cliquez pour recommencer.");
			}

			// redessine
			AngryBirds.GRAPHICCORE.repaint();
		}
	}

	public Animal getBird() {
		return bird;
	}

	public Animal getPig() {
		return pig;
	}

}
