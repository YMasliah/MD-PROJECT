package graphic.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.AngryBirds;

public class Background implements IComponents{

	public void draw(Graphics2D g) {

		Dimension d = AngryBirds.GRAPHICCORE.getPreferredSize();
		g.setColor(Color.WHITE);
		File file = new File("resources/images/b1.png");
		BufferedImage img;
		try {
			img = ImageIO.read(file);
			g.drawImage(img, 0, (int) 0,(int) d.getWidth(),(int) d.getHeight(), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
