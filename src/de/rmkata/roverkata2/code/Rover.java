package de.rmkata.roverkata2.code;

public class Rover {
	
	private Pos pos;
	private Planet planet;
	private Direction dir;
	
	public Rover(Planet planet, Pos pos, Direction dir) {
		setPlanet(planet);
		setPos(pos);
		setDir(dir);
	}
	
	public Obstacle move(String s) {
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(c.equals('f') || c.equals('b') || c.equals('l') || c.equals('r')) {
				Obstacle o = doCommand(c);
				if(o != null) {
					return o;
				}
			}
		}
		return null;
	}
	
	public Obstacle doCommand(Character c) {
		Direction dirLocal = (c=='f') ? dir : dir.getOppositeDirection();
		switch (c) {
		case 'f':
		case 'b':
			Pos pos1 = planet.getPositionAfterOneStepForward(pos, dirLocal);
			if(planet.obstacleAt(pos1) != null) {
				return planet.obstacleAt(pos1);
			}
			pos = pos1;
			break;
		case 'l':
			dir = dir.getDirectionToTheLeft();
			break;
		case 'r': 
			dir = dir.getDirectionToTheRight();
			break;
		}
		return null;
	}

	public Pos getPos() {
		return pos;
	}

	public void setPos(Pos pos) {
		this.pos = pos;
	}

	public Planet getPlanet() {
		return planet;
	}

	private void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}


}
