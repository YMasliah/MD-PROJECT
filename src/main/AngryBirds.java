/**
 * 
 */
package main;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import graphic.GraphicCore;
import logic.GameCore;
import logic.GameMode;

/**
 * @author masliah yann
 *
 */
public class AngryBirds {
	public static GameCore CORE = GameCore.getGameCore();
	public static GraphicCore GCORE = GraphicCore.getGraphicCore();
	public static GameMode GMODE = GameMode.getGameMode();
	
	// met le jeu dans une fenêtre
	public static void main(String args[]) {
		Frame frame = new Frame("Oiseau pas content");
		final GraphicCore obj = GCORE;
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		frame.add(obj);
		frame.pack();
		frame.setVisible(true);
	}
}
