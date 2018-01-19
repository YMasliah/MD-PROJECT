package graphic.components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import logic.GameCore.Status;
import main.AngryBirds;

public class Bird implements IComponents {
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		if (AngryBirds.GAMECORE.getStatus() == Status.playable) {
			g.drawLine((int) AngryBirds.GAMEMODE.getBird().getPosX(), (int) AngryBirds.GAMEMODE.getBird().getPosY(),
					AngryBirds.GRAPHICCORE.getPosX(), AngryBirds.GRAPHICCORE.getPosY());
		}
		// g.fillOval((int) AngryBirds.GAMEMODE.getBird().getPosX() - 20,
		// (int) AngryBirds.GAMEMODE.getBird().getPosY() - 20, 40, 40);

		File fast = new File("resources/images/bird.jpg");
		File slow = new File("resources/images/raw-bird.jpg");
		BufferedImage img;
		Double speed = new Double(0);
		try {
//			speed = Math.abs(AngryBirds.GAMECORE.getVelocityY()) / Math.abs(AngryBirds.GAMECORE.getVelocityX());
			if (!speed.isNaN() && Math.abs(AngryBirds.GAMECORE.getVelocityX())
					/ Math.abs(AngryBirds.GAMECORE.getVelocityY()) < 1.1) {

				img = ImageIO.read(fast);
				g.drawImage(img,
						(int) AngryBirds.GAMEMODE.getBird().getPosX() - 20,
						(int) AngryBirds.GAMEMODE.getBird().getPosY() - 20,
						40, 40, null);
			} else {
				// AngryBirds.GAMEMODE.getBird()
				// -AngryBirds.GAMECORE.getVelocityX() * 0.1);
				// bird.getPosY()-AngryBirds.GAMECORE.getVelocityY() *0.1);
				if (AngryBirds.GAMECORE.getStatus() != Status.game_over) {
					img = ImageIO.read(slow);
					g.drawImage(img, (int) AngryBirds.GAMEMODE.getBird().getPosX() - 20,
							(int) AngryBirds.GAMEMODE.getBird().getPosY() - 20, 40, 40, null);
				}
				else {
					img = ImageIO.read(fast);
					g.drawImage(img, (int) AngryBirds.GAMEMODE.getBird().getPosX() - 20,
							(int) AngryBirds.GAMEMODE.getBird().getPosY() - 20, 40, 40, null);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
