package client.view.properties

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.presenter.PropertySheetPresenter
import client.view.BinderView

class PropertySheetView extends BinderView {

	@Inject PropertySheetPresenter presenter

	override protected implementDefinition(GenEditorGenerator it) '''«presenter.qualifiedClassName(it)».View'''

	override getImports(GenEditorGenerator it) '''
		«super.getImports(it)»

		import com.google.gwt.uibinder.client.UiField;
		import com.google.gwt.user.client.ui.HTMLPanel;

		import «basePresenterPackage».PropertySheetPresenter;
		import «basePresenterPackage».PropertySheetPresenter.SectionView;
	'''

	override attrs(GenEditorGenerator it) '''
		@UiField HTMLPanel panel;
	'''

	override addMethods(GenEditorGenerator it) '''
		@Override
		public void add(SectionView section) {
			panel.add(section.asWidget());
		}

		@Override
		public void clear() {
			panel.clear();
		}
	'''
	
}