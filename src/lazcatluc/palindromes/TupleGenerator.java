package lazcatluc.palindromes;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TupleGenerator {
	private final Set<Number> originalSet;
	private final int arity;
	
	public TupleGenerator(Collection<? extends Number> originalNumbers, int arity) {
		this.originalSet = new TreeSet<>(originalNumbers);
		this.arity = arity;
	}
	
	public Set<Set<Number>> tuples() {
		if (arity > originalSet.size() || originalSet.isEmpty() || arity == 0) {
			return Collections.singleton(new TreeSet<>());
		}
		Set<Number> myOriginalSet = new TreeSet<>(originalSet);
		if (arity == originalSet.size()) {
			return Collections.singleton(myOriginalSet);
		}
		Number first = myOriginalSet.iterator().next();
		myOriginalSet.remove(first);
		
		Set<Set<Number>> ret = new LinkedHashSet<>();
		Set<Set<Number>> others = new TupleGenerator(myOriginalSet, arity).tuples();
		Set<Set<Number>> othersPlusFirst = new TupleGenerator(myOriginalSet, arity - 1)
				.tuples();
		othersPlusFirst.stream().forEach(set -> set.add(first));
		ret.addAll(othersPlusFirst);
		ret.addAll(others);
		return ret;
	}
}
