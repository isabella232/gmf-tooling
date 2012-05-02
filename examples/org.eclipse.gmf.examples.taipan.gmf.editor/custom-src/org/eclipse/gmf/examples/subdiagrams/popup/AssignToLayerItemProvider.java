package org.eclipse.gmf.examples.subdiagrams.popup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.layers.Layer;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.examples.layers.SubDiagramSupport;
import org.eclipse.gmf.examples.subdiagrams.SubDiagramManager;
import org.eclipse.gmf.examples.subdiagrams.SubDiagramManagerImpl;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchPage;

public class AssignToLayerItemProvider extends AbstractContributionItemProvider implements IProvider {

	public static final String MENU_ASSIGN_TO_LAYER = "menu_assign_to_layer"; //$NON-NLS-1$

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
			IGraphicalEditPart firstSelected = (IGraphicalEditPart) getSelectedObject(myWorkbenchPart);
			Diagram activeDiagram = firstSelected.getNotationView().getDiagram();

			SubDiagramManager subsetManager = SubDiagramManagerImpl.findOrCreateSubsetManager(activeDiagram);
			SubDiagramSupport support = subsetManager.getSubDiagramSupport();

			SubDiagramSpec activeSpec = support.findDiagramSpec(activeDiagram);

			List<EObject> allSelectedEObjects = Collections.unmodifiableList(resolveSelectedSemanticElements());
			for (Layer next : support.getLayers()) {
				AssignToLayerAction action = new AssignToLayerAction(getWorkbenchPage(), allSelectedEObjects, next);
				action.init();
				manager.add(action);
			}

			manager.add(new Separator());
			CreateNewLayerAction createNewAction = new CreateNewLayerAction(getWorkbenchPage(), allSelectedEObjects, support, activeSpec);
			createNewAction.init();
			manager.add(createNewAction);
		}

		private List<EObject> resolveSelectedSemanticElements() {
			LinkedHashSet<EObject> result = new LinkedHashSet<EObject>();
			for (Object next : getStructuredSelection(myWorkbenchPart).toArray()) {
				if (next instanceof IGraphicalEditPart) {
					result.add(((IGraphicalEditPart) next).resolveSemanticElement());
				}
			}
			return new ArrayList<EObject>(result);
		}

		private IWorkbenchPage getWorkbenchPage() {
			return myWorkbenchPart.getPartPage();
		}
	}

}
