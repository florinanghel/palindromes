package lazcatluc.palindromes;

import java.util.Collection;
import java.util.stream.Collectors;

public interface FilterPalindromes {
	default <T extends Number> Collection<T> keepOnlyPalindromes(Collection<T> numbers) {
		Decider decider = newDecider();

		return 
			numbers.stream().parallel().filter(currentNumber -> 
			decider.representedBy(currentNumber).isPalindrome())
				.collect(Collectors.toList());
		
	}

	Decider newDecider();
	
}
