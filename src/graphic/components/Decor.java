package graphic.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import logic.GameCore.GameStatus;
import main.AngryBirds;

public class Decor implements IComponents {

	public void draw(Graphics2D g) {
		File file = new File("resources/images/knife.png");
		BufferedImage img;
		if (AngryBirds.GAMEMODE.getStatus() == GameStatus.playable) {
			g.drawLine((int) AngryBirds.GAMEMODE.getRound().getBird().getPosX(), (int) AngryBirds.GAMEMODE.getRound().getBird().getPosY(),
					AngryBirds.GRAPHICCORE.getPosX(), AngryBirds.GRAPHICCORE.getPosY());
		}	
		try {
			img = ImageIO.read(file);
			g.drawImage(img, 60, 395, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
