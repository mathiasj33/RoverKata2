package de.rmkata.roverkata2.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmkata.roverkata2.code.Direction;
import de.rmkata.roverkata2.code.Obstacle;
import de.rmkata.roverkata2.code.Planet;
import de.rmkata.roverkata2.code.Pos;

public class TestPlanet {
	private Planet mars = null;

	@Before
	public void setUp() throws Exception {
		mars = new Planet("Mars", 100, 90);
	}

	@Test
	public final void testGetPositionAfterOneStepForward() {
		Pos startPos = mock(Pos.class);
		when(startPos.getX()).thenReturn(99);
		when(startPos.getY()).thenReturn(89);
		when(startPos.addModulo(new Pos(0,1),mars.getW(),mars.getH())).thenReturn(new Pos(99,0));
		Direction startDir = mock(Direction.class);
		when(startDir.getNesw()).thenReturn(Direction.NESW.NORTH);
		when(startDir.getVector()).thenReturn(new Pos(0,1));
		
		Pos pos = mars.getPositionAfterOneStepForward(startPos, startDir);
		Assert.assertEquals(new Pos(99,0), pos);
	}

	@Test
	public final void testObstacleAt() {
		mars.addObstacle(new Pos(2,4));
		Obstacle obstacle = mars.obstacleAt(new Pos(2,4));
		Assert.assertNotNull(obstacle);
		Assert.assertEquals(new Pos(2,4), obstacle.getPos());
		
		obstacle = mars.obstacleAt(new Pos(2,3));
		Assert.assertNull(obstacle);
	}

}
