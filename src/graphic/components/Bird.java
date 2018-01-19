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
		File fast = new File("resources/images/bird.jpg");
		File slow = new File("resources/images/raw-bird.jpg");
		BufferedImage img;
		Double speed = new Double(0);
		try {

			speed = Math.pow(Math.abs(AngryBirds.GAMECORE.getVelocityY()), 2)
					+ Math.pow(Math.abs(AngryBirds.GAMECORE.getVelocityX()), 2);

			if (Math.sqrt(speed) > 6) {
				System.out.println(Math.sqrt(speed));
				img = ImageIO.read(fast);
				g.drawImage(img, (int) AngryBirds.GAMEMODE.getBird().getPosX() - 20,
						(int) AngryBirds.GAMEMODE.getBird().getPosY() - 20, 40, 40, null);
			} else {

				if (AngryBirds.GAMECORE.getStatus() != Status.game_over) {
					img = ImageIO.read(slow);
					g.drawImage(img, (int) AngryBirds.GAMEMODE.getBird().getPosX() - 20,
							(int) AngryBirds.GAMEMODE.getBird().getPosY() - 20, 40, 40, null);

				} else {
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
