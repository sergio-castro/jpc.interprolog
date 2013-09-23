package org.jpc.engine.interprolog;

import static java.util.Arrays.asList;

import org.jpc.Jpc;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Term;
import org.jpc.term.Var;

public class InterPrologSwiYapQuery extends InterPrologQuery {

	public InterPrologSwiYapQuery(InterPrologEngine prologEngine, Term goal, boolean errorHandledQuery, Jpc context) {
		super(prologEngine, goal, errorHandledQuery, context);
	}
	
	@Override
	protected Term instrumentGoal(Term goal) {
		goal = super.instrumentGoal(goal);
		Term atomToTerm = new Compound("atom_to_term", asList(new Atom(goal.toString()), new Var(INSTRUMENTED_GOAL), new Var(ALL_VARIABLES)));
		Term buildTermModel = new Compound("buildTermModel", asList(new Var(ALL_VARIABLES), new Var(ALL_VARIABLES_TERM_MODEL)));
		Term instrumentedGoal = new Compound(",", asList(atomToTerm, new Var(INSTRUMENTED_GOAL)));
		return new Compound(",", asList(instrumentedGoal, buildTermModel)); //buildTermModel should be the last predicate
	}
	
}
