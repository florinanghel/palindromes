package lazcatluc.palindromes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class AnyOneOfMultipleBaseTuplesPalindromeDeciderTest {
	@Test
	public void emptyIsPalindrome() {
		assertTrue(new AnyOneOfMultipleBaseTuplesPalindromeDecider().isPalindrome());
	}
	
	@Test
	public void isPalindrome1000001() {
		assertTrue(new AnyOneOfMultipleBaseTuplesPalindromeDecider()
				.representedBy(1000001).isPalindrome());
	}
	
	
	@Test
	public void isNotPalindrome1000002() {
		assertFalse(new AnyOneOfMultipleBaseTuplesPalindromeDecider()
			.representedBy(1000002).isPalindrome());
	}
	
	
	@Test
	public void isPalindrome3InBase10And2() {
		assertTrue(new AnyOneOfMultipleBaseTuplesPalindromeDecider()
			.representedBy(3).withPossibleBaseTuples(Collections.singleton(
					new HashSet<>(Arrays.asList(2, 10)))).isPalindrome());
	}
	
	@Test
	public void isNotPalindrome3InBase10And2And3() {
		assertFalse(new AnyOneOfMultipleBaseTuplesPalindromeDecider()
			.representedBy(3).withPossibleBaseTuples(Collections.singleton(
					new HashSet<>(Arrays.asList(2, 3, 10)))).isPalindrome());
	}
	
	@Test
	public void isPalindrome3InBase10And2OrBase10And2And3() {
		Set<Set<Integer>> possibleBaseTuples = new HashSet<>();
		possibleBaseTuples.add(new HashSet<>(Arrays.asList(2, 10)));
		possibleBaseTuples.add(new HashSet<>(Arrays.asList(2, 3, 10)));
		
		assertTrue(new AnyOneOfMultipleBaseTuplesPalindromeDecider()
			.representedBy(3).withPossibleBaseTuples(possibleBaseTuples).isPalindrome());
	}
}
