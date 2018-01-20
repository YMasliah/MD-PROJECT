/**
 * 
 */
package graphic;

import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import logic.GameCore.Status;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class GraphicCoreWithMotionListener extends GraphicCore implements Listener, MouseListener, MouseMotionListener {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int posX, posY; // position de la souris lors de la sélection
	
	private GraphicCoreWithMotionListener() {
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	private static GraphicCoreWithMotionListener INSTANCE;
	
	public synchronized static GraphicCoreWithMotionListener getGraphicCoreWithMotionListener() {
		if (INSTANCE == null) {
			INSTANCE = new GraphicCoreWithMotionListener();
		}
		return INSTANCE;
	}
	
	// gestion des ï¿½vï¿½nements souris
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		action(e);
	}

	public void mouseDragged(MouseEvent e) {
		mouvement(e);
	}

	public void mouseMoved(MouseEvent e) {
		mouvement(e);
	}

	/* (non-Javadoc)
	 * @see graphic.Listener#action(java.awt.Event)
	 */
	@Override
	public void action(ComponentEvent e) {
		if (AngryBirds.GAMEMODE.getStatus() == Status.game_over || AngryBirds.GAMEMODE.getStatus() == Status.try_again) {
			AngryBirds.GAMEMODE.newRound();
		} else if (AngryBirds.GAMEMODE.getStatus() == Status.playable) {
			AngryBirds.GAMEMODE.launchBird(((MouseEvent) e).getX(), ((MouseEvent) e).getY());
		}
		repaint();
	}

	/* (non-Javadoc)
	 * @see graphic.Listener#mouvement(java.awt.Event)
	 */
	@Override
	public void mouvement(ComponentEvent e) {
		setPosX(((MouseEvent) e).getX());
		setPosY(((MouseEvent) e).getY());
		repaint();
	}
	
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
}
