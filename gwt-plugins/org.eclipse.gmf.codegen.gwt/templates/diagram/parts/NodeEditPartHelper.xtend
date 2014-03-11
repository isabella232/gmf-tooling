package diagram.parts

import org.eclipse.gmf.codegen.gmfgen.FigureViewmap
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap
import org.eclipse.gmf.codegen.gmfgen.Viewmap

class NodeEditPartHelper {

	def getInnerFixedLabels(GenNode it) {
		labels
			.filter(e | !(e instanceof GenExternalNodeLabel))
			.filter(e | (e as GenLabel).viewmap instanceof ParentAssignedViewmap)
	}
	
	def getPinnedCompartments(GenNode it) {
		compartments.filter(e | e.viewmap instanceof ParentAssignedViewmap)
	}
	
	def dispatch primaryShapeQualifiedClassName(Viewmap it) { null }
	
	def dispatch primaryShapeQualifiedClassName(FigureViewmap it) {
		if (figureQualifiedClassName == null) 
			'org.eclipse.draw2d.RectangleFigure'
		else figureQualifiedClassName
	}
	
	def dispatch primaryShapeQualifiedClassName(InnerClassViewmap it) { className }

}