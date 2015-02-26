package lazcatluc.palindromes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MultipleBasePalindromeFilterTest {
	@Test
	public void allDigitsArePalindromes() {
		assertEquals(base10digits(),
				new MultipleBasePalindromeFilter().filterNumbers(base10digits()));
	}
	
	@Test
	public void allDigitsAnd10AreNotPalindromes() {
		List<Integer> expectedFiltered = base10digits();
		assertEquals(expectedFiltered,
				new MultipleBasePalindromeFilter().filterNumbers(
						Arrays.asList(0,1,2,3,4,5,6,7,8,9,10)));
	}

	
	@Test
	public void allDigitsAnd10ArePalindromesInHigherBases() {
		List<Integer> digits = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
		assertEquals(digits,
				new MultipleBasePalindromeFilter()
					.withBasesToTest(11,12,13,14,15,16)
					.filterNumbers(digits));
	}
	
	@Test
	public void allDigitsInBase2() {
		assertEquals(Arrays.asList(0,1,3,5,7,9),
				new MultipleBasePalindromeFilter()
					.withBasesToTest(2)
					.filterNumbers(base10digits()));
	}
	
	@Test
	public void allDigitsInBase2And4() {
		assertEquals(Arrays.asList(0,1,3,5),
				new MultipleBasePalindromeFilter()
					.withBasesToTest(2,4)
					.filterNumbers(base10digits()));
	}
	
	private static List<Integer> base10digits() {
		return Arrays.asList(0,1,2,3,4,5,6,7,8,9);
	}
}
