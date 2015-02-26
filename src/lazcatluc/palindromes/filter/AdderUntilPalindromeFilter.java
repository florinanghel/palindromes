package lazcatluc.palindromes.filter;

import lazcatluc.palindromes.Decider;
import lazcatluc.palindromes.FilterPalindromes;
import lazcatluc.palindromes.decider.AdderUntilPalindrome;

public class AdderUntilPalindromeFilter implements FilterPalindromes {
	private Integer maxAdd = Integer.MAX_VALUE;
	
	public AdderUntilPalindromeFilter addingAtMost(Integer maxAdd) {
		this.maxAdd = maxAdd;
		return this;
	}

	@Override
	public Decider newDecider() {
		return new AdderUntilPalindrome().addingAtMost(maxAdd);
	}
}
