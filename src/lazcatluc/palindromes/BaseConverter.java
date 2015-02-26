package lazcatluc.palindromes;

import java.math.BigInteger;

public class BaseConverter {

	private Number numberToConvert = 0;
	private int fromBase = 10;
	private int toBase = 2;
	
	public BaseConverter fromBase(int fromBase) {
		this.fromBase = fromBase;
		return this;
	}
	
	public BaseConverter toBase(int toBase) {
		this.toBase = toBase;
		return this;
	}
	
	public BaseConverter forNumber(Number numberToConvert) {
		this.numberToConvert = numberToConvert;
		return this;
	}
	
	public String convert() {
		return new BigInteger(numberToConvert.toString(), fromBase)
			.toString(toBase);

	}
}
