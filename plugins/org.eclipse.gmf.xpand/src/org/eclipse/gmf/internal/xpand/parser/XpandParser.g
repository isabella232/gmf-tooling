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

%Globals
	/.
	import org.eclipse.gmf.internal.xpand.expression.ast.Identifier;
	import org.eclipse.gmf.internal.xpand.ast.*;
	import org.eclipse.ocl.cst.*;
	import java.util.Collections;

	import org.eclipse.m2m.internal.qvt.oml.cst.SimpleSignatureCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ParameterDeclarationCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindEnum;
	import org.eclipse.m2m.internal.qvt.oml.cst.DirectionKindCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.TypeSpecCS;
	
	import org.eclipse.ocl.util.OCLStandardLibraryUtil;
	import org.eclipse.ocl.utilities.PredefinedType;

	./
%End

%Headers
	/.
		private final XpandFactory xpandFactory;
	./
%End

%Start
	template
%End

%Import
	../../../../../../../../org.eclipse.m2m.qvt.oml.cst.parser/cst/ImperativeOCL.gi

%DropRules
	primaryNotNameCS -> switchExpCS
	primaryNotNameCS -> whileExpCS
	primaryNotNameCS -> computeExpCS
	primaryNotNameCS -> newExpCS
	IterateExpCS ::= primaryExpCS '->' switch '(' switchDeclaratorCS ')' switchBodyExpCS
	IteratorExpCS ::= primaryExpCS '->' forExpCS
	ifExpBodyCS -> expression_block
	OclExpressionCS -> assignStatementCS
	OclExpressionCS ::= primaryOCLExpressionCS
	OclExpressionCS -> returnExpCS
	OclExpressionCS -> var_init_exp

%DropSymbols
	logExpCS logWhenExp logWhenExpOpt
	assertExpCS assertWithLogExp assertWithLogExpOpt severityKindCS severityKindCSOpt
	oclExpressionCSOpt 
	expression_statement
	expression_block
	switchExpCS
	switchDeclaratorCS
	switchBodyExpCS
	switchAltExpCS
	switchElseExpCSOpt
	switchElseExpCS
	switchAltExpCSList
	whileExpCS
	whileBodyCS
	computeExpCS
	forExpCS
	forOpCode
	forExpDeclaratorList
	forExpConditionOpt
	--
	assignStatementCS
	primaryOCLExpressionCS
	returnExpCS
	var_init_group_exp
	var_init_exp
	expression_list
	expression_listOpt
	expression_semi_list
	expression_semi_list_element
	var_init_declarator_list
	var_init_declarator
	var_init_op
	newExpCS
	qualifier
	qualifierList
	param
	param_list
	param_listOpt
	colon_param_listOpt
	complete_signature
	simple_signature
	simple_signatureOpt
	param_direction 
	param_directionOpt
	typespec
	typeCS2
	scoped_identifier
	scoped_identifier2
	scoped_identifier_list
	semicolonOpt
	qualifiedNameCS
	qvtIdentifierCS
	reservedKeywordCS
	otherKeywordCS
	otherKeyword
--	simpleNameCS
	newTypespecCS
%End

-- FIXME need to fix $Notice section from EssentialOCL.g

-- factory method for QVT CST constructs
%Include
	AbstractQVTParser.gi
%End

-- factory method for OCL CST constructs
%Include
	AbstractOCLParser.gi
%End

-- unquote and setOffsets methods
%Include
	AbstractParser.gi
%End

%Define
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
%End

%Terminals
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
%End

