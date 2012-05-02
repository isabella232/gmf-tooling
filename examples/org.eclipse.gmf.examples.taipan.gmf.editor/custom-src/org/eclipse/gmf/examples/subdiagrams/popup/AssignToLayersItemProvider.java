package org.eclipse.gmf.examples.subdiagrams.popup;

import org.eclipse.gmf.examples.layers.Layer;
import org.eclipse.gmf.examples.layers.SubDiagramSupport;
import org.eclipse.gmf.examples.subdiagrams.SubDiagramManager;
import org.eclipse.gmf.examples.subdiagrams.SubDiagramManagerImpl;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchPage;

public class AssignToLayersItemProvider extends AbstractContributionItemProvider implements IProvider {

	public static final String MENU_ASSIGN_TO_LAYER = "menu_assign_to_layer"; //$NON-NLS-1$

	public AssignToLayersItemProvider() {
		super();
		System.out.println("AssignToLayersItemProvider.AssignToLayersItemProvider()");
	}

	@Override
	protected IMenuManager createMenuManager(String menuId, IWorkbenchPartDescriptor partDescriptor) {
		if (!MENU_ASSIGN_TO_LAYER.equals(menuId)) {
			return super.createMenuManager(menuId, partDescriptor);
		}
		MenuManager menuManager = new MenuManager("Assign To Layer");
		MenuBuilder builder = new MenuBuilder(partDescriptor);
		// XXX: build initial content -- otherwise menu is never shown
		builder.buildMenu(menuManager);

		menuManager.addMenuListener(builder);
		return menuManager;
	}

	private class MenuBuilder implements IMenuListener {

		private final IWorkbenchPartDescriptor myWorkbenchPart;

		public MenuBuilder(IWorkbenchPartDescriptor workbenchPart) {
			myWorkbenchPart = workbenchPart;
		}

		public void menuAboutToShow(IMenuManager manager) {
			buildMenu(manager);
		}

		public void buildMenu(IMenuManager manager) {
			manager.removeAll();
			IGraphicalEditPart selected = (IGraphicalEditPart) getSelectedObject(myWorkbenchPart);

			View selectedView = selected.getNotationView();
			Diagram activeDiagram = selectedView.getDiagram();

			SubDiagramManager subsetManager = SubDiagramManagerImpl.findOrCreateSubsetManager(activeDiagram);
			SubDiagramSupport support = subsetManager.getSubDiagramSupport();

			for (Layer next : support.getLayers()) {
				AssignToLayerAction action = new AssignToLayerAction(getWorkbenchPage(), selected.resolveSemanticElement(), next);
				action.init();
				manager.add(action);
			}
		}

		private IWorkbenchPage getWorkbenchPage() {
			return myWorkbenchPart.getPartPage();
		}
	}

}
