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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.gmf.internal.xpand.expression.codeassist.ProposalComputer;
import org.eclipse.gmf.internal.xpand.expression.codeassist.ProposalFactory;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public class ExpandProposalComputer implements ProposalComputer {
	private final static Pattern p1 = Pattern.compile("DEFINE\\s+([\\w]+)");
	private final static Pattern p2 = Pattern.compile("EXPAND\\s+([\\w]*)\\z");

	private final ProposalFactory proposalFactory;
	private final String fullText;

	public ExpandProposalComputer(String fullText, ProposalFactory factory) {
		assert factory != null;
		proposalFactory = factory;
		this.fullText = fullText;
	}
	public List<ICompletionProposal> computeProposals(final String txtToPoint, final ExecutionContext ctx) {
		String prefix;
		Matcher m2 = p2.matcher(txtToPoint);
		if (m2.find()) {
			prefix = m2.group(1);
		} else {
			prefix = "";
		}
		ArrayList<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
		Matcher m = p1.matcher(fullText);
		while (m.find()) {
			String templateName = m.group(1).trim();
			if (templateName.startsWith(prefix)) {
				result.add(proposalFactory.createStatementProposal(templateName, templateName, prefix));
			}
		}
		return result;
    }
}
