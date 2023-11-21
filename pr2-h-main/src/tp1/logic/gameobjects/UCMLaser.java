package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

/**
 * 
 * Class that represents the laser fired by {@link UCMShip}
 *
 */
public class UCMLaser extends UCMWeapon {
	private static final int ARMOR = 1;
	private static final int DAMAGE = 1;
	
	public UCMLaser(Game game, Position pos) {
		super(game, pos, ARMOR, Move.UP);
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
		game.enableLaser();
		game.removeObject(this);
	}

	@Override
	protected String getSymbol() {
		return Messages.LASER_SYMBOL;
	}
}