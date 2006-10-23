--
-- Copyright (c) 2006 Borland Software Corp.
-- 
-- All rights reserved. This program and the accompanying materials
-- are made available under the terms of the Eclipse Public License v1.0
-- which accompanies this distribution, and is available at
-- http://www.eclipse.org/legal/epl-v10.html
--
-- Contributors:
--    Artem Tikhomirov (Borland)
--

%options fp=ExpressionKWLexer,prefix=Char_
%options package=org.eclipse.gmf.internal.xpand.expression.parser
%options template=KeywordTemplateD.g
%options export_terminals=("ExpressionParsersym.java", "TK_")

$Notice
/./*******************************************************************************
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/./
$End

$Include
	KWLexerMap.g
$End

$Export
	true
	false
	null
	new
	let
	switch
	case
	default
	implies

	Collection
	List
	Set

	collect
	select
	reject
	exists
	notExists
	forAll
	typeSelect
$End

$Terminals
	DollarSign
	a b c d e f g h i j k l m n o p q r s t u v w x y z
	A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
$End

$Eof
	EOF
$End

$Start
	KeyWord
$End

$Rules
	KeyWord ::=
		n u l l
		/.$BeginAction
			$setResult($_null);
		  $EndAction
		./

		| t r u e
		/.$BeginAction
			$setResult($_true);
		  $EndAction
		./
		
		| f a l s e
		/.$BeginAction
			$setResult($_false);
		  $EndAction
		./

		| n e w
		/.$BeginAction
			$setResult($_new);
		  $EndAction
		./
		
		| l e t
		/.$BeginAction
			$setResult($_let);
		  $EndAction
		./
		
		| s w i t c h
		/.$BeginAction
			$setResult($_switch);
		  $EndAction
		./
		
		| c a s e
		/.$BeginAction
			$setResult($_case);
		  $EndAction
		./
		
		| d e f a u l t
		/.$BeginAction
			$setResult($_default);
		  $EndAction
		./
		
		| i m p l i e s
		/.$BeginAction
			$setResult($_implies);
		  $EndAction
		./

		| S e t
		/.$BeginAction
			$setResult($_Set);
		  $EndAction
		./
		
		| L i s t
		/.$BeginAction
			$setResult($_List);
		  $EndAction
		./
		
		| C o l l e c t i o n
		/.$BeginAction
			$setResult($_Collection);
		  $EndAction
		./

		| f o r A l l
		/.$BeginAction
			$setResult($_forAll);
		  $EndAction
		./
		
		| e x i s t s
		/.$BeginAction
			$setResult($_exists);
		  $EndAction
		./

		| n o t E x i s t s
		/.$BeginAction
			$setResult($_notExists);
		  $EndAction
		./

		| c o l l e c t
		/.$BeginAction
			$setResult($_collect);
		  $EndAction
		./

		| s e l e c t
		/.$BeginAction
			$setResult($_select);
		  $EndAction
		./

		| r e j e c t
		/.$BeginAction
			$setResult($_reject);
		  $EndAction
		./

		| t y p e S e l e c t
		/.$BeginAction
			$setResult($_typeSelect);
		  $EndAction
		./
$End
