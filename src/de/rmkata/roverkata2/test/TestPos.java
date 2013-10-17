package de.rmkata.roverkata2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.rmkata.roverkata2.code.Pos;

public class TestPos {

	private Pos pos = null;
	
	@Before
	public void setUp() throws Exception {
		pos = new Pos(5,5);
	}

	@Test
	public final void testAddModuloPositiv() {
		Pos newPos = pos.addModulo(new Pos(6,24), 11, 14);
		Assert.assertEquals(0, newPos.getX());
		Assert.assertEquals(1, newPos.getY());
		
	}
	
	@Test
	public final void testAddModuloNegativ() {
		Pos newPos = pos.addModulo(new Pos(-6,-5), 11, 14);
		Assert.assertEquals(10, newPos.getX());
		Assert.assertEquals(0, newPos.getY());
	}


}
