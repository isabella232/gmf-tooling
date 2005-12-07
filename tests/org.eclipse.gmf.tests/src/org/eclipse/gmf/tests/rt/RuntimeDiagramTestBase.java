/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.GraphicsSource;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.UpdateManager;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.BasicGenModelAccess;
import org.eclipse.gmf.bridge.genmodel.DefaultNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.gmfgraph.Connection;
import org.eclipse.gmf.gmfgraph.FigureGallery;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.mappings.CanvasMapping;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.MappingEntry;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.ToolGroup;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.EPath;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.DiaGenSource;
import org.eclipse.gmf.tests.setup.GenProjectSetup;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.RTSetup;
import org.eclipse.gmf.tests.setup.RTSource;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

/**
 * Unit testcase base class with support for runtime-diagram editing.
 */
public abstract class RuntimeDiagramTestBase extends TestCase {
	protected Bundle gmfEditorBundle;

	protected EditPart myDiagramEditPart;

	protected EditPartViewer myViewer;

	protected Composite myParentShell;

	protected GenDiagram myGenDiagram;

	protected Map transformationMap;

	public RuntimeDiagramTestBase(String name) {
		super(name);
	}

	protected EditPart getDiagramEditPart() {
		return myDiagramEditPart;
	}

	protected Diagram getDiagram() {
		return myDiagramEditPart != null ? (Diagram) myDiagramEditPart.getModel() : null;
	}

	protected abstract AbstractMappings getMappings();

	/**
	 * Called before generation step. User should override this method and
	 * customize genmodel with specific settings.
	 * 
	 * @see #getGenElement(MappingEntry)
	 */
	protected void customizeGenModelBeforeGeneration() {
		// do nothing be default
	}

	protected void setUp() throws Exception {
		super.setUp();

		DiaGenSetup diaGenSetup = new DiaGenSetup(getMappings());

		this.myGenDiagram = diaGenSetup.getGenDiagram();
		assertNotNull("GenDiagram not initialized", myGenDiagram); //$NON-NLS-1$

		GenProjectSetup genProject = new GenProjectSetup();
		genProject.init(SessionSetup.getRuntimeWorkspaceSetup(), diaGenSetup);

		this.gmfEditorBundle = genProject.getBundle();
		assertNotNull("GMF editor plugin bundle not initialized", gmfEditorBundle); //$NON-NLS-1$

		String epFactoryClassName = diaGenSetup.getGenDiagram().getEditPartFactoryQualifiedClassName();
		Class epFactory = this.gmfEditorBundle.loadClass(epFactoryClassName);

		assert EditPartFactory.class.isAssignableFrom(epFactory);
		myViewer = createViewer();
		myViewer.setEditPartFactory((EditPartFactory) epFactory.newInstance());

		RTSource rtDiagram = new RTSetup().init(this.gmfEditorBundle, diaGenSetup);

		myViewer.setContents(rtDiagram.getCanvas());
		myDiagramEditPart = (EditPart) myViewer.getEditPartRegistry().get(rtDiagram.getCanvas());
	}

	protected void tearDown() throws Exception {
		if (myParentShell != null) {
			myParentShell.dispose();
			myParentShell = null;
		}
		super.tearDown();
	}

	protected EditPart findEditPart(EditPart parentEditPart, View notationElement) {
		if (parentEditPart.getModel() instanceof View) {
			View view = (View) parentEditPart.getModel();
			if (notationElement instanceof Node || notationElement instanceof Diagram) {
				if (view == notationElement) {
					return parentEditPart;
				}
			} else if (notationElement instanceof Edge) {
				if (parentEditPart instanceof GraphicalEditPart) {
					GraphicalEditPart gpart = (GraphicalEditPart) parentEditPart;
					for (Iterator it = gpart.getSourceConnections().iterator(); it.hasNext();) {
						EditPart nextPart = (EditPart) it.next();
						if (nextPart.getModel() == notationElement) {
							return nextPart;
						}
					}
					for (Iterator it = gpart.getTargetConnections().iterator(); it.hasNext();) {
						EditPart nextPart = (EditPart) it.next();
						if (nextPart.getModel() == notationElement) {
							return nextPart;
						}
					}
				}
			}
		}

		for (Iterator it = parentEditPart.getChildren().iterator(); it.hasNext();) {
			EditPart childEditPart = (EditPart) it.next();
			EditPart foundEPart = findEditPart(childEditPart, notationElement);
			if (foundEPart != null) {
				return foundEPart;
			}
		}
		return null;
	}

