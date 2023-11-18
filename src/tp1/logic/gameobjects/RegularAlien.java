package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class RegularAlien extends AlienShip {
	
	private static final int ARMOR = 2;
	private static final int DAMAGE = 0;
	private static final int POINTS = 5;
	

	public RegularAlien(Game game, Position pos, AlienManager alienManager) {
		super(game, pos, ARMOR, alienManager);
	}

	//Métodos para acceder a los atributos privados de la clase
	public int getPoints() {
		return POINTS;
	}
	
	public int getDamage() {
		return DAMAGE;
	}
	
	public int getArmour() {
		return ARMOR;
	}
	
	//Métodos para imprimir por consola la UCMShip
	protected String getSymbol() {
		return Messages.REGULAR_ALIEN_SYMBOL;
	}
	
	protected String getDescription() {
		return Messages.REGULAR_ALIEN_DESCRIPTION;
	}
	
	public String getInfo() {
		return Messages.alienDescription(getDescription(), POINTS, DAMAGE, ARMOR);
	}
	
	public String toString() {
		return getSymbol() + "[0" + life + "]";
	}
	
}
