package de.rmkata.roverkata2.code;

public class Pos {
	private int x;
	private int y;
	
	private void log(String s){
	//	System.out.println(s);
	}
	
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
	
	public Pos addModulo(Pos dirVector, int w, int h) {
					log(this.toString()+".addModulo("+dirVector+","+w+","+h+") ");
		x += dirVector.getX();
		y += dirVector.getY();
					log("--> x="+x+", y="+y+";");
		x = (x % w + w) % w;
		y = (y % h + h) % h;
					log("this:="+this.toString());
		return new Pos(x, y);
	}
	
	
}
