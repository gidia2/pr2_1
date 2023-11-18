package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class ShockWave extends UCMWeapon {
	
	private static final int ARMOR = 1;

	public ShockWave(Game game, Position pos) {
		super(game, pos, ARMOR, Move.NONE);
	}
	
	public String getSymbol() {
		return Messages.SHOCKWAVE_SYMBOL;
	}
	
	public int getDamage() {
		return DAMAGE;
	}
	
	public int getArmour() {
		return ARMOR;
	}
	
	public void onDelete() {
		life = 0;
		pos = null;
		game.removeShockWave();;
	}
	
	public boolean performAttack(GameObject other) {
		boolean attacked = false;
		if(isAlive() && other.isAlive())
			attacked = weaponAttack(other);
		return attacked;
	}

}
