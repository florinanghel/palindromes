package lazcatluc.palindromes.decider;

import java.util.List;
import java.util.stream.Collectors;

import lazcatluc.palindromes.IntegerSequence;

import org.junit.Test;

public class AdderUntilPalindromedITest {

	@Test
	public void numbersWithBigStepsUntilConvertBelow100000() {
		List<Integer> numbers = new IntegerSequence().to(100000).build();
		final int minStepsUntilConvert = 100;
		AdderUntilPalindrome adder = new AdderUntilPalindrome().addingAtMost(1000);
		
		numbers = numbers.stream().parallel().filter(number -> 
			adder.representedBy(number).isPalindrome() && 
			adder.getStepsUntilConvert() > minStepsUntilConvert)
		.collect(Collectors.toList());
		
		System.out.println(numbers);
	}
}
