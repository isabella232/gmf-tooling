/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.osgi.framework.Bundle;

/**
 * TODO DomainModelInstanceSource to separate instantiation from diagram creation and
 * to facilitate testing of domain model instance - not to miss containments and other
 * potential problems in DomainModelSource
 * Simple implementation that creates simple diagram with few elements
 * @author artem
 */
public class RTSetup implements RTSource {

	private Diagram myCanvas;
	private Node myNodeA;
	private Node myNodeB;
	private Edge myLinkByClass;
	private Edge myLinkByRef;
	private Node myNodeACompartment;
	private Node myNodeBCompartment;
	
	private EObject myDiagramElement;


	public RTSetup() {
	}

	public final RTSetup init(Bundle b, DiaGenSource genSource) {
		initDiagramFileContents(new CoolDomainInstanceProducer(b), genSource);
		saveDiagramFile(genSource.getGenDiagram().getEditingDomainID());
		return this;
	}

	public final RTSetup init(DiaGenSource genSource) {
		initDiagramFileContents(new NaiveDomainInstanceProducer(), genSource);
		saveDiagramFile(genSource.getGenDiagram().getEditingDomainID());
		return this;
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	protected void initDiagramFileContents(DomainInstanceProducer instanceProducer, DiaGenSource genSource) {
		myCanvas = NotationFactory.eINSTANCE.createDiagram();
		myDiagramElement = instanceProducer.createInstance(genSource.getGenDiagram().getDomainDiagramElement());
		myCanvas.setElement(myDiagramElement);
		myCanvas.setType(genSource.getGenDiagram().getEditorGen().getModelID());
		
		myNodeA = setupNotationNode(genSource.getNodeA(), instanceProducer);
		List compartments = setupNotationCompartments(myNodeA, genSource.getNodeA());
		if (compartments.size() > 0) {
			myNodeACompartment = (Node) compartments.get(0);
		}
		
		myNodeB = setupNotationNode(genSource.getNodeB(), instanceProducer);
		compartments = setupNotationCompartments(myNodeB, genSource.getNodeB());
		if (compartments.size() > 0) {
			myNodeBCompartment = (Node) compartments.get(0);
		}

		myLinkByClass = NotationFactory.eINSTANCE.createEdge();
		myCanvas.getPersistedEdges().add(myLinkByClass);
		
		//myNode.setVisualID(genSource.getGenNode().getVisualID());
		TypeLinkModelFacet byClassFacet = (TypeLinkModelFacet) genSource.getLinkC().getModelFacet();
		EObject linkElement = instanceProducer.createInstance(byClassFacet.getMetaClass());
		instanceProducer.setFeatureValue(myNodeA.getElement(), linkElement, byClassFacet.getContainmentMetaFeature());
		instanceProducer.setFeatureValue(linkElement, myNodeB.getElement(), byClassFacet.getTargetMetaFeature());
		myLinkByClass.setElement(linkElement);
		myLinkByClass.setType(String.valueOf(genSource.getLinkC().getVisualID()));
		myLinkByClass.setSource(myNodeA);
		myLinkByClass.setTarget(myNodeB);
		setBendpoints(myLinkByClass);
		
		FeatureLinkModelFacet byRefFacet = (FeatureLinkModelFacet) genSource.getLinkD().getModelFacet();
		Assert.assertNotNull(byRefFacet);
		EStructuralFeature metaFeature = byRefFacet.getMetaFeature().getEcoreFeature();
		//The direction of the link is unspecified, could be from A to B or vice versa
		myLinkByRef = NotationFactory.eINSTANCE.createEdge();
		if (myNodeA.getElement().eClass().getEStructuralFeature(metaFeature.getName()) != null) {
			instanceProducer.setFeatureValue(myNodeA.getElement(), myNodeB.getElement(), byRefFacet.getMetaFeature());
			myLinkByRef.setSource(myNodeA);
			myLinkByRef.setTarget(myNodeB);
		} else if (myNodeB.getElement().eClass().getEStructuralFeature(metaFeature.getName()) != null) {
			instanceProducer.setFeatureValue(myNodeB.getElement(), myNodeA.getElement(), byRefFacet.getMetaFeature());
			myLinkByRef.setSource(myNodeB);
			myLinkByRef.setTarget(myNodeA);
		}
		myCanvas.getPersistedEdges().add(myLinkByRef);
		myLinkByRef.setType(String.valueOf(genSource.getLinkD().getVisualID()));
		myLinkByRef.setElement(null);
		setBendpoints(myLinkByRef);
		
		myCanvas.setType(genSource.getGenDiagram().getEditorGen().getDomainGenModel().getModelName());

		/*
		Object nc = diagramElement.eGet(genSource.getGenNode().getContainmentMetaFeature().getEcoreFeature());
		assert nc instanceof EList;
		((EList) nc).add(nodeElement);
		Object lc = nodeElement.eGet(genSource.getGenLink().getContainmentMetaFeature().getEcoreFeature());
		if (lc instanceof EList) {
			((EList) lc).add(linkElement);
		} else {
			nodeElement.eSet(genSource.getGenLink().getContainmentMetaFeature().getEcoreFeature(), linkElement);
		}
		*/
	}
	
	private void setBendpoints(Edge edge){
		edge.setBendpoints(NotationFactory.eINSTANCE.createRelativeBendpoints());
	}
	
	private Node setupNotationNode(GenNode genNode, DomainInstanceProducer instanceProducer){
		Node result = NotationFactory.eINSTANCE.createNode();
		myCanvas.getPersistedChildren().add(result);
		EObject nodeElement = instanceProducer.createInstance(genNode.getDomainMetaClass());
		instanceProducer.setFeatureValue(myDiagramElement, nodeElement, genNode.getModelFacet().getContainmentMetaFeature());
		result.setElement(nodeElement);
		result.setType(String.valueOf(genNode.getVisualID()));

		result.getStyles().add(NotationFactory.eINSTANCE.createShapeStyle());
		Bounds b = NotationFactory.eINSTANCE.createBounds();
		b.setWidth(0);
		b.setHeight(0);
		result.setLayoutConstraint(b);
		
		return result;
	}
	
	private List setupNotationCompartments(Node notationParent, GenNode genParent){
		List compartments = new LinkedList();
		for (Iterator it = genParent.getCompartments().iterator(); it.hasNext();) {
			GenCompartment nextCompartment = (GenCompartment) it.next();
			Node notationCompartment = NotationFactory.eINSTANCE.createNode();	
			notationCompartment.setType(String.valueOf(nextCompartment.getVisualID()));
			notationParent.getTransientChildren().add(notationCompartment);
			Assert.assertTrue(notationParent.getChildren().contains(notationCompartment));
			compartments.add(notationCompartment);
		}
		return compartments;
	}
	
	private void saveDiagramFile(String editingDomainId){
        TransactionalEditingDomain ted = DiagramEditingDomainFactory.getInstance().createEditingDomain();
        ted.setID(editingDomainId);
		ResourceSet rs = ted.getResourceSet();
		URI uri = URI.createURI("uri://fake/z"); //$NON-NLS-1$
		Resource r = rs.getResource(uri, false);
		if (r == null) {
			r = rs.createResource(uri);
		}
		
		final Resource diagramFile = r;
		AbstractEMFOperation operation = new AbstractEMFOperation(ted, "") { //$NON-NLS-1$			
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				diagramFile.getContents().clear();				
				diagramFile.getContents().add(getCanvas());
				diagramFile.getContents().add(getDiagramElement());					
				return Status.OK_STATUS;
			};
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(operation,
					new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
			Assert.fail("Failed to set diagram resource contents"); //$NON-NLS-1$
		}
	}

	public final Diagram getCanvas() {
		return myCanvas;
	}

	public final Node getNodeA() {
		return myNodeA;
	}
	
	public final Node getNodeB() {
		return myNodeB;
	}
	
	public Node getNodeACompartment() {
		Assert.assertNotNull("No compartment for Node A in this genmodel", myNodeACompartment);
		return myNodeACompartment;
	}
	
	public Node getNodeBCompartment() {
		Assert.assertNotNull("No compartment for Node B in this genmodel", myNodeBCompartment);
		return myNodeBCompartment;
	}

	public Edge getLinkByClass() {
		return myLinkByClass;
	}
	
	public Edge getLinkByRef() {
		return myLinkByRef;
	}
	
	protected EObject getDiagramElement(){
		return myDiagramElement;
	}

	protected interface DomainInstanceProducer {
		EObject createInstance(GenClass genClass);
		void setFeatureValue(EObject src, EObject value, GenFeature genFeature);
	}
	
	private static class NaiveDomainInstanceProducer implements DomainInstanceProducer {
		public EObject createInstance(GenClass genClass) {
			return createInstance(genClass.getEcoreClass());
		}

		public void setFeatureValue(EObject src, EObject value, GenFeature genFeature) {
			EStructuralFeature feature = genFeature.getEcoreFeature();
			if (genFeature.isListType()) {
				Collection result = (Collection) src.eGet(feature);
				result.add(value);
			} else {
				src.eSet(feature, value);
			}
		}

		public EObject createInstance(EClass eClass) {
			return eClass.getEPackage().getEFactoryInstance().create(eClass);
		}
	}
	private static class CoolDomainInstanceProducer implements DomainInstanceProducer {
		private final Bundle bundle;
		public EObject createInstance(GenClass genClass) {
			try {
				Class factoryClass = getFactoryClass(genClass);
				Method m = factoryClass.getMethod("create" + genClass.getName(), new Class[0]);
				return (EObject) m.invoke(getInstance(factoryClass), new Object[0]);
			} catch (Exception ex) {
				Assert.fail(ex.getClass().getSimpleName() + ":" + ex.getMessage());
			}
			Assert.fail();
			return null;
		}
		public void setFeatureValue(EObject src, EObject value, GenFeature genFeature) {
			try {
				Class packageClass = getPackageClass(genFeature);
				Method featureAccessor = packageClass.getMethod("get" + genFeature.getFeatureAccessorName(), new Class[0]);
				EStructuralFeature feature = (EStructuralFeature) featureAccessor.invoke(getInstance(packageClass), new Object[0]);
				if (genFeature.isListType()) {
					Collection result = (Collection) src.eGet(feature);
					result.add(value);
				} else {
					src.eSet(feature, value);
				}
			} catch (Exception ex) {
				Assert.fail(ex.getClass().getSimpleName() + ":" + ex.getMessage());
			}
		}
		private Class getFactoryClass(GenClass genClass) throws ClassNotFoundException {
			return bundle.loadClass(genClass.getGenPackage().getQualifiedFactoryInterfaceName());
		}
		private Object getInstance(Class interfaceClass) throws NoSuchFieldException, IllegalAccessException {
			return interfaceClass.getField("eINSTANCE").get(null);
		}
		private Class getPackageClass(GenFeature genFeature) throws ClassNotFoundException {
			return bundle.loadClass(genFeature.getGenPackage().getQualifiedPackageInterfaceName());
		}
		public CoolDomainInstanceProducer(Bundle b) {
			bundle = b;
		}

	}
}