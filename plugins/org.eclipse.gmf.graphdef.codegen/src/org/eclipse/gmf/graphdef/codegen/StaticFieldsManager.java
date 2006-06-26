/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.gmf.graphdef.codegen;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StaticFieldsManager {
	private final Map/*<String, StaticField>*/ myFields = new HashMap/*<String, StaticField>*/();
	private final Map/*<String, StaticField>*/ myFieldsRO = Collections.unmodifiableMap(myFields);
	private final String myDeclaringClassPrefix;

	public StaticFieldsManager(String declaringClassName){
		myDeclaringClassPrefix = (declaringClassName == null || declaringClassName.length() == 0) ? 
				"" : declaringClassName + ".";
	}
	
	public StaticFieldsManager(){
		this(null);
	}
	
	public String addStaticField(String type, String nameHint, String value) {
		int suffix = 0;
		String actualName;
		do {
			actualName = nameHint + ((suffix == 0) ? "" : "_" + suffix);
			suffix++;
		} while (myFields.containsKey(actualName));
		StaticField field = new StaticField(type, actualName, value);
		myFields.put(actualName, field);
		return myDeclaringClassPrefix + actualName;
	}
	
	public void reset() {
		myFields.clear();
	}

	public Iterator allFields() {
		return myFieldsRO.values().iterator();
	}
	
	public static class StaticField {
		private final String myType;
		private final String myName;
		private final String myValue;

		public StaticField(String type, String name, String value){
			myType = type;
			myName = name;
			myValue = value;
		}
		
		public String getName() {
			return myName;
		}
		
		public String getType() {
			return myType;
		}
		
		public String getValue() {
			return myValue;
		}
	}
}
