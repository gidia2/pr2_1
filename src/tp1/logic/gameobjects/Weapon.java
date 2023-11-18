package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class Weapon extends GameObject {
	
	protected static final int DAMAGE = 1;
	private Move dir;

	public Weapon(Game game, Position pos, int life, Move dir) {
		super(game, pos, life);
		this.dir = dir;
	}

	public void automaticMove () {
		if(isAlive()) {
			performMovement(dir);
			if(isOut(pos)) {
				onDelete();
			}
		}
	}
	
	protected abstract boolean weaponAttack(GameObject other);
	
}
