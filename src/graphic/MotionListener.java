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
	
	// gestion des �v�nements souris
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
		if (AngryBirds.GAMECORE.getStatus() == Status.game_over || AngryBirds.GAMECORE.getStatus() == Status.try_again) {
			AngryBirds.GAMEMODE.init();
		} else if (AngryBirds.GAMECORE.getStatus() == Status.playable) {
			AngryBirds.GAMEMODE.setBirdCount(AngryBirds.GAMEMODE.getBirdCount()-1);
			AngryBirds.GAMECORE.launchBird(((MouseEvent) e).getX(), ((MouseEvent) e).getY());
		}
		AngryBirds.GRAPHICCORE.repaint();
	}

	/* (non-Javadoc)
	 * @see graphic.Listener#mouvement(java.awt.Event)
	 */
	@Override
	public void mouvement(ComponentEvent e) {
		AngryBirds.GRAPHICCORE.setPosX(((MouseEvent) e).getX());
		AngryBirds.GRAPHICCORE.setPosY(((MouseEvent) e).getY());
		AngryBirds.GRAPHICCORE.repaint();
		
	}
}
