package com.minotaur;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EightQueenTest{
	
	private EightQueen queen;
	
	@Before
	public void setUp(){
		queen =new EightQueen();
		queen.printQueen();
	}
	
	@Test
	public void testQueenCount(){
		int count=queen.queenCount();
		assertEquals(92,count);
	}

}
