package tp1.logic;

import java.util.Random;
import tp1.logic.gameobjects.RegularAlien;
import tp1.logic.gameobjects.DestroyerAlien;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.AlienShip;
import tp1.logic.gameobjects.UCMShip;
import tp1.logic.gameobjects.Ufo;
import tp1.view.Messages;


public class Game implements GameStatus {

	public static final int DIM_X = 9;
	public static final int DIM_Y = 8;

	private int currentCycle;
	private Level level;
	private long seed;
	private Random rand;
	private AlienManager alienManager;
	private GameObjectContainer container;
	private UCMShip player;
	
	private boolean doExit;
	
	
	public Game(Level level, long seed) {
		currentCycle = 0;
		this.level= level ;
		this.seed = seed ;
		rand = new Random(this.seed);
		alienManager = new AlienManager(this);
		container = alienManager.initialize();
		player = new UCMShip(this);
		container.add(player);
		doExit = false;
	}
	
	//Métodos de acceso a los atributos privados de la clase game
	public Level getLevel() {
		return level;
	}
	
	public Random getRandom() {
		return rand;
	}
	
	public int getCycle() {
		return currentCycle;
	}
	
	//Métodos para concoer los aliens que quedan con vida
	public int getRemainingAliens() {
		return alienManager.getRemainingAliens();
	}
	
	//Métodos para concer si acaba el juego
	public boolean isFinished() {
		return doExit || playerWin() || aliensWin();
	}
	
	public boolean playerWin() {
		return alienManager.allAlienDead();
	}

	public boolean aliensWin() {
		return alienManager.haveLanded() || !player.isAlive();
	}
	
	//Métodos que ejecutan los comandos del usuario
	public void exit(){
		doExit = true;
	}
	
	public void reset(){
		currentCycle = 0;
		rand = new Random(this.seed);
		alienManager = new AlienManager(this);
		container = alienManager.initialize();
		player = new UCMShip(this);
		container.add(player);
		doExit = false;
	}
	
	public void list() {
		System.out.println(infoToString());
	}
	
	public boolean move(Move move){
		return player.move(move);
	}
	
	public boolean shoot(){
		return player.shootLaser();
	}
	
	public boolean shockWave() {
		return player.shockWave();
	}
	
	
	//Métodos que actualizan el estado del juego (acciones automáticas y computerActions
	public void update(){
		updateCycle();
		computerActions();
		automaticMoves();
		performAttacks();
	}
	
	private void updateCycle() {
		currentCycle++;
	}
	
	private void computerActions(){
		container.computerActions();
	}
	
	private void automaticMoves() {
		container.automaticMoves();
	}
	
	private void performAttacks() {
		container.performAttacks();
	}
	
	public void checkAttacks(GameObject object) {
		container.checkAttacks(object);
	}
	//Otros métodos que son llamados desde las otras clases
	public void addObject(GameObject object) {
		container.add(object);
	}
	
	public void removeObject(GameObject object) {
		container.remove(object);
	}
	
	public void enableLaser() {
		player.enableLaser();
	}
	
	public void enableShockWave() {
		player.enableShockWave();
	}
	
	public void enableBomb(DestroyerAlien alien) {
		alien.enableBomb();
	}
	
	public void alienDead(AlienShip alien) {
		alienManager.alienDead();
		removeObject(alien);
	}
	
	public void receivePoints(int points){
		player.receivePoints(points);
	}
	
	
	//Métodos para la impresión del juego por consola
	public String infoToString() {
		StringBuilder info = new StringBuilder();
		info
		.append(new UCMShip(this).getInfo()).append("\n")
		.append(new RegularAlien(this, new Position(0,0), alienManager).getInfo()).append("\n")
		.append(new DestroyerAlien(this, new Position(0, 0), alienManager).getInfo()).append("\n")
		.append(new Ufo(this).getInfo()).append("\n");
		
		return info.toString();
	}
	
	public String stateToString() {
		StringBuilder buffer = new StringBuilder();
		/* @formatter:off */
		buffer
		.append(Messages.REMAINING_LIFES).append(" ").append(player.getLife()).append("\n")
		.append(Messages.POINTS).append(" ").append(player.getPoints()).append("\n")
		.append(Messages.HAS_SHOCKWAVE).append(" ").append(player.hasShockWave() ? Messages.SHOCKWAVE_ON : Messages.SHOCKWAVE_OFF).append("\n");
		
		return buffer.toString();
	}
	
	public String positionToString(int col, int row) {
		return container.toString(col, row);
	}
}
