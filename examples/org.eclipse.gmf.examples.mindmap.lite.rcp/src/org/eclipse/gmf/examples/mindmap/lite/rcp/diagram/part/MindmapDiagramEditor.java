package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.PositionConstants;

import org.eclipse.emf.common.notify.AdapterFactory;

import org.eclipse.emf.common.ui.URIEditorInput;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;

import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.workspace.AbstractEMFOperation;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gef.KeyStroke;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.MouseWheelHandler;
import org.eclipse.gef.MouseWheelZoomHandler;

import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;

import org.eclipse.gef.palette.PaletteRoot;

import org.eclipse.gef.ui.actions.AlignmentAction;
import org.eclipse.gef.ui.actions.DeleteAction;
import org.eclipse.gef.ui.actions.DirectEditAction;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.gef.ui.actions.PrintAction;
import org.eclipse.gef.ui.actions.RedoAction;
import org.eclipse.gef.ui.actions.SaveAction;
import org.eclipse.gef.ui.actions.UndoAction;
import org.eclipse.gef.ui.actions.ZoomInAction;
import org.eclipse.gef.ui.actions.ZoomOutAction;

import org.eclipse.gef.ui.parts.GraphicalViewerKeyHandler;

import org.eclipse.gmf.examples.mindmap.Map;
import org.eclipse.gmf.examples.mindmap.MindmapFactory;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts.MindmapEditPartFactory;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.view.factories.MapViewFactory;

import org.eclipse.gmf.examples.mindmap.provider.MindmapItemProviderAdapterFactory;

import org.eclipse.gmf.runtime.lite.parts.DiagramEditor;

import org.eclipse.gmf.runtime.lite.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.lite.ui.actions.LayoutDiagramAction;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;

import org.eclipse.gmf.runtime.notation.provider.NotationItemProviderAdapterFactory;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;

import org.eclipse.jface.dialogs.ErrorDialog;

import org.eclipse.swt.SWT;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

import org.eclipse.ui.actions.ActionFactory;

import org.eclipse.ui.views.properties.IPropertySheetPage;

import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * @generated
 */
public class MindmapDiagramEditor extends DiagramEditor {
	/**
	 * @generated
	 */
	public static final String ID = "org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapDiagramEditorID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private Map diagramRoot;

	/**
	 * @generated
	 */
	private Diagram diagram;

	/**
	 * @generated
	 */
	private ComposedAdapterFactory domainAdapterFactory;

