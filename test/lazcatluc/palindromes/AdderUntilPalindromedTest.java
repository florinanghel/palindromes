package lazcatluc.palindromes;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdderUntilPalindromedTest {
	@Test
	public void isPalindrome1000001() {
		assertTrue(new AdderUntilPalindromed(1000001)
			.addingAtMost(0).becomesPalindrome());
	}
	
	
	@Test
	public void isNotPalindrome1000002() {
		assertFalse(new AdderUntilPalindromed(1000002)
			.addingAtMost(0).becomesPalindrome());
	}
	
	@Test
	public void bocomesPalindrome1000002FirstTime() {
		assertTrue(new AdderUntilPalindromed(1000002)
			.addingAtMost(1).becomesPalindrome());
	}
	
	@Test
	public void bocomesPalindrome1000002AtLeastFirstTime() {
		assertTrue(new AdderUntilPalindromed(1000002)
			.becomesPalindrome());
	}
	
	@Test
	public void doesntBocomePalindrome708FirstTime() {
		assertFalse(new AdderUntilPalindromed(708)
			.addingAtMost(1).becomesPalindrome());
	}
	
	@Test
	public void becomesPalindrome708TheSecondTime() {
		assertTrue(new AdderUntilPalindromed(708)
			.addingAtMost(2).becomesPalindrome());
	}
}
