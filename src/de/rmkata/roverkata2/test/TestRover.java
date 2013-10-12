package de.rmkata.roverkata2.test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmkata.roverkata2.code.Direction;
import de.rmkata.roverkata2.code.Obstacle;
import de.rmkata.roverkata2.code.Planet;
import de.rmkata.roverkata2.code.Pos;
import de.rmkata.roverkata2.code.Rover;

public class TestRover {

	private Planet mars;
	private Direction dir;
	private Pos pos;
	private Rover rover;

	@Before
	public void setUp() throws Exception {
		mars = new Planet("Mars",100,100);
		dir = new Direction(Direction.NESW.NORTH);
		pos = new Pos(0,0);  //Es muss Pos heiﬂen, da schon eine andere Java Klasse Position heiﬂt
	}
	
	@Test
	public void testMove() {

		rover = new Rover(mars,pos,dir);
		Rover spyRover = spy(rover);
		doReturn(null).when(spyRover).doCommand('f');
		doReturn(null).when(spyRover).doCommand('l');
		doReturn(new Obstacle(new Pos(2,2))).when(spyRover).doCommand('b');
		
		Obstacle o = spyRover.move("fflbbr");
		
		verify(spyRover, times(2)).doCommand('f');
		verify(spyRover, times(1)).doCommand('l');
		verify(spyRover, times(1)).doCommand('b');
		verify(spyRover, never()).doCommand('r');
		Assert.assertTrue(o!=null);
	}

}
