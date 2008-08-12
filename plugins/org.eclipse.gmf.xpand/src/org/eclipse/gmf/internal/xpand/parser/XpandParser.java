/*
 * Copyright (c) 2006, 2008 Borland Software Corporation and others.
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

import lpg.lpgjavaruntime.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.gmf.internal.xpand.util.ParserException.ErrorLocationInfo;

import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
import org.eclipse.gmf.internal.xpand.ast.*;
import org.eclipse.ocl.cst.*;
import java.util.Collections;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CallExpCS;
import org.eclipse.ocl.cst.CollectionTypeIdentifierEnum;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.IntegerLiteralExpCS;
import org.eclipse.ocl.cst.IsMarkedPreCS;
import org.eclipse.ocl.cst.MessageExpCS;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OCLMessageArgCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.SimpleTypeEnum;
import org.eclipse.ocl.cst.StateExpCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.PredefinedType;

import lpg.lpgjavaruntime.BadParseException;
import lpg.lpgjavaruntime.BadParseSymFileException;
import lpg.lpgjavaruntime.DeterministicParser;
import lpg.lpgjavaruntime.DiagnoseParser;
import lpg.lpgjavaruntime.IToken;
import lpg.lpgjavaruntime.Monitor;
import lpg.lpgjavaruntime.NotDeterministicParseTableException;
import lpg.lpgjavaruntime.ParseTable;
import lpg.lpgjavaruntime.RuleAction;

public class XpandParser extends PrsStream implements RuleAction {
    private static ParseTable prs = new XpandParserprs();
    private DeterministicParser dtParser;

    public DeterministicParser getParser() { return dtParser; }
    private void setResult(Object object) { dtParser.setSym1(object); }
    public Object getRhsSym(int i) { return dtParser.getSym(i); }

    public int getRhsTokenIndex(int i) { return dtParser.getToken(i); }
    public IToken getRhsIToken(int i) { return super.getIToken(getRhsTokenIndex(i)); }
    
    public int getRhsFirstTokenIndex(int i) { return dtParser.getFirstToken(i); }
    public IToken getRhsFirstIToken(int i) { return super.getIToken(getRhsFirstTokenIndex(i)); }

    public int getRhsLastTokenIndex(int i) { return dtParser.getLastToken(i); }
    public IToken getRhsLastIToken(int i) { return super.getIToken(getRhsLastTokenIndex(i)); }

    public int getLeftSpan() { return dtParser.getFirstToken(); }
    public IToken getLeftIToken()  { return super.getIToken(getLeftSpan()); }

    public int getRightSpan() { return dtParser.getLastToken(); }
    public IToken getRightIToken() { return super.getIToken(getRightSpan()); }

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
        }
        catch(NullExportedSymbolsException e) {
        }
        catch(NullTerminalSymbolsException e) {
        }
        catch(UnimplementedTerminalsException e) {
            java.util.ArrayList<?> unimplemented_symbols = e.getSymbols();
            System.out.println("The Lexer will not scan the following token(s):");
            for (int i = 0; i < unimplemented_symbols.size(); i++)
            {
                Integer id = (Integer) unimplemented_symbols.get(i);
                System.out.println("    " + XpandParsersym.orderedTerminalSymbols[id.intValue()]);               
            }
            System.out.println();                        
        }
        catch(UndefinedEofSymbolException e) {
            throw new Error(new UndefinedEofSymbolException
                                ("The Lexer does not implement the Eof symbol " +
                                 XpandParsersym.orderedTerminalSymbols[XpandParserprs.EOFT_SYMBOL]));
        } 
    }

    public String[] orderedTerminalSymbols() { return XpandParsersym.orderedTerminalSymbols; }
    public String getTokenKindName(int kind) { return XpandParsersym.orderedTerminalSymbols[kind]; }            
    public int getEOFTokenKind() { return XpandParserprs.EOFT_SYMBOL; }
    public PrsStream getParseStream() { return (PrsStream) this; }

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
            dtParser = new DeterministicParser(monitor, (TokenStream)this, prs, (RuleAction)this);
        }
        catch (NotDeterministicParseTableException e) {
            throw new Error(new NotDeterministicParseTableException
                                ("Regenerate XpandParserprs.java with -NOBACKTRACK option"));
        }
        catch (BadParseSymFileException e) {
            throw new Error(new BadParseSymFileException("Bad Parser Symbol File -- XpandParsersym.java. Regenerate XpandParserprs.java"));
        }

        try {
            return (Template) dtParser.parse();
        }
        catch (BadParseException e) {
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
	public void reportError(int errorCode, String locationInfo, int leftToken, int rightToken, String tokenText) {
		final int leftTokenLine = getLine(leftToken);
		final int leftTokenColumn = getColumn(leftToken);
		final int rightTokenLine = getEndLine(rightToken);
		final int rightTokenColumn = getEndColumn(rightToken);
		final String msg = tokenText + errorMsgText[errorCode];
		errors.add(new ErrorLocationInfo(msg, leftTokenLine, leftTokenColumn, rightTokenLine, rightTokenColumn));
	}
/*
	@Override
	public void reportError(int leftToken, int rightToken) {
		int errorCode = (rightToken >= getStreamLength() ? EOF_CODE : leftToken == rightToken ? LEX_ERROR_CODE : INVALID_TOKEN_CODE);
		int endToken = (leftToken == rightToken ? rightToken : rightToken - 1);
		String msg = (errorCode == EOF_CODE ? "End-of-file " : errorCode == INVALID_TOKEN_CODE
					? "\"" + new String(getInputChars(), leftToken, rightToken - leftToken) + "\" "
					: "\"" + getCharValue(leftToken) + "\" ");

		final int leftTokenLine = getLine(leftToken);
		final int leftTokenColumn = getColumn(leftToken);
		final int rightTokenLine = getEndLine(endToken);
		final int rightTokenColumn = getEndColumn(endToken);
		errors.add(new ErrorLocationInfo(msg, leftTokenLine, leftTokenColumn, rightTokenLine, rightTokenColumn));
	}
*/
	@Override
	public void reportError(int errorCode, String locationInfo, String tokenText) {
		try {
			Matcher m = Pattern.compile("(?:[^:]+::)*[^:]+:(\\d+):(\\d+):(\\d+):(\\d+):.*").matcher(locationInfo);
			boolean t = m.matches(); // ignore return value, rely on exception if anything wrong
			assert t;
			final int leftTokenLine = getLine(Integer.parseInt(m.group(1)));
			final int leftTokenColumn = getColumn(Integer.parseInt(m.group(2)));
			final int rightTokenLine = getEndLine(Integer.parseInt(m.group(3)));
			final int rightTokenColumn = getEndColumn(Integer.parseInt(m.group(4)));
			final String msg = tokenText + errorMsgText[errorCode];
			errors.add(new ErrorLocationInfo(msg, leftTokenLine, leftTokenColumn, rightTokenLine, rightTokenColumn));
		} catch (Throwable ex) {
			// ignore
			errors.add(new ErrorLocationInfo(tokenText + errorMsgText[errorCode]));
		}
	}

	private final XpandFactory xpandFactory;



private OperationCS createOperationCS(
		PathNameCS pathNameCS,
		SimpleNameCS simpleNameCS,
		EList<VariableCS> list,
		TypeCS typeCS) {
	OperationCS result = CSTFactory.eINSTANCE.createOperationCS();
	result.setPathNameCS(pathNameCS);
	result.setSimpleNameCS(simpleNameCS);
	result.getParameters().addAll(list);
	result.setTypeCS(typeCS);
	return result;
}

private OperationCS createOperationCS(
		String simpleName,
		EList<VariableCS> list,
		TypeCS typeCS) {
	return createOperationCS(
			null,
			createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName),
			list,
			typeCS);
}

