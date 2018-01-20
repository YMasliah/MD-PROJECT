package logic;

/**
 * 
 * 
 * @author Arthur
 *
 *         abstract class
 * 
 *         Faire un builder de cette classe , qui s'occupe de tout les
 *         paramètres envoyés au thread , gravité , nombre d'animaux
 *         regrouper init et start car il sont appelé au meme moment pour faire
 *         la meme chose KAppa
 * 
 * 
 * 
 */
public abstract class GameCore {
	public enum GameStatus {
		playable, processing, try_again, game_over
	}

	private final int velocityXPower = 20;
	private final int velocityYPower = 20;

	private String message; // message � afficher en haut de l'�cran
	private GameStatus status;

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getVelocityXPower() {
		return velocityXPower;
	}

	public int getVelocityYPower() {
		return velocityYPower;
	}
}