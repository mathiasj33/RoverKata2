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
		NORTH(0,new String("NORTH"),new Pos(0,1)), EAST(1,new String("EAST"),new Pos(1,0)),
		SOUTH(2,new String("SOUTH"),new Pos(0,-1)), WEST(3,new String("WEST"),new Pos(-1,0));
		private int index;
		private String name;
		private Pos vector;
		
		NESW(int index, String name, Pos vector) {
			this.index = index;
			this.name = name;
			this.vector = vector;
		}

		int getIndex() {
			return index;
		}

		String getName() {
			return name;
		}

		Pos getVector() {
			return vector;
		}
		
		static NESW getNESW(int index) {
		      for (NESW nesw : NESW.values()) {
		          if (nesw.index == index) return nesw;
		      }
		      throw new IllegalArgumentException("Diese Richtung gibts nicht.");
		}
		
		NESW getNESWToTheRight() {
			return getNESW((this.getIndex()+1)%4);
		}

	}

	public Direction getOppositeDirection() {
		return new Direction(getDirectionToTheRight().getDirectionToTheRight().getNesw());
	}

	
	public String toString() {
		return getNesw().getName();
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
		return new Direction(this.getNesw().getNESWToTheRight());
	}
	
	public Pos getVector() {
		return getNesw().getVector();
	}


}
