import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;
import org.apache.commons.lang3.ArrayUtils;

public class ConcatArraysTest {

	//Generates 100 arrays of various sizes (up to 500) containing integers between 0 and 500
		public static int[][] generateRandomArrays() {
			Random rand = new Random();
			int[][] randomArrays = new int[100][];

			for(int i = 0; i < 100; i++) {
				int arraySize = rand.nextInt(500);  
				randomArrays[i] = new int[arraySize];

				for(int j = 0; j < arraySize; j++) {
					randomArrays[i][j] =  rand.nextInt(500);
				}

			}

			return randomArrays;
		}

	//Given two arrays of any size, if I concatenate those arrays, the final array should contain all elements found in the original arrays
	@Test
	public void testComposition () {
		int[][] randomArrays = generateRandomArrays();
		
		for(int i = 0; i < randomArrays.length-1; i++) {	
			int[] testArray1 = randomArrays[i];
			int[] testArray2 = randomArrays[i+1];
			
			int[] concatArray = ArrayUtils.addAll(testArray1, testArray2);
			
			for(int j = 0; j < concatArray.length; j++) {
				if(!ArrayUtils.contains(testArray1, concatArray[j]))  {
					if(!ArrayUtils.contains(testArray2, concatArray[j]))  {
						fail("testComposition");
					}
				}
			}
		}
	}
	
	//Given two arrays of any size, if I concatenate those arrays, the final array should be the same size as the sum of the two original arrays' sizes
	@Test
	public void testSize() {
		int[][] randomArrays = generateRandomArrays();
		
		for(int i = 0; i < randomArrays.length-1; i++) {
			int[] testArray1 = randomArrays[i];
			int[] testArray2 = randomArrays[i+1];
			
			int[] concatArray = ArrayUtils.addAll(testArray1, testArray2);
	
			assertEquals(testArray1.length + testArray2.length, concatArray.length);
		}
	}

	//Given an array of any size, if I concatenate that array with a blank array, the resulting array should be the same as the original
	@Test
	public void testBlank() {
		int[][] randomArrays = generateRandomArrays();
		
		for(int i = 0; i < randomArrays.length; i++) {
			int[] testArray = randomArrays[i];
			int[] blankArray = null;
			
			int[] concatArray = ArrayUtils.addAll(testArray, blankArray);

			assertEquals(testArray, concatArray);
		}
	}

	//Given the concatenation of two arrays of any size, the first n integers (n being the length of the first array) should be found in the first array
	@Test
	public void testLeftConcat() {
		int[][] randomArrays = generateRandomArrays();
		
		// loop through all arrays
		for(int i = 0; i < randomArrays.length-1; i++) {
			int[] testArray1 = randomArrays[i];
			int[] testArray2 = randomArrays[i+1];
			
			int[] concatArray = ArrayUtils.addAll(testArray1, testArray2);

			for (int j = 0; j < testArray1.length; j++) {
				if(concatArray[j] != testArray1[j])  {
					fail("testLeftConcat");
				}
			}
		}
	}

	//Given the concatenation of two arrays of any size, the last n integers (n being the length of the second array) should be found in the second array
	@Test
	public void testRightConcat() {
		int[][] randomArrays = generateRandomArrays();
		
		// loop through all arrays
		for(int i = 0; i < randomArrays.length-1; i++) {
			int[] testArray1 = randomArrays[i];
			int[] testArray2 = randomArrays[i+1];
			
			int[] concatArray = ArrayUtils.addAll(testArray1, testArray2);

			for (int j = 0; j < testArray1.length; j++) {
				if(concatArray[j] != testArray1[j])  {
					fail("testLeftConcat");
				}
			}
		}
	}

	//Given two arrays of any size, the concatenation of those arrays should always yield the same result
	@Test
	public void testSameResult () {
		int[][] randomArrays = generateRandomArrays();
		
		for(int i = 0; i < randomArrays.length-1; i++) {
			int[] testArray1 = randomArrays[i];
			int[] testArray2 = randomArrays[i+1];
			
			int[] concatArray1 = ArrayUtils.addAll(testArray1, testArray2);
			int[] concatArray2 = ArrayUtils.addAll(testArray1, testArray2);
			
			
			assertArrayEquals(concatArray1, concatArray2);
		}
	}
}

