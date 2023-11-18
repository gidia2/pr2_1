package tp1.logic;

public enum Level {

	EASY(4, 1, 2, 0.1, 3, 0.5), HARD(8, 2, 2, 0.3, 2, 0.2), INSANE(8, 2, 4, 0.5, 1, 0.1);

	private int numRegularAliens;
	private int numRowsRegularAliens;
	private int numDestroyerAliens;
	private int numCyclesToMoveOneCell;
	private double ufoFrequency;
	private double shootFrequency;

	private Level(int numRegularAliens, int numRowsRegularAliens, 
			      int numDestroyerAliens, 
			      double shootFrequency, int numCyclesToMoveOneCell,
			      double ufoFrequency) {
		this.numRegularAliens = numRegularAliens;
		this.numRowsRegularAliens = numRowsRegularAliens;
		this.numDestroyerAliens = numDestroyerAliens;
		this.shootFrequency = shootFrequency;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ufoFrequency = ufoFrequency;
	}

	
	//TODO fill your code
	
	public int getNumRegularAliens() {
		return numRegularAliens;
	}
	
	public int getNumRowsRegularAliens() {
		return numRowsRegularAliens;
	}
	
	public int getNumDestroyerAliens() {
		return numDestroyerAliens;
	}
	
	public double getShootFrequency() {
		return shootFrequency;
	}
	
	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMoveOneCell;
	}
	
	/**
	 * Returns UFO frequency corresponding the Level
	 * @return UFO Frequency
	 */
	public double getUfoFrequency() {
		return ufoFrequency;
	}

	// TODO use your enum Level from p1

	public static String all(String separator) {
		StringBuilder sb = new StringBuilder();
		for (Level level : Level.values())
			sb.append(level.name() + separator);
		String allLevels = sb.toString();
		return allLevels.substring(0, allLevels.length() - separator.length());
	}

	public static Level valueOfIgnoreCase(String param) {
		for (Level level : Level.values())
			if (level.name().equalsIgnoreCase(param))
				return level;
		return null;
	}

}