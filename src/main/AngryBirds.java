/**
 * 
 */
package main;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import graphic.GraphicCore;
import logic.Core;

/**
 * @author masliah yann
 *
 */
public class AngryBirds {
	public static Core CORE = Core.getCore();
	public static GraphicCore GCORE = GraphicCore.getGraphicCore();
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
