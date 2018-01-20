/**
 * 
 */
package logic;

import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import bean.IGravity;
import bean.animal.Bird;
import bean.animal.Pig;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class GameMode extends GameCore {

	private final int pigCountInit;
	private final int birdCountInit;
	
	private GameRound round;
	private Thread thread;
	private Collision collisionManager;

	private static GameMode INSTANCE;

	/**
	 * ca serra dans un builder je crois plus tard
	 */
	private GameMode() {
		collisionManager = new Collision();
		pigCountInit = 2;
		birdCountInit = 4;
		thread = new Thread(new Runner());
		init();
		roundProcessing();
		thread.start();
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
	}
	
	/**
	 * debut de partie
	 * a refaire
	 */
	public void roundProcessing() {
		if(round == null || round.processing() == Status.game_over) {
			round = new GameRound(birdCountInit);
			round.setBird(new Bird(100, 400));
			round.setPigs(new ArrayList<>());
			for(int i = 0; i<pigCountInit;i++) {
				round.getPigs().add(new Pig(Math.random() * 500 + 200,480 - Math.random() * 100));
			}
		} else if(round.processing() == Status.processing) {
			round.setBird(new Bird(100, 400));
			round.setPigs(new ArrayList<>());
			for(int i = 0; i<pigCountInit;i++) {
				round.getPigs().add(new Pig(Math.random() * 500 + 200,480 - Math.random() * 100));
			}
		} else if(round.processing() == Status.try_again) {
			round.setBird(new Bird(100, 400));
		}
		setMessage("Choisissez l'angle et la vitesse.");
		setStatus(Status.playable);
	}

	public void launchBird(int x, int y) {
		round.getBird().setVelocityX((round.getBird().getPosX() - x) / getVelocityXPower());
		round.getBird().setVelocityY((round.getBird().getPosY() - y) / getVelocityYPower());
		setStatus(Status.processing);
		setMessage("L'oiseau prend sont envol");
	}
	
	public void work() {
		if (getStatus() == Status.processing) {

			// moteur physique
			round.getBird().setPosX(round.getBird().getVelocityX() + round.getBird().getPosX());
			round.getBird().setPosY(round.getBird().getVelocityY() + round.getBird().getPosY());
			
			for (IGravity g : round.getGravity_list()){
				g.agis_sur(round.getBird());
				
				for (Pig p : round.getPigs())
					g.agis_sur(p);
			}

			// conditions de victoire
			for(int i = round.getPigs().size()-1; i>= 0 ; i--) {
				if (Collision.distance(round.getBird(), round.getPigs().get(i)) < 35) {
					round.getPigs().remove(i);
					setStatus(Status.try_again);
					setMessage("Gagn� : cliquez pour recommencer.");
					round.setScore(round.getScore() + 1);
				} else if (round.getBird().getPosX() < 20 || round.getBird().getPosX() > 780 || round.getBird().getPosY() < 0 || round.getBird().getPosY() > 480) {
					System.out.println("hi");
					setStatus(Status.try_again);
					round.setLives(round.getLives()-1);
					setMessage("Perdu : cliquez pour recommencer.");
					break;
				}
			}
			// redessine
			AngryBirds.GRAPHICCORE.repaint();
		}
	}

	/**
	 * the user perform an action like pressing a button
	 * @param e
	 */
	public void action(ComponentEvent e) {
		if (getStatus() != Status.playable) {
			roundProcessing();
		} else {
			launchBird(((MouseEvent) e).getX(), ((MouseEvent) e).getY());
		}
	}

	public int getPigCountInit() {
		return pigCountInit;
	}

	public int getBirdCountInit() {
		return birdCountInit;
	}

	public GameRound getRound() {
		return round;
	}

	public void setRound(GameRound round) {
		this.round = round;
	}
}
