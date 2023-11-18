package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class EnemyShip extends Ship {
	
	private Move dir;

	public EnemyShip(Game game, Position pos, int life) {
		super(game, pos, life);
		dir = Move.LEFT;
	}
	
	protected abstract int getPoints();
	
	public void onDelete() {}
	
	public void receiveAttack() {}
	
	public String getInfo() {
		return "";
	}
}
