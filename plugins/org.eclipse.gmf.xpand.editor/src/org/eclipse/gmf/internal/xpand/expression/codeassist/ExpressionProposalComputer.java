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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import lpg.runtime.IToken;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.editor.Activator;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.gmf.internal.xpand.parser.XpandParsersym;
import org.eclipse.gmf.internal.xpand.xtend.ast.GenericExtension;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.lpg.AbstractFormattingHelper;
import org.eclipse.ocl.utilities.PredefinedType;

@SuppressWarnings("restriction")
public class ExpressionProposalComputer implements ProposalComputer {

	private ExecutionContext executionContext;

	private final ProposalFactory proposalFactory;
	private final ExpressionSimpleAnalyzer exprAnalyzer;

	public ExpressionProposalComputer(ProposalFactory factory) {
		assert factory != null;
		proposalFactory = factory;
		ExpressionSimpleAnalyzer cached = Activator.findState(ExpressionSimpleAnalyzer.class);
		if (cached == null) {
			Activator.putState(ExpressionSimpleAnalyzer.class, cached = new ExpressionSimpleAnalyzer());
		}
		exprAnalyzer = cached;
	}

	/**
	 * @param ctx
	 * @return
	 */
	public List<ICompletionProposal> computeProposals(final String txt, final ExecutionContext context) {
		try {
			final String[] s = exprAnalyzer.computePrefixAndTargetExpression(txt);
			final String prefix = s[0];
			final String expressionString = s[1];
			this.executionContext = context;
			final List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();

			if ((prefix.length() > 0) && (expressionString == null)) {
				proposals.addAll(new TypeProposalComputer(proposalFactory).computeProposals(txt, executionContext));
			}

			EClassifier targetType = null;
			if (expressionString != null) {
				/*
				 * FIXME new ExpressionHelper(expressionString).analyze(executionContext, issues);
				 * 
				final Set<AnalysationIssue> issues = new HashSet<AnalysationIssue>();
				targetType = null;
				if (targetType == null) {
					return Collections.emptyList();
				}
				*/
				// HACK: FALL-THROUGH
			}
			if (targetType == null) {
				// variables
				for (org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> v : executionContext.getOCLEnvironment().getVariables()) {
					String varName = v.getName();
					if (varName.toLowerCase().startsWith(prefix.toLowerCase())) {
						EClassifier t = v.getType();
						String typeName = AbstractFormattingHelper.INSTANCE.formatType(t);
						proposals.add(proposalFactory.createVariableProposal(varName, typeName, prefix));
					}
				}
				// members and extensions on this
				final Variable v = executionContext.getImplicitVariable();
				if (v != null) {
					targetType = v.getType();
					proposals.addAll(getAllMemberProposals(targetType, prefix));
				}

				final Set<? extends GenericExtension> exts = executionContext.getAllExtensions();
				for (GenericExtension extension : exts) {
					if (extension.getName().toLowerCase().startsWith(prefix.toLowerCase())) {
						proposals.add(proposalFactory.createExtensionProposal(extension, prefix));
					}
				}
			} else {
				// members and extensions on targetType
				proposals.addAll(getAllMemberProposals(targetType, prefix));
			}
			return proposals;
		} finally {
			executionContext = null;
		}
	}

	/**
	 * @param targetType
	 * @param prefix
	 * @param context
	 * @param ctx
	 * @param factory
	 * @return
	 */
	private List<ICompletionProposal> getAllMemberProposals(EClassifier targetType, final String prefix) {
		if (targetType == null) {
			return Collections.emptyList();
		}
		final List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();

		result.addAll(internalGetAllMemberProposals(targetType, prefix, false));
		if (targetType instanceof CollectionType) {
			result.addAll(getAllCollectionOperations(prefix));
			targetType = ((CollectionType) targetType).getElementType();
			result.addAll(internalGetAllMemberProposals(targetType, prefix, true));
		}
		return result;
	}

	private List<ICompletionProposal> internalGetAllMemberProposals(EClassifier targetType, String prefix, boolean onCollection) {
		final List<ICompletionProposal> result = new LinkedList<ICompletionProposal>();
		final String prefixLowerCase = prefix.toLowerCase();
		for (EStructuralFeature f : getAllFeatures(targetType, executionContext)) {
			if (f.getName().toLowerCase().startsWith(prefixLowerCase)) {
				result.add(proposalFactory.createPropertyProposal(f, prefix, onCollection));
			}
		}
		for (EOperation op : getAllOperation(targetType, executionContext)) {
			if (op.getName().toLowerCase().startsWith(prefixLowerCase) && Character.isJavaIdentifierStart(op.getName().charAt(0))) {
				result.add(proposalFactory.createOperationProposal(op, prefix, onCollection));
			}
		}
		for (GenericExtension e : executionContext.getAllExtensions()) {
			if (e.getName().toLowerCase().startsWith(prefixLowerCase) && (e.getParameterTypes().size() >= 1) &&
					BuiltinMetaModel.isAssignableFrom(executionContext, e.getParameterTypes().get(0), targetType)) {
				result.add(proposalFactory.createExtensionOnMemberPositionProposal(e, prefix, onCollection));
			}
		}
		return result;
	}

