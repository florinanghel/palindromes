package lazcatluc.palindromes;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseConverterTest {

	@Test
	public void converts10To1010Base2() {
		assertEquals("1010", new BaseConverter(10, 10, 2).convert());
	}
	
	@Test
	public void converts1010To10Base10() {
		assertEquals("10", new BaseConverter(1010, 2, 10).convert());
	}
}
