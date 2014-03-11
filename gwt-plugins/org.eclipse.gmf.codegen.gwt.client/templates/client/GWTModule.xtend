package client

import common.BaseFileTemplate
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class GWTModule extends BaseFileTemplate<GenEditorGenerator> {

	extension QualifiedNamesHelper = new QualifiedNamesHelper

	override filePath(GenEditorGenerator it) {
		baseModulePackage.toString.replaceAll("\\.", "/") + "/" + modelID + "App.gwt.xml"
	}

	override generate(GenEditorGenerator it) '''
		<?xml version="1.0" encoding="UTF-8"?>
		<module>
			<!-- GWT modules -->
			<inherits name="com.google.gwt.user.User" />
			<!-- 	<inherits name="com.google.gwt.activity.Activity" /> -->
			<!-- 	<inherits name="com.google.gwt.place.Place" /> -->

			<inherits name="org.eclipselabs.emfjson.gwt.EMFJs" />

			«FOR p: domainGenModel.genPackages»
			<inherits name="«p.basePackage».«p.NSName».«p.prefix»" />
			<inherits name="«p.basePackage».«p.NSName».«p.prefix»Edit" />
			«ENDFOR»
			<inherits name="«packageNamePrefix».«modelID»" />

			<entry-point class='«baseClientPackage».AppEntryPoint'/>

			<replace-with class="«baseClientPackage».AppClientFactory">
				<when-type-is class="org.eclipse.gmf.runtime.gwt.client.ClientFactory" />
			</replace-with>

			<source path="client"/>

			<!--
			<add-linker name="xsiframe"/>
			<set-configuration-property name="devModeRedirectEnabled" value="true"/>
			<set-property name="compiler.useSourceMaps" value="true" />
			-->
		</module>
	'''

}