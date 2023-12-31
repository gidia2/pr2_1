package tp1.logic;

import tp1.logic.gameobjects.RegularAlien;
import tp1.logic.gameobjects.Ufo;
import tp1.logic.gameobjects.DestroyerAlien;
/**
 * 
 * Manages alien initialization and
 * used by aliens to coordinate movement
 *
 */
public class AlienManager {
	public static final int FIRST_ALIEN_COL = 2;
	public static final int FIRST_ALIEN_ROW = 1;
	
	private Game game;
	private int remainingAliens;
	private boolean squadInFinalRow;
	private boolean onBorder;
	private int shipsOnBorder;

	public AlienManager(Game game) {
		this.game = game;
		remainingAliens = 0;
		squadInFinalRow = false;
		onBorder = false;
		shipsOnBorder = 0;
	}
	
	
	// INITIALIZER METHODS
	/**
	 * Initializes the list of regular aliens
	 * @return the initial list of regular aliens according to the current level
	 */
	
	public GameObjectContainer initialize() {
		this.remainingAliens = 0;
		GameObjectContainer  container= new GameObjectContainer();
		
		initializeOvni(container);
		initializeRegularAliens(container);
		initializeDestroyerAliens(container);
		
		return container;
	}
	
	private void initializeOvni(GameObjectContainer container) {
		container.add(new Ufo(game));
	}
	
	private void initializeRegularAliens(GameObjectContainer container) {
		int numRows = game.getLevel().getNumRowsRegularAliens();
		int numRegularAliensInRow = game.getLevel().getNumRegularAliens() / numRows;
		
		for(int i = 0; i < numRows; i++) {
			for(int j = 0; j < numRegularAliensInRow; j++) {
				Position pos = new Position(AlienManager.FIRST_ALIEN_COL + j, AlienManager.FIRST_ALIEN_ROW + i);
				RegularAlien regularAlien = new RegularAlien(game, pos, this);
				container.add(regularAlien);
				remainingAliens++;
			}
		}
	}

	/**
	 * Initializes the list of destroyer aliens
	 * @return the initial list of destroyer aliens according to the current level
	 */
	private  void initializeDestroyerAliens(GameObjectContainer container) {
		int numRegularAliensInRow = game.getLevel().getNumRegularAliens() / game.getLevel().getNumRowsRegularAliens();
		int numDestroyerAliens = game.getLevel().getNumDestroyerAliens();
		int numRows = game.getLevel().getNumRowsRegularAliens();
		
		for(int i = 0; i < numDestroyerAliens; i++) {
				Position pos = new Position(AlienManager.FIRST_ALIEN_COL + ((numRegularAliensInRow - numDestroyerAliens) / 2) + i, AlienManager.FIRST_ALIEN_ROW  + numRows);
				DestroyerAlien destroyerAlien = new DestroyerAlien(game, pos, this);
				container.add(destroyerAlien);
				remainingAliens++;
		}
	}

	
	// CONTROL METHODS
	public int getRemainingAliens() {
		return remainingAliens;
	}
	
	public boolean allAlienDead() {
		return remainingAliens == 0;
	}
	
	public void alienDead(){
		remainingAliens--;
		if(onBorder)
			decreaseOnBorder();
	}
	
	public boolean onBorder() {
		return onBorder;
	}
	
	public void shipOnBorder() {
		if(!onBorder) {
			onBorder = true;
			shipsOnBorder = remainingAliens;
		}
	}
	
	public void decreaseOnBorder() {
		shipsOnBorder--;
		if(shipsOnBorder == 0)
			onBorder = false;
	}
	
	public void squadInFinalRow() {
		squadInFinalRow = true;
	}
	
	public boolean haveLanded() {
		return squadInFinalRow;
	}
}
