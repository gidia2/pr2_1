package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class Ufo extends EnemyShip {
	
	private static final int DAMAGE = 0;
	private static final int ARMOR = 1;
	private static final int POINTS = 25;
	private static final Position INITIAL_POSITION = new Position(9, 0);
	
	private boolean enabled;

	public Ufo(Game game) {
		super(game, INITIAL_POSITION, 0);
		enabled = false;
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
	
	//Métodos para imprimir el ovni por consola
	public String toString(Position pos) {
		return isOnPosition(pos) 
				? getSymbol() + "[0" + life + "]" 
				: "";
	}
	
	protected String getSymbol() {
		return Messages.UFO_SYMBOL;
	}
	
	public String getInfo() {
		return Messages.alienDescription(getDescription(), POINTS, DAMAGE, ARMOR);
	}
	
	protected String getDescription() {
		return Messages.UFO_DESCRIPTION;
	}
	
	//Método para las computerActions y hacer aparecer el Ufo
	public void computerAction() {
		if(!enabled && canGenerateRandomUfo())
			enable();
	}
	
	private void enable() {
		enabled = true;
		life = ARMOR;
		pos = INITIAL_POSITION;
	}

	private boolean canGenerateRandomUfo(){
		return  game.getRandom().nextDouble() < game.getLevel().getUfoFrequency();
	}
	
	//Métodos para actualizar el estado del Ufo
	public void automaticMove() {
		if(isAlive())
			performMovement();
	}
	
	private void performMovement() {
		Position new_pos = new Position(pos.getCol() + Move.LEFT.getX(), pos.getRow() + Move.LEFT.getY());
		if (new_pos.isOnBoard())
			pos = new_pos;
		else
			onDelete();
		
	}
	
	public void onDelete() {
		enabled = false;
		life = 0;
		pos = null;
	}
	
	public boolean receiveAttack(UCMLaser laser) {
		receiveDamage(laser.getDamage());
		if(!isAlive()) {
			game.enableShockWave();
			game.receivePoints(POINTS);
			onDelete();
		}
		return true;
	}

}
