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
		// TODO Auto-generated constructor stub
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
