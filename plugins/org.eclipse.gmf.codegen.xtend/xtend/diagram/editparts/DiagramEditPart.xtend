/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package diagram.editparts

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import xpt.Common
import xpt.Common_qvto

class DiagramEditPart {
	@Inject extension Common;
	@Inject extension Common_qvto;

	@Inject impl.diagram.editparts.DiagramEditPart xptDiagramEditPart;
	@Inject impl.diagram.editparts.NodeLabelEditPart xptNodeLabelEditPart;
	@Inject impl.diagram.editparts.LinkLabelEditPart xptLinkLabelEditPart;
	@Inject xpt.diagram.editparts.Common xptEditpartsCommon;

	def Main(GenDiagram it) '''
«copyright(editorGen)»
package «editPartsPackageName»;

«generatedClassComment»
public class «editPartClassName» «extendsList(it)» «implementsList(it)» {

	«attributes(it)»
	
	«xptDiagramEditPart.constructor(it)»
	
	«createDefaultEditPolicies(it)»
	
	«xptDiagramEditPart.createFigure(it)»
«IF getAllNodes().exists[n|n.labels.exists[l|!l.oclIsKindOf(typeof(GenExternalNodeLabel))]]/*iow, NodeLabelEditPart template (GenNodeLabel target) will require this EditPolicy*/»
	«xptNodeLabelEditPart.nodeLabelDragPolicyClass(it)»
«ENDIF»

«IF links.exists[l|l.labels.notEmpty()]»
	«xptLinkLabelEditPart.linkLabelDragPolicyClass(it)»
«ENDIF»

	«additions(it)»
}
'''

	def extendsList(GenDiagram it) '''extends org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart'''

	def implementsList(GenDiagram it) ''''''

	def attributes(GenDiagram it) '''
		«generatedMemberComment»
		public final static String MODEL_ID = "«editorGen.modelID»"; «nonNLS(1)»
		
		«xptEditpartsCommon.visualIDConstant(it)»
	'''

	def createDefaultEditPolicies(GenDiagram it) '''
		«generatedMemberComment»
		protected void createDefaultEditPolicies() {
			«xptDiagramEditPart.createDefaultEditPoliciesBody(it)»
		}
	'''

	def additions(GenDiagram it) ''''''
}
