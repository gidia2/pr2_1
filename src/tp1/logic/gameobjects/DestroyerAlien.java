package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.AlienManager;
import tp1.logic.Position;
import tp1.view.Messages;

public class DestroyerAlien extends AlienShip {
	
	private static final int ARMOR = 1;
	private static final int DAMAGE = 1;
	private static final int POINTS = 10;

	private boolean canShootBomb;
	

	public DestroyerAlien(Game game, Position pos, AlienManager alienManager) {
		super(game, pos, ARMOR, alienManager);
		canShootBomb = false;
	}
	
	protected int getDamage() {
		return DAMAGE;
	}
	
	protected int getPoints() {
		return POINTS;
	}
	
	public int getArmour() {
		return ARMOR;
	}
	
	protected String getSymbol() {
		return Messages.DESTROYER_ALIEN_SYMBOL;
	}
	
	public String getInfo() {
		return Messages.alienDescription(getDescription(), POINTS, DAMAGE, ARMOR);
	}
	
	protected String getDescription() {
		return Messages.DESTROYER_ALIEN_DESCRIPTION;
	}
	
	public String toString() {
		return getSymbol() + "[0" + life + "]";
	}
	
	public void computerActions() {
		if (canGenerateRandomBomb())
			performAttack();
	}
	
	public void enableBomb() {
		canShootBomb = true;
	}
	
	private boolean canGenerateRandomBomb() {
		return (canShootBomb && game.getRandom().nextDouble() < game.getLevel().getShootFrequency());
	}
	
}
