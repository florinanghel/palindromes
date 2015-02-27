package lazcatluc.palindromes.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import lazcatluc.palindromes.IntegerSequence;

import org.junit.Test;

public class AdderUntilPalindromeFilterITest {

	@Test
	public void allNumbersBelow10000ThatFinishIn1000FinishIn50() {
		List<Integer> numbers1000 = new IntegerSequence().to(9999).build();
		
		numbers1000.removeAll(
				new AdderUntilPalindromeFilter().addingAtMost(1000)
					.keepOnlyPalindromes(numbers1000));
		
		List<Integer> numbers50 = new IntegerSequence().to(9999).build();
		
		numbers50.removeAll(
				new AdderUntilPalindromeFilter().addingAtMost(50)
					.keepOnlyPalindromes(numbers50));
		
		assertEquals(numbers50, numbers1000);
	}
	
	
	
	@Test
	public void allNumbersAtMost10000ThatDontBecomePalindromesIn1000GenerationsPerformance() {
		long start = System.currentTimeMillis();
		List<Integer> numbers = new IntegerSequence().to(9999).build();
		
		numbers.removeAll(
				new AdderUntilPalindromeFilter().addingAtMost(1000)
					.keepOnlyPalindromes(numbers));

		long end = System.currentTimeMillis();
		
		assertTrue(end - start <= 5000);

	}

}
