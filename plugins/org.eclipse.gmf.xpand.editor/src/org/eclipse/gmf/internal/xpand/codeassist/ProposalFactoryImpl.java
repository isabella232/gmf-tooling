/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.internal.xpand.codeassist;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.editor.EditorImages;
import org.eclipse.gmf.internal.xpand.expression.TypeNameUtil;
import org.eclipse.gmf.internal.xpand.expression.codeassist.ProposalFactory;
import org.eclipse.gmf.internal.xpand.xtend.ast.GenericExtension;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.graphics.Image;

public class ProposalFactoryImpl implements ProposalFactory {

    protected final int offset;

    public ProposalFactoryImpl(int offset) {
        this.offset = offset;
    }

    public ICompletionProposal createCollectionSpecificOperationProposal(String insertString, String displayString, String prefix, int cursor, int marked) {
        return new CompletionProposal(insertString, offset - prefix.length(), prefix.length(), cursor, getOperationImage(), displayString, null, null);
    }

    public ICompletionProposal createPropertyProposal(final EStructuralFeature p, final String prefix, final boolean onCollection) {
        final String returnType = computeReturnType(p.getEType(), onCollection);
        final String displayStr = p.getName() + " " + returnType + " - " + p.getEContainingClass().getName();
        final String insertStr = p.getName();
        return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), getPropertyImage(), displayStr, null, null);
    }

    private String computeReturnType(EClassifier returnType, final boolean onCollection) {
        if (returnType == null) {
			return BuiltinMetaModel.VOID.getName();
		}
        if (onCollection) {
            if (BuiltinMetaModel.isParameterizedType(returnType)) {
                returnType = BuiltinMetaModel.getInnerType(returnType);
            }
            return "List[" + TypeNameUtil.getLastSegment(returnType.getName()) + "]";
        }

        return TypeNameUtil.getSimpleName(returnType.getName());
    }

    public ICompletionProposal createOperationProposal(final EOperation p, final String prefix, final boolean onCollection) {
        final StringBuilder displayStr = new StringBuilder();
        displayStr.append(p.getName());
        displayStr.append(toParamString(p));
        displayStr.append(" ");
        displayStr.append(computeReturnType(p.getEType(), onCollection));
        if(p.getEContainingClass() != null) { // == null for EDataType operations
        	displayStr.append(" - ");
        	displayStr.append(TypeNameUtil.getSimpleName(p.getEContainingClass().getName()));
        }
        final String insertStr = p.getName() + "()";
        int x = insertStr.length();
        if (p.getEParameters().size() > 0) {
            x--;
        }
        final Image img = getOperationImage();
        return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), x, img, displayStr.toString(), null, null);
    }

    public ICompletionProposal createExtensionProposal(final GenericExtension p, final String prefix) {
        final String displayStr = p.getName() + toParamString(p, false) + " - " + p.getFileName();
        final String insertStr = p.getName() + "()";
        int x = insertStr.length();
        if (p.getParameterNames().size() > 0) {
            x--;
        }
        return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), x, getExtensionImage(), displayStr, null, null);
    }

    public ICompletionProposal createExtensionOnMemberPositionProposal(GenericExtension p, String prefix, boolean onOperation) {
        final String displayStr = p.getName() + toParamString(p, true) + " - " + getTypeName(p.getParameterTypes().get(0));
        final String insertStr = p.getName() + "()";
        int x = insertStr.length();
        if (p.getParameterNames().size() > 1) {
            x--;
        }
        final Image img = getExtensionImage();
        return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), x, img, displayStr, null, null);
    }

    private static String toParamString(final EOperation op) {
        final StringBuilder b = new StringBuilder("(");
        EList/*<EParameter>*/ params = op.getEParameters();
        for (int i = 0, x = params.size(); i < x; i++) {
        	EParameter p = (EParameter) params.get(i);
            b.append(TypeNameUtil.getSimpleName(p.getEType().getName()));
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
    	StringBuilder b = new StringBuilder();
    	getPackageFQName(classifier.getEPackage(), b);
    	b.append(classifier.getName());
    	if (BuiltinMetaModel.isParameterizedType(classifier)) {
    		b.append("[");
    		BuiltinMetaModel.getInnerType(classifier);
    		b.append("]");
    	}
		return b.toString();
	}
    
    private static void getPackageFQName(EPackage ePackage, StringBuilder b) {
    	if (ePackage != null) {
	    	if (ePackage.getESuperPackage() != null) {
	    		getPackageFQName(ePackage.getESuperPackage(), b);
	    	}
    		b.append(ePackage.getName());
    		b.append("::");
    	}
    }

	public ICompletionProposal createVariableProposal(final String name, final EClassifier t, final String prefix) {
        final String displayStr = name + " " + computeReturnType(t, false);
        final String insertStr = name;
        return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), getVariableImage(), displayStr, null, null);
    }

    public ICompletionProposal createTypeProposal(final String insertString, final EClassifier type, final String prefix) {
        StringBuilder displayStr = new StringBuilder(type.getName());
        final String packName = TypeNameUtil.getFullNamespace(type);
        if (packName.length() > 0) {
            displayStr.append(" - ");
            displayStr.append(packName);
        }

        final String insertStr = insertString;
        return new CompletionProposal(insertStr, offset - prefix.length(), prefix.length(), insertStr.length(), getTypeImage(), displayStr.toString(), null, null);
    }

    public ICompletionProposal createStatementProposal(String insertString, String displayString, String prefix, int cursor, int marked) {
        return new CompletionProposal(insertString, offset, prefix.length(), cursor, getStatementImage(), displayString, null, null);
    }

    public ICompletionProposal createStatementProposal(String insertString, String displayString, String prefix) {
        return createStatementProposal(insertString, displayString, prefix, insertString.length(), 0);
    }

    public ICompletionProposal createKeywordProposal(String insertString, String displayString, String prefix) {
        return new CompletionProposal(insertString, offset - prefix.length(), prefix.length(), insertString.length());
    }

	protected Image getTypeImage() {
		return EditorImages.getImage(EditorImages.TYPE);
	}

	protected Image getStatementImage() {
		return EditorImages.getImage(EditorImages.STATEMENT);
	}

	protected Image getOperationImage() {
		return EditorImages.getImage(EditorImages.OPERATION);
	}

	protected Image getPropertyImage() {
		return EditorImages.getImage(EditorImages.PROPERTY);
	}

	protected Image getExtensionImage() {
		return EditorImages.getImage(EditorImages.EXTENSION);
	}

	private Image getVariableImage() {
		return EditorImages.getImage(EditorImages.VARIABLE);
	}
}
