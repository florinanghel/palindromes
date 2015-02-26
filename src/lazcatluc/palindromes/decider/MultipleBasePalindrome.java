package lazcatluc.palindromes.decider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import lazcatluc.palindromes.BaseConverter;
import lazcatluc.palindromes.Decider;

public class MultipleBasePalindrome implements Decider {
	private String originalRepresentation = "";
	private int originalBase = 10;
	private List<Integer> basesToTest = Arrays.asList(new Integer[]{10});
	
	@Override
	public MultipleBasePalindrome representedBy(String originalRepresentation) {
		this.originalRepresentation = originalRepresentation;
		return this;
	}
	
	@Override
	public MultipleBasePalindrome representedBy(Number originalRepresentation) {
		this.originalRepresentation = originalRepresentation.toString();
		return this;
	}
	
	public MultipleBasePalindrome inBase(int originalBase) {
		this.originalBase = originalBase;
		return this;
	}
	
	public MultipleBasePalindrome withBasesToTest(Integer... basesToTest) {
		this.basesToTest = Arrays.asList(basesToTest);
		return this;
	}
	
	public MultipleBasePalindrome withBasesToTest(Collection<Integer> basesToTest) {
		this.basesToTest = new ArrayList<Integer>(basesToTest);
		return this;
	}
	
	@Override
	public boolean isPalindrome() {
		if (originalRepresentation.isEmpty()) {
			return true;
		}
		BaseConverter converter = new BaseConverter()
			.forString(originalRepresentation)
			.fromBase(originalBase);
		for (Integer baseToTest : basesToTest) {
			String baseRepresentation = converter.toBase(baseToTest).convert();
			boolean isPalindromeInBase = new SimplePalindrome().representedBy(baseRepresentation).isPalindrome();
			if (!isPalindromeInBase) {
				return false;
			}
		}
		return true;
	}
}
