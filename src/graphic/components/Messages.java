package graphic.components;

import java.awt.Color;
import java.awt.Graphics2D;

import main.AngryBirds;

public class Messages implements IComponents{

	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.drawString(AngryBirds.GAMECORE.getMessage(), 300, 100);
		g.drawString("score: " + AngryBirds.GAMECORE.getScore(), 20, 20);
	}
}
