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
		int[][] board = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		assertEquals(0, GameEngine.eval(board));
		
		int[][] board2 = {{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		assertEquals(-1880, GameEngine.eval(board2));
		
		int[][] board3 = {{0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0}};
		assertEquals(-225, GameEngine.eval(board3));
		
	}
	@Test
	public void testMinMax(){
		int[][] board = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		int[] move = {1,1,1,1};
		int[] counter = {1,1,1,1,1,1};		
		assertEquals(0,GameEngine.MinMax(board, 1, 1, move, 1, counter));
		
		int[][] board2 = {{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
		int[] move2 = {1,1,1,1};
		int[] counter2 = {1,1,1,1,1,1};		
		assertEquals(-1880,GameEngine.MinMax(board2, 1, 1, move2, 1, counter2));
		
		int[][] board3 = {{0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0}};
		assertEquals(-225,GameEngine.MinMax(board3, 1, 1, move, 1, counter));
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