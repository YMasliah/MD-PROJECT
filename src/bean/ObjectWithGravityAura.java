/**
 * 
 */
package bean;

/**
 * @author masliah yann
 *
 */
public abstract class ObjectWithGravityAura extends CollidableObject  {
	private double gravity; // gravité

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
}
