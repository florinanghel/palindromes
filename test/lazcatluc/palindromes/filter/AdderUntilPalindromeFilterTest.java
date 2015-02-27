package lazcatluc.palindromes.filter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import lazcatluc.palindromes.IntegerSequence;
import lazcatluc.palindromes.filter.AdderUntilPalindromeFilter;

import org.junit.Test;

public class AdderUntilPalindromeFilterTest {
	@Test
	public void allDigitsArePalindromes() {
		assertEquals(new IntegerSequence().build(), new AdderUntilPalindromeFilter()
				.addingAtMost(0).keepOnlyPalindromes(new IntegerSequence().build()));
	}

	@Test
	public void allDigitsAnd10AreNotPalindromes() {
		assertEquals(
				new IntegerSequence().build(),
				new AdderUntilPalindromeFilter().addingAtMost(0).keepOnlyPalindromes(
						new IntegerSequence().to(10).build()));
	}

	@Test
	public void allNumbersAtMost100ThatDontBecomePalindromesIn10Generations() {
		List<Integer> numbers = new IntegerSequence().to(99).build();
		
		numbers.removeAll(
				new AdderUntilPalindromeFilter().addingAtMost(10)
					.keepOnlyPalindromes(numbers));
					
		assertEquals(Arrays.asList(89,98), numbers);
	}
	
	@Test
	public void allNumbersBelow10000ThatFinishIn1000FinishIn500() {
		List<Integer> numbers1000 = new IntegerSequence().to(9999).build();
		
		numbers1000.removeAll(
				new AdderUntilPalindromeFilter().addingAtMost(1000)
					.keepOnlyPalindromes(numbers1000));
		
		List<Integer> numbers500 = new IntegerSequence().to(9999).build();
		
		numbers500.removeAll(
				new AdderUntilPalindromeFilter().addingAtMost(500)
					.keepOnlyPalindromes(numbers500));
		
		assertEquals(numbers500, numbers1000);
	}
	
	@Test
	public void allNumbersAtMost10000ThatDontBecomePalindromesIn1000GenerationsPerformance() {
		long start = System.currentTimeMillis();
		List<Integer> numbers = new IntegerSequence().to(9999).build();
		
		numbers.removeAll(
				new AdderUntilPalindromeFilter().addingAtMost(500)
					.keepOnlyPalindromes(numbers));

		long end = System.currentTimeMillis();
		
		assertTrue(end - start <= 5000);
		System.out.println(numbers.size());
		System.out.println(numbers);
	}

}
