package org.eclipse.gmf.examples.layers.subdiagrams.popup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.examples.layers.Layer;
import org.eclipse.gmf.examples.layers.LayerEnablement;
import org.eclipse.gmf.examples.layers.LayersFactory;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;

public class SwitchLayerVisibilityAction extends DiagramAction {

	protected static final String EMPTY_LAYER_NAME = "<empty-name>";

	private final Layer myLayer;

	private final SubDiagramSpec mySpec;

	public SwitchLayerVisibilityAction(IWorkbenchPage workbenchPage, Layer layer, SubDiagramSpec spec) {
		super(workbenchPage);
		myLayer = layer;
		mySpec = spec;
	}

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	@Override
	protected Command getCommand() {
		DiagramEditPart diagramEditPart = getDiagramEditPart();
		if (diagramEditPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		if (mySpec == null) {
			return UnexecutableCommand.INSTANCE;
		}

		IEditCommandRequest request = new DomainOnlyEditRequest(diagramEditPart);
		return new ICommandProxy(new SwitchLayerVisibility("Switching Layer Visibility", myLayer, mySpec, request));
	}

	@Override
	public boolean isEnabled() {
		return getDiagramEditPart() != null;
	}

	@Override
	public void refresh() {
		super.refresh();
		setText(calculateText());
		setChecked(calculateChecked());
	}

	protected String calculateText() {
		String name = myLayer.getName();
		return name != null ? name : EMPTY_LAYER_NAME;
	}

	protected boolean calculateChecked() {
		LayerEnablement layerEnablement = mySpec.findLayerEnablement(myLayer);
		//may be null, but only if disabled
		return layerEnablement != null && layerEnablement.isVisible();
	}

	protected static class SwitchLayerVisibility extends EditElementCommand {

		private final Layer myLayer;

		private final SubDiagramSpec myDiagramSpec;

		protected SwitchLayerVisibility(String label, Layer layer, SubDiagramSpec spec, IEditCommandRequest request) {
			super(label, layer, request);
			myLayer = layer;
			myDiagramSpec = spec;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			final NodesBag mappedNodes = mapDiagramNodes();
			LayerEnablement enablement = myDiagramSpec.findLayerEnablement(myLayer);
			if (enablement != null && enablement.isVisible()) {
				enablement.setVisible(false);

				final Map<EObject, List<LayerEnablement>> mappedLayers = mapLayers();
				for (EObject nextParticipant : enablement.getLayer().getParticipants()) {
					List<LayerEnablement> allLayers = mappedLayers.get(nextParticipant);
					if (!hasVisibleLayerOtherThan(allLayers, enablement.getLayer())) {
						mappedNodes.setAllNodesVisibleFor(nextParticipant, false);
					}
				}
			} else {
				if (enablement == null) {
					enablement = LayersFactory.eINSTANCE.createLayerEnablement();
					enablement.setLayer(myLayer);
					myDiagramSpec.getDiagramLayers().add(enablement);
				}
				enablement.setVisible(true);
				//if element is in at least one visible layer, it is visible for sure
				for (EObject nextParticiant : myLayer.getParticipants()) {
					mappedNodes.setAllNodesVisibleFor(nextParticiant, true);
				}
			}
			return CommandResult.newOKCommandResult(enablement);
		}

		private static boolean hasVisibleLayerOtherThan(List<LayerEnablement> allLayers, Layer layer) {
			if (allLayers == null) {
				return false;
			}
			for (LayerEnablement next : allLayers) {
				if (next.getLayer() == layer) {
					continue;
				}
				if (next.isVisible()) {
					return true;
				}
			}
			return false;
		}

		private NodesBag mapDiagramNodes() {
			NodesBag result = new NodesBag();
			LinkedList<View> queue = new LinkedList<View>();
			queue.add(myDiagramSpec.getDiagram());

			while (!queue.isEmpty()) {
				View next = queue.removeFirst();
				if (next.isSetElement() && next instanceof Node) {
					EObject element = next.getElement();
					if (element != null) {
						result.putOne(element, (Node) next);
					}
				}
				@SuppressWarnings("unchecked")
				List<View> children = next.getChildren();
				queue.addAll(children);
			}

			return result;
		}

		private BagByEObject<LayerEnablement> mapLayers() {
			BagByEObject<LayerEnablement> result = new BagByEObject<LayerEnablement>();
			for (LayerEnablement next : myDiagramSpec.getDiagramLayers()) {
				for (EObject participant : next.getLayer().getParticipants()) {
					result.putOne(participant, next);
				}
			}
			return result;
		}

	}

	@SuppressWarnings("serial")
	private static class BagByEObject<V> extends HashMap<EObject, List<V>> {

		public void putOne(EObject key, V value) {
			if (key == null) {
				return;
			}
			List<V> values = get(key);
			if (values == null) {
				values = new ArrayList<V>();
				put(key, values);
			}
			values.add(value);
		}
	}

	@SuppressWarnings("serial")
	private static class NodesBag extends BagByEObject<Node> {

		public void setAllNodesVisibleFor(EObject object, boolean visible) {
			List<Node> nodes = this.get(object);
			if (nodes != null) {
				for (Node nextNode : nodes) {
					nextNode.setVisible(visible);
				}
			}
		}

	}

}
