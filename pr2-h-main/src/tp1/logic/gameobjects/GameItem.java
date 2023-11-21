package tp1.logic.gameobjects;

import tp1.logic.Position;

public interface GameItem {
	
	
	public boolean performAttack(GameItem other);
	
	public void receiveAttack(EnemyWeapon weapon);
	public void receiveAttack(UCMWeapon weapon);

	public boolean isAlive();
	public boolean isOnPosition(Position pos);

}
