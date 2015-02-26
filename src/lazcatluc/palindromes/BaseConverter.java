package lazcatluc.palindromes;

import java.math.BigInteger;

public class BaseConverter {

	private String numberAsString = "0";
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
		this.numberAsString = numberToConvert.toString();
		return this;
	}
	
	public String convert() {
		return new BigInteger(numberAsString, fromBase)
			.toString(toBase);

	}

	public BaseConverter forString(String string) {
		this.numberAsString = string;
		return this;
	}
}
