package lazcatluc.palindromes.decider;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import lazcatluc.palindromes.decider.AdderUntilPalindrome;

import org.junit.Test;

public class AdderUntilPalindromedTest {
	@Test
	public void isPalindrome1000001() {
		assertTrue(new AdderUntilPalindrome().representedBy(1000001)
			.addingAtMost(0).isPalindrome());
	}
	
	
	@Test
	public void isNotPalindrome1000002() {
		assertFalse(new AdderUntilPalindrome().representedBy(1000002)
			.addingAtMost(0).isPalindrome());
	}
	
	@Test
	public void bocomesPalindrome1000002FirstTime() {
		assertTrue(new AdderUntilPalindrome().representedBy(1000002)
			.addingAtMost(1).isPalindrome());
	}
	
	@Test
	public void bocomesPalindrome1000002AtLeastFirstTime() {
		assertTrue(new AdderUntilPalindrome().representedBy(1000002)
			.isPalindrome());
	}
	
	@Test
	public void doesntBocomePalindrome708FirstTime() {
		assertFalse(new AdderUntilPalindrome().representedBy(708)
			.addingAtMost(1).isPalindrome());
	}
	
	@Test
	public void becomesPalindrome708TheSecondTime() {
		assertTrue(new AdderUntilPalindrome().representedBy(708)
			.addingAtMost(2).isPalindrome());
	}
}
