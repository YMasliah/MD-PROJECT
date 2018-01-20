package logic;

public class CollisionReturnValue {

	public enum CollisionTypes {
		playable, processing, try_again, game_over
	}
	
	private CollisionTypes collisionType;
	private int indexI;
	private int indexJ;
	
	public CollisionTypes getCollisionType() {
		return collisionType;
	}
	public void setCollisionType(CollisionTypes collisionType) {
		this.collisionType = collisionType;
	}
	public int getIndexI() {
		return indexI;
	}
	public void setIndexI(int indexI) {
		this.indexI = indexI;
	}
	public int getIndexJ() {
		return indexJ;
	}
	public void setIndexJ(int indexJ) {
		this.indexJ = indexJ;
	}
	
}
