package bean;

import graphic.components.IComponents;
import logic.Collision;

public abstract class Animal implements IComponents{

	private double posX;
	private double posY;
	
	public Animal(double x, double y) {
		this.setPosX(x);
		this.setPosY(y);
	}
	public Animal() {
		this.posX = 0;
		this.posY = 0;
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
	
	public void collisionWith(Animal a, Collision c){}

}
