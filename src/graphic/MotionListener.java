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
public class MotionListener implements Listener, MouseListener, MouseMotionListener {	
	private MotionListener() {
	}

	private static MotionListener INSTANCE;
	
	public synchronized static MotionListener getMotionListener() {
		if (INSTANCE == null) {
			INSTANCE = new MotionListener();
		}
		return INSTANCE;
	}
	
	// gestion des événements souris
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
		if (AngryBirds.CORE.getStatus() == Status.game_over) {
			AngryBirds.GAMEMODE.init();
		} else if (AngryBirds.CORE.getStatus() == Status.playable) {
			AngryBirds.CORE.launchBird(((MouseEvent) e).getX(), ((MouseEvent) e).getY());
		}
		AngryBirds.GCORE.repaint();
	}

	/* (non-Javadoc)
	 * @see graphic.Listener#mouvement(java.awt.Event)
	 */
	@Override
	public void mouvement(ComponentEvent e) {
		AngryBirds.GCORE.setPosX(((MouseEvent) e).getX());
		AngryBirds.GCORE.setPosY(((MouseEvent) e).getY());
		AngryBirds.GCORE.repaint();
		
	}
}
