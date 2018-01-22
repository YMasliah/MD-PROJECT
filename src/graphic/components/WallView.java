/**
 * 
 */
package graphic.components;

import java.awt.Graphics2D;

/**
 * @author masliah yann
 *
 */
public class WallView implements IComponents {

	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.fillRect(200, 400, 30, 100);
	}

}
