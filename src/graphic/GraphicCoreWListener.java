/**
 * 
 */
package graphic;

import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class GraphicCoreWListener extends GraphicCore implements MouseListener, MouseMotionListener {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int posX, posY; // position de la souris lors de la selection
	
	private GraphicCoreWListener() {
		super();
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	private static GraphicCoreWListener INSTANCE;
	
	public synchronized static GraphicCoreWListener getGraphicCoreWithMotionListener() {
		if (INSTANCE == null) {
			INSTANCE = new GraphicCoreWListener();
		}
		return INSTANCE;
	}

	/* (non-Javadoc)
	 * @see graphic.Listener#mouvement(java.awt.Event)
	 */
	public void mouvement(ComponentEvent e) {
		setPosX(((MouseEvent) e).getX());
		setPosY(((MouseEvent) e).getY());
		repaint();
	}
	
	// gestion des evenements souris
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
		AngryBirds.GAMEMODE.action(e);
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		mouvement(e);
	}

	public void mouseMoved(MouseEvent e) {
		mouvement(e);
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
