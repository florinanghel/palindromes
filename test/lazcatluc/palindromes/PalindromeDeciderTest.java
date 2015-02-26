package lazcatluc.palindromes;

import static org.junit.Assert.*;

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
	
	@Test
	public void reverseOf1000002Is2000001() {
		assertEquals("2000001",new PalindromeDecider(1000002).reverseRepresentation());
	}
}
