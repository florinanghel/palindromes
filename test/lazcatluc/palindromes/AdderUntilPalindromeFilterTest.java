package lazcatluc.palindromes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AdderUntilPalindromeFilterTest {
	@Test
	public void allDigitsArePalindromes() {
		assertEquals(new IntegerSequence().build(), new AdderUntilPalindromeFilter()
				.addingAtMost(0).filterNumbers(new IntegerSequence().build()));
	}

	@Test
	public void allDigitsAnd10AreNotPalindromes() {
		assertEquals(
				new IntegerSequence().build(),
				new AdderUntilPalindromeFilter().addingAtMost(0).filterNumbers(
						new IntegerSequence().to(10).build()));
	}

	@Test
	public void allNumbersAtMost100ThatDontBecomePalindromesIn10Generations() {
		List<Integer> numbers = new IntegerSequence().to(99).build();
		
		numbers.removeAll(
				new AdderUntilPalindromeFilter().addingAtMost(10)
					.filterNumbers(numbers));
					
		assertEquals(Arrays.asList(89,98), numbers);
	}

}
