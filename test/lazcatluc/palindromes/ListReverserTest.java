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
		List<Integer> originalList = Arrays.asList(new Integer[]{1,2,3,4,5});
		List<Integer> expectedList = Arrays.asList(new Integer[]{5,4,3,2,1});
		
		assertEquals(expectedList, new ListReverser<Integer>(originalList).reverse());
	}
}
