package org.jpc.util.salt.interprolog;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.jpc.util.salt.JpcTermStreamer;
import org.jpc.term.Atom;
import org.jpc.term.Compound;
import org.jpc.term.Float;
import org.jpc.term.Integer;
import org.jpc.term.Term;
import org.jpc.term.Var;
import org.jpc.term.interprolog.InterPrologTermWrapper;
import org.junit.Test;

import com.declarativa.interprolog.TermModel;
import com.declarativa.interprolog.util.VariableNode;

public class InterPrologTransformationTest {

	//jpl.Term t1Jpl = new jpl.Compound("id", new jpl.Term[] {new jpl.Compound("name2", new jpl.Term[] {new jpl.Atom("atom1"), new jpl.Integer(-10), new jpl.Float(10.5), new jpl.Variable("A"), new jpl.Variable("_A")})});
	TermModel t1InterProlog = new TermModel("id", new TermModel[]{new TermModel("name2", new TermModel[]{new TermModel("atom1"), new TermModel(-10), new TermModel(10.5), new TermModel(new VariableNode(0)), new TermModel(new VariableNode(1))})});
	InterPrologTermWrapper t1InterPrologWrapper = new InterPrologTermWrapper(t1InterProlog, new HashMap<java.lang.Integer, String>(){{put(0, "A"); put(1, "_A");}});
	Term t1Jpc = new Compound("id", asList(new Compound("name2", asList(new Atom("atom1"), new Integer(-10), new Float(10.5), new Var("A"), new Var("_A")))));
	
	@Test
	public void testInterPrologToInterProlog() {
		InterPrologTermStreamer termWriter = new InterPrologTermStreamer();
		new InterPrologTermReader(t1InterPrologWrapper, termWriter).read();
		assertEquals(t1InterPrologWrapper, termWriter.getFirst());
	}
	
	@Test
	public void testInterPrologToJpc() {
		JpcTermStreamer jpcTermWriter = new JpcTermStreamer();
		new InterPrologTermReader(t1InterPrologWrapper, jpcTermWriter).read();
		assertEquals(t1Jpc, jpcTermWriter.getFirst());
	}
	
	@Test
	public void testJpcToInterProlog() {
		InterPrologTermStreamer interPrologTermWriter = new InterPrologTermStreamer();
		t1Jpc.read(interPrologTermWriter);
		assertEquals(t1InterPrologWrapper, interPrologTermWriter.getFirst());
	}
	
}
