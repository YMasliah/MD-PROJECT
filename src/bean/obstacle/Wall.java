/**
 * 
 */
package bean.obstacle;

import java.awt.Graphics2D;

import bean.CollidableObject;

/**
 * @author masliah yann
 *
 */
public class Wall extends CollidableObject{
	
	private int width;
	private int height;
	
	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	public Wall() {
		setPosX(200);
		setPosY(400);
		this.width = 30;
		this.height = 100;
	}
	
	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	public Wall(double x, double y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.fillRect((int) getPosX(), (int) getPosY(), width, height);
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
