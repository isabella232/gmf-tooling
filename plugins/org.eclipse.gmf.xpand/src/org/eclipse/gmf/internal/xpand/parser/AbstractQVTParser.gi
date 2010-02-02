-- Copy of QVT CST factory methods from AbstractQVTParser
-- Only required (reused) methods were copied, hence private visibility to make sure we use all them
-- XXX ask QVT guys to split factory out of AbstractOCLParser.java 
%Globals
	/.
	import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.StatementCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ListLiteralExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ImperativeOperationCallExpCS;
	./
%End

%Headers
/.
    private ImperativeIterateExpCS createImperativeIterateExpCS(
            SimpleNameCS simpleNameCS,
            EList<VariableCS> iterators,
            VariableCS target,
            OCLExpressionCS body,
            OCLExpressionCS condition) {
        ImperativeIterateExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createImperativeIterateExpCS();
        result.setSimpleNameCS(simpleNameCS);
        if (iterators.size() > 0) {
            result.setVariable1(iterators.get(0));
            if (iterators.size() > 1) {
                result.setVariable2(iterators.get(1));
            }
        }
        if (target != null) {
            result.setTarget(target);
        }
        result.setBody(body);
        result.setCondition(condition);
        return result;
    }
    
	protected final CSTNode createCompleteSignatureCS(SimpleSignatureCS simpleSignatureCS, EList<ParameterDeclarationCS> resultList) {
	    CompleteSignatureCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createCompleteSignatureCS();
	    result.setSimpleSignature(simpleSignatureCS);
	    result.getResultParams().addAll(resultList);
	    return result;
	}
	
	protected final SimpleSignatureCS createSimpleSignatureCS(EList<ParameterDeclarationCS> paramsCS) {
	    SimpleSignatureCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createSimpleSignatureCS();
	    result.getParams().addAll(paramsCS);
	    return result;
	}
	
	protected final ParameterDeclarationCS createParameterDeclarationCS(DirectionKindCS sym, IToken tokenText, TypeSpecCS typeSpecCS) {
		ParameterDeclarationCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createParameterDeclarationCS();
		SimpleNameCS nameCS = null;
		if (tokenText != null) {
			nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
			setOffsets(nameCS, tokenText);
		} else {
			//nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, ""); //$NON-NLS-1$
		}
		result.setSimpleNameCS(nameCS);
		result.setTypeSpecCS(typeSpecCS);
		if (sym != null) {
			result.setDirectionKind(sym.getDirectionKind());
		}
		return result;
	}
	
	protected final CSTNode createLibraryImportCS(PathNameCS sym) {
		LibraryImportCS imp = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createLibraryImportCS();
		imp.setPathNameCS(sym);
		return imp;
	}
	
	protected final CSTNode createDirectionKindCS(DirectionKindEnum kind) {
		DirectionKindCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDirectionKindCS();
		result.setDirectionKind(kind);
		return result;
	}
	
	protected final TypeSpecCS createTypeSpecCS(TypeCS typeCS, IToken extentLocation) {
		TypeSpecCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTypeSpecCS();
		result.setTypeCS(typeCS);
		setOffsets(result, typeCS);
		if (extentLocation != null) {
			SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, extentLocation.toString());
			setOffsets(nameCS, extentLocation);
			result.setSimpleNameCS(nameCS);
			result.setEndOffset(extentLocation.getEndOffset());
		}
		return result;
	}
	
	private ListTypeCS createListTypeCS(TypeCS typeCS) {
		ListTypeCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createListTypeCS();
		result.setTypeCS(typeCS);
		return result;
	}
	
	private DictLiteralExpCS createDictLiteralExpCS(EList<DictLiteralPartCS> parts) {		
		DictLiteralExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDictLiteralExpCS();
		result.getParts().addAll(parts);
		return result;
	}
	
	private DictionaryTypeCS createDictTypeCS(TypeCS keyTypeCS, TypeCS valueTypeCS) {
		DictionaryTypeCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDictionaryTypeCS();
		result.setKey(keyTypeCS);
		result.setValue(valueTypeCS);
		return result;
	}	
	
	private DictLiteralPartCS createDictLiteralPartCS(LiteralExpCS keyLiteralCS, OCLExpressionCS valueExpCS) {
		DictLiteralPartCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createDictLiteralPartCS();
		result.setKey(keyLiteralCS);
		result.setValue(valueExpCS);
		return result;
	}
	
	private final StatementCS createBreakCS() {
		StatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createBreakExpCS();
		return result;
	}
	
	private final StatementCS createContinueCS() {
		StatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createContinueExpCS();
		return result;
	}
	
	private ListLiteralExpCS createListLiteralExpCS(EList<CollectionLiteralPartCS> collectionLiteralParts) {
		ListLiteralExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createListLiteralExpCS();
		result.getCollectionLiteralParts().addAll(collectionLiteralParts);
		return result;
	}

	private boolean isTokenOfType(IToken token, int kind) {
		return (token != null) && (token.getKind() == kind);
	}
	
	private ImperativeOperationCallExpCS createFeatureFQNOperationCallExpCS(SimpleNameCS moduleName, SimpleNameCS operationName, EList<OCLExpressionCS> arguments) {
		ImperativeOperationCallExpCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createImperativeOperationCallExpCS();
		return setupImperativeOperationCallExpCS(moduleName, operationName,	arguments, result);
	}
	
	private OperationCallExpCS createDotOperationCallExpCS(OCLExpressionCS oclExpressionCS, PathNameCS pathNameCs, SimpleNameCS simpleNameCS, IsMarkedPreCS isMarkedPreCS,	EList<OCLExpressionCS> arguments) {
		if (pathNameCs != null && pathNameCs.getSimpleNames().size() == 1) {
			ImperativeOperationCallExpCS result = createFeatureFQNOperationCallExpCS(pathNameCs.getSimpleNames().get(0), simpleNameCS, arguments);
			if (oclExpressionCS != null) {
				result.setSource(oclExpressionCS);
				result.setIsAtomic(true);
			}
			result.setAccessor(oclExpressionCS != null ? DotOrArrowEnum.DOT_LITERAL : DotOrArrowEnum.NONE_LITERAL);
			if (isAtPre(isMarkedPreCS)) {
				result.setIsMarkedPreCS(isMarkedPreCS);
			}
			return result;
		}
		OperationCallExpCS result = createOperationCallExpCS(oclExpressionCS, DotOrArrowEnum.DOT_LITERAL, pathNameCs, simpleNameCS, isMarkedPreCS, arguments);
		if (oclExpressionCS != null) {
			result.setIsAtomic(true);
		}
		return result;
	}
	
	private ImperativeOperationCallExpCS setupImperativeOperationCallExpCS(SimpleNameCS moduleName, SimpleNameCS operationName, EList<OCLExpressionCS> arguments, ImperativeOperationCallExpCS result) {
		result.setModule(moduleName);
		result.setSimpleNameCS(operationName);
		result.getArguments().addAll(arguments);
		return result;
	}
	
	protected VariableCS createVariableCS(IToken token, TypeCS typeCS, OCLExpressionCS oclExpressionCS) {
		VariableCS result = CSTFactory.eINSTANCE.createVariableCS();
		result.setName(unSingleQuote(token));
		result.setTypeCS(typeCS);
		result.setInitExpression(oclExpressionCS);
		return result;
	}
./
%End