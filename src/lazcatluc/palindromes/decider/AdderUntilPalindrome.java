package lazcatluc.palindromes.decider;

import java.math.BigInteger;

import lazcatluc.palindromes.Decider;

public class AdderUntilPalindrome implements Decider {
	private BigInteger number = BigInteger.ZERO;
	private int radix = 10;
	private int maxAdd = Integer.MAX_VALUE;
	
	@Override
	public AdderUntilPalindrome representedBy(String originalRepresentation) {
		this.number = new BigInteger(originalRepresentation, radix);
		return this;
	}
	
	@Override
	public AdderUntilPalindrome representedBy(Number originalRepresentation) {
		this.number = BigInteger.valueOf(originalRepresentation.longValue());
		return this;
	} 
	
	public AdderUntilPalindrome addingAtMost(int maxAdd) {
		this.maxAdd = maxAdd;
		return this;
	}
	
	@Override
	public boolean isPalindrome() {
		ReverseAdder adder = new ReverseAdder(number, radix);
		int count = maxAdd;
		while (count >= 0) {
			count--;
			if (isPalindrome(adder)) {
				return true;
			}
			adder = adder.addReverse();
		}
		return false;
	}

	private boolean isPalindrome(ReverseAdder adder) {
		return new SimplePalindrome().representedBy(adder.toString()).isPalindrome();
	}
}