%Rules

	template ::= emptyTemplate
		/.$BeginCode
			setResult(xpandFactory.createTemplate(Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, Collections.EMPTY_LIST, getRightIToken()));
		$EndCode./

	-- original xpand allows empty templates, not sure what for; added support to handle comments-only content
	emptyTemplate -> %empty | LG TEXT commentTextPairAny

	-- unlike original xpand, do not allow mixed order of imports (ext and regular)
	template ::= LG commentTextPairAny imports extensionImports defineOrAroundSeq
		/.$BeginCode
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
		$EndCode./

	defineOrAroundSeq ::= define TEXT commentTextPairAny defineOrAroundSuffix
		/.$BeginCode
			List result = new LinkedList();
			result.add(getRhsSym(1));
			result.addAll((List) getRhsSym(4));
			setResult(result);
		$EndCode./
	defineOrAroundSeq ::= around TEXT commentTextPairAny defineOrAroundSuffix 
		/.$BeginCode
			List result = new LinkedList();
			result.add(getRhsSym(1));
			result.addAll((List) getRhsSym(4));
			setResult(result);
		$EndCode./
	defineOrAroundSuffix ::= %empty
		/.$BeginCode
			setResult(Collections.EMPTY_LIST);
		$EndCode./
	defineOrAroundSuffix -> defineOrAroundSeq

	commentTextPairAny -> %empty | TEXT commentTextPairAny

	imports ::= %empty
		/.$BeginCode
			setResult(Collections.EMPTY_LIST);
		$EndCode./
	imports ::= anImport imports
		/.$BeginCode
			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
		$EndCode./

	anImport ::= "IMPORT" StringLiteralExpCS TEXT commentTextPairAny 
		/.$BeginCode
			setResult(xpandFactory.createNamespaceImport(getLeftIToken(), (StringLiteralExpCS) getRhsSym(2)));
		$EndCode./

	extensionImports ::= %empty
		/.$BeginCode
			setResult(Collections.EMPTY_LIST);
		$EndCode./
	extensionImports ::= anExtensionImport extensionImports
		/.$BeginCode
			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
		$EndCode./

	anExtensionImport ::= "EXTENSION" pathNameCS TEXT commentTextPairAny 
		/.$BeginCode
			setResult(xpandFactory.createImportDeclaration(getLeftIToken(), (PathNameCS) getRhsSym(2)));
		$EndCode./

	around ::= "AROUND" pointcut "FOR" typeCS sequence "ENDAROUND"
		/.$BeginCode
			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), Collections.<VariableCS>emptyList(), false, (TypeCS) getRhsSym(4), (List) getRhsSym(5)));
		$EndCode./
	around ::= "AROUND" pointcut LPAREN parametersList RPAREN "FOR" typeCS sequence "ENDAROUND"
		/.$BeginCode
			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), (List<VariableCS>) getRhsSym(4), false, (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
		$EndCode./
	around ::= "AROUND" pointcut LPAREN parametersList COMMA MULTIPLY RPAREN "FOR" typeCS sequence "ENDAROUND"
		/.$BeginCode
			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), (List<VariableCS>) getRhsSym(4), true, (TypeCS) getRhsSym(9), (List) getRhsSym(10)));
		$EndCode./
	around ::= "AROUND" pointcut LPAREN MULTIPLY RPAREN "FOR" typeCS sequence "ENDAROUND"
		/.$BeginCode
			setResult(xpandFactory.createAround(getLeftIToken(), getRightIToken(), (Identifier) getRhsSym(2), Collections.<VariableCS>emptyList(), true, (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
		$EndCode./

	pointcut ::= MULTIPLY pointcutSuffix 
		/.$BeginCode
//			FIXME: may use SimpleNameCS here, though need more sophisticated code to update end position
//			SimpleNameCS simpleNameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, getTokenText(getRhsTokenIndex(1)));
//			setOffsets(simpleNameCS, getLeftIToken());
			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
		$EndCode./
	pointcut ::= IDENTIFIER pointcutSuffix
		/.$BeginCode
			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
		$EndCode./

	pointcutSuffix ::= %empty
		/.$BeginCode
			setResult(null);
		$EndCode./
	pointcutSuffix -> pointcut
	pointcutSuffix ::= COLONCOLON pointcutSuffix
		/.$BeginCode
			Identifier res = xpandFactory.createIdentifier(getLeftIToken());
			if (getRhsSym(2) != null) {
				res = res.append((Identifier) getRhsSym(2));
			}
			setResult(res);
		$EndCode./

	define ::= "DEFINE" IDENTIFIER "FOR" typeCS sequence "ENDDEFINE"
		/.$BeginCode
			setResult(xpandFactory.createDefinition(getLeftIToken(), getRightIToken(), getRhsIToken(2), Collections.<VariableCS>emptyList(), (TypeCS) getRhsSym(4), (List) getRhsSym(5)));
		$EndCode./
	define ::= "DEFINE" IDENTIFIER LPAREN parametersList RPAREN "FOR" typeCS sequence "ENDDEFINE"
		/.$BeginCode
			setResult(xpandFactory.createDefinition(getLeftIToken(), getRightIToken(), getRhsIToken(2), (List<VariableCS>) getRhsSym(4), (TypeCS) getRhsSym(7), (List) getRhsSym(8)));
		$EndCode./
		
	parametersList ::= parameter 
		/.$BeginCode
			VariableCS param = (VariableCS) getRhsSym(1);
			LinkedList res = new LinkedList();
			res.add(param);
			setResult(res);
		$EndCode./

	parametersList ::= parametersList ',' parameter 
		/.$BeginCode
			VariableCS param = (VariableCS) getRhsSym(3);
			LinkedList res = new LinkedList();
			res.addAll((List) getRhsSym(1));
			res.add(param);
			setResult(res);
		$EndCode./

	parameter -> declarator

	parameter ::= typeCS IDENTIFIER
		/.$BeginCode
			VariableCS result = createVariableCS(getRhsIToken(2).toString(), (TypeCS) getRhsSym(1), null);
			setOffsets(result, (TypeCS) getRhsSym(1), getRhsIToken(2));
			setResult(result);
		$EndCode./
	
	sequence ::= text sequenceSuffix
		/.$BeginCode
			List res = new LinkedList();
			res.addAll((List) getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			setResult(res);
		$EndCode./
	sequenceSuffix ::= %empty
		/.$BeginCode
			setResult(Collections.EMPTY_LIST);
		$EndCode./
	sequenceSuffix ::= statement text sequenceSuffix
		/.$BeginCode
			List res = new LinkedList();
			res.add(getRhsSym(1));
			res.addAll((List) getRhsSym(2));
			res.addAll((List) getRhsSym(3));
			setResult(res);
		$EndCode./


--
-- Statements
--
--
	statement -> simpleStatement | fileStatement | foreachStatement | ifStatement | letStatement | protectStatement

	text ::= minusOpt TEXT textSuffix 
		/.$BeginCode
			List res = new LinkedList();
			res.add(xpandFactory.createTextStatement(getRhsIToken(2), (IToken) getRhsSym(1)));
			res.addAll((List) getRhsSym(3));
			setResult(res);
		$EndCode./

	textSuffix ::= %empty
		/.$BeginCode
			setResult(Collections.EMPTY_LIST);
		$EndCode./
	textSuffix ::= minusOpt TEXT textSuffix
		/.$BeginCode
			List res = new LinkedList();
			res.add(xpandFactory.createTextStatement(getRhsIToken(2), (IToken) getRhsSym(1)));
			res.addAll((List) getRhsSym(3));
			setResult(res);
		$EndCode./

	minusOpt ::= %empty
		/.$BeginCode
			setResult(null);
		$EndCode./
	minusOpt ::= MINUS
		/.$BeginCode
			setResult(getLeftIToken());
		$EndCode./

	simpleStatement -> errorStatement | expandStatement | expressionStmt

	errorStatement ::= "ERROR" OclExpressionCS
		/.$BeginCode
			setResult(xpandFactory.createErrorStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2)));
		$EndCode./


	expandStatement ::= "EXPAND" definitionName parameterListOpt
		/.$BeginCode
			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), null, false, null));
		$EndCode./
	expandStatement ::= "EXPAND" definitionName parameterListOpt "FOR" OclExpressionCS
		/.$BeginCode
			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), false, null));
		$EndCode./
	expandStatement ::= "EXPAND" definitionName parameterListOpt "FOREACH" OclExpressionCS separatorOpt
		/.$BeginCode
			setResult(xpandFactory.createExpandStatement(getLeftIToken(), (PathNameCS) getRhsSym(2), (List) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), true, (OCLExpressionCS) getRhsSym(6)));
		$EndCode./

	parameterListOpt ::= %empty
		/.$BeginCode
			setResult(Collections.EMPTY_LIST);
		$EndCode./
	parameterListOpt ::= LPAREN argumentsCS RPAREN
		/.$BeginCode
			setResult(getRhsSym(2));
		$EndCode./


	definitionName -> pathNameCS

	expressionStmt ::= OclExpressionCS
		/.$BeginCode
			// XXX OCL CST doesn't keep track of line numbers, but we use them (perhaps, might refactor to stop using?)
			int lineNumber = getLeftIToken().getLine();
			setResult(xpandFactory.createExpressionStatement((OCLExpressionCS) getRhsSym(1), lineNumber));
		$EndCode./

	fileStatement ::= "FILE" OclExpressionCS identOpt sequence "ENDFILE"
		/.$BeginCode
			setResult(xpandFactory.createFileStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), (Identifier) getRhsSym(3), (List) getRhsSym(4)));
		$EndCode./

	-- XXX may use simpleNameCSopt instead, however not sure about self and String/Real/etc as possible values there.
	identOpt ::= %empty
		/.$BeginCode
			setResult(null);
		$EndCode./
	identOpt ::= IDENTIFIER
		/.$BeginCode
			setResult(xpandFactory.createIdentifier(getLeftIToken()));
		$EndCode./

	foreachStatement ::= "FOREACH" OclExpressionCS "AS" IDENTIFIER iteratorOpt separatorOpt sequence "ENDFOREACH"
		/.$BeginCode
			setResult(xpandFactory.createForEachStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), getRhsIToken(4), (OCLExpressionCS) getRhsSym(6), (IToken) getRhsSym(5), (List) getRhsSym(7)));
		$EndCode./

	iteratorOpt ::= %empty
		/.$BeginCode
			setResult(null);
		$EndCode./
	iteratorOpt ::= "ITERATOR" IDENTIFIER
		/.$BeginCode
			setResult(getRightIToken());
		$EndCode./

	separatorOpt ::= %empty
		/.$BeginCode
			setResult(null);
		$EndCode./
	separatorOpt ::= "SEPARATOR" OclExpressionCS
		/.$BeginCode
			setResult(getRhsSym(2));
		$EndCode./


	ifStatement ::= "IF" OclExpressionCS sequence elseifAny elseOpt "ENDIF"
		/.$BeginCode
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
		$EndCode./

	elseifAny ::= %empty
		/.$BeginCode
			setResult(null);
		$EndCode./
	elseifAny ::= "ELSEIF" OclExpressionCS sequence elseifAny
		/.$BeginCode
			IfStatement elseIf = xpandFactory.createIfStatement(getLeftIToken(), (OCLExpressionCS) getRhsSym(2), (List) getRhsSym(3), null);
			IfStatement restElseIf = (IfStatement) getRhsSym(4);
			elseIf.setElseIf(restElseIf);
			setResult(elseIf);
		$EndCode./

	elseOpt ::= %empty
		/.$BeginCode
			setResult(null);
		$EndCode./
	elseOpt ::= "ELSE" sequence
		/.$BeginCode
			setResult(xpandFactory.createIfStatement(getLeftIToken(), null, (List) getRhsSym(2), null));
		$EndCode./

	letStatement ::= "LET" OclExpressionCS "AS" IDENTIFIER sequence "ENDLET"
		/.$BeginCode
			setResult(xpandFactory.createLetStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(2), getRhsIToken(4), (List) getRhsSym(5)));
		$EndCode./
	
	protectStatement ::= "PROTECT" "CSTART" OclExpressionCS "CEND" OclExpressionCS "ID" OclExpressionCS disabledOpt sequence "ENDPROTECT"
		/.$BeginCode
			setResult(xpandFactory.createProtectStatement(getLeftIToken(), getRightIToken(), (OCLExpressionCS) getRhsSym(3), (OCLExpressionCS) getRhsSym(5), (OCLExpressionCS) getRhsSym(7), (IToken) getRhsSym(8), (List) getRhsSym(9)));
		$EndCode./

	disabledOpt ::= %empty
		/.$BeginCode
			setResult(null);
		$EndCode./
	disabledOpt ::= "DISABLE"
		/.$BeginCode
			setResult(getLeftIToken());
		$EndCode./

%End