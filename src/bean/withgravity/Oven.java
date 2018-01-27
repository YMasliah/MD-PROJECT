/**
 * 
 */
package bean.withgravity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import bean.Animal;
import bean.ObjectWithGravityAura;
import bean.animal.Bird;

/**
 * @author arthur
 *
 */
public class Oven extends ObjectWithGravityAura{
	
	public Oven() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Oven(double x, double y, double gravity) {
		super(x, y, gravity);
		// TODO Auto-generated constructor stub
	}

	public Oven(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see graphic.components.IComponents#draw(java.awt.Graphics2D)
	 */
	@Override
	public void draw(Graphics2D g) {
		File file = new File ("resources/images/oven.png");
		BufferedImage img;
		try {
			img = ImageIO.read(file);
			g.drawImage(img, (int) getPosX()-15, (int) getPosY()-15, 40, 40, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	/* (non-Javadoc)
	 * @see bean.IGravity#agis_sur(bean.Animal)
	 */
	@Override
	public void agis_sur(Animal a) {
		if (a instanceof Bird){
			if(a.getPosX() > getPosX()){
				a.setVelocityX(a.getVelocityX() + getGravity());
			}else{
				a.setVelocityX(a.getVelocityX() - getGravity());
			}
			if(a.getPosY() > getPosY()){
				a.setVelocityY(a.getVelocityY() + getGravity());
			}else{
				a.setVelocityY(a.getVelocityY() - getGravity());
			}
			
		}		
	}
}
