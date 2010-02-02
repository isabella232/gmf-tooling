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

%options fp=XpandKWLexer,prefix=Char_
%options package=org.eclipse.gmf.internal.xpand.parser
%options template=../expression/parser/KeywordTemplateF.gi
%options export_terminals=("XpandParsersym.java", "TK_")
%options include_directory="../../../../../../../../org.eclipse.m2m.qvt.oml.cst.parser/cst;../../../../../../../../org.eclipse.m2m.qvt.oml.cst.parser/lpg"

%Import
	../../../../../../../../org.eclipse.m2m.qvt.oml.cst.parser/cst/QVTOKWLexer.gi

%DropRules
	QVTKeyWord ::= t r a n s f o r m a t i o n
	QVTKeyWord ::= i m p o r t
	QVTKeyWord ::= l i b r a r y
	QVTKeyWord ::= m e t a m o d e l
	QVTKeyWord ::= m a p p i n g
	QVTKeyWord ::= q u e r y
	QVTKeyWord ::= h e l p e r
	QVTKeyWord ::= e n d
	QVTKeyWord ::= m a p
	QVTKeyWord ::= x m a p
	QVTKeyWord ::= o u t
	QVTKeyWord ::= i n o u t
	QVTKeyWord ::= m o d e l t y p e
	QVTKeyWord ::= e x t e n d s
	QVTKeyWord ::= a b s t r a c t
	QVTKeyWord ::= s t a t i c
	QVTKeyWord ::= r e s u l t
	QVTKeyWord ::= m a i n
	QVTKeyWord ::= r e t u r n
	QVTKeyWord ::= r e n a m e
	QVTKeyWord ::= d i s j u n c t s
	QVTKeyWord ::= m e r g e s
	QVTKeyWord ::= i n h e r i t s
	-- next are symbols that were not dropped
	QVTKeyWord ::= c o n f i g u r a t i o n
		| p o p u l a t i o n
		| i n t e r m e d i a t e
		| p r o p e r t y
		| l a t e
		| l o g
		| a s s e r t
		| u s e s
		| r e f i n e s
		| e n f o r c i n g
		| a c c e s s
		| b l a c k b o x
%End

%Export
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
%End

%Rules
	KeyWord ::=
		I M P O R T
		/.$BeginAction
			$setResult($_IMPORT);
		$EndAction./

		| E X T E N S I O N
		/.$BeginAction
			$setResult($_EXTENSION);
		$EndAction./

		| A R O U N D
		/.$BeginAction
			$setResult($_AROUND);
		$EndAction./

		| E N D A R O U N D
		/.$BeginAction
			$setResult($_ENDAROUND);
		$EndAction./

		| D E F I N E
		/.$BeginAction
			$setResult($_DEFINE);
		$EndAction./

		| E N D D E F I N E
		/.$BeginAction
			$setResult($_ENDDEFINE);
		$EndAction./

		| E R R O R
		/.$BeginAction
			$setResult($_ERROR);
		$EndAction./

		| E X P A N D
		/.$BeginAction
			$setResult($_EXPAND);
		$EndAction./

		| F O R
		/.$BeginAction
			$setResult($_FOR);
		$EndAction./

		| S E P A R A T O R
		/.$BeginAction
			$setResult($_SEPARATOR);
		$EndAction./

		| A S
		/.$BeginAction
			$setResult($_AS);
		$EndAction./

		| I T E R A T O R
		/.$BeginAction
			$setResult($_ITERATOR);
		$EndAction./

		| F O R E A C H
		/.$BeginAction
			$setResult($_FOREACH);
		$EndAction./

		| E N D F O R E A C H
		/.$BeginAction
			$setResult($_ENDFOREACH);
		$EndAction./

		| F I L E
		/.$BeginAction
			$setResult($_FILE);
		$EndAction./

		| E N D F I L E
		/.$BeginAction
			$setResult($_ENDFILE);
		$EndAction./

		| I F
		/.$BeginAction
			$setResult($_IF);
		$EndAction./

		| E L S E I F
		/.$BeginAction
			$setResult($_ELSEIF);
		$EndAction./

		| E L S E
		/.$BeginAction
			$setResult($_ELSE);
		$EndAction./

		| E N D I F
		/.$BeginAction
			$setResult($_ENDIF);
		$EndAction./

		| L E T
		/.$BeginAction
			$setResult($_LET);
		$EndAction./

		| E N D L E T
		/.$BeginAction
			$setResult($_ENDLET);
		$EndAction./

		| P R O T E C T
		/.$BeginAction
			$setResult($_PROTECT);
		$EndAction./

		| C S T A R T
		/.$BeginAction
			$setResult($_CSTART);
		$EndAction./

		| C E N D
		/.$BeginAction
			$setResult($_CEND);
		$EndAction./

		| I D
		/.$BeginAction
			$setResult($_ID);
		$EndAction./

		| D I S A B L E
		/.$BeginAction
			$setResult($_DISABLE);
		$EndAction./

		| E N D P R O T E C T
		/.$BeginAction
			$setResult($_ENDPROTECT);
		$EndAction./
%End