package lazcatluc.palindromes;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseConverterTest {

	@Test
	public void converts10To1010Base2() {
		assertEquals("1010", new BaseConverter().forNumber(10)
					.fromBase(10).toBase(2).convert());
	}
	
	@Test
	public void converts1010To10Base10() {
		assertEquals("10", new BaseConverter().forNumber(1010)
					.fromBase(2).toBase(10).convert());
	}
	
	@Test
	public void converts15ToFBase16() {
		assertEquals("f", new BaseConverter().forNumber(15)
					.fromBase(10).toBase(16).convert());
	}
	
	@Test
	public void convertsFTo15Base10() {
		assertEquals("15", new BaseConverter().forString("f")
					.fromBase(16).toBase(10).convert());
	}
}
