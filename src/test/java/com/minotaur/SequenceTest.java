package com.minotaur;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SequenceTest {

	private Dp dp;
	
	private final static int NUM=399;
	
	private static int[] a=new int[NUM];

	@BeforeClass
	public static void init(){
		for(int i=0;i<NUM;i++){
			Random rd=new Random();
			a[i]=rd.nextInt(NUM);
		}
	}
	
	@Before
	public void setUp(){
		dp =new Dp();
	}
	
	@Test
	public void testRule0() {
		long b=System.currentTimeMillis();
		int len=dp.sumSeque(a);
		long e=System.currentTimeMillis();
		System.out.println("len:"+len+"\ttime:"+(e-b));
	}

	@Test
	public void testRule1() {
		dp.sum();
		assertEquals(100,dp.ii);
	}
}
