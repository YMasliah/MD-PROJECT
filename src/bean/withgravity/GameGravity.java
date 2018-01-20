package bean.withgravity;

import bean.Animal;
import bean.IGravity;
import bean.ObjectWithGravityAura;
import bean.animal.Bird;

public class GameGravity extends ObjectWithGravityAura implements IGravity {
	
	public GameGravity (){
	}
	
	public GameGravity (double gravity){
		setGravity(gravity);
	}
	
	/* (non-Javadoc)
	 * @see bean.IGravity#agis_sur(bean.Animal)
	 */
	@Override
	public void agis_sur (Animal a){
		if (a instanceof Bird){
			a.setVelocityY(a.getVelocityY() + getGravity());
		}
	}
	

}


