--
-- Copyright (c) 2006, 2008 Borland Software Corp.
-- 
-- All rights reserved. This program and the accompanying materials
-- are made available under the terms of the Eclipse Public License v1.0
-- which accompanies this distribution, and is available at
-- http://www.eclipse.org/legal/epl-v10.html
--
-- Contributors:
--    Artem Tikhomirov (Borland)
--

%options fp=XpandParser,prefix=TK_
%options programming_language=java
%options package=org.eclipse.gmf.internal.xpand.parser
%options template=../expression/parser/dtParserTemplateD.g
%options ast_type=Template
%options import_terminals=XpandLexer.g
%options lalr=2
%options include_directory="../expression/parser/;../../../../../../../../org.eclipse.m2m.qvt.oml.cst.parser/cst;../../../../../../../../org.eclipse.m2m.qvt.oml.cst.parser/lpg"

$Globals
	/.
	import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
	import org.eclipse.gmf.internal.xpand.ast.*;
	import org.eclipse.ocl.cst.*;
	import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeIterateExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.NewRuleCallExpCS;
	import java.util.Collections;
	./
$End

$Headers
	/.
		private final XpandFactory xpandFactory;
	./
$End

$Start
	template
$End

$Import
	../../../../../../../../org.eclipse.m2m.qvt.oml.cst.parser/cst/ImperativeOCL.g

$DropRules
	oclExpCS -> switchExpCS
	oclExpCS -> whileExpCS
	oclExpCS -> legacyWhileExpCS
	oclExpCS -> computeExpCS
	loopExpCS -> iterateSwitchExpCS
	loopExpCS -> forExpCS
	ifExpBodyCS -> expression_block

$DropSymbols
	statementCS
	variableInitializationCS
	variableInitializationCSCorrect
	assignStatementCS
	primaryOCLExpressionCS
	complianceKindCSOpt
	returnExpCS
	logExpCS logWhenExp logWhenExpOpt
	assertExpCS assertWithLogExp assertWithLogExpOpt severityKindCS severityKindCSOpt
	oclExpressionCSOpt 
	statementListOpt 
	statementList 
	statementInnerList
	expressionStatementCS
	expression_block
	switchExpCS
	iterateSwitchExpCS
	switchDeclaratorCS
	switchBodyExpCS
	switchAltExpCS
	switchElseExpCSOpt
	switchElseExpCS
	switchAltExpCSList
	whileExpCS
	whileBodyCS
	legacyWhileExpCS
	computeExpCS
	forExpCS
	forOpCode
	forExpDeclaratorList
	forExpConditionOpt
$End

-- FIXME need to fix $Notice section from EssentialOCL.g

-- factory method for QVT CST constructs
$Include
	AbstractQVTParser.gi
$End

-- factory method for OCL CST constructs
$Include
	AbstractOCLParser.gi
$End

-- unquote and setOffsets methods
$Include
	AbstractParser.gi
$End

