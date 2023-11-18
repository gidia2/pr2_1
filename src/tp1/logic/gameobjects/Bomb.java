package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class Bomb extends EnemyWeapon {
	
	private static final int ARMOR = 1;
	
	private DestroyerAlien owner;

	public Bomb(Game game, Position pos, DestroyerAlien owner) {
		super(game, pos, ARMOR, Move.DOWN);
		this.owner = owner;
	}
	
	public int getDamage() {
		return DAMAGE;
	}
	
	public int getArmour() {
		return ARMOR;
	}
	
	//Métodos para imprimir la bomba por consola
	public String toString() {
		return getSymbol();
	}
	
	public String getSymbol() {
		return Messages.BOMB_SYMBOL;
	}
	
	public void die() {
		onDelete();
		owner = null;
		pos = null;
		life = 0;
	}
	
	public void onDelete() {
		game.enableBomb(owner);
		game.removeBomb(this);
	}

}
