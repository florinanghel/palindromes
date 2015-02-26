package lazcatluc.palindromes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TupleGeneratorTest {
	
	@Test
	public void tuplesOfArrity1AreTheElements() {
		List<Integer> original = Arrays.asList(1,2,3);
		
		Set<Set<Number>> expected = new HashSet<>();
		expected.add(Collections.singleton(1));
		expected.add(Collections.singleton(2));
		expected.add(Collections.singleton(3));
		
		assertEquals(expected, new TupleGenerator<Integer>(original, 1).tuples());
	}
	
	@Test
	public void tuplesOfArrity2AreThePairs() {
		List<Integer> original = Arrays.asList(1,2,3);
		
		Set<Set<Number>> expected = new HashSet<>();
		expected.add(new HashSet<Number>(Arrays.asList(1,2)));
		expected.add(new HashSet<Number>(Arrays.asList(1,3)));
		expected.add(new HashSet<Number>(Arrays.asList(2,3)));
		
		assertEquals(expected, new TupleGenerator<Integer>(original, 2).tuples());
	}
}
