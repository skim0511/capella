/*******************************************************************************
 * Copyright (c) 2006, 2020 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.test.validation.rules.ju.testcases.dcov;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.polarsys.capella.core.data.ctx.CtxPackage;
import org.polarsys.capella.test.framework.api.OracleDefinition;
import org.polarsys.capella.test.validation.rules.ju.testcases.AbstractRulesOnDesignTest;

/**
 * test on DCOV_07: This rule checks that a Capability is involved by at least one Actor.
 * 
 * @generated
 */
public class Rule_DCOV_07 extends AbstractRulesOnDesignTest {

  public static final String OK_CAPABILITY = "5a37afe6-1089-4ad1-974b-c9a152f44239"; //$NON-NLS-1$
  public static final String KO_CAPABILITY = "05927644-bb49-4673-9323-322294191580"; //$NON-NLS-1$
  public static final String KO_CAPABILITY_2 = "81b89aac-fae8-44ba-a06a-2d92d62e1267"; //$NON-NLS-1$

  /**
   * @see org.polarsys.capella.test.validation.rules.ju.testcases.ValidationRuleTestCase#getTargetedEClass()
   * @generated
   */
  protected EClass getTargetedEClass() {
    return CtxPackage.Literals.CAPABILITY;
  }

  /**
   * @see org.polarsys.capella.test.validation.rules.ju.testcases.ValidationRuleTestCase#getRuleID()
   * @generated
   */
  protected String getRuleID() {
    return "org.polarsys.capella.core.data.ctx.validation.DCOV_07";
  }

  /**
   * @see org.polarsys.capella.test.validation.rules.ju.testcases.ValidationRulePartialTestCase#getScopeDefinition()
   * @generated
   */
  protected List<String> getScopeDefinition() {
    return Arrays.asList(new String[] { OK_CAPABILITY, KO_CAPABILITY, KO_CAPABILITY_2 });
  }

  /**
   * @see org.polarsys.capella.test.validation.rules.ju.testcases.ValidationRuleTestCase#getOracleDefinitions()
   * @generated
   */
  protected List<OracleDefinition> getOracleDefinitions() {
    return Arrays.asList(
        new OracleDefinition[] { new OracleDefinition(KO_CAPABILITY, 1), new OracleDefinition(KO_CAPABILITY_2, 1) });
  }

}
