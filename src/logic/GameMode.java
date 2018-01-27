/**
 * 
 */
package logic;

import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import bean.Animal;
import bean.CollidableObject;
import bean.IGravity;
import bean.animal.Bird;
import bean.animal.Pig;
import bean.obstacle.Wall;
import bean.withgravity.Oven;
import logic.GameRound.RoundStatus;
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
		initGraphicCore();
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

	private void initGraphicCore() {
		AngryBirds.GRAPHICCORE.addElement("BACKGROUND");
		AngryBirds.GRAPHICCORE.addElement("DECOR");
		AngryBirds.GRAPHICCORE.addElement("MESSAGES");
		AngryBirds.GRAPHICCORE.addElement("LIFE");
	}

	public void roundProcessing() {
		if (round == null || round.processing() == RoundStatus.round_lost) {
			round = new GameRound(birdCountInit);
			round.setBird(new Bird(100, 400));
			round.addOtherObjects(new Wall());
			round.addOven(new Oven(Math.random() * 500 + 100, 200, -0.1));
			round.setPigs(new ArrayList<>());
			for (int i = 0; i < pigCountInit; i++) {
				round.getPigs().add(new Pig(Math.random() * 500 + 200, 480 - Math.random() * 100));
			}
			setMessage("Choisissez l'angle et la vitesse.");
			setStatus(GameStatus.playable);
		} else if (round.processing() == RoundStatus.round_win) {
			round.setBird(new Bird(100, 400));
			round.setPigs(new ArrayList<>());
			for (int i = 0; i < pigCountInit; i++) {
				round.getPigs().add(new Pig(Math.random() * 500 + 200, 480 - Math.random() * 100));
			}
			round.setLives(getBirdCountInit());
			setMessage("Choisissez l'angle et la vitesse.");
			setStatus(GameStatus.playable);
		} else if (round.processing() == RoundStatus.try_again && getStatus() == GameStatus.try_again) {
			round.setBird(new Bird(100, 400));
			setMessage("Choisissez l'angle et la vitesse.");
			setStatus(GameStatus.playable);
		}

		collisionManager.clearManager();
		collisionManager.addCollidableObject(round.getBird());
		collisionManager.addCollidableObjects(round.getPigs());
		collisionManager.addCollidableObjects(round.getOtherObjects());
		collisionManager.addCollidableGravityObject(round.getGravity_list());

	}

	public void launchBird(int x, int y) {
		double tempX = (round.getBird().getPosX() - x) / getVelocityXPower();
		double tempY = (round.getBird().getPosY() - y) / getVelocityYPower();

		if (tempX > 5)
			tempX = 5;
		else if (tempX < -5)
			tempX = -5;
		if (tempY > 10)
			tempY = 10;
		else if (tempY < -10)
			tempY = -10;

		round.getBird().setVelocityX(tempX);
		round.getBird().setVelocityY(tempY);
		setStatus(GameStatus.processing);
		setMessage("L'oiseau prend sont envol");
	}

	public void work() {
		if (getStatus() == GameStatus.processing) {

			// moteur physique
			round.getBird().setPosX(round.getBird().getVelocityX() + round.getBird().getPosX());
			round.getBird().setPosY(round.getBird().getVelocityY() + round.getBird().getPosY());

			for (CollisionReturnValue col : collisionManager.CheckCollision()) {
				switch (col.getCollisionType()) {
				case OVEN:
					((Oven) col.getObjectJ()).agis_sur((Animal) col.getObjectI());
					break;
				case PIG:
					round.getPigs().remove(round.getPigs().indexOf(((Pig) col.getObjectJ())));
					if (round.processing() == RoundStatus.round_win) {
						setStatus(GameStatus.try_again);
						setMessage("Gagn� : cliquez pour recommencer.");
					} else {
						roundProcessing();
					}
					round.setScore(round.getScore() + 1);
					break;
				case WALL:
					setStatus(GameStatus.try_again);
					round.setLives(round.getLives() - 1);
					setMessage("Perdu : cliquez pour recommencer.");
					break;
				default:
					break;
				}
			}

			for (IGravity g : round.getGravity_list()) {
				if (g instanceof Oven)
					continue;
				g.agis_sur(round.getBird());

				for (CollidableObject p : round.getPigs())
					g.agis_sur((Animal) p);

			}
			
			if (Math.abs(round.getBird().getVelocityY()) < 0.15  && round.getBird().getPosY() > 460) {
				setStatus(GameStatus.try_again);
				System.out.println(round.getBird().getVelocityY());
				round.setLives(round.getLives() - 1);
				setMessage("Perdu : cliquez pour recommencer.");
			}
			
			// redessine
			AngryBirds.GRAPHICCORE.repaint();
		}
	}

	/**
	 * the user perform an action like pressing a button
	 * 
	 * @param e
	 */
	public void action(ComponentEvent e) {
		if (getStatus() == GameStatus.processing)
			return;
		if (getStatus() != GameStatus.playable) {
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

	public ArrayList<CollidableObject> getCollisionList() {
		return collisionManager.getListeObjects();
	}
}
