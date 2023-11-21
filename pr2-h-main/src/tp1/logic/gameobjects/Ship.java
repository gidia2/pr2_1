package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class Ship extends GameObject{
	
	public Ship(Game game, Position pos, int life) {
		super(game, pos, life);
	}
	
	public boolean move(Move dir) {
		Position new_pos = new Position(pos.getCol() + dir.getX(), pos.getRow() + dir.getY());
		
		if (new_pos.isOnBoard()) {
			pos = new_pos;
			return true;
		}
		return false;
	}
	public abstract String getInfo();
	
	protected abstract String getDescription();
	
	public String toString() {
		return isAlive() 
				? getSymbol() + "[0" + life + "]"
				: "";
	}
}
