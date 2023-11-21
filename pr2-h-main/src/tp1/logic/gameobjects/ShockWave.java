package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class ShockWave extends UCMWeapon {
	private static final int DAMAGE = 1;
	private static final int ARMOR = 1;
	
	public ShockWave(Game game, Position pos) {
		super(game, pos, ARMOR, Move.NONE);
	}

	@Override
	public int getDamage() {
		return DAMAGE;
	}
	
	@Override
	protected int getArmor() {
		return ARMOR;
	}
	
	@Override
	public void onDelete() {
		life = 0;
		pos = null;
		game.removeObject(this);;
	}
	
	@Override
	protected String getSymbol() {
		return Messages.SHOCKWAVE_SYMBOL;
	}
	
	public boolean performAttack(GameItem other) {
		if(isAlive() && other.isAlive() && !(other instanceof Ufo))
			weaponAttack(other);
		return true;
	}
	
	
}
