package com.minotaur;

import org.junit.Test;

public class SortTest {

	
	@Test
	public void testQuickSort1(){
		int[] array={9,8,7,12,17,1,4,5,16,16,3,2,13,11,7,10,17,18};
		Sort.quickSort(array);
	}
	
	@Test
	public void testMergeSort1(){
		int[] array={9,8,7,12,17,1,4,5,16,16,3,2,13,11,7,10,17,18};
		Sort.mergeSort(array);
	}
}
