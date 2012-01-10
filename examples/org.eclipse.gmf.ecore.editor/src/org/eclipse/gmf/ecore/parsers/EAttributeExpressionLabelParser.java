/*
 * Copyright (c) 2006, 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.parsers;

import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.ecore.expressions.EcoreAbstractExpression;
import org.eclipse.gmf.ecore.expressions.EcoreOCLFactory;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

/**
 * @generated
 */
public class EAttributeExpressionLabelParser implements IParser {

	/**
	 * @generated
	 */
	private final EcoreAbstractExpression printExpression;

	/**
	 * @generated
	 */
	public EAttributeExpressionLabelParser() {
		this.printExpression = EcoreOCLFactory.getExpression("self.name.concat(\' : \').concat(if self.eType.name.oclIsUndefined() then \'none\' else self.eType.name endif)", EcorePackage.eINSTANCE.getEAttribute());
	}

	/**
	 * @generated
	 */
	public String getEditString(IAdaptable element, int flags) {
		return "<enter new value>";
	}

	/**
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		if (Boolean.FALSE.equals(evaluateValidateExpression(editString))) {
			return ParserEditStatus.UNEDITABLE_STATUS;
		} // else fall-through
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable element, final String newString, int flags) {
		final EObject target = (EObject) element.getAdapter(EObject.class);
		if (!validateValues(target, newString)) {
			return UnexecutableCommand.INSTANCE;
		}
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(target);
		if (editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		IFile affectedFile = WorkspaceSynchronizer.getFile(target.eResource());
		return new AbstractTransactionalCommand(editingDomain, "Set Values", affectedFile == null ? null : Collections.singletonList(affectedFile)) { //$NON-NLS-1$ 

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				return new CommandResult(updateValues(target, newString));
			}
		};
	}

	/**
	 * @generated
	 */
	public String getPrintString(IAdaptable element, int flags) {
		EObject target = (EObject) element.getAdapter(EObject.class);
		Object result = this.printExpression.evaluate(target);
		return String.valueOf(result);
	}

	/**
	 * @generated
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		// XXX Any event is recognized as important, unless there's a way to extract this information from expression itself.
		// TODO analyze expressions (e.g. using OCL parser) to find out structural features in use
		return true;
	}

	/**
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean validateValues(EObject target, String newString) {
		// TODO implement as needed
		return true;
	}

	/**
	 * @generated NOT
	 */
	private IStatus updateValues(EObject target, String newString) throws ExecutionException {
		EAttribute attr = (EAttribute) target;
		String[] parts = newString.split(":");
		if (parts.length != 2 || parts[0].trim().length() == 0 || parts[1].trim().length() == 0) {
			return Status.CANCEL_STATUS;
		}
		attr.setName(parts[0].trim());
		LinkedList<EPackage> lookup = new LinkedList<EPackage>();
		if (attr.getEContainingClass() != null && attr.getEContainingClass().getEPackage() != null) {
			lookup.add(attr.getEContainingClass().getEPackage());
		}
		lookup.add(EcorePackage.eINSTANCE);
		String newTypeName = parts[1].trim();
		EClassifier newType = null;
		for (EPackage p : lookup) {
			EClassifier c = p.getEClassifier(newTypeName);
			if (c != null) {
				newType = c;
				break;
			}
		}
		if (newType != null) {
			attr.setEType(newType);
		}
		return Status.OK_STATUS;
	}

	/**
	 * @generated
	 */
	private Boolean evaluateValidateExpression(String self) {
		return self.length() > 0;
	}

}
