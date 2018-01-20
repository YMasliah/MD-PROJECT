/**
 * 
 */
package logic;

import java.util.ArrayList;

import bean.Bird;
import bean.Gravity;
import bean.Oven;
import bean.Pig;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class GameMode extends GameCore {

	private ArrayList<Oven> ovens = new ArrayList<>();
	private ArrayList<Gravity> gravity_list = new ArrayList<>();
	
	private final int pigCountInit;
	private final int birdCountInit;
	
	private int lives;
	
	private static GameMode INSTANCE;

	/**
	 * ca serra dans un builder je crois plus tard
	 */
	GameMode() {
		setScore(0);
		lives = 0;
		pigCountInit = 2;
		birdCountInit = 4;
		init();
		newRound();
		start();
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
	
	private void init() {
		AngryBirds.GRAPHICCORE.addElement("BACKGROUND");
		AngryBirds.GRAPHICCORE.addElement("DECOR");
		AngryBirds.GRAPHICCORE.addElement("BIRD");
		AngryBirds.GRAPHICCORE.addElement("PIG");
		AngryBirds.GRAPHICCORE.addElement("MESSAGES");
		
		gravity_list.add(new Gravity(0.1)); //
	}
	
	// d�but de partie
	public void newRound() {
		if(lives < 1 || getPigs().size() == 0) {
			if(lives==0){
				setScore(0);
			}
			setStatus(Status.game_over);
			lives = birdCountInit;
		}else{
			setStatus(Status.try_again);
		}
		
		setBird(new Bird(100, 400));
		
		if(getStatus() == Status.game_over) {
			setPigs(new ArrayList<>());
			for(int i = 0; i<pigCountInit;i++) {
				getPigs().add(new Pig(Math.random() * 500 + 200,480 - Math.random() * 100));
			}
		}
		start();
	}

	// d�but de partie
	public void start() {
		setStatus(Status.playable);
		setMessage("Choisissez l'angle et la vitesse.");
	}

	// fin de partie
	void stop() {
		getBird().setVelocityX(0);
		getBird().setVelocityY(0);
		setStatus(Status.try_again);
	}

	public void launchBird(int x, int y) {
		setBirdCount(getBirdCount()-1);
		getBird().setVelocityX((getBird().getPosX() - x) / getVelocityXPower());
		getBird().setVelocityY((getBird().getPosY() - y) / getVelocityYPower());
		setStatus(Status.processing);
		setMessage("L'oiseau prend sont envol");
	}
	
	void work() {
		if (getStatus() == Status.processing) {

			// moteur physique
			getBird().setPosX(getBird().getVelocityX() + getBird().getPosX());
			getBird().setPosY(getBird().getVelocityY() + getBird().getPosY());
			//getBird()
				//	.setVelocityY(getBird().getVelocityY() + AngryBirds.GAMECORE.getGravity().getGravity());
			
			for (Gravity g : gravity_list){
				g.agis_sur(getBird());
				
				for (Pig p : getPigs())
					g.agis_sur(p);
			}

			// conditions de victoire
			for(int i = getPigs().size()-1; i>= 0 ; i--) {
				if (Collision.distance(getBird(), getPigs().get(i)) < 35) {
					getPigs().remove(i);
					stop();
					setMessage("Gagn� : cliquez pour recommencer.");
					setScore(getScore() + 1);
				} else if (getBird().getPosX() < 20 || getBird().getPosX() > 780 || getBird().getPosY() < 0 || getBird().getPosY() > 480) {
					stop();
					setMessage("Perdu : cliquez pour recommencer.");
				}
			}
			// redessine
			AngryBirds.GRAPHICCORE.repaint();
		}
	}

	public int getBirdCount() {
		return lives;
	}

	public void setBirdCount(int birdCount) {
		this.lives = birdCount;
	}

	public int getPigCountInit() {
		return pigCountInit;
	}

	public int getBirdCountInit() {
		return birdCountInit;
	}

	public ArrayList<Oven> getOvens() {
		// TODO Auto-generated method stub
		return ovens;
	}

	
}
