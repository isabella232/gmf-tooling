-- Copy of OCL CST factory methods from AbstractOCLParser
-- Only required (reused) methods were copied, hence private visibility to make sure we use all them
-- XXX ask C.Damus to split factory out of AbstractOCLParser.java 
%Headers
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

	private boolean isNonStdSQSupported() {
		return false;
	}
	
	protected SimpleNameCS createConceptualOperationNameCS(IToken token) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(SimpleTypeEnum.KEYWORD_LITERAL);
		String conceptualName = token.toString();
		result.setValue(conceptualName);
		ProblemHandler.Severity sev = ProblemHandler.Severity.OK;
/*
[AS]: TODO log error here

		BasicEnvironment benv = getEnvironment();
		if (benv != null) {
			sev = benv.getValue(ProblemOption.CONCEPTUAL_OPERATION_NAME);
		}
		
		if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
			benv.problem(sev, ProblemHandler.Phase.PARSER, OCLMessages
				.bind(OCLMessages.Conceptual_Operation_Name_, conceptualName),
				"unquote", //$NON-NLS-1$
				token);
		}
*/		
		return result;
	}
	
	protected SimpleNameCS createSimpleNameCS(SimpleTypeEnum type, IToken token) {
		SimpleNameCS result = CSTFactory.eINSTANCE.createSimpleNameCS();
		result.setType(type);
		result.setValue(unDoubleQuote(token));
		return result;
	}
	
	protected StringLiteralExpCS createStringLiteralExpCS(IToken token) {
		StringLiteralExpCS result = CSTFactory.eINSTANCE
			.createStringLiteralExpCS();
		String unquoted = unSingleQuote(token);
		result.setSymbol(unquoted);
		result.setStringSymbol(unquoted);
		result.setUnescapedStringSymbol(unquoted);
		return result;
	}
	
	protected StringLiteralExpCS extendStringLiteralExpCS(StringLiteralExpCS string, IToken token) {       
        String oldString = string.getUnescapedStringSymbol();
        String newString = unSingleQuote(token);
        int oldFinish = string.getEndOffset();
        int newStart = token.getStartOffset();
    	String joinedString;
        if (newStart - oldFinish > 1) {
        	joinedString = oldString + newString;
            }
        else {
        	joinedString = oldString + '\'' + newString;
/*
[AS]: TODO log error here        	
    		ProblemHandler.Severity sev = getEnvironment().getValue(
    			ProblemOption.STRING_SINGLE_QUOTE_ESCAPE);
    		if ((sev != null) && (sev != ProblemHandler.Severity.OK)) {
    			getEnvironment().problem(
    				sev,
    				ProblemHandler.Phase.PARSER,
    				OCLMessages.bind(OCLMessages.NonStd_SQuote_Escape_,
    					joinedString), "STRING_LITERAL", //$NON-NLS-1$
    					joinedString);
    		}
*/    		
        }
		string.setSymbol(joinedString);
    	string.setStringSymbol(joinedString);
    	string.setUnescapedStringSymbol(joinedString);
		return string;
	}
	
	protected Set<String> iteratorNames = null;

	@SuppressWarnings("nls")
	protected Set<String> createIteratorNames() {
		Set<String> iteratorNames = new HashSet<String>();
		iteratorNames.add("any");
		iteratorNames.add("collect");
		iteratorNames.add("collectNested");
		iteratorNames.add("exists");
		iteratorNames.add("forAll");
		iteratorNames.add("isUnique");
		iteratorNames.add("one");
		iteratorNames.add("reject");
		iteratorNames.add("select");
		iteratorNames.add("sortedBy");

		iteratorNames.add("closure");
		return iteratorNames;
	}
	
	protected boolean isIterator(String name) {
		if (iteratorNames == null) {
			iteratorNames = createIteratorNames();
		}
		return iteratorNames.contains(name);
	}
./
%End