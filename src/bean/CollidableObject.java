/**
 * 
 */
package bean;

import graphic.components.IComponents;

/**
 * @author masliah yann
 *
 */
public abstract class CollidableObject implements IComponents{
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
	
	public void collisionWith(CollidableObject object){}
	
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
