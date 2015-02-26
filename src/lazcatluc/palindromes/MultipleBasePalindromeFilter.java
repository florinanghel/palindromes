package lazcatluc.palindromes;

import java.util.Collection;
import java.util.stream.Collectors;

public class MultipleBasePalindromeFilter {
	private Integer[] basesToTest = new Integer[]{10};
	
	public MultipleBasePalindromeFilter withBasesToTest(Integer... basesToTest) {
		this.basesToTest = basesToTest.clone();
		return this;
	}
	
	public <T extends Number> Collection<T> filterNumbers(Collection<T> numbers) {
		MultipleBasePalindromeDecider palindromeDecider = 
				new MultipleBasePalindromeDecider().withBasesToTest(basesToTest);
		return 
			numbers.stream().filter(currentNumber -> 
			palindromeDecider.representedBy(currentNumber).isPalindrome())
				.collect(Collectors.toList());
		
	}
}
