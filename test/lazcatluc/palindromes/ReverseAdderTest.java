package lazcatluc.palindromes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseAdderTest {
	
	@Test
	public void addReverseOf1Is2() {
		assertEquals("2", new ReverseAdder(1).addReverse().toString());
	}
}
