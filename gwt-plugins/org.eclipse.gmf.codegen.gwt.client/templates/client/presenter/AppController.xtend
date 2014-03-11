package client.presenter

import client.view.DiagramView
import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import client.view.sidebar.SidePaneView

class AppController extends PresenterTemplate {
	
	@Inject DiagramView diagramView
	@Inject SidePaneView sidePaneView
	@Inject DiagramPresenter diagramPresenter

	protected override implementDefinition(GenEditorGenerator it) 
		'''«basePresenterPackage».Presenter, com.google.gwt.event.logical.shared.ValueChangeHandler<String>'''
	
	protected override getImports(GenEditorGenerator it) '''
		import org.eclipse.draw2d.ColorConstants;
		import org.eclipse.draw2d.IFigure;
		import org.eclipse.emf.common.command.Command;
		import org.eclipse.emf.common.util.URI;
		import org.eclipse.emf.ecore.resource.Resource;
		import org.eclipse.gef.EditPart;
		import org.eclipse.gef.commands.CommandStack;
		import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
		import org.eclipse.gef.internal.ui.palette.editparts.GroupEditPart;
		import org.eclipse.gef.internal.ui.palette.editparts.SliderPaletteEditPart;
		import org.eclipse.gef.palette.PaletteContainer;
		import org.eclipse.gef.palette.PaletteRoot;
		import org.eclipse.gef.ui.palette.PaletteEditPartFactory;
		import org.eclipse.gef.ui.palette.PaletteViewer;
		import org.eclipse.gef.ui.palette.PaletteViewerProvider;
		import org.eclipse.gmf.runtime.gwt.client.ClientFactory;
		import org.eclipse.gmf.runtime.gwt.commands.RemoveNotationalElementCommand;
		import org.eclipse.gmf.runtime.gwt.commands.WrappingCommand;
		import org.eclipse.jface.viewers.ISelection;
		import org.eclipse.jface.viewers.IStructuredSelection;
		import org.eclipse.swt.graphics.Color;

		import «baseEventPackage».ShowPaneEvent.ShowPaneEventHandler;
		import «baseEventPackage».ShowPaneEvent;
		import «baseClientPackage».view.DiagramView;
		import «baseClientPackage».view.PaletteView;
		import «baseClientPackage».view.PropertySheetView;
		import «baseClientPackage».view.SidePaneView;

		import com.google.gwt.event.logical.shared.ValueChangeEvent;
		import com.google.gwt.event.logical.shared.ValueChangeHandler;
		import com.google.gwt.event.shared.HandlerManager;
		import com.google.gwt.user.client.History;
		import com.google.gwt.user.client.ui.HasWidgets;
		import com.google.gwt.user.client.ui.Widget;
	'''
	
	override interfaces(GenEditorGenerator it) '''
		«viewInterface»

		«generatedMemberComment»
		public interface MenuView {
			«generatedMemberComment»
			void addControlViewHandler(MenuViewHandler handler);
		}
	'''
	
	override handlers(GenEditorGenerator it) '''
		«generatedMemberComment»
		public interface MenuViewHandler {

			«generatedMemberComment»
			void onClickCreate();

			«generatedMemberComment»
			void onClickPalette();

			«generatedMemberComment»
			void onClickProperty();

			«generatedMemberComment»
			void onDelete();

			«generatedMemberComment»
			void onRedo();

			«generatedMemberComment»
			void onUndo();

			«generatedMemberComment»
			void onZoomIn();

			«generatedMemberComment»
			void onZoomOut();
		}
	'''
	
	override viewInterfaceMethods(GenEditorGenerator it) '''
		«generatedMemberComment»
		«diagramView.qualifiedClassName(it)» getDiagramView();

		«generatedMemberComment»
		MenuView getMenuView();

		«generatedMemberComment»
		com.google.gwt.user.client.ui.Widget asWidget();
	'''
	
