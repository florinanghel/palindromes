package lazcatluc.palindromes;

import java.util.ArrayList;
import java.util.List;

public class IntegerSequence {
	private int from = 0;
	private int to = 9;
	private int step = 1;
	
	public IntegerSequence from(int from) {
		this.from = from;
		return this;
	}
	
	public IntegerSequence to(int to) {
		this.to = to;
		return this;
	}
	
	public IntegerSequence step(int step) {
		this.step = step;
		return this;
	}
	
	public List<Integer> build() {
		List<Integer> ret = new ArrayList<>();
		for (int i = from; i <= to; i += step) {
			ret.add(i);
		}
		return ret;
	}
}
