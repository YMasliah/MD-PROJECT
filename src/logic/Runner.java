/**
 * 
 */
package logic;

import main.AngryBirds;

/**
 * @author masliah yann
 *
 */
public class Runner  implements Runnable {
	
	// boucle qui calcule la position de l'oiseau en vol, effectue l'affichage et
	// teste les conditions de victoire
	public void run() {
		while (true) {
			// un pas de simulation toutes les 10ms
			try {
				Thread.currentThread();
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			AngryBirds.CORE.work();
		}
	}
}
