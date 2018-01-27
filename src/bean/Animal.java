package bean;

public abstract class Animal extends CollidableObject{

	// informations relatives aux animaux
	private double velocityX; 
	private double velocityY;
	
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animal(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}


	public double getVelocityX() {
		return velocityX;
	}
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}
	public double getVelocityY() {
		return velocityY;
	}
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}
}
