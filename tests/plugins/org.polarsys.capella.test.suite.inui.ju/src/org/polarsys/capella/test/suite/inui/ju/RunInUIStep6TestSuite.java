/*******************************************************************************
 * Copyright (c) 2017, 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.test.suite.inui.ju;

import java.util.ArrayList;
import java.util.List;

import org.polarsys.capella.test.diagram.filters.ju.testsuites.DiagramFiltersTestSuite;
import org.polarsys.capella.test.diagram.misc.ju.testsuites.DiagramMiscTestSuite;
import org.polarsys.capella.test.diagram.tools.ju.testsuites.main.DiagramToolsStep2TestSuite;
import org.polarsys.capella.test.fragmentation.ju.testsuites.FragmentationTestSuite;
import org.polarsys.capella.test.framework.api.BasicTestArtefact;
import org.polarsys.capella.test.framework.api.BasicTestSuite;
import org.polarsys.capella.test.massactions.ju.testsuites.MassActionsTestSuite;
import org.polarsys.capella.test.odesign.ju.maintestsuite.ODesignTestSuite;
import junit.framework.Test;

/**
 *
 */
public class RunInUIStep6TestSuite extends BasicTestSuite {

  /**
   * Returns the suite. This is required to unary launch this test.
   */
  public static Test suite() {
    return new RunInUIStep6TestSuite();
  }

  @Override
  protected List<BasicTestArtefact> getTests() {
    List<BasicTestArtefact> tests = new ArrayList<>();
    tests.add(new DiagramToolsStep2TestSuite());
    tests.add(new DiagramFiltersTestSuite());
    tests.add(new DiagramMiscTestSuite());
    tests.add(new MassActionsTestSuite());
    tests.add(new FragmentationTestSuite());
    tests.add(new ODesignTestSuite());

    return tests;
  }

}
