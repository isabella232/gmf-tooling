package org.eclipse.gmf.codegen.gwt.client

import client.icons.Icons
import client.view.Ui
import com.google.inject.Inject
import common.BaseClassTemplate
import java.io.InputStream
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gwt.AbstractGenerator
import org.eclipse.jdt.core.IPackageFragmentRoot
import client.QualifiedNamesHelper

class ClientGenerator extends AbstractGenerator {

	@Inject TemplateProvider templates

	extension QualifiedNamesHelper = new QualifiedNamesHelper 

	def generate(GenEditorGenerator genEditor,
		IProject project,
		IPackageFragmentRoot fragmentRoot,
		IProgressMonitor monitor
	) {
		setupMonitor(monitor)
		sourceGenerator.setFragmentRoot(fragmentRoot)

		val rootSourcePath = fragmentRoot.path

		genEditor.generateFile(templates.gwtModule, rootSourcePath)

		genEditor.generateClass(templates.clientFactory)
		genEditor.generateClass(templates.entryPoint)
		genEditor.generateClass(templates.icons)
		genEditor.generateClasses(events)
		genEditor.generateClasses(presenters)
		genEditor.generateClasses(views)

		genEditor.generateUis(viewUis, rootSourcePath)
		icons.forEach[icon |
			copyFile(Icons.getResourceAsStream(icon), rootSourcePath + "/" + genEditor.iconsPath + icon)
		]
	}

	protected def events() { 
		#{
			templates.showPaneEvent,
			templates.openDiagramEvent
		}
	}

	protected def presenters() {
		#{
			templates.presenter,
			templates.appController,
			templates.diagramPresenter,
			templates.propertySheetPresenter,
			templates.featureEditPresenter,
			templates.featureUniqueEditPresenter,
			templates.featureListEditPresenter
		}
	}

	protected def views() {
		#{
			templates.appView,
			templates.diagramView,
			templates.menuView,
			templates.paletteView,
			templates.propertySheetView,
			templates.propertySheetSectionView,
			templates.sidePaneView,
			templates.checkBoxView,
			templates.dateView,
			templates.multipleListView,
			templates.singleListView,
			templates.textAreaView,
			templates.textView
		}
	}

	protected def viewUis() {
		#{
			templates.appViewUi,
			templates.sidePaneViewUi,
			templates.diagramViewUi,
			templates.menuViewUi,
			templates.paletteViewUi,
			templates.propertySheetSectionViewUi,
			templates.propertySheetViewUi,
			templates.checkBoxViewUi,
			templates.dateViewUi,
			templates.multipleListViewUi,
			templates.singleListViewUi,
			templates.textAreaViewUi,
			templates.textViewUi
		}
	}

	protected def generateUis(GenEditorGenerator genEditor, Iterable<? extends Ui> templates, IPath basePath) {
		templates.forEach[template |
			genEditor.generateFile(template, basePath)
		]
	} 

	protected def generateClasses(GenEditorGenerator genEditor, Iterable<? extends BaseClassTemplate<GenEditorGenerator>> templates) {
		templates.forEach[template | 
			genEditor.generateClass(template)
		]
	}

	val icons = #{
		"delete.png",
		"file_obj.png",
		"filenav_nav.png",
		"palette_view.gif",
		"prop_ps.png",
		"redo_edit.png",
		"undo_edit.png",
		"zoom_in.gif",
		"zoom_out.gif"
	}

	protected def iconsPath(GenEditorGenerator it) { baseIconsPackage.toString.replaceAll("\\.", "/") + "/" }

	protected def copyFile(InputStream contents, String targetFile) {
		if (contents != null) {
			fileGenerator.generateFile(contents, targetFile, nextMonitor)
			contents.close()
		}
	}

}