private OperationCallExpCS createOperationCallExpCS(
		OCLExpressionCS oclExpressionCS,
		SimpleNameCS simpleNameCS,
		IsMarkedPreCS isMarkedPreCS,
		EList<OCLExpressionCS> arguments) {
	OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
	result.setSource(oclExpressionCS);
	result.setSimpleNameCS(simpleNameCS);
	result.setIsMarkedPreCS(isMarkedPreCS);
	result.getArguments().addAll(arguments);
	return result;
}

private OperationCallExpCS createOperationCallExpCS(
		OCLExpressionCS oclExpressionCS,
		SimpleNameCS simpleNameCS,
		EList<OCLExpressionCS> arguments) {
	return createOperationCallExpCS(oclExpressionCS, simpleNameCS,
			createIsMarkedPreCS(false), arguments);
}

private OperationCallExpCS createOperationCallExpCS(
		SimpleNameCS simpleNameCS,
		IsMarkedPreCS isMarkedPreCS,
		EList<OCLExpressionCS> arguments) {
	return createOperationCallExpCS(null, simpleNameCS, isMarkedPreCS, arguments);
}

private OperationCallExpCS createOperationCallExpCS(
		SimpleNameCS simpleNameCS,
		IsMarkedPreCS isMarkedPreCS,
		StateExpCS stateExpCS) {
	OperationCallExpCS result = CSTFactory.eINSTANCE.createOperationCallExpCS();
	result.setSimpleNameCS(simpleNameCS);
	result.setIsMarkedPreCS(isMarkedPreCS);
	result.getArguments().add(stateExpCS);
	return result;
}

private StateExpCS createStateExpCS(PathNameCS pathName) {
	StateExpCS result = CSTFactory.eINSTANCE.createStateExpCS();
	result.getSequenceOfNames().addAll(pathName.getSequenceOfNames());
	return result;
}

private VariableExpCS createVariableExpCS(
		SimpleNameCS simpleNameCS,
		EList<OCLExpressionCS> arguments,
		IsMarkedPreCS isMarkedPreCS) {
	VariableExpCS result = CSTFactory.eINSTANCE.createVariableExpCS();
	result.setSimpleNameCS(simpleNameCS);
	result.getArguments().addAll(arguments);
	result.setIsMarkedPreCS(isMarkedPreCS);
	return result;
}

private SimpleNameCS createSimpleNameCS(
		SimpleTypeEnum type,
		String value) {
	SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
	result.setType(type);
	result.setValue(unquote(value));
	return result;
}

private PrimitiveTypeCS createPrimitiveTypeCS(
		SimpleTypeEnum type,
		String value) {
	PrimitiveTypeCS result = CSTFactory.eINSTANCE.createPrimitiveTypeCS();
	result.setType(type);
	result.setValue(value);
	return result;
}

private PathNameCS createPathNameCS(String pathName) {
	PathNameCS result = CSTFactory.eINSTANCE.createPathNameCS();
	result.getSequenceOfNames().add(unquote(pathName));
	return result;
}

private PathNameCS extendPathNameCS(PathNameCS path, String name) {
	path.getSequenceOfNames().add(unquote(name));
	return path;
}

private PathNameCS createPathNameCS() {
	return CSTFactory.eINSTANCE.createPathNameCS();
}

private EnumLiteralExpCS createEnumLiteralExpCS(
		PathNameCS pathNameCS,
		SimpleNameCS simpleNameCS) {
	EnumLiteralExpCS result = CSTFactory.eINSTANCE.createEnumLiteralExpCS();
	result.setPathNameCS(pathNameCS);
	result.setSimpleNameCS(simpleNameCS);
	return result;
}

private EnumLiteralExpCS createEnumLiteralExpCS(
		PathNameCS pathNameCS,
		String simpleName) {
	return createEnumLiteralExpCS(pathNameCS,
		createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, simpleName));
}

private CollectionLiteralExpCS createCollectionLiteralExpCS(
		CollectionTypeIdentifierEnum type,
		EList<CollectionLiteralPartCS> collectionLiteralParts) {
	CollectionLiteralExpCS result = CSTFactory.eINSTANCE.createCollectionLiteralExpCS();
	result.setCollectionType(type);
	result.getCollectionLiteralParts().addAll(collectionLiteralParts);
	return result;
}

private CollectionLiteralPartCS createCollectionLiteralPartCS(OCLExpressionCS oclExpressionCS) {
	CollectionLiteralPartCS result = CSTFactory.eINSTANCE.createCollectionLiteralPartCS();
	result.setExpressionCS(oclExpressionCS);
	return result;
}

private CollectionRangeCS createCollectionRangeCS(
		OCLExpressionCS oclExpressionCS,
		OCLExpressionCS lastOCLExpressionCS) {
	CollectionRangeCS result = CSTFactory.eINSTANCE.createCollectionRangeCS();
	result.setExpressionCS(oclExpressionCS);
	result.setLastExpressionCS(lastOCLExpressionCS);
	return result;
}

private IntegerLiteralExpCS createRangeStart(
		String integerDotDot,
		boolean isNegative) {
	String intToken = integerDotDot.substring(0, integerDotDot.indexOf('.'));
	int intValue = Integer.parseInt(intToken);
	if (isNegative) {
		intValue = -intValue;
	}
	
	IntegerLiteralExpCS result = CSTFactory.eINSTANCE.createIntegerLiteralExpCS();
	result.setIntegerSymbol(new Integer(intValue));
	result.setSymbol(Integer.toString(intValue));
	
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
	result.setSymbol(string);
	return result;
}

private InvalidLiteralExpCS createInvalidLiteralExpCS(String string) {
	InvalidLiteralExpCS result = CSTFactory.eINSTANCE.createInvalidLiteralExpCS();
	result.setSymbol(string);
	return result;
}

private IteratorExpCS createIteratorExpCS(
		SimpleNameCS simpleNameCS,
		VariableCS variable1,
		VariableCS variable2,
		OCLExpressionCS oclExpressionCS) {
	IteratorExpCS result = CSTFactory.eINSTANCE.createIteratorExpCS();
	result.setSimpleNameCS(simpleNameCS);
	result.setVariable1(variable1);
	result.setVariable2(variable2);
	result.setBody(oclExpressionCS);
	return result;
}

private IterateExpCS createIterateExpCS(
		SimpleNameCS simpleNameCS,
		VariableCS variable1,
		VariableCS variable2,
		OCLExpressionCS oclExpressionCS) {
	IterateExpCS result = CSTFactory.eINSTANCE.createIterateExpCS();
	result.setSimpleNameCS(simpleNameCS);
	result.setVariable1(variable1);
	result.setVariable2(variable2);
	result.setBody(oclExpressionCS);
	return result;
}

private VariableCS createVariableCS(
		String varName,
		TypeCS typeCS,
		OCLExpressionCS oclExpressionCS) {
	VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
	result.setName(unquote(varName));
	result.setTypeCS(typeCS);
	result.setInitExpression(oclExpressionCS);
	return result;
}

private CollectionTypeCS createCollectionTypeCS(
		CollectionTypeIdentifierEnum collectionType,
		TypeCS typeCS) {
	CollectionTypeCS result = CSTFactory.eINSTANCE.createCollectionTypeCS();
	result.setCollectionTypeIdentifier(collectionType);
	result.setTypeCS(typeCS);
	return result;
}

private TupleTypeCS createTupleTypeCS(EList<VariableCS> variables) {
	TupleTypeCS result = CSTFactory.eINSTANCE.createTupleTypeCS();
	result.getVariables().addAll(variables);
	return result;
}

private FeatureCallExpCS createFeatureCallExpCS(
		SimpleNameCS simpleNameCS,
		EList<OCLExpressionCS> arguments,
		IsMarkedPreCS isMarkedPreCS) {
	FeatureCallExpCS result = CSTFactory.eINSTANCE.createFeatureCallExpCS();
	result.setSimpleNameCS(simpleNameCS);
	result.getArguments().addAll(arguments);
	result.setIsMarkedPreCS(isMarkedPreCS);
	return result;
}

