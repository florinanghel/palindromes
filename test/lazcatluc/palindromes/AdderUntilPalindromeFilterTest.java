package lazcatluc.palindromes;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AdderUntilPalindromeFilterTest {
	@Test
	public void allDigitsArePalindromes() {
		assertEquals(base10digits(), new AdderUntilPalindromeFilter()
				.addingAtMost(0).filterNumbers(base10digits()));
	}

	@Test
	public void allDigitsAnd10AreNotPalindromes() {
		List<Integer> expectedFiltered = base10digits();
		assertEquals(
				expectedFiltered,
				new AdderUntilPalindromeFilter().addingAtMost(0).filterNumbers(
						Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
	}

	@Test
	public void allNumbersAtMost100ThatDontBecomePalindromesIn10Generations() {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			numbers.add(i);
		}
		
		numbers.removeAll(
				new AdderUntilPalindromeFilter().addingAtMost(10)
					.filterNumbers(numbers));
					
		assertEquals(Arrays.asList(89,98), numbers);
	}

	private static List<Integer> base10digits() {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	}
}
