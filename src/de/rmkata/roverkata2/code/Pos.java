package de.rmkata.roverkata2.code;

public class Pos {
	private int x;
	private int y;
	
	public Pos(int x, int y) {
		super();
		setX(x);
		setY(y);
	}
	
	public int getX() {
		return x;
	}
	
	private void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	private void setY(int y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Pos other = (Pos) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	public String toString() {
		return "(" + x +";"+y+")";
	}
	
	public Pos addModulo(Pos start, int w, int h) {
		x += start.getX();
		y += start.getY();
		x = (w % x + x) % w;
		y = (h % y + y) % h;
		return new Pos(x, y);
	}
	
	
}
