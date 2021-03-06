package lazcatluc.palindromes.decider;

import java.math.BigInteger;

import lazcatluc.palindromes.Decider;

public class AdderUntilPalindrome implements Decider {
	private final ThreadLocal<BigInteger> number = ThreadLocal.withInitial(() -> BigInteger.ZERO);
	private int radix = 10;
	private ThreadLocal<Integer> stepsUntilConvert = ThreadLocal.withInitial(() -> 0);
	private int maxAdd = Integer.MAX_VALUE;
	
	@Override
	public AdderUntilPalindrome representedBy(String originalRepresentation) {
		this.number.set(new BigInteger(originalRepresentation, radix));
		return this;
	}
	
	@Override
	public AdderUntilPalindrome representedBy(Number originalRepresentation) {
		this.number.set(BigInteger.valueOf(originalRepresentation.longValue()));
		return this;
	} 
	
	public AdderUntilPalindrome addingAtMost(int maxAdd) {
		this.maxAdd = maxAdd;
		return this;
	}
	
	@Override
	public boolean isPalindrome() {
		ReverseAdder adder = new ReverseAdder(number.get(), radix);
		int count = maxAdd;
		while (count >= 0) {
			count--;
			if (isPalindrome(adder)) {
				stepsUntilConvert.set(maxAdd - count);
				return true;
			}
			adder = adder.addReverse();
		}
		return false;
	}

	private boolean isPalindrome(ReverseAdder adder) {
		return new SimplePalindrome().representedBy(adder.toString()).isPalindrome();
	}
	
	public int getStepsUntilConvert() {
		return stepsUntilConvert.get();
	}
		
}
