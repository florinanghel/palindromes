package lazcatluc.palindromes;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TupleGenerator<T extends Number> {
	private final Set<T> originalSet;
	private final int arity;
	
	public TupleGenerator(Collection<T> originalNumbers, int arity) {
		this.originalSet = new TreeSet<>(originalNumbers);
		this.arity = arity;
	}
	
	public Set<Set<T>> tuples() {
		if (arity > originalSet.size() || originalSet.isEmpty() || arity == 0) {
			return Collections.singleton(new TreeSet<>());
		}
		Set<T> myOriginalSet = new TreeSet<>(originalSet);
		if (arity == originalSet.size()) {
			return Collections.singleton(myOriginalSet);
		}
		T first = myOriginalSet.iterator().next();
		myOriginalSet.remove(first);
		
		Set<Set<T>> ret = new LinkedHashSet<>();
		Set<Set<T>> others = new TupleGenerator<T>(myOriginalSet, arity).tuples();
		Set<Set<T>> othersPlusFirst = new TupleGenerator<T>(myOriginalSet, arity - 1)
				.tuples();
		othersPlusFirst.stream().forEach(set -> set.add(first));
		ret.addAll(othersPlusFirst);
		ret.addAll(others);
		return ret;
	}
}
