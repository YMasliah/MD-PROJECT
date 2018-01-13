/**
 * 
 */
package graphic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import logic.GameCore.Status;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class MotionListener implements MouseListener, MouseMotionListener {	
	public MotionListener() {
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
		if (AngryBirds.CORE.getStatus() == Status.game_over) {
			AngryBirds.GMODE.init();
		} else if (AngryBirds.CORE.getStatus() == Status.playable) {
			AngryBirds.CORE.launchBird(e.getX(), e.getY());
		}
		AngryBirds.GCORE.repaint();
	}

	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseMoved(MouseEvent e) {
		AngryBirds.GCORE.setPosX(e.getX());
		AngryBirds.GCORE.setPosY(e.getY());
		AngryBirds.GCORE.repaint();
	}
}
