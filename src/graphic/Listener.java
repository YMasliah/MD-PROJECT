/**
 * 
 */
package graphic;

import java.awt.Event;
import java.util.EventListener;

/**
 * @author masliah yann
 *
 */
public interface Listener extends EventListener {

	/**
	 * the user perform an action like pressing a button
	 * @param e
	 */
	public void action(Event e);
	
	/**
	 * the user move is listener, like pressing arrow in his keyboard
	 * @param e
	 */
	public void mouvement(Event e);
}
