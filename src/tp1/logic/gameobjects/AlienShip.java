package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.AlienManager;
import tp1.logic.Position;

public abstract class AlienShip extends EnemyShip {
	
	protected int cyclesToMove;
	private int speed;
	private AlienManager alienControl;

	public AlienShip(Game game, Position pos, int life, AlienManager alienManager) {
		super(game, pos, life);
		speed = game.getLevel().getNumCyclesToMoveOneCell();
		cyclesToMove = speed;
		this.alienControl = alienManager;
	}
	
	public void automaticMove() {
		if (cyclesToMove == 0) {
			performMovement(dir);
			cyclesToMove = speed;
			if(IsInBorder())
				alienControl.shipOnBorder();
		}
		
		else {
			if(alienControl.onBorder())
				descend();
			else
				cyclesToMove--;
		}
	}
	
	private void changeDir() {
		if(dir == Move.LEFT)
			dir = Move.RIGHT;
		else
			dir = Move.LEFT;
	}
	
	private boolean IsInBorder() {
		return alienControl.onBorder();
	}
	
	private void descend(){
		
	}
	
	private boolean isInFinalRow() {
		return alienControl.haveLanded();
	}
	
	public void onDelete() {}

}
