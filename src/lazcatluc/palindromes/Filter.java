package lazcatluc.palindromes;

import java.util.Collection;
import java.util.stream.Collectors;

public interface Filter {
	default <T extends Number> Collection<T> filterNumbers(Collection<T> numbers) {
		Decider decider = newDecider();
		return 
			numbers.stream().filter(currentNumber -> 
			decider.representedBy(currentNumber).isPalindrome())
				.collect(Collectors.toList());
		
	}

	Decider newDecider();
}
