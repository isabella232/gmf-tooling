/**
 * Copyright (c) 2007, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #372479, #386838
 */
package xpt.editor

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef
import xpt.Common

class ValidationMarker {
	@Inject extension Common;

	@MetaDef def className(GenDiagram it) '''ValidationMarker'''

	def packageName(GenDiagram it) '''«it.editorGen.editor.packageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''

	def ValidationMarker(GenDiagram it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» {
		
			«generatedMemberComment»
			private static final String KEY = "validation_marker"; //$NON-NLS-1$
		
			«generatedMemberComment»
			public static final «className(it)»[] EMPTY_ARRAY = new «className(it)»[0];
		
			«generatedMemberComment»
			private final String location;
		
			«generatedMemberComment»
			private final String message;
		
			«generatedMemberComment»
			private final int statusSeverity;
		
			«generatedMemberComment»
			public «className(it)»(String location, String message, int statusSeverity) {
				this.location = location;
				this.message = message;
				this.statusSeverity = statusSeverity;
			}
		
			«generatedMemberComment»
			public String getLocation() {
				return location;
			}
		
			«generatedMemberComment»
			public String getMessage() {
				return message;
			}
		
			«generatedMemberComment»
			public int getStatusSeverity() {
				return statusSeverity;	
			}
		
			«generatedMemberComment»
			private static java.util.Map getMarkers(org.eclipse.gef.EditPartViewer viewer) {
				java.util.Map markers = (java.util.Map) viewer.getProperty(KEY);
				if (markers == null) {
					markers = new java.util.HashMap();
					viewer.setProperty(KEY, markers);
				}
				return markers;
			}
		
			«generatedMemberComment»
			private static java.util.Set getMarkers(org.eclipse.gef.EditPartViewer viewer, String viewId, boolean create) {
				java.util.Set markers = (java.util.Set) getMarkers(viewer).get(viewId);
				if (markers == null) {
					if (!create) {
						return java.util.Collections.EMPTY_SET;
					}
					markers = new java.util.HashSet();
					getMarkers(viewer).put(viewId, markers);
				}
				return markers;
			}
		
			«generatedMemberComment»
			public static «className(it)»[] getMarkers(org.eclipse.gef.EditPartViewer viewer, String viewId) {
				java.util.Set markers = getMarkers(viewer, viewId, false);
				if (markers.isEmpty()) {
					return EMPTY_ARRAY;
				}
				return («className(it)»[]) markers.toArray(new «className(it)»[markers.size()]);
			}
		
			«generatedMemberComment»
			public static void removeAllMarkers(org.eclipse.gef.EditPartViewer viewer) {
				getMarkers(viewer).clear();
			}
		
			«generatedMemberComment»
			public void add(org.eclipse.gef.EditPartViewer viewer, String viewId) {
				getMarkers(viewer, viewId, true).add(this);
			}
			«additions(it)»
		}
	'''

	def additions(GenDiagram it) ''''''

}
