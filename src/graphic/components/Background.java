package graphic.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import main.AngryBirds;

public class Background implements IComponents{

	public void draw(Graphics2D g) {

		Dimension d = AngryBirds.GRAPHICCORE.getPreferredSize();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (int) d.getWidth(), (int) d.getHeight());

	}
}
