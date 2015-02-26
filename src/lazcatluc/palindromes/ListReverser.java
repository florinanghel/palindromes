package lazcatluc.palindromes;

import java.util.ArrayList;
import java.util.List;

public class ListReverser<T> {
	private final List<T> original;

	public ListReverser(List<T> original) {
		this.original = new ArrayList<>(original);
	}

	public List<T> reverse() {
		List<T> ret = new ArrayList<T>(original.size());
		for (int i = original.size() - 1; i >= 0; i--) {
			ret.add(original.get(i));
		}
		return ret;
	}
}
