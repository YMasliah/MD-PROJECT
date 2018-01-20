/**
 * 
 */
package bean;

import logic.Collision;

/**
 * @author masliah yann
 *
 */
public abstract class CollidableObject {
	private double posX;
	private double posY;
	
	public CollidableObject(double x, double y) {
		setPosX(x);
		setPosY(y);
	}
	public CollidableObject() {
		setPosX(0);
		setPosY(0);
		// TODO Auto-generated constructor stub
	}
	
	public void collisionWith(CollidableObject a, Collision c){}
	
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
}
