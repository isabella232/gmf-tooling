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

%options fp=XpandLexer,prefix=Char_
%options package=org.eclipse.gmf.internal.xpand.parser
%options template=../expression/parser/LexerTemplateF.gi
%options export_terminals=("XpandParsersym.java", "TK_")
%options filter=XpandKWLexer.g
-- stupid endrem needs 6
%options lalr=6
%options include_directory="../expression/parser/;../../../../../../../../org.eclipse.m2m.qvt.oml.cst.parser/cst;../../../../../../../../org.eclipse.m2m.qvt.oml.cst.parser/lpg"

%Import
	../../../../../../../../org.eclipse.m2m.qvt.oml.cst.parser/cst/QVTOLexer.gi
%End

%Define
	$kw_lexer_class /.XpandKWLexer./
	$prs_stream_class /.PrsStream./
	$getNonASCIICharKindMethodImpl 
	    /.if (c == '\u00AB') {
              return Char_LG;
          }
          if (c == '\u00BB') {
              return Char_RG;
          }
          if (c == '\u00b4') {
              return Char_Acute; // For OCLLexer
          }
          return Char_AfterASCII;
        ./
%End

%Export
	TEXT
	LG
--	RG
%End

%Terminals
	AfterASCII
	LG ::= '\u00AB'
	RG ::= '\u00BB'
%End

%Rules
	Token ::= LG
		/.$BeginAction
			makeToken($_LG);
		$EndAction./

	Token ::= RG textAny lgOpt
		/.$BeginAction
			makeToken($_TEXT);
		$EndAction./

	textAny -> %empty
	textAny -> textAny textAnyChars
	textAnyChars -> AfterASCII | NotSlashOrStar | '*' | '/' | CtlCharNotWS

	-- lgOpt -> EOF | LG
	lgOpt -> %empty
	lgOpt -> LG

	Token ::= R E M RG commentAny lgPlus E N D R E M 
		/.$BeginAction
			skipToken();
		$EndAction./

	commentAny -> %empty
	commentAny -> commentAny commentChar 
	commentAny -> commentAny LG commentCharNotE
	commentAny -> commentAny LG E commentCharNotN
	commentAny -> commentAny LG E N commentCharNotD
	commentAny -> commentAny LG E N D commentCharNotR
	commentAny -> commentAny LG E N D R commentCharNotE
	commentAny -> commentAny LG E N D R E commentCharNotM

	commentChar -> commentCharNoUpper | UpperCaseLetter

	commentCharNoUpper -> AfterASCII | Digit | SpecialNotSlash | WSChar | RG | '*' | '/' | CtlCharNotWS | LowerCaseLetter | '_' 

	commentCharNotE ::= commentCharNoUpper | UpperCaseLetterWithoutENDRM | N | D | R | M 
	commentCharNotN ::= commentCharNoUpper | UpperCaseLetterWithoutENDRM | E | D | R | M
	commentCharNotD ::= commentCharNoUpper | UpperCaseLetterWithoutENDRM | E | N | R | M
	commentCharNotR ::= commentCharNoUpper | UpperCaseLetterWithoutENDRM | E | N | D | M
	commentCharNotM ::= commentCharNoUpper | UpperCaseLetterWithoutENDRM | E | N | D | R

	UpperCaseLetterWithoutENDRM -> A | B | C | F | G | H | I | J | K | L | O | P | Q | S | T | U | V | W | X | Y | Z
	
	lgPlus ::= LG | lgPlus LG
%End