package graphic.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.AngryBirds;

public class Messages implements IComponents{

	public void draw(Graphics2D g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
	    g.setColor(Color.white);
		g.drawString(AngryBirds.GAMECORE.getMessage(), 300, 100);
		g.drawString("score: " + AngryBirds.GAMECORE.getScore(), 20, 20);
	}
}
