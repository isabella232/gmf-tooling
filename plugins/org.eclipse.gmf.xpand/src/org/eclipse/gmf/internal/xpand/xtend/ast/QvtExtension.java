/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.xtend.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.Variable;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEvaluationEnv;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl;
import org.eclipse.m2m.internal.qvt.oml.evaluator.QvtOperationalEvaluationVisitorImpl.OperationCallResult;
import org.eclipse.m2m.internal.qvt.oml.expressions.ImperativeOperation;
import org.eclipse.m2m.internal.qvt.oml.library.Context;
import org.eclipse.ocl.ecore.BagType;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.OrderedSetType;
import org.eclipse.ocl.ecore.PrimitiveType;
import org.eclipse.ocl.ecore.SequenceType;
import org.eclipse.ocl.ecore.SetType;
import org.eclipse.ocl.ecore.util.EcoreSwitch;
import org.eclipse.ocl.types.OCLStandardLibrary;

public class QvtExtension implements GenericExtension {

	private static final QvtOperationalEnv qvtEnvironment = QvtOperationalEnvFactory.INSTANCE.createEnvironment(null);
	
	private static final EcoreSwitch<EClassifier> ecoreSwitch = new EcoreSwitch<EClassifier>() {
		
		@Override
		public EClassifier casePrimitiveType(PrimitiveType object) {
			OCLStandardLibrary<EClassifier> standardLibrary = qvtEnvironment.getOCLStandardLibrary();
			if (standardLibrary.getString() == object) {
				return EcorePackage.eINSTANCE.getEString();
			}
			if (standardLibrary.getBoolean() == object) {
				return EcorePackage.eINSTANCE.getEBoolean();
			}
			if (standardLibrary.getInteger() == object) {
				return EcorePackage.eINSTANCE.getEInt();
			}
			return null;
		}
		
		@Override
		public EClassifier caseCollectionType(CollectionType object) {
			return BuiltinMetaModel.getCollectionType(getXpandElementType(object));
		}
		
		@Override
		public EClassifier caseBagType(BagType object) {
			return BuiltinMetaModel.getCollectionType(getXpandElementType(object));
		}
		
		@Override
		public EClassifier caseSetType(SetType object) {
			return BuiltinMetaModel.getSetType(getXpandElementType(object));
		}
		
		@Override
		public EClassifier caseSequenceType(SequenceType object) {
			return BuiltinMetaModel.getListType(getXpandElementType(object));
		}
		
		@Override
		public EClassifier caseOrderedSetType(OrderedSetType object) {
			return BuiltinMetaModel.getSetType(getXpandElementType(object));
		}
		
		private EClassifier getXpandElementType(CollectionType collectionType) {
			EClassifier elementType = this.doSwitch(collectionType.getElementType());
			return elementType == null ? collectionType.getElementType() : elementType;
		}
	};

	private QvtResource qvtResource;

	private ImperativeOperation operation;

	private List<String> parameterNames;

	private List<EClassifier> parameterTypes;

	private String fileName;

	public QvtExtension(ImperativeOperation operation, QvtFile qvtFile, String fileName) {
		qvtResource = qvtFile;
		this.operation = operation;
		this.fileName = fileName;
	}

	public void setQvtResource(QvtResource resource) {
		qvtResource = resource;
	}

	public QvtResource getQvtResource() {
		return qvtResource;
	}

	public Object evaluate(Object[] parameters, ExecutionContext ctx) {
		Context context = new Context();
		QvtOperationalEvaluationEnv evaluationEnv = QvtOperationalEnvFactory.INSTANCE.createEvaluationEnvironment(context, null);
		// evaluationEnv.setOperationSelf("Hahaha");
		// evaluationEnv.getOperationArgs().addAll();

		// EvaluationVisitor<EPackage, EClassifier, EOperation,
		// EStructuralFeature, EEnumLiteral, EParameter, EObject,
		// CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
		// evaluator = factory.createEvaluationVisitor(rootEnv, evaluationEnv,
		// null);
		QvtOperationalEvaluationVisitorImpl evaluator = new QvtOperationalEvaluationVisitorImpl(qvtEnvironment, evaluationEnv);

		// assert library.getEntry() == null;
		// library.setEntry(library.getEOperations().get(0));
		Variable selfVariable = ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
		// TODO: remove first parameter if necessary..
		List<Object> parametersVariable = Arrays.asList(parameters);
		// TODO: (?) surround with try-catch block to catch *RuntimeExceptions from QVT execution.
		// TODO: check if parametersVariable are passed correctly (values used)
		OperationCallResult result = evaluator.executeImperativeOperation(operation, selfVariable.getValue(), parametersVariable, false);
		return result == null ? null : result.myResult;
	}

	public String getName() {
		return operation.getName();
	}

	public List<EClassifier> getParameterTypes() {
		if (parameterTypes == null) {
			parameterTypes = new ArrayList<EClassifier>();
			// TODO: we should be able to distinguish between static and
			// context-specific queries
			if (operation.getContext() != null) {
				parameterTypes.add(getXpandType(operation.getContext().getEType()));
			}
			for (EParameter parameter : operation.getEParameters()) {
				parameterTypes.add(getXpandType(parameter.getEType()));
			}
			parameterTypes = Collections.unmodifiableList(parameterTypes);
		}
		return parameterTypes;
	}

	public List<String> getParameterNames() {
		if (parameterNames == null) {
			parameterNames = new ArrayList<String>();
			for (EParameter parameter : operation.getEParameters()) {
				parameterNames.add(parameter.getName());
			}
			parameterNames = Collections.unmodifiableList(parameterNames);
		}
		return parameterNames;
	}

	public EClassifier getReturnType(EClassifier[] parameters, ExecutionContext ctx, Set<AnalysationIssue> issues) {
		// TODO: deduce return type here? (need another visitor?)
		return getXpandType(operation.getEType());
	}

	private EClassifier getXpandType(EClassifier type) {
		EClassifier result = ecoreSwitch.doSwitch(type);
		return result == null ? type : result;
	}

	public void init(ExecutionContext ctx) {
		// TODO nothing to do here? Call QVT to preparse AST?..
	}

	public String getFileName() {
		return fileName;
	}

}
