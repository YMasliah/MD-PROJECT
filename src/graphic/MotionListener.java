/**
 * 
 */
package graphic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import logic.Core;
import logic.Core.Status;

/**
 * @author masliah yann
 *
 */
@Deprecated
public class MotionListener implements MouseListener, MouseMotionListener {
	private Core core = Core.getCore();
	private GraphicCore gCore = GraphicCore.getGraphicCore();
	
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
		if (core.getStatus() == Status.game_over) {
			core.init();
		} else if (core.getStatus() == Status.playable) {
			core.launchBird(e.getX(), e.getY());
		}
		gCore.repaint();
	}

	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseMoved(MouseEvent e) {
		gCore.setPosX(e.getX());
		gCore.setPosY(e.getY());
		gCore.repaint();
	}
}
