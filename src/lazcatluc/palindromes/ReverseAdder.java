package lazcatluc.palindromes;

import java.math.BigInteger;

import lazcatluc.palindromes.decider.SimplePalindrome;

public class ReverseAdder {
	private final BigInteger number;
	private final int radix;
	
	public ReverseAdder(long number) {
		this(BigInteger.valueOf(number));
	}
	
	public ReverseAdder(BigInteger number) {
		this(number, 10);
	}
	
	public ReverseAdder(BigInteger number, int radix) {
		this.number = number;
		this.radix = radix;
	}
	
	public ReverseAdder(String number, int radix) {
		this.number = new BigInteger(number, radix);
		this.radix = radix;
	}
	
	private BigInteger computeReversed() {
		return new BigInteger(new SimplePalindrome().representedBy(number).reverseRepresentation(),
				radix);
	}
	
	public ReverseAdder addReverse() {
		return new ReverseAdder(computeReversed().add(number), radix);
	}
	
	@Override	
	public String toString() {
		return number.toString();
	}
}
