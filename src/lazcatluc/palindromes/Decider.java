package lazcatluc.palindromes;


public interface Decider {
	Decider representedBy(String originalRepresentation);
	Decider representedBy(Number originalRepresentation);
	
	boolean isPalindrome();	
}
