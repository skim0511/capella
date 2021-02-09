/*******************************************************************************
 * Copyright (c) 2021 THALES GLOBAL SERVICES.
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
package org.polarsys.capella.core.semantic.queries.basic.queries;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.polarsys.capella.common.data.modellingcore.AbstractTrace;
import org.polarsys.capella.common.data.modellingcore.TraceableElement;
import org.polarsys.capella.common.helpers.query.IQuery;
import org.polarsys.capella.core.data.capellacommon.StateTransition;
import org.polarsys.capella.core.data.capellacommon.StateTransitionRealization;

/**
 * Return the State Transition realizing another State Transition
 *
 */
public class StateTransition_RealizingStateTransition implements IQuery {

  public StateTransition_RealizingStateTransition() {
    // Do nothing
  }

  @Override
  public List<Object> compute(Object object) {
    List<Object> result = new ArrayList<>();
    if (object instanceof StateTransition) {
      StateTransition stateTransition = (StateTransition) object;
      EList<AbstractTrace> traces = stateTransition.getIncomingTraces();
      for (AbstractTrace trace : traces) {
        if (trace instanceof StateTransitionRealization) {
          TraceableElement targetElement = trace.getSourceElement();
          if (targetElement instanceof StateTransition) {
            result.add(targetElement);
          }
        }
      }
    }
    return result;
  }
}