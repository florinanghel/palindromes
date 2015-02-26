package lazcatluc.palindromes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ListReverserTest {
	
	@Test
	public void revertsEmptyList() {
		assertEquals(Collections.emptyList(), new ListReverser<Object>(Collections.emptyList()).reverse());
	}
	
	@Test
	public void revertsListOfNumbers() {
		List<Integer> originalList = new IntegerSequence().from(1).to(5).build();
		List<Integer> expectedList = Arrays.asList(new Integer[]{5,4,3,2,1});
		
		assertEquals(expectedList, new ListReverser<Integer>(originalList).reverse());
	}
}
