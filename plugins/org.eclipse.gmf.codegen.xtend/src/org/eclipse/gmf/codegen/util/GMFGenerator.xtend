package org.eclipse.gmf.codegen.util

import com.google.inject.Inject
import java.util.Collections
import org.eclipse.core.runtime.Path
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.common.UnexpectedBehaviourException
import org.eclipse.gmf.internal.common.codegen.GeneratorBase
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import diagram.editparts.NodeEditPart

class GMFGenGenerator extends GeneratorBase implements IGenerator {

	private IFileSystemAccess fileSystemAccess
	private GenEditorGenerator genEditor

	@Inject private NodeEditPart nodeEditPartGen;

	override doGenerate(Resource resource, IFileSystemAccess fsa) {
		fileSystemAccess = fsa
		if (!resource.contents.empty && resource.contents.get(0) instanceof GenEditorGenerator) {
			genEditor = resource.contents.get(0) as GenEditorGenerator
			customRun
		}
	}

	override protected customRun() throws InterruptedException, UnexpectedBehaviourException {
		if(genEditor == null) return

		val pluginDirectory = new Path(genEditor.pluginDirectory)
		initializeEditorProject(pluginDirectory, guessProjectLocation(genEditor), Collections::emptyList)
		(fileSystemAccess as MergeFileSystemAccess).setOutputPath(pluginDirectory.toString);

		genEditor.diagram.topLevelNodes.forEach[generateEditPart(it)]

	}

	def private generateEditPart(GenNode genNode) {
		val qualifiedName = genNode.editPartQualifiedClassName;
		val fileName = qualifiedName.replaceAll("\\.", "/").concat(".java")
		fileSystemAccess.generateFile(fileName, nodeEditPartGen.Main(genNode))
	}

	def private guessProjectLocation(GenEditorGenerator genEditor) {
		val path = new Path(genEditor.pluginDirectory)
		val projectName = path.segment(0)
		val modelProjectPath = new Path(genEditor.domainGenModel?.modelDirectory)

		guessNewProjectLocation(modelProjectPath, projectName)
	}

	override protected setupProgressMonitor() {
		val c = new _Counter2()
		c.registerFactor(GMFGenPackage::eINSTANCE.genNode, 7)
		c.registerFactor(GMFGenPackage::eINSTANCE.genChildLabelNode, 5)
		c.registerFactor(GMFGenPackage::eINSTANCE.genLink, 6)
		c.registerFactor(GMFGenPackage::eINSTANCE.genLinkLabel, 2)
		c.registerFactor(GMFGenPackage::eINSTANCE.genCompartment, 3)
		c.registerFactor(GMFGenPackage::eINSTANCE.genDiagram, 30)
		c.registerFactor(GMFGenPackage::eINSTANCE.genEditorGenerator, 2) // i18n=2
		c.registerFactor(GMFGenPackage::eINSTANCE.genPlugin, 6)
		c.registerFactor(GMFGenPackage::eINSTANCE.genNavigator, 3)
		c.registerFactor(GMFGenPackage::eINSTANCE.genNavigatorChildReference, 1)
		c.registerFactor(GMFGenPackage::eINSTANCE.genCustomPropertyTab, 1)
		c.registerFactor(GMFGenPackage::eINSTANCE.behaviour, 1)
		c.registerFactor(GMFGenPackage::eINSTANCE.genMetricContainer, 1)
		c.registerFactor(GMFGenPackage::eINSTANCE.genExpressionProviderContainer, 1)
		c.registerFactor(GMFGenPackage::eINSTANCE.palette, 1)
		setupProgressMonitor(null, c.getTotal(genEditor))
	}

}
