package bean.withgravity;

import java.awt.Graphics2D;

import bean.Animal;
import bean.ObjectWithGravityAura;

public class Vent extends ObjectWithGravityAura{
	
	public Vent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vent(double x, double y, double gravity) {
		super(x, y, gravity);
		// TODO Auto-generated constructor stub
	}

	public Vent(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public Vent(double gravity){
		setGravity(gravity);
	}
	
	public void agis_sur (Animal a){
		a.setPosX(a.getPosX() + getGravity());
	}

	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
}



