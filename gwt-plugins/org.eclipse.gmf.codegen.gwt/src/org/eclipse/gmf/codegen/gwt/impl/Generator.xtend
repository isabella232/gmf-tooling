package org.eclipse.gmf.codegen.gwt.impl

import com.google.inject.Inject
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gwt.AbstractGenerator
import org.eclipse.jdt.core.IPackageFragmentRoot

class Generator extends AbstractGenerator {

	@Inject TemplateProvider templates

	def generate(GenEditorGenerator genEditor, IProject project, IPackageFragmentRoot fragmentRoot, IProgressMonitor monitor) {
		val genDiagram = genEditor.diagram

		monitor.setupMonitor
		sourceGenerator.setFragmentRoot(fragmentRoot)

		genEditor.generateFile(templates.moduleGenerator, fragmentRoot.path)

		genDiagram.generateClass(templates.visualId)
		genDiagram.palette.generateClass(templates.paletteFactory)
		genDiagram.generateClass(templates.editPartFactory)
		genDiagram.generateClass(templates.diagramEditPart)
		genDiagram.generateClass(templates.viewFactory)
		genDiagram.generateClass(templates.layoutEditPolicy)

		genDiagram.allNodes.forEach[generate(it)]
		genDiagram.links.forEach[generate(it)]
		genDiagram.compartments.forEach[
			generateClass(templates.compartmentEditPart)
			generateClass(templates.viewFactory)
			generateClass(templates.layoutEditPolicy)
		]
	}

    def protected generate(GenNode node) {
        switch node {
        	GenChildLabelNode: node.generateClass(templates.childNodeEditPart)
        	default: {
        		node.generateClass(templates.nodeEditPart)
        		node.generateClass(templates.graphicalNodeEditPolicy)
	        	node.labels.forEach[label | 
	        		label.generateClass(templates.nodeLabelEditPart)
	        		label.generateClass(templates.viewFactory)
	        	]
        	}
        }

		node.generateClass(templates.viewFactory)
        generateCommands(node)
		node.generateClass(templates.componentEditPolicy)
    }
	
	def protected generateCommands(GenNode node) {
		if (!node.domainMetaClass.abstract) {
			node.generateClass(templates.createNodeCommand)
		}
		node.generateClass(templates.addNodeCommand)
		node.generateClass(templates.cloneNodeCommand)
	}

    def protected generate(GenLink link) {
    	link.generateClass(templates.linkEditPart)
		link.generateClass(templates.graphicalNodeEditPolicy)
        if (link.labels.size > 0) {
        	link.generateClass(templates.connectionEndPointPolicy)
		}
		link.labels.forEach[label | 
			label.generateClass(templates.linkLabelEditPart)
			label.generateClass(templates.viewFactory)
		]
		link.generateClass(templates.viewFactory)
		link.generateClass(templates.componentEditPolicy)
		generateCommands(link)
	}

    def protected generateCommands(GenLink link) {
    	if (link.viewDirectionAlignedWithModel) {
    		link.generateClass(templates.createLinkStartCommand)
			link.generateClass(templates.createLinkCompleteCommmand)
			link.generateClass(templates.reconnectLinkSourceCommand)
			link.generateClass(templates.reconnectLinkTargetCommand)
    	}
    }

}