	private static List<EStructuralFeature> getAllFeatures(EClassifier targetType, ExecutionContext ctx) {
		List<EStructuralFeature> r2 = ctx.getOCLEnvironment().getTypeResolver().getAdditionalAttributes(targetType);
		if (targetType instanceof EClass) {
			List<EStructuralFeature> r1 = ((EClass) targetType).getEAllStructuralFeatures();
			ArrayList<EStructuralFeature> rv = new ArrayList<EStructuralFeature>(r1.size() + r2.size());
			rv.addAll(r1);
			rv.addAll(r2);
			return rv;
		}
		return r2;
	}

	private static List<EOperation> getAllOperation(EClassifier targetType, ExecutionContext ctx) {
		List<EOperation> r2 = ctx.getOCLEnvironment().getTypeResolver().getAdditionalOperations(targetType);
		if (targetType instanceof PredefinedType<?>) {
			@SuppressWarnings("unchecked")
			PredefinedType<EOperation> t = (PredefinedType<EOperation>) targetType;
			List<EOperation> r1 = t.oclOperations();
			ArrayList<EOperation> rv = new ArrayList<EOperation>(r1.size() + r2.size());
			rv.addAll(r1);
			rv.addAll(r2);
			return rv;
		} else if (targetType instanceof EClass) {
			List<EOperation> r1 = ((EClass) targetType).getEAllOperations();
			ArrayList<EOperation> rv = new ArrayList<EOperation>(r1.size() + r2.size());
			rv.addAll(r1);
			rv.addAll(r2);
			return rv;
		}
		return r2;
	}

