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

import java.text.MessageFormat;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @generated
 */
public class TaiPanStructuralFeatureParser extends TaiPanAbstractParser {

	/**
	 * @generated
	 */
	private EStructuralFeature feature;

	/**
	 * @generated
	 */
	public TaiPanStructuralFeatureParser(EStructuralFeature feature) {
		this.feature = feature;
	}

	/**
	 * @generated
	 */
	protected String getStringByPattern(IAdaptable adapter, int flags, String pattern) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		Object value = element.eGet(feature);
		if (pattern == null) {
			pattern = "{0}";
		}
		return MessageFormat.format(pattern, new Object[] { value });
	}

	/**
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		String pattern = getEditPattern();
		if (pattern == null) {
			pattern = "{0}";
		}
		Object[] values = getValuesFromEditString(newString, pattern);
		if (values.length != 1) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest request = new SetRequest(element, feature, values[0]);
		return getModelCommand(new SetValueCommand(request));
	}

	/**
	 * @generated
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			if (feature == ((Notification) event).getFeature()) {
				return true;
			}
		}
		return false;
	}
}
