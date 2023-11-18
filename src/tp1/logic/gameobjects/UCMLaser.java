package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMLaser extends UCMWeapon {
	
	private static final int ARMOR = 1;

	public UCMLaser(Game game, Position pos) {
		super(game, pos, ARMOR, Move.UP);
	}
	
	//Métodos para acceder a los atributos privados de la clase
	public int getDamage() {
		return DAMAGE;
	}
	
	public int getArmour() {
		return ARMOR;
	}
	
	public void onDelete() {
		game.removeLaser();
	}
	
	protected String getSymbol() {
		return Messages.LASER_SYMBOL;
	}
	
	public String toString(Position pos) {
		return isOnPosition(pos) 
				? getSymbol()
				: "";
	}
	
	public boolean performAttack(GameObject other) {
		boolean attacked = false;
		if(isAlive() && other.isAlive() && other.isOnPosition(pos)) {
			attacked = weaponAttack(other);
			receiveDamage(1);
		}
		return attacked;
	}

}
