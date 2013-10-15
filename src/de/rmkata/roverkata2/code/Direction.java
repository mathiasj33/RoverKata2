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

	
	public String toString() {
		switch (getNesw()) {
		case NORTH:
			return "NORTH";
		case SOUTH:
			return "SOUTH";
		case EAST:
			return "EAST";
		case WEST:
			return "WEST";
		}
		return "NOT DEFINED";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nesw == null) ? 0 : nesw.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direction other = (Direction) obj;
		if (nesw != other.nesw)
			return false;
		return true;
	}
	
	public Direction getDirectionToTheLeft() {
		return null;
	}
	
	public Direction getDirectionToTheRight() {
		return null;
	}


}
