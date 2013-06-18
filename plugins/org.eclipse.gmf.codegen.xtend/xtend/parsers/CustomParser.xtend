/**
 * Copyright (c) 2008, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - [244419] custom parsers
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package parsers

import com.google.inject.Inject
import xpt.Common
import xpt.Common_qvto

class CustomParser {
	@Inject extension Common;
	@Inject extension Common_qvto;

	def Main(org.eclipse.gmf.codegen.gmfgen.CustomParser it) '''
		«copyright(holder.editorGen)»
		package «withoutLastSegment(qualifiedName)»;
		
		«generatedClassComment»
		public class «lastSegment(qualifiedName)» «extendsList(it)» «implementsList(it)» {
			«body(it)»
			«additions(it)»
		}
	'''

	def additions(org.eclipse.gmf.codegen.gmfgen.CustomParser it) ''''''

	def extendsList(org.eclipse.gmf.codegen.gmfgen.CustomParser it) ''''''

	def implementsList(org.eclipse.gmf.codegen.gmfgen.CustomParser it) ''' implements org.eclipse.gmf.runtime.common.ui.services.parser.IParser'''

	/**
	 * As this is a borderblate class generator, there are no reasons to split it to per-method pieces.
	 */
	def body(org.eclipse.gmf.codegen.gmfgen.CustomParser it) '''
		«generatedMemberComment»
		public String getEditString(org.eclipse.core.runtime.IAdaptable element, int flags) {
			return "";
		}
		
		«generatedMemberComment»
		public org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus isValidEditString(org.eclipse.core.runtime.IAdaptable element, String editString) {
			// TODO change to EDITABLE_STATUS as appropriate
			return org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus.UNEDITABLE_STATUS;
		}
		
		«generatedMemberComment»
		public org.eclipse.gmf.runtime.common.core.command.ICommand getParseCommand(org.eclipse.core.runtime.IAdaptable element, String newString, int flags) {
			// TODO
			throw new UnsupportedOperationException(); 
		}
		
		«generatedMemberComment»
		public String getPrintString(org.eclipse.core.runtime.IAdaptable element, int flags) {
			return "";
		}
		
		«generatedMemberComment»
		public boolean isAffectingEvent(Object event, int flags) {
			return false;
		}
		
		«generatedMemberComment»
		public org.eclipse.jface.text.contentassist.IContentAssistProcessor getCompletionProcessor(org.eclipse.core.runtime.IAdaptable element) {
			return null;
		}
	'''

}
