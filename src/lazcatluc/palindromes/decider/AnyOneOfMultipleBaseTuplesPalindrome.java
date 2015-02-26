package lazcatluc.palindromes.decider;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import lazcatluc.palindromes.Decider;

public class AnyOneOfMultipleBaseTuplesPalindrome implements Decider {
	private Set<Set<Integer>> possibleBaseTuples = 
			Collections.singleton(Collections.singleton(10));
	
	private String originalRepresentation = "";
	
	@Override
	public AnyOneOfMultipleBaseTuplesPalindrome representedBy(String originalRepresentation) {
		this.originalRepresentation = originalRepresentation;
		return this;
	}
	
	@Override
	public AnyOneOfMultipleBaseTuplesPalindrome representedBy(Number originalRepresentation) {
		this.originalRepresentation = originalRepresentation.toString();
		return this;
	}
	
	public AnyOneOfMultipleBaseTuplesPalindrome withPossibleBaseTuples(
			Set<Set<Integer>> possibleBaseTuples) {
		this.possibleBaseTuples = new LinkedHashSet<>(possibleBaseTuples);
		return this;
	}
	
	@Override
	public boolean isPalindrome() {
		MultipleBasePalindrome palindromeDecider = new MultipleBasePalindrome()
			.representedBy(originalRepresentation);
		for (Set<Integer> baseTuple : possibleBaseTuples) {
			if (palindromeDecider.withBasesToTest(baseTuple).isPalindrome()) {
				return true;
			}
		}
		return false;
	}
}
