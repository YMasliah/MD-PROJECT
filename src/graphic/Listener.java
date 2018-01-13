/**
 * 
 */
package graphic;

import java.awt.event.ComponentEvent;

/**
 * @author masliah yann
 *
 */
public interface Listener{

	/**
	 * the user perform an action like pressing a button
	 * @param e
	 */
	public void action(ComponentEvent e);
	
	/**
	 * the user move is listener, like pressing arrow in his keyboard
	 * @param e
	 */
	public void mouvement(ComponentEvent e);
}
