/**
 * 
 */
package main;

import graphic.GraphicCore;
import graphic.MotionListener;
import logic.GameCore;
import logic.GameMode;

/**
 * @author masliah yann
 *
 */
public abstract class Launcher {
	public static GameCore GAMECORE;
	public static GraphicCore GRAPHICCORE;
	public static GameMode GAMEMODE;
	public static MotionListener LISTENER;
	
	public Launcher() throws Exception {
		if(GAMECORE == null || GRAPHICCORE == null || GAMEMODE == null || LISTENER == null)
			throw new Exception("Un composant est manquant");
	}
}
