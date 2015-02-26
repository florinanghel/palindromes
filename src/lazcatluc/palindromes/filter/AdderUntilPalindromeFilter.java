package lazcatluc.palindromes.filter;

import lazcatluc.palindromes.Decider;
import lazcatluc.palindromes.Filter;
import lazcatluc.palindromes.decider.AdderUntilPalindrome;

public class AdderUntilPalindromeFilter implements Filter {
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
