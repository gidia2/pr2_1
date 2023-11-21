package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;
import tp1.logic.Game;
import tp1.logic.Move;

public abstract class EnemyShip extends Ship{
	Move dir;
	
	public EnemyShip(Game game, Position pos, int life) {
		super(game, pos, life);
		this.dir = Move.LEFT;
	}
	
	protected abstract int getPoints();
	
	public String getInfo() {
		return Messages.alienDescription(getDescription(), getPoints(), getDamage(), getArmor());
	}
}
