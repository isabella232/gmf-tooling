-- Copy of QVT CST factory methods from AbstractQVTParser
-- Only required (reused) methods were copied, hence private visibility to make sure we use all them
-- XXX ask QVT guys to split factory out of AbstractOCLParser.java 
$Globals
	/.
	import org.eclipse.m2m.internal.qvt.oml.cst.CompleteSignatureCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.LibraryImportCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ExpressionStatementCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.TransformationHeaderCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ModuleUsageCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.TransformationRefineCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.RenameCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.ListTypeCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DictionaryTypeCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.DictLiteralPartCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.VariableInitializationCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.InstantiationExpCS;
	import org.eclipse.m2m.internal.qvt.oml.cst.StatementCS;
	./
$End

$Headers
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
	
	private final ScopedNameCS createScopedNameCS(TypeCS typeCS, String name) {
		ScopedNameCS result = TempFactory.eINSTANCE.createScopedNameCS();
		result.setTypeCS(typeCS);
		result.setName(name);
		if(typeCS != null) {
			result.setStartOffset(typeCS.getStartOffset());
			result.setEndOffset(typeCS.getEndOffset());
			if(name != null) {
				result.setEndOffset(result.getEndOffset() + name.length());
			}
		}
		return result;
	}
	
	private final CSTNode createExpressionStatementCS(OCLExpressionCS sym) {
		ExpressionStatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createExpressionStatementCS();
		result.setOclExpressionCS(sym);
		return result;
	}
	
	private final TransformationHeaderCS createTransformationHeaderCS(EList<StringLiteralExpCS> qualifiers, 
			PathNameCS pathNameCS, SimpleSignatureCS simpleSignatureCS, EList<ModuleUsageCS> transfUsages, 
			TransformationRefineCS transfRefineCS) {
				TransformationHeaderCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createTransformationHeaderCS();
				result.getQualifiers().addAll(qualifiers);
				result.getParameters().addAll(simpleSignatureCS.getParams());
				result.getModuleUsages().addAll(transfUsages);
				result.setTransformationRefineCS(transfRefineCS);
				result.setPathNameCS(pathNameCS);
				return result;
	}
	
	private final CSTNode createRenameCS(TypeCS sym, IToken tokenText, StringLiteralExpCS sym2) {
		RenameCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createRenameCS();
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, tokenText.toString());
		setOffsets(nameCS, tokenText);
		result.setSimpleNameCS(nameCS);
		result.setTypeCS(sym);
		result.setOriginalName(sym2);
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
	
	private final CSTNode createVariableInitializationCS(IToken identifier, TypeCS typeCS, OCLExpressionCS initExpressionCS, boolean withResult) {
		VariableInitializationCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createVariableInitializationCS();
		SimpleNameCS nameCS = createSimpleNameCS(SimpleTypeEnum.IDENTIFIER_LITERAL, identifier.toString());
		setOffsets(nameCS, identifier);
		result.setSimpleNameCS(nameCS);
		result.setTypeCS(typeCS);
		result.setOclExpressionCS(initExpressionCS);
		result.setWithResult(withResult);
		return result;
	}
	
	private InstantiationExpCS createNewRuleCallExpCS(TypeSpecCS typeSpecCS, List<OCLExpressionCS> arguments) {
		InstantiationExpCS call = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createInstantiationExpCS();
		call.setTypeSpecCS(typeSpecCS);
		call.getArguments().addAll(arguments);
		return call;
	}
	
	private final StatementCS createBreakCS() {
		StatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createBreakExpCS();
		return result;
	}
	
	private final StatementCS createContinueCS() {
		StatementCS result = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createContinueExpCS();
		return result;
	}

	private final int getEndOffset(int ensuredOffset, EList<? extends CSTNode>... listOpt) {
	    int offset = ensuredOffset;
	    for (EList<? extends CSTNode> list : listOpt) {
	        if (list.size() == 0) {
	            continue;
	        }
	        CSTNode node = list.get(list.size()-1);
	        offset = node.getEndOffset();
	    }
	    return offset;
	}

	private boolean isTokenOfType(IToken token, int kind) {
		return (token != null) && (token.getKind() == kind);
	}
./
$End