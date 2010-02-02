-- Copy of reelvant methods from org.eclipse.ocl.lpg.AbstractParser
%Headers
/.
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
		if ((quotedLength < 2) || (quoted.charAt(0) != '"') || (quoted.charAt(quotedLength-1) != '"')) {
			return quoted;
		}
		ProblemHandler.Severity sev = ProblemHandler.Severity.OK;
/*
		BasicEnvironment benv = getEnvironment();

		if (benv != null) {
			sev = benv
				.getValue(ProblemOption.ELEMENT_NAME_QUOTE_ESCAPE);
		}
		if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
			benv.problem(sev, ProblemHandler.Phase.PARSER, OCLMessages
				.bind(OCLMessages.NonStd_DQuote_Escape_, quoted),
				"unquote", //$NON-NLS-1$
				token);
		}
*/		
		return decodeString(token, quoted.substring(1, quotedLength-1));
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
		if ((quotedLength < 2) || (quoted.charAt(0) != '\'') || (quoted.charAt(quotedLength-1) != '\'')) {
			return quoted;
		}
		String unquoted = quoted.substring(1, quotedLength-1);
		Boolean backslashProcessingEnabled = true;
/*
		BasicEnvironment benv = getEnvironment();
		if (benv != null) {
			backslashProcessingEnabled = benv
				.getValue(ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING);
		}
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
			}
			else {
				int iStart = i.getIndex();
				char ch = decodeEscapeSequence(i);
				if (ch != StringCharacterIterator.DONE) {
					s.append(ch);
				}
				else {
/*
[AS]: TODO: report error here

					BasicEnvironment benv = getEnvironment();
					benv.problem(ProblemHandler.Severity.ERROR, ProblemHandler.Phase.PARSER, OCLMessages
						.bind(OCLMessages.InvalidEscapeSequence_ERROR, string.substring(iStart, i.getIndex())),
						"unquote", //$NON-NLS-1$
						token);
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
			case 'b' : return '\b';
			case 'f' : return '\f';
			case 't' : return '\t';
			case 'n' : return '\n';
			case 'r' : return '\r';
			case '\\' : return '\\';
			case '\'' : return '\'';
			case '"' : return '\"';
			case '0' :
			case '1' :
			case '2' :
			case '3' : {
				int c1 = c - '0';
				int c2 = decodeOctalCharacter(i);
				if (c2 < 0) {
					return (char)(c1);					
				}
				int c3 = decodeOctalCharacter(i);
				if (c3 < 0) {
					return (char)((c1 << 3) + c2);
				}
				return (char)((c1 << 6) + (c2 << 3) + c3);
			}
			case '4' :
			case '5' :
			case '6' :
			case '7' : {
				int c1 = c - '0';
				int c2 = decodeOctalCharacter(i);
				if (c2 < 0) {
					i.previous();
					return (char)(c1);					
				}
				return (char)((c1 << 3) + c2);
			}
			case 'x' : {
				int c1 = decodeHexCharacter(i.next());
				int c2 = decodeHexCharacter(i.next());
				if ((c1 < 0) || (c2 < 0)) {
					break;
				}
				return (char)((c1 << 4) + c2);
			}
			case 'u' : {
				int c1 = decodeHexCharacter(i.next());
				int c2 = decodeHexCharacter(i.next());
				int c3 = decodeHexCharacter(i.next());
				int c4 = decodeHexCharacter(i.next());
				if ((c1 < 0) || (c2 < 0) || (c3 < 0) || (c4 < 0)) {
					break;
				}
				return (char)((c1 << 12) + (c2 << 8) + (c3 << 4) + c4);
			}
		}
		i.setIndex(savedIndex);		// Give derived augmentations the same starting point
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
./
%End