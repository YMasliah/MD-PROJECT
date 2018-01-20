package graphic.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import logic.GameCore.Status;
import main.AngryBirds;

public class BirdView implements IComponents {
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		if (AngryBirds.GAMEMODE.getStatus() == Status.playable) {
			g.drawLine((int) AngryBirds.GAMEMODE.getRound().getBird().getPosX(), (int) AngryBirds.GAMEMODE.getRound().getBird().getPosY(),
					AngryBirds.GRAPHICCORE.getPosX(), AngryBirds.GRAPHICCORE.getPosY());
		}
		File fast = new File("resources/images/burning-bird.png");
		File slow = new File("resources/images/raw-bird.png");
		BufferedImage img;
		Double speed = new Double(0);
		try {

			speed = Math.pow(Math.abs(AngryBirds.GAMEMODE.getRound().getBird().getVelocityY()), 2)
					+ Math.pow(Math.abs(AngryBirds.GAMEMODE.getRound().getBird().getVelocityX()), 2);

			if (Math.sqrt(speed) > 6) {
				img = ImageIO.read(fast);
				g.drawImage(img, null, (int) AngryBirds.GAMEMODE.getRound().getBird().getPosX() - 20,
						(int) AngryBirds.GAMEMODE.getRound().getBird().getPosY() - 20);
				;

			} else {

				if (AngryBirds.GAMEMODE.getStatus() != Status.try_again) {
					img = ImageIO.read(slow);
					g.drawImage(img, null, (int) AngryBirds.GAMEMODE.getRound().getBird().getPosX() - 20,
							(int) AngryBirds.GAMEMODE.getRound().getBird().getPosY() - 20);
					;

				} else {
					img = ImageIO.read(fast);
					g.drawImage(img, null, (int) AngryBirds.GAMEMODE.getRound().getBird().getPosX() - 20,
							(int) AngryBirds.GAMEMODE.getRound().getBird().getPosY() - 20);
					;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
