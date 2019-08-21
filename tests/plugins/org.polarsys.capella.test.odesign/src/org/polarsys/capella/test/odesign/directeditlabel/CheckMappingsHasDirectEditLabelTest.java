/*******************************************************************************
 * Copyright (c) 2019 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.test.odesign.directeditlabel;

import static org.polarsys.capella.test.odesign.directeditlabel.DirectEditLabelConstants.COMMON;
import static org.polarsys.capella.test.odesign.directeditlabel.DirectEditLabelConstants.CONTEXT;
import static org.polarsys.capella.test.odesign.directeditlabel.DirectEditLabelConstants.EPBS;
import static org.polarsys.capella.test.odesign.directeditlabel.DirectEditLabelConstants.LOGICAL;
import static org.polarsys.capella.test.odesign.directeditlabel.DirectEditLabelConstants.OA;
import static org.polarsys.capella.test.odesign.directeditlabel.DirectEditLabelConstants.PHYSICAL;

import java.util.List;
import java.util.Map;

import org.eclipse.sirius.diagram.description.tool.DirectEditLabel;
import org.polarsys.capella.test.framework.api.BasicTestCase;

public class CheckMappingsHasDirectEditLabelTest extends BasicTestCase {

  private Map<String, List<DirectEditLabel>> currentDirectEditLabels;

  public CheckMappingsHasDirectEditLabelTest(Map<String, List<DirectEditLabel>> currentDirectEditLabels) {
    this.currentDirectEditLabels = currentDirectEditLabels;
  }

  @Override
  public void test() throws Exception {
    DirectEditLabelHelper.checkMappingsHasEditLabels(COMMON, currentDirectEditLabels);
    DirectEditLabelHelper.checkMappingsHasEditLabels(OA, currentDirectEditLabels);
    DirectEditLabelHelper.checkMappingsHasEditLabels(CONTEXT, currentDirectEditLabels);
    DirectEditLabelHelper.checkMappingsHasEditLabels(LOGICAL, currentDirectEditLabels);
    DirectEditLabelHelper.checkMappingsHasEditLabels(PHYSICAL, currentDirectEditLabels);
    DirectEditLabelHelper.checkMappingsHasEditLabels(EPBS, currentDirectEditLabels);
  }
}
