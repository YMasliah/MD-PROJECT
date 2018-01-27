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
import bean.CollidableObject;
import logic.GameCore.GameStatus;
import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class Bird extends Animal {

	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bird(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void collisionWith(CollidableObject object) {
		if (object == null) {
			if (getPosX() < 25 && getVelocityX() < 0) {
				setVelocityX(-(getVelocityX()*0.7));
			}
			if (getPosX() > AngryBirds.GRAPHICCORE.getWidth() -25 && getVelocityX() > 0) {
				setVelocityX(-(getVelocityX()*0.7));
			}
			if (getPosY() < 0 && getVelocityY() < 0) {
				setVelocityY(-(getVelocityY()*0.7));
			}
			if (getPosY() > 480 && getVelocityY() > 0) {
				setVelocityY(-(getVelocityY()*0.7));
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {

		File fast = new File("resources/images/burning-bird.png");
		File slow = new File("resources/images/raw-bird.png");
		BufferedImage img;
		Double speed = new Double(0);
		try {

			speed = Math.pow(Math.abs(getVelocityY()), 2) + Math.pow(Math.abs(getVelocityX()), 2);

			if (Math.sqrt(speed) > 6) {
				img = ImageIO.read(fast);
				g.drawImage(img, null, (int) getPosX() - 20, (int) getPosY() - 20);

			} else {

				if (AngryBirds.GAMEMODE.getStatus() != GameStatus.try_again) {
					img = ImageIO.read(slow);
					g.drawImage(img, null, (int) getPosX() - 20, (int) getPosY() - 20);

				} else {
					img = ImageIO.read(fast);
					g.drawImage(img, null, (int) getPosX() - 20, (int) getPosY() - 20);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
