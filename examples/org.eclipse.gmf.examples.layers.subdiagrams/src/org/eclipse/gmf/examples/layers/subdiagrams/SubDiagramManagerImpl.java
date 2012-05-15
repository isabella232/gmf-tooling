package org.eclipse.gmf.examples.layers.subdiagrams;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.examples.layers.LayersFactory;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.examples.layers.SubDiagramSupport;
import org.eclipse.gmf.runtime.notation.Diagram;

public class SubDiagramManagerImpl implements SubDiagramManager {

	private static class ManagerHolderAdapter extends AdapterImpl {

		private final SubDiagramManagerImpl myManager;

		public ManagerHolderAdapter(SubDiagramManagerImpl manager) {
			myManager = manager;
		}

		public SubDiagramManagerImpl getManager() {
			return myManager;
		}
	}

	public static SubDiagramManager findOrCreateSubsetManager(Diagram diagram) {
		for (Adapter next : diagram.eAdapters()) {
			if (next instanceof ManagerHolderAdapter) {
				return ((ManagerHolderAdapter) next).getManager();
			}
		}
		SubDiagramManagerImpl result = new SubDiagramManagerImpl(diagram.eResource());
		diagram.eAdapters().add(new ManagerHolderAdapter(result));
		return result;
	}

	public static void setupSubsetsSupport(Diagram diagram, Resource diagramResource) {
		SubDiagramSupport support = LayersFactory.eINSTANCE.createSubDiagramSupport();
		diagramResource.getContents().add(support);

		SubDiagramSpec mainDiagramSpec = LayersFactory.eINSTANCE.createSubDiagramSpec();
		mainDiagramSpec.setName("Main");
		mainDiagramSpec.setShowing(true);
		mainDiagramSpec.setDiagram(diagram);
		support.setMainDiagram(mainDiagramSpec);

		//fake layers
		//		Layer layerA = LayersFactory.eINSTANCE.createLayer();
		//		layerA.setName("Layer A");
		//
		//		Layer layerB = LayersFactory.eINSTANCE.createLayer();
		//		layerB.setName("Layer B");
		//
		//		support.getLayers().add(layerA);
		//		support.getLayers().add(layerB);
		//

		support.ensureAllSubDiagramsHaveEnablementForAllLayers();
	}

	private final Resource myDiagramResource;

	private final SubDiagramSupport mySubDiagramSupport;

	public SubDiagramManagerImpl(Resource diagramResource) {
		myDiagramResource = diagramResource;
		mySubDiagramSupport = findSubDiagramSupport(myDiagramResource);
	}

	private static SubDiagramSupport findSubDiagramSupport(Resource resource) {
		for (EObject next : resource.getContents()) {
			if (next instanceof SubDiagramSupport) {
				return (SubDiagramSupport) next;
			}
		}
		return null;
	}

	@Override
	public SubDiagramSupport getSubDiagramSupport() {
		return mySubDiagramSupport;
	}

}
