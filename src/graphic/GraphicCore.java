/**
 * 
 */
package graphic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.Panel;
import java.util.ArrayList;

import bean.CollidableObject;
import graphic.components.ComponentsFactory;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public abstract class GraphicCore extends Panel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int height = 600;
	private int width = 800;

	private Image buffer; // image pour le rendu hors écran
	private ArrayList<String> elements;

	protected GraphicCore() {
		elements = new ArrayList<>();
	}

	// évite les scintillements
	public void update(Graphics g) {
		paint(g);
	}

	// dessine le contenu de l'écran dans un buffer puis copie le buffer à
	// l'écran
	@SuppressWarnings("unchecked")
	public void paint(Graphics g2) {
		if (buffer == null)
			buffer = createImage(800, 600);
		Graphics2D g = (Graphics2D) buffer.getGraphics();
		
		for(String element : elements) {
			ComponentsFactory.getComponents(element).draw(g);
		}
		ArrayList<CollidableObject> clonedCollisionList = (ArrayList<CollidableObject>) AngryBirds.GAMEMODE.getCollisionList().clone();
		for(CollidableObject element : clonedCollisionList) {
			element.draw(g);
		}
		
		// affichage à l'écran sans scintillement
		g2.drawImage(buffer, 0, 0, null);
	}

	// taille de la fenêtre
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	
	public ArrayList<String> getElements() {
		return elements;
	}

	public void addElement(String element) {
		elements.add(element);
	}
	
	public void clearElements() {
		elements.clear();
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
}
