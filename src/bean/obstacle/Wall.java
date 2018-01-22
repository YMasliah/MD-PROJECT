/**
 * 
 */
package bean.obstacle;

import java.awt.Graphics2D;

import bean.CollidableObject;
import graphic.components.ComponentsFactory;
import graphic.components.IComponents;

/**
 * @author masliah yann
 *
 */
public class Wall extends CollidableObject implements IComponents{
	
	private double posX;
	private double posY;
	private int width;
	private int height;
	
	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	public Wall() {
		this.posX = 200;
		this.posY = 400;
		this.width = 30;
		this.height = 100;
	}
	
	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	public Wall(double x, double y, int posX, int posY, int width, int height) {
		super(x, y);
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		ComponentsFactory.getComponents("Wall").draw(g);
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
