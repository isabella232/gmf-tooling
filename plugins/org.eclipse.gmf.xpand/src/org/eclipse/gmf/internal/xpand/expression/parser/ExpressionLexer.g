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

%options fp=ExpressionLexer,prefix=Char_
%options single-productions
%options package=org.eclipse.gmf.internal.xpand.expression.parser
%options template=LexerTemplateD.g
%options export_terminals=("ExpressionParsersym.java", "TK_")
%options filter=ExpressionKWLexer.g
%options la=2

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

$Define
	$kw_lexer_class /.$ExpressionKWLexer./
	$_IDENTIFIER /.$_IDENT./
$End

$Include
    LexerBasicMap.g
$End

$Export
	IDENT  STRING  INT_CONST  REAL_CONST

	QUESTION_MARK
	DCOLON
	COLON
	LPAREN
	RPAREN
	LCURLY
	RCURLY
	LSQUARE
	RSQUARE
	ARROW
	NOT
	AND
	OR

	ASSIGN
	EQ
	NE
	GE
	LE
	GT
	LT

	PLUS
	MINUS

	MULTI
	DIV

	DOT
	COMMA

	BAR
$End

$Terminals
	CtlCharNotWS

	LF   CR   HT   FF

	a b c d e f g h i j k l m n o p q r s t u v w x y z
	_

	A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

	0 1 2 3 4 5 6 7 8 9

	Space        ::= ' '
	LF           ::= NewLine
	CR           ::= Return
	HT           ::= HorizontalTab
	FF           ::= FormFeed
	DoubleQuote  ::= '"'
	SingleQuote  ::= "'"
	Percent      ::= '%'
	VerticalBar  ::= '|'
	Exclamation  ::= '!'
	AtSign       ::= '@'
	BackQuote    ::= '`'
	Acute        ::= '´'
	Tilde        ::= '~'
	Sharp        ::= '#'
	DollarSign   ::= '$'
	Ampersand    ::= '&'
	Caret        ::= '^'
	Colon        ::= ':'
	SemiColon    ::= ';'
	BackSlash    ::= '\'
	LeftBrace    ::= '{'
	RightBrace   ::= '}'
	LeftBracket  ::= '['
	RightBracket ::= ']'
	QuestionMark ::= '?'
	Comma        ::= ','
	Dot          ::= '.'
	LessThan     ::= '<'
	GreaterThan  ::= '>'
	Plus         ::= '+'
	Minus        ::= '-'
	Slash        ::= '/'
	Star         ::= '*'
	LeftParen    ::= '('
	RightParen   ::= ')'
	Equal        ::= '='
    AfterASCII   ::= '\u0080..\ufffe'

$End

$Start
	Token
$End