$Define
	-- definition of init code should go *after* import
	$initialization_code /.xpandFactory = new XpandFactory(lexStream.getFileName());./
	-- not to include all the stuff from EssentialOCL.g but rules
	$parserCore /../
	$copyright_contributions /.*   Borland Software Corporation - Xpand integration/support./

	-- need to redefine so that one from ImperativeOCL.g doesn't inject it's own debug stuff
	$BeginActions
	/.
		@SuppressWarnings("unchecked")
		public void ruleAction(int ruleNumber) {
			switch (ruleNumber) {
	./
	-- do not inject DEBUG variable as well.
	$DebugModeOff /../
$End

$Terminals
	IMPORT EXTENSION
	AROUND ENDAROUND
	DEFINE ENDDEFINE
	ERROR
	EXPAND
	FOR SEPARATOR AS ITERATOR 
	FOREACH ENDFOREACH
	FILE ENDFILE
	IF ELSEIF ELSE ENDIF
	LET ENDLET
	PROTECT CSTART CEND ID DISABLE ENDPROTECT

	LG ::= '\u00AB'

--	RG ::= '\u00BB' -- useless
$End

$Rules

	template ::= emptyTemplate
		/.$BeginJava
			setResult(xpandFactory.createTemplate(Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, getRightIToken()));
		$EndJava./

	-- original xpand allows empty templates, not sure what for; added support to handle comments-only content
	emptyTemplate -> $empty | LG TEXT commentTextPairAny

	-- unlike original xpand, do not allow mixed order of imports (ext and regular)
	template ::= LG commentTextPairAny imports extensionImports defineOrAroundSeq
		/.$BeginJava
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
		$EndJava./

	defineOrAroundSeq ::= define TEXT commentTextPairAny defineOrAroundSuffix
		/.$BeginJava
			List result = new LinkedList();
			result.add(getRhsSym(1));
			result.addAll((List) getRhsSym(4));
			setResult(result);
		$EndJava./
	defineOrAroundSeq ::= around TEXT commentTextPairAny defineOrAroundSuffix 
		/.$BeginJava
			List result = new LinkedList();
			result.add(getRhsSym(1));
			result.addAll((List) getRhsSym(4));
			setResult(result);
		$EndJava./
	defineOrAroundSuffix ::= $empty
		/.$BeginJava
			setResult(Collections.EMPTY_LIST);
		$EndJava./
	defineOrAroundSuffix -> defineOrAroundSeq

	lgOpt -> $empty | LG
	commentTextPairAny -> $empty | TEXT commentTextPairAny

	imports ::= $empty
		/.$BeginJava
			setResult(Collections.EMPTY_LIST);
		$EndJava./
	imports ::= anImport imports
		/.$BeginJava
			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
		$EndJava./

	anImport ::= "IMPORT" qvtStringLiteralExpCS TEXT commentTextPairAny 
		/.$BeginJava
			setResult(xpandFactory.createNamespaceImport(getLeftIToken(), (StringLiteralExpCS) getRhsSym(2)));
		$EndJava./

	extensionImports ::= $empty
		/.$BeginJava
			setResult(Collections.EMPTY_LIST);
		$EndJava./
	extensionImports ::= anExtensionImport extensionImports
		/.$BeginJava
			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
		$EndJava./

	anExtensionImport ::= "EXTENSION" pathNameCS TEXT commentTextPairAny 
		/.$BeginJava
			setResult(xpandFactory.createImportDeclaration(getLeftIToken(), (PathNameCS) getRhsSym(2)));
		$EndJava./

	around ::= "AROUND" pointcut "FOR" typeCS sequence "ENDAROUND"
		/.$BeginJava
			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), Collections.<VariableCS>emptyList(), false, (TypeCS) getRhsSym(4), (List) getRhsSym(5)));
		$EndJava./
	around ::= "AROUND" pointcut LPAREN parametersList RPAREN "FOR" typeCS sequence "ENDAROUND"
		/.$BeginJava
			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), (List<VariableCS>) getRhsSym(4), false, (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
		$EndJava./
	around ::= "AROUND" pointcut LPAREN parametersList COMMA MULTIPLY RPAREN "FOR" typeCS sequence "ENDAROUND"
		/.$BeginJava
			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), (List<VariableCS>) getRhsSym(4), true, (TypeCS) getRhsSym(9), (List) getRhsSym(10)));
		$EndJava./
	around ::= "AROUND" pointcut LPAREN MULTIPLY RPAREN "FOR" typeCS sequence "ENDAROUND"
		/.$BeginJava
			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), Collections.<VariableCS>emptyList(), true, (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
		$EndJava./

	pointcut ::= MULTIPLY pointcutSuffix 
		/.$BeginJava
//			FIXME: may use SimpleNameCS here, though need more sophisticated code to update end position
//			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(getRhsTokenIndex(1)));
//			setOffsets(simpleNameCS, getLeftIToken());
			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
		$EndJava./
	pointcut ::= IDENTIFIER pointcutSuffix
		/.$BeginJava
			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
		$EndJava./

	pointcutSuffix ::= $empty
		/.$BeginJava
			setResult(null);
		$EndJava./
	pointcutSuffix -> pointcut
	pointcutSuffix ::= COLONCOLON pointcutSuffix
		/.$BeginJava
			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
		$EndJava./

	define ::= "DEFINE" IDENTIFIER "FOR" typeCS sequence "ENDDEFINE"
		/.$BeginJava
			setResult(xpandFactory.createDefinition(getLeftIToken(), getRightIToken(), getRhsIToken(2), Collections.<VariableCS>emptyList(), (TypeCS) getRhsSym(4), (List) getRhsSym(5)));
		$EndJava./
	define ::= "DEFINE" IDENTIFIER LPAREN parametersList RPAREN "FOR" typeCS sequence "ENDDEFINE"
		/.$BeginJava
			setResult(xpandFactory.createDefinition(getLeftIToken(), getRightIToken(), getRhsIToken(2), (List<VariableCS>) getRhsSym(4), (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
		$EndJava./
		
	parametersList ::= parameter 
		/.$BeginJava
			VariableCS param = (VariableCS) getRhsSym(1);
			LinkedList res = new LinkedList();
			res.add(param);
			setResult(res);
		$EndJava./

	parametersList ::= parametersList ',' parameter 
		/.$BeginJava
			VariableCS param = (VariableCS) getRhsSym(3);
			LinkedList res = new LinkedList();
			res.addAll((List) getRhsSym(1));
			res.add(param);
			setResult(res);
		$EndJava./

	parameter -> declarator

	parameter ::= typeCS IDENTIFIER
		/.$BeginJava
			VariableCS result = createVariableCS(getRhsIToken(2).toString(), (TypeCS) getRhsSym(1), null);
			setOffsets(result, (TypeCS) getRhsSym(1), getRhsIToken(2));
			setResult(result);
		$EndJava./
	
	sequence ::= text sequenceSuffix
		/.$BeginJava
			List res = new LinkedList();
			res.addAll((List) getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
		$EndJava./
	sequenceSuffix ::= $empty
		/.$BeginJava
			setResult(Collections.EMPTY_LIST);
		$EndJava./
	sequenceSuffix ::= statement text sequenceSuffix
		/.$BeginJava
			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			res.addAll((List) getRhsSym(3));
			setResult(res);
		$EndJava./


--
-- Statements
--
--
	statement -> simpleStatement | fileStatement | foreachStatement | ifStatement | letStatement | protectStatement

	text ::= minusOpt TEXT textSuffix 
		/.$BeginJava
			List res = new LinkedList();
			res.add(xpandFactory.createTextStatement(getRhsIToken(2), (IToken) getRhsSym(1)));
			res.addAll((List) getRhsSym(3));
			setResult(res);
		$EndJava./

	textSuffix ::= $empty
		/.$BeginJava
			setResult(Collections.EMPTY_LIST);
		$EndJava./
	textSuffix ::= minusOpt TEXT textSuffix
		/.$BeginJava
			List res = new LinkedList();
			res.add(xpandFactory.createTextStatement(getRhsIToken(2), (IToken) getRhsSym(1)));
			res.addAll((List) getRhsSym(3));
			setResult(res);
		$EndJava./

	minusOpt ::= $empty
		/.$BeginJava
			setResult(null);
		$EndJava./
	minusOpt ::= MINUS
		/.$BeginJava
			setResult(getLeftIToken());
		$EndJava./

	simpleStatement -> errorStatement | expandStatement | expressionStmt

	errorStatement ::= "ERROR" oclExpressionCS
		/.$BeginJava
			setResult(xpandFactory.createErrorStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2)));
		$EndJava./


	expandStatement ::= "EXPAND" definitionName parameterListOpt
		/.$BeginJava
			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), null, false, null));
		$EndJava./
	expandStatement ::= "EXPAND" definitionName parameterListOpt "FOR" oclExpressionCS
		/.$BeginJava
			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), false, null));
		$EndJava./
	expandStatement ::= "EXPAND" definitionName parameterListOpt "FOREACH" oclExpressionCS separatorOpt
		/.$BeginJava
			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), true, (OCLExpressionCS) getRhsSym(6)));
		$EndJava./

	parameterListOpt ::= $empty
		/.$BeginJava
			setResult(Collections.EMPTY_LIST);
		$EndJava./
	parameterListOpt ::= LPAREN argumentsCS RPAREN
		/.$BeginJava
			setResult(getRhsSym(2));
		$EndJava./


	definitionName -> pathNameCS

	expressionStmt ::= oclExpressionCS
		/.$BeginJava
			// XXX OCL CST doesn't keep track of line numbers, but we use them (perhaps, might refactor to stop using?)
			int lineNumber = getLeftIToken().getLine();
			setResult(xpandFactory.createExpressionStatement((OCLExpressionCS) getRhsSym(1), lineNumber));
		$EndJava./

	fileStatement ::= "FILE" oclExpressionCS identOpt sequence "ENDFILE"
		/.$BeginJava
			setResult(xpandFactory.createFileStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), (Identifier) getRhsSym(3), (List) getRhsSym(4)));
		$EndJava./

	-- XXX may use simpleNameCSopt instead, however not sure about self and String/Real/etc as possible values there.
	identOpt ::= $empty
		/.$BeginJava
			setResult(null);
		$EndJava./
	identOpt ::= IDENTIFIER
		/.$BeginJava
			setResult(xpandFactory.createIdentifier(getLeftIToken()));
		$EndJava./

	foreachStatement ::= "FOREACH" oclExpressionCS "AS" IDENTIFIER iteratorOpt separatorOpt sequence "ENDFOREACH"
		/.$BeginJava
			setResult(xpandFactory.createForEachStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), getRhsIToken(4), (OCLExpressionCS) getRhsSym(6), (IToken) getRhsSym(5), (List) getRhsSym(7)));
		$EndJava./

	iteratorOpt ::= $empty
		/.$BeginJava
			setResult(null);
		$EndJava./
	iteratorOpt ::= "ITERATOR" IDENTIFIER
		/.$BeginJava
			setResult(getRightIToken());
		$EndJava./

	separatorOpt ::= $empty
		/.$BeginJava
			setResult(null);
		$EndJava./
	separatorOpt ::= "SEPARATOR" oclExpressionCS
		/.$BeginJava
			setResult(getRhsSym(2));
		$EndJava./


	ifStatement ::= "IF" oclExpressionCS sequence elseifAny elseOpt "ENDIF"
		/.$BeginJava
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
		$EndJava./

	elseifAny ::= $empty
		/.$BeginJava
			setResult(null);
		$EndJava./
	elseifAny ::= "ELSEIF" oclExpressionCS sequence elseifAny
		/.$BeginJava
			IfStatement elseIf = xpandFactory.createIfStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2), (List) getRhsSym(3), null);
			IfStatement restElseIf = (IfStatement) getRhsSym(4);
			elseIf.setElseIf(restElseIf);
			setResult(elseIf);
		$EndJava./

	elseOpt ::= $empty
		/.$BeginJava
			setResult(null);
		$EndJava./
	elseOpt ::= "ELSE" sequence
		/.$BeginJava
			setResult(xpandFactory.createIfStatement(getLeftIToken(), null, (List) getRhsSym(2), null));
		$EndJava./

	letStatement ::= "LET" oclExpressionCS "AS" IDENTIFIER sequence "ENDLET"
		/.$BeginJava
			setResult(xpandFactory.createLetStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), getRhsIToken(4), (List) getRhsSym(5)));
		$EndJava./
	
	protectStatement ::= "PROTECT" "CSTART" oclExpressionCS "CEND" oclExpressionCS "ID" oclExpressionCS disabledOpt sequence "ENDPROTECT"
		/.$BeginJava
			setResult(xpandFactory.createProtectStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), (OCLExpressionCS) getRhsSym(7), (IToken) getRhsSym(8), (List) getRhsSym(9)));
		$EndJava./

	disabledOpt ::= $empty
		/.$BeginJava
			setResult(null);
		$EndJava./
	disabledOpt ::= "DISABLE"
		/.$BeginJava
			setResult(getLeftIToken());
		$EndJava./

$End