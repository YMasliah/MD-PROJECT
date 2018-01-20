package bean.withgravity;

import bean.Animal;
import bean.IGravity;
import bean.ObjectWithGravityAura;

public class Vent extends ObjectWithGravityAura implements IGravity{
	public Vent(double gravity){
		setGravity(gravity);
	}
	
	public void agis_sur (Animal a){
		a.setPosX(a.getPosX() + getGravity());
	}
}



