package de.rmkata.roverkata2.code;

import java.util.ArrayList;

public class Planet {
	
	private String name;
	private int height;
	private int width;
	private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	
	public Planet(String name, int w, int h) {
		this.name = name;
		this.width = w;
		this.height = h;
	}

	public Pos getPositionAfterOneStepForward(Pos pos, Direction dir) {
		return pos.addModulo(dir.getVector(), width, height);
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
	
	public String getName() {
		return name;
	}

	public void addObstacle(Pos pos) {
		obstacles.add(new Obstacle(pos));
	}

}
