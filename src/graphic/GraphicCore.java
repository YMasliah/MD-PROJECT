/**
 * 
 */
package graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import logic.Core;
import logic.Core.Status;

/**
 * @author masliah yann
 *
 */
public class GraphicCore extends Panel implements  MouseListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Core core = Core.getCore();
	private static GraphicCore INSTANCE = new GraphicCore();
	Image buffer; // image pour le rendu hors écran
	int mouseX, mouseY; // position de la souris lors de la sélection
	
	GraphicCore(){
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
    public static GraphicCore getGraphicCore()
    {   return INSTANCE;
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
		repaint();
	}

	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		repaint();
	}
	
	// évite les scintillements
	public void update(Graphics g) {
		paint(g);
	}

	// dessine le contenu de l'écran dans un buffer puis copie le buffer à l'écran
	public void paint(Graphics g2) {
		if (buffer == null)
			buffer = createImage(800, 600);
		Graphics2D g = (Graphics2D) buffer.getGraphics();

		// fond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		// décor
		g.setColor(Color.BLACK);
		g.drawLine(0, 500, 800, 500);
		g.drawLine(100, 500, 100, 400);

		// oiseau
		g.setColor(Color.RED);
		if (core.getStatus() == Status.playable)
			g.drawLine((int) core.getBirdX(), (int) core.getBirdY(), mouseX, mouseY); // montre l'angle et la vitesse
		g.fillOval((int) core.getBirdX() - 20, (int) core.getBirdY() - 20, 40, 40);

		// cochon
		g.setColor(Color.GREEN);
		g.fillOval((int) core.getPigX() - 20, (int) core.getPigY() - 20, 40, 40);

		// messages
		g.setColor(Color.BLACK);
		g.drawString(core.getMessage(), 300, 100);
		g.drawString("score: " + core.getScore(), 20, 20);

		// affichage à l'écran sans scintillement
		g2.drawImage(buffer, 0, 0, null);
	}

	// taille de la fenêtre
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}
}
