package lazcatluc.palindromes;

import java.math.BigInteger;

public class AdderUntilPalindromeDecider {
	private BigInteger number = BigInteger.ZERO;
	private int radix = 10;
	private int maxAdd = Integer.MAX_VALUE;
	
	public AdderUntilPalindromeDecider representedBy(String originalRepresentation) {
		this.number = new BigInteger(originalRepresentation, radix);
		return this;
	}
	
	public AdderUntilPalindromeDecider representedBy(Number originalRepresentation) {
		this.number = BigInteger.valueOf(originalRepresentation.longValue());
		return this;
	} 
	
	public AdderUntilPalindromeDecider addingAtMost(int maxAdd) {
		this.maxAdd = maxAdd;
		return this;
	}
	
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
		return new PalindromeDecider(adder.toString()).isPalindrome();
	}
}
