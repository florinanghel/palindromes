package lazcatluc.palindromes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MultipleBasePalindromeDecider {
	private String originalRepresentation = "";
	private int originalBase = 10;
	private List<Integer> basesToTest = Arrays.asList(new Integer[]{10});
	
	public MultipleBasePalindromeDecider representedBy(String originalRepresentation) {
		this.originalRepresentation = originalRepresentation;
		return this;
	}
	
	public MultipleBasePalindromeDecider representedBy(Number originalRepresentation) {
		this.originalRepresentation = originalRepresentation.toString();
		return this;
	}
	
	public MultipleBasePalindromeDecider inBase(int originalBase) {
		this.originalBase = originalBase;
		return this;
	}
	
	public MultipleBasePalindromeDecider withBasesToTest(Integer... basesToTest) {
		this.basesToTest = Arrays.asList(basesToTest);
		return this;
	}
	
	public MultipleBasePalindromeDecider withBasesToTest(Collection<Integer> basesToTest) {
		this.basesToTest = new ArrayList<Integer>(basesToTest);
		return this;
	}
	
	public boolean isPalindrome() {
		if (originalRepresentation.isEmpty()) {
			return true;
		}
		BaseConverter converter = new BaseConverter()
			.forString(originalRepresentation)
			.fromBase(originalBase);
		for (Integer baseToTest : basesToTest) {
			String baseRepresentation = converter.toBase(baseToTest).convert();
			boolean isPalindromeInBase = new PalindromeDecider(baseRepresentation).isPalindrome();
			if (!isPalindromeInBase) {
				return false;
			}
		}
		return true;
	}
}