	override attrs(GenEditorGenerator it) '''
		«super.attrs(it)»

		«generatedMemberComment»
		private «diagramPresenter.qualifiedClassName(it)» diagramPresenter = null;

		«generatedMemberComment»
		private Panes currentPane = null;

		«generatedMemberComment»
		private «sidePaneView.qualifiedClassName(it)» currentPaneView = null;
		
		«addControlHandler(it)»
	'''
	
	def addControlHandler(GenEditorGenerator it) '''
		«generatedMemberComment»
		private final MenuViewHandler handler = new MenuViewHandler() {

			«generatedMemberComment»
			@Override
			public void onClickCreate() {
			}

			«generatedMemberComment»
			@Override
			public void onClickPalette() {
				clientFactory.getEventBus().fireEvent(new ShowPaneEvent(Panes.PALETTE));
			}

			«generatedMemberComment»
			@Override
			public void onClickProperty() {
				clientFactory.getEventBus().fireEvent(new ShowPaneEvent(Panes.PROPERTY));
			}

			«generatedMemberComment»
			@Override
			public void onDelete() {
				ISelection selection = diagramPresenter.getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					final Object element = ((IStructuredSelection) selection).getFirstElement();

					if (element instanceof EditPart) {
						final org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) ((EditPart) element).getModel();
						Command command = new RemoveNotationalElementCommand((org.eclipse.gmf.runtime.notation.View) view.eContainer(), view);
						WrappingCommand gefCommand = new WrappingCommand(clientFactory.getEditingDomain(), command);
						diagramPresenter.getViewer().getEditDomain().getCommandStack().execute(gefCommand);
					}
				}
			}

			«generatedMemberComment»
			@Override
			public void onRedo() {
				CommandStack stack = diagramPresenter.getViewer().getEditDomain().getCommandStack();
				if (stack.canRedo())
					stack.redo();
			}

			«generatedMemberComment»
			@Override
			public void onUndo() {
				CommandStack stack = diagramPresenter.getViewer().getEditDomain().getCommandStack();
				if (stack.canUndo())
					stack.undo();
			}

			«generatedMemberComment»
			@Override
			public void onZoomIn() {
				EditPart part = diagramPresenter.getViewer().getRootEditPart();
				if (part instanceof ScalableFreeformRootEditPart) {
					((ScalableFreeformRootEditPart) part).getZoomManager().zoomIn();
				}
			}

			«generatedMemberComment»
			@Override
			public void onZoomOut() {
				EditPart part = diagramPresenter.getViewer().getRootEditPart();
				if (part instanceof ScalableFreeformRootEditPart) {
					((ScalableFreeformRootEditPart) part).getZoomManager().zoomOut();
				}
			}
		};
	'''
	
	override ctorBody(GenEditorGenerator it) '''
		«super.ctorBody(it)»
		this.view.getMenuView().addControlViewHandler(handler);

		bind();
	'''
	
	override bindBody(GenEditorGenerator it) '''
		com.google.gwt.user.client.History.addValueChangeHandler(this);

		eventBus.addHandler(«baseEventPackage».ShowPaneEvent.TYPE, new ShowPaneEventHandler() {
			«generatedMemberComment»
			@Override
			public void show(«baseEventPackage».ShowPaneEvent event) {
				if (currentPaneView != null) {
					currentPaneView.removeFromParent();
				}
				if (event.pane.equals(currentPane)) {
					currentPane = null;
					currentPaneView = null;
				} else {
					currentPane = event.pane;
					currentPaneView = event.pane.createView(AppController.this);
					((HasWidgets) view.asWidget().getParent()).add(currentPaneView);
				}
			}
		});
	'''
	
