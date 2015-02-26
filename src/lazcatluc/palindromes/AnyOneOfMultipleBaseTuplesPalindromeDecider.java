package lazcatluc.palindromes;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class AnyOneOfMultipleBaseTuplesPalindromeDecider {
	private Set<Set<Integer>> possibleBaseTuples = 
			Collections.singleton(Collections.singleton(10));
	
	private String originalRepresentation = "";
	
	public AnyOneOfMultipleBaseTuplesPalindromeDecider representedBy(String originalRepresentation) {
		this.originalRepresentation = originalRepresentation;
		return this;
	}
	
	public AnyOneOfMultipleBaseTuplesPalindromeDecider representedBy(Number originalRepresentation) {
		this.originalRepresentation = originalRepresentation.toString();
		return this;
	}
	
	public AnyOneOfMultipleBaseTuplesPalindromeDecider withPossibleBaseTuples(
			Set<Set<Integer>> possibleBaseTuples) {
		this.possibleBaseTuples = new LinkedHashSet<>(possibleBaseTuples);
		return this;
	}
	
	public boolean isPalindrome() {
		MultipleBasePalindromeDecider palindromeDecider = new MultipleBasePalindromeDecider()
			.representedBy(originalRepresentation);
		for (Set<Integer> baseTuple : possibleBaseTuples) {
			if (palindromeDecider.withBasesToTest(baseTuple).isPalindrome()) {
				return true;
			}
		}
		return false;
	}
}
