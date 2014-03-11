package client.view.properties

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.presenter.PropertySheetPresenter
import client.view.BinderView

class PropertySheetSectionView extends BinderView {

	@Inject PropertySheetPresenter presenter

	override protected implementDefinition(GenEditorGenerator it) '''«presenter.qualifiedClassName(it)».SectionView'''
	
	override getImports(GenEditorGenerator it) '''
		«super.getImports(it)»

		import «basePresenterPackage».FeatureEditPresenter;
		import «basePresenterPackage».PropertySheetPresenter;
		import com.google.gwt.uibinder.client.UiField;
		import com.google.gwt.user.client.ui.HTMLPanel;
	'''
	
	override attrs(GenEditorGenerator it) '''
		@UiField HTMLPanel layout;
	'''

	override addMethods(GenEditorGenerator it) '''
		@Override
		public void setContent(java.util.List<FeatureEditPresenter.View> items) {
			layout.clear();

			for (FeatureEditPresenter.View item: items) {
				layout.add(item.asWidget());
			}
		}
	'''
		
}