package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class GameObject implements GameItem {

	protected Position pos;
	protected int life;
	protected Game game;

	public GameObject(Game game, Position pos, int life) {
		this.pos = pos;
		this.game = game;
		this.life = life;
	}

	@Override
	public boolean isAlive() {
		return this.life > 0;
	}

	protected int getLife() {
		return this.life;
	}
	
	public Position getPosition() {
		return pos;
	}
	
	public boolean isOnPosition(Position pos){
		return this.pos.equals(pos);
	}
	
	protected boolean isOut(Position pos) {
		return !pos.isOnBoard();
	}

	// TODO fill with your code

	protected abstract String getSymbol();

	protected abstract int getDamage();

	protected abstract int getArmour();

	public abstract void onDelete();

	public abstract void automaticMove();

	public void computerAction() {
		
	};

	// TODO fill with your code
	
	protected void receiveDamage(int damage) {
		life -= damage;
	}
	
	protected void performMovement(Move dir) {
		Position new_pos = new Position(pos.getCol() + dir.getX(), pos.getRow() + dir.getY());
		if (new_pos.isOnBoard())
			pos = new_pos;
	}

	@Override
	public boolean performAttack(GameItem other) {
		return false;
	}

	@Override
	public boolean receiveAttack(EnemyWeapon weapon) {
		return false;
	}

	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		return false;
	}

}
