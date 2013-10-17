package de.rmkata.roverkata2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmkata.roverkata2.code.Direction;
import de.rmkata.roverkata2.code.Direction.NESW;
import de.rmkata.roverkata2.code.Pos;

public class TestDirection {
	
	private Direction dNorth = null;
	private Direction dEast = null;
	private Direction dSouth = null;
	private Direction dWest = null;
	

	@Before
	public void setUp() throws Exception {
		dNorth = new Direction(NESW.NORTH);
		dEast = new Direction(NESW.EAST);
		dSouth = new Direction(NESW.SOUTH);
		dWest = new Direction(NESW.WEST);
	}

	@Test
	public final void testGetOppositeDirection() {
		Assert.assertEquals(dSouth,dNorth.getOppositeDirection());
		Assert.assertEquals(dWest,dEast.getOppositeDirection());
		Assert.assertEquals(dNorth,dSouth.getOppositeDirection());
		Assert.assertEquals(dEast,dWest.getOppositeDirection());
	}

	@Test
	public final void testGetDirectionToTheLeft() {
		Assert.assertEquals(dWest,  dNorth.getDirectionToTheLeft());
		Assert.assertEquals(dSouth, dWest.getDirectionToTheLeft());
		Assert.assertEquals(dEast,  dSouth.getDirectionToTheLeft());
		Assert.assertEquals(dNorth, dEast.getDirectionToTheLeft());
	}

	@Test
	public final void testGetDirectionToTheRight() {
		Assert.assertEquals(dEast,  dNorth.getDirectionToTheRight());
		Assert.assertEquals(dSouth, dEast.getDirectionToTheRight());
		Assert.assertEquals(dWest,  dSouth.getDirectionToTheRight());
		Assert.assertEquals(dNorth, dWest.getDirectionToTheRight());
	}

	@Test
	public final void testGetVector() {
		Assert.assertEquals(new Pos(-1,0), dWest.getVector());
	}

}
