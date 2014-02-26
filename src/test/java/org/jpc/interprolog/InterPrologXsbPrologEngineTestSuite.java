package org.jpc.interprolog;

import static org.jpc.engine.provider.PrologEngineProviderManager.setPrologEngineProvider;

import org.jpc.engine.provider.SimpleEngineProvider;
import org.jpc.util.config.EngineConfigurationManager;
import org.junit.BeforeClass;

public class InterPrologXsbPrologEngineTestSuite extends InterPrologPrologEngineTestSuite {
	@BeforeClass
	public static void setUp() {
		EngineConfigurationManager engineConfigurationManager = EngineConfigurationManager.createFromFile("jpc_xsb.settings");
		EngineConfigurationManager.setDefault(engineConfigurationManager);
		setPrologEngineProvider(new SimpleEngineProvider(EngineConfigurationManager.getDefault().getNamedPrologEngine("xsb")));
	}
}