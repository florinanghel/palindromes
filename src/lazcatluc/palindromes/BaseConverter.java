package lazcatluc.palindromes;

import java.math.BigInteger;

public class BaseConverter {
	private final Number numberToConvert;
	private final int fromBase;
	private final int toBase;
	
	public BaseConverter(Number numberToConvert, int fromBase, int toBase) {
		super();
		this.numberToConvert = numberToConvert;
		this.fromBase = fromBase;
		this.toBase = toBase;
	}
	
	public String convert() {
		return new BigInteger(numberToConvert.toString(), fromBase)
			.toString(toBase);
	}
}
