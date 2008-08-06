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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnv;
import org.eclipse.m2m.internal.qvt.oml.ast.env.QvtOperationalEnvFactory;
import org.eclipse.m2m.internal.qvt.oml.expressions.Helper;
import org.eclipse.m2m.qvt.oml.runtime.util.HelperOperationCall;
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

	private List<String> parameterNames;

	private List<EClassifier> parameterTypes;

	private String fileName;

	private HelperOperationCall helperCall;

	public QvtExtension(HelperOperationCall helperOperationCall, QvtFile qvtFile, String fileName) {
		this.helperCall = helperOperationCall;
		qvtResource = qvtFile;
		this.fileName = fileName;
	}

	public void setQvtResource(QvtResource resource) {
		qvtResource = resource;
	}

	public QvtResource getQvtResource() {
		return qvtResource;
	}

	public Object evaluate(Object[] parameters, ExecutionContext ctx) {
		try {
			if (helperCall.isContextual()) {
				// TODO: this is a proper way to get context variable (self) for
				// now
				// getting this variable from the parameters array in accordance
				// with OperationCall.evaluateInternal() implementation
				// Variable selfVariable =
				// ctx.getVariable(ExecutionContext.IMPLICIT_VARIABLE);
				assert parameters.length > 0;
				Object self = parameters[0];
				Object[] actualParameters = new Object[parameters.length - 1];
				System.arraycopy(parameters, 1, actualParameters, 0, parameters.length - 1);
				return helperCall.invoke(self, actualParameters);
			} else {
				return helperCall.invoke(parameters);
			}
		} catch (IllegalArgumentException e) {
			throw new RuntimeException("Illigal arguments in QVT helper (" + getSignature(helperCall.getOperation()) + ") call: " + e.getMessage());
		} catch (InvocationTargetException e) {
			throw new RuntimeException("Invocation target exception in QVT helper (" + getSignature(helperCall.getOperation()) + ") call: " + e.getMessage());
		}
	}

	private String getSignature(Helper operation) {
		StringBuilder sb = new StringBuilder();
		if (operation.getContext() != null) {
			sb.append(operation.getContext().getEType().getName());
			sb.append("::");
		}
		sb.append(operation.getName());
		sb.append("(");
		for (EParameter parameter : operation.getEParameters()) {
			if (sb.lastIndexOf("(") != sb.length() - 1) {
				sb.append(",");
			}
			sb.append(parameter.getName());
			sb.append(":");
			sb.append(parameter.getEType().getName());
		}
		sb.append(")");
		sb.append(":");
		sb.append(operation.getEType().getName());
		return sb.toString();
	}

	public String getName() {
		return getHelper().getName();
	}

	public List<EClassifier> getParameterTypes() {
		if (parameterTypes == null) {
			parameterTypes = new ArrayList<EClassifier>();
			// TODO: we should be able to distinguish between static and
			// context-specific queries
			if (getHelper().getContext() != null) {
				parameterTypes.add(getXpandType(getHelper().getContext().getEType()));
			}
			for (EParameter parameter : getHelper().getEParameters()) {
				parameterTypes.add(getXpandType(parameter.getEType()));
			}
			parameterTypes = Collections.unmodifiableList(parameterTypes);
		}
		return parameterTypes;
	}

	public List<String> getParameterNames() {
		if (parameterNames == null) {
			parameterNames = new ArrayList<String>();
			for (EParameter parameter : getHelper().getEParameters()) {
				parameterNames.add(parameter.getName());
			}
			parameterNames = Collections.unmodifiableList(parameterNames);
		}
		return parameterNames;
	}

	public EClassifier getReturnType(EClassifier[] parameters, ExecutionContext ctx, Set<AnalysationIssue> issues) {
		// TODO: deduce return type here? (need another visitor?)
		return getXpandType(getHelper().getEType());
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

	private Helper getHelper() {
		return helperCall.getOperation();
	}

}
