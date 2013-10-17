package de.rmkata.roverkata2.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	TestDirection.class,
	TestRover.class,
	TestPlanet.class,
	TestPos.class
	})
public class AllTests {
}