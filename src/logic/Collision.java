package logic;

import java.util.ArrayList;

import bean.Animal;

import bean.animal.Bird;
import bean.animal.Pig;
import bean.withgravity.Oven;

public class Collision {

	private ArrayList<Animal> liste_animaux;

	public Collision() {
		liste_animaux = new ArrayList<Animal>();
	}

	public void add_animal(ArrayList<Pig> pigs) {
		liste_animaux.addAll(pigs);
	}

	public void add_bird(Bird bird) {
		liste_animaux.add(bird);

	}

	public void add_ovens(ArrayList<Oven> ovens) {
		liste_animaux.addAll(ovens);

	}

	public void clearManager() {
		liste_animaux.clear();
	}

	// calcule la distance entre deux animaux
	public static double distance(Animal a1, Animal a2) {
		double dx = a1.getPosX() - a2.getPosX();
		double dy = a1.getPosY() - a2.getPosY();
		return Math.sqrt(dx * dx + dy * dy);
	}

	// 0 = aucune collision, 1 = collision bird et pig, 2 collison bird et blackhole
	public int CheckCollision() {

		for (int i = 0; i < liste_animaux.size(); i++) {
			// System.out.println(liste_animaux.get(i).getClass());
			for (int j = 0; j < liste_animaux.size(); j++) {
				if (i != j && Collision.distance(liste_animaux.get(i), liste_animaux.get(j)) < 35
						&& liste_animaux.get(j) instanceof Pig && liste_animaux.get(i) instanceof Bird) {
					liste_animaux.get(i).collisionWith(liste_animaux.get(j), this);
					liste_animaux.get(j).collisionWith(liste_animaux.get(i), this);

					return 1;

				}
				if (i != j && liste_animaux.get(j) instanceof Oven && liste_animaux.get(i) instanceof Bird
						&& Collision.distance(liste_animaux.get(i), liste_animaux.get(j)) < 100) {
					liste_animaux.get(i).collisionWith(liste_animaux.get(j), this);
					liste_animaux.get(j).collisionWith(liste_animaux.get(i), this);
					return 2;
				}
			}
		}
		return 0;
	}

}
