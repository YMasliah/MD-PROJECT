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
	private double auraRange;
	private boolean inAura;

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

	public double getAuraRange() {
		return auraRange;
	}

	public void setAuraRange(double auraRange) {
		this.auraRange = auraRange;
	}

	public boolean isInAura() {
		return inAura;
	}

	public void setInAura(boolean inAura) {
		this.inAura = inAura;
	}
}
