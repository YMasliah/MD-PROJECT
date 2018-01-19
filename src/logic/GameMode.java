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

	private Bird bird;
	private ArrayList<Pig> pigs = new ArrayList<>();
	
	private final int pigCountInit;
	private final int birdCountInit;
	
	private int birdCount = 0;
	
	private static GameMode INSTANCE;

	/**
	 * ca serra dans un builder je crois plus tard
	 */
	GameMode() {
		pigCountInit = 2;
		birdCountInit = 4;
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
		if(birdCount < 1 || pigs.size() == 0) {
			if(birdCount==0){
				AngryBirds.GAMECORE.setScore(0);
			}
			AngryBirds.GAMECORE.setStatus(Status.game_over);
			birdCount = birdCountInit;
		}else{
			AngryBirds.GAMECORE.setStatus(Status.try_again);
		}
		
		
		bird = new Bird(100, 400);
		
		if(AngryBirds.GAMECORE.getStatus() == Status.game_over) {
			pigs = new ArrayList<>();
			for(int i = 0; i<pigCountInit;i++) {
				pigs.add(new Pig(Math.random() * 500 + 200,480 - Math.random() * 100));
			}
		}
		AngryBirds.GAMECORE.start();
	}

	void work() {
		if (AngryBirds.GAMECORE.getStatus() == Status.processing) {

			// moteur physique
			bird.setPosX(AngryBirds.GAMECORE.getVelocityX() + bird.getPosX());
			bird.setPosY(AngryBirds.GAMECORE.getVelocityY() + bird.getPosY());
			AngryBirds.GAMECORE
					.setVelocityY(AngryBirds.GAMECORE.getVelocityY() + AngryBirds.GAMECORE.getGravity().getGravity());

			// conditions de victoire
			for(int i = pigs.size()-1; i>= 0 ; i--) {
				if (Animal.distance((Animal)bird, (Animal)pigs.get(i)) < 35) {
					pigs.remove(i);
					AngryBirds.GAMECORE.stop();
					AngryBirds.GAMECORE.setMessage("Gagn� : cliquez pour recommencer.");
					AngryBirds.GAMECORE.setScore(AngryBirds.GAMECORE.getScore() + 1);
				} else if (bird.getPosX() < 20 || bird.getPosX() > 780 || bird.getPosY() < 0 || bird.getPosY() > 480) {
					AngryBirds.GAMECORE.stop();
					AngryBirds.GAMECORE.setMessage("Perdu : cliquez pour recommencer.");
				}
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

	public int getBirdCount() {
		return birdCount;
	}

	public void setBirdCount(int birdCount) {
		this.birdCount = birdCount;
	}

	public int getPigCountInit() {
		return pigCountInit;
	}

	public int getBirdCountInit() {
		return birdCountInit;
	}

	public void setBird(Bird bird) {
		this.bird = bird;
	}

	public void setPigs(ArrayList<Pig> pigs) {
		this.pigs = pigs;
	}

	
}
