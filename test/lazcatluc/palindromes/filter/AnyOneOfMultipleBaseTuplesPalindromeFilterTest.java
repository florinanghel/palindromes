package lazcatluc.palindromes.filter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lazcatluc.palindromes.IntegerSequence;
import lazcatluc.palindromes.TupleGenerator;
import lazcatluc.palindromes.filter.AnyOneOfMultipleBaseTuplesPalindromeFilter;

import org.junit.Test;

public class AnyOneOfMultipleBaseTuplesPalindromeFilterTest {
	@Test
	public void allDigitsArePalindromes() {
		assertEquals(new IntegerSequence().build(),
				new AnyOneOfMultipleBaseTuplesPalindromeFilter()
					.keepOnlyPalindromes(new IntegerSequence().build()));
	}
	
	@Test
	public void allDigitsAnd10AreNotPalindromes() {
		List<Integer> expectedFiltered = new IntegerSequence().build();
		assertEquals(expectedFiltered,
				new AnyOneOfMultipleBaseTuplesPalindromeFilter().keepOnlyPalindromes(
						new IntegerSequence().to(10).build()));
	}

	
	@Test
	public void allDigitsAnd10ArePalindromesInHigherBases() {
		List<Integer> digits = new IntegerSequence().to(10).build();
		assertEquals(digits,
				new AnyOneOfMultipleBaseTuplesPalindromeFilter()
					.withPossibleBaseTuples(Collections.singleton(
							new HashSet<Integer>(new IntegerSequence().from(11).to(16).build())))
					.keepOnlyPalindromes(digits));
	}
	
	@Test
	public void allDigitsInBase2() {
		assertEquals(Arrays.asList(0,1,3,5,7,9),
				new AnyOneOfMultipleBaseTuplesPalindromeFilter()
					.withPossibleBaseTuples(Collections.singleton(
							new HashSet<Integer>(Arrays.asList(2))))
					.keepOnlyPalindromes(new IntegerSequence().build()));
	}
	
	@Test
	public void allDigitsInBase2And4() {
		assertEquals(Arrays.asList(0,1,3,5),
			new AnyOneOfMultipleBaseTuplesPalindromeFilter()
				.withPossibleBaseTuples(Collections.singleton(
						new HashSet<Integer>(Arrays.asList(2,4))))
					.keepOnlyPalindromes(new IntegerSequence().build()));
	}
	
	@Test
	public void allDigitsInBase3And5() {
		assertEquals(Arrays.asList(0,1,2,4),
			new AnyOneOfMultipleBaseTuplesPalindromeFilter()
				.withPossibleBaseTuples(Collections.singleton(
						new HashSet<Integer>(Arrays.asList(3,5))))
					.keepOnlyPalindromes(new IntegerSequence().build()));
	}
	
	
	@Test
	public void allDigitsInBase3And5Or2And4() {
		Set<Set<Integer>> possibleBaseTuples = new HashSet<>();
		possibleBaseTuples.add(new HashSet<Integer>(Arrays.asList(2,4)));
		possibleBaseTuples.add(new HashSet<Integer>(Arrays.asList(3,5)));
		
		assertEquals(Arrays.asList(0,1,2,3,4,5),
				new AnyOneOfMultipleBaseTuplesPalindromeFilter()
					.withPossibleBaseTuples(possibleBaseTuples)
					.keepOnlyPalindromes(new IntegerSequence().build()));
	}
	
	@Test
	public void allPalindromesInAtLeast4BasesBetween2And10() {
		Set<Set<Integer>> possibleBaseTuples = new TupleGenerator<Integer>(
				new IntegerSequence().from(2).to(10).build(),4).tuples();
		List<Integer> numbersToTest = new ArrayList<Integer>();
		for (int i = 10; i < 500; i++) {
			numbersToTest.add(i);
		}
		
		assertEquals(Arrays.asList(121,373),
				new AnyOneOfMultipleBaseTuplesPalindromeFilter()
					.withPossibleBaseTuples(possibleBaseTuples)
					.keepOnlyPalindromes(numbersToTest));
	}
}
