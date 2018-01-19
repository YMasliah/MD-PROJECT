/**
 * 
 */
package bean;

import java.awt.Graphics2D;

import graphic.components.ComponentsFactory;

/**
 * @author masliah yann
 *
 */
public class Bird extends Animal {

	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bird(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		ComponentsFactory.getComponents("Bird");		
	}
}
