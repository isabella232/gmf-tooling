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
package org.eclipse.gmf.internal.xpand.migration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;

public class StandardLibraryImports extends AbstractImportsManager {

	private static final String STRING_LIBRARY_NAME = "XpandStringOperations";

	private static final Map<EOperation, String> operationNames;

	static {
		operationNames = new HashMap<EOperation, String>();
		operationNames.put(BuiltinMetaModel.EString_ToFirstUpper, "firstToUpper");
		operationNames.put(BuiltinMetaModel.EString_ToFirstLower, "xpandToFirstLower");
		operationNames.put(BuiltinMetaModel.EString_SubString_StartEnd, "substring");
		operationNames.put(BuiltinMetaModel.EString_SubString, "xpandSubstring");
		operationNames.put(BuiltinMetaModel.EString_ToUpperCase, "toUpper");
		operationNames.put(BuiltinMetaModel.EString_ToLowerCase, "toLower");
		operationNames.put(BuiltinMetaModel.EString_ReplaceFirst, "xpandReplaceFirst");
		operationNames.put(BuiltinMetaModel.EString_ToCharList, "xpandToCharList");
		operationNames.put(BuiltinMetaModel.EString_ReplaceAll, "xpandReplaceAll");
		operationNames.put(BuiltinMetaModel.EString_Split, "xpandSplit");
		operationNames.put(BuiltinMetaModel.EString_Matches, "xpandMatches");
	}

	private static final Set<EOperation> stringLibOperations;

	static {
		stringLibOperations = new HashSet<EOperation>();
		stringLibOperations.add(BuiltinMetaModel.EString_ToFirstLower);
		stringLibOperations.add(BuiltinMetaModel.EString_SubString);
		stringLibOperations.add(BuiltinMetaModel.EString_ReplaceFirst);
		stringLibOperations.add(BuiltinMetaModel.EString_ToCharList);
		stringLibOperations.add(BuiltinMetaModel.EString_ReplaceAll);
		stringLibOperations.add(BuiltinMetaModel.EString_Split);
		stringLibOperations.add(BuiltinMetaModel.EString_Matches);
	}

	private Set<String> usedLibraries = new LinkedHashSet<String>();

	StandardLibraryImports(StringBuilder stringBuilder) {
		super(stringBuilder);
	}

	void injectImports() {
		for (String usedLibrary : usedLibraries) {
			writeln("import library " + usedLibrary + ";");
		}
	}

	public String getOperationName(EOperation eOperation) {
		if (stringLibOperations.contains(eOperation)) {
			usedLibraries.add(STRING_LIBRARY_NAME);
		}
		return operationNames.containsKey(eOperation) ? operationNames.get(eOperation) : eOperation.getName();
	}
}
