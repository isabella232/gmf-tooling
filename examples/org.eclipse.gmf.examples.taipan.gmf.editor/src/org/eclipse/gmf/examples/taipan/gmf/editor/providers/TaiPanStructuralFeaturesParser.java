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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @generated
 */
public class TaiPanStructuralFeaturesParser extends TaiPanAbstractParser {

	/**
	 * @generated
	 */
	private List features;

	/**
	 * @generated
	 */
	public TaiPanStructuralFeaturesParser(List features) {
		this.features = features;
	}

	/**
	 * @generated
	 */
	protected String getStringByPattern(IAdaptable adapter, int flags, String pattern) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		List values = new ArrayList(features.size());
		for (Iterator it = features.iterator(); it.hasNext();) {
			Object value = element.eGet((EStructuralFeature) it.next());
			values.add(value);
		}
		return MessageFormat.format(pattern, values.toArray(new Object[values.size()]));
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
		Object[] values = getValuesFromEditString(newString, getEditPattern());
		if (values.length != features.size()) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeCommand command = new CompositeCommand("Set Values");
		for (int i = 0; i < values.length; i++) {
			EStructuralFeature feature = (EStructuralFeature) features.get(i);
			SetRequest request = new SetRequest(element, feature, values[i]);
			command.compose(new SetValueCommand(request));
		}
		return getModelCommand(command);
	}

	/**
	 * @generated
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			if (features.contains(feature)) {
				return true;
			}
		}
		return false;
	}
}
