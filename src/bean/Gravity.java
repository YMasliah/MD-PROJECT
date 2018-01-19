package bean;

import main.AngryBirds;

public class Gravity {
	private double gravity; // gravité

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	public Gravity (){
	}
	
	public Gravity (double gravity){
		this.gravity = gravity;
	}
	
	public void agis_sur (Animal a){
		if (a instanceof Bird){
			a.setVelocityY(a.getVelocityY() + gravity);
			
			System.out.println("test bug");
		}
	}
	

}


