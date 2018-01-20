/**
 * 
 */
package main;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import graphic.GraphicCoreWithMotionListener;
import logic.GameMode;

/**
 * @author masliah yann
 *
 * Tout les attributs de cette classe seront surement des appel a des factory avec des choix d'objets a recuperer.
 * ex :
 * Core = GameCore.getGameCore(AngryBirdCore)
 * GCore = GraphicCore.getGraphicCore(DefaultInteractiveWindows)
 * ...
 */
public class AngryBirds {

	public static GraphicCoreWithMotionListener GRAPHICCORE;
	public static GameMode GAMEMODE;
	
	// met le jeu dans une fen�tre et rajoute son listener
	public static void main(String[] args) {
		GRAPHICCORE = GraphicCoreWithMotionListener.getGraphicCoreWithMotionListener();
		GAMEMODE = GameMode.getGameMode();
		Frame frame = new Frame("Oiseau pas content");

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		frame.add(GRAPHICCORE);
		frame.pack();
		frame.setVisible(true);
	}
}
