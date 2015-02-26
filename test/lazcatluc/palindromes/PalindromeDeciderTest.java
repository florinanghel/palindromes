package lazcatluc.palindromes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PalindromeDeciderTest {
	
	@Test
	public void emptyIsPalindrome() {
		assertTrue(new PalindromeDecider("").isPalindrome());
	}
	
	@Test
	public void isPalindrome1000001() {
		assertTrue(new PalindromeDecider(1000001).isPalindrome());
	}
	
	
	@Test
	public void isNotPalindrome1000002() {
		assertFalse(new PalindromeDecider(1000002).isPalindrome());
	}
}
