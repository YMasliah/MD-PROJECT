package logic;

import java.util.ArrayList;

import bean.CollidableObject;
import bean.ObjectWithGravityAura;
import bean.animal.Bird;
import bean.animal.Pig;
import bean.withgravity.Oven;
import logic.CollisionReturnValue.CollisionTypes;

public class Collision {

	private ArrayList<CollidableObject> listeObjects;

	public Collision() {
		listeObjects = new ArrayList<CollidableObject>();
	}

	// calcule la distance entre deux animaux
	public static double distance(CollidableObject a1, CollidableObject a2) {
		double dx = a1.getPosX() - a2.getPosX();
		double dy = a1.getPosY() - a2.getPosY();
		return Math.sqrt(dx * dx + dy * dy);
	}

	// 0 = aucune collision, 1 = collision bird et pig, 2 collison bird et blackhole
	public ArrayList<CollisionReturnValue> CheckCollision() {
		ArrayList<CollisionReturnValue> returnValue = new ArrayList<CollisionReturnValue>();
		CollisionReturnValue temp;		
		
		for (int i = 0; i < listeObjects.size(); i++) {
			if (!(listeObjects.get(i) instanceof Bird)) {
				continue;
			}
			if (listeObjects.get(i).getPosX() < 20 || listeObjects.get(i).getPosX() > 780
					|| listeObjects.get(i).getPosY() < 0 || listeObjects.get(i).getPosY() > 480) {
				temp = new CollisionReturnValue();
				temp.setCollisionType(CollisionTypes.WALL);
				returnValue.add(temp);
				break;
			}
			for (int j = i; j < listeObjects.size(); j++) {
				if (i == j) {
					continue;
				}
				if (listeObjects.get(j) instanceof Pig
						&& Collision.distance(listeObjects.get(i), listeObjects.get(j)) < 35) {
					temp = new CollisionReturnValue();
					temp.setCollisionType(CollisionTypes.PIG);
					temp.setObjectI(listeObjects.get(i));
					temp.setObjectJ(listeObjects.get(j));
					returnValue.add(temp);
					return returnValue;
				} else if (listeObjects.get(j) instanceof Oven
						&& Collision.distance(listeObjects.get(i), listeObjects.get(j)) < 100) {
					temp = new CollisionReturnValue();
					temp.setCollisionType(CollisionTypes.OVEN);
					temp.setObjectI(listeObjects.get(i));
					temp.setObjectJ(listeObjects.get(j));
					returnValue.add(temp);
				}
			}
		}
		return returnValue;
	}
	
	public void addCollidableObject(CollidableObject object) {
		listeObjects.add(object);
	}
	
	public void addCollidableObjects(ArrayList<CollidableObject> objects) {
		listeObjects.addAll(objects);
	}

	public void clearManager() {
		listeObjects.clear();
	}

	/**
	 * a supprimer
	 * @param pigs
	 */
	public void addCollidablePigs(ArrayList<Pig> pigs) {
		listeObjects.addAll(pigs);
		
	}
	
	/**
	 * a supprimer
	 * @param objects
	 */
	public void addCollidableGravityObject(ArrayList<ObjectWithGravityAura> objects) {
		listeObjects.addAll(objects);
		
	}

}
