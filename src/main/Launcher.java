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
	public static GameCore CORE;
	public static GraphicCore GCORE;
	public static GameMode GAMEMODE;
	public static MotionListener LISTENER;
	
	public Launcher() throws Exception {
		if(CORE == null || GCORE == null || GAMEMODE == null || LISTENER == null)
			throw new Exception("Un composant est manquant");
	}
}
