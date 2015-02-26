package lazcatluc.palindromes.decider;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import lazcatluc.palindromes.decider.MultipleBasePalindrome;

import org.junit.Test;

public class MultipleBasePalindromeTest {
	@Test
	public void emptyIsPalindrome() {
		assertTrue(new MultipleBasePalindrome().isPalindrome());
	}
	
	@Test
	public void isPalindrome1000001() {
		assertTrue(new MultipleBasePalindrome()
				.representedBy(1000001).isPalindrome());
	}
	
	
	@Test
	public void isNotPalindrome1000002() {
		assertFalse(new MultipleBasePalindrome()
			.representedBy(1000002).isPalindrome());
	}
	
	
	@Test
	public void isPalindrome3InBase10And2() {
		assertTrue(new MultipleBasePalindrome()
			.representedBy(3).withBasesToTest(2, 10).isPalindrome());
	}
	
	@Test
	public void isNotPalindrome3InBase10And2And3() {
		assertFalse(new MultipleBasePalindrome()
			.representedBy(3).withBasesToTest(2, 3, 10).isPalindrome());
	}
}
