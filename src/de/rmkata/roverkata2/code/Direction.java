package de.rmkata.roverkata2.code;

public class Direction {
	
	private NESW nesw = null;
	
	public Direction(NESW nesw) {
		setNesw(nesw);
	}
	
	public NESW getNesw() {
		return nesw;
	}

	private void setNesw(NESW nesw) {
		this.nesw = nesw;
	}

	public enum NESW {
		NORTH,
		EAST,
		SOUTH,
		WEST
	}

	public Direction getOppositeDirection() {
		// TODO Auto-generated method stub
		return null;
	}

}
