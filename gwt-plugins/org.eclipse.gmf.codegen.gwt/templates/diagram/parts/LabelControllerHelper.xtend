package diagram.parts

import org.eclipse.gmf.codegen.gmfgen.FigureViewmap
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap
import org.eclipse.gmf.codegen.gmfgen.Viewmap

class LabelControllerHelper {

	def dispatch isReadOnly(GenCommonBase it) { true }
	
	def dispatch isReadOnly(GenChildLabelNode it) { labelReadOnly }
	
	def dispatch isReadOnly(GenLabel it) { readOnly }
	
	def dispatch isElementIcon(GenCommonBase it) { false }
	
	def dispatch isElementIcon(GenChildLabelNode it) { labelElementIcon }
	
	def dispatch isElementIcon(GenLabel it) { elementIcon }
	
	def dispatch LabelModelFacet getLabelModelFacet(GenCommonBase it) { null }
	
	def dispatch LabelModelFacet getLabelModelFacet(GenLabel it) { modelFacet }
	
	def dispatch LabelModelFacet getLabelModelFacet(GenChildLabelNode it) { labelModelFacet }
	
	def dispatch getFigureQualifiedClassName(Viewmap it)  { 'org.eclipse.draw2d.IFigure' }
	
	def dispatch getFigureQualifiedClassName(FigureViewmap it) {
		if (figureQualifiedClassName == null) 
			"org.eclipse.draw2d.Label" 
		else figureQualifiedClassName
	}
	
	def dispatch getFigureQualifiedClassName(ParentAssignedViewmap it) {
		if (figureQualifiedClassName == null) 
			"org.eclipse.draw2d.Label" 
		else figureQualifiedClassName
	}
	
	def dispatch getFigureQualifiedClassName(InnerClassViewmap it) { className }
	
	def dispatch getLabelHostQualifiedClassName(GenLabel it) { null }
	
	def dispatch getLabelHostQualifiedClassName(GenNodeLabel it) { node.getEditPartQualifiedClassName }
	
	def dispatch getLabelHostQualifiedClassName(GenLinkLabel it) { link.getEditPartQualifiedClassName }

}
