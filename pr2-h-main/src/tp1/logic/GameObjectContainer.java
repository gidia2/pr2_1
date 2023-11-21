package tp1.logic;

import java.util.ArrayList;
import java.util.List;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.ShockWave;
import tp1.logic.gameobjects.UCMShip;
import tp1.logic.gameobjects.Ufo;

public class GameObjectContainer {

	private List<GameObject> objects;

	public GameObjectContainer() {
		objects = new ArrayList<>();
	}

	public void add(GameObject object) {
		objects.add(object);
	}

	public void remove(GameObject object) {
		objects.remove(object);
	}

	public void automaticMoves() {
		for (int i=0;i<objects.size();i++) {
			GameObject object = objects.get(i);
			if(object.isAlive()) {
				object.automaticMove();
				if(!object.isAlive())
					i--;
			}
		}
	}

	public void computerActions() {
		for (int i=0;i<objects.size();i++) {
			GameObject object = objects.get(i);
			object.computerAction();
		}
	}
	
	public void performAttacks() {
		for (int i=0;i<objects.size();i++) {
			GameObject object = objects.get(i);
			if(object.isAlive()) {
				performAttacks(object);
				if(!object.isAlive())
					i--;
				if(object instanceof ShockWave)
					object.onDelete();
			}
		}
	}
	
	private void performAttacks(GameObject object) {
		for (int i=0;i<objects.size();i++) {
			GameObject other = objects.get(i);
			if(other.isAlive()) {
				if(other != object) {
					if(!object.performAttack(other))
						break;
				}
			}
		}
	}
	
	public void checkAttacks(GameObject object) {
		for(int j = 0; j < objects.size(); j++) {
			GameObject other = objects.get(j);
			if(other.isAlive()) {
				if(other != object) {
					other.performAttack(object);
					if(!other.isAlive())
						j--;
				}
			}
		}
	}
	
	public String toString(int col, int row) {
		StringBuilder posString = new StringBuilder();
		Position posActual = new Position(col, row);
		
		for(int i = 0; i < objects.size(); i++) {
			GameObject object = objects.get(i);
			if(object.isAlive() && object.isOnPosition(posActual))
				posString.append(object.toString());
		}
		
		return posString.toString();
	}
}
