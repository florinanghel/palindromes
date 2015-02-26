package lazcatluc.palindromes.filter;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import lazcatluc.palindromes.Decider;
import lazcatluc.palindromes.FilterPalindromes;
import lazcatluc.palindromes.decider.AnyOneOfMultipleBaseTuplesPalindrome;

public class AnyOneOfMultipleBaseTuplesPalindromeFilter implements FilterPalindromes {
	private Set<Set<Integer>> possibleBaseTuples = Collections.singleton(
			Collections.singleton(10));
	
	public AnyOneOfMultipleBaseTuplesPalindromeFilter withPossibleBaseTuples(
			Set<Set<Integer>> possibleBaseTuples) {
		this.possibleBaseTuples = new LinkedHashSet<>(possibleBaseTuples);
		return this;
	}

	@Override
	public Decider newDecider() {
		return new AnyOneOfMultipleBaseTuplesPalindrome()
				.withPossibleBaseTuples(possibleBaseTuples);
	}
}
