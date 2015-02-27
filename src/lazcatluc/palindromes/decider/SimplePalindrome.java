package lazcatluc.palindromes.decider;

import java.util.ArrayList;
import java.util.List;

import lazcatluc.palindromes.Decider;

public class SimplePalindrome implements Decider {

	private final ThreadLocal<List<Character>> original = ThreadLocal.withInitial(() -> new ArrayList<>());
	
	@Override
	public SimplePalindrome representedBy(String possiblePalindrome) {
		char[] palindromeChars = possiblePalindrome.toCharArray();
		for (char c : palindromeChars) {
			original.get().add(c);
		}
		return this;
	}
	
	@Override
	public SimplePalindrome representedBy(Number possiblePalindrome) {
		return representedBy(possiblePalindrome.toString());
	}
	
	@Override
	public boolean isPalindrome() {
		return original.get().equals(reversed());
	}

	private List<Character> reversed() {
		return new ListReverser<Character>(original.get()).reverse();
	}
	
	public String reverseRepresentation() {
		List<Character> reversed = reversed(); 
		char[] palindromeChars = new char[reversed.size()];
		int i = 0;
		for (Character c : reversed) {
			palindromeChars[i++] = c;
		}
		return new String(palindromeChars);
	}
}
