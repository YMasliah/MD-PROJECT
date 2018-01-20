/**
 * 
 */
package bean;

/**
 * @author masliah yann
 *
 */
public abstract class ObjectWithGravityAura extends CollidableObject implements IGravity {
	
	private double gravity; // gravité

	public ObjectWithGravityAura() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObjectWithGravityAura(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public ObjectWithGravityAura(double x, double y, double gravity) {
		super(x, y);
		this.gravity = gravity;
		// TODO Auto-generated constructor stub
	}
	
	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
}
