package edithelpers

import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode
import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.ElementType

class plugin {
	@Inject edithelper helper;
	
def main(GenDiagram it)'''
<?xml version="1.0" encoding="UTF-8"?>
<?eclipse version="3.0"?>
<plugin>
	<extension point="org.eclipse.gmf.runtime.emf.type.core.elementTypes">
«FOR f : topLevelNodes.filter(n | n.elementType != null)»«registerHelperAdvice(f)»«ENDFOR»
	</extension>
	<extension point="org.eclipse.gmf.runtime.emf.type.core.elementTypeBindings">
		<binding context="«editorGen.plugin.ID».TypeContext">
«FOR f : topLevelNodes.filter(n | n.elementType != null)»«registerHelperAdvice(f)»«registerHelperAdviceBinding(f)»«ENDFOR»
		</binding>
	</extension>
</plugin>
'''

def registerHelperAdvice(GenTopLevelNode it) '''
		<metamodel nsURI="«modelFacet.metaClass.genPackage.ecorePackage.nsURI»">
			<adviceBinding
				class="«helper.className(elementType)»"
				id="«id(elementType)»"
				inheritance="none"
				typeId="«elementType.uniqueIdentifier»"/>
		</metamodel>
'''

def id(ElementType it)'''«uniqueIdentifier»_ExternalAdvice'''

def registerHelperAdviceBinding(GenTopLevelNode it)'''
			<advice ref="«id(elementType)»"/>
'''
}