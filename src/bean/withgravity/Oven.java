/**
 * 
 */
package bean.withgravity;

import java.awt.Graphics2D;

import bean.Animal;
import graphic.components.ComponentsFactory;

/**
 * @author arthur
 *
 */
public class Oven extends Animal {

	public Oven() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oven(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		ComponentsFactory.getComponents("OVEN");		
	}
}
