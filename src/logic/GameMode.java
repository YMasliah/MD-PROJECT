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
import bean.withgravity.GameGravity;
import bean.withgravity.Oven;
import bean.withgravity.Vent;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class GameMode extends GameCore {

	private ArrayList<IGravity> gravity_list = new ArrayList<>();
	private Collision collision_manager = new Collision();
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
		AngryBirds.GRAPHICCORE.addElement("OVEN");

		// gravity_list.add(new GameGravity(0.1)); //
		// gravity_list.add(new Vent(0.1)); //
	}

	/**
	 * debut de partie a refaire
	 */
	public void newRound() {
		collision_manager.clearManager();
		if (lives < 1 || getPigs().size() == 0) {
			if (lives == 0) {
				setScore(0);
			}
			setStatus(Status.game_over);
			lives = birdCountInit;
		} else {
			setStatus(Status.try_again);
		}

		setBird(new Bird(100, 400));

		if (getStatus() == Status.game_over) {
			setPigs(new ArrayList<>());
			for (int i = 0; i < pigCountInit; i++) {
				getPigs().add(new Pig(Math.random() * 500 + 200, 480 - Math.random() * 100));
			}
			setOvens(new ArrayList<>());
			getOvens().add(new Oven(Math.random() * 500 + 100, 300));
		}

		collision_manager.add_bird(getBird());
		collision_manager.add_animal(getPigs());

		collision_manager.add_ovens(getOvens());
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
		setBirdCount(getBirdCount() - 1);
		getBird().setVelocityX((getBird().getPosX() - x) / getVelocityXPower());
		getBird().setVelocityY((getBird().getPosY() - y) / getVelocityYPower());
		setStatus(Status.processing);
		setMessage("L'oiseau prend sont envol");
	}

	@SuppressWarnings("unchecked")
	void work() {
		if (getStatus() == Status.processing) {

			// moteur physique

			getBird().setPosX(getBird().getVelocityX() + getBird().getPosX());
			getBird().setPosY(getBird().getVelocityY() + getBird().getPosY());
			// test gravité
			GameGravity g = new GameGravity(0.15);
			g.agis_sur(getBird());
			int CHECK = collision_manager.CheckCollision(); //
			if (CHECK == 2) {
				GameGravity blackhole = new GameGravity(-0.2);
				blackhole.agis_sur(getBird());
			}
			// conditions de victoire
			if (collision_manager.CheckCollision() == 1) {
				// si il y collision on regarde avec quel cochon et on le delete
				ArrayList<Pig> pigs_copy = (ArrayList<Pig>) getPigs().clone();
				for (int i = 0; i < pigs_copy.size(); i++) {
					if (pigs_copy.get(i).isCollided()) {

						getPigs().remove(i);
					}
				}

				stop();
				setMessage("Gagn� : cliquez pour recommencer.");
				setScore(getScore() + 1);
			} else if (getBird().getPosX() < 20 || getBird().getPosX() > 780 || getBird().getPosY() < 0
					|| getBird().getPosY() > 480) {
				stop();
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
		if (getStatus() == Status.game_over || getStatus() == Status.try_again) {
			newRound();
		} else if (getStatus() == Status.playable) {
			launchBird(((MouseEvent) e).getX(), ((MouseEvent) e).getY());
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

}
