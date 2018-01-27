/**
 * 
 */
package bean.animal;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bean.Animal;

/**
 * @author masliah yann
 *
 */
public class Pig extends Animal {
	
	public Pig() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pig(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		File file = new File ("resources/images/pig.png");
		BufferedImage img;
		try {
			img = ImageIO.read(file);
			g.drawImage(img, (int) getPosX() - 20, (int) getPosY() - 20, 40, 40, null);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
