package lazcatluc.palindromes;

import java.util.ArrayList;
import java.util.List;

public class PalindromeDecider {

	private final List<Character> original = new ArrayList<>();
	
	public PalindromeDecider(String possiblePalindrome) {
		char[] palindromeChars = possiblePalindrome.toCharArray();
		for (char c : palindromeChars) {
			original.add(c);
		}
	}
	
	public PalindromeDecider(Number possiblePalindrome) {
		this(possiblePalindrome.toString());
	}
	
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
