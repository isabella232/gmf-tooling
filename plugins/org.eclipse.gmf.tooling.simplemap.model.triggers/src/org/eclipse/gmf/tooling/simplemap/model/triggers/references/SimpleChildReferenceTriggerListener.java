/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.model.triggers.references;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.GMFMapPackage;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildReference;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage;

public class SimpleChildReferenceTriggerListener extends TriggerListener implements ResourceSetListener {

	public static NotificationFilter setReferencedSimpleNodeFilter;

	public SimpleChildReferenceTriggerListener() {
		super(NotificationFilter.createNotifierTypeFilter(SimpleChildReference.class));
	}

	static {

		setReferencedSimpleNodeFilter = NotificationFilter.createNotifierTypeFilter(SimpleChildReference.class).and(NotificationFilter.createEventTypeFilter(Notification.SET))
				.and(NotificationFilter.createFeatureFilter(SimpleChildReference.class, SimplemappingsPackage.SIMPLE_CHILD_REFERENCE__REFERENCED_SIMPLE_NODE));

	}

	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {

		if (setReferencedSimpleNodeFilter.matches(notification)) {
			SimpleChildReference simpleChildReference = (SimpleChildReference) notification.getNotifier();
			SimpleNode newReference = (SimpleNode) notification.getNewValue();

			//We set the referenced child
			ChildReference nodeReference = (ChildReference) simpleChildReference.getNodeReference();

			if (newReference != null && newReference.getNodeReference() != null) {
				NodeMapping referencedChild = newReference.getNodeReference().getChild();

				if (referencedChild != null)
					return SetCommand.create(domain, nodeReference, GMFMapPackage.eINSTANCE.getChildReference_ReferencedChild(), referencedChild);
			}

		}

		return null;
	}

}
