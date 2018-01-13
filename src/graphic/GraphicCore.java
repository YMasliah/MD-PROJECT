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

import logic.GameCore.Status;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 *         J'arrive pas a sortir les Listeners si je les sort. ben il veut pas
 *         repaint quand c'est le listener qui demande.
 */
public class GraphicCore extends Panel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static GraphicCore INSTANCE;
	MotionListener motionListener;
	Image buffer; // image pour le rendu hors écran
	int posX, posY; // position de la souris lors de la sélection

	private GraphicCore() {
		motionListener = new MotionListener();
		addMouseListener(motionListener);
		addMouseMotionListener(motionListener);
	}

	public synchronized static GraphicCore getGraphicCore() {
		if (INSTANCE == null) {
			INSTANCE = new GraphicCore();
		}
		return INSTANCE;
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
		if (AngryBirds.CORE.getStatus() == Status.playable)
			g.drawLine((int) AngryBirds.GMODE.getBirdX(), (int) AngryBirds.GMODE.getBirdY(), posX, posY); // montre l'angle et la vitesse
		g.fillOval((int) AngryBirds.GMODE.getBirdX() - 20, (int) AngryBirds.GMODE.getBirdY() - 20, 40, 40);

		// cochon
		g.setColor(Color.GREEN);
		g.fillOval((int) AngryBirds.GMODE.getPigX() - 20, (int) AngryBirds.GMODE.getPigY() - 20, 40, 40);

		// messages
		g.setColor(Color.BLACK);
		g.drawString(AngryBirds.CORE.getMessage(), 300, 100);
		g.drawString("score: " + AngryBirds.CORE.getScore(), 20, 20);

		// affichage à l'écran sans scintillement
		g2.drawImage(buffer, 0, 0, null);
	}

	// taille de la fenêtre
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
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
