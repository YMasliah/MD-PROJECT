package bean;

public class Animal {

	private double posX;
	private double posY;
	
	public Animal(double x, double y) {
		this.setPosX(x);
		this.setPosY(y);
	}
	public Animal() {
		// TODO Auto-generated constructor stub
	}
	
	// calcule la distance entre deux animaux
	public static double distance(Animal a1, Animal a2) {
		double dx = a1.getPosX() - a2.getPosX();
		double dy = a1.getPosY() - a2.getPosY();
		return Math.sqrt(dx * dx + dy * dy);
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

}
