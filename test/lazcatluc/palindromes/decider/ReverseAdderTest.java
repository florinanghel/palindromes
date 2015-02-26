package lazcatluc.palindromes.decider;

import static org.junit.Assert.*;
import lazcatluc.palindromes.decider.ReverseAdder;

import org.junit.Test;

public class ReverseAdderTest {
	
	@Test
	public void addReverseOf1Is2() {
		assertEquals("2", new ReverseAdder(1).addReverse().toString());
	}
	
	@Test
	public void addReverseOf102Is303() {
		assertEquals("303", new ReverseAdder(102).addReverse().toString());
	}
	
	@Test
	public void addReverseOf708Is1515() {
		assertEquals("1515", new ReverseAdder(708).addReverse().toString());
	}
}
