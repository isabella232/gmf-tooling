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
package org.eclipse.gmf.tooling.simplemap.model.triggers.compartment;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage;

public class SimpleCompartmentTriggerListener extends TriggerListener implements ResourceSetListener {

	public static NotificationFilter setCompartmentNeedsTitleFilter;

	public SimpleCompartmentTriggerListener() {
		super(NotificationFilter.createNotifierTypeFilter(SimpleCompartment.class));
	}

	static {

		setCompartmentNeedsTitleFilter = NotificationFilter.createNotifierTypeFilter(SimpleCompartment.class).and(NotificationFilter.createEventTypeFilter(Notification.SET))
				.and(NotificationFilter.createFeatureFilter(SimpleCompartment.class, SimplemappingsPackage.SIMPLE_COMPARTMENT__NEEDS_TITLE));

	}

	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {

		if (setCompartmentNeedsTitleFilter.matches(notification)) {
			SimpleCompartment compartment = (SimpleCompartment) notification.getNotifier();
			boolean needsTitle = (Boolean) notification.getNewValue();

			return new SetCompartmentNeedsTitleTrigger(domain, compartment, needsTitle);
		}

		return null;
	}

}