$Rules
	Token ::= Identifier
		/.$BeginAction
				checkForKeyWord();
		$EndAction./

	-- unlike original xpand, do not support multiline strings
	Token ::= SingleQuote SLNotSQOpt SingleQuote
		/.$BeginAction
				makeToken($_STRING);
		$EndAction./

	-- unlike original xpand, do not support multiline strings
	Token ::= DoubleQuote SLNotSQOpt DoubleQuote
		/.$BeginAction
				makeToken($_STRING);
		$EndAction./

	Token ::= Integer
		/.$BeginAction
				makeToken($_INT_CONST);
		$EndAction./

	Token ::= Integer '.' Identifier
		/.$BeginAction
				makeToken(getRhsFirstTokenIndex(1), getRhsLastTokenIndex(1), $_INT_CONST);
				makeToken(getRhsFirstTokenIndex(2), getRhsLastTokenIndex(2), $_DOT);
				makeToken(getRhsFirstTokenIndex(3), getRhsLastTokenIndex(3), $_IDENT);
		$EndAction./

	Token ::= Decimal
		/.$BeginAction
				makeToken($_REAL_CONST);
		$EndAction./

	Token ::= '+'
		/.$BeginAction
				makeToken($_PLUS);
		$EndAction./

	Token ::= '-'
		/.$BeginAction
				makeToken($_MINUS);
		$EndAction./

	Token ::= '*'
		/.$BeginAction
				makeToken($_MULTI);
		$EndAction./

	Token ::= '/'
		/.$BeginAction
				makeToken($_DIV);
		$EndAction./

	Token ::= '&' '&'
		/.$BeginAction
				makeToken($_AND);
		$EndAction./

	Token ::= '|' '|'
		/.$BeginAction
				makeToken($_OR);
		$EndAction./

	Token ::= '!'
		/.$BeginAction
				makeToken($_NOT);
		$EndAction./

	Token ::= '('
		/.$BeginAction
				makeToken($_LPAREN);
		$EndAction./

	Token ::= ')'
		/.$BeginAction
				makeToken($_RPAREN);
		$EndAction./

	Token ::= '>'
		/.$BeginAction
				makeToken($_GT);
		$EndAction./
		
	Token ::= '<'
		/.$BeginAction
				makeToken($_LT);
		$EndAction./

	Token ::= '=' '='
		/.$BeginAction
				makeToken($_EQ);
		$EndAction./

	Token ::= '>' '='
		/.$BeginAction
				makeToken($_GE);
		$EndAction./

	Token ::= '<' '='
		/.$BeginAction
				makeToken($_LE);
		$EndAction./

	Token ::= '!' '='
		/.$BeginAction
				makeToken($_NE);
		$EndAction./

	Token ::= '['
		/.$BeginAction
				makeToken($_LSQUARE);
		$EndAction./

	Token ::= ']'
		/.$BeginAction
				makeToken($_RSQUARE);
		$EndAction./

	Token ::= '{'
		/.$BeginAction
				makeToken($_LCURLY);
		$EndAction./

	Token ::= '}'
		/.$BeginAction
				makeToken($_RCURLY);
		$EndAction./

	Token ::= '-' '>'
		/.$BeginAction
				makeToken($_ARROW);
		$EndAction./

	Token ::= '|'
		/.$BeginAction
				makeToken($_BAR);
		$EndAction./

	Token ::= ','
		/.$BeginAction
				makeToken($_COMMA);
		$EndAction./

	Token ::= ':'
		/.$BeginAction
				makeToken($_COLON);
		$EndAction./

	Token ::= ':' ':'
		/.$BeginAction
				makeToken($_DCOLON);
		$EndAction./

	Token ::= '.'
		/.$BeginAction
				makeToken($_DOT);
		$EndAction./

	Token ::= '='
		/.$BeginAction
				makeToken($_ASSIGN);
		$EndAction./

	Token ::= '?'
		/.$BeginAction
				makeToken($_QUESTION_MARK);
		$EndAction./

	Token ::= WS
		/.$BeginAction
				skipToken();
		$EndAction./

    Token ::= '/' '*' Inside Stars '/'
        /.$BeginAction
				skipToken();
		$EndAction./

	Token ::= SLC
		/.$BeginAction
				skipToken();
		$EndAction./


    Integer -> Digit | Integer Digit

    Decimal -> Integer '.' Integer

    Identifier -> Letter
                | Identifier Letter
                | Identifier Digit

    Letter -> LowerCaseLetter | UpperCaseLetter | '_'

    LowerCaseLetter -> a | b | c | d | e | f | g | h | i | j | k | l | m | n | o | p | q | r | s | t | u | v | w | x | y | z
    UpperCaseLetter -> A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z
    Digit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    WSChar -> Space | LF | CR | HT | FF

    WS -> WSChar | WS WSChar

    SpecialNotSlash -> '+' | '-' | -- exclude the star as well
                       '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                       '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                       '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'

	-- dumb copy from OCLLexer, not sure this is the best way to define single line comment
    SLC -> '/' '/' | SLC NotEol

    NotEol -> Letter | Digit | Space | '*' | '/' | SpecialNotSlash | HT | FF | CtlCharNotWS

    NotSlashOrStar -> Letter
                    | Digit
                    | SpecialNotSlash
                    | WSChar

    Inside ::= Inside Stars NotSlashOrStar
             | Inside '/'
             | Inside NotSlashOrStar
             | $empty

    Stars -> '*' | Stars '*'

	SLNotSQ -> NotSQ | SLNotSQ NotSQ

	SLNotSQOpt -> $empty | SLNotSQ

    SpecialNotSQ -> '+' | '-' | '/' | '(' | ')' | '*' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | '|' | '{' | '}' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#'

    NotSQ -> Letter
           | Digit
           | SpecialNotSQ
           | Space
           | EscapeSequence
           | '\' u HexDigit HexDigit HexDigit HexDigit

    EscapeSequence ::= '\' b
                     | '\' t
                     | '\' n
                     | '\' f
                     | '\' r
                     | '\' '"'
                     | '\' "'"
                     | '\' '\'

    afAF -> a | b | c | d | e | f | A | B | C | D | E | F

    HexDigit -> Digit | afAF

$End