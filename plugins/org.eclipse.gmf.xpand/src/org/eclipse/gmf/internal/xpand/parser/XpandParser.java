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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.DeterministicParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.ErrorToken;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.LexStream;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotDeterministicParseTableException;
import lpg.lpgjavaruntime.NullExportedSymbolsException;
import lpg.lpgjavaruntime.NullTerminalSymbolsException;
import lpg.lpgjavaruntime.ParseErrorCodes;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.PrsStream;
import lpg.lpgjavaruntime.RuleAction;
import lpg.lpgjavaruntime.TokenStream;
import lpg.lpgjavaruntime.UndefinedEofSymbolException;
import lpg.lpgjavaruntime.UnimplementedTerminalsException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.internal.xpand.Activator;
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
import org.eclipse.m2m.internal.qvt.oml.cst.temp.TempFactory;
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
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

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
	public void reportError(int i, String code) {
		Activator.logWarn("Unexpected #reportError(int,String)");
		reportError(i, i);
	}

	@Override
	public void reportError(int leftToken, int rightToken) {
		final int errorCode = (rightToken >= getStreamLength() ? EOF_CODE : leftToken == rightToken ? LEX_ERROR_CODE : INVALID_TOKEN_CODE);
		final int endToken = (leftToken == rightToken ? rightToken : rightToken - 1);
		reportError(errorCode, null, leftToken, endToken, getName(leftToken));
	}

	@Override
	public void reportError(int errorCode, String locationInfo, String tokenText) {
		try {
			Matcher m = Pattern.compile("(?:[^:]+::)*[^:]+:(\\d+):(\\d+):(\\d+):(\\d+):.*").matcher(locationInfo);
			boolean t = m.matches(); // ignore return value, rely on exception
										// if anything wrong
			assert t;
			final int leftTokenLine = Integer.parseInt(m.group(1));
			final int leftTokenColumn = Integer.parseInt(m.group(2));
			final int rightTokenLine = Integer.parseInt(m.group(3));
			final int rightTokenColumn = Integer.parseInt(m.group(4));
			final String msg = tokenText + errorMsgText[errorCode];
			errors.add(new ErrorLocationInfo(msg, leftTokenLine, leftTokenColumn, rightTokenLine, rightTokenColumn));
		} catch (Throwable ex) {
			// ignore
			errors.add(new ErrorLocationInfo(tokenText + errorMsgText[errorCode]));
		}
	}

	@Override
	public void reportError(int errorCode, String locationInfo, int leftToken, int rightToken, String tokenText) {
		final int leftTokenLine = getLine(leftToken);
		final int leftTokenColumn = getColumn(leftToken);
		final int rightTokenLine = getEndLine(rightToken);
		final int rightTokenColumn = getEndColumn(rightToken);
		final String msg = tokenText + errorMsgText[errorCode] + (locationInfo != null && locationInfo.length() > 0 ? '(' + locationInfo + ')' : "");
		final int startOffset = getStartOffset(leftToken);
		final int endOffset = getEndOffset(rightToken);
		errors.add(new ErrorLocationInfo(msg, leftTokenLine, leftTokenColumn, rightTokenLine, rightTokenColumn, startOffset, endOffset));
	}

	private final XpandFactory xpandFactory;

	/**
	 * 
	 * QVT Operational specific part
	 * 
	 */

	@SuppressWarnings("unchecked")
	private static final EList ourEmptyEList = new BasicEList.UnmodifiableEList(0, new Object[0]);

	private void diagnozeErrorToken(int token_index) {
		IToken token = getIToken(token_index);
		if (token instanceof lpg.lpgjavaruntime.ErrorToken) {
			token = ((lpg.lpgjavaruntime.ErrorToken) token).getErrorToken();
		}

		reportError(lpg.lpgjavaruntime.ParseErrorCodes.MISPLACED_CODE, "", token.getTokenIndex(), token.getTokenIndex(), //$NON-NLS-1$ 
				"'" + token.toString() + "'"); //$NON-NLS-1$ //$NON-NLS-2$
		reset(token.getTokenIndex()); // point to error token
		DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
		diagnoseParser.diagnose(token.getTokenIndex());
		dtParser.setSym1(null);
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
			//nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""); //$NON-NLS-1$
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

	private SimpleNameCS removeLastSimpleNameCS(PathNameCS path) {
		EList<SimpleNameCS> simpleNames = path.getSimpleNames();
		SimpleNameCS name = simpleNames.remove(simpleNames.size() - 1);
		setOffsets(path, path, simpleNames.size() > 0 ? simpleNames.get(simpleNames.size() - 1) : path);
		return name;
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

	private StringLiteralExpCS createStringLiteralExpCS(String string) {
		StringLiteralExpCS result = CSTFactory.eINSTANCE.createStringLiteralExpCS();
		result.setSymbol(string);
		result.setStringSymbol(string);
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

	private String unescape(IToken stringLiteral) {
		String rawString = stringLiteral.toString();
		int rawStringLength = rawString.length();
		if (rawStringLength <= 2) {
			return ""; //$NON-NLS-1$
		}
		StringBuilder unescapedStringBuilder = null;
		boolean isBackslashEscapeProcessingUsed = true; // getEnvironment().isEnabled(ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING);
		boolean isNonStdSQEscapingUsed = false;
		int n = rawStringLength - 1;
		for (int i = 1; i < n; i++) {
			char ch = rawString.charAt(i);
			if ((isBackslashEscapeProcessingUsed && (ch == '\\')) || ((ch == '\'') && isNonStdSQSupported())) {
				if (unescapedStringBuilder == null) {
					unescapedStringBuilder = new StringBuilder(rawString.substring(1, i));
				}
				i++;
				if (i >= n) {
					reportError(ParseErrorCodes.INVALID_CODE, "", stringLiteral.getTokenIndex(), stringLiteral.getTokenIndex(), //$NON-NLS-1$
							"String literal not properly closed");
				}
				char nextCh = rawString.charAt(i);
				if (ch == '\\') {
					switch (nextCh) {
					case 'b':
						unescapedStringBuilder.append('\b');
						break;
					case 't':
						unescapedStringBuilder.append('\t');
						break;
					case 'n':
						unescapedStringBuilder.append('\n');
						break;
					case 'f':
						unescapedStringBuilder.append('\f');
						break;
					case 'r':
						unescapedStringBuilder.append('\r');
						break;
					case '\"':
						unescapedStringBuilder.append('\"');
						break;
					case '\'':
						unescapedStringBuilder.append('\'');
						break;
					case '\\':
						unescapedStringBuilder.append('\\');
						break;
					default:
						// octal escape check
						int unescapedChar = -1;
						if ((nextCh >= '\u0030') && (nextCh <= '\u0037')) { // octal
							// digit
							unescapedChar = Character.getNumericValue(nextCh);
							if (i + 1 < n) {
								char tmpCh = rawString.charAt(i + 1);
								if ((tmpCh >= '\u0030') && (tmpCh <= '\u0037')) { // octal
																					// digit
									unescapedChar = 8 * unescapedChar + Character.getNumericValue(tmpCh);
									i++;
									if (i + 1 < n) {
										tmpCh = rawString.charAt(i + 1);
										if ((tmpCh >= '\u0030') && (tmpCh <= '\u0037') // octal
												// digit
												&& (nextCh <= '\u0033')) { // most-significant
											// digit
											// in
											// range
											// 0..2
											unescapedChar = 8 * unescapedChar + Character.getNumericValue(tmpCh);
											i++;
										}
									}
								}
							}
							unescapedStringBuilder.append((char) unescapedChar);
						}
						if (unescapedChar < 0) {
							reportError(ParseErrorCodes.INVALID_CODE, "", stringLiteral.getTokenIndex(), stringLiteral.getTokenIndex(), //$NON-NLS-1$
									"Invalid escape sequence (valid ones are \\b \\t \\n \\f \\r \\\" \\\' \\\\)");
						}
						break;
					}
				} else { // non-std '' escaping
					unescapedStringBuilder.append('\'');
					isNonStdSQEscapingUsed = true;
					assert nextCh == '\'' : "Unexpected escape sequence in string literal: " + rawString; //$NON-NLS-1$
				}
			} else if (unescapedStringBuilder != null) {
				unescapedStringBuilder.append(ch);
			}
		}
		if (isNonStdSQEscapingUsed) {
			// Should not be called - isNonStdSQSupported returns false

			// // check settings for using non-standard closure iterator
			// ProblemHandler.Severity sev = getEnvironment().getValue(
			// ProblemOption.STRING_SINGLE_QUOTE_ESCAPE);
			// if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
			// getEnvironment().problem(
			// sev,
			// ProblemHandler.Phase.PARSER,
			// OCLMessages.bind(OCLMessages.NonStd_SQuote_Escape_,
			//					stringLiteral), "STRING_LITERAL", //$NON-NLS-1$
			// null);
			// }
		}
		return (unescapedStringBuilder == null) ? rawString.substring(1, n) : unescapedStringBuilder.toString();
	}

	private boolean isNonStdSQSupported() {
		return false;
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
			result = result.replaceAll("\\\\\"", "\""); //$NON-NLS-2$//$NON-NLS-1$
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

	@SuppressWarnings("unchecked")
	public void ruleAction(int ruleNumber) {
		switch (ruleNumber) {

		//
		// Rule 31: binaryKeywordCS ::= binaryKeyword
		//
		case 31:

			//
			// Rule 32: unaryKeywordCS ::= unaryKeyword
			//
		case 32:

			//
			// Rule 33: reservedPunctuationCS ::= reservedPunctuation
			//
		case 33: {

			SimpleNameCS result = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 34: iterateNameCS ::= iterateIdentifier
			//
		case 34:

			//
			// Rule 35: iteratorNameCS ::= iteratorIdentifier
			//
		case 35:

			//
			// Rule 36: simpleIdentifierCS ::= otherIdentifier
			//
		case 36: {

			CSTNode result = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 38: simpleIdentifierCS ::= self
			//
		case 38: {

			CSTNode result = createSimpleNameCS(SimpleTypeEnum.SELF_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 51: pathNameCS ::= notReservedSimpleNameCS
			//
		case 51: {

			SimpleNameCS simpleName = (SimpleNameCS) dtParser.getSym(1);
			PathNameCS result = createPathNameCS(simpleName);
			setOffsets(result, simpleName);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 53: qualifiedPathNameCS ::= pathNameCS ::
			// notReservedSimpleNameCS
			//
		case 53: {

			PathNameCS result = (PathNameCS) dtParser.getSym(1);
			SimpleNameCS simpleName = (SimpleNameCS) dtParser.getSym(3);
			result = extendPathNameCS(result, simpleName);
			setOffsets(result, result, simpleName);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 54: primitiveTypeCS ::= Boolean
			//
		case 54: {

			CSTNode result = createPrimitiveTypeCS(SimpleTypeEnum.BOOLEAN_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 55: primitiveTypeCS ::= Integer
			//
		case 55: {

			CSTNode result = createPrimitiveTypeCS(SimpleTypeEnum.INTEGER_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 56: primitiveTypeCS ::= Real
			//
		case 56: {

			CSTNode result = createPrimitiveTypeCS(SimpleTypeEnum.REAL_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 57: primitiveTypeCS ::= String
			//
		case 57: {

			CSTNode result = createPrimitiveTypeCS(SimpleTypeEnum.STRING_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 58: primitiveTypeCS ::= UnlimitedNatural
			//
		case 58: {

			CSTNode result = createPrimitiveTypeCS(SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 59: primitiveTypeCS ::= OclAny
			//
		case 59: {

			CSTNode result = createPrimitiveTypeCS(SimpleTypeEnum.OCL_ANY_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 60: primitiveTypeCS ::= OclInvalid
			//
		case 60: {

			CSTNode result = createPrimitiveTypeCS(SimpleTypeEnum.OCL_INVALID_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 61: primitiveTypeCS ::= OclVoid
			//
		case 61: {

			CSTNode result = createPrimitiveTypeCS(SimpleTypeEnum.OCL_VOID_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 62: CollectionTypeIdentifierCS ::= Bag
			//
		case 62: {

			SimpleNameCS result = createCollectionTypeCS(CollectionTypeIdentifierEnum.BAG_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 63: CollectionTypeIdentifierCS ::= Collection
			//
		case 63: {

			SimpleNameCS result = createCollectionTypeCS(CollectionTypeIdentifierEnum.COLLECTION_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 64: CollectionTypeIdentifierCS ::= OrderedSet
			//
		case 64: {

			SimpleNameCS result = createCollectionTypeCS(CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 65: CollectionTypeIdentifierCS ::= Sequence
			//
		case 65: {

			SimpleNameCS result = createCollectionTypeCS(CollectionTypeIdentifierEnum.SEQUENCE_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 66: CollectionTypeIdentifierCS ::= Set
			//
		case 66: {

			SimpleNameCS result = createCollectionTypeCS(CollectionTypeIdentifierEnum.SET_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 67: collectionTypeCS ::= CollectionTypeIdentifierCS ( typeCS
			// )
			//
		case 67: {

			CollectionTypeCS result = (CollectionTypeCS) dtParser.getSym(1);
			result.setTypeCS((TypeCS) dtParser.getSym(3));
			setOffsets(result, result, getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 68: tupleTypeCS ::= Tuple ( variableDeclarationListCSopt )
			//
		case 68: {

			CSTNode result = createTupleTypeCS((EList) dtParser.getSym(3));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 69: typeCS ::= notReservedSimpleNameCS
			//
		case 69: {

			CSTNode result = (CSTNode) dtParser.getSym(1);
			if (!(result instanceof TypeCS)) {
				PathNameCS pathNameCS = createPathNameCS((SimpleNameCS) result);
				setOffsets(pathNameCS, result);
				result = pathNameCS;
			}
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 77: typedVariableCS ::= BooleanLiteralExpCS : typeCS
			//
		case 77:

			//
			// Rule 78: typedVariableCS ::= InvalidLiteralExpCS : typeCS
			//
		case 78:

			//
			// Rule 79: typedVariableCS ::= NullLiteralExpCS : typeCS
			//
		case 79:

			//
			// Rule 80: typedVariableCS ::= notLiteralNorReservedSimpleNameCS :
			// typeCS
			//
		case 80: {

			SimpleNameCS name = (SimpleNameCS) dtParser.getSym(1);
			TypeCS type = (TypeCS) dtParser.getSym(3);
			VariableCS result = createVariableCS(name, type, null);
			setOffsets(result, name, type);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 81: VariableDeclarationCS ::= variableNameCS
			//
		case 81: {

			SimpleNameCS name = (SimpleNameCS) dtParser.getSym(1);
			CSTNode result = createVariableCS(name, null, null);
			setOffsets(result, name);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 83: VariableDeclarationCS ::= typedVariableCS =
			// OclExpressionCS
			//
		case 83: {

			VariableCS result = (VariableCS) dtParser.getSym(1);
			OCLExpressionCS initExpression = (OCLExpressionCS) dtParser.getSym(3);
			result.setInitExpression(initExpression);
			setOffsets(result, result, initExpression);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 84: variableDeclarationListCS ::= VariableDeclarationCS
			//
		case 84: {

			EList result = new BasicEList();
			result.add(dtParser.getSym(1));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 85: variableDeclarationListCS ::= variableDeclarationListCS
			// , VariableDeclarationCS
			//
		case 85: {

			EList result = (EList) dtParser.getSym(1);
			result.add(dtParser.getSym(3));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 86: variableDeclarationListCSopt ::= $Empty
			//
		case 86:
			dtParser.setSym1(new BasicEList());
			break;

		//
		// Rule 88: BooleanLiteralExpCS ::= false
		//
		case 88: {

			CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 89: BooleanLiteralExpCS ::= true
			//
		case 89: {

			CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 90: IntegerLiteralExpCS ::= INTEGER_LITERAL
			//
		case 90: {

			CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 91: InvalidLiteralExpCS ::= invalid
			//
		case 91: {

			CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 92: NullLiteralExpCS ::= null
			//
		case 92: {

			CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 93: RealLiteralExpCS ::= REAL_LITERAL
			//
		case 93: {

			CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 94: StringLiteralExpCS ::= STRING_LITERAL
			//
		case 94: {

			IToken literalToken = getIToken(dtParser.getToken(1));
			StringLiteralExpCS result = createStringLiteralExpCS(literalToken.toString());
			result.setUnescapedStringSymbol(unescape(literalToken));
			setOffsets(result, literalToken);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 95: UnlimitedNaturalLiteralExpCS ::= *
			//
		case 95: {

			CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 101: CollectionLiteralExpCS ::= CollectionTypeIdentifierCS {
			// CollectionLiteralPartsCSopt }
			//
		case 101: {

			CollectionTypeCS typeCS = (CollectionTypeCS) dtParser.getSym(1);
			CSTNode result = createCollectionLiteralExpCS(typeCS, (EList) dtParser.getSym(3));
			setOffsets(result, typeCS, getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 102: CollectionRangeCS ::= OclExpressionCS ..
			// OclExpressionCS
			//
		case 102: {

			CSTNode result = createCollectionRangeCS((OCLExpressionCS) dtParser.getSym(1), (OCLExpressionCS) dtParser.getSym(3));
			setOffsets(result, (CSTNode) dtParser.getSym(1), (CSTNode) dtParser.getSym(3));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 104: CollectionLiteralPartCS ::= OclExpressionCS
			//
		case 104: {

			CSTNode result = createCollectionLiteralPartCS((OCLExpressionCS) dtParser.getSym(1));
			setOffsets(result, (CSTNode) dtParser.getSym(1));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 105: CollectionLiteralPartsCS ::= CollectionLiteralPartCS
			//
		case 105: {

			EList result = new BasicEList();
			result.add(dtParser.getSym(1));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 106: CollectionLiteralPartsCS ::= CollectionLiteralPartsCS ,
			// CollectionLiteralPartCS
			//
		case 106: {

			EList result = (EList) dtParser.getSym(1);
			result.add(dtParser.getSym(3));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 107: CollectionLiteralPartsCSopt ::= $Empty
			//
		case 107:
			dtParser.setSym1(new BasicEList());
			break;

		//
		// Rule 109: TupleLiteralExpCS ::= Tuple { TupleLiteralPartsCS }
		//
		case 109: {

			CSTNode result = createTupleLiteralExpCS((EList) dtParser.getSym(3));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 110: TupleLiteralPartCS ::= variableNameCS = OclExpressionCS
			//
		case 110: {

			SimpleNameCS name = (SimpleNameCS) dtParser.getSym(1);
			OCLExpressionCS initExpression = (OCLExpressionCS) dtParser.getSym(3);
			VariableCS result = createVariableCS(name, null, initExpression);
			setOffsets(result, name, initExpression);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 111: TupleLiteralPartCS ::= typedVariableCS =
			// OclExpressionCS
			//
		case 111: {

			VariableCS result = (VariableCS) dtParser.getSym(1);
			OCLExpressionCS initExpression = (OCLExpressionCS) dtParser.getSym(3);
			result.setInitExpression(initExpression);
			setOffsets(result, result, initExpression);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 112: TupleLiteralPartsCS ::= TupleLiteralPartCS
			//
		case 112: {

			EList result = new BasicEList();
			result.add(dtParser.getSym(1));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 113: TupleLiteralPartsCS ::= TupleLiteralPartsCS ,
			// TupleLiteralPartCS
			//
		case 113: {

			EList result = (EList) dtParser.getSym(1);
			result.add(dtParser.getSym(3));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 119: OperationCallExpCS ::= primaryExpCS ->
			// notIteratorNorReservedSimpleNameCS isMarkedPreCSopt (
			// argumentsCSopt )
			//
		case 119: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			CSTNode result = createArrowOperationCallExpCS(source, (SimpleNameCS) dtParser.getSym(3), (IsMarkedPreCS) dtParser.getSym(4), (EList) dtParser.getSym(6));
			setOffsets(result, source, getIToken(dtParser.getToken(7)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 120: OperationCallExpCS ::= primaryExpCS . binaryKeywordCS
			// isMarkedPreCSopt ( argumentsCSopt )
			//
		case 120:

			//
			// Rule 121: OperationCallExpCS ::= primaryExpCS . unaryKeywordCS
			// isMarkedPreCSopt ( argumentsCSopt )
			//
		case 121:

			//
			// Rule 122: OperationCallExpCS ::= primaryExpCS .
			// reservedPunctuationCS isMarkedPreCSopt ( argumentsCSopt )
			//
		case 122:

			//
			// Rule 123: OperationCallExpCS ::= primaryExpCS .
			// notReservedSimpleNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
		case 123: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			CSTNode result = createDotOperationCallExpCS(source, null, (SimpleNameCS) dtParser.getSym(3), (IsMarkedPreCS) dtParser.getSym(4), (EList) dtParser.getSym(6));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 124: OperationCallExpCS ::= literalSimpleNameCS
			// isMarkedPreCSopt ( argumentsCSopt )
			//
		case 124:

			//
			// Rule 125: OperationCallExpCS ::=
			// notLiteralNorReservedSimpleNameCS isMarkedPreCSopt (
			// argumentsCSopt )
			//
		case 125: {

			CSTNode result = createDotOperationCallExpCS(null, null, (SimpleNameCS) dtParser.getSym(1), (IsMarkedPreCS) dtParser.getSym(2), (EList) dtParser.getSym(4));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 126: OperationCallExpCS ::= qualifiedPathNameCS (
			// argumentsCSopt )
			//
		case 126: {

			PathNameCS pathNameCS = (PathNameCS) dtParser.getSym(1);
			SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
			OperationCallExpCS result = createDotOperationCallExpCS(null, pathNameCS, simpleNameCS, null, (EList) dtParser.getSym(3));
			setOffsets(result, pathNameCS, getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 127: OperationCallExpCS ::= primaryExpCS .
			// qualifiedPathNameCS isMarkedPreCSopt ( argumentsCSopt )
			//
		case 127: {

			PathNameCS pathNameCS = (PathNameCS) dtParser.getSym(3);
			SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			CallExpCS result = createDotOperationCallExpCS(source, pathNameCS, simpleNameCS, (IsMarkedPreCS) dtParser.getSym(4), (EList) dtParser.getSym(6));
			setOffsets(result, source, getIToken(dtParser.getToken(7)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 128: argumentsCS ::= OclExpressionCS
			//
		case 128: {

			EList result = new BasicEList();
			result.add(dtParser.getSym(1));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 129: argumentsCS ::= argumentsCS , OclExpressionCS
			//
		case 129: {

			EList result = (EList) dtParser.getSym(1);
			result.add(dtParser.getSym(3));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 130: argumentsCSopt ::= $Empty
			//
		case 130:
			dtParser.setSym1(new BasicEList());
			break;

		//
		// Rule 132: isMarkedPreCSopt ::= $Empty
		//
		case 132: {

			dtParser.setSym1(null);
			break;
		}

			//
			// Rule 133: PropertyCallExpCS ::= primaryExpCS .
			// notReservedSimpleNameCS isMarkedPreCSopt
			//
		case 133: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) dtParser.getSym(3);
			IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser.getSym(4);
			CSTNode result = createFeatureCallExpCS(source, null, simpleNameCS, new BasicEList(), isMarkedPreCS);
			if (isMarkedPreCS != null) {
				setOffsets(result, source, isMarkedPreCS);
			} else {
				setOffsets(result, source, simpleNameCS);
			}
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 134: PropertyCallExpCS ::= primaryExpCS .
			// qualifiedPathNameCS isMarkedPreCSopt
			//
		case 134: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			PathNameCS pathNameCS = (PathNameCS) dtParser.getSym(3);
			SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
			IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser.getSym(4);
			CSTNode result = createFeatureCallExpCS(source, pathNameCS, simpleNameCS, new BasicEList(), isMarkedPreCS);
			if (isMarkedPreCS != null) {
				setOffsets(result, source, isMarkedPreCS);
			} else {
				setOffsets(result, source, simpleNameCS);
			}
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 135: PropertyCallExpCS ::= qualifiedPathNameCS
			// isMarkedPreCSopt
			//
		case 135: {

			PathNameCS pathNameCS = (PathNameCS) dtParser.getSym(1);
			SimpleNameCS simpleNameCS = removeLastSimpleNameCS(pathNameCS);
			IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser.getSym(2);
			CSTNode result = createFeatureCallExpCS(null, pathNameCS, simpleNameCS, new BasicEList(), isMarkedPreCS);
			if (isMarkedPreCS != null) {
				setOffsets(result, pathNameCS, isMarkedPreCS);
			} else {
				setOffsets(result, pathNameCS, simpleNameCS);
			}
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 136: AssociationClassCallExpCS ::=
			// notLiteralNorReservedSimpleNameCS isMarkedPreCSopt
			//
		case 136: {

			IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS) dtParser.getSym(2);
			CSTNode result = createVariableExpCS((SimpleNameCS) dtParser.getSym(1), new BasicEList(), isMarkedPreCS);
			if (isMarkedPreCS != null) {
				setOffsets(result, (CSTNode) dtParser.getSym(1), (CSTNode) dtParser.getSym(2));
			} else {
				setOffsets(result, (CSTNode) dtParser.getSym(1));
			}
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 140: IterateExpCS ::= primaryExpCS -> iterateNameCS (
			// VariableDeclarationCS | OclExpressionCS )
			//
		case 140: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) dtParser.getSym(3);
			CSTNode result = createIterateExpCS(source, simpleNameCS, (VariableCS) dtParser.getSym(5), null, (OCLExpressionCS) dtParser.getSym(7));
			setOffsets(result, source, getIToken(dtParser.getToken(8)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 141: IterateExpCS ::= primaryExpCS -> iterateNameCS (
			// VariableDeclarationCS ; VariableDeclarationCS | OclExpressionCS )
			//
		case 141: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) dtParser.getSym(3);
			CSTNode result = createIterateExpCS(source, simpleNameCS, (VariableCS) dtParser.getSym(5), (VariableCS) dtParser.getSym(7), (OCLExpressionCS) dtParser.getSym(9));
			setOffsets(result, source, getIToken(dtParser.getToken(10)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 142: IteratorExpCS ::= primaryExpCS -> iteratorNameCS (
			// OclExpressionCS )
			//
		case 142: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) dtParser.getSym(3);
			CSTNode result = createIteratorExpCS(source, simpleNameCS, null, null, (OCLExpressionCS) dtParser.getSym(5));
			setOffsets(result, source, getIToken(dtParser.getToken(6)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 143: IteratorExpCS ::= primaryExpCS -> iteratorNameCS (
			// VariableDeclarationCS | OclExpressionCS )
			//
		case 143: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) dtParser.getSym(3);
			CSTNode result = createIteratorExpCS(source, simpleNameCS, (VariableCS) dtParser.getSym(5), null, (OCLExpressionCS) dtParser.getSym(7));
			setOffsets(result, source, getIToken(dtParser.getToken(8)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 144: IteratorExpCS ::= primaryExpCS -> iteratorNameCS (
			// VariableDeclarationCS , VariableDeclarationCS | OclExpressionCS )
			//
		case 144: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) dtParser.getSym(3);
			CSTNode result = createIteratorExpCS(source, simpleNameCS, (VariableCS) dtParser.getSym(5), (VariableCS) dtParser.getSym(7), (OCLExpressionCS) dtParser.getSym(9));
			setOffsets(result, source, getIToken(dtParser.getToken(10)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 149: LetExpCS ::= let variableDeclarationListCS in
			// OclExpressionCS
			//
		case 149: {

			OCLExpressionCS expr = (OCLExpressionCS) dtParser.getSym(4);
			CSTNode result = createLetExpCS((EList) dtParser.getSym(2), expr);
			setOffsets(result, getIToken(dtParser.getToken(1)), expr);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 154: impliesExpCS ::= impliesExpCS implies xorExpCS
			//
		case 154:

			//
			// Rule 155: impliesLetCS ::= impliesExpCS implies xorLetCS
			//
		case 155:

			//
			// Rule 158: xorExpCS ::= xorExpCS xor orExpCS
			//
		case 158:

			//
			// Rule 159: xorLetCS ::= xorExpCS xor orLetCS
			//
		case 159:

			//
			// Rule 162: orExpCS ::= orExpCS or andExpCS
			//
		case 162:

			//
			// Rule 163: orLetCS ::= orExpCS or andLetCS
			//
		case 163:

			//
			// Rule 166: andExpCS ::= andExpCS and equalityExpCS
			//
		case 166:

			//
			// Rule 167: andLetCS ::= andExpCS and equalityLetCS
			//
		case 167:

			//
			// Rule 170: equalityExpCS ::= equalityExpCS = relationalExpCS
			//
		case 170:

			//
			// Rule 171: equalityLetCS ::= equalityExpCS = relationalLetCS
			//
		case 171:

			//
			// Rule 172: equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
		case 172:

			//
			// Rule 173: equalityLetCS ::= equalityExpCS <> relationalLetCS
			//
		case 173:

			//
			// Rule 176: relationalExpCS ::= relationalExpCS > additiveExpCS
			//
		case 176:

			//
			// Rule 177: relationalLetCS ::= relationalExpCS > additiveLetCS
			//
		case 177:

			//
			// Rule 178: relationalExpCS ::= relationalExpCS < additiveExpCS
			//
		case 178:

			//
			// Rule 179: relationalLetCS ::= relationalExpCS < additiveLetCS
			//
		case 179:

			//
			// Rule 180: relationalExpCS ::= relationalExpCS >= additiveExpCS
			//
		case 180:

			//
			// Rule 181: relationalLetCS ::= relationalExpCS >= additiveLetCS
			//
		case 181:

			//
			// Rule 182: relationalExpCS ::= relationalExpCS <= additiveExpCS
			//
		case 182:

			//
			// Rule 183: relationalLetCS ::= relationalExpCS <= additiveLetCS
			//
		case 183:

			//
			// Rule 186: additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
		case 186:

			//
			// Rule 187: additiveLetCS ::= additiveExpCS + multiplicativeLetCS
			//
		case 187:

			//
			// Rule 188: additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
		case 188:

			//
			// Rule 189: additiveLetCS ::= additiveExpCS - multiplicativeLetCS
			//
		case 189:

			//
			// Rule 192: multiplicativeExpCS ::= multiplicativeExpCS *
			// unaryExpCS
			//
		case 192:

			//
			// Rule 193: multiplicativeLetCS ::= multiplicativeExpCS *
			// unaryLetCS
			//
		case 193:

			//
			// Rule 194: multiplicativeExpCS ::= multiplicativeExpCS /
			// unaryExpCS
			//
		case 194:

			//
			// Rule 195: multiplicativeLetCS ::= multiplicativeExpCS /
			// unaryLetCS
			//
		case 195: {

			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.STRING_LITERAL, getTokenText(dtParser.getToken(2)));
			setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
			OCLExpressionCS left = (OCLExpressionCS) dtParser.getSym(1);
			OCLExpressionCS right = (OCLExpressionCS) dtParser.getSym(3);
			EList args = new BasicEList();
			args.add(right);
			CSTNode result = createOperationCallExpCS(left, simpleNameCS, args);
			setOffsets(result, left, right);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 198: unaryExpCS ::= - unaryExpCS
			//
		case 198:

			//
			// Rule 199: unaryLetCS ::= - unaryLetCS
			//
		case 199:

			//
			// Rule 200: unaryExpCS ::= not unaryExpCS
			//
		case 200:

			//
			// Rule 201: unaryLetCS ::= not unaryLetCS
			//
		case 201: {

			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.STRING_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
			OCLExpressionCS expr = (OCLExpressionCS) dtParser.getSym(2);
			CSTNode result = createOperationCallExpCS(expr, simpleNameCS, new BasicEList());
			setOffsets(result, simpleNameCS, expr);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 205: primaryExpCS ::= ( OclExpressionCS )
			//
		case 205: {

			CSTNode result = (CSTNode) dtParser.getSym(2);
			if (result instanceof OperationCallExpCS) {
				((OperationCallExpCS) result).setIsAtomic(true);
			}
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 208: declarator1 ::= IDENTIFIER : typeCS
			//
		case 208: {

			CSTNode result = createVariableCS(getTokenText(dtParser.getToken(1)), (TypeCS) dtParser.getSym(3), null);
			setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(3));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 209: declarator1 ::= IDENTIFIER : typeCS = OclExpressionCS
			//
		case 209: {

			CSTNode result = createVariableCS(getTokenText(dtParser.getToken(1)), (TypeCS) dtParser.getSym(3), (OCLExpressionCS) dtParser.getSym(5));
			setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(5));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 210: declarator1 ::= IDENTIFIER : typeCS := OclExpressionCS
			//
		case 210: {

			CSTNode result = createVariableCS(getTokenText(dtParser.getToken(1)), (TypeCS) dtParser.getSym(3), (OCLExpressionCS) dtParser.getSym(5));
			setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(5));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 211: declarator2 ::= IDENTIFIER := OclExpressionCS
			//
		case 211: {

			CSTNode result = createVariableCS(getTokenText(dtParser.getToken(1)), null, (OCLExpressionCS) dtParser.getSym(3));
			setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(3));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 212: letExpSubCS3 ::= variableNameCS = OclExpressionCS
			//
		case 212: {

			SimpleNameCS name = (SimpleNameCS) dtParser.getSym(1);
			OCLExpressionCS initExpression = (OCLExpressionCS) dtParser.getSym(3);
			VariableCS variableCS = createVariableCS(name, null, initExpression);
			setOffsets(variableCS, name, initExpression);

			EList result = new BasicEList();
			result.add(variableCS);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 213: letExpSubCS3 ::= letExpSubCS3 , TupleLiteralPartCS
			//
		case 213: {

			EList result = (EList) dtParser.getSym(1);
			result.add(dtParser.getSym(3));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 214: LetExpCS ::= let letExpSubCS3 in OclExpressionCS
			//
		case 214: {

			EList variables = (EList) dtParser.getSym(2);
			CSTNode result = createLetExpCS(variables, (OCLExpressionCS) dtParser.getSym(4));
			setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(4));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 215: LetExpCS ::= let letExpSubCS3 in qvtErrorToken
			//
		case 215: {

			EList variables = (EList) dtParser.getSym(2);
			CSTNode result = createLetExpCS(variables, createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, "") //$NON-NLS-1$
			);
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 216: CallExpCS ::= . qvtErrorToken
			//
		case 216: {

			CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
			result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 217: CallExpCS ::= -> qvtErrorToken
			//
		case 217: {

			CallExpCS result = TempFactory.eINSTANCE.createErrorCallExpCS();
			result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 218: argumentsCS ::= qvtErrorToken
			//
		case 218:
			dtParser.setSym1(new BasicEList());
			break;

		//
		// Rule 220: IteratorExpCS ::= primaryExpCS -> iteratorNameCS (
		// qvtErrorToken
		//
		case 220: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			SimpleNameCS simpleNameCS = (SimpleNameCS) dtParser.getSym(3);
			CSTNode result = createIteratorExpCS(source, simpleNameCS, null, null, null);
			setOffsets(result, source, getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 221: qvtErrorToken ::= ERROR_TOKEN
			//
		case 221: {

			diagnozeErrorToken(dtParser.getToken(1));
			break;
		}

			//
			// Rule 222: equalityExpCS ::= equalityExpCS != relationalExpCS
			//
		case 222:

			//
			// Rule 223: equalityLetCS ::= equalityExpCS != relationalLetCS
			//
		case 223: {

			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.STRING_LITERAL, OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL));
			setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
			EList args = new BasicEList();
			args.add(dtParser.getSym(3));
			CSTNode result = createOperationCallExpCS((OCLExpressionCS) dtParser.getSym(1), simpleNameCS, args);
			setOffsets(result, (CSTNode) dtParser.getSym(1), (CSTNode) dtParser.getSym(3));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 224: StringLiteralExpCS ::= StringLiteralExpCS
			// STRING_LITERAL
			//
		case 224: {

			IToken literalToken = getIToken(dtParser.getToken(2));
			StringLiteralExpCS result = (StringLiteralExpCS) dtParser.getSym(1);
			result.setSymbol(result.getSymbol() + literalToken.toString());
			result.setStringSymbol(result.getStringSymbol() + literalToken.toString());
			result.setUnescapedStringSymbol(result.getUnescapedStringSymbol() + unescape(literalToken));
			int tokenLine = literalToken.getLine();
			setOffsets(result, result, literalToken);
			IToken prevToken = getParseStream().getTokenAt(literalToken.getTokenIndex() - 1);
			int prevTokenLine = prevToken.getLine();
			if (prevTokenLine == tokenLine) {
				reportError(lpg.lpgjavaruntime.ParseErrorCodes.INVALID_CODE,
						"", prevToken.getTokenIndex(), literalToken.getTokenIndex(), "Multiline string literals must be located in different lines!"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 226: listTypeCS ::= List ( typeCS )
			//
		case 226: {

			CSTNode result = createListTypeCS((TypeCS) dtParser.getSym(3));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 227: listLiteralCS ::= List { CollectionLiteralPartsCSopt }
			//
		case 227: {

			CSTNode result = createListLiteralExpCS((EList) dtParser.getSym(3));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 229: dictTypeCS ::= Dict ( typeCS , typeCS )
			//
		case 229: {

			CSTNode result = createDictTypeCS((TypeCS) dtParser.getSym(3), (TypeCS) dtParser.getSym(5));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 230: dictLiteralCS ::= Dict { dictLiteralPartListCSopt }
			//
		case 230: {

			CSTNode result = createDictLiteralExpCS((EList<DictLiteralPartCS>) dtParser.getSym(3));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 235: dictLiteralPartCS ::= literalSimpleCS = OclExpressionCS
			//
		case 235: {

			CSTNode result = createDictLiteralPartCS((LiteralExpCS) dtParser.getSym(1), (OCLExpressionCS) dtParser.getSym(3));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 237: dictLiteralPartListCSopt ::= $Empty
			//
		case 237:
			dtParser.setSym1(new BasicEList());
			break;

		//
		// Rule 238: dictLiteralPartListCS ::= dictLiteralPartCS
		//
		case 238: {

			EList result = new BasicEList();
			result.add(dtParser.getSym(1));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 239: dictLiteralPartListCS ::= dictLiteralPartListCS ,
			// dictLiteralPartCS
			//
		case 239: {

			EList result = (EList) dtParser.getSym(1);
			result.add(dtParser.getSym(3));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 240: dictLiteralPartListCS ::= dictLiteralPartListCS
			// qvtErrorToken
			//
		case 240: {

			EList result = (EList) dtParser.getSym(1);
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 242: IfExpCS ::= if OclExpressionCS then ifExpBodyCS else
			// ifExpBodyCS endif
			//
		case 242: {

			CSTNode result = createIfExpCS((OCLExpressionCS) dtParser.getSym(2), (OCLExpressionCS) dtParser.getSym(4), (OCLExpressionCS) dtParser.getSym(6));
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 243: IfExpCS ::= if OclExpressionCS then ifExpBodyCS endif
			//
		case 243: {

			CSTNode result = createIfExpCS((OCLExpressionCS) dtParser.getSym(2), (OCLExpressionCS) dtParser.getSym(4), null);
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 244: IfExpCS ::= if OclExpressionCS then ifExpBodyCS else
			// ifExpBodyCS qvtErrorToken
			//
		case 244: {

			CSTNode result = createIfExpCS((OCLExpressionCS) dtParser.getSym(2), (OCLExpressionCS) dtParser.getSym(4), (OCLExpressionCS) dtParser.getSym(6));
			setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(6));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 245: IfExpCS ::= if OclExpressionCS then ifExpBodyCS else
			// qvtErrorToken
			//
		case 245: {

			CSTNode result = createIfExpCS((OCLExpressionCS) dtParser.getSym(2), (OCLExpressionCS) dtParser.getSym(4), null);
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 246: IfExpCS ::= if OclExpressionCS then ifExpBodyCS
			// qvtErrorToken
			//
		case 246: {

			CSTNode result = createIfExpCS((OCLExpressionCS) dtParser.getSym(2), (OCLExpressionCS) dtParser.getSym(4), null);
			setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(4));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 247: IfExpCS ::= if OclExpressionCS then qvtErrorToken
			//
		case 247: {

			CSTNode result = createIfExpCS((OCLExpressionCS) dtParser.getSym(2), null, null);
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 248: IfExpCS ::= if OclExpressionCS qvtErrorToken
			//
		case 248: {

			CSTNode result = createIfExpCS((OCLExpressionCS) dtParser.getSym(2), null, null);
			setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode) dtParser.getSym(2));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 249: IfExpCS ::= if qvtErrorToken
			//
		case 249: {

			OCLExpressionCS invalidCondition = createInvalidLiteralExpCS(""); //$NON-NLS-1$
			invalidCondition.setStartOffset(getIToken(dtParser.getToken(1)).getEndOffset());
			invalidCondition.setEndOffset(getIToken(dtParser.getToken(1)).getEndOffset());
			CSTNode result = createIfExpCS(invalidCondition, null, null);
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 250: IterateExpCS ::= primaryExpCS -> imperativeIterateExpCS
			//
		case 250: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			ImperativeIterateExpCS iterateExpCS = (ImperativeIterateExpCS) dtParser.getSym(3);
			iterateExpCS.setSource(source);
			setOffsets(iterateExpCS, source, iterateExpCS);
			dtParser.setSym1(iterateExpCS);
			break;
		}

			//
			// Rule 259: imperativeIterateExpCS ::=
			// imperativeIteratorExpCSToken12 ( imperativeIterContents12 )
			//
		case 259:

			//
			// Rule 260: imperativeIterateExpCS ::=
			// imperativeIteratorExpCSToken3 ( imperativeIterContents3 )
			//
		case 260: {

			String opCode = getTokenText(dtParser.getToken(1));
			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCode);
			setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
			Object[] iterContents = (Object[]) dtParser.getSym(3);
			OCLExpressionCS bodyCS = null;
			OCLExpressionCS conditionCS = null;
			if ("xcollect".equals(opCode) || "collectOne".equals(opCode)) { //$NON-NLS-1$ //$NON-NLS-2$ 
				bodyCS = (OCLExpressionCS) iterContents[2];
			} else {
				conditionCS = (OCLExpressionCS) iterContents[2];
			}
			CSTNode result = createImperativeIterateExpCS(simpleNameCS, (EList<VariableCS>) iterContents[0], (VariableCS) iterContents[1], bodyCS, conditionCS);
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 261: imperativeIterateExpCS ::= imperativeIteratorExpCSToken
			// qvtErrorToken
			//
		case 261: {

			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, getTokenText(dtParser.getToken(1)));
			setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
			CSTNode result = createImperativeIterateExpCS(simpleNameCS, ourEmptyEList, null, null, null);
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 262: imperativeIterContents12 ::= OclExpressionCS
			//
		case 262: {

			dtParser.setSym1(new Object[] { ourEmptyEList, null, dtParser.getSym(1) });
			break;
		}

			//
			// Rule 263: imperativeIterContents12 ::= variableDeclarationListCS
			// | OclExpressionCS
			//
		case 263: {

			dtParser.setSym1(new Object[] { dtParser.getSym(1), null, dtParser.getSym(3) });
			break;
		}

			//
			// Rule 264: imperativeIterContents3 ::= variableDeclarationListCS ;
			// TupleLiteralPartCS | OclExpressionCS
			//
		case 264: {

			dtParser.setSym1(new Object[] { dtParser.getSym(1), dtParser.getSym(3), dtParser.getSym(5) });
			break;
		}

			//
			// Rule 265: exclamationOpt ::= $Empty
			//
		case 265:
			dtParser.setSym1(null);
			break;

		//
		// Rule 267: declarator_vsep ::= IDENTIFIER |
		//
		case 267: {

			CSTNode result = createVariableCS(getTokenText(dtParser.getToken(1)), null, null);
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 268: declarator_vsepOpt ::= $Empty
			//
		case 268:
			dtParser.setSym1(null);
			break;

		//
		// Rule 270: IterateExpCS ::= primaryExpCS exclamationOpt [
		// declarator_vsepOpt OclExpressionCS ]
		//
		case 270: {

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			if (source instanceof ImperativeIterateExpCS) {
				String opCode = isTokenOfType(getIToken(dtParser.getToken(2)), XpandParsersym.TK_EXCLAMATION_MARK) ? "collectselectOne" : "collectselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
				SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCode);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(3)), getIToken(dtParser.getToken(6)));

				ImperativeIterateExpCS result = (ImperativeIterateExpCS) source;
				result.setSimpleNameCS(simpleNameCS);

				VariableCS variableCS = (VariableCS) dtParser.getSym(4);
				if (variableCS != null) {
					result.setTarget(variableCS);
				}
				result.setCondition((OCLExpressionCS) dtParser.getSym(5));

				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
			} else {
				String opCode = isTokenOfType(getIToken(dtParser.getToken(2)), XpandParsersym.TK_EXCLAMATION_MARK) ? "selectOne" : "xselect"; //$NON-NLS-1$ //$NON-NLS-2$ 
				SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCode);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(3)), getIToken(dtParser.getToken(6)));

				CallExpCS result = createImperativeIterateExpCS(simpleNameCS, ourEmptyEList, (VariableCS) dtParser.getSym(4), null, (OCLExpressionCS) dtParser.getSym(5));
				result.setSource(source);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
			}
			break;
		}

			//
			// Rule 271: IterateExpCS ::= primaryExpCS ->
			// notReservedSimpleNameCS
			//
		case 271: {

			String opCode = "xcollect"; //$NON-NLS-1$
			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.KEYWORD_LITERAL, opCode);

			OCLExpressionCS source = (OCLExpressionCS) dtParser.getSym(1);
			SimpleNameCS featureNameCS = (SimpleNameCS) dtParser.getSym(3);
			OCLExpressionCS featureCallExpCS = createFeatureCallExpCS(source, null, featureNameCS, new BasicEList(), null);
			setOffsets(featureCallExpCS, source, featureNameCS);

			ImperativeIterateExpCS result = createImperativeIterateExpCS(simpleNameCS, ourEmptyEList, null, null, null);
			result.setSource(featureCallExpCS);
			setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 272: primaryExpCS ::= break
			//
		case 272: {

			OCLExpressionCS result = createBreakCS();
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 273: primaryExpCS ::= continue
			//
		case 273: {

			OCLExpressionCS result = createContinueCS();
			setOffsets(result, getIToken(dtParser.getToken(1)));
			dtParser.setSym1(result);
			break;
		}

			//
			// Rule 274: template ::= emptyTemplate
			//
		case 274: {

			setResult(xpandFactory.createTemplate(Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, getRightIToken()));
			break;
		}
			//
			// Rule 277: template ::= LG commentTextPairAny imports
			// extensionImports defineOrAroundSeq
			//
		case 277: {

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
			// Rule 278: defineOrAroundSeq ::= define TEXT commentTextPairAny
			// defineOrAroundSuffix
			//
		case 278: {

			List result = new LinkedList();
			result.add(getRhsSym(1));
			result.addAll((List) getRhsSym(4));
			setResult(result);
			break;
		}
			//
			// Rule 279: defineOrAroundSeq ::= around TEXT commentTextPairAny
			// defineOrAroundSuffix
			//
		case 279: {

			List result = new LinkedList();
			result.add(getRhsSym(1));
			result.addAll((List) getRhsSym(4));
			setResult(result);
			break;
		}
			//
			// Rule 280: defineOrAroundSuffix ::= $Empty
			//
		case 280: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 284: imports ::= $Empty
			//
		case 284: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 285: imports ::= anImport imports
			//
		case 285: {

			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
			break;
		}
			//
			// Rule 286: anImport ::= IMPORT StringLiteralExpCS TEXT
			// commentTextPairAny
			//
		case 286: {

			setResult(xpandFactory.createNamespaceImport(getLeftIToken(), (StringLiteralExpCS) getRhsSym(2)));
			break;
		}
			//
			// Rule 287: extensionImports ::= $Empty
			//
		case 287: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 288: extensionImports ::= anExtensionImport extensionImports
			//
		case 288: {

			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
			break;
		}
			//
			// Rule 289: anExtensionImport ::= EXTENSION pathNameCS TEXT
			// commentTextPairAny
			//
		case 289: {

			setResult(xpandFactory.createImportDeclaration(getLeftIToken(), (PathNameCS) getRhsSym(2)));
			break;
		}
			//
			// Rule 290: around ::= AROUND pointcut FOR typeCS sequence
			// ENDAROUND
			//
		case 290: {

			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), Collections.<VariableCS> emptyList(), false, (TypeCS) getRhsSym(4), (List) getRhsSym(5)));
			break;
		}
			//
			// Rule 291: around ::= AROUND pointcut LPAREN parametersList RPAREN
			// FOR typeCS sequence ENDAROUND
			//
		case 291: {

			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), (List<VariableCS>) getRhsSym(4), false, (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
			break;
		}
			//
			// Rule 292: around ::= AROUND pointcut LPAREN parametersList COMMA
			// MULTIPLY RPAREN FOR typeCS sequence ENDAROUND
			//
		case 292: {

			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), (List<VariableCS>) getRhsSym(4), true, (TypeCS) getRhsSym(9), (List) getRhsSym(10)));
			break;
		}
			//
			// Rule 293: around ::= AROUND pointcut LPAREN MULTIPLY RPAREN FOR
			// typeCS sequence ENDAROUND
			//
		case 293: {

			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), Collections.<VariableCS> emptyList(), true, (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
			break;
		}
			//
			// Rule 294: pointcut ::= MULTIPLY pointcutSuffix
			//
		case 294: {

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
			// Rule 295: pointcut ::= IDENTIFIER pointcutSuffix
			//
		case 295: {

			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
			break;
		}
			//
			// Rule 296: pointcutSuffix ::= $Empty
			//
		case 296: {

			setResult(null);
			break;
		}
			//
			// Rule 298: pointcutSuffix ::= COLONCOLON pointcutSuffix
			//
		case 298: {

			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
			break;
		}
			//
			// Rule 299: define ::= DEFINE IDENTIFIER FOR typeCS sequence
			// ENDDEFINE
			//
		case 299: {

			setResult(xpandFactory.createDefinition(getLeftIToken(), getRightIToken(), getRhsIToken(2), Collections.<VariableCS> emptyList(), (TypeCS) getRhsSym(4), (List) getRhsSym(5)));
			break;
		}
			//
			// Rule 300: define ::= DEFINE IDENTIFIER LPAREN parametersList
			// RPAREN FOR typeCS sequence ENDDEFINE
			//
		case 300: {

			setResult(xpandFactory.createDefinition(getLeftIToken(), getRightIToken(), getRhsIToken(2), (List<VariableCS>) getRhsSym(4), (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
			break;
		}
			//
			// Rule 301: parametersList ::= parameter
			//
		case 301: {

			VariableCS param = (VariableCS) getRhsSym(1);
			LinkedList res = new LinkedList();
			res.add(param);
			setResult(res);
			break;
		}
			//
			// Rule 302: parametersList ::= parametersList , parameter
			//
		case 302: {

			VariableCS param = (VariableCS) getRhsSym(3);
			LinkedList res = new LinkedList();
			res.addAll((List) getRhsSym(1));
			res.add(param);
			setResult(res);
			break;
		}
			//
			// Rule 304: parameter ::= typeCS IDENTIFIER
			//
		case 304: {

			VariableCS result = createVariableCS(getRhsIToken(2).toString(), (TypeCS) getRhsSym(1), null);
			setOffsets(result, (TypeCS) getRhsSym(1), getRhsIToken(2));
			setResult(result);
			break;
		}
			//
			// Rule 305: sequence ::= text sequenceSuffix
			//
		case 305: {

			List res = new LinkedList();
			res.addAll((List) getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
			break;
		}
			//
			// Rule 306: sequenceSuffix ::= $Empty
			//
		case 306: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 307: sequenceSuffix ::= statement text sequenceSuffix
			//
		case 307: {

			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			res.addAll((List) getRhsSym(3));
			setResult(res);
			break;
		}
			//
			// Rule 314: text ::= minusOpt TEXT textSuffix
			//
		case 314: {

			List res = new LinkedList();
			res.add(xpandFactory.createTextStatement(getRhsIToken(2), (IToken) getRhsSym(1)));
			res.addAll((List) getRhsSym(3));
			setResult(res);
			break;
		}
			//
			// Rule 315: textSuffix ::= $Empty
			//
		case 315: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 316: textSuffix ::= minusOpt TEXT textSuffix
			//
		case 316: {

			List res = new LinkedList();
			res.add(xpandFactory.createTextStatement(getRhsIToken(2), (IToken) getRhsSym(1)));
			res.addAll((List) getRhsSym(3));
			setResult(res);
			break;
		}
			//
			// Rule 317: minusOpt ::= $Empty
			//
		case 317: {

			setResult(null);
			break;
		}
			//
			// Rule 318: minusOpt ::= MINUS
			//
		case 318: {

			setResult(getLeftIToken());
			break;
		}
			//
			// Rule 322: errorStatement ::= ERROR OclExpressionCS
			//
		case 322: {

			setResult(xpandFactory.createErrorStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2)));
			break;
		}
			//
			// Rule 323: expandStatement ::= EXPAND definitionName
			// parameterListOpt
			//
		case 323: {

			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), null, false, null));
			break;
		}
			//
			// Rule 324: expandStatement ::= EXPAND definitionName
			// parameterListOpt FOR OclExpressionCS
			//
		case 324: {

			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), false, null));
			break;
		}
			//
			// Rule 325: expandStatement ::= EXPAND definitionName
			// parameterListOpt FOREACH OclExpressionCS separatorOpt
			//
		case 325: {

			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), true, (OCLExpressionCS) getRhsSym(6)));
			break;
		}
			//
			// Rule 326: parameterListOpt ::= $Empty
			//
		case 326: {

			setResult(Collections.EMPTY_LIST);
			break;
		}
			//
			// Rule 327: parameterListOpt ::= LPAREN argumentsCS RPAREN
			//
		case 327: {

			setResult(getRhsSym(2));
			break;
		}
			//
			// Rule 329: expressionStmt ::= OclExpressionCS
			//
		case 329: {

			// XXX OCL CST doesn't keep track of line numbers, but we use them
			// (perhaps, might refactor to stop using?)
			int lineNumber = getLeftIToken().getLine();
			setResult(xpandFactory.createExpressionStatement((OCLExpressionCS) getRhsSym(1), lineNumber));
			break;
		}
			//
			// Rule 330: fileStatement ::= FILE OclExpressionCS identOpt
			// sequence ENDFILE
			//
		case 330: {

			setResult(xpandFactory.createFileStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), (Identifier) getRhsSym(3), (List) getRhsSym(4)));
			break;
		}
			//
			// Rule 331: identOpt ::= $Empty
			//
		case 331: {

			setResult(null);
			break;
		}
			//
			// Rule 332: identOpt ::= IDENTIFIER
			//
		case 332: {

			setResult(xpandFactory.createIdentifier(getLeftIToken()));
			break;
		}
			//
			// Rule 333: foreachStatement ::= FOREACH OclExpressionCS AS
			// IDENTIFIER iteratorOpt separatorOpt sequence ENDFOREACH
			//
		case 333: {

			setResult(xpandFactory.createForEachStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), getRhsIToken(4), (OCLExpressionCS) getRhsSym(6), (IToken) getRhsSym(5),
					(List) getRhsSym(7)));
			break;
		}
			//
			// Rule 334: iteratorOpt ::= $Empty
			//
		case 334: {

			setResult(null);
			break;
		}
			//
			// Rule 335: iteratorOpt ::= ITERATOR IDENTIFIER
			//
		case 335: {

			setResult(getRightIToken());
			break;
		}
			//
			// Rule 336: separatorOpt ::= $Empty
			//
		case 336: {

			setResult(null);
			break;
		}
			//
			// Rule 337: separatorOpt ::= SEPARATOR OclExpressionCS
			//
		case 337: {

			setResult(getRhsSym(2));
			break;
		}
			//
			// Rule 338: ifStatement ::= IF OclExpressionCS sequence elseifAny
			// elseOpt ENDIF
			//
		case 338: {

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
			// Rule 339: elseifAny ::= $Empty
			//
		case 339: {

			setResult(null);
			break;
		}
			//
			// Rule 340: elseifAny ::= ELSEIF OclExpressionCS sequence elseifAny
			//
		case 340: {

			IfStatement elseIf = xpandFactory.createIfStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2), (List) getRhsSym(3), null);
			IfStatement restElseIf = (IfStatement) getRhsSym(4);
			elseIf.setElseIf(restElseIf);
			setResult(elseIf);
			break;
		}
			//
			// Rule 341: elseOpt ::= $Empty
			//
		case 341: {

			setResult(null);
			break;
		}
			//
			// Rule 342: elseOpt ::= ELSE sequence
			//
		case 342: {

			setResult(xpandFactory.createIfStatement(getLeftIToken(), null, (List) getRhsSym(2), null));
			break;
		}
			//
			// Rule 343: letStatement ::= LET OclExpressionCS AS IDENTIFIER
			// sequence ENDLET
			//
		case 343: {

			setResult(xpandFactory.createLetStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), getRhsIToken(4), (List) getRhsSym(5)));
			break;
		}
			//
			// Rule 344: protectStatement ::= PROTECT CSTART OclExpressionCS
			// CEND OclExpressionCS ID OclExpressionCS disabledOpt sequence
			// ENDPROTECT
			//
		case 344: {

			setResult(xpandFactory.createProtectStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), (OCLExpressionCS) getRhsSym(7),
					(IToken) getRhsSym(8), (List) getRhsSym(9)));
			break;
		}
			//
			// Rule 345: disabledOpt ::= $Empty
			//
		case 345: {

			setResult(null);
			break;
		}
			//
			// Rule 346: disabledOpt ::= DISABLE
			//
		case 346: {

			setResult(getLeftIToken());
			break;
		}

		default:
			break;
		}
		return;
	}
}
