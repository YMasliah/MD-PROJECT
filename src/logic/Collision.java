package logic;

import java.util.ArrayList;

import bean.Animal;
import bean.Bird;
import bean.Pig;

public class Collision {

	private ArrayList<Animal> liste_animaux;

	public Collision() {
		liste_animaux = new ArrayList<Animal>();
	}

	public void add_animal(ArrayList<Animal> a) {
		liste_animaux = a;
	}

	// calcule la distance entre deux animaux
	public static double distance(Animal a1, Animal a2) {
		double dx = a1.getPosX() - a2.getPosX();
		double dy = a1.getPosY() - a2.getPosY();
		return Math.sqrt(dx * dx + dy * dy);
	}

	// 0 = aucune collision, 1 = collision bird et pig
	public int CheckCollision() {
		for (int i = 0; i < liste_animaux.size(); i++) {
			for (int j = 0; j < liste_animaux.size(); j++) {
				if ((i != j) && (Collision.distance(liste_animaux.get(i), liste_animaux.get(j)) < 35)) {
					liste_animaux.get(i).collisionWith(liste_animaux.get(j), this);
					liste_animaux.get(j).collisionWith(liste_animaux.get(i), this);
					if (liste_animaux.get(i) instanceof Bird && liste_animaux.get(j) instanceof Pig)
						return 1;
				}
			}
		}
		return 0;
	}
}
