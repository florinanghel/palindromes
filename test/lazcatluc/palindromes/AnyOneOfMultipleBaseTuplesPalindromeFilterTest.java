package lazcatluc.palindromes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class AnyOneOfMultipleBaseTuplesPalindromeFilterTest {
	@Test
	public void allDigitsArePalindromes() {
		assertEquals(base10digits(),
				new AnyOneOfMultipleBaseTuplesPalindromeFilter()
					.filterNumbers(base10digits()));
	}
	
	@Test
	public void allDigitsAnd10AreNotPalindromes() {
		List<Integer> expectedFiltered = base10digits();
		assertEquals(expectedFiltered,
				new AnyOneOfMultipleBaseTuplesPalindromeFilter().filterNumbers(
						Arrays.asList(0,1,2,3,4,5,6,7,8,9,10)));
	}

	
	@Test
	public void allDigitsAnd10ArePalindromesInHigherBases() {
		List<Integer> digits = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
		assertEquals(digits,
				new AnyOneOfMultipleBaseTuplesPalindromeFilter()
					.withPossibleBaseTuples(Collections.singleton(
							new HashSet<Integer>(Arrays.asList(11,12,13,14,15,16))))
					.filterNumbers(digits));
	}
	
	@Test
	public void allDigitsInBase2() {
		assertEquals(Arrays.asList(0,1,3,5,7,9),
				new AnyOneOfMultipleBaseTuplesPalindromeFilter()
					.withPossibleBaseTuples(Collections.singleton(
							new HashSet<Integer>(Arrays.asList(2))))
					.filterNumbers(base10digits()));
	}
	
	@Test
	public void allDigitsInBase2And4() {
		assertEquals(Arrays.asList(0,1,3,5),
			new AnyOneOfMultipleBaseTuplesPalindromeFilter()
				.withPossibleBaseTuples(Collections.singleton(
						new HashSet<Integer>(Arrays.asList(2,4))))
					.filterNumbers(base10digits()));
	}
	
	@Test
	public void allDigitsInBase3And5() {
		assertEquals(Arrays.asList(0,1,2,4),
			new AnyOneOfMultipleBaseTuplesPalindromeFilter()
				.withPossibleBaseTuples(Collections.singleton(
						new HashSet<Integer>(Arrays.asList(3,5))))
					.filterNumbers(base10digits()));
	}
	
	
	@Test
	public void allDigitsInBase3And5Or2And4() {
		Set<Set<Integer>> possibleBaseTuples = new HashSet<>();
		possibleBaseTuples.add(new HashSet<Integer>(Arrays.asList(2,4)));
		possibleBaseTuples.add(new HashSet<Integer>(Arrays.asList(3,5)));
		
		assertEquals(Arrays.asList(0,1,2,3,4,5),
				new AnyOneOfMultipleBaseTuplesPalindromeFilter()
					.withPossibleBaseTuples(possibleBaseTuples)
					.filterNumbers(base10digits()));
	}
	
	@Test
	public void allPalindromesInAtLeast4BasesBetween2And10() {
		Set<Set<Integer>> possibleBaseTuples = new TupleGenerator<Integer>(
				Arrays.asList(2,3,4,5,6,7,8,9,10),4).tuples();
		List<Integer> numbersToTest = new ArrayList<Integer>();
		for (int i = 10; i < 500; i++) {
			numbersToTest.add(i);
		}
		
		assertEquals(Arrays.asList(121,373),
				new AnyOneOfMultipleBaseTuplesPalindromeFilter()
					.withPossibleBaseTuples(possibleBaseTuples)
					.filterNumbers(numbersToTest));
	}
	
	private static List<Integer> base10digits() {
		return Arrays.asList(0,1,2,3,4,5,6,7,8,9);
	}
}
