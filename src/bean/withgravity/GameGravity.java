package bean.withgravity;

import java.awt.Graphics2D;

import bean.Animal;
import bean.ObjectWithGravityAura;
import bean.animal.Bird;

public class GameGravity extends ObjectWithGravityAura {
	
	public GameGravity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameGravity(double x, double y, double gravity) {
		super(x, y, gravity);
		// TODO Auto-generated constructor stub
	}

	public GameGravity(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public GameGravity (double gravity){
		setGravity(gravity);
	}
	
	/* (non-Javadoc)
	 * @see bean.IGravity#agis_sur(bean.Animal)
	 */
	@Override
	public void agis_sur (Animal a){
		if (a instanceof Bird){
			a.setVelocityY(a.getVelocityY() + getGravity());
		}
	}

	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	

}


