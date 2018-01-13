/**
 * 
 */
package main;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import bean.Animal;
import graphic.GraphicCore;
import graphic.MotionListener;
import logic.GameCore;
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
public class AngryBirds extends Launcher {
	/**
	 * @throws Exception
	 */
	public AngryBirds() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public static GameCore CORE = GameCore.getGameCore();
	public static GraphicCore GCORE = GraphicCore.getGraphicCore();
	public static GameMode GAMEMODE = GameMode.getGameMode();
	public static MotionListener LISTENER = MotionListener.getMotionListener();
	
	// met le jeu dans une fenêtre et rajoute son listener
	public static void main(String[] args) {
		Frame frame = new Frame("Oiseau pas content");
		final GraphicCore obj = GCORE;
		GCORE.addListener();
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
