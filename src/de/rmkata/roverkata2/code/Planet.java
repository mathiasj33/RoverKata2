package de.rmkata.roverkata2.code;

import java.util.ArrayList;

import de.rmkata.roverkata2.code.Direction.NESW;

public class Planet {
	
	private int height;
	private int width;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	public Planet(String name, int w, int h) {
		
	}

	public Pos getPositionAfterOneStepForward(Pos pos, Direction dir) {
		if(dir.getNesw() == NESW.NORTH) {
			return pos.addModulo(dir.getVector(), width, height);
		}
		return null;
	}

	public Obstacle obstacleAt(Pos newPos) {
		for(Obstacle o:obstacles) {
			if(o.getPos().equals(newPos)) {
				return o;
			}
		}
		return null;
	}
	
	public int getH() {
		return height;
	}
	
	public int getW() {
		return width;
	}
	
	public void addObstacle(Pos pos) {
		obstacles.add(new Obstacle(pos));
	}

}
