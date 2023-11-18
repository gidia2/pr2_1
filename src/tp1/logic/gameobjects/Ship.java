package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;

public abstract class Ship extends GameObject {

	public Ship(Game game, Position pos, int life) {
		super(game, pos, life);
	}
	
	@Override
	public boolean isOnPosition(Position pos) {
		// TODO Auto-generated method stub
		return false;
	}

	protected abstract String getDescription();
	
	public abstract String getInfo();
}