	override addMethods(GenEditorGenerator it) '''
		«generatedMemberComment»
		private void createDiagram() {
			Resource resource = clientFactory.getResourceSet().createResource(URI.createURI("client://diagram"));
			diagramPresenter = new DiagramPresenter(eventBus, clientFactory, view.getDiagramView(), resource);
		}
		
		«generatedMemberComment»
		@Override
		public void onValueChange(com.google.gwt.event.logical.shared.ValueChangeEvent<String> event) {
			String token = event.getValue();

			if (token != null) {
				if (token.equals("diagram")) {
					createDiagram();
					clientFactory.getEventBus().fireEvent(new ShowPaneEvent(Panes.PALETTE));
				}
			}
		}
		
		«generatedMemberComment»
		protected PaletteViewerProvider createPaletteProvider() {
			return new PaletteViewerProvider(clientFactory.getEditDomain()) {
				«generatedMemberComment»
				@Override
				protected void hookPaletteViewer(PaletteViewer viewer) {
					super.hookPaletteViewer(viewer);
					viewer.setEditPartFactory(new PaletteEditPartFactory() {

						«generatedMemberComment»
						@Override
						protected EditPart createGroupEditPart(EditPart parentEditPart, Object model) {
							return new GroupEditPart((PaletteContainer) model) {
								«generatedMemberComment»
								@Override
								public IFigure createFigure() {
									IFigure figure = super.createFigure();
									figure.setBackgroundColor(new Color(null, 250, 250, 250));
									return figure;
								}
							};
						}

						«generatedMemberComment»
						@Override
						protected EditPart createMainPaletteEditPart(EditPart parentEditPart, Object model) {
							return new SliderPaletteEditPart((PaletteRoot) model) {
								«generatedMemberComment»
								@Override
								public IFigure createFigure() {
									IFigure figure = super.createFigure();
									figure.setOpaque(true);
									figure.setBackgroundColor(new Color(null, 250, 250, 250));
									figure.setForegroundColor(ColorConstants.black);
									return figure;
								}
							};
						}
					});
				}
			};
		}
		
		«generatedMemberComment»
		private PaletteRoot createPalette() {
			PaletteRoot paletteRoot = new PaletteRoot();
			new «diagram.palette.factoryQualifiedClassName»(clientFactory).contributeToPalette(paletteRoot);

			return paletteRoot;
		}

		«generatedMemberComment»
		public void showPalette() {
			eventBus.fireEvent(new ShowPaneEvent(Panes.PALETTE));
		}
	'''

	override goToBody() '''
		container.clear();
		container.add(view.asWidget());

		if ("".equals(com.google.gwt.user.client.History.getToken())) {
			com.google.gwt.user.client.History.newItem("diagram");
		} else {
			com.google.gwt.user.client.History.fireCurrentHistoryState();
		}
	'''
	
	override additions(GenEditorGenerator it) '''
		«addPanes»
	'''
	
	def addPanes(GenEditorGenerator it) '''
		«generatedMemberComment»
		public enum Panes {
			PALETTE {

				«generatedMemberComment»
				@Override
				public int getWidth() {
					return 120;
				}

				«generatedMemberComment»
				@Override
				public SidePaneView createView(AppController controller) {
					SidePaneView view = new SidePaneView();
					view.setWidth(getWidth() + "px");

					PaletteView paletteView = new PaletteView();
					paletteView.setPalette(controller.createPalette(), controller.createPaletteProvider());
					view.setContent(paletteView);
					
					return view;
				}
			}, 
			PROPERTY {

				«generatedMemberComment»
				@Override
				public int getWidth() {
					return 200;
				}

				«generatedMemberComment»
				@Override
				public SidePaneView createView(AppController controller) {
					SidePaneView view = new SidePaneView();
					view.setWidth(getWidth() + "px");

					PropertySheetView content = new PropertySheetView();
					new PropertySheetPresenter(controller.eventBus, controller.clientFactory, content);
					view.setContent(content);

					return view;
				}
			};

			«generatedMemberComment»
			public abstract int getWidth();

			«generatedMemberComment»
			public abstract SidePaneView createView(AppController controller);
		}
	''' 

}