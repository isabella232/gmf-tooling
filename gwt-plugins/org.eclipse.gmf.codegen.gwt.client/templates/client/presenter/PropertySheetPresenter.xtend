package client.presenter

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class PropertySheetPresenter extends PresenterTemplate {

	override protected getImports(GenEditorGenerator it) '''
		import java.util.ArrayList;
		import java.util.Date;
		import java.util.List;

		import org.eclipse.emf.ecore.EClassifier;
		import org.eclipse.emf.ecore.EDataType;
		import org.eclipse.emf.ecore.EObject;
		import org.eclipse.emf.ecore.EReference;
		import org.eclipse.emf.ecore.EStructuralFeature;
		import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
		import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
		import org.eclipse.gmf.runtime.gwt.edit.parts.BaseNodeEditPart;
		import org.eclipse.gmf.runtime.notation.Node;

		import org.eclipse.gmf.runtime.gwt.events.DeselectEditPartEvent;
		import org.eclipse.gmf.runtime.gwt.events.DeselectEditPartEvent.DeselectEditPartEventHandler;
		import org.eclipse.gmf.runtime.gwt.events.SelectEditPartEvent;
		import org.eclipse.gmf.runtime.gwt.events.SelectEditPartEvent.SelectEditPartEventHandler;

		import com.google.gwt.event.shared.HandlerManager;
		import com.google.gwt.user.client.ui.HasWidgets;
		import com.google.gwt.user.client.ui.Widget;
	'''

	override viewInterface(GenEditorGenerator it) '''
		«super.viewInterface(it)»
		
		public interface SectionView {

			void setContent(List<FeatureEditPresenter.View> items);

			Widget asWidget();

		}
	'''

	override viewInterfaceMethods(GenEditorGenerator it) '''
		void add(SectionView section);

		void clear();

		Widget asWidget();
	'''

	override ctorBody(GenEditorGenerator it) '''
		«super.ctorBody(it)»

		bind();
	'''
	
	override bindBody(GenEditorGenerator it) '''
		eventBus.addHandler(DeselectEditPartEvent.TYPE, new DeselectEditPartEventHandler() {
			@Override
			public void onDeselect(DeselectEditPartEvent event) {
				view.clear();
			}
		});
		eventBus.addHandler(SelectEditPartEvent.TYPE, new SelectEditPartEventHandler() {
			@Override
			public void onSelect(SelectEditPartEvent event) {
				BaseNodeEditPart part = event.part;
				Object model = part != null ? part.getModel() : null;

				if (model instanceof org.eclipse.gmf.runtime.notation.Node) {
					SectionView section = initializeSection(
							((org.eclipse.gmf.runtime.notation.View) model).getElement(), 
							new «baseViewPackage».PropertySheetSectionView());
					view.add(section);
				}
			}
		});
	'''
	
	override addMethods(GenEditorGenerator it) '''
		«initializeSection»

		«featurePresenterFactory»
	'''
	
	protected def initializeSection() '''
		private SectionView initializeSection(EObject selected, SectionView section) {
			List<IItemPropertyDescriptor> descriptors = clientFactory.getItemDelegator().getPropertyDescriptors(selected);
			List<FeatureEditPresenter> presenters = new ArrayList<FeatureEditPresenter>();
			List<FeatureEditPresenter.View> views = new ArrayList<FeatureEditPresenter.View>();
			FeaturePresenterFactory factory = new FeaturePresenterFactory();

			for (IItemPropertyDescriptor descriptor: descriptors) {
				FeatureEditPresenter presenter = factory.create(selected, descriptor);
				if (presenter != null) {
					presenters.add(presenter);
					views.add(presenter.getView());
				}
			}

			section.setContent(views);

			return section;
		}
	'''

	protected def featurePresenterFactory(GenEditorGenerator it) '''
		protected class FeaturePresenterFactory {
			private EObject data;
			private IItemPropertyDescriptor descriptor;
			private Object feature;

			public FeatureEditPresenter create(EObject data, IItemPropertyDescriptor descriptor) {
				this.data = data;
				this.descriptor = descriptor;
				this.feature = descriptor.getFeature(data);

				return createFeaturePresenter((EStructuralFeature) feature);
			}

			private FeatureEditPresenter createFeaturePresenter(EStructuralFeature eStructureFeature) {
				if (!eStructureFeature.isChangeable() || eStructureFeature.isDerived())
					return null;

				EClassifier eType = eStructureFeature.getEType();
				
				if (eStructureFeature instanceof EReference) {
					return createFeatureListPresenter();
				} else if (eType instanceof EDataType) {
					return createFeatureDataPresenter((EDataType) eType);
				} else {
					return new FeatureUniqueEditPresenter(clientFactory, data, descriptor, new «baseViewPackage».TextView());
				}
			}

			private FeatureEditPresenter createFeatureDataPresenter(EDataType type) {
				if (!type.isSerializable()) return null;

				if (descriptor.isMany(data)) {
					return new FeatureListEditPresenter(clientFactory, data, descriptor, new «baseViewPackage».SingleListView());
				}
				else {
					if (type.getInstanceClass() == Date.class) {
						return new FeatureUniqueEditPresenter(clientFactory, data, descriptor, new «baseViewPackage».DateView());
					} 
					else if (type.getInstanceClass() == Boolean.class || type.getInstanceClass() == boolean.class) {
						return new FeatureUniqueEditPresenter(clientFactory, data, descriptor, new «baseViewPackage».CheckBoxView());
					}
					else if (descriptor.isMultiLine(data)) {
						return new FeatureUniqueEditPresenter(clientFactory, data, descriptor, new «baseViewPackage».TextAreaView());
					}
					else {
						return new FeatureUniqueEditPresenter(clientFactory, data, descriptor, new «baseViewPackage».TextView());
					}
				}
			}

			private FeatureEditPresenter createFeatureListPresenter() {
				FeatureListEditPresenter.View view = descriptor.isMany(feature) ?
						new «baseViewPackage».MultipleListView() :
							new «baseViewPackage».SingleListView();

				return new FeatureListEditPresenter(clientFactory, data, descriptor, view);
			}
		}
	'''
	
}