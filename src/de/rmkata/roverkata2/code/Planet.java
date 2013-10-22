package de.rmkata.roverkata2.code;

import java.util.Hashtable;

public class Planet {
	
	private String name;
	private int height;
	private int width;
	private Hashtable<Pos,Obstacle> obstacles = new Hashtable<Pos,Obstacle>();
	
	public Planet(String name, int w, int h) {
		this.name = name;
		this.width = w;
		this.height = h;
	}

	public Pos getPositionAfterOneStepForward(Pos pos, Direction dir) {
		return pos.addModulo(dir.getVector(), width, height);
	}

	public void addObstacle(Pos p) {
		obstacles.put(p,new Obstacle(p));
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	

	public Obstacle obstacleAt(Pos p) {
		return obstacles.get(p); 
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


}
