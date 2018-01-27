package logic;

import bean.CollidableObject;

public class CollisionReturnValue {

	public enum CollisionTypes {
		PIG, WALL, OVEN_AURA, OVEN
	}
	
	private CollisionTypes collisionType;
	private CollidableObject objectI;
	private CollidableObject objectJ;
	
	public CollisionReturnValue() {
		collisionType = null;
		objectI = null;
		objectJ = null;
	}
	
	public CollisionTypes getCollisionType() {
		return collisionType;
	}
	public void setCollisionType(CollisionTypes collisionType) {
		this.collisionType = collisionType;
	}

	public CollidableObject getObjectI() {
		return objectI;
	}

	public void setObjectI(CollidableObject objectI) {
		this.objectI = objectI;
	}

	public CollidableObject getObjectJ() {
		return objectJ;
	}

	public void setObjectJ(CollidableObject objectJ) {
		this.objectJ = objectJ;
	}
	
	
}
