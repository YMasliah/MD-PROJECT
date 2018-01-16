package graphic.components;

import java.awt.Color;
import java.awt.Graphics2D;

public class Decor implements IComponents{

	public void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, 500, 800, 500);
		g.drawLine(100, 500, 100, 400);
	}
}
