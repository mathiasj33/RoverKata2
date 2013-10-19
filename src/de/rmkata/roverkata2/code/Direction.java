package de.rmkata.roverkata2.code;

public class Direction {
	
	private NESW nesw;
	
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
		return new Direction(getDirectionToTheRight().getDirectionToTheRight().getNesw());
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
		return new Direction(getDirectionToTheRight().getDirectionToTheRight().getDirectionToTheRight().getNesw());  //3 mal rechts ist auch nach links
	}
	
	public Direction getDirectionToTheRight() {
		if(nesw == NESW.NORTH) return new Direction(NESW.EAST);
		else if(nesw == NESW.EAST) return new Direction(NESW.SOUTH);
		else if(nesw == NESW.SOUTH) return new Direction(NESW.WEST);
		else if(nesw == NESW.WEST) return new Direction(NESW.NORTH);
		return null;
	}
	
	public Pos getVector() {
		if(nesw == NESW.NORTH) return new Pos(0,1);
		else if(nesw == NESW.EAST) return new Pos(1,0);
		else if(nesw == NESW.SOUTH) return new Pos(0,-1);
		else if(nesw == NESW.WEST) return new Pos(-1,0);
		return null;
	}


}
