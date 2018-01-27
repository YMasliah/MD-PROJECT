package graphic.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.AngryBirds;

public class LifeView implements IComponents {

	@Override
	public void draw(Graphics2D g) {
		File file = new File("resources/images/life.png");
		BufferedImage img;

		try {
			int pos = 10;
			for (int i = 0; i < AngryBirds.GAMEMODE.getRound().getLives(); i++) {
				img = ImageIO.read(file);
				g.drawImage(img, pos, 30, null);
				pos += 40;
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
