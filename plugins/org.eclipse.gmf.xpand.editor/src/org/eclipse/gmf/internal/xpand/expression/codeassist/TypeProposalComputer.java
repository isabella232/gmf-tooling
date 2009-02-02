/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand.expression.codeassist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.ocl.lpg.FormattingHelper;

public class TypeProposalComputer implements ProposalComputer {
    private final char[] possibleTypeNameChars;
	private final ProposalFactory proposalFactory;

    public TypeProposalComputer(ProposalFactory factory) {
    	possibleTypeNameChars = new char[] {
    	   	':', '{', '}', '(', ')'
    	};
    	Arrays.sort(possibleTypeNameChars);
    	assert factory != null;
    	this.proposalFactory = factory;
    }

    public List<ICompletionProposal> computeProposals(final String txt, final ExecutionContext ctx) {
        final String prefix = findPrefix(txt);
        String[] prefixParts = prefix.split(TypeNameUtil.NS_DELIM, -1);
        List<EPackage> possiblePackages = new LinkedList<EPackage>();
        // XXX how about package with artificial types (e.g. various Sequence instances)?
        if (prefixParts.length > 1) {
        	ArrayList<String> p = new ArrayList<String>(5);
        	p.addAll(Arrays.asList(prefixParts));
        	p.remove(p.size()-1);
        	EPackage r = ctx.getOCLEnvironment().lookupPackage(p);
        	if (r != null) {
        		possiblePackages.add(r);
        	}
        } else {
        	for (Object next : ((ExecutionContextImpl) ctx).getAllVisibleModels().values()) {
        		if (next instanceof EPackage) {
        			possiblePackages.add((EPackage) next);
        		}
        	}
        }
       	final String typeNamePrefix = prefixParts.length == 0 ? "" : prefixParts[prefixParts.length-1];
        final LinkedList<ICompletionProposal> result = new LinkedList<ICompletionProposal>();
		final FormattingHelper formatter = ctx.getOCLEnvironment().getFormatter();
		final EPackage oclStdLibPackage = ctx.getOCLEnvironment().getOCLStandardLibrary().getOclAny().getEPackage();
       	for (EPackage pkg : possiblePackages) {
       		// XXX how about nested packages?
       		for (EClassifier type : pkg.getEClassifiers()) {
       			if (type.getName() != null && type.getName().startsWith(typeNamePrefix)) {
    	            //String insertString = TypeNameUtil.getQualifiedName(type);
					String insertString = formatter.formatQualifiedName(type);
    	            if (!insertString.startsWith(prefix) && insertString.indexOf(prefix) > 0) {
    	                insertString = insertString.substring(insertString.indexOf(prefix));
    	            }
    	            String displayStr;
    	            // pkg == type.getPackage()
    	            if (pkg != oclStdLibPackage) {
        	            final String packName = formatter.formatQualifiedName(type.getEPackage());
    	            	displayStr = type.getName() + " - " + packName;
    	            } else {
    	            	displayStr = type.getName();
    	            }
    	            result.add(proposalFactory.createTypeProposal(insertString, displayStr.toString(), prefix));
       			}
       		}
       		final String pkgQualifiedName = formatter.formatQualifiedName(pkg);
       		if (pkgQualifiedName.startsWith(prefix)) {
       			result.add(proposalFactory.createTypeProposal(pkgQualifiedName + TypeNameUtil.NS_DELIM, pkgQualifiedName, prefix));
       		}
        }
        return result;
    }

	/**
	 * is public only for testing purposes
	 */
    public String findPrefix(final String txt) {
        final StringBuilder result = new StringBuilder();
        int i = txt.length() - 1;
        char c = txt.charAt(i);
        while (Character.isJavaIdentifierPart(c) || Arrays.binarySearch(possibleTypeNameChars, c) >= 0) {
            result.append(c);
            if (i > 0) {
            	c = txt.charAt(--i);
            } else {
            	break;
            }
        }
        return result.reverse().toString();
    }
}
