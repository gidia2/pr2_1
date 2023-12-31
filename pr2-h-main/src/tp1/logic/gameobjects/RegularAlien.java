package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.AlienManager;
import tp1.logic.Position;
import tp1.view.Messages;

/**
 * 
 * Class representing a regular alien
 *
 */
public class RegularAlien extends AlienShip {
	
	private static final int ARMOR = 2;
	private static final int DAMAGE = 0;
	private static final int POINTS = 5;

	
	public RegularAlien(Game game, Position pos, AlienManager alienManager) {
		super(game, pos, ARMOR, alienManager);
	}
	
	protected int getDamage() {
		return DAMAGE;
	}
	
	protected int getArmor() {
		return ARMOR;
	}
	
	protected int getPoints() {
		return POINTS;
	}
	
	public String getSymbol() {
		return Messages.REGULAR_ALIEN_SYMBOL;
	}
	
	public String getDescription() {
		return Messages.REGULAR_ALIEN_DESCRIPTION;
	}
}