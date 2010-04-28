/*
 * Copyright (c) 2005, 2010 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.codeassist;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.gmf.internal.xpand.editor.EditorImages;
import org.eclipse.gmf.internal.xpand.expression.codeassist.ProposalFactory;
import org.eclipse.gmf.internal.xpand.xtend.ast.GenericExtension;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.lpg.AbstractFormattingHelper;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.swt.graphics.Image;

public class ProposalFactoryImpl implements ProposalFactory {

	protected final int offset;

	private final EditorImages editorImages;

	private final int selectionLen;
	
	private final EcoreEnvironment ecoreEnvironment;

	public ProposalFactoryImpl(int offset, int selectionLen, EditorImages images) {
		this.offset = offset;
		assert selectionLen >= 0;
		this.selectionLen = selectionLen;
		this.editorImages = images;
		this.ecoreEnvironment = (EcoreEnvironment) EcoreEnvironmentFactory.INSTANCE.createEnvironment();
	}

	public ICompletionProposal createCollectionSpecificOperationProposal(String insertString, String displayString, String prefix, int cursor, int marked) {
		return new CompletionProposal(insertString, offset - prefix.length(), prefix.length() + selectionLen, cursor, editorImages.getOperation(), displayString, null, null);
	}

	public ICompletionProposal createPropertyProposal(final EStructuralFeature p, final String prefix, final boolean onCollection) {
		final String returnType = computeReturnType(p, onCollection);
		final String displayStr = p.getName() + " " + returnType + " - " + p.getEContainingClass().getName();
		final String insertStr = p.getName();
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length() + selectionLen, insertStr.length(), editorImages.getProperty(), displayStr, null, null);
	}

	private String computeReturnType(ETypedElement returnType, final boolean onCollection) {
		EClassifier t = ecoreEnvironment.getUMLReflection().getOCLType(returnType);
		if (onCollection) {
			// FIXME [artem] not sure why for properties that return list but invoked on collection
			// I need to use inner type - sort of implicit collect ("a.b.c", where all properties are lists still
			// gives a flat result list). Need to check if this holds true with OCL/QVT
			if (t instanceof CollectionType) {
				EClassifier temp = t;
				t = ((CollectionType) t).getElementType();
				// @see EcoreEvaluationEnvironment#getCollectionKind()
				ObjectUtil.dispose(temp);
			}
			t = (EClassifier) ecoreEnvironment.getOCLFactory().createSequenceType(t);
		}
		return getTypeName(t);
	}

	public ICompletionProposal createOperationProposal(final EOperation p, final String prefix, final boolean onCollection) {
		final StringBuilder displayStr = new StringBuilder();
		displayStr.append(p.getName());
		displayStr.append(toParamString(p));
		displayStr.append(" ");
		displayStr.append(computeReturnType(p, onCollection));
		if (p.getEContainingClass() != null) { // == null for EDataType operations
			displayStr.append(" - ");
			displayStr.append(getTypeName(p.getEContainingClass()));
		}
		final String insertStr = p.getName() + "()";
		int x = insertStr.length();
		if (p.getEParameters().size() > 0) {
			x--;
		}
		final Image img = editorImages.getOperation();
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length() + selectionLen, x, img, displayStr.toString(), null, null);
	}

	public ICompletionProposal createExtensionProposal(final GenericExtension p, final String prefix) {
		final String displayStr = p.getName() + toParamString(p, false) + " - " + p.getFileName();
		final String insertStr = p.getName() + "()";
		int x = insertStr.length();
		if (p.getParameterNames().size() > 0) {
			x--;
		}
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length() + selectionLen, x, editorImages.getExtension(), displayStr, null, null);
	}

	public ICompletionProposal createExtensionOnMemberPositionProposal(GenericExtension p, String prefix, boolean onOperation) {
		final String displayStr = p.getName() + toParamString(p, true) + " - " + getTypeName(p.getParameterTypes().get(0));
		final String insertStr = p.getName() + "()";
		int x = insertStr.length();
		if (p.getParameterNames().size() > 1) {
			x--;
		}
		final Image img = editorImages.getExtension();
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length() + selectionLen, x, img, displayStr, null, null);
	}

	private static String toParamString(final EOperation op) {
		final StringBuilder b = new StringBuilder("(");
		EList<EParameter> params = op.getEParameters();
		for (int i = 0, x = params.size(); i < x; i++) {
			b.append(getTypeName(params.get(i).getEType()));
			if (i + 1 < x) {
				b.append(",");
			}
		}
		b.append(")");
		return b.toString();
	}

	private static String toParamString(final GenericExtension p, final boolean member) {
		final StringBuilder b = new StringBuilder("(");
		int i = member ? 1 : 0;
		List<String> parameterNames = p.getParameterNames();
		// TODO: check if getParameterTypes() return proper collection in all situations
		List<EClassifier> parameterTypes = p.getParameterTypes();
		for (final int x = parameterNames.size(); i < x; i++) {
			b.append(parameterTypes.size() < x ? getTypeName(parameterTypes.get(x)) : "?");
			b.append(" ");
			b.append(parameterNames.get(x));
			if (i + 1 < x) {
				b.append(",");
			}
		}
		b.append(")");
		return b.toString();
	}

	// TODO: revisit this method and check correct type name processing for QVT types
	private static String getTypeName(EClassifier classifier) {
		return AbstractFormattingHelper.INSTANCE.formatType(classifier);
	}

	public ICompletionProposal createVariableProposal(String varName, String typeName, String prefix) {
		final String displayStr = varName + " " + typeName;
		final String insertStr = varName;
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length() + selectionLen, insertStr.length(), editorImages.getVariable(), displayStr, null, null);
	}

	public ICompletionProposal createTypeProposal(final String insertStr, String displayStr, final String prefix) {
		return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length() + selectionLen, insertStr.length(), editorImages.getType(), displayStr, null, null);
	}

	public ICompletionProposal createStatementProposal(String insertString, String displayString, String prefix, int cursor, int marked) {
		return new CompletionProposal(insertString, offset - prefix.length(), prefix.length() + selectionLen, cursor, editorImages.getStatement(), displayString, null, null);
	}

	public ICompletionProposal createStatementProposal(String insertString, String displayString, String prefix) {
		return createStatementProposal(insertString, displayString, prefix, insertString.length(), 0);
	}

	public ICompletionProposal createKeywordProposal(String insertString, String displayString, String prefix) {
		return new CompletionProposal(insertString, offset - prefix.length(), prefix.length() + selectionLen, insertString.length());
	}
}
