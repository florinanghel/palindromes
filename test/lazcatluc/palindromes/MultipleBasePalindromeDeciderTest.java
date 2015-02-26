package lazcatluc.palindromes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MultipleBasePalindromeDeciderTest {
	@Test
	public void emptyIsPalindrome() {
		assertTrue(new MultipleBasePalindromeDecider().isPalindrome());
	}
	
	@Test
	public void isPalindrome1000001() {
		assertTrue(new MultipleBasePalindromeDecider()
				.representedBy(1000001).isPalindrome());
	}
	
	
	@Test
	public void isNotPalindrome1000002() {
		assertFalse(new MultipleBasePalindromeDecider()
			.representedBy(1000002).isPalindrome());
	}
	
	
	@Test
	public void isPalindrome3InBase10And2() {
		assertTrue(new MultipleBasePalindromeDecider()
			.representedBy(3).withBasesToTest(2, 10).isPalindrome());
	}
	
	@Test
	public void isNotPalindrome3InBase10And2And3() {
		assertFalse(new MultipleBasePalindromeDecider()
			.representedBy(3).withBasesToTest(2, 3, 10).isPalindrome());
	}
}
