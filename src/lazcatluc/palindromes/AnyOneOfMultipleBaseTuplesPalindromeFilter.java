package lazcatluc.palindromes;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lazcatluc.palindromes.decider.AnyOneOfMultipleBaseTuplesPalindrome;

public class AnyOneOfMultipleBaseTuplesPalindromeFilter {
	private Set<Set<Integer>> possibleBaseTuples = Collections.singleton(
			Collections.singleton(10));
	
	public AnyOneOfMultipleBaseTuplesPalindromeFilter withPossibleBaseTuples(
			Set<Set<Integer>> possibleBaseTuples) {
		this.possibleBaseTuples = new LinkedHashSet<>(possibleBaseTuples);
		return this;
	}
	
	public <T extends Number> Collection<T> filterNumbers(Collection<T> numbers) {
		AnyOneOfMultipleBaseTuplesPalindrome palindromeDecider = 
				new AnyOneOfMultipleBaseTuplesPalindrome()
					.withPossibleBaseTuples(possibleBaseTuples);
		return 
			numbers.stream().filter(currentNumber -> 
			palindromeDecider.representedBy(currentNumber).isPalindrome())
				.collect(Collectors.toList());
		
	}
}
