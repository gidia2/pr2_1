package tp1.logic.gameobjects;

import tp1.logic.Game;
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

	public int getLife() {
		return this.life;
	}
	
	public Position getPosition() {
		return pos;
	}
	
	@Override
	public boolean isOnPosition(Position pos) {
		return this.pos.equals(pos);
	}
	
	public void receiveDamage(int damage) {
		life -= damage;
		if(!isAlive())
			onDelete();
	}

	protected abstract String getSymbol();
	protected abstract int getDamage();
	protected abstract int getArmor();

	public abstract void onDelete();
	
	public abstract void automaticMove();
	public void computerAction() {}
	
	@Override
	public boolean performAttack(GameItem other) {return false;}
	@Override
	public void receiveAttack(EnemyWeapon weapon) {}
	@Override
	public void receiveAttack(UCMWeapon weapon) {}
}
