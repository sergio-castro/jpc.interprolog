package org.jpc.jpl;

import org.jpc.PrologEngineTestSuite;
import org.jpc.examples.PrologExamplesTestSuite;
import org.jpc.salt.jpl.TransformationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * All the non-Logtalk tests the logic engine should pass
 * @author sergioc
 *
 */
@RunWith(Suite.class)
@SuiteClasses({PrologEngineTestSuite.class, PrologExamplesTestSuite.class, TransformationTest.class})
public abstract class JplPrologEngineTestSuite {}