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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.Assert;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet;
import org.eclipse.gmf.runtime.emf.core.edit.MEditingDomain;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.osgi.framework.Bundle;

/**
 * Simple implementation that creates simple diagram with few elements
 * @author artem
 */
public class RTSetup implements RTSource {

	private Diagram myCanvas;
	private Node myNode;
	private Edge myLink;

	public RTSetup() {
	}

	public final RTSetup init(Bundle b, DiaGenSource genSource) {
		return init(new CoolDomainInstanceProducer(b), genSource);
	}

	public final RTSetup init(DiaGenSource genSource) {
		return init(new NaiveDomainInstanceProducer(), genSource);
	}

	/**
	 * @return <code>this</code> for convenience
	 */
	public final RTSetup init(DomainInstanceProducer instanceProducer, DiaGenSource genSource) {
		myCanvas = NotationFactory.eINSTANCE.createDiagram();
		myNode = NotationFactory.eINSTANCE.createNode();
		myLink = NotationFactory.eINSTANCE.createEdge();
		myCanvas.getPersistedChildren().add(myNode);
		myCanvas.getPersistedEdges().add(myLink);

		EObject diagramElement = instanceProducer.createInstance(genSource.getGenDiagram().getDomainDiagramElement());
		myCanvas.setElement(diagramElement);
		EObject nodeElement = instanceProducer.createInstance(genSource.getGenNode().getDomainMetaClass());
		myNode.setElement(nodeElement);
		//myNode.setVisualID(genSource.getGenNode().getVisualID());
		TypeLinkModelFacet mf = (TypeLinkModelFacet) genSource.getGenLink().getModelFacet();
		EObject linkElement = instanceProducer.createInstance(mf.getMetaClass());
		myLink.setElement(linkElement);
		//myLink.setVisualID(genSource.getGenLink().getVisualID());

		myNode.getStyles().add(NotationFactory.eINSTANCE.createShapeStyle());
		final Bounds b = NotationFactory.eINSTANCE.createBounds();
		b.setWidth(0);
		b.setHeight(0);
		myNode.setLayoutConstraint(b);

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
		ResourceSet rs = MEditingDomain.INSTANCE.getResourceSet();
		URI uri = URI.createURI("uri://fake/z");
		Resource r = rs.getResource(uri, false);
		if (r == null) {
			r = rs.createResource(uri);
		} else {
			r.getContents().clear();
		}
		r.getContents().add(getCanvas());

		return this;
	}

	public final Diagram getCanvas() {
		return myCanvas;
	}

	public final Node getNode() {
		return myNode;
	}

	public Edge getLink() {
		return myLink;
	}

	private interface DomainInstanceProducer {
		EObject createInstance(GenClass genClass);
	};
	private static class NaiveDomainInstanceProducer implements DomainInstanceProducer {
		public EObject createInstance(GenClass genClass) {
			return createInstance(genClass.getEcoreClass());
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
				return (EObject) m.invoke(getFactoryInstance(factoryClass), new Object[0]);
			} catch (NoSuchFieldException ex) {
				Assert.fail(ex.getMessage());
			} catch (NoSuchMethodException ex) {
				Assert.fail(ex.getMessage());
			} catch (InvocationTargetException ex) {
				Assert.fail(ex.getMessage());
			} catch (IllegalAccessException ex) {
				Assert.fail(ex.getMessage());
			} catch (ClassNotFoundException ex) {
				Assert.fail(ex.getMessage());
			}
			Assert.fail();
			return null;
		}
		private Class getFactoryClass(GenClass genClass) throws ClassNotFoundException {
			return bundle.loadClass(genClass.getGenPackage().getQualifiedFactoryInterfaceName());
		}
		private Object getFactoryInstance(Class factoryClass) throws NoSuchFieldException, IllegalAccessException {
			return factoryClass.getField("eINSTANCE").get(null);
		}
		public CoolDomainInstanceProducer(Bundle b) {
			bundle = b;
		}
	}
}
