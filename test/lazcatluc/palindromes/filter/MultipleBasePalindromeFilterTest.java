package lazcatluc.palindromes.filter;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import lazcatluc.palindromes.IntegerSequence;
import lazcatluc.palindromes.filter.MultipleBasePalindromeFilter;

import org.junit.Test;

public class MultipleBasePalindromeFilterTest {
	@Test
	public void allDigitsArePalindromes() {
		assertEquals(new IntegerSequence().build(),
				new MultipleBasePalindromeFilter().filterNumbers(new IntegerSequence().build()));
	}
	
	@Test
	public void allDigitsAnd10AreNotPalindromes() {
		List<Integer> expectedFiltered = new IntegerSequence().build();
		assertEquals(expectedFiltered,
				new MultipleBasePalindromeFilter().filterNumbers(
						new IntegerSequence().to(10).build()));
	}

	
	@Test
	public void allDigitsAnd10ArePalindromesInHigherBases() {
		List<Integer> digits = new IntegerSequence().to(10).build();
		assertEquals(digits,
				new MultipleBasePalindromeFilter()
					.withBasesToTest(new IntegerSequence().from(11).to(16).build())
					.filterNumbers(digits));
	}
	
	@Test
	public void allDigitsInBase2() {
		assertEquals(Arrays.asList(0,1,3,5,7,9),
				new MultipleBasePalindromeFilter()
					.withBasesToTest(2)
					.filterNumbers(new IntegerSequence().build()));
	}
	
	@Test
	public void allDigitsInBase2And4() {
		assertEquals(Arrays.asList(0,1,3,5),
				new MultipleBasePalindromeFilter()
					.withBasesToTest(2,4)
					.filterNumbers(new IntegerSequence().build()));
	}
}
