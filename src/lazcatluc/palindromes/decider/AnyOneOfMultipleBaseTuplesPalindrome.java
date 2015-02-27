package lazcatluc.palindromes.decider;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import lazcatluc.palindromes.Decider;

public class AnyOneOfMultipleBaseTuplesPalindrome implements Decider {
	private Set<Set<Integer>> possibleBaseTuples = 
			Collections.singleton(Collections.singleton(10));
	
	private ThreadLocal<String> originalRepresentation = ThreadLocal.withInitial(() -> "");
	
	@Override
	public AnyOneOfMultipleBaseTuplesPalindrome representedBy(String originalRepresentation) {
		this.originalRepresentation.set(originalRepresentation);
		return this;
	}
	
	@Override
	public AnyOneOfMultipleBaseTuplesPalindrome representedBy(Number originalRepresentation) {
		this.originalRepresentation.set(originalRepresentation.toString());
		return this;
	}
	
	public AnyOneOfMultipleBaseTuplesPalindrome withPossibleBaseTuples(
			Set<Set<Integer>> possibleBaseTuples) {
		this.possibleBaseTuples = new LinkedHashSet<>(possibleBaseTuples);
		return this;
	}
	
	@Override
	public boolean isPalindrome() {		
		MultipleBasePalindrome palindromeDecider = new MultipleBasePalindrome().representedBy(originalRepresentation.get());
		Optional<Set<Integer>> possibleBaseTuple = possibleBaseTuples.stream()
			.filter(baseTuple -> palindromeDecider.withBasesToTest(baseTuple).isPalindrome()).findAny();
		
		return possibleBaseTuple.isPresent();
	}
	
}
