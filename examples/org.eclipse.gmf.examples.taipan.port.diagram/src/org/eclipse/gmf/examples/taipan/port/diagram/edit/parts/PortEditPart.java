/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.port.diagram.edit.parts;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.examples.taipan.layouts.PortLayoutProvider;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.policies.PortCanonicalEditPolicy;
import org.eclipse.gmf.examples.taipan.port.diagram.edit.policies.PortItemSemanticEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.ObjectAdapter;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ContainerEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.layout.IInternalLayoutRunnable;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.layout.LayoutNode;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class PortEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Port"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1000;

	private PortLayoutProvider layoutProvider = new PortLayoutProvider();

	/**
	 * @generated
	 */
	public PortEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPoliciesGen() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new PortItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new PortCanonicalEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	protected void createDefaultEditPolicies() {
		createDefaultEditPoliciesGen();
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {

			protected Command getArrangeCommand(ArrangeRequest request) {
				if (layoutProvider.isWorking()) {
					return null;
				}
				// DeferredCommand is patched to arrange all children when no viewAdapters is specified
				if (RequestConstants.REQ_ARRANGE_DEFERRED.equals(request.getType())) {
					String layoutType = request.getLayoutType();
					TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
					return new ICommandProxy(new DeferredLayoutCommand(editingDomain, request.getViewAdaptersToArrange(), (IGraphicalEditPart) getHost(), layoutType) {

						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
							if (viewAdapters == null || viewAdapters.isEmpty()) {
								viewAdapters = new ArrayList(PortEditPart.this.getChildren());
							}
							return super.doExecuteWithResult(progressMonitor, info);
						}
					});
				}
				// Snap to grid command is stripped off to prevent loops
				String layoutDesc = request.getLayoutType() != null ? request.getLayoutType() : LayoutType.DEFAULT;
				boolean offsetFromBoundingBox = false;
				List editparts = new ArrayList();

				if ((ActionIds.ACTION_ARRANGE_ALL.equals(request.getType())) || (ActionIds.ACTION_TOOLBAR_ARRANGE_ALL.equals(request.getType()))) {
					editparts = ((IGraphicalEditPart) getHost()).getChildren();
					request.setPartsToArrange(editparts);
				}
				if ((ActionIds.ACTION_ARRANGE_SELECTION.equals(request.getType())) || (ActionIds.ACTION_TOOLBAR_ARRANGE_SELECTION.equals(request.getType()))) {
					editparts = request.getPartsToArrange();
					if (!(((GraphicalEditPart) ((EditPart) editparts.get(0)).getParent()).getContentPane().getLayoutManager() instanceof XYLayout)) {
						return null;
					}
					offsetFromBoundingBox = true;
				}
				if (RequestConstants.REQ_ARRANGE_RADIAL.equals(request.getType())) {
					editparts = request.getPartsToArrange();
					offsetFromBoundingBox = true;
					layoutDesc = LayoutType.RADIAL;
				}
				if (editparts.isEmpty()) {
					return null;
				}
				List nodes = new ArrayList(editparts.size());
				ListIterator li = editparts.listIterator();
				while (li.hasNext()) {
					IGraphicalEditPart ep = (IGraphicalEditPart) li.next();
					View view = ep.getNotationView();
					if (ep.isActive() && view != null && view instanceof Node) {
						Rectangle bounds = ep.getFigure().getBounds();
						nodes.add(new LayoutNode((Node) view, bounds.width, bounds.height));
					}
				}
				if (nodes.isEmpty()) {
					return null;
				}

				List hints = new ArrayList(2);
				hints.add(layoutDesc);
				hints.add(getHost());
				IAdaptable layoutHint = new ObjectAdapter(hints);
				Runnable layoutRun = layoutNodes(nodes, offsetFromBoundingBox, layoutHint);
				return ((IInternalLayoutRunnable) layoutRun).getCommand();
			}

			public Runnable layoutNodes(List nodes, boolean offsetFromBoundingBox, IAdaptable layoutHint) {
				return layoutProvider.layoutLayoutNodes(nodes, offsetFromBoundingBox, layoutHint);
			}
		});
	}

	public Command getCommand(Request request) {
		Command command = super.getCommand(request);
		if (request.getType().equals(REQ_CREATE) || request.getType().equals(REQ_MOVE_CHILDREN) || request.getType().equals(REQ_RESIZE_CHILDREN)) {
			ArrangeRequest layoutRequest = new ArrangeRequest(RequestConstants.REQ_ARRANGE_DEFERRED);
			Command layoutCommand = super.getCommand(layoutRequest);
			if (layoutCommand != null) {
				command = command.chain(layoutCommand);
			}
		}
		return command;
	}
}