	// XXX could use XpandParsersym.orderedTerminalSymbols[TK_xx] to get
	// values like 'select', 'reject', etc
	private List<ICompletionProposal> getAllCollectionOperations(final String prefix) {
		final List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
		final String marked = "expression-with-e";

		String s = "select(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(proposalFactory.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "reject(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(proposalFactory.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "collect(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(proposalFactory.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "exists(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(proposalFactory.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "notExists(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(proposalFactory.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "forAll(e|" + marked + ")";
		if (s.startsWith(prefix)) {
			result.add(proposalFactory.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf(marked), marked.length()));
		}

		s = "[EClassifier]";
		if (s.startsWith(prefix)) {
			result.add(proposalFactory.createCollectionSpecificOperationProposal(s, s, prefix, s.indexOf("EClassifier"), "EClassifier".length()));
		}

		return result;
	}

	/**
	 * is public only for testing purposes
	 */
	public static class ExpressionSimpleAnalyzer {

		private final Set<Integer> operators = new HashSet<Integer>();
		{
			operators.add(XpandParsersym.TK_and);
			operators.add(XpandParsersym.TK_DIVIDE);
			operators.add(XpandParsersym.TK_DOT);
			operators.add(XpandParsersym.TK_EQUAL);
			operators.add(XpandParsersym.TK_GREATER_EQUAL);
			operators.add(XpandParsersym.TK_GREATER);
			operators.add(XpandParsersym.TK_LESS_EQUAL);
			operators.add(XpandParsersym.TK_LESS);
			operators.add(XpandParsersym.TK_MINUS);
			operators.add(XpandParsersym.TK_MULTIPLY);
			operators.add(XpandParsersym.TK_NOT_EQUAL);
			operators.add(XpandParsersym.TK_not);
			operators.add(XpandParsersym.TK_or);
			operators.add(XpandParsersym.TK_PLUS);
			operators.add(XpandParsersym.TK_ARROW);
		}

		private final Set<Integer> stopper = new HashSet<Integer>();
		{
			stopper.add(XpandParsersym.TK_LPAREN);
			stopper.add(XpandParsersym.TK_COLON);
			stopper.add(XpandParsersym.TK_QUESTIONMARK);
			stopper.add(XpandParsersym.TK_BAR);
			stopper.add(XpandParsersym.TK_LBRACE);
			stopper.add(XpandParsersym.TK_COMMA);
		}

		private final Set<Integer> methodNames = new HashSet<Integer>();
		{
// TODO: commented out due to the latest changed in OCL parser. Corresponding code have to be reviewed.
/*			
			methodNames.add(XpandParsersym.TK_IDENTIFIER);
			methodNames.add(XpandParsersym.TK_collect);
			methodNames.add(XpandParsersym.TK_exists);
			methodNames.add(XpandParsersym.TK_forAll);
			methodNames.add(XpandParsersym.TK_reject);
			methodNames.add(XpandParsersym.TK_select);
*/			
// methodNames.add(XpandParsersym.TK_typeSelect);
// TODO: commented out due to the latest changed in OCL parser. Corresponding code have to be reviewed.			
/*
			methodNames.add(XpandParsersym.TK_closure);
			methodNames.add(XpandParsersym.TK_any);
			methodNames.add(XpandParsersym.TK_one);
			methodNames.add(XpandParsersym.TK_collectNested);
			methodNames.add(XpandParsersym.TK_sortedBy);
			methodNames.add(XpandParsersym.TK_isUnique);
			methodNames.add(XpandParsersym.TK_iterate);
*/			
// TODO: commented out due to the latest changed in OCL parser. Corresponding code have to be reviewed.			
/*			methodNames.add(XpandParsersym.TK_oclIsKindOf);
			methodNames.add(XpandParsersym.TK_oclIsTypeOf);
			methodNames.add(XpandParsersym.TK_oclAsType);
			methodNames.add(XpandParsersym.TK_oclIsNew);
			methodNames.add(XpandParsersym.TK_oclIsUndefined);
			methodNames.add(XpandParsersym.TK_oclIsInvalid);
			methodNames.add(XpandParsersym.TK_oclIsInState);
			methodNames.add(XpandParsersym.TK_allInstances);*/
		}

		private final Set<Integer> operands = new HashSet<Integer>();
		{
			operands.add(XpandParsersym.TK_IDENTIFIER);
//			operands.add(XpandParsersym.TK_collect);
//			operands.add(XpandParsersym.TK_exists);
			operands.add(XpandParsersym.TK_false);
//			operands.add(XpandParsersym.TK_forAll);
			operands.add(XpandParsersym.TK_null);
//			operands.add(XpandParsersym.TK_reject);
//			operands.add(XpandParsersym.TK_select);
			operands.add(XpandParsersym.TK_true);
			operands.add(XpandParsersym.TK_self);
// operands.add(XpandParsersym.TK_typeSelect);
			operands.add(XpandParsersym.TK_INTEGER_LITERAL);
			operands.add(XpandParsersym.TK_REAL_LITERAL);
			operands.add(XpandParsersym.TK_STRING_LITERAL);
		}

		private final Map<Integer, Integer> blockTokens = new HashMap<Integer, Integer>();

		{
			blockTokens.put(XpandParsersym.TK_LPAREN, XpandParsersym.TK_RPAREN);
			blockTokens.put(XpandParsersym.TK_LBRACE, XpandParsersym.TK_RBRACE); // XXX braces as block tokens?
		}

		/**
		 * is public only for testing purposes
		 */
		public String[] computePrefixAndTargetExpression(final String str) {
			final ReverseScanner scanner = new ReverseScanner(str);
			String prefix = "";

			IToken t = scanner.previousToken();
			if (t != null) {
				// prefix consists of identifier parts
				if (!Character.isWhitespace(str.charAt(str.length() - 1))) {
					if (Character.isJavaIdentifierStart(t.toString().charAt(0))) {
						prefix = t.toString();
						t = scanner.previousToken(); // go to operator
					}
				}

				final int exprEnd = scanner.getOffset();
				// if t is a dot there is a target expression
				if (t != null && (t.getKind() == XpandParsersym.TK_DOT || t.getKind() == XpandParsersym.TK_ARROW)) {
					boolean lastWasOperator = true;
					boolean stop = false;
					while (!stop && (t = scanner.previousToken()) != null) {
						if (isOperand(t)) {
							if (lastWasOperator) {
								lastWasOperator = false;
							} else { // two operands in sequence -> stopper!
								scanner.nextToken();
								stop = true;
							}
						} else if (t.getKind() == XpandParsersym.TK_DOT || t.getKind() == XpandParsersym.TK_ARROW) {
							if (!lastWasOperator) {
								lastWasOperator = true;
							} else {
								// errorneous expression
								return new String[] { prefix, null };
							}
						} else if (isBlockCloser(t) && lastWasOperator) {
							lastWasOperator = false;
							final Stack<IToken> s = new Stack<IToken>();
							s.push(t);
							while (!s.isEmpty()) {
								final IToken temp = scanner.previousToken();
								if (temp == null) {
									return new String[] { prefix, null };
								}
								if (temp.getKind() == t.getKind()) {
									s.push(temp);
								} else if (isOpposite(temp, t)) {
									s.pop();
								}
							}
							if (t.getKind() == XpandParsersym.TK_RPAREN) {
								// we have an unambigous syntax here
								// a.method(with.param)
								// but also
								// anIdentifier
								// (another.parenthesized.expressions)
								final IToken temp = scanner.previousToken();
								if (!isMethodName(temp)) {
									scanner.nextToken();
								}
							}
						} else {
							scanner.nextToken(); // go one forward
							stop = true;
						}
					}
					return new String[] { prefix, str.substring(scanner.getOffset(), exprEnd).trim() };
				}
			}
			return new String[] { prefix, null };
		}

		private boolean isMethodName(final IToken temp) {
			return methodNames.contains(temp.getKind());
		}

		private boolean isOpposite(final IToken left, final IToken right) {
			final Integer temp = blockTokens.get(left.getKind());
			return (temp != null) && (right.getKind() == temp.intValue());
		}

		private boolean isBlockCloser(final IToken t) {
			return blockTokens.values().contains(t.getKind());
		}

		private boolean isOperand(final IToken t) {
			return operands.contains(t.getKind());
		}
	}
}
