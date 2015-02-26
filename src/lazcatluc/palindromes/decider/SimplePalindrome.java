package lazcatluc.palindromes.decider;

import java.util.ArrayList;
import java.util.List;

import lazcatluc.palindromes.Decider;
import lazcatluc.palindromes.ListReverser;

public class SimplePalindrome implements Decider {

	private List<Character> original = new ArrayList<>();
	
	@Override
	public SimplePalindrome representedBy(String possiblePalindrome) {
		char[] palindromeChars = possiblePalindrome.toCharArray();
		for (char c : palindromeChars) {
			original.add(c);
		}
		return this;
	}
	
	@Override
	public SimplePalindrome representedBy(Number possiblePalindrome) {
		return representedBy(possiblePalindrome.toString());
	}
	
	@Override
	public boolean isPalindrome() {
		return original.equals(reversed());
	}

	private List<Character> reversed() {
		return new ListReverser<Character>(original).reverse();
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
