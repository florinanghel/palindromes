package lazcatluc.palindromes;

import java.util.Collection;
import java.util.stream.Collectors;

import lazcatluc.palindromes.decider.AdderUntilPalindrome;

public class AdderUntilPalindromeFilter {
	private Integer maxAdd = Integer.MAX_VALUE;
	
	public AdderUntilPalindromeFilter addingAtMost(Integer maxAdd) {
		this.maxAdd = maxAdd;
		return this;
	}
	
	public <T extends Number> Collection<T> filterNumbers(Collection<T> numbers) {
		AdderUntilPalindrome palindromeDecider = 
				new AdderUntilPalindrome().addingAtMost(maxAdd);
		return 
			numbers.stream().filter(currentNumber -> 
			palindromeDecider.representedBy(currentNumber).isPalindrome())
				.collect(Collectors.toList());
		
	}
}
