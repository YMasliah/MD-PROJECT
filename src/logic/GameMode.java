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
		AngryBirds.CORE.start();
		bird = new Animal(100,400);
		pig = new Animal();
		pig.setPosX(Math.random() * 500 + 200); // position aléatoire pour le cochon
		pig.setPosY(480);
	}
	
	void work() {
		if (AngryBirds.CORE.getStatus() == Status.processing) {

			// moteur physique
			bird.setPosX(AngryBirds.CORE.velocityX + bird.getPosX());
			bird.setPosY(AngryBirds.CORE.velocityY + bird.getPosY());
			AngryBirds.CORE.velocityY += AngryBirds.CORE.gravity;

			// conditions de victoire
			if (Animal.distance(bird,pig) < 35) {
				AngryBirds.CORE.stop();
				AngryBirds.CORE.message = "Gagné : cliquez pour recommencer.";
				AngryBirds.CORE.score++;
			} else if (bird.getPosX() < 20 || bird.getPosX() > 780 || bird.getPosY() < 0 || bird.getPosY() > 480) {
				AngryBirds.CORE.stop();
				AngryBirds.CORE.message = "Perdu : cliquez pour recommencer.";
			}

			// redessine
			AngryBirds.GCORE.repaint();
		}
	}

	public Animal getBird() {
		return bird;
	}
	public Animal getPig(){
		return pig;
	}

}
