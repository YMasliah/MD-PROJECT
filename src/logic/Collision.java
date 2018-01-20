package logic;

import java.util.ArrayList;

import bean.CollidableObject;
import bean.animal.Bird;
import bean.animal.Pig;

public class Collision {

	private ArrayList<CollidableObject> listeObjets;

	public Collision() {
		listeObjets = new ArrayList<CollidableObject>();
	}

	public void add_animal(ArrayList<CollidableObject> a) {
		listeObjets = a;
	}

	// calcule la distance entre deux animaux
	public static double distance(CollidableObject a1, CollidableObject a2) {
		double dx = a1.getPosX() - a2.getPosX();
		double dy = a1.getPosY() - a2.getPosY();
		return Math.sqrt(dx * dx + dy * dy);
	}

	// 0 = aucune collision, 1 = collision bird et pig
	public int CheckCollision() {
		for (int i = 0; i < listeObjets.size(); i++) {
			for (int j = 0; j < listeObjets.size(); j++) {
				if ((i != j) && (Collision.distance(listeObjets.get(i), listeObjets.get(j)) < 35)) {
					listeObjets.get(i).collisionWith(listeObjets.get(j), this);
					listeObjets.get(j).collisionWith(listeObjets.get(i), this);
					if (listeObjets.get(i) instanceof Bird && listeObjets.get(j) instanceof Pig)
						return 1;
				}
			}
		}
		return 0;
	}
}
