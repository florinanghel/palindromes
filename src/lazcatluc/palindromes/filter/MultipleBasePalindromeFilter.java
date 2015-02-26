package lazcatluc.palindromes.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import lazcatluc.palindromes.Decider;
import lazcatluc.palindromes.Filter;
import lazcatluc.palindromes.decider.MultipleBasePalindrome;

public class MultipleBasePalindromeFilter implements Filter {
	private List<Integer> basesToTest = Arrays.asList(new Integer[]{10});
	
	public MultipleBasePalindromeFilter withBasesToTest(Integer... basesToTest) {
		this.basesToTest = Arrays.asList(basesToTest);
		return this;
	}
	
	public MultipleBasePalindromeFilter withBasesToTest(Collection<Integer> basesToTest) {
		this.basesToTest = new ArrayList<Integer>(basesToTest);
		return this;
	}

	@Override
	public Decider newDecider() {
		return new MultipleBasePalindrome().withBasesToTest(basesToTest);
	}
}
