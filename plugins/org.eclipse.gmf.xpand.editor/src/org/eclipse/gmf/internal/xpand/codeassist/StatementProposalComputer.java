/*
 * Copyright (c) 2005, 2010 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.codeassist;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.gmf.internal.xpand.expression.codeassist.ProposalComputer;
import org.eclipse.gmf.internal.xpand.expression.codeassist.ProposalFactory;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public class StatementProposalComputer implements ProposalComputer {

	private final ProposalFactory proposalFactory;

	public StatementProposalComputer(ProposalFactory factory) {
		assert factory != null;
		proposalFactory = factory;
	}

	public List<ICompletionProposal> computeProposals(final String txt, final ExecutionContext ctx) {
		final List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
		final String ws = findTrailingWhitespace(txt);

		final Stack<StackElement> s = FastAnalyzer.computeStack(txt);
		if (s.size() > 0) {
			final StackElement se = s.peek();
			result.add(proposalFactory.createStatementProposal(XpandTokens.LT + "END" + se.block + XpandTokens.RT, "END" + se.block, ""));
			if (contains(XpandTokens.IF, s)) {
				result.add(proposalFactory.createStatementProposal(XpandTokens.LT + "ELSE" + XpandTokens.RT, "ELSE", ""));
				result.add(proposalFactory.createStatementProposal(XpandTokens.LT + "ELSEIF statement" + XpandTokens.RT, "ELSEIF", ""));
			}
			if (!contains(XpandTokens.FILE, s)) {
				result.add(fileBlockProposal(ws));
			}
			if (!contains(XpandTokens.PROTECT, s)) {
				result.add(protectBlockProposal(ws));
			}
			result.add(foreachBlockProposal(ws));
			result.add(ifBlockProposal(ws));
			result.add(letBlockProposal(ws));
			result.add(expandStatementProposal(ws));
		} else {
			if (txt.indexOf(XpandTokens.LT + XpandTokens.DEFINE) == -1) {
				if (txt.indexOf(XpandTokens.LT + XpandTokens.EXTENSION) == -1) {
					result.add(importStatementProposal());
				}
				result.add(extensionStatementProposal());
			}
			result.add(defineBlockProposal(ws));
			result.add(aroundBlockProposal(ws));
		}
		return result;
	}

	private ICompletionProposal importStatementProposal() {
		final String insertString = XpandTokens.LT + XpandTokens.IMPORT + " my::imported::namespace" + XpandTokens.RT;
		return proposalFactory.createStatementProposal(insertString, "IMPORT statement", "", insertString.indexOf("my::imported::namespace"), "my::imported::namespace".length());
	}

	private ICompletionProposal extensionStatementProposal() {
		final String insertString = XpandTokens.LT + XpandTokens.EXTENSION + " path::to::Extension" + XpandTokens.RT;
		return proposalFactory.createStatementProposal(insertString, "EXTENSION statement", "", insertString.indexOf("path::to::Extension"), "path::to::Extension".length());
	}

	private final static Pattern WS_PATTERN = Pattern.compile("(\\n?[\\t ]*)\\z");

	private String findTrailingWhitespace(final String txt) {
		final Matcher m = WS_PATTERN.matcher(txt);
		m.find();
		return m.group(1);
	}

	private ICompletionProposal expandStatementProposal(final String ws) {
		final String insertString = XpandTokens.LT + "EXPAND definition FOR self" + XpandTokens.RT;
		return proposalFactory.createStatementProposal(insertString, "EXPAND statement", "", insertString.indexOf("definition"), "definition".length());
	}

	private ICompletionProposal letBlockProposal(final String ws) {
		final String insertString = XpandTokens.LT + "LET expression AS e" + XpandTokens.RT + ws + XpandTokens.LT + "ENDLET" + XpandTokens.RT;
		return proposalFactory.createStatementProposal(insertString, "LET block", "", insertString.indexOf("expression"), "expression".length());
	}

	private ICompletionProposal ifBlockProposal(final String ws) {
		final String insertString = XpandTokens.LT + "IF condition" + XpandTokens.RT + ws + XpandTokens.LT + "ENDIF" + XpandTokens.RT;
		return proposalFactory.createStatementProposal(insertString, "IF block", "", insertString.indexOf("condition"), "condition".length());
	}

	private ICompletionProposal foreachBlockProposal(final String ws) {
		final String insertString = XpandTokens.LT + "FOREACH elements AS e" + XpandTokens.RT + ws + XpandTokens.LT + "ENDFOREACH" + XpandTokens.RT;
		return proposalFactory.createStatementProposal(insertString, "FOREACH block", "", insertString.indexOf("elements"), "elements".length());
	}

	private ICompletionProposal protectBlockProposal(final String ws) {
		final String insertString = XpandTokens.LT + "PROTECT CSTART '/*' CEND '*/' ID uniqueId ENABLED" + XpandTokens.RT + ws + XpandTokens.LT + "ENDPROTECT" + XpandTokens.RT;
		return proposalFactory.createStatementProposal(insertString, "PROTECT region", "", insertString.indexOf("uniqueId"), "uniqueId".length());
	}

	private ICompletionProposal fileBlockProposal(final String ws) {
		final String insertString = XpandTokens.LT + "FILE fileName" + XpandTokens.RT + ws + XpandTokens.LT + "ENDFILE" + XpandTokens.RT;
		return proposalFactory.createStatementProposal(insertString, "FILE block", "", insertString.indexOf("fileName"), "fileName".length());
	}

	private ICompletionProposal defineBlockProposal(final String ws) {
		final String insertString = XpandTokens.LT + "DEFINE definionName FOR Type" + XpandTokens.RT + ws + XpandTokens.LT + "ENDDEFINE" + XpandTokens.RT;
		return proposalFactory.createStatementProposal(insertString, "new DEFINE", "", insertString.indexOf("definionName"), "definionName".length());
	}

	private ICompletionProposal aroundBlockProposal(final String ws) {
		final String insertString = XpandTokens.LT + "AROUND fullyQualifiedDefinionName FOR Type" + XpandTokens.RT + ws + XpandTokens.LT + "ENDAROUND" + XpandTokens.RT;
		return proposalFactory.createStatementProposal(insertString, "new AROUND", "", insertString.indexOf("fullyQualifiedDefinionName"), "fullyQualifiedDefinionName".length());
	}

	private boolean contains(final String blockName, final Stack<StackElement> s) {
		for (StackElement element : s) {
			if (element.block.equals(blockName)) {
				return true;
			}
		}
		return false;
	}

	protected String findPrefix(final String txt) {
		final StringBuffer result = new StringBuffer();
		int i = txt.length() - 1;
		char c = txt.charAt(i);
		while ((i > 0) && Character.isJavaIdentifierStart(c)) {
			result.append(c);
			c = txt.charAt(--i);
		}
		return result.reverse().toString();
	}
}
