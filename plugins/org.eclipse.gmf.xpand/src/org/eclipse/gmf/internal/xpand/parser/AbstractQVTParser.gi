-- Copy of QVT CST factory methods from AbstractQVTParser
-- Only required (reused) methods were copied, hence private visibility to make sure we use all them
-- XXX ask QVT guys to split factory out of AbstractOCLParser.java 
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
    
    private NewRuleCallExpCS createNewRuleCallExpCS(PathNameCS pathNameCS, List<OCLExpressionCS> arguments) {
    	NewRuleCallExpCS call = org.eclipse.m2m.internal.qvt.oml.cst.CSTFactory.eINSTANCE.createNewRuleCallExpCS();
		call.setTypeSpecCS(createTypeSpecCS(pathNameCS, null)); //call.setScopedIdentifier(pathNameCS);
		call.getArguments().addAll(arguments);
    	return call;
    }

	// FIXME this method is only temp solution until we regenerate with new ImperativeOCL.g
	private final TypeSpecCS createTypeSpecCS(TypeCS typeCS, IToken extentLocation) {
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

	private boolean isTokenOfType(IToken token, int kind) {
		return (token != null) && (token.getKind() == kind);
	}
./
$End