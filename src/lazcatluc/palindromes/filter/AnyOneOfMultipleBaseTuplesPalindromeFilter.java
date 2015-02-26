package lazcatluc.palindromes.filter;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import lazcatluc.palindromes.Decider;
import lazcatluc.palindromes.Filter;
import lazcatluc.palindromes.decider.AnyOneOfMultipleBaseTuplesPalindrome;

public class AnyOneOfMultipleBaseTuplesPalindromeFilter implements Filter {
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
