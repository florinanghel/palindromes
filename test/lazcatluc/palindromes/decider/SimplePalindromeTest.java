package lazcatluc.palindromes.decider;

import static org.junit.Assert.*;
import lazcatluc.palindromes.decider.SimplePalindrome;

import org.junit.Test;

public class SimplePalindromeTest {
	
	@Test
	public void emptyIsPalindrome() {
		assertTrue(new SimplePalindrome().isPalindrome());
	}
	
	@Test
	public void isPalindrome1000001() {
		assertTrue(new SimplePalindrome().representedBy(1000001).isPalindrome());
	}
	
	
	@Test
	public void isNotPalindrome1000002() {
		assertFalse(new SimplePalindrome().representedBy(1000002).isPalindrome());
	}
	
	@Test
	public void reverseOf1000002Is2000001() {
		assertEquals("2000001",new SimplePalindrome().representedBy(1000002).reverseRepresentation());
	}
}
