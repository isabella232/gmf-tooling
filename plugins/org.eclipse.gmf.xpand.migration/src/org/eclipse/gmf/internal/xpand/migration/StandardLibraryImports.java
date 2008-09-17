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
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;

public class StandardLibraryImports extends AbstractImportsManager {

	private static final Map<EOperation, MapEntry> operationsMap;

	static {
		operationsMap = new HashMap<EOperation, MapEntry>();

		operationsMap.put(BuiltinMetaModel.EString_ToFirstUpper, MapEntry.newEntry("firstToUpper"));
		operationsMap.put(BuiltinMetaModel.EString_ToFirstLower, MapEntry.newStringLibEntry("xpandToFirstLower"));
		operationsMap.put(BuiltinMetaModel.EString_SubString_StartEnd, MapEntry.newEntry("substring"));
		operationsMap.put(BuiltinMetaModel.EString_SubString, MapEntry.newStringLibEntry("xpandSubstring"));
		operationsMap.put(BuiltinMetaModel.EString_ToUpperCase, MapEntry.newEntry("toUpper"));
		operationsMap.put(BuiltinMetaModel.EString_ToLowerCase, MapEntry.newEntry("toLower"));
		operationsMap.put(BuiltinMetaModel.EString_ReplaceFirst, MapEntry.newStringLibEntry("xpandReplaceFirst"));
		operationsMap.put(BuiltinMetaModel.EString_ToCharList, MapEntry.newStringLibEntry("xpandToCharList"));
		operationsMap.put(BuiltinMetaModel.EString_ReplaceAll, MapEntry.newStringLibEntry("xpandReplaceAll"));
		operationsMap.put(BuiltinMetaModel.EString_Split, MapEntry.newStringLibEntry("xpandSplit"));
		operationsMap.put(BuiltinMetaModel.EString_Matches, MapEntry.newStringLibEntry("xpandMatches"));
		operationsMap.put(BuiltinMetaModel.Object_CompareTo, MapEntry.newOclAnyLibEntry("xpandCompareTo"));
		operationsMap.put(BuiltinMetaModel.Object_ToString, MapEntry.newEntry("repr"));
		operationsMap.put(BuiltinMetaModel.Int_Div_Int, MapEntry.newEntry("div"));
		operationsMap.put(BuiltinMetaModel.Int_UpTo, MapEntry.newIntegerLibEntry("xpandUpTo"));
	}

	private Set<String> usedLibraries = new LinkedHashSet<String>();

	StandardLibraryImports(StringBuilder stringBuilder) {
		super(stringBuilder);
	}

	StandardLibraryImports(int placeholder) {
		super(placeholder);
	}

	String[] getLibraries() {
		return usedLibraries.toArray(new String[usedLibraries.size()]);
	}

	String getOperationName(EOperation eOperation) {
		if (operationsMap.containsKey(eOperation)) {
			MapEntry entry = operationsMap.get(eOperation);
			if (entry.isLibraryOperation()) {
				usedLibraries.add(entry.getLibraryName());
			}
			return entry.getQvtOperationName();
		}
		return null;
	}

	private static class MapEntry {

		private static final String STRING_LIBRARY_NAME = "XpandStringOperations";

		private static final String OCLANY_LIBRARY_NAME = "XpandOclAnyOperations";

		private static final String INTEGER_LIBRARY_NAME = "XpandIntegerOperations";

		private String qvtOperationName;

		private String libraryName;

		public static MapEntry newEntry(String qvtOperationName) {
			return new MapEntry(qvtOperationName);
		}

		public static MapEntry newStringLibEntry(String qvtOperationName) {
			return new MapEntry(qvtOperationName, STRING_LIBRARY_NAME);
		}

		public static MapEntry newOclAnyLibEntry(String qvtOperationName) {
			return new MapEntry(qvtOperationName, OCLANY_LIBRARY_NAME);
		}

		public static MapEntry newIntegerLibEntry(String qvtOperationName) {
			return new MapEntry(qvtOperationName, INTEGER_LIBRARY_NAME);
		}

		private MapEntry(String qvtOperationName) {
			this.qvtOperationName = qvtOperationName;
		}

		private MapEntry(String qvtOperationName, String libraryName) {
			this(qvtOperationName);
			this.libraryName = libraryName;
		}

		public String getQvtOperationName() {
			return qvtOperationName;
		}

		public boolean isLibraryOperation() {
			return libraryName != null;
		}

		public String getLibraryName() {
			return libraryName;
		}

	}

}
