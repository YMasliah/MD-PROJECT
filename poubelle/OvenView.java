package graphic.components;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bean.CollidableObject;
import bean.IGravity;
import bean.withgravity.Oven;
import main.AngryBirds;

public class OvenView implements IComponents {

	@Override
	public void draw(Graphics2D g) {
		File file = new File ("resources/images/bird-oven.jpg");
		BufferedImage img;
		try {
			img = ImageIO.read(file);
			for(IGravity oven : AngryBirds.GAMEMODE.getRound().getGravity_list()) {
				if(oven instanceof Oven) {
					g.drawImage(img, (int) ((CollidableObject) oven).getPosX(), (int) ((CollidableObject) oven).getPosY(), 40, 40, null);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
