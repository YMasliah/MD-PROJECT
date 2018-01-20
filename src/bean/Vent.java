package bean;

public class Vent extends Gravity{
	public Vent(double gravity){
		super(gravity);
	}
	
	public void agis_sur (Animal a){
		a.setPosX(a.getPosX() + getGravity());
	}
}



