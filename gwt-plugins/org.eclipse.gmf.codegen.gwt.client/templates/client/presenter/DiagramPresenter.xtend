package client.presenter

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class DiagramPresenter extends PresenterTemplate {

	override viewInterfaceMethods(GenEditorGenerator it) '''
		«generatedMemberComment»
		void setGraphicalViewer(org.eclipse.gef.GraphicalViewer viewer);

		«generatedMemberComment»
		com.google.gwt.user.client.ui.Widget asWidget();
	'''

	override attrs(GenEditorGenerator it) '''
		«generatedMemberComment»
		private final org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory;

		«generatedMemberComment»
		private final View view;

		«generatedMemberComment»
		private final org.eclipse.emf.ecore.resource.Resource diagram;

		«generatedMemberComment»
		private final org.eclipse.gef.GraphicalViewer viewer;
	'''

	override ctorParams() '''«super.ctorParams», org.eclipse.emf.ecore.resource.Resource diagram'''

	override ctorBody(GenEditorGenerator it) '''
		this.clientFactory = clientFactory;
		this.view = view;
		this.diagram = diagram;
		this.viewer = createGraphicalViewer(clientFactory.getEditDomain());

		view.setGraphicalViewer(viewer);

		bind();
	'''

	override goToBody() '''
		container.clear();
		container.add(view.asWidget());
	'''

	override addMethods(GenEditorGenerator it) '''
		«getViewer»

		«createGraphicalViewer»
		
		«createOrLoadDiagram»
	'''
	
	protected def createGraphicalViewer(GenEditorGenerator it) '''
		«generatedMemberComment»
		private org.eclipse.gef.GraphicalViewer createGraphicalViewer(org.eclipse.gef.EditDomain editDomain) {
			org.eclipse.gef.GraphicalViewer viewer = new org.eclipse.gef.ui.parts.ScrollingGraphicalViewer();
			org.eclipse.gef.editparts.ScalableFreeformRootEditPart root = new org.eclipse.gef.editparts.ScalableFreeformRootEditPart();

			viewer.setRootEditPart(root);
			viewer.setEditPartFactory(new «it.diagram.editPartFactoryQualifiedClassName»(clientFactory));
			viewer.setEditDomain(editDomain);
			viewer.setContents(createOrLoadDiagram(diagram));

			return viewer;
		}
	'''
	
	protected def createOrLoadDiagram(GenEditorGenerator it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.Diagram createOrLoadDiagram(org.eclipse.emf.ecore.resource.Resource resource) {
			org.eclipse.gmf.runtime.notation.Diagram diagram = null;

			if (resource.getContents().isEmpty()) {
				diagram = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDiagram();
				«val editPartQCN = it.diagram.editPartQualifiedClassName»
				diagram.setType(«editPartQCN».MODEL_ID);
				«val className = it.diagram.domainDiagramElement.name»
				«val qualifiedClassName = it.diagram.domainDiagramElement.qualifiedInterfaceName»
				«val factoryClassName = it.diagram.domainDiagramElement.genPackage.qualifiedFactoryClassName»
				«qualifiedClassName» model = «factoryClassName».eINSTANCE.create«className»();
				diagram.setElement(model);

				org.eclipse.emf.ecore.resource.Resource domain = clientFactory.getResourceSet().createResource(
						resource.getURI().trimFileExtension().appendFileExtension("«it.domainFileExtension»"));

				domain.getContents().add(model);
				resource.getContents().add(diagram);

				try {
					domain.save(null, new org.eclipse.emf.common.util.Callback<org.eclipse.emf.ecore.resource.Resource>() {
						@Override public void onSuccess(org.eclipse.emf.ecore.resource.Resource result) {}
						@Override public void onFailure(Throwable caught) {}
					});
				} catch (java.io.IOException e) {
					e.printStackTrace();
				}
				try {
					resource.save(null, new org.eclipse.emf.common.util.Callback<org.eclipse.emf.ecore.resource.Resource>() {
						@Override public void onSuccess(org.eclipse.emf.ecore.resource.Resource result) {}
						@Override public void onFailure(Throwable caught) {}
					});
				} catch (java.io.IOException e) {
					e.printStackTrace();
				}
			} else {
				diagram = (org.eclipse.gmf.runtime.notation.Diagram) resource.getContents().get(0);
			}

			return diagram;
		}
	'''

	protected def getViewer(GenEditorGenerator it) '''
		«generatedMemberComment»
		public org.eclipse.gef.GraphicalViewer getViewer() {
			return viewer;
		}
	'''

}