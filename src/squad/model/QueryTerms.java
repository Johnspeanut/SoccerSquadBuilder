package squad.model;

import java.util.ArrayList;
import java.util.List;

public class QueryTerms {
	private List<String> terms;

	public QueryTerms(List<String> terms) {
		this.terms = new ArrayList<>();
		terms.forEach(term -> this.terms.add(term.toLowerCase()));
	}
	
	public void toLower() {
		final List<String> newTerms = new ArrayList<>();
		terms.forEach(term -> newTerms.add(term.toLowerCase()));
		terms = newTerms;
	}

	public List<String> getTerms() {
		return terms;
	}

	@Override
	public String toString() {
		return "QueryTerms [terms=" + terms + "]";
	}
}
