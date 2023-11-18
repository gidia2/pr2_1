package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMShip extends Ship {

	private static final int ARMOR = 3;
	private static final int DAMAGE = 1;
	
	private int points;
	private boolean hasShockWave;
	private boolean canShoot;

	public UCMShip(Game game, Position pos) {
		super(game, pos, ARMOR);
		points = 0;
		hasShockWave = false;
		canShoot = true;
	}
	//Métodos para acceder a los atributos privados de la clase
	public int getPoints() {
		return points;
	}
	
	public int getDamage() {
		return DAMAGE;
	}
	
	public int getArmour() {
		return ARMOR;
	}
	
	public boolean hasShockWave() {
		return hasShockWave;
	}
	
	public boolean canShoot() {
		return canShoot;
	}
	
	public void receivePoints(int points) {
		this.points += points;
	}
	
	public void enableShockWave() {
		hasShockWave = true;
	}
	
	public void disableShockWave() {
		hasShockWave = false;
	}
	
	public void enableLaser(){
		canShoot = true;
	}
	
	public void shootLaser() {
		UCMLaser laser = new UCMLaser(game, pos);
		game.addLaser(laser);
		canShoot = false;
	}
	
	//Métodos para imprimir por consola la UCMShip
	public String toString(Position pos) {
		return isOnPosition(pos) 
				? isAlive()
						? getSymbol() 
						: getDeadSymbol()
				: "";
	}
	
	protected String getSymbol() {
		return Messages.UCMSHIP_SYMBOL;
	}
	
	private static String getDeadSymbol() {
		return Messages.UCMSHIP_DEAD_SYMBOL;
	}
	
	public String getInfo() {
		return Messages.ucmShipDescription(getDescription(), DAMAGE, ARMOR);
	}
	
	protected String getDescription() {
		return Messages.UCMSHIP_DESCRIPTION;
	}
		
	//Otros métodos
	public void automaticMove() {}
	
	public void onDelete() {}
	
}
