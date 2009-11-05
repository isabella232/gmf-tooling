-- Copy of OCL CST factory methods from AbstractOCLParser
-- Only required (reused) methods were copied, hence private visibility to make sure we use all them
-- XXX ask C.Damus to split factory out of AbstractOCLParser.java 
$Headers
/.
	private OperationCallExpCS createArrowOperationCallExpCS(OCLExpressionCS oclExpressionCS, SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS, EList<OCLExpressionCS> arguments) {
		return createOperationCallExpCS(oclExpressionCS, DotOrArrowEnum.ARROW_LITERAL, null, simpleNameCS, isMarkedPreCS, arguments);
	}
	
	private OperationCallExpCS createOperationCallExpCS(OCLExpressionCS oclExpressionCS, DotOrArrowEnum dotOrArrow, PathNameCS pathNameCS, SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS, EList<OCLExpressionCS> arguments) {
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
		SimpleNameCS name = simpleNames.remove(simpleNames.size()-1);
		setOffsets(path, path, simpleNames.size() > 0 ? simpleNames.get(simpleNames.size()-1) : path);
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

	private CollectionRangeCS createCollectionRangeCS(
			OCLExpressionCS oclExpressionCS,
			OCLExpressionCS lastOCLExpressionCS) {
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

	private String unescape(IToken stringLiteral) {
		String rawString = stringLiteral.toString();
		int rawStringLength = rawString.length();
		if (rawStringLength <= 2) {
			return ""; //$NON-NLS-1$
		}
		StringBuilder unescapedStringBuilder = null;
		boolean isBackslashEscapeProcessingUsed = true; //getEnvironment().isEnabled(ParsingOptions.USE_BACKSLASH_ESCAPE_PROCESSING);
		boolean isNonStdSQEscapingUsed = false;
		int n = rawStringLength - 1;
		for (int i = 1; i < n; i++) {
			char ch = rawString.charAt(i);
			if ((isBackslashEscapeProcessingUsed && (ch == '\\'))
				|| ((ch == '\'') && isNonStdSQSupported())) {
				if (unescapedStringBuilder == null) {
					unescapedStringBuilder = new StringBuilder(rawString
						.substring(1, i));
				}
				i++;
				if (i >= n) {
					reportError(
						ParseErrorCodes.INVALID_CODE,
						"", stringLiteral.getTokenIndex(), stringLiteral.getTokenIndex(), //$NON-NLS-1$
						"String literal not properly closed");
				}
				char nextCh = rawString.charAt(i);
				if (ch == '\\') {
					switch (nextCh) {
						case 'b' :
							unescapedStringBuilder.append('\b');
							break;
						case 't' :
							unescapedStringBuilder.append('\t');
							break;
						case 'n' :
							unescapedStringBuilder.append('\n');
							break;
						case 'f' :
							unescapedStringBuilder.append('\f');
							break;
						case 'r' :
							unescapedStringBuilder.append('\r');
							break;
						case '\"' :
							unescapedStringBuilder.append('\"');
							break;
						case '\'' :
							unescapedStringBuilder.append('\'');
							break;
						case '\\' :
							unescapedStringBuilder.append('\\');
							break;
						default :
							// octal escape check
							int unescapedChar = -1;
							if ((nextCh >= '\u0030') && (nextCh <= '\u0037')) { // octal
																				// digit
								unescapedChar = Character
									.getNumericValue(nextCh);
								if (i + 1 < n) {
									char tmpCh = rawString.charAt(i + 1);
									if ((tmpCh >= '\u0030')
										&& (tmpCh <= '\u0037')) { // octal digit
										unescapedChar = 8 * unescapedChar
											+ Character.getNumericValue(tmpCh);
										i++;
										if (i + 1 < n) {
											tmpCh = rawString.charAt(i + 1);
											if ((tmpCh >= '\u0030')
												&& (tmpCh <= '\u0037') // octal
																		// digit
												&& (nextCh <= '\u0033')) { // most-significant
																			// digit
																			// in
																			// range
																			// 0..2
												unescapedChar = 8
													* unescapedChar
													+ Character
														.getNumericValue(tmpCh);
												i++;
											}
										}
									}
								}
								unescapedStringBuilder
									.append((char) unescapedChar);
							}
							if (unescapedChar < 0) {
								reportError(
									ParseErrorCodes.INVALID_CODE,
									"", stringLiteral.getTokenIndex(), stringLiteral.getTokenIndex(), //$NON-NLS-1$
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
			
	//		// check settings for using non-standard closure iterator
	//		ProblemHandler.Severity sev = getEnvironment().getValue(
	//			ProblemOption.STRING_SINGLE_QUOTE_ESCAPE);
	//		if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
	//			getEnvironment().problem(
	//				sev,
	//				ProblemHandler.Phase.PARSER,
	//				OCLMessages.bind(OCLMessages.NonStd_SQuote_Escape_,
	//					stringLiteral), "STRING_LITERAL", //$NON-NLS-1$
	//				null);
	//		}
		}
		return (unescapedStringBuilder == null)
			? rawString.substring(1, n)
			: unescapedStringBuilder.toString();
	}

	private boolean isNonStdSQSupported() {
		return false;
	}
./
$End