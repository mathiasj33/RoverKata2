package de.rmkata.roverkata2.test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmkata.roverkata2.code.Direction;
import de.rmkata.roverkata2.code.Direction.NESW;
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
		pos = new Pos(0,0);
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
	
	@Test
	public void testDoCommand_f() {
	
		Planet mockVenus = mock(Planet.class);
		Direction mockDir = mock(Direction.class);
		when(mockVenus.getPositionAfterOneStepForward(pos,mockDir)).thenReturn(new Pos(49,0));
		when(mockVenus.obstacleAt(new Pos(49,0))).thenReturn(null);
		rover = new Rover(mockVenus,pos,mockDir);
		
		Obstacle obstacle = rover.doCommand('f');
		Assert.assertEquals(new Pos(49,0), rover.getPos());
		Assert.assertNull(obstacle);
	}
	
	@Test
	public void testDoCommand_f_with_obstacle() {
	
		Planet mockVenus = mock(Planet.class);
		Direction mockDir = mock(Direction.class);
		when(mockVenus.getPositionAfterOneStepForward(pos,mockDir)).thenReturn(new Pos(49,0));
		when(mockVenus.obstacleAt(new Pos(49,0))).thenReturn(new Obstacle(new Pos(49,0)));

		rover = new Rover(mockVenus,pos,mockDir);
		
		Obstacle obstacle = rover.doCommand('f');
		Assert.assertEquals(new Pos(0,0), rover.getPos());
		Assert.assertNotNull(obstacle);
	}

	@Test
	public void testDoCommand_b_with_obstacle() {
	
		Planet mockVenus = mock(Planet.class);
		Direction mockDir = mock(Direction.class);
		when(mockVenus.getPositionAfterOneStepForward(pos,mockDir.getOppositeDirection())).thenReturn(new Pos(49,0));
		when(mockVenus.obstacleAt(new Pos(49,0))).thenReturn(new Obstacle(new Pos(49,0)));

		rover = new Rover(mockVenus,pos,mockDir);
		
		Obstacle obstacle = rover.doCommand('b');
		Assert.assertEquals(new Pos(0,0), rover.getPos());
		Assert.assertNotNull(obstacle);
	}


	@Test
	public void testDoCommand_b() {
	
		Planet mockVenus = mock(Planet.class);
		Direction mockDir = mock(Direction.class);
		Direction mockDirOpposite = mock(Direction.class);
		when(mockDir.getOppositeDirection()).thenReturn(mockDirOpposite);
		when(mockVenus.getPositionAfterOneStepForward(pos,mockDirOpposite)).thenReturn(new Pos(1,0));

		rover = new Rover(mockVenus,pos,mockDir);
		
		rover.doCommand('b');
		Assert.assertEquals(new Pos(1,0), rover.getPos());
	}

	@Test
	public void testDoCommand_l() {
	
		Planet mockVenus = mock(Planet.class);
		Direction mockDir = mock(Direction.class);
		Direction dirLeft = new Direction(NESW.WEST);
		when(mockDir.getDirectionToTheLeft()).thenReturn(dirLeft);

		rover = new Rover(mockVenus,pos,mockDir);
		
		rover.doCommand('l');
		Assert.assertEquals(dirLeft, rover.getDir());
	}


	@Test
	public void testDoCommand_r() {
	
		Planet mockVenus = mock(Planet.class);
		Direction mockDir = mock(Direction.class);
		Direction dirRight = new Direction(NESW.EAST);
		when(mockDir.getDirectionToTheRight()).thenReturn(dirRight);

		rover = new Rover(mockVenus,pos,mockDir);
		
		rover.doCommand('r');
		Assert.assertEquals(dirRight, rover.getDir());
	}
	
	@Test
	public void testMoveWithCollaboratorClasses() {
		Planet pluto = new Planet("Pluto", 2, 3);
		pluto.addObstacle(new Pos(0,0));
		Rover plutoRover = new Rover(pluto,new Pos(1,1),new Direction(NESW.NORTH));
		//
		//   o o
		//   o r
		//   x o
		//
		Obstacle obstacle = plutoRover.move("fff");
		Assert.assertNull(obstacle);
		Assert.assertEquals(plutoRover.getPos(), new Pos(1,1));
		
		obstacle = plutoRover.move("brf");
		Assert.assertNotNull(obstacle);
		Assert.assertEquals(plutoRover.getPos(), new Pos(1,0));
		
		obstacle = plutoRover.move("lfflb");
		Assert.assertNull(obstacle);
		Assert.assertEquals(plutoRover.getPos(), new Pos(0,2));
	}
	

}
