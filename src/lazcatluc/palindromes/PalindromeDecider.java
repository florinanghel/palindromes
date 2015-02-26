package lazcatluc.palindromes;

import java.util.ArrayList;
import java.util.List;

public class PalindromeDecider {

	private final char[] palindromeChars;
	
	public PalindromeDecider(String possiblePalindrome) {
		palindromeChars = possiblePalindrome.toCharArray();
	}
	
	public PalindromeDecider(Number possiblePalindrome) {
		this(possiblePalindrome.toString());
	}
	
	public boolean isPalindrome() {
		List<Character> original = new ArrayList<>();
		for (char c : palindromeChars) {
			original.add(c);
		}
		
		List<Character> reversed = new ListReverser<Character>(original).reverse();
		
		return original.equals(reversed);
	}
}
