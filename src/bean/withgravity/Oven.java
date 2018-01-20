/**
 * 
 */
package bean.withgravity;

import java.awt.Graphics2D;

import bean.Animal;
import bean.ObjectWithGravityAura;
import bean.animal.Bird;
import graphic.components.ComponentsFactory;
import graphic.components.IComponents;

/**
 * @author arthur
 *
 */
public class Oven extends ObjectWithGravityAura implements IComponents{
	
	public Oven() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oven(double x, double y, double gravity) {
		super(x, y, gravity);
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

	/* (non-Javadoc)
	 * @see bean.IGravity#agis_sur(bean.Animal)
	 */
	@Override
	public void agis_sur(Animal a) {
		if (a instanceof Bird){
			a.setVelocityY(a.getVelocityY() + getGravity());
		}		
	}
}
