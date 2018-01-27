package bean;

public abstract class Animal extends CollidableObject{

	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Animal(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	private double velocityX, velocityY; // informations relatives a l'oiseau

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
