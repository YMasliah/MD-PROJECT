package graphic.components;

import java.awt.Color;
import java.awt.Graphics2D;

import main.AngryBirds;

public class Pig implements IComponents {

	public void draw(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillOval((int) AngryBirds.GAMEMODE.getPig().getPosX() - 20, (int) AngryBirds.GAMEMODE.getPig().getPosY() - 20,
				40, 40);

	}

}
