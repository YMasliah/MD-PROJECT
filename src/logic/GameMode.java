/**
 * 
 */
package logic;

import java.util.ArrayList;

import bean.Animal;
import bean.Bird;
import bean.Pig;
import logic.GameCore.Status;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class GameMode {

	Bird bird;
	ArrayList<Pig> pigs = new ArrayList<>();
	
	final int pigCountInit;
	final int birdCountInit;
	
	Collision gestionnaire_collision = new Collision();
	
	int pigCount = 0;
	int birdCount = 0;
	
	private static GameMode INSTANCE;

	/**
	 * ca serra dans un builder je crois plus tard
	 */
	GameMode() {
		pigCountInit = 2;
		birdCountInit = 1;
		AngryBirds.GRAPHICCORE.addElement("BACKGROUND");
		AngryBirds.GRAPHICCORE.addElement("DECOR");
		AngryBirds.GRAPHICCORE.addElement("BIRD");
		AngryBirds.GRAPHICCORE.addElement("PIG");
		AngryBirds.GRAPHICCORE.addElement("MESSAGES");
		init();
		new Thread(new Runner()).start();
	}

	/**
	 * faut mettre syncrhonized sinon sa marche pas. parce que une classe runnable
	 * sa bug a la creation singleton sinon
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
		if(birdCount < 1) {
			AngryBirds.GAMECORE.setStatus(Status.game_over);
			birdCount = birdCountInit;
		}
		bird = new Bird(100, 400);
		gestionnaire_collision.liste_animaux.add(bird);
		
		if(AngryBirds.GAMECORE.getStatus() == Status.game_over) {
			pigCount = pigCountInit;
			pigs = new ArrayList<>();
			for(int i = 0; i<pigCount;i++) {
				pigs.add(new Pig(Math.random() * 500 + 200,480));
				gestionnaire_collision.add_animal(pigs);
			}
			AngryBirds.GAMECORE.setStatus(Status.playable);
		}
		
	}

	void work() {
		if (AngryBirds.GAMECORE.getStatus() == Status.processing) {

			// moteur physique
			bird.setPosX(AngryBirds.GAMECORE.getVelocityX() + bird.getPosX());
			bird.setPosY(AngryBirds.GAMECORE.getVelocityY() + bird.getPosY());
			AngryBirds.GAMECORE
					.setVelocityY(AngryBirds.GAMECORE.getVelocityY() + AngryBirds.GAMECORE.getGravity().getGravity());

			// conditions de victoire
			if (gestionnaire_collision.CheckCollision() == 1) {
				AngryBirds.GAMECORE.stop();
				AngryBirds.GAMECORE.setMessage("Gagné : cliquez pour recommencer.");
				AngryBirds.GAMECORE.setScore(AngryBirds.GAMECORE.getScore() + 1);
			}
			
			else if (bird.getPosX() < 20 || bird.getPosX() > 780 || bird.getPosY() < 0 || bird.getPosY() > 480) {
				AngryBirds.GAMECORE.stop();
				AngryBirds.GAMECORE.setMessage("Perdu : cliquez pour recommencer.");
			}
			// redessine
			AngryBirds.GRAPHICCORE.repaint();
		}
	}

	public Bird getBird() {
		return bird;
	}

	public ArrayList<Pig> getPigs() {
		return pigs;
	}

}
