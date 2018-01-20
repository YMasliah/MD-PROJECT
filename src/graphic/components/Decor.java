package graphic.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Decor implements IComponents {

	public void draw(Graphics2D g) {
		File file = new File("resources/images/knife.png");
		BufferedImage img;
		try {
			img = ImageIO.read(file);
			g.drawImage(img, 60, 395, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
