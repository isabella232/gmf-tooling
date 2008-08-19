/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.expression.codeassist;

import java.util.List;

import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.jface.text.contentassist.ICompletionProposal;

public interface ProposalComputer {
    public List<ICompletionProposal> computeProposals(String txt, ExecutionContext ctx);
}