	/**
	 * @generated
	 */
	protected void createActions() {
		addStackAction(new UndoAction(this));
		addStackAction(new RedoAction(this));

		addEditPartAction(new DeleteAction((IWorkbenchPart) this));
		addEditPartAction(new DirectEditAction((IWorkbenchPart) this));

		addEditPartAction(new AlignmentAction((IWorkbenchPart) this,
				PositionConstants.LEFT));
		addEditPartAction(new AlignmentAction((IWorkbenchPart) this,
				PositionConstants.RIGHT));
		addEditPartAction(new AlignmentAction((IWorkbenchPart) this,
				PositionConstants.TOP));
		addEditPartAction(new AlignmentAction((IWorkbenchPart) this,
				PositionConstants.BOTTOM));
		addEditPartAction(new AlignmentAction((IWorkbenchPart) this,
				PositionConstants.CENTER));
		addEditPartAction(new AlignmentAction((IWorkbenchPart) this,
				PositionConstants.MIDDLE));

		addEditorAction(new SaveAction(this));
		addEditorAction(new PrintAction(this));
		addEditorAction(new LayoutDiagramAction(this));

		IAction zoomIn = new ZoomInAction(getZoomManager());
		IAction zoomOut = new ZoomOutAction(getZoomManager());
		addAction(zoomIn);
		addAction(zoomOut);
		getSite().getKeyBindingService().registerAction(zoomIn);
		getSite().getKeyBindingService().registerAction(zoomOut);
		KeyHandler keyHandler = getGraphicalViewer().getKeyHandler();
		keyHandler.put(KeyStroke.getPressed(SWT.DEL, 127, 0),
				getActionRegistry().getAction(ActionFactory.DELETE.getId()));
		keyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry()
				.getAction(GEFActionConstants.DIRECT_EDIT));
	}

	/**
	 * @generated
	 */
	public void dispose() {
		// important: always call super implementation of dispose
		super.dispose();
	}

	/**
	 * @generated
	 */
	public void doSave(IProgressMonitor monitor) {
		try {
			save(monitor);
			getCommandStack().markSaveLocation();
		} catch (CoreException e) {
			ErrorDialog.openError(getSite().getShell(), "Error During Save",
					"The current Mindmap model could not be saved.", e
							.getStatus());
		}
	}

	/**
	 * @generated
	 */
	public void configurePalette(PaletteRoot paletteRoot) {
		new MindmapPaletteFactory(getDomainAdapterFactory())
				.contributeToPalette(paletteRoot);
	}

	/**
	 * @generated
	 */
	public Map getDiagramRoot() {
		return diagramRoot;
	}

	/**
	 * @generated
	 */
	public Diagram getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	protected IPropertySheetPage getPropertySheetPage() {
		if (myPropertySheetPage == null) {
			myPropertySheetPage = new TabbedPropertySheetPage(
					new ITabbedPropertySheetPageContributor() {
						public String getContributorId() {
							return org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapDiagramEditorPlugin.ID;
						}
					});
		}
		return myPropertySheetPage;
	}

	/**
	 * @generated
	 */
	private IPropertySheetPage myPropertySheetPage;

	/**
	 * @generated
	 */
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		URI file = getURIFromInput(input);
		if (file == null) {
			throw new PartInitException("The specified input is not valid.");
		}
		super.init(site, input);
		// validate
		if (getDiagramRoot() == null) {
			throw new PartInitException("The specified input is not valid.");
		}
	}

	/**
	 * @generated
	 */
	protected void setInput(IEditorInput input) {
		URI file = getURIFromInput(input);
		load(file);
		setPartName(file.lastSegment());
		super.setInput(input);
	}

	/**
	 * @generated
	 */
	private URI getURIFromInput(IEditorInput input) {
		if (input == null) {
			return null;
		}
		if (input instanceof URIEditorInput) {
			return ((URIEditorInput) input).getURI();
		}
		if (input instanceof IPathEditorInput) {
			return URI.createFileURI(((IPathEditorInput) input).getPath()
					.toOSString());
		}
		URI uri = (URI) input.getAdapter(URI.class);
		if (uri != null) {
			return uri;
		}
		return null;
	}

	/**
	 * @generated
	 */
	public AdapterFactory getDomainAdapterFactory() {
		if (domainAdapterFactory == null) {
			List factories = new ArrayList();
			factories.add(new ResourceItemProviderAdapterFactory());
			factories.add(new MindmapItemProviderAdapterFactory());
			factories.add(new ReflectiveItemProviderAdapterFactory());
			factories.add(new NotationItemProviderAdapterFactory());
			domainAdapterFactory = new ComposedAdapterFactory(factories);
		}
		return domainAdapterFactory;
	}

	/**
	 * @generated
	 */
	private void load(URI diagramFile) {
		diagramRoot = null;
		diagram = null;
		if (diagramFile == null) {
			return;
		}
		final URI diagramFileURI = diagramFile;
		TransactionalEditingDomain editingDomain = getEditingDomain();
		final ResourceSet resourceSet = editingDomain.getResourceSet();
		final Resource diagramResource = resourceSet.getResource(diagramFile
				.trimFragment(), true);
		if (diagramResource == null) {
			return;
		}
		AbstractEMFOperation operation = new AbstractEMFOperation(
				editingDomain, "Load diagram", null) {
			protected IStatus doExecute(IProgressMonitor monitor,
					IAdaptable info) throws ExecutionException {
				if (diagramFileURI.fragment() != null) {
					EObject possibleDiagram = diagramResource
							.getEObject(diagramFileURI.fragment());
					if (possibleDiagram instanceof Diagram) {
						diagram = (Diagram) possibleDiagram;
					} else {
						return Status.CANCEL_STATUS;
					}
				} else {
					diagram = (Diagram) findInResource(diagramResource,
							Diagram.class);
					if (diagram == null) {
						diagram = NotationFactory.eINSTANCE.createDiagram();
						diagramResource.getContents().add(0, diagram);
						//Auxiliary creation should not be undoable.
						try {
							diagramResource.save(Collections.EMPTY_MAP);
						} catch (IOException e) {
							diagram = null;
							diagramRoot = null;
							return Status.CANCEL_STATUS;
						}
					}
				}
				diagramRoot = (Map) diagram.getElement();
				if (diagramRoot == null) {
					URI modelFile = MindmapDiagramEditorUtil
							.getModelFileURI(diagramFileURI);
					Resource modelResource = resourceSet.getResource(modelFile,
							true);
					if (modelResource == null) {
						diagram = null;
						return Status.CANCEL_STATUS;
					}
					diagramRoot = (Map) findInResource(modelResource, Map.class);
					if (diagramRoot == null) {
						diagramRoot = MindmapFactory.eINSTANCE.createMap();
						modelResource.getContents().add(0, diagramRoot);
						//We don't want this auxiliary creation to be undoable.
						try {
							modelResource.save(Collections.EMPTY_MAP);
						} catch (IOException e) {
							diagram = null;
							diagramRoot = null;
							return Status.CANCEL_STATUS;
						}
					}
					if (!diagramRoot.equals(diagram.getElement())) {
						diagram.setElement(diagramRoot);
					}
				}
				if (!diagram.eIsSet(NotationPackage.eINSTANCE.getView_Type())) {
					MapViewFactory.INSTANCE.decorateView(diagram);
					doSave(new NullProgressMonitor());
				}
				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			diagram = null;
			diagramRoot = null;
		}
	}

	/**
	 * @generated
	 */
	private Object findInResource(Resource resource, Class expectedClass) {
		for (Iterator it = resource.getContents().iterator(); it.hasNext();) {
			Object next = it.next();
			if (expectedClass.isInstance(next)) {
				return next;
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public void initializeGraphicalViewer() {
		// initialize the viewer with input
		ScalableFreeformRootEditPart root = new ScalableFreeformRootEditPart();
		getGraphicalViewer().setRootEditPart(root);
		getGraphicalViewer().setEditPartFactory(new MindmapEditPartFactory());

		LayeredPane printableLayers = (LayeredPane) root
				.getLayer(LayerConstants.PRINTABLE_LAYERS);
		FreeformLayer extLabelsLayer = new FreeformLayer();
		extLabelsLayer.setLayoutManager(new DelegatingLayout());
		printableLayers.addLayerAfter(extLabelsLayer,
				MindmapEditPartFactory.EXTERNAL_NODE_LABELS_LAYER,
				LayerConstants.PRIMARY_LAYER);
		getGraphicalViewer().setContents(getDiagram());
	}

	/**
	 * @generated
	 */
	public void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		GraphicalViewer viewer = getGraphicalViewer();
		// configure the context menu
		ContextMenuProvider provider = new MindmapDiagramEditorContextMenuProvider(
				viewer);
		viewer.setContextMenu(provider);
		getSite()
				.registerContextMenu(
						MindmapDiagramEditorPlugin.ID + ".editor.contextmenu", provider, getSite().getSelectionProvider()); //$NON-NLS-1$

		KeyHandler keyHandler = new GraphicalViewerKeyHandler(viewer);
		viewer.setKeyHandler(keyHandler);

		viewer.setProperty(MouseWheelHandler.KeyGenerator.getKey(SWT.CTRL),
				MouseWheelZoomHandler.SINGLETON);
	}

	/**
	 * @generated
	 */
	public boolean isFlyoutPalette() {
		return true;
	}

	/**
	 * @generated
	 */
	private class MindmapDiagramEditorContextMenuProvider extends
			ContextMenuProvider {
		/**
		 * @generated
		 */
		public MindmapDiagramEditorContextMenuProvider(EditPartViewer viewer) {
			super(viewer);
		}

		/**
		 * @generated
		 */
		public void buildContextMenu(IMenuManager menuManager) {
			GEFActionConstants.addStandardActionGroups(menuManager);
			appendActionToMenu(menuManager, ActionFactory.UNDO.getId(),
					GEFActionConstants.GROUP_UNDO);
			appendActionToMenu(menuManager, ActionFactory.REDO.getId(),
					GEFActionConstants.GROUP_UNDO);

			appendActionToMenu(menuManager, ActionFactory.COPY.getId(),
					GEFActionConstants.GROUP_EDIT);
			appendActionToMenu(menuManager, ActionFactory.PASTE.getId(),
					GEFActionConstants.GROUP_EDIT);
			appendActionToMenu(menuManager, ActionFactory.DELETE.getId(),
					GEFActionConstants.GROUP_EDIT);
			appendActionToMenu(menuManager, GEFActionConstants.DIRECT_EDIT,
					GEFActionConstants.GROUP_EDIT);

			appendActionToMenu(menuManager, ActionIds.LAYOUT_ALL_ACTION,
					GEFActionConstants.GROUP_REST);

			appendActionToMenu(menuManager, ActionFactory.SAVE.getId(),
					GEFActionConstants.GROUP_SAVE);
			appendAlignmentSubmenu(menuManager);
		}

		/**
		 * @generated
		 */
		private void appendAlignmentSubmenu(IMenuManager menuManager) {
			// Alignment Actions
			MenuManager submenu = new MenuManager("Align");
			submenu.add(new Separator(GEFActionConstants.MB_ADDITIONS));

			appendActionToMenu(submenu, GEFActionConstants.ALIGN_LEFT,
					GEFActionConstants.MB_ADDITIONS);
			appendActionToMenu(submenu, GEFActionConstants.ALIGN_CENTER,
					GEFActionConstants.MB_ADDITIONS);
			appendActionToMenu(submenu, GEFActionConstants.ALIGN_RIGHT,
					GEFActionConstants.MB_ADDITIONS);
			appendActionToMenu(submenu, GEFActionConstants.ALIGN_TOP,
					GEFActionConstants.MB_ADDITIONS);
			appendActionToMenu(submenu, GEFActionConstants.ALIGN_MIDDLE,
					GEFActionConstants.MB_ADDITIONS);
			appendActionToMenu(submenu, GEFActionConstants.ALIGN_BOTTOM,
					GEFActionConstants.MB_ADDITIONS);

			if (!submenu.isEmpty()) {
				menuManager.appendToGroup(GEFActionConstants.GROUP_REST,
						submenu);
			}
		}

		/**
		 * @generated
		 */
		private void appendActionToMenu(IMenuManager menu, String actionId,
				String menuGroup) {
			IAction action = getActionRegistry().getAction(actionId);
			if (action != null && action.isEnabled()) {
				menu.appendToGroup(menuGroup, action);
			}
		}
	}
}
