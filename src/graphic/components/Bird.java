package graphic.components;

import java.awt.Color;
import java.awt.Graphics2D;

import logic.GameCore.Status;
import main.AngryBirds;

public class Bird implements IComponents {
	public void draw(Graphics2D g) {
		g.setColor(Color.RED);
		if (AngryBirds.GAMECORE.getStatus() == Status.playable)
			g.drawLine((int) AngryBirds.GAMEMODE.getBird().getPosX(), (int) AngryBirds.GAMEMODE.getBird().getPosY(),
					AngryBirds.GRAPHICCORE.getPosX(), AngryBirds.GRAPHICCORE.getPosY());
		g.fillOval((int) AngryBirds.GAMEMODE.getBird().getPosX() - 20,
				(int) AngryBirds.GAMEMODE.getBird().getPosY() - 20, 40, 40);
	}
}