	protected Node createNode(IMetamodelType metamodelType, View notationContainer) {
		final Object[] newObjHolder = new Object[1];

		Adapter adapter = new AdapterImpl() {
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if (msg.getEventType() == Notification.ADD) {
					newObjHolder[0] = msg.getNewValue();
				}
			}

			public boolean isAdapterForType(Object type) {
				return true;
			}
		};
		notationContainer.eAdapters().add(adapter);

		try {
			CreateViewAndElementRequest req = new CreateViewAndElementRequest(metamodelType, notationContainer, PreferencesHint.USE_DEFAULTS);
			Command cmd = findEditPart(getDiagramEditPart(), notationContainer).getCommand(req);
			Assert.assertNotNull("No command is available for request", cmd); //$NON-NLS-1$		
			cmd.execute();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Node creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$			
		} finally {
			notationContainer.eAdapters().remove(adapter);
		}
		return newObjHolder[0] instanceof Node ? (Node) newObjHolder[0] : null;
	}

	protected boolean canStartLinkFrom(IMetamodelType metamodelType, View source) {
		CreateRelationshipRequest req = new CreateRelationshipRequest(source.getElement(), null, metamodelType);
		EditCommandRequestWrapper wrapper = new EditCommandRequestWrapper(req);
		Command cmd = findEditPart(getDiagramEditPart(), source).getCommand(wrapper);
		return cmd != null && cmd.canExecute();
	}

	protected Edge createLink(IMetamodelType metamodelType, View source, View target) {
		final Object[] newObjHolder = new Object[1];

		Adapter adapter = new AdapterImpl() {
			public void notifyChanged(Notification msg) {
				super.notifyChanged(msg);
				if (msg.getEventType() == Notification.ADD && msg.getNewValue() instanceof Edge) {
					newObjHolder[0] = msg.getNewValue();
				}
			}

			public boolean isAdapterForType(Object type) {
				return true;
			}
		};
		Diagram diagram = getDiagram();
		diagram.eAdapters().add(adapter);
		try {
			CreateRelationshipRequest relationShipReq = new CreateRelationshipRequest(metamodelType);
			relationShipReq.setSource(source.getElement());
			if (target != null) {
				relationShipReq.setTarget(target.getElement());
			}

			ConnectionViewAndElementDescriptor desc = new ConnectionViewAndElementDescriptor(new CreateElementRequestAdapter(relationShipReq), PreferencesHint.USE_DEFAULTS);

			CreateConnectionViewAndElementRequest req = new CreateConnectionViewAndElementRequest(desc);
			req.setType(RequestConstants.REQ_CONNECTION_START);

			EditPart sourceEditPart = findEditPart(getDiagramEditPart(), source);
			req.setSourceEditPart(sourceEditPart);
			// Note: initializes the sourceCommand in the request
			Command sourceCmd = sourceEditPart.getCommand(req);
			if (sourceCmd == null || !sourceCmd.canExecute()) {
				return null;
			}

			EditPart targetEditPart = target != null ? findEditPart(getDiagramEditPart(), target) : null;
			if (targetEditPart != null) {
				req.setType(RequestConstants.REQ_CONNECTION_END);
				req.setTargetEditPart(targetEditPart);
				req.setLocation(new Point(0, 0));
				sourceEditPart.getCommand(req);
				Command targetCmd = targetEditPart.getCommand(req);
				if (targetCmd == null || !targetCmd.canExecute()) {
					return null;
				}
				targetCmd.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Edge creation failure: " + e.getLocalizedMessage()); //$NON-NLS-1$
		} finally {
			diagram.eAdapters().remove(adapter);
		}
		return newObjHolder[0] instanceof Edge ? (Edge) newObjHolder[0] : null;
	}

	private EditPartViewer createViewer() {
		Viewer gv = new Viewer();
		myParentShell = new Shell(SWT.NONE);
		gv.createControl(myParentShell);
		DiagramEditDomain ded = new DiagramEditDomain(null);
		gv.setEditDomain(ded);
		gv.getEditDomain().setCommandStack(new DiagramCommandStack(ded));
		return gv;
	}

	protected IMetamodelType getElementType(GenCommonBase genElement) {
		Class clazz = null;
		try {
			clazz = gmfEditorBundle.loadClass(this.myGenDiagram.getElementTypesQualifiedClassName());
		} catch (Exception e) {
			e.printStackTrace();
			fail("ElementTypes class not loaded. " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		String identifier = genElement.getUniqueIdentifier();
		try {
			Object type = clazz.getField(identifier).get(null);
			assert type instanceof IMetamodelType : IMetamodelType.class.getName() + ": metamodel type class required"; //$NON-NLS-1$ 
			return (IMetamodelType) type;
		} catch (NoSuchFieldException e) {
			fail("Metamodel type " + identifier + " is not registered"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (Exception e) {
			e.printStackTrace();
			fail("Can't access metamodel type " + identifier); //$NON-NLS-1$			
		}

		return null;
	}

	protected GenCommonBase getGenElement(MappingEntry mappingEntry) {
		assert transformationMap != null && !transformationMap.isEmpty() : "transformation map not initialized"; //$NON-NLS-1$		
		Object genElement = transformationMap.get(mappingEntry);
		assert genElement != null : "No genmodel element found for mapping entry"; //$NON-NLS-1$
		assert genElement instanceof GenCommonBase : "Invalid genmodel element"; //$NON-NLS-1$
		return (GenCommonBase) genElement;
	}

	protected abstract static class AbstractDiaDefs implements DiaDefSource {
		private final Canvas canvas;
		private final FigureGallery figureGallery;

		protected AbstractDiaDefs() {
			this.canvas = GMFGraphFactory.eINSTANCE.createCanvas();
			figureGallery = GMFGraphFactory.eINSTANCE.createFigureGallery();
			figureGallery.setName("fc1");
			this.canvas.getFigures().add(figureGallery);
			init();
		}

		protected abstract void init();

		public Canvas getCanvas() {
			return canvas;
		}

		public Canvas getCanvasDef() {
			return canvas;
		}

		public Connection getLinkDef() {
			return !canvas.getConnections().isEmpty() ? (Connection) canvas.getConnections().get(0) : null;
		}

		public org.eclipse.gmf.gmfgraph.Node getNodeDef() {
			return !canvas.getNodes().isEmpty() ? (org.eclipse.gmf.gmfgraph.Node) canvas.getNodes().get(0) : null;
		}

		protected Connection createConnection(String name) {
			Connection conn = GMFGraphFactory.eINSTANCE.createConnection();
			conn.setName(name);
			conn.setFigure(GMFGraphFactory.eINSTANCE.createPolylineConnection());
			conn.getFigure().setName("lf1");
			figureGallery.getFigures().add(conn.getFigure());
			canvas.getConnections().add(conn);
			return conn;
		}

		protected org.eclipse.gmf.gmfgraph.Node createNode(String name) {
			org.eclipse.gmf.gmfgraph.Node node = GMFGraphFactory.eINSTANCE.createNode();
			node.setName(name);
			node.setFigure(GMFGraphFactory.eINSTANCE.createEllipse());
			node.getFigure().setName("nf1");
			figureGallery.getFigures().add(node.getFigure());
			canvas.getNodes().add(node);
			return node;
		}
	}

	public static abstract class AbstractMappings implements MapDefSource {
		private EPackage domainModel;

		private Mapping mapping;

		private Canvas canvas;

		protected AbstractMappings(EPackage domainModel, DiaDefSource diaDefSource) {
			this.domainModel = domainModel;
			this.mapping = GMFMapFactory.eINSTANCE.createMapping();
			this.canvas = diaDefSource.getCanvasDef();
			assert canvas != null;

			init();
		}

		public Canvas getMappedCanvas() {
			return canvas;
		}

		protected abstract void init();

		protected CanvasMapping mapCanvas(String domainEClassQName) {
			CanvasMapping canvasMapping = GMFMapFactory.eINSTANCE.createCanvasMapping();
			canvasMapping.setDiagramCanvas(canvas);
			canvasMapping.setDomainModel(domainModel);
			canvasMapping.setDomainMetaElement((EClass) EPath.ECORE.lookup(domainModel, domainEClassQName));
			ToolGroup tg = GMFMapFactory.eINSTANCE.createToolGroup();
			tg.setName("tg1");
			mapping.getToolGroups().add(tg);
			mapping.setDiagram(canvasMapping);
			return canvasMapping;
		}

		protected NodeMapping mapNode(String nodeName, String eClassQName, String containmentFeature) {
			NodeMapping nodeMap = GMFMapFactory.eINSTANCE.createNodeMapping();
			nodeMap.setDiagramNode((org.eclipse.gmf.gmfgraph.Node) EPath.GMFGRAPH.lookup(canvas, nodeName));
			nodeMap.setDomainMetaElement((EClass) EPath.ECORE.lookup(domainModel, eClassQName));
			nodeMap.setContainmentFeature((EReference) EPath.ECORE.lookup(domainModel, containmentFeature));
			nodeMap.setTool(GMFMapFactory.eINSTANCE.createCreationTool());
			nodeMap.getTool().setGroup((ToolGroup) mapping.getToolGroups().get(0));
			mapping.getNodes().add(nodeMap);
			return nodeMap;
		}

		protected LinkMapping mapClassLink(String linkName, String domainEClassQName, String containmentMetaFeature, String linkMetaFeature) {
			LinkMapping linkMap = GMFMapFactory.eINSTANCE.createLinkMapping();
			linkMap.setDiagramLink((Connection) EPath.GMFGRAPH.lookup(canvas, linkName));
			linkMap.setDomainMetaElement((EClass) EPath.ECORE.lookup(domainModel, domainEClassQName));
			linkMap.setContainmentFeature((EReference) EPath.ECORE.lookup(domainModel, containmentMetaFeature));
			linkMap.setLinkMetaFeature((EReference) EPath.ECORE.lookup(domainModel, linkMetaFeature));
			mapping.getLinks().add(linkMap);
			return linkMap;
		}

		protected LinkMapping mapRefLink(String linkName, String linkMetaFeature) {
			LinkMapping linkMap = GMFMapFactory.eINSTANCE.createLinkMapping();
			linkMap.setDiagramLink((Connection) EPath.GMFGRAPH.lookup(canvas, linkName));
			linkMap.setLinkMetaFeature((EReference) EPath.ECORE.lookup(domainModel, linkMetaFeature));
			mapping.getLinks().add(linkMap);
			return linkMap;
		}

		public CanvasMapping getCanvasMapping() {
			return mapping.getDiagram();
		}

		public LinkMapping getLinkMapping() {
			return mapping.getLinks().isEmpty() ? null : (LinkMapping) mapping.getLinks().get(0);
		}

		public Mapping getMapping() {
			return mapping;
		}

		public NodeMapping getNodeMapping() {
			return mapping.getNodes().isEmpty() ? null : (NodeMapping) mapping.getNodes().get(0);
		}
	}

	private class DiaGenSetup implements DiaGenSource {
		private MapDefSource mapDefSource;

		private GenDiagram genDiagram;

		DiaGenSetup(AbstractMappings mappingSource) {
			this.mapDefSource = mappingSource;

			BasicGenModelAccess genModelAccess = new BasicGenModelAccess(mapDefSource.getCanvasMapping().getDomainModel());
			IStatus status = genModelAccess.createDummy();
			Assert.assertTrue("GenModel for transformation has error status", status.isOK()); //$NON-NLS-1$

			Transformer transformer = new Transformer();
			transformer.setEMFGenModel(genModelAccess.model());
			transformer.transform(mapDefSource.getMapping());
			this.genDiagram = transformer.getResult();

			RuntimeDiagramTestBase.this.transformationMap = transformer.mapping2GenNode;
			// call user genmodel customization
			customizeGenModelBeforeGeneration();
		}

		public GenDiagram getGenDiagram() {
			return genDiagram;
		}

		public GenLink getGenLink() {
			return genDiagram.getLinks().isEmpty() ? null : (GenLink) genDiagram.getLinks().get(0);
		}

		public GenNode getGenNode() {
			return genDiagram.getNodes().isEmpty() ? null : (GenNode) genDiagram.getNodes().get(0);
		}

		MapDefSource getMapping() {
			return mapDefSource;
		}
	}

	private static class Transformer extends DiagramGenModelTransformer {
		GenDiagram diagram;

		Adapter adapter;

		Map mapping2GenNode = new HashMap();

		MappingEntry currentMapping;

		Transformer() {
			super(new BasicDiagramRunTimeModelHelper(), new DefaultNamingStrategy());
		}

		public void transform(Mapping m) {
			try {
				super.transform(m);
			} finally {
				if (adapter != null) {
					diagram.eAdapters().remove(adapter);
				}
			}
		}

		protected void process(CanvasMapping cme) {
			super.process(cme);

			this.diagram = getResult();
			this.mapping2GenNode.put(diagram, cme);
			AdapterImpl adapter = new AdapterImpl() {
				public void notifyChanged(Notification msg) {
					if (msg.getEventType() == Notification.ADD) {
						Object newObj = msg.getNewValue();
						if (newObj instanceof GenNode || newObj instanceof GenLink) {
							mapping2GenNode.put(currentMapping, newObj);
						}
					}
				}

				public boolean isAdapterForType(Object type) {
					return true;
				}
			};
			diagram.eAdapters().add(adapter);
		}

		protected void process(LinkMapping lme) {
			currentMapping = lme;
			super.process(lme);
		}

		protected void process(NodeMapping nme) {
			currentMapping = nme;
			super.process(nme);
		}
	}

	private static final class Viewer extends DiagramGraphicalViewer implements IDiagramGraphicalViewer {
		private Viewer() {
		}

		protected void createDefaultRoot() {
			setRootEditPart(new DiagramRootEditPart());
		}

		protected LightweightSystem createLightweightSystem() {
			final UpdateManager NO_MANAGER = new UpdateManager() {
				public void addDirtyRegion(IFigure figure, int x, int y, int w, int h) {
				}

				public void addInvalidFigure(IFigure figure) {
				}

				public void performUpdate() {
				}

				public void performUpdate(Rectangle exposed) {
				}

				public void setGraphicsSource(GraphicsSource gs) {
				}

				public void setRoot(IFigure figure) {
				}
			};

			return new LightweightSystem() {
				{
					setUpdateManager(NO_MANAGER);
				}

				public UpdateManager getUpdateManager() {
					return NO_MANAGER;
				}
			};
		}

		public IDiagramEditDomain getDiagramEditDomain() {
			return (IDiagramEditDomain) super.getEditDomain();
		}

		public List findEditPartsForElement(String elementIdStr, Class editPartClass) {
			return Collections.EMPTY_LIST;
		}

		public void registerEditPartForElement(String elementIdStr, EditPart ep) {
		}

		public void unregisterEditPartForElement(String elementIdStr, EditPart ep) {
		}
	}
}
