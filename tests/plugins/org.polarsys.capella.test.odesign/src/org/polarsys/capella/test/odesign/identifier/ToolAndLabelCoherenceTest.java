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
package org.polarsys.capella.test.odesign.identifier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.osgi.util.NLS;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelection;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.ui.PlatformUI;
import org.polarsys.capella.core.model.handler.command.CapellaResourceHelper;
import org.polarsys.capella.core.platform.sirius.ui.services.IElementIdentifierService;
import org.polarsys.capella.test.framework.api.BasicTestCase;

public class ToolAndLabelCoherenceTest extends BasicTestCase {

  @Override
  public void test() {
    Collection<String> errors = new ArrayList<>();

    IElementIdentifierService elementIdentifier = PlatformUI.getWorkbench().getService(IElementIdentifierService.class);

    for (Viewpoint viewpoint : ViewpointSelection.getViewpoints(CapellaResourceHelper.CAPELLA_MODEL_FILE_EXTENSION)) {
      EList<RepresentationDescription> descriptions = viewpoint.getOwnedRepresentations();
      for (RepresentationDescription description : descriptions) {
        if (description instanceof DiagramDescription) {
          DiagramDescription diagramDescription = (DiagramDescription) description;
          IdentifierHelper.getTools(diagramDescription).forEach(element -> {
            String toolIdentifier = elementIdentifier.getIdentifier(diagramDescription, element);
            String toolLabel = element.getLabel();
            if (toolLabel == null) {
              errors.add(NLS.bind("Element {0} doesn't have a label.", element.getName()));

            } else {
              String[] tokens = toolLabel.split("%");
              if (tokens.length != 1) {
                errors.add(NLS.bind("Element {0} is not internationalized.", element.getName()));

              } else {
                String label = tokens[0];
                if (!label.equals(toolIdentifier)) {
                  errors.add(NLS.bind("Element {0} doesn't use the correct label identifier. {1} instead of {2}", new String[] {element.getName(), label, toolIdentifier}));
                }
              }
            }
          });
        }
      }
    }

    if (!errors.isEmpty()) {
      assertTrue(errors.stream().collect(Collectors.joining("\n")), errors.isEmpty());
    }

  }
}
