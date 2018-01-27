/**
 * 
 */
package bean.obstacle;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
		this.width = 60;
		this.height = 110;
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
		//g.fillRect((int) getPosX(), (int) getPosY(), width, height);
		File file = new File ("resources/images/wall.png");
		BufferedImage img;
		try {
			img = ImageIO.read(file);
			g.drawImage(img, (int) getPosX()-10 , (int) getPosY(), width, height, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
