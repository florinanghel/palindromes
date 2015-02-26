package lazcatluc.palindromes;

import java.math.BigInteger;

public class AdderUntilPalindromed {
	private final BigInteger number;
	private final int radix;
	private int maxAdd = Integer.MAX_VALUE;
	
	public AdderUntilPalindromed(long number) {
		this(BigInteger.valueOf(number));
	}
	
	public AdderUntilPalindromed(BigInteger number) {
		this(number, 10);
	}
	
	public AdderUntilPalindromed(BigInteger number, int radix) {
		this.number = number;
		this.radix = radix;
	}
	
	public AdderUntilPalindromed(String number, int radix) {
		this.number = new BigInteger(number, radix);
		this.radix = radix;
	}
	
	public AdderUntilPalindromed addingAtMost(int maxAdd) {
		this.maxAdd = maxAdd;
		return this;
	}
	
	public boolean becomesPalindrome() {
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
