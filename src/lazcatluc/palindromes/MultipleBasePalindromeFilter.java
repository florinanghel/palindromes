package lazcatluc.palindromes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MultipleBasePalindromeFilter {
	private List<Integer> basesToTest = Arrays.asList(new Integer[]{10});
	
	public MultipleBasePalindromeFilter withBasesToTest(Integer... basesToTest) {
		this.basesToTest = Arrays.asList(basesToTest);
		return this;
	}
	
	public MultipleBasePalindromeFilter withBasesToTest(Collection<Integer> basesToTest) {
		this.basesToTest = new ArrayList<Integer>(basesToTest);
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
