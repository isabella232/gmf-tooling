/*
 * Copyright (c) 2006, 2009 Borland Software Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - Xpand language syntax
 *     Artem Tikhomirov (Borland) - LALR grammar
 *                                - Migration to OCL expressions
 */
package org.eclipse.gmf.internal.xpand.parser;

import java.text.StringCharacterIterator;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import lpg.runtime.BadParseException;
import lpg.runtime.BadParseSymFileException;
import lpg.runtime.DeterministicParser;
import lpg.runtime.DiagnoseParser;
import lpg.runtime.ErrorToken;
import lpg.runtime.IToken;
import lpg.runtime.LexStream;
import lpg.runtime.Monitor;
import lpg.runtime.NotDeterministicParseTableException;
import lpg.runtime.NullExportedSymbolsException;
import lpg.runtime.NullTerminalSymbolsException;
import lpg.runtime.ParseTable;
import lpg.runtime.PrsStream;
import lpg.runtime.RuleAction;
import lpg.runtime.TokenStream;
import lpg.runtime.UndefinedEofSymbolException;
import lpg.runtime.UnimplementedTerminalsException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.internal.xpand.ast.Advice;
import org.eclipse.gmf.internal.xpand.ast.Definition;
import org.eclipse.gmf.internal.xpand.ast.IfStatement;
import org.eclipse.gmf.internal.xpand.ast.Template;
import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.util.ParserException.ErrorLocationInfo;
import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeOperationCallExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ListLiteralExpCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS;
import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
import org.eclipse.m2m.internal.qvt.oml.cst.StatementCS;
import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
import org.eclipse.ocl.cst.BooleanLiteralExpCS;
import org.eclipse.ocl.cst.CSTFactory;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.CollectionRangeCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IfExpCS;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.InvalidLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.LiteralExpCS;
import org.eclipse.ocl.cst.NullLiteralExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.RealLiteralExpCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StringLiteralExpCS;
import org.eclipse.ocl.cst.TupleLiteralExpCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.UnlimitedNaturalLiteralExpCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.lpg.ProblemHandler;

public class XpandParser extends PrsStream implements RuleAction {

	private static ParseTable prs = new XpandParserprs();

	private DeterministicParser dtParser;

	public DeterministicParser getParser() {
		return dtParser;
	}

	private void setResult(Object object) {
		dtParser.setSym1(object);
	}

	public Object getRhsSym(int i) {
		return dtParser.getSym(i);
	}

	public int getRhsTokenIndex(int i) {
		return dtParser.getToken(i);
	}

	public IToken getRhsIToken(int i) {
		return super.getIToken(getRhsTokenIndex(i));
	}

	public int getRhsFirstTokenIndex(int i) {
		return dtParser.getFirstToken(i);
	}

	public IToken getRhsFirstIToken(int i) {
		return super.getIToken(getRhsFirstTokenIndex(i));
	}

	public int getRhsLastTokenIndex(int i) {
		return dtParser.getLastToken(i);
	}

	public IToken getRhsLastIToken(int i) {
		return super.getIToken(getRhsLastTokenIndex(i));
	}

	public int getLeftSpan() {
		return dtParser.getFirstToken();
	}

	public IToken getLeftIToken() {
		return super.getIToken(getLeftSpan());
	}

	public int getRightSpan() {
		return dtParser.getLastToken();
	}

	public IToken getRightIToken() {
		return super.getIToken(getRightSpan());
	}

	public int getRhsErrorTokenIndex(int i) {
		int index = dtParser.getToken(i);
		IToken err = super.getIToken(index);
		return (err instanceof ErrorToken ? index : 0);
	}

	public ErrorToken getRhsErrorIToken(int i) {
		int index = dtParser.getToken(i);
		IToken err = super.getIToken(index);
		return (ErrorToken) (err instanceof ErrorToken ? err : null);
	}

	public XpandParser(LexStream lexStream) {
		super(lexStream);
		xpandFactory = new XpandFactory(lexStream.getFileName());

		try {
			super.remapTerminalSymbols(orderedTerminalSymbols(), XpandParserprs.EOFT_SYMBOL);
		} catch (NullExportedSymbolsException e) {
		} catch (NullTerminalSymbolsException e) {
		} catch (UnimplementedTerminalsException e) {
			java.util.ArrayList<?> unimplemented_symbols = e.getSymbols();
			System.out.println("The Lexer will not scan the following token(s):");
			for (int i = 0; i < unimplemented_symbols.size(); i++) {
				Integer id = (Integer) unimplemented_symbols.get(i);
				System.out.println("    " + XpandParsersym.orderedTerminalSymbols[id.intValue()]);
			}
			System.out.println();
		} catch (UndefinedEofSymbolException e) {
			throw new Error(new UndefinedEofSymbolException("The Lexer does not implement the Eof symbol " + XpandParsersym.orderedTerminalSymbols[XpandParserprs.EOFT_SYMBOL]));
		}
	}

	public String[] orderedTerminalSymbols() {
		return XpandParsersym.orderedTerminalSymbols;
	}

	public String getTokenKindName(int kind) {
		return XpandParsersym.orderedTerminalSymbols[kind];
	}

	public int getEOFTokenKind() {
		return XpandParserprs.EOFT_SYMBOL;
	}

	public PrsStream getParseStream() {
		return (PrsStream) this;
	}

	public Template parser() {
		return parser(null, 0);
	}

	public Template parser(Monitor monitor) {
		return parser(monitor, 0);
	}

	public Template parser(int error_repair_count) {
		return parser(null, error_repair_count);
	}

	public Template parser(Monitor monitor, int error_repair_count) {
		try {
			resetErrors();
			dtParser = new DeterministicParser(monitor, (TokenStream) this, prs, (RuleAction) this);
		} catch (NotDeterministicParseTableException e) {
			throw new Error(new NotDeterministicParseTableException("Regenerate XpandParserprs.java with -NOBACKTRACK option"));
		} catch (BadParseSymFileException e) {
			throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- XpandParsersym.java. Regenerate XpandParserprs.java"));
		}

		try {
			return (Template) dtParser.parse();
		} catch (BadParseException e) {
			reset(e.error_token); // point to error token

			DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
			diagnoseParser.diagnose(e.error_token);
		}

		return null;
	}

	public ErrorLocationInfo[] getErrors() {
		return errors.toArray(new ErrorLocationInfo[errors.size()]);
	}

	private void resetErrors() {
		errors.clear();
	}

	private final List<ErrorLocationInfo> errors = new LinkedList<ErrorLocationInfo>();

	@Override
	public void reportError(int errorCode, int leftToken, int errorToken, int rightToken, String errorInfo[]) {
		StringBuilder sb = new StringBuilder("(");
		sb.append(errorCode);
		sb.append(") ");
		if (errorInfo != null) {
			for (int i = 0; i < errorInfo.length; i++) {
				if (sb.length() > 0) {
					sb.append("; ");
				}
				sb.append(errorInfo[i]);
			}
		}
		errors.add(new ErrorLocationInfo(sb.toString(), getLine(leftToken), getColumn(leftToken), getEndLine(rightToken), getEndColumn(rightToken)));
	}

	private final XpandFactory xpandFactory;

	/**
	 * A convenience method to obtain the text of a right hand side IToken.
	 * 
	 * @param i
	 *            the right hand side token index
	 * @result the text of the correspondent right hand side IToken.
	 * 
	 * @since 3.0
	 */
	protected String getRhsTokenText(int i) {
		return this.getTokenText(getRhsTokenIndex(i));
	}

	@SuppressWarnings("unchecked")
	private static final EList ourEmptyEList = new BasicEList.UnmodifiableEList(0, new Object[0]);

	private void diagnozeErrorToken(int token_index) {
		// IToken token = getIToken(token_index);
		// if (token instanceof lpg.runtime.ErrorToken) {
		// token = ((lpg.runtime.ErrorToken) token).getErrorToken();
		// }
		// reportError(lpg.runtime.ParseErrorCodes.MISPLACED_CODE,
		// token.getTokenIndex(), token.getTokenIndex(),
		// "'" +
		// token.toString() + "'");

		this.reset(token_index); // point to error token
		DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
		diagnoseParser.diagnose(token_index);
		setResult(null);
	}

	private ImperativeIterateExpCS createImperativeIterateExpCS(SimpleNameCS simpleNameCS, EList<VariableCS> iterators, VariableCS target, OCLExpressionCS body, OCLExpressionCS condition) {
		ImperativeIterateExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createImperativeIterateExpCS();
		result.setSimpleNameCS(simpleNameCS);
		if (iterators.size() > 0) {
			result.setVariable1(iterators.get(0));
			if (iterators.size() > 1) {
				result.setVariable2(iterators.get(1));
			}
		}
		if (target != null) {
			result.setTarget(target);
		}
		result.setBody(body);
		result.setCondition(condition);
		return result;
	}

	protected final CSTNode createCompleteSignatureCS(SimpleSignatureCS simpleSignatureCS, EList<ParameterDeclarationCS> resultList) {
		CompleteSignatureCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createCompleteSignatureCS();
		result.setSimpleSignature(simpleSignatureCS);
		result.getResultParams().addAll(resultList);
		return result;
	}

	protected final SimpleSignatureCS createSimpleSignatureCS(EList<ParameterDeclarationCS> paramsCS) {
		SimpleSignatureCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createSimpleSignatureCS();
		result.getParams().addAll(paramsCS);
		return result;
	}

	protected final ParameterDeclarationCS createParameterDeclarationCS(DirectionKindCS sym, IToken tokenText, TypeSpecCS typeSpecCS) {
		ParameterDeclarationCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createParameterDeclarationCS();
		SimpleNameCS nameCS = null;
		if (tokenText != null) {
			nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
			setOffsets(nameCS, tokenText);
		} else {
			//nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""); //$NON-NLS-1
		}
		result.setSimpleNameCS(nameCS);
		result.setTypeSpecCS(typeSpecCS);
		if (sym != null) {
			result.setDirectionKind(sym.getDirectionKind());
		}
		return result;
	}

	protected final CSTNode createLibraryImportCS(PathNameCS sym) {
		LibraryImportCS imp = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createLibraryImportCS();
		imp.setPathNameCS(sym);
		return imp;
	}

	protected final CSTNode createDirectionKindCS(DirectionKindEnum kind) {
		DirectionKindCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDirectionKindCS();
		result.setDirectionKind(kind);
		return result;
	}

