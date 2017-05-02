package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import checkers.GameEngine;

public class GameEngineTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEval() {
		int[][] board = new int[8][8];
		assertEquals(0, GameEngine.eval(board));
		
	}
	@Test
	public void testMinMax(){
		fail("Not yet implemented");
	}
	@Test
	public void testCopyBoard(){
		fail("Not yet implemented");
		//can't test due to method not being public
		
	}
	@Test
	public void testGetOpponent(){
		fail("Not yet implemented");
		//can't test due to method not being public
	}
	@Test
	public void testGetTurn(){
		fail("Not yet implemented");
		//can't test due to method not being public
		
	}

}
