package tp1.logic;

import tp1.logic.gameobjects.RegularAlien;
import tp1.logic.lists.DestroyerAlienList;
import tp1.logic.lists.RegularAlienList;

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

	public GameObjectContainer initialize() {
		this.remainingAliens = 0;
		GameObjectContainer container = new GameObjectContainer();

		initializeOvni(container);
		initializeRegularAliens(container);
		initializeDestroyerAliens(container);

		// TODO fill with your code

		return container;
	}

	private void initializeOvni(GameObjectContainer container) {
		// container.add(new Ufo(game));
	}

	private void initializeRegularAliens(GameObjectContainer container) {

		// TODO fill with your code
		// container.add(new RegularAlien(....));
	}

	private void initializeDestroyerAliens(GameObjectContainer container) {
		// TODO fill with your code
	}

	public int getRemainingAliens() {
		return remainingAliens;
	}
	
	public boolean allAlienDead() {
		return remainingAliens == 0;
	}
	
	public void alienDead(int points){
		remainingAliens--;
		if(onBorder)
			decreaseOnBorder();
		game.receivePoints(points);
	}
	
	public boolean haveLanded(RegularAlienList regularAliens, DestroyerAlienList destroyerAliens){
		if(finalRowReached(regularAliens, destroyerAliens))
			squadInFinalRow = true;
		return squadInFinalRow;
	}
	
	private boolean finalRowReached(RegularAlienList regularAliens, DestroyerAlienList destroyerAliens){
		return regularAliens.finalRowReached() || destroyerAliens.finalRowReached();
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

}