private IsMarkedPreCS createIsMarkedPreCS(boolean isMarkedPre) {
	IsMarkedPreCS result = CSTFactory.eINSTANCE.createIsMarkedPreCS();
	result.setPre(isMarkedPre);
	return result;
}

private LetExpCS createLetExpCS(
		EList<VariableCS> variables,
		OCLExpressionCS oclExpressionCS) {
	LetExpCS result = CSTFactory.eINSTANCE.createLetExpCS();
	result.getVariables().addAll(variables);
	result.setInExpression(oclExpressionCS);
	return result;
}

private IfExpCS createIfExpCS(
		OCLExpressionCS condition,
		OCLExpressionCS thenExpression,
		OCLExpressionCS elseExpression) {
	IfExpCS result = CSTFactory.eINSTANCE.createIfExpCS();
	result.setCondition(condition);
	result.setThenExpression(thenExpression);
	result.setElseExpression(elseExpression);
	return result;
}

private MessageExpCS createMessageExpCS(
		boolean hasSent,
		SimpleNameCS simpleNameCS,
		EList<OCLMessageArgCS> oclMessageArgs) {
	MessageExpCS result = CSTFactory.eINSTANCE.createMessageExpCS();
	result.setKind(hasSent ? MessageExpKind.HAS_SENT_LITERAL : MessageExpKind.SENT_LITERAL);
	result.setSimpleNameCS(simpleNameCS);
	result.getArguments().addAll(oclMessageArgs);
	return result;
}

private OCLMessageArgCS createOCLMessageArgCS(
		TypeCS typeCS,
		OCLExpressionCS oclExpressionCS) {
	OCLMessageArgCS result = CSTFactory.eINSTANCE.createOCLMessageArgCS();
	result.setTypeCS(typeCS);
	result.setExpression(oclExpressionCS);
	return result;
}

/**
 * Sets the start and end offsets of the given <code>CSTNode</code>
 * to the start and end offsets of the given <code>IToken</code>
 *
 * @param cstNode <code>CSTNode</code> to set offsets
 * @param startEnd <code>IToken</code> to retrieve offsets from
 */
private void setOffsets(CSTNode cstNode, IToken startEnd) {
	cstNode.setStartOffset(startEnd.getStartOffset());
	cstNode.setEndOffset(startEnd.getEndOffset());
}

/**
 * Sets the start and end offsets of the given <code>CSTNode</code>
 * to the start and end offsets of the 2nd given <code>CSTNode</code>
 *
 * @param cstNode <code>CSTNode</code> to set offsets
 * @param startEnd <code>CSTNode</code> to retrieve offsets from
 */
private void setOffsets(CSTNode cstNode, CSTNode startEnd) {
	cstNode.setStartOffset(startEnd.getStartOffset());
	cstNode.setEndOffset(startEnd.getEndOffset());
}

/**
 * Sets the start and end offsets of the given <code>CSTNode</code>
 * to the start offset of the 2nd given <code>CSTNode</code> and the
 * end offset of the 3rd given <code>CSTNode</code>
 *
 * @param cstNode <code>CSTNode</code> to set offsets
 * @param start <code>CSTNode</code> to retrieve start offset from
 * @param end <code>CSTNode</code> to retrieve end offset from
 */
private void setOffsets(CSTNode cstNode, CSTNode start, CSTNode end) {
	cstNode.setStartOffset(start.getStartOffset());
	cstNode.setEndOffset(end.getEndOffset());
}

/**
 * Sets the start and end offsets of the given <code>CSTNode</code>
 * to the start offset of the 2nd given <code>CSTNode</code> and the
 * end offset of the given <code>IToken</code>
 *
 * @param cstNode <code>CSTNode</code> to set offsets
 * @param start <code>CSTNode</code> to retrieve start offset from
 * @param end <code>IToken</code> to retrieve end offset from
 */
private void setOffsets(CSTNode cstNode, CSTNode start, IToken end) {
	cstNode.setStartOffset(start.getStartOffset());
	cstNode.setEndOffset(end.getEndOffset());
}

/**
 * Sets the start and end offsets of the given <code>CSTNode</code>
 * to the start offset of the given <code>IToken</code> and the
 * end offset of the 2nd given <code>CSTNode</code>
 *
 * @param cstNode <code>CSTNode</code> to set offsets
 * @param start <code>IToken</code> to retrieve start offset from
 * @param end <code>CSTNode</code> to retrieve end offset from
 */
private void setOffsets(CSTNode cstNode, IToken start, CSTNode end) {
	cstNode.setStartOffset(start.getStartOffset());
	cstNode.setEndOffset(end.getEndOffset());
}

/**
 * Sets the start and end offsets of the given <code>CSTNode</code>
 * to the start offset of the 1std given <code>IToken</code> and the
 * end offset of the 2nd given <code>IToken</code>
 *
 * @param cstNode <code>CSTNode</code> to set offsets
 * @param start <code>IToken</code> to retrieve start offset from
 * @param end <code>IToken</code> to retrieve end offset from
 */
private void setOffsets(CSTNode cstNode, IToken start, IToken end) {
	cstNode.setStartOffset(start.getStartOffset());
	cstNode.setEndOffset(end.getEndOffset());
}

/**
 * Removes the "s surrounding a quoted string, if any.
 * 
 * @param quoted a possibly quoted string
 * @return <code>quoted</code> without the surrounding quotes, or just
 *	 <code>quoted</code> verbatim if there were none
 */
