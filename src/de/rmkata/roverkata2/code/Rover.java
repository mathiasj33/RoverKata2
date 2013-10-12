package de.rmkata.roverkata2.code;

public class Rover {
	
	public Rover(Planet planet, Pos pos, Direction dir) {
		
	}
	
	public Obstacle move(String s) {
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(Character.toString(c).equals("f") || Character.toString(c).equals("b") || Character.toString(c).equals("l") || Character.toString(c).equals("r")) {
				Obstacle o = doCommand(c);
				if(o != null) {
					return o;
				}
			}
		}
		return null;
	}
	
	public Obstacle doCommand(Character c) {
		return null;
	}

}
