/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.emf.core.services.metamodel.GetMetamodelSupportOperation;
import org.eclipse.gmf.runtime.emf.core.services.metamodel.IMetamodelSupport;
import org.eclipse.gmf.runtime.emf.core.services.metamodel.IMetamodelSupportProvider;
import org.eclipse.gmf.runtime.notation.providers.internal.semproc.NotationSemProc;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

/**
 * @generated
 */
public class TaiPanMetaModelSupportProvider extends AbstractProvider implements IMetamodelSupportProvider {

	/**
	 * @generated
	 */
	private IMetamodelSupport support;

	/**
	 * @generated
	 */
	public IMetamodelSupport getMetamodelSupport(EPackage ePackage) {
		if (support == null) {
			support = new MetamodelSupportImpl();
		}
		return support;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetMetamodelSupportOperation) {
			return TaiPanPackage.eINSTANCE == ((GetMetamodelSupportOperation) operation).getEPackage();
		}
		return false;
	}

	/**
	 * @generated
	 */
	public class MetamodelSupportImpl implements IMetamodelSupport {

		/**
		 * @generated
		 */
		public boolean canDestroy(EObject eObject) {
			return true;
		}

		/**
		 * @generated
		 */
		public boolean canContain(EClass eContainer, EReference eReference, EClass eClass) {
			return true;
		}

		/**
		 * @generated
		 */
		public void handleEvent(Notification event) {
			NotationSemProc.handleEvent(event);
		}

		/**
		 * @generated
		 */
		public void postProcess(EObject root) {
		}
	}
}
