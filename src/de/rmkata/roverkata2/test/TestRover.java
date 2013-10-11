package de.rmkata..test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmkata.roverkata2.src.Direction;
import de.rmkata.roverkata2.src.Obstacle;
import de.rmkata.roverkata2.src.Planet;
import de.rmkata.roverkata2.src.Position;
import de.rmkata.roverkata2.src.Rover;

public class TestRover {

	private Planet mars;
	private Direction dir;
	private Position pos;
	private Rover rover;

	@Before
	public void setUp() throws Exception {
		mars = new Planet("Mars",100,100);
		dir = new Direction(Direction.NESW.NORTH);
		pos = new Position(0,0);
	}
	
	@Test
	public void testMove() {

		rover = new Rover(mars,pos,dir);
		Rover spyRover = spy(rover);
		doReturn(null).when(spyRover).doCommand('f');
		doReturn(null).when(spyRover).doCommand('l');
		doReturn(new Obstacle(new Position(2,2))).when(spyRover).doCommand('b');
		
		Obstacle o = spyRover.move("fflbbr");
		
		verify(spyRover, times(2)).doCommand('f');
		verify(spyRover, times(1)).doCommand('l');
		verify(spyRover, times(1)).doCommand('b');
		verify(spyRover, never()).doCommand('r');
		Assert.assertTrue(o!=null);
	}

}