	protected final TypeSpecCS createTypeSpecCS(TypeCS typeCS, IToken extentLocation) {
		TypeSpecCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTypeSpecCS();
		result.setTypeCS(typeCS);
		setOffsets(result, typeCS);
		if (extentLocation != null) {
			SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, extentLocation.toString());
			setOffsets(nameCS, extentLocation);
			result.setSimpleNameCS(nameCS);
			result.setEndOffset(extentLocation.getEndOffset());
		}
		return result;
	}

	private ListTypeCS createListTypeCS(TypeCS typeCS) {
		ListTypeCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createListTypeCS();
		result.setTypeCS(typeCS);
		return result;
	}

	private DictLiteralExpCS createDictLiteralExpCS(EList<DictLiteralPartCS> parts) {
		DictLiteralExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDictLiteralExpCS();
		result.getParts().addAll(parts);
		return result;
	}

	private DictionaryTypeCS createDictTypeCS(TypeCS keyTypeCS, TypeCS valueTypeCS) {
		DictionaryTypeCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDictionaryTypeCS();
		result.setKey(keyTypeCS);
		result.setValue(valueTypeCS);
		return result;
	}

	private DictLiteralPartCS createDictLiteralPartCS(LiteralExpCS keyLiteralCS, OCLExpressionCS valueExpCS) {
		DictLiteralPartCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDictLiteralPartCS();
		result.setKey(keyLiteralCS);
		result.setValue(valueExpCS);
		return result;
	}

	private final StatementCS createBreakCS() {
		StatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createBreakExpCS();
		return result;
	}

	private final StatementCS createContinueCS() {
		StatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createContinueExpCS();
		return result;
	}

	private ListLiteralExpCS createListLiteralExpCS(EList<CollectionLiteralPartCS> collectionLiteralParts) {
		ListLiteralExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createListLiteralExpCS();
		result.getCollectionLiteralParts().addAll(collectionLiteralParts);
		return result;
	}

	private boolean isTokenOfType(IToken token, int kind) {
		return (token != null) && (token.getKind() == kind);
	}

	private ImperativeOperationCallExpCS createFeatureFQNOperationCallExpCS(SimpleNameCS moduleName, SimpleNameCS operationName, EList<OCLExpressionCS> arguments) {
		ImperativeOperationCallExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createImperativeOperationCallExpCS();
		return setupImperativeOperationCallExpCS(moduleName, operationName, arguments, result);
	}

	private OperationCallExpCS createDotOperationCallExpCS(OCLExpressionCS oclExpressionCS, PathNameCS pathNameCs, SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS,
			EList<OCLExpressionCS> arguments) {
		if (pathNameCs != null && pathNameCs.getSimpleNames().size() == 1) {
			ImperativeOperationCallExpCS result = createFeatureFQNOperationCallExpCS(pathNameCs.getSimpleNames().get(0), simpleNameCS, arguments);
			if (oclExpressionCS != null) {
				result.setSource(oclExpressionCS);
				result.setIsAtomic(true);
			}
			result.setAccessor(oclExpressionCS != null ? DotOrArrowEnum.DOT_LITERAL : DotOrArrowEnum.NONE_LITERAL);
			if (isAtPre(isMarkedPreCS)) {
				result.setIsMarkedPreCS(isMarkedPreCS);
			}
			return result;
		}
		OperationCallExpCS result = createOperationCallExpCS(oclExpressionCS, DotOrArrowEnum.DOT_LITERAL, pathNameCs, simpleNameCS, isMarkedPreCS, arguments);
		if (oclExpressionCS != null) {
			result.setIsAtomic(true);
		}
		return result;
	}

	private ImperativeOperationCallExpCS setupImperativeOperationCallExpCS(SimpleNameCS moduleName, SimpleNameCS operationName, EList<OCLExpressionCS> arguments, ImperativeOperationCallExpCS result) {
		result.setModule(moduleName);
		result.setSimpleNameCS(operationName);
		result.getArguments().addAll(arguments);
		return result;
	}

	protected VariableCS createVariableCS(IToken token, TypeCS typeCS, OCLExpressionCS oclExpressionCS) {
		VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
		result.setName(unSingleQuote(token));
		result.setTypeCS(typeCS);
		result.setInitExpression(oclExpressionCS);
		return result;
	}

	private OperationCallExpCS createArrowOperationCallExpCS(OCLExpressionCS oclExpressionCS, SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS, EList<OCLExpressionCS> arguments) {
		return createOperationCallExpCS(oclExpressionCS, DotOrArrowEnum.ARROW_LITERAL, null, simpleNameCS, isMarkedPreCS, arguments);
	}

	private OperationCallExpCS createOperationCallExpCS(OCLExpressionCS oclExpressionCS, DotOrArrowEnum dotOrArrow, PathNameCS pathNameCS, SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS,
			EList<OCLExpressionCS> arguments) {
		OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
		result.setSource(oclExpressionCS);
		result.setAccessor(oclExpressionCS != null ? dotOrArrow : DotOrArrowEnum.NONE_LITERAL);
		result.setPathNameCS((pathNameCS != null) && (pathNameCS.getSimpleNames().size() > 0) ? pathNameCS : null);
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);

		if (isAtPre(isMarkedPreCS)) {
			result.setIsMarkedPreCS(isMarkedPreCS);
		}

		return result;
	}

	private OperationCallExpCS createOperationCallExpCS(OCLExpressionCS oclExpressionCS, SimpleNameCS simpleNameCS, EList<OCLExpressionCS> arguments) {
		return createOperationCallExpCS(oclExpressionCS, null, null, simpleNameCS, null, arguments);
	}

	private VariableExpCS createVariableExpCS(SimpleNameCS simpleNameCS, EList<OCLExpressionCS> arguments, IsMarkedPreCS isMarkedPreCS) {
		VariableExpCS result = CSTFactory.eINSTANCE.createVariableExpCS();
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);
		result.setIsMarkedPreCS(isMarkedPreCS);
		return result;
	}

	private SimpleNameCS createSimpleNameCS(SimpleTypeEnum type, String value) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(type);
		result.setValue(unquote(value));
		return result;
	}

	private PrimitiveTypeCS createPrimitiveTypeCS(SimpleTypeEnum type, String value) {
		PrimitiveTypeCS result = CSTFactory.eINSTANCE.createPrimitiveTypeCS();
		result.setType(type);
		result.setValue(value);
		return result;
	}

	private PathNameCS createPathNameCS(SimpleNameCS name) {
		PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
		result.getSimpleNames().add(name);
		return result;
	}

	private PathNameCS extendPathNameCS(PathNameCS path, SimpleNameCS name) {
		path.getSimpleNames().add(name);
		return path;
	}

	private CollectionLiteralExpCS createCollectionLiteralExpCS(CollectionTypeCS typeCS, EList<CollectionLiteralPartCS> collectionLiteralParts) {
		CollectionLiteralExpCS result = CSTFactory.eINSTANCE.createCollectionLiteralExpCS();
		result.setCollectionType(typeCS.getCollectionTypeIdentifier());
		result.getCollectionLiteralParts().addAll(collectionLiteralParts);
		return result;
	}

	private CollectionLiteralPartCS createCollectionLiteralPartCS(OCLExpressionCS oclExpressionCS) {
		CollectionLiteralPartCS result = CSTFactory.eINSTANCE.createCollectionLiteralPartCS();
		result.setExpressionCS(oclExpressionCS);
		return result;
	}

	private CollectionRangeCS createCollectionRangeCS(OCLExpressionCS oclExpressionCS, OCLExpressionCS lastOCLExpressionCS) {
		CollectionRangeCS result = CSTFactory.eINSTANCE.createCollectionRangeCS();
		result.setExpressionCS(oclExpressionCS);
		result.setLastExpressionCS(lastOCLExpressionCS);
		return result;
	}

	private TupleLiteralExpCS createTupleLiteralExpCS(EList<VariableCS> variables) {
		TupleLiteralExpCS result = CSTFactory.eINSTANCE.createTupleLiteralExpCS();
		result.getVariables().addAll(variables);
		return result;
	}

	private IntegerLiteralExpCS createIntegerLiteralExpCS(String string) {
		IntegerLiteralExpCS result = CSTFactory.eINSTANCE.createIntegerLiteralExpCS();
		result.setSymbol(string);
		result.setIntegerSymbol(Integer.valueOf(string));
		return result;
	}

	@SuppressWarnings("nls")
	private UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS(String string) {
		UnlimitedNaturalLiteralExpCS result = CSTFactory.eINSTANCE.createUnlimitedNaturalLiteralExpCS();
		result.setSymbol(string);
		if ("*".equals(string)) {
			result.setIntegerSymbol(-1);
		} else {
			result.setIntegerSymbol(Integer.valueOf(string));
		}
		return result;
	}

	private RealLiteralExpCS createRealLiteralExpCS(String string) {
		RealLiteralExpCS result = CSTFactory.eINSTANCE.createRealLiteralExpCS();
		result.setSymbol(string);
		result.setRealSymbol(Double.valueOf(string));
		return result;
	}

	private BooleanLiteralExpCS createBooleanLiteralExpCS(String string) {
		BooleanLiteralExpCS result = CSTFactory.eINSTANCE.createBooleanLiteralExpCS();
		result.setSymbol(string);
		result.setBooleanSymbol(Boolean.valueOf(string));
		return result;
	}

	private NullLiteralExpCS createNullLiteralExpCS(String string) {
		NullLiteralExpCS result = CSTFactory.eINSTANCE.createNullLiteralExpCS();
		result.setValue(string);
		result.setType(SimpleTypeEnum.KEYWORD_LITERAL);
		return result;
	}

	private InvalidLiteralExpCS createInvalidLiteralExpCS(String string) {
		InvalidLiteralExpCS result = CSTFactory.eINSTANCE.createInvalidLiteralExpCS();
		result.setValue(string);
		result.setType(SimpleTypeEnum.KEYWORD_LITERAL);
		return result;
	}

	protected IteratorExpCS createIteratorExpCS(OCLExpressionCS source, SimpleNameCS simpleNameCS, VariableCS variable1, VariableCS variable2, OCLExpressionCS oclExpressionCS) {
		IteratorExpCS result = CSTFactory.eINSTANCE.createIteratorExpCS();
		result.setSource(source);
		result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	protected IterateExpCS createIterateExpCS(OCLExpressionCS source, SimpleNameCS simpleNameCS, VariableCS variable1, VariableCS variable2, OCLExpressionCS oclExpressionCS) {
		IterateExpCS result = CSTFactory.eINSTANCE.createIterateExpCS();
		result.setSource(source);
		result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
		result.setSimpleNameCS(simpleNameCS);
		result.setVariable1(variable1);
		result.setVariable2(variable2);
		result.setBody(oclExpressionCS);
		return result;
	}

	private VariableCS createVariableCS(String varName, TypeCS typeCS, OCLExpressionCS oclExpressionCS) {
		VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
		result.setName(unquote(varName));
		result.setTypeCS(typeCS);
		result.setInitExpression(oclExpressionCS);
		return result;
	}

	private VariableCS createVariableCS(SimpleNameCS varName, TypeCS typeCS, OCLExpressionCS oclExpressionCS) {
		VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
		result.setName(unquote(varName.getValue()));
		result.setTypeCS(typeCS);
		result.setInitExpression(oclExpressionCS);
		return result;
	}

	protected CollectionTypeCS createCollectionTypeCS(CollectionTypeIdentifierEnum collectionType, String value) {
		CollectionTypeCS result = CSTFactory.eINSTANCE.createCollectionTypeCS();
		result.setType(SimpleTypeEnum.IDENTIFIER_LITERAL);
		result.setValue(unquote(value));
		result.setCollectionTypeIdentifier(collectionType);
		return result;
	}

	private TupleTypeCS createTupleTypeCS(EList<VariableCS> variables) {
		TupleTypeCS result = CSTFactory.eINSTANCE.createTupleTypeCS();
		result.getVariables().addAll(variables);
		return result;
	}

	private FeatureCallExpCS createFeatureCallExpCS(OCLExpressionCS source, PathNameCS pathNameCS, SimpleNameCS simpleNameCS, EList<OCLExpressionCS> arguments, IsMarkedPreCS isMarkedPreCS) {
		FeatureCallExpCS result = CSTFactory.eINSTANCE.createFeatureCallExpCS();
		result.setSource(source);
		result.setAccessor(source != null ? DotOrArrowEnum.DOT_LITERAL : DotOrArrowEnum.NONE_LITERAL);
		result.setPathNameCS((pathNameCS != null) && (pathNameCS.getSimpleNames().size() > 0) ? pathNameCS : null);
		result.setSimpleNameCS(simpleNameCS);
		result.getArguments().addAll(arguments);

		if (isAtPre(isMarkedPreCS)) {
			result.setIsMarkedPreCS(isMarkedPreCS);
		}

		return result;
	}

	private LetExpCS createLetExpCS(EList<VariableCS> variables, OCLExpressionCS oclExpressionCS) {
		LetExpCS result = CSTFactory.eINSTANCE.createLetExpCS();
		result.getVariables().addAll(variables);
		result.setInExpression(oclExpressionCS);
		return result;
	}

	private IfExpCS createIfExpCS(OCLExpressionCS condition, OCLExpressionCS thenExpression, OCLExpressionCS elseExpression) {
		IfExpCS result = CSTFactory.eINSTANCE.createIfExpCS();
		result.setCondition(condition);
		result.setThenExpression(thenExpression);
		result.setElseExpression(elseExpression);
		return result;
	}

	protected SimpleNameCS createConceptualOperationNameCS(IToken token) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(SimpleTypeEnum.KEYWORD_LITERAL);
		String conceptualName = token.toString();
		result.setValue(conceptualName);
		ProblemHandler.Severity sev = ProblemHandler.Severity.OK;
		/*
		 * [AS]: TODO log error here
		 * 
		 * BasicEnvironment benv = getEnvironment(); if (benv != null) { sev =
		 * benv.getValue(ProblemOption.CONCEPTUAL_OPERATION_NAME); }
		 * 
		 * if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
		 * benv.problem(sev, ProblemHandler.Phase.PARSER, OCLMessages
		 * .bind(OCLMessages.Conceptual_Operation_Name_, conceptualName),
		 * "unquote", //-NLS-1 token); }
		 */
		return result;
	}

	protected SimpleNameCS createSimpleNameCS(SimpleTypeEnum type, IToken token) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(type);
		result.setValue(unDoubleQuote(token));
		return result;
	}

	protected StringLiteralExpCS createStringLiteralExpCS(IToken token) {
		StringLiteralExpCS result = CSTFactory.eINSTANCE.createStringLiteralExpCS();
		String unquoted = unSingleQuote(token);
		result.setSymbol(unquoted);
		result.setStringSymbol(unquoted);
		result.setUnescapedStringSymbol(unquoted);
		return result;
	}

	protected StringLiteralExpCS extendStringLiteralExpCS(StringLiteralExpCS string, IToken token) {
		String oldString = string.getUnescapedStringSymbol();
		String newString = unSingleQuote(token);
		int oldFinish = string.getEndOffset();
		int newStart = token.getStartOffset();
		String joinedString;
		if (newStart - oldFinish > 1) {
			joinedString = oldString + newString;
		} else {
			joinedString = oldString + '\'' + newString;
			/*
			 * [AS]: TODO log error here ProblemHandler.Severity sev =
			 * getEnvironment().getValue(
			 * ProblemOption.STRING_SINGLE_QUOTE_ESCAPE); if ((sev != null) &&
			 * (sev != ProblemHandler.Severity.OK)) { getEnvironment().problem(
			 * sev, ProblemHandler.Phase.PARSER,
			 * OCLMessages.bind(OCLMessages.NonStd_SQuote_Escape_,
			 * joinedString), "STRING_LITERAL", //-NLS-1 joinedString); }
			 */
		}
		string.setSymbol(joinedString);
		string.setStringSymbol(joinedString);
		string.setUnescapedStringSymbol(joinedString);
		return string;
	}

	protected Set<String> iteratorNames = null;

	@SuppressWarnings("nls")
	protected Set<String> createIteratorNames() {
		Set<String> iteratorNames = new HashSet<String>();
		iteratorNames.add("any");
		iteratorNames.add("collect");
		iteratorNames.add("collectNested");
		iteratorNames.add("exists");
		iteratorNames.add("forAll");
		iteratorNames.add("isUnique");
		iteratorNames.add("one");
		iteratorNames.add("reject");
		iteratorNames.add("select");
		iteratorNames.add("sortedBy");

		iteratorNames.add("closure");
		return iteratorNames;
	}

	protected boolean isIterator(String name) {
		if (iteratorNames == null) {
			iteratorNames = createIteratorNames();
		}
		return iteratorNames.contains(name);
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start and end offsets of the given <code>IToken</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param startEnd
	 *            <code>IToken</code> to retrieve offsets from
	 */
	private void setOffsets(CSTNode cstNode, IToken startEnd) {
		cstNode.setStartOffset(startEnd.getStartOffset());
		cstNode.setEndOffset(startEnd.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start and end offsets of the 2nd given <code>CSTNode</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param startEnd
	 *            <code>CSTNode</code> to retrieve offsets from
	 */
	private void setOffsets(CSTNode cstNode, CSTNode startEnd) {
		cstNode.setStartOffset(startEnd.getStartOffset());
		cstNode.setEndOffset(startEnd.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start offset of the 2nd given <code>CSTNode</code> and the end offset of
	 * the 3rd given <code>CSTNode</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param start
	 *            <code>CSTNode</code> to retrieve start offset from
	 * @param end
	 *            <code>CSTNode</code> to retrieve end offset from
	 */
	private void setOffsets(CSTNode cstNode, CSTNode start, CSTNode end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start offset of the 2nd given <code>CSTNode</code> and the end offset of
	 * the given <code>IToken</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param start
	 *            <code>CSTNode</code> to retrieve start offset from
	 * @param end
	 *            <code>IToken</code> to retrieve end offset from
	 */
	private void setOffsets(CSTNode cstNode, CSTNode start, IToken end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start offset of the given <code>IToken</code> and the end offset of the
	 * 2nd given <code>CSTNode</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param start
	 *            <code>IToken</code> to retrieve start offset from
	 * @param end
	 *            <code>CSTNode</code> to retrieve end offset from
	 */
	private void setOffsets(CSTNode cstNode, IToken start, CSTNode end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Sets the start and end offsets of the given <code>CSTNode</code> to the
	 * start offset of the 1std given <code>IToken</code> and the end offset of
	 * the 2nd given <code>IToken</code>
	 * 
	 * @param cstNode
	 *            <code>CSTNode</code> to set offsets
	 * @param start
	 *            <code>IToken</code> to retrieve start offset from
	 * @param end
	 *            <code>IToken</code> to retrieve end offset from
	 */
	private void setOffsets(CSTNode cstNode, IToken start, IToken end) {
		cstNode.setStartOffset(start.getStartOffset());
		cstNode.setEndOffset(end.getEndOffset());
	}

	/**
	 * Removes the "s surrounding a quoted string, if any.
	 * 
	 * @param quoted
	 *            a possibly quoted string
	 * @return <code>quoted</code> without the surrounding quotes, or just
	 *         <code>quoted</code> verbatim if there were none
	 */
	private String unquote(String quoted) {
		String result = quoted;

		if ((result != null) && (result.length() > 1)) {
			int max = result.length() - 1;

			if ((result.charAt(0) == '"') && (quoted.charAt(max) == '"')) {
				result = result.substring(1, max);
			}

			// this is a regexp, so the backslash needs to be
			// re-escaped, thus "\\" is rendered in a Java
			// string literal as "\\\\"
			result = result.replaceAll("\\\\\"", "\""); // -NLS-2//-NLS-1
			/*
			 * [artem] removed extra error handling fon non-spec escape
			 * processing
			 */
		}

		return result;
	}

	private boolean isAtPre(IsMarkedPreCS atPreCS) {
		return atPreCS != null;
	}

	protected String unDoubleQuote(IToken token) {
		if (token == null) {
			return null;
		}
		String quoted = token.toString();
		if (quoted == null) {
			return null;
		}
		int quotedLength = quoted.length();
		if ((quotedLength < 2) || (quoted.charAt(0) != '"') || (quoted.charAt(quotedLength - 1) != '"')) {
			return quoted;
		}
		ProblemHandler.Severity sev = ProblemHandler.Severity.OK;
		/*
		 * BasicEnvironment benv = getEnvironment();
		 * 
		 * if (benv != null) { sev = benv
		 * .getValue(ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE); } if ((sev !=
		 * null) && (sev != ProblemHandler.Severity.OK)) { benv.problem(sev,
		 * ProblemHandler.Phase.PARSER, OCLMessages
		 * .bind(OCLMessages.NonStd_DQuote_Escape_, quoted), "unquote", //-NLS-1
		 * token); }
		 */
		return decodeString(token, quoted.substring(1, quotedLength - 1));
	}

	protected String unSingleQuote(IToken token) {
		if (token == null) {
			return null;
		}
		String quoted = token.toString();
		if (quoted == null) {
			return null;
		}
		int quotedLength = quoted.length();
		if ((quotedLength < 2) || (quoted.charAt(0) != '\'') || (quoted.charAt(quotedLength - 1) != '\'')) {
			return quoted;
		}
		String unquoted = quoted.substring(1, quotedLength - 1);
		Boolean backslashProcessingEnabled = true;
		/*
		 * BasicEnvironment benv = getEnvironment(); if (benv != null) {
		 * backslashProcessingEnabled = benv
		 * .getValue(ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING); }
		 */
		if ((backslashProcessingEnabled == null) || !backslashProcessingEnabled) {
			return unquoted;
		}
		return decodeString(token, unquoted);
	}

	protected String decodeString(IToken token, String string) {
		if (string.indexOf('\\') < 0) {
			return string;
		}
		StringBuffer s = new StringBuffer();
		StringCharacterIterator i = new StringCharacterIterator(string);
		for (char c = i.first(); c != StringCharacterIterator.DONE; c = i.next()) {
			if (c != '\\') {
				s.append(c);
			} else {
				int iStart = i.getIndex();
				char ch = decodeEscapeSequence(i);
				if (ch != StringCharacterIterator.DONE) {
					s.append(ch);
				} else {
					/*
					 * [AS]: TODO: report error here
					 * 
					 * BasicEnvironment benv = getEnvironment();
					 * benv.problem(ProblemHandler.Severity.ERROR,
					 * ProblemHandler.Phase.PARSER, OCLMessages
					 * .bind(OCLMessages.InvalidEscapeSequence_ERROR,
					 * string.substring(iStart, i.getIndex())), "unquote",
					 * //-NLS-1 token);
					 */
					return string;
				}
			}
		}
		return s.toString();
	}

	protected char decodeEscapeSequence(StringCharacterIterator i) {
		int savedIndex = i.getIndex();
		char c = i.next();
		switch (c) {
		case 'b':
			return '\b';
		case 'f':
			return '\f';
		case 't':
			return '\t';
		case 'n':
			return '\n';
		case 'r':
			return '\r';
		case '\\':
			return '\\';
		case '\'':
			return '\'';
		case '"':
			return '\"';
		case '0':
		case '1':
		case '2':
		case '3': {
			int c1 = c - '0';
			int c2 = decodeOctalCharacter(i);
			if (c2 < 0) {
				return (char) (c1);
			}
			int c3 = decodeOctalCharacter(i);
			if (c3 < 0) {
				return (char) ((c1 << 3) + c2);
			}
			return (char) ((c1 << 6) + (c2 << 3) + c3);
		}
		case '4':
		case '5':
		case '6':
		case '7': {
			int c1 = c - '0';
			int c2 = decodeOctalCharacter(i);
			if (c2 < 0) {
				i.previous();
				return (char) (c1);
			}
			return (char) ((c1 << 3) + c2);
		}
		case 'x': {
			int c1 = decodeHexCharacter(i.next());
			int c2 = decodeHexCharacter(i.next());
			if ((c1 < 0) || (c2 < 0)) {
				break;
			}
			return (char) ((c1 << 4) + c2);
		}
		case 'u': {
			int c1 = decodeHexCharacter(i.next());
			int c2 = decodeHexCharacter(i.next());
			int c3 = decodeHexCharacter(i.next());
			int c4 = decodeHexCharacter(i.next());
			if ((c1 < 0) || (c2 < 0) || (c3 < 0) || (c4 < 0)) {
				break;
			}
			return (char) ((c1 << 12) + (c2 << 8) + (c3 << 4) + c4);
		}
		}
		i.setIndex(savedIndex); // Give derived augmentations the same starting
								// point
		return StringCharacterIterator.DONE;
	}

	protected int decodeOctalCharacter(StringCharacterIterator i) {
		char c = i.next();
		if (c == StringCharacterIterator.DONE) {
			return -1;
		}
		if (('0' <= c) && (c <= '7')) {
			return c - '0';
		}
		i.previous();
		return -1;
	}

	protected int decodeHexCharacter(char c) {
		if (('0' <= c) && (c <= '9')) {
			return c - '0';
		}
		if (('A' <= c) && (c <= 'F')) {
			return 10 + c - 'A';
		}
		if (('a' <= c) && (c <= 'f')) {
			return 10 + c - 'a';
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	public void ruleAction(int ruleNumber) {
		switch (ruleNumber) {

		//
		// Rule 16: conceptualOperationNameCS ::= conceptualOperationName
		//
		case 16: {

			IToken iToken = getRhsIToken(1);
			SimpleNameCS result = createConceptualOperationNameCS(iToken);
			setOffsets(result, iToken);
			setResult(result);
			break;
		}

			//
			// Rule 28: tupleKeywordCS ::= Tuple
			//
		case 28:

			//
			// Rule 32: selfKeywordCS ::= self
			//
		case 32: {

			IToken iToken = getRhsIToken(1);
			SimpleNameCS result = createSimpleNameCS(SimpleTypeEnum.SELF_LITERAL, iToken);
			setOffsets(result, iToken);
			setResult(result);
			break;
		}

			//
			// Rule 33: simpleNameCS ::= IDENTIFIER
			//
		case 33: {

			IToken iToken = getRhsIToken(1);
			SimpleNameCS result = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, iToken);
			setOffsets(result, iToken);
			setResult(result);
			break;
		}

			//
			// Rule 36: pathNameCS ::= simpleNameCS
			//
		case 36: {

			SimpleNameCS simpleName = (SimpleNameCS) getRhsSym(1);
			PathNameCS result = createPathNameCS(simpleName);
			setOffsets(result, simpleName);
			setResult(result);
			break;
		}

			//
			// Rule 37: pathNameCS ::= pathNameCS :: unreservedSimpleNameCS
			//
		case 37: {

			PathNameCS result = (PathNameCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			result = extendPathNameCS(result, simpleNameCS);
			setOffsets(result, result, simpleNameCS);
			setResult(result);
			break;
		}

			//
			// Rule 38: primitiveTypeCS ::= Boolean
			//
		case 38: {

			PrimitiveTypeCS result = createPrimitiveTypeCS(SimpleTypeEnum.BOOLEAN_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 39: primitiveTypeCS ::= Integer
			//
		case 39: {

			PrimitiveTypeCS result = createPrimitiveTypeCS(SimpleTypeEnum.INTEGER_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 40: primitiveTypeCS ::= Real
			//
		case 40: {

			PrimitiveTypeCS result = createPrimitiveTypeCS(SimpleTypeEnum.REAL_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 41: primitiveTypeCS ::= String
			//
		case 41: {

			PrimitiveTypeCS result = createPrimitiveTypeCS(SimpleTypeEnum.STRING_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 42: primitiveTypeCS ::= UnlimitedNatural
			//
		case 42: {

			PrimitiveTypeCS result = createPrimitiveTypeCS(SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 43: primitiveTypeCS ::= OclAny
			//
		case 43: {

			PrimitiveTypeCS result = createPrimitiveTypeCS(SimpleTypeEnum.OCL_ANY_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 44: primitiveTypeCS ::= OclInvalid
			//
		case 44: {

			PrimitiveTypeCS result = createPrimitiveTypeCS(SimpleTypeEnum.OCL_INVALID_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 45: primitiveTypeCS ::= OclVoid
			//
		case 45: {

			PrimitiveTypeCS result = createPrimitiveTypeCS(SimpleTypeEnum.OCL_VOID_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 46: CollectionTypeIdentifierCS ::= Set
			//
		case 46: {

			SimpleNameCS result = createCollectionTypeCS(CollectionTypeIdentifierEnum.SET_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 47: CollectionTypeIdentifierCS ::= Bag
			//
		case 47: {

			SimpleNameCS result = createCollectionTypeCS(CollectionTypeIdentifierEnum.BAG_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 48: CollectionTypeIdentifierCS ::= Sequence
			//
		case 48: {

			SimpleNameCS result = createCollectionTypeCS(CollectionTypeIdentifierEnum.SEQUENCE_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 49: CollectionTypeIdentifierCS ::= Collection
			//
		case 49: {

			SimpleNameCS result = createCollectionTypeCS(CollectionTypeIdentifierEnum.COLLECTION_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 50: CollectionTypeIdentifierCS ::= OrderedSet
			//
		case 50: {

			SimpleNameCS result = createCollectionTypeCS(CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL, getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 55: collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS
			// )
			//
		case 55: {

			CollectionTypeCS result = (CollectionTypeCS) getRhsSym(1);
			result.setTypeCS((TypeCS) getRhsSym(3));
			setOffsets(result, result, getRhsIToken(4));
			setResult(result);
			break;
		}

			//
			// Rule 56: tupleTypeCS ::= Tuple ( tupleTypePartsCSopt )
			//
		case 56: {

			TupleTypeCS result = createTupleTypeCS((EList<VariableCS>) getRhsSym(3));
			setOffsets(result, getRhsIToken(1), getRhsIToken(4));
			setResult(result);
			break;
		}

			//
			// Rule 57: tupleTypePartsCSopt ::= $Empty
			//
		case 57: {

			setResult(new BasicEList<VariableCS>());
			break;
		}

			//
			// Rule 59: tupleTypePartsCS ::= typedUninitializedVariableCS
			//
		case 59: {

			EList<VariableCS> result = new BasicEList<VariableCS>();
			result.add((VariableCS) getRhsSym(1));
			setResult(result);
			break;
		}

			//
			// Rule 60: tupleTypePartsCS ::= tupleTypePartsCS ,
			// typedUninitializedVariableCS
			//
		case 60: {

			EList<VariableCS> result = (EList<VariableCS>) getRhsSym(1);
			result.add((VariableCS) getRhsSym(3));
			setResult(result);
			break;
		}

			//
			// Rule 61: untypedUninitializedVariableCS ::= simpleNameCS
			//
		case 61: {

			SimpleNameCS name = (SimpleNameCS) getRhsSym(1);
			VariableCS result = createVariableCS(name, null, null);
			setOffsets(result, name);
			setResult(result);
			break;
		}

			//
			// Rule 62: typedUninitializedVariableCS ::= simpleNameCS : typeCS
			//
		case 62: {

			SimpleNameCS name = (SimpleNameCS) getRhsSym(1);
			TypeCS type = (TypeCS) getRhsSym(3);
			VariableCS result = createVariableCS(name, type, null);
			setOffsets(result, name, type);
			setResult(result);
			break;
		}

			//
			// Rule 63: untypedInitializedVariableCS ::= simpleNameCS =
			// OclExpressionCS
			//
		case 63: {

			SimpleNameCS name = (SimpleNameCS) getRhsSym(1);
			OCLExpressionCS initExpression = (OCLExpressionCS) getRhsSym(3);
			VariableCS result = createVariableCS(name, null, initExpression);
			setOffsets(result, name, initExpression);
			setResult(result);
			break;
		}

			//
			// Rule 64: typedInitializedVariableCS ::= simpleNameCS : typeCS =
			// OclExpressionCS
			//
		case 64: {

			SimpleNameCS name = (SimpleNameCS) getRhsSym(1);
			TypeCS type = (TypeCS) getRhsSym(3);
			OCLExpressionCS initExpression = (OCLExpressionCS) getRhsSym(5);
			VariableCS result = createVariableCS(name, type, initExpression);
			setOffsets(result, name, initExpression);
			setResult(result);
			break;
		}

			//
			// Rule 77: CollectionLiteralExpCS ::= CollectionTypeIdentifierCS {
			// CollectionLiteralPartsCSopt }
			//
		case 77: {

			CollectionTypeCS typeCS = (CollectionTypeCS) getRhsSym(1);
			CollectionLiteralExpCS result = createCollectionLiteralExpCS(typeCS, (EList<CollectionLiteralPartCS>) getRhsSym(3));
			setOffsets(result, typeCS, getRhsIToken(4));
			setResult(result);
			break;
		}

			//
			// Rule 78: CollectionLiteralPartsCSopt ::= $Empty
			//
		case 78: {

			setResult(new BasicEList<CollectionLiteralPartCS>());
			break;
		}

			//
			// Rule 80: CollectionLiteralPartsCS ::= CollectionLiteralPartCS
			//
		case 80: {

			EList<CollectionLiteralPartCS> result = new BasicEList<CollectionLiteralPartCS>();
			result.add((CollectionLiteralPartCS) getRhsSym(1));
			setResult(result);
			break;
		}

			//
			// Rule 81: CollectionLiteralPartsCS ::= CollectionLiteralPartsCS ,
			// CollectionLiteralPartCS
			//
		case 81: {

			EList<CollectionLiteralPartCS> result = (EList<CollectionLiteralPartCS>) getRhsSym(1);
			result.add((CollectionLiteralPartCS) getRhsSym(3));
			setResult(result);
			break;
		}

			//
			// Rule 83: CollectionLiteralPartCS ::= OclExpressionCS
			//
		case 83: {

			CollectionLiteralPartCS result = createCollectionLiteralPartCS((OCLExpressionCS) getRhsSym(1));
			setOffsets(result, (CSTNode) getRhsSym(1));
			setResult(result);
			break;
		}

			//
			// Rule 84: CollectionRangeCS ::= OclExpressionCS .. OclExpressionCS
			//
		case 84: {

			CollectionLiteralPartCS result = createCollectionRangeCS((OCLExpressionCS) getRhsSym(1), (OCLExpressionCS) getRhsSym(3));
			setOffsets(result, (CSTNode) getRhsSym(1), (CSTNode) getRhsSym(3));
			setResult(result);
			break;
		}

			//
			// Rule 92: TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
			//
		case 92: {

			TupleLiteralExpCS result = createTupleLiteralExpCS((EList<VariableCS>) getRhsSym(3));
			setOffsets(result, getRhsIToken(1), getRhsIToken(4));
			setResult(result);
			break;
		}

			//
			// Rule 93: TupleLiteralPartsCS ::= initializedVariableCS
			//
		case 93: {

			EList<VariableCS> result = new BasicEList<VariableCS>();
			result.add((VariableCS) getRhsSym(1));
			setResult(result);
			break;
		}

			//
			// Rule 94: TupleLiteralPartsCS ::= TupleLiteralPartsCS ,
			// initializedVariableCS
			//
		case 94: {

			EList<VariableCS> result = (EList<VariableCS>) getRhsSym(1);
			result.add((VariableCS) getRhsSym(3));
			setResult(result);
			break;
		}

			//
			// Rule 95: IntegerLiteralExpCS ::= INTEGER_LITERAL
			//
		case 95: {

			IntegerLiteralExpCS result = createIntegerLiteralExpCS(getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 96: RealLiteralExpCS ::= REAL_LITERAL
			//
		case 96: {

			RealLiteralExpCS result = createRealLiteralExpCS(getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 97: StringLiteralExpCS ::= STRING_LITERAL
			//
		case 97: {

			IToken literalToken = getRhsIToken(1);
			StringLiteralExpCS result = createStringLiteralExpCS(literalToken);
			setOffsets(result, literalToken);
			setResult(result);
			break;
		}

			//
			// Rule 98: StringLiteralExpCS ::= StringLiteralExpCS STRING_LITERAL
			//
		case 98: {

			StringLiteralExpCS string = (StringLiteralExpCS) getRhsSym(1);
			IToken literalToken = getRhsIToken(2);
			StringLiteralExpCS result = extendStringLiteralExpCS(string, literalToken);
			setOffsets(result, string, literalToken);
			setResult(result);
			break;
		}

			//
			// Rule 99: BooleanLiteralExpCS ::= true
			//
		case 99: {

			BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 100: BooleanLiteralExpCS ::= false
			//
		case 100: {

			BooleanLiteralExpCS result = createBooleanLiteralExpCS(getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 101: UnlimitedNaturalLiteralExpCS ::= *
			//
		case 101: {

			UnlimitedNaturalLiteralExpCS result = createUnlimitedNaturalLiteralExpCS(getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 102: InvalidLiteralExpCS ::= invalid
			//
		case 102: {

			InvalidLiteralExpCS result = createInvalidLiteralExpCS(getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 103: NullLiteralExpCS ::= null
			//
		case 103: {

			NullLiteralExpCS result = createNullLiteralExpCS(getRhsTokenText(1));
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 104: TypeLiteralExpCS ::= primitiveTypeCS
			//
		case 104:

			//
			// Rule 105: TypeLiteralExpCS ::= collectionTypeCS
			//
		case 105:

			//
			// Rule 106: TypeLiteralExpCS ::= tupleTypeCS
			//
		case 106: {

			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(1);
			VariableExpCS result = createVariableExpCS(simpleNameCS, new BasicEList<OCLExpressionCS>(), null);
			setOffsets(result, simpleNameCS);
			setResult(result);
			break;
		}

			//
			// Rule 111: IteratorExpCS ::= primaryExpCS -> simpleNameCS (
			// uninitializedVariableCS | OclExpressionCS )
			//
		case 111: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			IteratorExpCS result = createIteratorExpCS(source, simpleNameCS, (VariableCS) getRhsSym(5), null, (OCLExpressionCS) getRhsSym(7));
			setOffsets(result, source, getRhsIToken(8));
			setResult(result);
			break;
		}

			//
			// Rule 112: IteratorExpCS ::= primaryExpCS -> simpleNameCS (
			// simpleNameCS , uninitializedVariableCS | OclExpressionCS )
			//
		case 112: {

			SimpleNameCS name = (SimpleNameCS) getRhsSym(5);
			VariableCS variableCS = createVariableCS(name, null, null);
			setOffsets(variableCS, name);
			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			IteratorExpCS result = createIteratorExpCS(source, simpleNameCS, variableCS, (VariableCS) getRhsSym(7), (OCLExpressionCS) getRhsSym(9));
			setOffsets(result, source, getRhsIToken(10));
			setResult(result);
			break;
		}

			//
			// Rule 113: IteratorExpCS ::= primaryExpCS -> simpleNameCS (
			// typedUninitializedVariableCS , uninitializedVariableCS |
			// OclExpressionCS )
			//
		case 113: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			IteratorExpCS result = createIteratorExpCS(source, simpleNameCS, (VariableCS) getRhsSym(5), (VariableCS) getRhsSym(7), (OCLExpressionCS) getRhsSym(9));
			setOffsets(result, source, getRhsIToken(10));
			setResult(result);
			break;
		}

			//
			// Rule 114: IterateExpCS ::= primaryExpCS -> simpleNameCS (
			// typedInitializedVariableCS | OclExpressionCS )
			//
		case 114: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			IterateExpCS result = createIterateExpCS(source, simpleNameCS, (VariableCS) getRhsSym(5), null, (OCLExpressionCS) getRhsSym(7));
			setOffsets(result, source, getRhsIToken(8));
			setResult(result);
			break;
		}

			//
			// Rule 115: IterateExpCS ::= primaryExpCS -> simpleNameCS (
			// uninitializedVariableCS ; typedInitializedVariableCS |
			// OclExpressionCS )
			//
		case 115: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			IterateExpCS result = createIterateExpCS(source, simpleNameCS, (VariableCS) getRhsSym(5), (VariableCS) getRhsSym(7), (OCLExpressionCS) getRhsSym(9));
			setOffsets(result, source, getRhsIToken(10));
			setResult(result);
			break;
		}

			//
			// Rule 119: OperationCallExpCS ::= primaryExpCS -> simpleNameCS ( )
			//
		case 119: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			OperationCallExpCS result = createArrowOperationCallExpCS(source, (SimpleNameCS) getRhsSym(3), null, new BasicEList<OCLExpressionCS>());
			setOffsets(result, source, getRhsIToken(5));
			setResult(result);
			break;
		}

			//
			// Rule 120: OperationCallExpCS ::= primaryExpCS -> simpleNameCS (
			// OclExpressionCS )
			//
		case 120: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			OCLExpressionCS arg = (OCLExpressionCS) getRhsSym(5);
			OCLExpressionCS result;
			if (isIterator(simpleNameCS.getValue())) {
				result = createIteratorExpCS(source, simpleNameCS, null, null, arg);
			} else {
				EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
				args.add(arg);
				result = createArrowOperationCallExpCS(source, simpleNameCS, null, args);
			}
			setOffsets(result, source, getRhsIToken(6));
			setResult(result);
			break;
		}

			//
			// Rule 121: OperationCallExpCS ::= primaryExpCS -> simpleNameCS (
			// notNameExpressionCS , argumentsCS )
			//
		case 121: {

			EList<OCLExpressionCS> args = (EList<OCLExpressionCS>) getRhsSym(7);
			args.add(0, (OCLExpressionCS) getRhsSym(5));
			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			OperationCallExpCS result = createArrowOperationCallExpCS(source, (SimpleNameCS) getRhsSym(3), null, args);
			setOffsets(result, source, getRhsIToken(8));
			setResult(result);
			break;
		}

			//
			// Rule 122: OperationCallExpCS ::= primaryExpCS -> simpleNameCS (
			// simpleNameCS , argumentsCS )
			//
		case 122: {

			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(5);
			OCLExpressionCS variableExpCS = createVariableExpCS(simpleNameCS, new BasicEList<OCLExpressionCS>(), null);
			setOffsets(variableExpCS, simpleNameCS);
			EList<OCLExpressionCS> args = (EList<OCLExpressionCS>) getRhsSym(7);
			args.add(0, variableExpCS);
			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			OperationCallExpCS result = createArrowOperationCallExpCS(source, (SimpleNameCS) getRhsSym(3), null, args);
			setOffsets(result, source, getRhsIToken(8));
			setResult(result);
			break;
		}

			//
			// Rule 123: OperationCallExpCS ::= primaryExpCS .
			// conceptualOperationNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
		case 123:

			//
			// Rule 124: OperationCallExpCS ::= primaryExpCS . simpleNameCS
			// isMarkedPreCSopt ( argumentsCSopt )
			//
		case 124: {

			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			CallExpCS result = createDotOperationCallExpCS(source, null, simpleNameCS, (IsMarkedPreCS) getRhsSym(4), (EList<OCLExpressionCS>) getRhsSym(6));
			setOffsets(result, source, getRhsIToken(7));
			setResult(result);
			break;
		}

			//
			// Rule 125: OperationCallExpCS ::= simpleNameCS isMarkedPreCSopt (
			// argumentsCSopt )
			//
		case 125: {

			OperationCallExpCS result = createDotOperationCallExpCS(null, null, (SimpleNameCS) getRhsSym(1), (IsMarkedPreCS) getRhsSym(2), (EList<OCLExpressionCS>) getRhsSym(4));
			setOffsets(result, getRhsIToken(1), getRhsIToken(5));
			setResult(result);
			break;
		}

			//
			// Rule 126: OperationCallExpCS ::= pathNameCS ::
			// unreservedSimpleNameCS ( argumentsCSopt )
			//
		case 126: {

			PathNameCS pathNameCS = (PathNameCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			OperationCallExpCS result = createDotOperationCallExpCS(null, pathNameCS, simpleNameCS, null, (EList<OCLExpressionCS>) getRhsSym(5));
			setOffsets(result, pathNameCS, getRhsIToken(6));
			setResult(result);
			break;
		}

			//
			// Rule 127: OperationCallExpCS ::= primaryExpCS . pathNameCS ::
			// unreservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
		case 127: {

			PathNameCS pathNameCS = (PathNameCS) getRhsSym(3);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(5);
			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			CallExpCS result = createDotOperationCallExpCS(source, pathNameCS, simpleNameCS, (IsMarkedPreCS) getRhsSym(6), (EList<OCLExpressionCS>) getRhsSym(8));
			setOffsets(result, source, getRhsIToken(9));
			setResult(result);
			break;
		}

			//
			// Rule 129: PropertyCallExpCS ::= pathNameCS ::
			// unreservedSimpleNameCS isMarkedPreCSopt
			//
		case 129: {

			PathNameCS pathNameCS = (PathNameCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) getRhsSym(4);
			FeatureCallExpCS result = createFeatureCallExpCS(null, pathNameCS, simpleNameCS, new BasicEList<OCLExpressionCS>(), isMarkedPreCS);
			if (isMarkedPreCS != null) {
				setOffsets(result, pathNameCS, isMarkedPreCS);
			} else {
				setOffsets(result, pathNameCS, simpleNameCS);
			}
			setResult(result);
			break;
		}

			//
			// Rule 130: PropertyCallExpCS ::= primaryExpCS . pathNameCS ::
			// unreservedSimpleNameCS isMarkedPreCSopt
			//
		case 130: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			PathNameCS pathNameCS = (PathNameCS) getRhsSym(3);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(5);
			IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) getRhsSym(6);
			FeatureCallExpCS result = createFeatureCallExpCS(source, pathNameCS, simpleNameCS, new BasicEList<OCLExpressionCS>(), isMarkedPreCS);
			if (isMarkedPreCS != null) {
				setOffsets(result, source, isMarkedPreCS);
			} else {
				setOffsets(result, source, simpleNameCS);
			}
			setResult(result);
			break;
		}

			//
			// Rule 131: AssociationClassCallExpCS ::= primaryExpCS .
			// simpleNameCS isMarkedPreCSopt
			//
		case 131: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) getRhsSym(4);
			FeatureCallExpCS result = createFeatureCallExpCS(source, null, simpleNameCS, new BasicEList<OCLExpressionCS>(), isMarkedPreCS);
			if (isMarkedPreCS != null) {
				setOffsets(result, source, isMarkedPreCS);
			} else {
				setOffsets(result, source, simpleNameCS);
			}
			setResult(result);
			break;
		}

			//
			// Rule 132: isMarkedPreCSopt ::= $Empty
			//
		case 132: {

			setResult(null);
			break;
		}

			//
			// Rule 133: argumentsCSopt ::= $Empty
			//
		case 133: {

			setResult(new BasicEList<OCLExpressionCS>());
			break;
		}

			//
			// Rule 135: argumentsCS ::= OclExpressionCS
			//
		case 135: {

			EList<OCLExpressionCS> result = new BasicEList<OCLExpressionCS>();
			result.add((OCLExpressionCS) getRhsSym(1));
			setResult(result);
			break;
		}

			//
			// Rule 136: argumentsCS ::= argumentsCS , OclExpressionCS
			//
		case 136: {

			EList<OCLExpressionCS> result = (EList<OCLExpressionCS>) getRhsSym(1);
			result.add((OCLExpressionCS) getRhsSym(3));
			setResult(result);
			break;
		}

			//
			// Rule 139: VariableExpCS ::= selfKeywordCS
			//
		case 139: {

			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(1);
			VariableExpCS result = createVariableExpCS(simpleNameCS, new BasicEList<OCLExpressionCS>(), null);
			setOffsets(result, simpleNameCS);
			setResult(result);
			break;
		}

			//
			// Rule 140: SimpleNameExpCS ::= simpleNameCS
			//
		case 140: {

			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(1);
			VariableExpCS result = createVariableExpCS(simpleNameCS, new BasicEList<OCLExpressionCS>(), null);
			setOffsets(result, simpleNameCS);
			setResult(result);
			break;
		}

			//
			// Rule 146: impliesNotNameNotLetCS ::= impliesNotLetCS implies
			// xorNotLetCS
			//
		case 146:

			//
			// Rule 148: impliesWithLetCS ::= impliesNotLetCS implies
			// xorWithLetCS
			//
		case 148:

			//
			// Rule 152: xorNotNameNotLetCS ::= xorNotLetCS xor orNotLetCS
			//
		case 152:

			//
			// Rule 154: xorWithLetCS ::= xorNotLetCS xor orWithLetCS
			//
		case 154:

			//
			// Rule 158: orNotNameNotLetCS ::= orNotLetCS or andNotLetCS
			//
		case 158:

			//
			// Rule 160: orWithLetCS ::= orNotLetCS or andWithLetCS
			//
		case 160:

			//
			// Rule 164: andNotNameNotLetCS ::= andNotLetCS and equalityNotLetCS
			//
		case 164:

			//
			// Rule 166: andWithLetCS ::= andNotLetCS and equalityWithLetCS
			//
		case 166:

			//
			// Rule 170: equalityNotNameNotLetCS ::= equalityNotLetCS =
			// relationalNotLetCS
			//
		case 170:

			//
			// Rule 171: equalityNotNameNotLetCS ::= equalityNotLetCS <>
			// relationalNotLetCS
			//
		case 171:

			//
			// Rule 173: equalityWithLetCS ::= equalityNotLetCS =
			// relationalWithLetCS
			//
		case 173:

			//
			// Rule 174: equalityWithLetCS ::= equalityNotLetCS <>
			// relationalWithLetCS
			//
		case 174:

			//
			// Rule 178: relationalNotNameNotLetCS ::= relationalNotLetCS >
			// additiveNotLetCS
			//
		case 178:

			//
			// Rule 179: relationalNotNameNotLetCS ::= relationalNotLetCS <
			// additiveNotLetCS
			//
		case 179:

			//
			// Rule 180: relationalNotNameNotLetCS ::= relationalNotLetCS >=
			// additiveNotLetCS
			//
		case 180:

			//
			// Rule 181: relationalNotNameNotLetCS ::= relationalNotLetCS <=
			// additiveNotLetCS
			//
		case 181:

			//
			// Rule 183: relationalWithLetCS ::= relationalNotLetCS >
			// additiveWithLetCS
			//
		case 183:

			//
			// Rule 184: relationalWithLetCS ::= relationalNotLetCS <
			// additiveWithLetCS
			//
		case 184:

			//
			// Rule 185: relationalWithLetCS ::= relationalNotLetCS >=
			// additiveWithLetCS
			//
		case 185:

			//
			// Rule 186: relationalWithLetCS ::= relationalNotLetCS <=
			// additiveWithLetCS
			//
		case 186:

			//
			// Rule 190: additiveNotNameNotLetCS ::= additiveNotLetCS +
			// multiplicativeNotLetCS
			//
		case 190:

			//
			// Rule 191: additiveNotNameNotLetCS ::= additiveNotLetCS -
			// multiplicativeNotLetCS
			//
		case 191:

			//
			// Rule 193: additiveWithLetCS ::= additiveNotLetCS +
			// multiplicativeWithLetCS
			//
		case 193:

			//
			// Rule 194: additiveWithLetCS ::= additiveNotLetCS -
			// multiplicativeWithLetCS
			//
		case 194:

			//
			// Rule 198: multiplicativeNotNameNotLetCS ::=
			// multiplicativeNotLetCS * unaryNotLetCS
			//
		case 198:

			//
			// Rule 199: multiplicativeNotNameNotLetCS ::=
			// multiplicativeNotLetCS / unaryNotLetCS
			//
		case 199:

			//
			// Rule 201: multiplicativeWithLetCS ::= multiplicativeNotLetCS *
			// unaryWithLetCS
			//
		case 201:

			//
			// Rule 202: multiplicativeWithLetCS ::= multiplicativeNotLetCS /
			// unaryWithLetCS
			//
		case 202: {

			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getRhsIToken(2));
			setOffsets(simpleNameCS, getRhsIToken(2));
			OCLExpressionCS left = (OCLExpressionCS) getRhsSym(1);
			OCLExpressionCS right = (OCLExpressionCS) getRhsSym(3);
			EList<OCLExpressionCS> args = new BasicEList<OCLExpressionCS>();
			args.add(right);
			OperationCallExpCS result = createOperationCallExpCS(left, simpleNameCS, args);
			setOffsets(result, left, right);
			setResult(result);
			break;
		}

			//
			// Rule 206: unaryNotNameNotLetCS ::= - unaryNotLetCS
			//
		case 206:

			//
			// Rule 207: unaryNotNameNotLetCS ::= not unaryNotLetCS
			//
		case 207:

			//
			// Rule 209: unaryWithLetCS ::= - unaryWithLetCS
			//
		case 209:

			//
			// Rule 210: unaryWithLetCS ::= not unaryWithLetCS
			//
		case 210: {

			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getRhsIToken(1));
			setOffsets(simpleNameCS, getRhsIToken(1));
			OCLExpressionCS expr = (OCLExpressionCS) getRhsSym(2);
			OperationCallExpCS result = createOperationCallExpCS(expr, simpleNameCS, new BasicEList<OCLExpressionCS>());
			setOffsets(result, simpleNameCS, expr);
			setResult(result);
			break;
		}

			//
			// Rule 217: primaryNotNameCS ::= ( OclExpressionCS )
			//
		case 217: {

			OCLExpressionCS result = (OCLExpressionCS) getRhsSym(2);
			if (result instanceof OperationCallExpCS) {
				((OperationCallExpCS) result).setIsAtomic(true);
			}
			setOffsets(result, getRhsIToken(1), getRhsIToken(3));
			setResult(result);
			break;
		}

			//
			// Rule 218: LetExpCS ::= let letVariablesCS in OclExpressionCS
			//
		case 218: {

			OCLExpressionCS expr = (OCLExpressionCS) getRhsSym(4);
			LetExpCS result = createLetExpCS((EList<VariableCS>) getRhsSym(2), expr);
			setOffsets(result, getRhsIToken(1), expr);
			setResult(result);
			break;
		}

			//
			// Rule 219: letVariablesCS ::= typedInitializedVariableCS
			//
		case 219: {

			EList<VariableCS> result = new BasicEList<VariableCS>();
			result.add((VariableCS) getRhsSym(1));
			setResult(result);
			break;
		}

			//
			// Rule 220: letVariablesCS ::= letVariablesCS ,
			// typedInitializedVariableCS
			//
		case 220: {

			EList<VariableCS> result = (EList<VariableCS>) getRhsSym(1);
			result.add((VariableCS) getRhsSym(3));
			setResult(result);
			break;
		}

			//
			// Rule 222: listTypeCS ::= List ( typeCS )
			//
		case 222: {

			CSTNode result = createListTypeCS((TypeCS) getRhsSym(3));
			setOffsets(result, getRhsIToken(1), getRhsIToken(4));
			setResult(result);
			break;
		}

			//
			// Rule 223: listLiteralCS ::= List { CollectionLiteralPartsCSopt }
			//
		case 223: {

			CSTNode result = createListLiteralExpCS((EList) getRhsSym(3));
			setOffsets(result, getRhsIToken(1), getRhsIToken(4));
			setResult(result);
			break;
		}

			//
			// Rule 225: dictTypeCS ::= Dict ( typeCS , typeCS )
			//
		case 225: {

			CSTNode result = createDictTypeCS((TypeCS) getRhsSym(3), (TypeCS) getRhsSym(5));
			setOffsets(result, getRhsIToken(1), getRhsIToken(6));
			setResult(result);
			break;
		}

			//
			// Rule 226: dictLiteralCS ::= Dict { dictLiteralPartListCSopt }
			//
		case 226: {

			CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>) getRhsSym(3));
			setOffsets(result, getRhsIToken(1), getRhsIToken(4));
			setResult(result);
			break;
		}

			//
			// Rule 230: dictLiteralPartCS ::= literalSimpleCS = OclExpressionCS
			//
		case 230: {

			CSTNode result = createDictLiteralPartCS((LiteralExpCS) getRhsSym(1), (OCLExpressionCS) getRhsSym(3));
			setOffsets(result, getRhsIToken(1), getRhsIToken(3));
			setResult(result);
			break;
		}

			//
			// Rule 232: dictLiteralPartListCSopt ::= $Empty
			//
		case 232:
			setResult(new BasicEList<Object>());
			break;

		//
		// Rule 233: dictLiteralPartListCS ::= dictLiteralPartCS
		//
		case 233: {

			EList result = new BasicEList();
			result.add(getRhsSym(1));
			setResult(result);
			break;
		}

			//
			// Rule 234: dictLiteralPartListCS ::= dictLiteralPartListCS ,
			// dictLiteralPartCS
			//
		case 234: {

			EList result = (EList) getRhsSym(1);
			result.add(getRhsSym(3));
			setResult(result);
			break;
		}

			//
			// Rule 235: dictLiteralPartListCS ::= dictLiteralPartListCS
			// qvtErrorToken
			//
		case 235: {

			EList result = (EList) getRhsSym(1);
			setResult(result);
			break;
		}

			//
			// Rule 236: IteratorExpCS ::= primaryExpCS -> simpleNameCS (
			// qvtErrorToken
			//
		case 236: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) getRhsSym(3);
			CSTNode result = createIteratorExpCS(source, simpleNameCS, null, null, null);
			setOffsets(result, source, getRhsIToken(4));
			setResult(result);
			break;
		}

			//
			// Rule 237: argumentsCS ::= qvtErrorToken
			//
		case 237:
			setResult(new BasicEList<Object>());
			break;

		//
		// Rule 240: IfExpCS ::= if OclExpressionCS then ifExpBodyCS else
		// ifExpBodyCS endif
		//
		case 240: {

			CSTNode result = createIfExpCS((OCLExpressionCS) getRhsSym(2), (OCLExpressionCS) getRhsSym(4), (OCLExpressionCS) getRhsSym(6));
			setOffsets(result, getRhsIToken(1), getRhsIToken(7));
			setResult(result);
			break;
		}

			//
			// Rule 241: IfExpCS ::= if OclExpressionCS then ifExpBodyCS endif
			//
		case 241: {

			CSTNode result = createIfExpCS((OCLExpressionCS) getRhsSym(2), (OCLExpressionCS) getRhsSym(4), null);
			setOffsets(result, getRhsIToken(1), getRhsIToken(5));
			setResult(result);
			break;
		}

			//
			// Rule 242: IfExpCS ::= if OclExpressionCS then ifExpBodyCS else
			// ifExpBodyCS qvtErrorToken
			//
		case 242: {

			CSTNode result = createIfExpCS((OCLExpressionCS) getRhsSym(2), (OCLExpressionCS) getRhsSym(4), (OCLExpressionCS) getRhsSym(6));
			setOffsets(result, getRhsIToken(1), (CSTNode) getRhsSym(6));
			setResult(result);
			break;
		}

			//
			// Rule 243: IfExpCS ::= if OclExpressionCS then ifExpBodyCS else
			// qvtErrorToken
			//
		case 243: {

			CSTNode result = createIfExpCS((OCLExpressionCS) getRhsSym(2), (OCLExpressionCS) getRhsSym(4), null);
			setOffsets(result, getRhsIToken(1), getRhsIToken(5));
			setResult(result);
			break;
		}

			//
			// Rule 244: IfExpCS ::= if OclExpressionCS then ifExpBodyCS
			// qvtErrorToken
			//
		case 244: {

			CSTNode result = createIfExpCS((OCLExpressionCS) getRhsSym(2), (OCLExpressionCS) getRhsSym(4), null);
			setOffsets(result, getRhsIToken(1), (CSTNode) getRhsSym(4));
			setResult(result);
			break;
		}

			//
			// Rule 245: IfExpCS ::= if OclExpressionCS then qvtErrorToken
			//
		case 245: {

			CSTNode result = createIfExpCS((OCLExpressionCS) getRhsSym(2), null, null);
			setOffsets(result, getRhsIToken(1), getRhsIToken(3));
			setResult(result);
			break;
		}

			//
			// Rule 246: IfExpCS ::= if OclExpressionCS qvtErrorToken
			//
		case 246: {

			CSTNode result = createIfExpCS((OCLExpressionCS) getRhsSym(2), null, null);
			setOffsets(result, getRhsIToken(1), (CSTNode) getRhsSym(2));
			setResult(result);
			break;
		}

			//
			// Rule 247: IfExpCS ::= if qvtErrorToken
			//
		case 247: {

			OCLExpressionCS invalidCondition = createInvalidLiteralExpCS("");
			invalidCondition.setStartOffset(getRhsIToken(1).getEndOffset());
			invalidCondition.setEndOffset(getRhsIToken(1).getEndOffset());
			CSTNode result = createIfExpCS(invalidCondition, null, null);
			setOffsets(result, getRhsIToken(1), getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 248: IterateExpCS ::= primaryExpCS -> imperativeIterateExpCS
			//
		case 248: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			ImperativeIterateExpCS iterateExpCS = (ImperativeIterateExpCS) getRhsSym(3);
			iterateExpCS.setSource(source);
			setOffsets(iterateExpCS, source, iterateExpCS);
			setResult(iterateExpCS);
			break;
		}

			//
			// Rule 257: imperativeIterateExpCS ::=
			// imperativeIteratorExpCSToken12 ( imperativeIterContents12 )
			//
		case 257:

			//
			// Rule 258: imperativeIterateExpCS ::=
			// imperativeIteratorExpCSToken3 ( imperativeIterContents3 )
			//
		case 258: {

			String opCode = getRhsTokenText(1);
			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getRhsIToken(1));
			setOffsets(simpleNameCS, getRhsIToken(1));
			Object[] iterContents = (Object[]) getRhsSym(3);
			OCLExpressionCS bodyCS = null;
			OCLExpressionCS conditionCS = null;
			if ("xcollect".equals(opCode) || "collectOne".equals(opCode)) {
				bodyCS = (OCLExpressionCS) iterContents[2];
			} else {
				conditionCS = (OCLExpressionCS) iterContents[2];
			}
			CSTNode result = createImperativeIterateExpCS(simpleNameCS, (EList<VariableCS>) iterContents[0], (VariableCS) iterContents[1], bodyCS, conditionCS);
			setOffsets(result, getRhsIToken(1), getRhsIToken(4));
			setResult(result);
			break;
		}

			//
			// Rule 259: imperativeIterateExpCS ::= imperativeIteratorExpCSToken
			// qvtErrorToken
			//
		case 259: {

			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getRhsIToken(1));
			setOffsets(simpleNameCS, getRhsIToken(1));
			CSTNode result = createImperativeIterateExpCS(simpleNameCS, ourEmptyEList, null, null, null);
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 260: imperativeIterContents12 ::= OclExpressionCS
			//
		case 260: {

			setResult(new Object[] { ourEmptyEList, null, getRhsSym(1) });
			break;
		}

			//
			// Rule 261: imperativeIterContents12 ::= uninitializedVariableCS |
			// OclExpressionCS
			//
		case 261: {

			EList iters = new BasicEList();
			iters.add(getRhsSym(1));

			setResult(new Object[] { iters, null, getRhsSym(3) });
			break;
		}

			//
			// Rule 262: imperativeIterContents12 ::= simpleNameCS ,
			// variableDeclarationListCS | OclExpressionCS
			//
		case 262: {

			SimpleNameCS name = (SimpleNameCS) getRhsSym(1);
			CSTNode variableCS = createVariableCS(name, null, null);
			setOffsets(variableCS, name);

			EList iters = (EList) getRhsSym(3);
			iters.add(0, variableCS);

			setResult(new Object[] { iters, null, getRhsSym(5) });
			break;
		}

			//
			// Rule 263: imperativeIterContents3 ::= variableDeclarationListCS ;
			// initializedVariableCS | OclExpressionCS
			//
		case 263: {

			setResult(new Object[] { getRhsSym(1), getRhsSym(3), getRhsSym(5) });
			break;
		}

			//
			// Rule 264: variableDeclarationListCS ::= uninitializedVariableCS
			//
		case 264: {

			EList result = new BasicEList();
			result.add(getRhsSym(1));
			setResult(result);
			break;
		}

			//
			// Rule 265: variableDeclarationListCS ::= variableDeclarationListCS
			// , uninitializedVariableCS
			//
		case 265: {

			EList result = (EList) getRhsSym(1);
			result.add(getRhsSym(3));
			setResult(result);
			break;
		}

			//
			// Rule 266: exclamationOpt ::= $Empty
			//
		case 266:
			setResult(null);
			break;

		//
		// Rule 268: declarator_vsep ::= IDENTIFIER |
		//
		case 268: {

			CSTNode result = createVariableCS(getRhsIToken(1), null, null);
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 269: declarator_vsepOpt ::= $Empty
			//
		case 269:
			setResult(null);
			break;

		//
		// Rule 271: IterateExpCS ::= primaryExpCS exclamationOpt [
		// declarator_vsepOpt OclExpressionCS ]
		//
		case 271: {

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			if (source instanceof ImperativeIterateExpCS) {
				String opCode = isTokenOfType(getRhsIToken(2), XpandParsersym.TK_EXCLAMATION_MARK) ? "collectselectOne" : "collectselect";
				SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCode);
				setOffsets(simpleNameCS, getRhsIToken(3), getRhsIToken(6));

				ImperativeIterateExpCS result = (ImperativeIterateExpCS) source;
				result.setSimpleNameCS(simpleNameCS);

				VariableCS variableCS = (VariableCS) getRhsSym(4);
				if (variableCS != null) {
					result.setTarget(variableCS);
				}
				result.setCondition((OCLExpressionCS) getRhsSym(5));

				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
			} else {
				String opCode = isTokenOfType(getRhsIToken(2), XpandParsersym.TK_EXCLAMATION_MARK) ? "selectOne" : "xselect";
				SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCode);
				setOffsets(simpleNameCS, getRhsIToken(3), getRhsIToken(6));

				CallExpCS result = createImperativeIterateExpCS(simpleNameCS, ourEmptyEList, (VariableCS) getRhsSym(4), null, (OCLExpressionCS) getRhsSym(5));
				result.setSource(source);
				setOffsets(result, getRhsIToken(1), getRhsIToken(6));
				setResult(result);
			}
			break;
		}

			//
			// Rule 272: IterateExpCS ::= primaryExpCS -> simpleNameCS
			//
		case 272: {

			String opCode = "xcollect";
			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCode);

			OCLExpressionCS source = (OCLExpressionCS) getRhsSym(1);
			SimpleNameCS featureNameCS = (SimpleNameCS) getRhsSym(3);
			OCLExpressionCS featureCallExpCS = createFeatureCallExpCS(source, null, featureNameCS, new BasicEList(), null);
			setOffsets(featureCallExpCS, source, featureNameCS);

			ImperativeIterateExpCS result = createImperativeIterateExpCS(simpleNameCS, ourEmptyEList, null, null, null);
			result.setSource(featureCallExpCS);
			setOffsets(result, getRhsIToken(1), getRhsIToken(3));
			setResult(result);
			break;
		}

			//
			// Rule 273: primaryNotNameCS ::= break
			//
		case 273: {

			OCLExpressionCS result = createBreakCS();
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 274: primaryNotNameCS ::= continue
			//
		case 274: {

			OCLExpressionCS result = createContinueCS();
			setOffsets(result, getRhsIToken(1));
			setResult(result);
			break;
		}

			//
			// Rule 277: declarator1 ::= IDENTIFIER : typeCS
			//
		case 277: {

			CSTNode result = createVariableCS(getRhsIToken(1), (TypeCS) getRhsSym(3), null);
			setOffsets(result, getRhsIToken(1), (CSTNode) getRhsSym(3));
			setResult(result);
			break;
		}

			//
			// Rule 278: declarator1 ::= IDENTIFIER : typeCS = OclExpressionCS
			//
		case 278: {

			CSTNode result = createVariableCS(getRhsIToken(1), (TypeCS) getRhsSym(3), (OCLExpressionCS) getRhsSym(5));
			setOffsets(result, getRhsIToken(1), (CSTNode) getRhsSym(5));
			setResult(result);
			break;
		}

			//
			// Rule 279: declarator1 ::= IDENTIFIER : typeCS := OclExpressionCS
			//
		case 279: {

			CSTNode result = createVariableCS(getRhsIToken(1), (TypeCS) getRhsSym(3), (OCLExpressionCS) getRhsSym(5));
			setOffsets(result, getRhsIToken(1), (CSTNode) getRhsSym(5));
			setResult(result);
			break;
		}

			//
			// Rule 280: declarator2 ::= IDENTIFIER := OclExpressionCS
			//
		case 280: {

			CSTNode result = createVariableCS(getRhsIToken(1), null, (OCLExpressionCS) getRhsSym(3));
			setOffsets(result, getRhsIToken(1), (CSTNode) getRhsSym(3));
			setResult(result);
			break;
		}

			//
			// Rule 281: qvtErrorToken ::= ERROR_TOKEN
			//
		case 281: {

			diagnozeErrorToken(getRhsTokenIndex(1));
			break;
		}

			//
			// Rule 282: template ::= emptyTemplate
			//
		case 282: {

			setResult(xpandFactory.createTemplate(Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, getRightIToken()));
			break;
		}
			//
			// Rule 285: template ::= LG commentTextPairAny imports
			// extensionImports defineOrAroundSeq
			//
		case 285: {

			List imports = (List) getRhsSym(3);
			List extensionImports = (List) getRhsSym(4);
			List defineOrAround = (List) getRhsSym(5);
			List<Advice> advices = new LinkedList<Advice>();
			List<Definition> defines = new LinkedList<Definition>();
			for (Object o : defineOrAround) {
				if (o instanceof Definition) {
					defines.add((Definition) o);
				} else if (o instanceof Advice) {
					advices.add((Advice) o);
				} else {
					throw new IllegalStateException();// assert false?
				}
			}
			setResult(xpandFactory.createTemplate(imports, extensionImports, defines, advices, getRightIToken()));
			break;
		}
			//
			// Rule 286: defineOrAroundSeq ::= define TEXT commentTextPairAny
			// defineOrAroundSuffix
			//
		case 286: {

			List result = new LinkedList();
			result.add(getRhsSym(1));
			result.addAll((List) getRhsSym(4));
			setResult(result);
			break;
		}
			//
			// Rule 287: defineOrAroundSeq ::= around TEXT commentTextPairAny
			// defineOrAroundSuffix
			//
		case 287: {

			List result = new LinkedList();
			result.add(getRhsSym(1));
			result.addAll((List) getRhsSym(4));
			setResult(result);
			break;
		}
			//
			// Rule 288: defineOrAroundSuffix ::= $Empty
			//
		case 288: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 292: imports ::= $Empty
			//
		case 292: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 293: imports ::= anImport imports
			//
		case 293: {

			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
			break;
		}
			//
			// Rule 294: anImport ::= IMPORT StringLiteralExpCS TEXT
			// commentTextPairAny
			//
		case 294: {

			setResult(xpandFactory.createNamespaceImport(getLeftIToken(), (StringLiteralExpCS) getRhsSym(2)));
			break;
		}
			//
			// Rule 295: extensionImports ::= $Empty
			//
		case 295: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 296: extensionImports ::= anExtensionImport extensionImports
			//
		case 296: {

			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
			break;
		}
			//
			// Rule 297: anExtensionImport ::= EXTENSION pathNameCS TEXT
			// commentTextPairAny
			//
		case 297: {

			setResult(xpandFactory.createImportDeclaration(getLeftIToken(), (PathNameCS) getRhsSym(2)));
			break;
		}
			//
			// Rule 298: around ::= AROUND pointcut FOR typeCS sequence
			// ENDAROUND
			//
		case 298: {

			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), Collections.<VariableCS> emptyList(), false, (TypeCS) getRhsSym(4), (List) getRhsSym(5)));
			break;
		}
			//
			// Rule 299: around ::= AROUND pointcut LPAREN parametersList RPAREN
			// FOR typeCS sequence ENDAROUND
			//
		case 299: {

			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), (List<VariableCS>) getRhsSym(4), false, (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
			break;
		}
			//
			// Rule 300: around ::= AROUND pointcut LPAREN parametersList COMMA
			// MULTIPLY RPAREN FOR typeCS sequence ENDAROUND
			//
		case 300: {

			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), (List<VariableCS>) getRhsSym(4), true, (TypeCS) getRhsSym(9), (List) getRhsSym(10)));
			break;
		}
			//
			// Rule 301: around ::= AROUND pointcut LPAREN MULTIPLY RPAREN FOR
			// typeCS sequence ENDAROUND
			//
		case 301: {

			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), Collections.<VariableCS> emptyList(), true, (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
			break;
		}
			//
			// Rule 302: pointcut ::= MULTIPLY pointcutSuffix
			//
		case 302: {

			// FIXME: may use SimpleNameCS here, though need more sophisticated
			// code to update end position
			// SimpleNameCS simpleNameCS =
			// createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL,
			// getTokenText(getRhsTokenIndex(1)));
			// setOffsets(simpleNameCS, getLeftIToken());
			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
			break;
		}
			//
			// Rule 303: pointcut ::= IDENTIFIER pointcutSuffix
			//
		case 303: {

			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
			break;
		}
			//
			// Rule 304: pointcutSuffix ::= $Empty
			//
		case 304: {

			setResult(null);
			break;
		}
			//
			// Rule 306: pointcutSuffix ::= COLONCOLON pointcutSuffix
			//
		case 306: {

			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
			break;
		}
			//
			// Rule 307: define ::= DEFINE IDENTIFIER FOR typeCS sequence
			// ENDDEFINE
			//
		case 307: {

			setResult(xpandFactory.createDefinition(getLeftIToken(), getRightIToken(), getRhsIToken(2), Collections.<VariableCS> emptyList(), (TypeCS) getRhsSym(4), (List) getRhsSym(5)));
			break;
		}
			//
			// Rule 308: define ::= DEFINE IDENTIFIER LPAREN parametersList
			// RPAREN FOR typeCS sequence ENDDEFINE
			//
		case 308: {

			setResult(xpandFactory.createDefinition(getLeftIToken(), getRightIToken(), getRhsIToken(2), (List<VariableCS>) getRhsSym(4), (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
			break;
		}
			//
			// Rule 309: parametersList ::= parameter
			//
		case 309: {

			VariableCS param = (VariableCS) getRhsSym(1);
			LinkedList res = new LinkedList();
			res.add(param);
			setResult(res);
			break;
		}
			//
			// Rule 310: parametersList ::= parametersList , parameter
			//
		case 310: {

			VariableCS param = (VariableCS) getRhsSym(3);
			LinkedList res = new LinkedList();
			res.addAll((List) getRhsSym(1));
			res.add(param);
			setResult(res);
			break;
		}
			//
			// Rule 312: parameter ::= typeCS IDENTIFIER
			//
		case 312: {

			VariableCS result = createVariableCS(getRhsIToken(2).toString(), (TypeCS) getRhsSym(1), null);
			setOffsets(result, (TypeCS) getRhsSym(1), getRhsIToken(2));
			setResult(result);
			break;
		}
			//
			// Rule 313: sequence ::= text sequenceSuffix
			//
		case 313: {

			List res = new LinkedList();
			res.addAll((List) getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
			break;
		}
			//
			// Rule 314: sequenceSuffix ::= $Empty
			//
		case 314: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 315: sequenceSuffix ::= statement text sequenceSuffix
			//
		case 315: {

			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			res.addAll((List) getRhsSym(3));
			setResult(res);
			break;
		}
			//
			// Rule 322: text ::= minusOpt TEXT textSuffix
			//
		case 322: {

			List res = new LinkedList();
			res.add(xpandFactory.createTextStatement(getRhsIToken(2), (IToken) getRhsSym(1)));
			res.addAll((List) getRhsSym(3));
			setResult(res);
			break;
		}
			//
			// Rule 323: textSuffix ::= $Empty
			//
		case 323: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 324: textSuffix ::= minusOpt TEXT textSuffix
			//
		case 324: {

			List res = new LinkedList();
			res.add(xpandFactory.createTextStatement(getRhsIToken(2), (IToken) getRhsSym(1)));
			res.addAll((List) getRhsSym(3));
			setResult(res);
			break;
		}
			//
			// Rule 325: minusOpt ::= $Empty
			//
		case 325: {

			setResult(null);
			break;
		}
			//
			// Rule 326: minusOpt ::= MINUS
			//
		case 326: {

			setResult(getLeftIToken());
			break;
		}
			//
			// Rule 330: errorStatement ::= ERROR OclExpressionCS
			//
		case 330: {

			setResult(xpandFactory.createErrorStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2)));
			break;
		}
			//
			// Rule 331: expandStatement ::= EXPAND definitionName
			// parameterListOpt
			//
		case 331: {

			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), null, false, null));
			break;
		}
			//
			// Rule 332: expandStatement ::= EXPAND definitionName
			// parameterListOpt FOR OclExpressionCS
			//
		case 332: {

			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), false, null));
			break;
		}
			//
			// Rule 333: expandStatement ::= EXPAND definitionName
			// parameterListOpt FOREACH OclExpressionCS separatorOpt
			//
		case 333: {

			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), true, (OCLExpressionCS) getRhsSym(6)));
			break;
		}
			//
			// Rule 334: parameterListOpt ::= $Empty
			//
		case 334: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 335: parameterListOpt ::= LPAREN argumentsCS RPAREN
			//
		case 335: {

			setResult(getRhsSym(2));
			break;
		}
			//
			// Rule 337: expressionStmt ::= OclExpressionCS
			//
		case 337: {

			// XXX OCL CST doesn't keep track of line numbers, but we use them
			// (perhaps, might refactor to stop using?)
			int lineNumber = getLeftIToken().getLine();
			setResult(xpandFactory.createExpressionStatement((OCLExpressionCS) getRhsSym(1), lineNumber));
			break;
		}
			//
			// Rule 338: fileStatement ::= FILE OclExpressionCS identOpt
			// sequence ENDFILE
			//
		case 338: {

			setResult(xpandFactory.createFileStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), (Identifier) getRhsSym(3), (List) getRhsSym(4)));
			break;
		}
			//
			// Rule 339: identOpt ::= $Empty
			//
		case 339: {

			setResult(null);
			break;
		}
			//
			// Rule 340: identOpt ::= IDENTIFIER
			//
		case 340: {

			setResult(xpandFactory.createIdentifier(getLeftIToken()));
			break;
		}
			//
			// Rule 341: foreachStatement ::= FOREACH OclExpressionCS AS
			// IDENTIFIER iteratorOpt separatorOpt sequence ENDFOREACH
			//
		case 341: {

			setResult(xpandFactory.createForEachStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), getRhsIToken(4), (OCLExpressionCS) getRhsSym(6), (IToken) getRhsSym(5),
					(List) getRhsSym(7)));
			break;
		}
			//
			// Rule 342: iteratorOpt ::= $Empty
			//
		case 342: {

			setResult(null);
			break;
		}
			//
			// Rule 343: iteratorOpt ::= ITERATOR IDENTIFIER
			//
		case 343: {

			setResult(getRightIToken());
			break;
		}
			//
			// Rule 344: separatorOpt ::= $Empty
			//
		case 344: {

			setResult(null);
			break;
		}
			//
			// Rule 345: separatorOpt ::= SEPARATOR OclExpressionCS
			//
		case 345: {

			setResult(getRhsSym(2));
			break;
		}
			//
			// Rule 346: ifStatement ::= IF OclExpressionCS sequence elseifAny
			// elseOpt ENDIF
			//
		case 346: {

			IfStatement i = xpandFactory.createIfStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2), (List) getRhsSym(3), null);
			IfStatement elseIf = (IfStatement) getRhsSym(4);
			IfStatement elseStmt = (IfStatement) getRhsSym(5);
			if (elseIf != null) {
				i.setElseIf(elseIf);
				IfStatement curElseIf = elseIf;
				// get the latest one in the chain
				while (curElseIf.getElseIf() != null) {
					curElseIf = curElseIf.getElseIf();
				}
				curElseIf.setElseIf(elseStmt);
			} else {
				i.setElseIf(elseStmt);
			}
			setResult(i);
			break;
		}
			//
			// Rule 347: elseifAny ::= $Empty
			//
		case 347: {

			setResult(null);
			break;
		}
			//
			// Rule 348: elseifAny ::= ELSEIF OclExpressionCS sequence elseifAny
			//
		case 348: {

			IfStatement elseIf = xpandFactory.createIfStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2), (List) getRhsSym(3), null);
			IfStatement restElseIf = (IfStatement) getRhsSym(4);
			elseIf.setElseIf(restElseIf);
			setResult(elseIf);
			break;
		}
			//
			// Rule 349: elseOpt ::= $Empty
			//
		case 349: {

			setResult(null);
			break;
		}
			//
			// Rule 350: elseOpt ::= ELSE sequence
			//
		case 350: {

			setResult(xpandFactory.createIfStatement(getLeftIToken(), null, (List) getRhsSym(2), null));
			break;
		}
			//
			// Rule 351: letStatement ::= LET OclExpressionCS AS IDENTIFIER
			// sequence ENDLET
			//
		case 351: {

			setResult(xpandFactory.createLetStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), getRhsIToken(4), (List) getRhsSym(5)));
			break;
		}
			//
			// Rule 352: protectStatement ::= PROTECT CSTART OclExpressionCS
			// CEND OclExpressionCS ID OclExpressionCS disabledOpt sequence
			// ENDPROTECT
			//
		case 352: {

			setResult(xpandFactory.createProtectStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), (OCLExpressionCS) getRhsSym(7),
					(IToken) getRhsSym(8), (List) getRhsSym(9)));
			break;
		}
			//
			// Rule 353: disabledOpt ::= $Empty
			//
		case 353: {

			setResult(null);
			break;
		}
			//
			// Rule 354: disabledOpt ::= DISABLE
			//
		case 354: {

			setResult(getLeftIToken());
			break;
		}

		default:
			break;
		}
		return;
	}
}
