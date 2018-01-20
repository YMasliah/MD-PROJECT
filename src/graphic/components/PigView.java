package graphic.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.AngryBirds;

public class PigView implements IComponents {

	public void draw(Graphics2D g) {
//		g.setColor(Color.GREEN);
//		g.fillOval((int) AngryBirds.GAMEMODE.getPig().getPosX() - 20, (int) AngryBirds.GAMEMODE.getPig().getPosY() - 20,
//				40, 40);
		File file = new File ("resources/images/pig.png");
		BufferedImage img;
		try {
			img = ImageIO.read(file);
			for(bean.animal.Pig pig : AngryBirds.GAMEMODE.getPigs()) {
				
				g.drawImage(img, (int) pig.getPosX() - 20, (int) pig.getPosY() - 20, 40, 40, null);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
