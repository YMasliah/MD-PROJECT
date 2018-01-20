package bean;

import graphic.components.IComponents;

public abstract class Animal extends CollidableObject implements IComponents{

	public Animal(double x, double y) {
		setPosX(x);
		setPosY(y);
	}
	public Animal() {
		setPosX(0);
		setPosY(0);
		// TODO Auto-generated constructor stub
	}
	
	private double velocityX, velocityY; // informations relatives � l'oiseau

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