private String unquote(String quoted) {
	String result = quoted;

	if ((result != null) && (result.length() > 1)) {
		int max = result.length() - 1;

		if ((result.charAt(0) == '"') && (quoted.charAt(max) == '"')) {
			result = result.substring(1, max);
		}
		
		// this is a regexp, so the backslash needs to be
		//   re-escaped, thus "\\" is rendered in a Java
		//   string literal as "\\\\"
		result = result.replaceAll("\\\\\"", "\"");  //$NON-NLS-2$//$NON-NLS-1$
		/*
		 * [artem] removed extra error handling fon non-spec escape processing 
		 */
	}

	return result;
}

	@SuppressWarnings("unchecked")
	public void ruleAction(int ruleNumber)
	{
		switch (ruleNumber) {
		
 
			//
			// Rule 26:  operationCS1 ::= IDENTIFIER ( parametersCSopt ) : typeCSopt
			//
			case 26: {
				
				CSTNode result = createOperationCS(
						getTokenText(dtParser.getToken(1)),
						(EList)dtParser.getSym(3),
						(TypeCS)dtParser.getSym(6)
					);
				if (dtParser.getSym(6) != null) {
					setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(6));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 27:  operationCS2 ::= pathNameCS :: simpleNameCS ( parametersCSopt ) : typeCSopt
			//
			case 27: {
				
				CSTNode result = createOperationCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5),
						(TypeCS)dtParser.getSym(8)
					);
				if (dtParser.getSym(8) != null) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(8));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(7)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 28:  parametersCSopt ::= $Empty
			//
			case 28:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 30:  parametersCS ::= variableCS
			//
			case 30: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 31:  parametersCS ::= parametersCS , variableCS
			//
			case 31: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 32:  simpleNameCSopt ::= $Empty
			//
			case 32:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 38:  impliesExpCS ::= impliesExpCS implies andOrXorExpCS
			//
			case 38:
 
			//
			// Rule 39:  impliesWithLet ::= impliesExpCS implies andOrXorWithLet
			//
			case 39:
 
			//
			// Rule 42:  andOrXorExpCS ::= andOrXorExpCS and equalityExpCS
			//
			case 42:
 
			//
			// Rule 43:  andOrXorExpCS ::= andOrXorExpCS or equalityExpCS
			//
			case 43:
 
			//
			// Rule 44:  andOrXorExpCS ::= andOrXorExpCS xor equalityExpCS
			//
			case 44:
 
			//
			// Rule 45:  andOrXorWithLet ::= andOrXorExpCS and equalityWithLet
			//
			case 45:
 
			//
			// Rule 46:  andOrXorWithLet ::= andOrXorExpCS or equalityWithLet
			//
			case 46:
 
			//
			// Rule 47:  andOrXorWithLet ::= andOrXorExpCS xor equalityWithLet
			//
			case 47: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(2))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 50:  equalityExpCS ::= equalityExpCS = relationalExpCS
			//
			case 50:
 
			//
			// Rule 51:  equalityWithLet ::= equalityExpCS = relationalWithLet
			//
			case 51: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 52:  equalityExpCS ::= equalityExpCS <> relationalExpCS
			//
			case 52:
 
			//
			// Rule 53:  equalityWithLet ::= equalityExpCS <> relationalWithLet
			//
			case 53: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.NOT_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 56:  relationalExpCS ::= relationalExpCS > ifExpCSPrec
			//
			case 56:
 
			//
			// Rule 57:  relationalWithLet ::= relationalExpCS > additiveWithLet
			//
			case 57: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.GREATER_THAN)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 58:  relationalExpCS ::= relationalExpCS < ifExpCSPrec
			//
			case 58:
 
			//
			// Rule 59:  relationalWithLet ::= relationalExpCS < additiveWithLet
			//
			case 59: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.LESS_THAN)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 60:  relationalExpCS ::= relationalExpCS >= ifExpCSPrec
			//
			case 60:
 
			//
			// Rule 61:  relationalWithLet ::= relationalExpCS >= additiveWithLet
			//
			case 61: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.GREATER_THAN_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 62:  relationalExpCS ::= relationalExpCS <= ifExpCSPrec
			//
			case 62:
 
			//
			// Rule 63:  relationalWithLet ::= relationalExpCS <= additiveWithLet
			//
			case 63: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.LESS_THAN_EQUAL)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 68:  additiveExpCS ::= additiveExpCS + multiplicativeExpCS
			//
			case 68:
 
			//
			// Rule 69:  additiveWithLet ::= additiveExpCS + multiplicativeWithLet
			//
			case 69: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.PLUS)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 70:  additiveExpCS ::= additiveExpCS - multiplicativeExpCS
			//
			case 70:
 
			//
			// Rule 71:  additiveWithLet ::= additiveExpCS - multiplicativeWithLet
			//
			case 71: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.MINUS)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 74:  multiplicativeExpCS ::= multiplicativeExpCS * unaryExpCS
			//
			case 74:
 
			//
			// Rule 75:  multiplicativeWithLet ::= multiplicativeExpCS * unaryWithLet
			//
			case 75: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.TIMES)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 76:  multiplicativeExpCS ::= multiplicativeExpCS / unaryExpCS
			//
			case 76:
 
			//
			// Rule 77:  multiplicativeWithLet ::= multiplicativeExpCS / unaryWithLet
			//
			case 77: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.DIVIDE)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(2)));
				EList args = new BasicEList();
				args.add(dtParser.getSym(3));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(1),
						simpleNameCS,
						args
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 80:  unaryExpCS ::= - unaryExpCS
			//
			case 80: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							OCLStandardLibraryUtil.getOperationName(PredefinedType.MINUS)
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						simpleNameCS,
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 81:  unaryExpCS ::= not unaryExpCS
			//
			case 81: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.STRING_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						simpleNameCS,
						new BasicEList()
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 83:  dotArrowExpCS ::= dotArrowExpCS callExpCS
			//
			case 83: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setSource((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), result);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 84:  dotArrowExpCS ::= dotArrowExpCS messageExpCS
			//
			case 84: {
				
				MessageExpCS result = (MessageExpCS)dtParser.getSym(2);
				result.setTarget((OCLExpressionCS)dtParser.getSym(1));
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 85:  dotArrowExpCS ::= NUMERIC_OPERATION ( argumentsCSopt )
			//
			case 85: {
				
				// NUMERIC_OPERATION -> Integer '.' Identifier
				String text = getTokenText(dtParser.getToken(1));
				int index = text.indexOf('.');
				String integer = text.substring(0, index);
				String simpleName = text.substring(index + 1);

				// create the IntegerLiteralExpCS
				int startOffset = getIToken(dtParser.getToken(1)).getStartOffset();
				int endOffset = startOffset + integer.length() - 1; // inclusive

				IntegerLiteralExpCS integerLiteralExpCS = createIntegerLiteralExpCS(integer);
				integerLiteralExpCS.setStartOffset(startOffset);
				integerLiteralExpCS.setEndOffset(endOffset);

				startOffset = endOffset + 2; // end of integerLiteral + 1('.') + 1(start of simpleName)
				endOffset = getIToken(dtParser.getToken(1)).getEndOffset();

				// create the SimpleNameCS
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							simpleName
						);
				simpleNameCS.setStartOffset(startOffset);
				simpleNameCS.setEndOffset(endOffset);

				// create the OperationCallExpCS
				CSTNode result = createOperationCallExpCS(
						integerLiteralExpCS,
						simpleNameCS,
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 86:  dotArrowExpCS ::= pathNameCS :: simpleNameCS ( argumentsCSopt )
			//
			case 86: {
				
				OperationCallExpCS result = createOperationCallExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3),
						(EList)dtParser.getSym(5)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(6)));
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 91:  oclExpCS ::= ( oclExpressionCS )
			//
			case 91: {
				
				CSTNode result = (CSTNode)dtParser.getSym(2);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 92:  variableExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 92: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 93:  variableExpCS ::= keywordAsIdentifier1 isMarkedPreCS
			//
			case 93: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createVariableExpCS(
						simpleNameCS,
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(1)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 94:  variableExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 94: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 95:  variableExpCS ::= keywordAsIdentifier1 [ argumentsCS ] isMarkedPreCS
			//
			case 95: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createVariableExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 97:  simpleNameCS ::= self
			//
			case 97: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.SELF_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 98:  simpleNameCS ::= IDENTIFIER
			//
			case 98: {
				
				CSTNode result = createSimpleNameCS(
						SimpleTypeEnum.IDENTIFIER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 99:  primitiveTypeCS ::= Integer
			//
			case 99: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INTEGER_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 100:  primitiveTypeCS ::= UnlimitedNatural
			//
			case 100: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.UNLIMITED_NATURAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 101:  primitiveTypeCS ::= String
			//
			case 101: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.STRING_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 102:  primitiveTypeCS ::= Real
			//
			case 102: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.REAL_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 103:  primitiveTypeCS ::= Boolean
			//
			case 103: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.BOOLEAN_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 104:  primitiveTypeCS ::= OclAny
			//
			case 104: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_ANY_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 105:  primitiveTypeCS ::= OclVoid
			//
			case 105: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_VOID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 106:  primitiveTypeCS ::= Invalid
			//
			case 106: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.INVALID_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 107:  primitiveTypeCS ::= OclMessage
			//
			case 107: {
				
				CSTNode result = createPrimitiveTypeCS(
						SimpleTypeEnum.OCL_MESSAGE_LITERAL,
						getTokenText(dtParser.getToken(1))
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 108:  pathNameCS ::= IDENTIFIER
			//
			case 108: {
				
				CSTNode result = createPathNameCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 109:  pathNameCS ::= pathNameCS :: simpleNameCS
			//
			case 109: {
				
				PathNameCS result = (PathNameCS)dtParser.getSym(1);
				result = extendPathNameCS(result, getTokenText(dtParser.getToken(3)));
				setOffsets(result, result, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 110:  pathNameCSOpt ::= $Empty
			//
			case 110: {
				
				CSTNode result = createPathNameCS();
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 118:  enumLiteralExpCS ::= pathNameCS :: keywordAsIdentifier
			//
			case 118: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						getTokenText(dtParser.getToken(3))
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(3)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 119:  enumLiteralExpCS ::= pathNameCS :: simpleNameCS
			//
			case 119: {
				
				CSTNode result = createEnumLiteralExpCS(
						(PathNameCS)dtParser.getSym(1),
						(SimpleNameCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 120:  collectionLiteralExpCS ::= collectionTypeIdentifierCS { collectionLiteralPartsCSopt }
			//
			case 120: {
				
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionLiteralExpCS(
						(CollectionTypeIdentifierEnum)objs[1],
						(EList)dtParser.getSym(3)
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 121:  collectionTypeIdentifierCS ::= Set
			//
			case 121: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 122:  collectionTypeIdentifierCS ::= Bag
			//
			case 122: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.BAG_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 123:  collectionTypeIdentifierCS ::= Sequence
			//
			case 123: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.SEQUENCE_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 124:  collectionTypeIdentifierCS ::= Collection
			//
			case 124: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.COLLECTION_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 125:  collectionTypeIdentifierCS ::= OrderedSet
			//
			case 125: {
				
				dtParser.setSym1(new Object[]{getIToken(dtParser.getToken(1)), CollectionTypeIdentifierEnum.ORDERED_SET_LITERAL});
	  		  break;
			}
	 
			//
			// Rule 126:  collectionLiteralPartsCSopt ::= $Empty
			//
			case 126:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 128:  collectionLiteralPartsCS ::= collectionLiteralPartCS
			//
			case 128: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 129:  collectionLiteralPartsCS ::= collectionLiteralPartsCS , collectionLiteralPartCS
			//
			case 129: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 131:  collectionLiteralPartCS ::= oclExpressionCS
			//
			case 131: {
				
				CSTNode result = createCollectionLiteralPartCS(
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 132:  collectionRangeCS ::= - INTEGER_RANGE_START oclExpressionCS
			//
			case 132: {
				
				OCLExpressionCS rangeStart = createRangeStart(
						getTokenText(dtParser.getToken(2)), true);
				CSTNode result = createCollectionRangeCS(
						rangeStart,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, rangeStart, (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 133:  collectionRangeCS ::= INTEGER_RANGE_START oclExpressionCS
			//
			case 133: {
				
				OCLExpressionCS rangeStart = createRangeStart(
						getTokenText(dtParser.getToken(1)), false);
				CSTNode result = createCollectionRangeCS(
						rangeStart,
						(OCLExpressionCS)dtParser.getSym(2)
					);
				setOffsets(result, rangeStart, (CSTNode)dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 134:  collectionRangeCS ::= oclExpressionCS .. oclExpressionCS
			//
			case 134: {
				
				CSTNode result = createCollectionRangeCS(
						(OCLExpressionCS)dtParser.getSym(1),
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 140:  tupleLiteralExpCS ::= Tuple { variableListCS2 }
			//
			case 140: {
				
				CSTNode result = createTupleLiteralExpCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 141:  integerLiteralExpCS ::= INTEGER_LITERAL
			//
			case 141: {
				
				CSTNode result = createIntegerLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 142:  unlimitedNaturalLiteralExpCS ::= *
			//
			case 142: {
				
				CSTNode result = createUnlimitedNaturalLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 143:  realLiteralExpCS ::= REAL_LITERAL
			//
			case 143: {
				
				CSTNode result = createRealLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 144:  stringLiteralExpCS ::= STRING_LITERAL
			//
			case 144: {
				
				CSTNode result = createStringLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 145:  booleanLiteralExpCS ::= true
			//
			case 145: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 146:  booleanLiteralExpCS ::= false
			//
			case 146: {
				
				CSTNode result = createBooleanLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 147:  nullLiteralExpCS ::= null
			//
			case 147: {
				
				CSTNode result = createNullLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 148:  invalidLiteralExpCS ::= OclInvalid
			//
			case 148: {
				
				CSTNode result = createInvalidLiteralExpCS(getTokenText(dtParser.getToken(1)));
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 149:  callExpCS ::= -> featureCallExpCS
			//
			case 149:
 
			//
			// Rule 150:  callExpCS ::= -> loopExpCS
			//
			case 150: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.ARROW_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 151:  callExpCS ::= . keywordOperationCallExpCS
			//
			case 151:
 
			//
			// Rule 152:  callExpCS ::= . featureCallExpCS
			//
			case 152: {
				
				CallExpCS result = (CallExpCS)dtParser.getSym(2);
				result.setAccessor(DotOrArrowEnum.DOT_LITERAL);
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 155:  iteratorExpCS ::= forAll ( iterContents )
			//
			case 155:
 
			//
			// Rule 156:  iteratorExpCS ::= exists ( iterContents )
			//
			case 156:
 
			//
			// Rule 157:  iteratorExpCS ::= isUnique ( iterContents )
			//
			case 157:
 
			//
			// Rule 158:  iteratorExpCS ::= one ( iterContents )
			//
			case 158:
 
			//
			// Rule 159:  iteratorExpCS ::= any ( iterContents )
			//
			case 159:
 
			//
			// Rule 160:  iteratorExpCS ::= collect ( iterContents )
			//
			case 160:
 
			//
			// Rule 161:  iteratorExpCS ::= select ( iterContents )
			//
			case 161:
 
			//
			// Rule 162:  iteratorExpCS ::= reject ( iterContents )
			//
			case 162:
 
			//
			// Rule 163:  iteratorExpCS ::= collectNested ( iterContents )
			//
			case 163:
 
			//
			// Rule 164:  iteratorExpCS ::= sortedBy ( iterContents )
			//
			case 164:
 
			//
			// Rule 165:  iteratorExpCS ::= closure ( iterContents )
			//
			case 165: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				Object[] iterContents = (Object[])dtParser.getSym(3);
				CSTNode result = createIteratorExpCS(
						simpleNameCS,
						(VariableCS)iterContents[0],
						(VariableCS)iterContents[1],
						(OCLExpressionCS)iterContents[2]
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 166:  iterContents ::= oclExpressionCS
			//
			case 166: {
				
				dtParser.setSym1(new Object[] {
						null,
						null,
						dtParser.getSym(1)
					});
	  		  break;
			}
	 
			//
			// Rule 167:  iterContents ::= variableCS | oclExpressionCS
			//
			case 167: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						null,
						dtParser.getSym(3)
					});
	  		  break;
			}
	 
			//
			// Rule 168:  iterContents ::= variableCS , variableCS | oclExpressionCS
			//
			case 168: {
				
				dtParser.setSym1(new Object[] {
						dtParser.getSym(1),
						dtParser.getSym(3),
						dtParser.getSym(5)
					});
	  		  break;
			}
	 
			//
			// Rule 169:  iterateExpCS ::= iterate ( variableCS | oclExpressionCS )
			//
			case 169: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createIterateExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						null,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(6)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 170:  iterateExpCS ::= iterate ( variableCS ; variableCS | oclExpressionCS )
			//
			case 170: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createIterateExpCS(
						simpleNameCS,
						(VariableCS)dtParser.getSym(3),
						(VariableCS)dtParser.getSym(5),
						(OCLExpressionCS)dtParser.getSym(7)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(8)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 171:  variableCS ::= IDENTIFIER
			//
			case 171: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 172:  variableCS ::= IDENTIFIER : typeCS
			//
			case 172: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 173:  variableCS ::= IDENTIFIER : typeCS = oclExpressionCS
			//
			case 173: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						(TypeCS)dtParser.getSym(3),
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 174:  variableCS2 ::= IDENTIFIER = oclExpressionCS
			//
			case 174: {
				
				CSTNode result = createVariableCS(
						getTokenText(dtParser.getToken(1)),
						null,
						(OCLExpressionCS)dtParser.getSym(3)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 175:  typeCSopt ::= $Empty
			//
			case 175:
				dtParser.setSym1(null);
				break;
 
			//
			// Rule 181:  collectionTypeCS ::= collectionTypeIdentifierCS ( typeCS )
			//
			case 181: {
				
				Object[] objs = (Object[])dtParser.getSym(1);
				CSTNode result = createCollectionTypeCS(
						(CollectionTypeIdentifierEnum)objs[1],
						(TypeCS)dtParser.getSym(3)
					);
				setOffsets(result, (IToken)objs[0], getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 182:  tupleTypeCS ::= Tuple ( variableListCSopt )
			//
			case 182: {
				
				CSTNode result = createTupleTypeCS((EList)dtParser.getSym(3));
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(4)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 183:  variableListCSopt ::= $Empty
			//
			case 183:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 185:  variableListCS ::= variableCS
			//
			case 185: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 186:  variableListCS ::= variableListCS , variableCS
			//
			case 186: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 187:  variableListCS2 ::= variableCS2
			//
			case 187:
 
			//
			// Rule 188:  variableListCS2 ::= variableCS
			//
			case 188: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 189:  variableListCS2 ::= variableListCS2 , variableCS2
			//
			case 189:
 
			//
			// Rule 190:  variableListCS2 ::= variableListCS2 , variableCS
			//
			case 190: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 193:  featureCallExpCS ::= MINUS isMarkedPreCS ( argumentsCSopt )
			//
			case 193:
 
			//
			// Rule 194:  featureCallExpCS ::= not isMarkedPreCS ( argumentsCSopt )
			//
			case 194: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 195:  operationCallExpCS ::= simpleNameCS isMarkedPreCS ( argumentsCSopt )
			//
			case 195: {
				
				CSTNode result = createOperationCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 196:  operationCallExpCS ::= oclIsUndefined isMarkedPreCS ( argumentsCSopt )
			//
			case 196:
 
			//
			// Rule 197:  operationCallExpCS ::= oclIsInvalid isMarkedPreCS ( argumentsCSopt )
			//
			case 197:
 
			//
			// Rule 198:  operationCallExpCS ::= oclIsNew isMarkedPreCS ( argumentsCSopt )
			//
			case 198:
 
			//
			// Rule 199:  operationCallExpCS ::= oclAsType isMarkedPreCS ( argumentsCSopt )
			//
			case 199:
 
			//
			// Rule 200:  operationCallExpCS ::= oclIsKindOf isMarkedPreCS ( argumentsCSopt )
			//
			case 200:
 
			//
			// Rule 201:  operationCallExpCS ::= oclIsTypeOf isMarkedPreCS ( argumentsCSopt )
			//
			case 201:
 
			//
			// Rule 202:  operationCallExpCS ::= EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 202:
 
			//
			// Rule 203:  operationCallExpCS ::= NOT_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 203:
 
			//
			// Rule 204:  operationCallExpCS ::= PLUS isMarkedPreCS ( argumentsCSopt )
			//
			case 204:
 
			//
			// Rule 205:  operationCallExpCS ::= MULTIPLY isMarkedPreCS ( argumentsCSopt )
			//
			case 205:
 
			//
			// Rule 206:  operationCallExpCS ::= DIVIDE isMarkedPreCS ( argumentsCSopt )
			//
			case 206:
 
			//
			// Rule 207:  operationCallExpCS ::= GREATER isMarkedPreCS ( argumentsCSopt )
			//
			case 207:
 
			//
			// Rule 208:  operationCallExpCS ::= LESS isMarkedPreCS ( argumentsCSopt )
			//
			case 208:
 
			//
			// Rule 209:  operationCallExpCS ::= GREATER_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 209:
 
			//
			// Rule 210:  operationCallExpCS ::= LESS_EQUAL isMarkedPreCS ( argumentsCSopt )
			//
			case 210:
 
			//
			// Rule 211:  operationCallExpCS ::= and isMarkedPreCS ( argumentsCSopt )
			//
			case 211:
 
			//
			// Rule 212:  operationCallExpCS ::= or isMarkedPreCS ( argumentsCSopt )
			//
			case 212:
 
			//
			// Rule 213:  operationCallExpCS ::= xor isMarkedPreCS ( argumentsCSopt )
			//
			case 213:
 
			//
			// Rule 214:  keywordOperationCallExpCS ::= keywordAsIdentifier isMarkedPreCS ( argumentsCSopt )
			//
			case 214: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						(EList)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 215:  operationCallExpCS ::= oclIsInState isMarkedPreCS ( pathNameCSOpt )
			//
			case 215: {
				
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.KEYWORD_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));

				PathNameCS pathNameCS = (PathNameCS) dtParser.getSym(4);
				StateExpCS stateExpCS = createStateExpCS(pathNameCS);
				setOffsets(stateExpCS, pathNameCS);
			
				CSTNode result = createOperationCallExpCS(
						simpleNameCS,
						(IsMarkedPreCS)dtParser.getSym(2),
						stateExpCS
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 216:  attrOrNavCallExpCS ::= simpleNameCS isMarkedPreCS
			//
			case 216: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				CSTNode result = createFeatureCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 217:  attrOrNavCallExpCS ::= keywordAsIdentifier isMarkedPreCS
			//
			case 217: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(2);
				SimpleNameCS simpleNameCS = createSimpleNameCS(
							SimpleTypeEnum.IDENTIFIER_LITERAL,
							getTokenText(dtParser.getToken(1))
						);
				setOffsets(simpleNameCS, getIToken(dtParser.getToken(1)));
				CSTNode result = createFeatureCallExpCS(
						simpleNameCS,
						new BasicEList(),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(2));
				} else {
					setOffsets(result, getIToken(dtParser.getToken(1)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 218:  attrOrNavCallExpCS ::= simpleNameCS [ argumentsCS ] isMarkedPreCS
			//
			case 218: {
				
				IsMarkedPreCS isMarkedPreCS = (IsMarkedPreCS)dtParser.getSym(5);
				CSTNode result = createFeatureCallExpCS(
						(SimpleNameCS)dtParser.getSym(1),
						(EList)dtParser.getSym(3),
						isMarkedPreCS
					);
				if (isMarkedPreCS.isPre()) {
					setOffsets(result, (CSTNode)dtParser.getSym(1), (CSTNode)dtParser.getSym(5));
				} else {
					setOffsets(result, (CSTNode)dtParser.getSym(1), getIToken(dtParser.getToken(4)));
				}
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 219:  isMarkedPreCS ::= $Empty
			//
			case 219: {
				
				CSTNode result = createIsMarkedPreCS(false);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 220:  isMarkedPreCS ::= @pre
			//
			case 220: {
				
				CSTNode result = createIsMarkedPreCS(true);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 221:  argumentsCSopt ::= $Empty
			//
			case 221:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 223:  argumentsCS ::= oclExpressionCS
			//
			case 223: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 224:  argumentsCS ::= argumentsCS , oclExpressionCS
			//
			case 224: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 225:  letExpCS ::= let variableCS letExpSubCSopt in oclExpressionCS
			//
			case 225: {
				
				EList variables = (EList)dtParser.getSym(3);
				variables.add(0, dtParser.getSym(2));
				CSTNode result = createLetExpCS(
						variables,
						(OCLExpressionCS)dtParser.getSym(5)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(5));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 226:  letExpSubCSopt ::= $Empty
			//
			case 226:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 228:  letExpSubCS ::= , variableCS
			//
			case 228: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(2));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 229:  letExpSubCS ::= letExpSubCS , variableCS
			//
			case 229: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 230:  ifExpCS ::= if oclExpressionCS then oclExpressionCS else oclExpressionCS endif
			//
			case 230: {
				
				CSTNode result = createIfExpCS(
						(OCLExpressionCS)dtParser.getSym(2),
						(OCLExpressionCS)dtParser.getSym(4),
						(OCLExpressionCS)dtParser.getSym(6)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(7)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 231:  messageExpCS ::= ^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 231:
 
			//
			// Rule 232:  messageExpCS ::= ^^ simpleNameCS ( oclMessageArgumentsCSopt )
			//
			case 232: {
				
				CSTNode result = createMessageExpCS(
						getIToken(dtParser.getToken(1)).getKind() == XpandParsersym.TK_CARET,
						(SimpleNameCS)dtParser.getSym(2),
						(EList<OCLMessageArgCS>)dtParser.getSym(4)
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), getIToken(dtParser.getToken(5)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 233:  oclMessageArgumentsCSopt ::= $Empty
			//
			case 233:
				dtParser.setSym1(new BasicEList());
				break;
 
			//
			// Rule 235:  oclMessageArgumentsCS ::= oclMessageArgCS
			//
			case 235: {
				
				EList result = new BasicEList();
				result.add(dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 236:  oclMessageArgumentsCS ::= oclMessageArgumentsCS , oclMessageArgCS
			//
			case 236: {
				
				EList result = (EList)dtParser.getSym(1);
				result.add(dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 237:  oclMessageArgCS ::= oclExpressionCS
			//
			case 237: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						(OCLExpressionCS)dtParser.getSym(1)
					);
				setOffsets(result, (CSTNode)dtParser.getSym(1));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 238:  oclMessageArgCS ::= ?
			//
			case 238: {
				
				CSTNode result = createOCLMessageArgCS(
						null,
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 239:  oclMessageArgCS ::= ? : typeCS
			//
			case 239: {
				
				CSTNode result = createOCLMessageArgCS(
						(TypeCS)dtParser.getSym(3),
						null
					);
				setOffsets(result, getIToken(dtParser.getToken(1)), (CSTNode)dtParser.getSym(3));
				dtParser.setSym1(result);
	  		  break;
			}
	 
			//
			// Rule 240:  template ::= emptyTemplate
			//
			case 240: {
				
		setResult(xpandFactory.createTemplate(Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, getRightIToken()));
			  break;
			} 
			//
			// Rule 243:  template ::= LG commentTextPairAny imports extensionImports defineOrAroundSeq
			//
			case 243: {
				
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
			// Rule 244:  defineOrAroundSeq ::= define TEXT commentTextPairAny defineOrAroundSuffix
			//
			case 244: {
				
		List result = new LinkedList();
		result.add(getRhsSym(1));
		result.addAll((List) getRhsSym(4));
		setResult(result);
			  break;
			} 
			//
			// Rule 245:  defineOrAroundSeq ::= around TEXT commentTextPairAny defineOrAroundSuffix
			//
			case 245: {
				
		List result = new LinkedList();
		result.add(getRhsSym(1));
		result.addAll((List) getRhsSym(4));
		setResult(result);
			  break;
			} 
			//
			// Rule 246:  defineOrAroundSuffix ::= $Empty
			//
			case 246: {
				
		setResult(Collections.EMPTY_LIST);
			  break;
			} 
			//
			// Rule 252:  imports ::= $Empty
			//
			case 252: {
				
		setResult(Collections.EMPTY_LIST);
			  break;
			} 
			//
			// Rule 253:  imports ::= anImport imports
			//
			case 253: {
				
		List res = new LinkedList();
		res.add(getRhsSym(1));
		res.addAll((List) getRhsSym(2));
		setResult(res);
			  break;
			} 
			//
			// Rule 254:  anImport ::= IMPORT stringLiteralExpCS TEXT commentTextPairAny
			//
			case 254: {
				
		setResult(xpandFactory.createNamespaceImport(getLeftIToken(), (StringLiteralExpCS) getRhsSym(2)));
			  break;
			} 
			//
			// Rule 255:  extensionImports ::= $Empty
			//
			case 255: {
				
		setResult(Collections.EMPTY_LIST);
			  break;
			} 
			//
			// Rule 256:  extensionImports ::= anExtensionImport extensionImports
			//
			case 256: {
				
		List res = new LinkedList();
		res.add(getRhsSym(1));
		res.addAll((List) getRhsSym(2));
		setResult(res);
			  break;
			} 
			//
			// Rule 257:  anExtensionImport ::= EXTENSION pathNameCS TEXT commentTextPairAny
			//
			case 257: {
				
		setResult(xpandFactory.createImportDeclaration(getLeftIToken(), (PathNameCS) getRhsSym(2)));
			  break;
			} 
			//
			// Rule 258:  around ::= AROUND pointcut FOR typeCS sequence ENDAROUND
			//
			case 258: {
				
		setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), Collections.<VariableCS>emptyList(), false, (TypeCS) getRhsSym(4), (List) getRhsSym(5)));
			  break;
			} 
			//
			// Rule 259:  around ::= AROUND pointcut LPAREN parametersCS RPAREN FOR typeCS sequence ENDAROUND
			//
			case 259: {
				
		setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), (List<VariableCS>) getRhsSym(4), false, (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
			  break;
			} 
			//
			// Rule 260:  around ::= AROUND pointcut LPAREN parametersCS COMMA MULTIPLY RPAREN FOR typeCS sequence ENDAROUND
			//
			case 260: {
				
		setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), (List<VariableCS>) getRhsSym(4), true, (TypeCS) getRhsSym(9), (List) getRhsSym(10)));
			  break;
			} 
			//
			// Rule 261:  around ::= AROUND pointcut LPAREN MULTIPLY RPAREN FOR typeCS sequence ENDAROUND
			//
			case 261: {
				
		setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), Collections.<VariableCS>emptyList(), true, (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
			  break;
			} 
			//
			// Rule 262:  pointcut ::= MULTIPLY pointcutSuffix
			//
			case 262: {
				
//			FIXME: may use SimpleNameCS here, though need more sophisticated code to update end position
//			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(getRhsTokenIndex(1)));
//			setOffsets(simpleNameCS, getLeftIToken());
		Identifier res = xpandFactory.createIdentifier(getLeftIToken());
		if (getRhsSym(2) != null) {
			res = res.append((Identifier) getRhsSym(2));
		}
		setResult(res);
			  break;
			} 
			//
			// Rule 263:  pointcut ::= IDENTIFIER pointcutSuffix
			//
			case 263: {
				
		Identifier res = xpandFactory.createIdentifier(getLeftIToken());
		if (getRhsSym(2) != null) {
			res = res.append((Identifier) getRhsSym(2));
		}
		setResult(res);
			  break;
			} 
			//
			// Rule 264:  pointcutSuffix ::= $Empty
			//
			case 264: {
				
		setResult(null);
			  break;
			} 
			//
			// Rule 266:  pointcutSuffix ::= COLONCOLON pointcutSuffix
			//
			case 266: {
				
		Identifier res = xpandFactory.createIdentifier(getLeftIToken());
		if (getRhsSym(2) != null) {
			res = res.append((Identifier) getRhsSym(2));
		}
		setResult(res);
			  break;
			} 
			//
			// Rule 267:  define ::= DEFINE IDENTIFIER FOR typeCS sequence ENDDEFINE
			//
			case 267: {
				
		setResult(xpandFactory.createDefinition(getLeftIToken(), getRightIToken(), getRhsIToken(2), Collections.<VariableCS>emptyList(), (TypeCS) getRhsSym(4), (List) getRhsSym(5)));
			  break;
			} 
			//
			// Rule 268:  define ::= DEFINE IDENTIFIER LPAREN parametersList RPAREN FOR typeCS sequence ENDDEFINE
			//
			case 268: {
				
		setResult(xpandFactory.createDefinition(getLeftIToken(), getRightIToken(), getRhsIToken(2), (List<VariableCS>) getRhsSym(4), (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
			  break;
			} 
			//
			// Rule 269:  parametersList ::= parameter
			//
			case 269: {
				
		VariableCS param = (VariableCS) getRhsSym(1);
		LinkedList res = new LinkedList();
		res.add(param);
		setResult(res);
			  break;
			} 
			//
			// Rule 270:  parametersList ::= parametersList , parameter
			//
			case 270: {
				
		VariableCS param = (VariableCS) getRhsSym(3);
		LinkedList res = new LinkedList();
		res.addAll((List) getRhsSym(1));
		res.add(param);
		setResult(res);
			  break;
			} 
			//
			// Rule 272:  parameter ::= typeCS IDENTIFIER
			//
			case 272: {
				
		VariableCS result = createVariableCS(getRhsIToken(2).toString(), (TypeCS) getRhsSym(1), null);
		setOffsets(result, (TypeCS) getRhsSym(1), getRhsIToken(2));
		setResult(result);
			  break;
			} 
			//
			// Rule 273:  sequence ::= text sequenceSuffix
			//
			case 273: {
				
		List res = new LinkedList();
		res.addAll((List) getRhsSym(1));
		res.addAll((List) getRhsSym(2));
		setResult(res);
			  break;
			} 
			//
			// Rule 274:  sequenceSuffix ::= $Empty
			//
			case 274: {
				
		setResult(Collections.EMPTY_LIST);
			  break;
			} 
			//
			// Rule 275:  sequenceSuffix ::= statement text sequenceSuffix
			//
			case 275: {
				
		List res = new LinkedList();
		res.add(getRhsSym(1));
		res.addAll((List) getRhsSym(2));
		res.addAll((List) getRhsSym(3));
		setResult(res);
			  break;
			} 
			//
			// Rule 282:  text ::= minusOpt TEXT textSuffix
			//
			case 282: {
				
		List res = new LinkedList();
		res.add(xpandFactory.createTextStatement(getRhsIToken(2), (IToken) getRhsSym(1)));
		res.addAll((List) getRhsSym(3));
		setResult(res);
			  break;
			} 
			//
			// Rule 283:  textSuffix ::= $Empty
			//
			case 283: {
				
		setResult(Collections.EMPTY_LIST);
			  break;
			} 
			//
			// Rule 284:  textSuffix ::= minusOpt TEXT textSuffix
			//
			case 284: {
				
		List res = new LinkedList();
		res.add(xpandFactory.createTextStatement(getRhsIToken(2), (IToken) getRhsSym(1)));
		res.addAll((List) getRhsSym(3));
		setResult(res);
			  break;
			} 
			//
			// Rule 285:  minusOpt ::= $Empty
			//
			case 285: {
				
		setResult(null);
			  break;
			} 
			//
			// Rule 286:  minusOpt ::= MINUS
			//
			case 286: {
				
		setResult(getLeftIToken());
			  break;
			} 
			//
			// Rule 290:  errorStatement ::= ERROR oclExpressionCS
			//
			case 290: {
				
		setResult(xpandFactory.createErrorStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2)));
			  break;
			} 
			//
			// Rule 291:  expandStatement ::= EXPAND definitionName parameterListOpt
			//
			case 291: {
				
		setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), null, false, null));
			  break;
			} 
			//
			// Rule 292:  expandStatement ::= EXPAND definitionName parameterListOpt FOR oclExpressionCS
			//
			case 292: {
				
		setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), false, null));
			  break;
			} 
			//
			// Rule 293:  expandStatement ::= EXPAND definitionName parameterListOpt FOREACH oclExpressionCS separatorOpt
			//
			case 293: {
				
		setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), true, (OCLExpressionCS) getRhsSym(6)));
			  break;
			} 
			//
			// Rule 294:  parameterListOpt ::= $Empty
			//
			case 294: {
				
		setResult(Collections.EMPTY_LIST);
			  break;
			} 
			//
			// Rule 295:  parameterListOpt ::= LPAREN argumentsCS RPAREN
			//
			case 295: {
				
		setResult(getRhsSym(2));
			  break;
			} 
			//
			// Rule 297:  expressionStmt ::= oclExpressionCS
			//
			case 297: {
				
		// XXX OCL CST doesn't keep track of line numbers, but we use them (perhaps, might refactor to stop using?)
		int lineNumber = getLeftIToken().getLine();
		setResult(xpandFactory.createExpressionStatement((OCLExpressionCS) getRhsSym(1), lineNumber));
			  break;
			} 
			//
			// Rule 298:  fileStatement ::= FILE oclExpressionCS identOpt sequence ENDFILE
			//
			case 298: {
				
		setResult(xpandFactory.createFileStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), (Identifier) getRhsSym(3), (List) getRhsSym(4)));
			  break;
			} 
			//
			// Rule 299:  identOpt ::= $Empty
			//
			case 299: {
				
		setResult(null);
			  break;
			} 
			//
			// Rule 300:  identOpt ::= IDENTIFIER
			//
			case 300: {
				
		setResult(xpandFactory.createIdentifier(getLeftIToken()));
			  break;
			} 
			//
			// Rule 301:  foreachStatement ::= FOREACH oclExpressionCS AS IDENTIFIER iteratorOpt separatorOpt sequence ENDFOREACH
			//
			case 301: {
				
		setResult(xpandFactory.createForEachStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), getRhsIToken(4), (OCLExpressionCS) getRhsSym(6), (IToken) getRhsSym(5), (List) getRhsSym(7)));
			  break;
			} 
			//
			// Rule 302:  iteratorOpt ::= $Empty
			//
			case 302: {
				
		setResult(null);
			  break;
			} 
			//
			// Rule 303:  iteratorOpt ::= ITERATOR IDENTIFIER
			//
			case 303: {
				
		setResult(getRightIToken());
			  break;
			} 
			//
			// Rule 304:  separatorOpt ::= $Empty
			//
			case 304: {
				
		setResult(null);
			  break;
			} 
			//
			// Rule 305:  separatorOpt ::= SEPARATOR oclExpressionCS
			//
			case 305: {
				
		setResult(getRhsSym(2));
			  break;
			} 
			//
			// Rule 306:  ifStatement ::= IF oclExpressionCS sequence elseifAny elseOpt ENDIF
			//
			case 306: {
				
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
			// Rule 307:  elseifAny ::= $Empty
			//
			case 307: {
				
		setResult(null);
			  break;
			} 
			//
			// Rule 308:  elseifAny ::= ELSEIF oclExpressionCS sequence elseifAny
			//
			case 308: {
				
		IfStatement elseIf = xpandFactory.createIfStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2), (List) getRhsSym(3), null);
		IfStatement restElseIf = (IfStatement) getRhsSym(4);
		elseIf.setElseIf(restElseIf);
		setResult(elseIf);
			  break;
			} 
			//
			// Rule 309:  elseOpt ::= $Empty
			//
			case 309: {
				
		setResult(null);
			  break;
			} 
			//
			// Rule 310:  elseOpt ::= ELSE sequence
			//
			case 310: {
				
		setResult(xpandFactory.createIfStatement(getLeftIToken(), null, (List) getRhsSym(2), null));
			  break;
			} 
			//
			// Rule 311:  letStatement ::= LET oclExpressionCS AS IDENTIFIER sequence ENDLET
			//
			case 311: {
				
		setResult(xpandFactory.createLetStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), getRhsIToken(4), (List) getRhsSym(5)));
			  break;
			} 
			//
			// Rule 312:  protectStatement ::= PROTECT CSTART oclExpressionCS CEND oclExpressionCS ID oclExpressionCS disabledOpt sequence ENDPROTECT
			//
			case 312: {
				
		setResult(xpandFactory.createProtectStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), (OCLExpressionCS) getRhsSym(7), (IToken) getRhsSym(8), (List) getRhsSym(9)));
			  break;
			} 
			//
			// Rule 313:  disabledOpt ::= $Empty
			//
			case 313: {
				
		setResult(null);
			  break;
			} 
			//
			// Rule 314:  disabledOpt ::= DISABLE
			//
			case 314: {
				
		setResult(getLeftIToken());
			  break;
			}
	
			default:
				break;
		}
		return;
	}
}

