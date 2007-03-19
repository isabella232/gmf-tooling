/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup.annotated;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;

/**
 * @author dstadnik
 */
public abstract class AbstractASetup {

	private static boolean SAVE_GENERATED_MODELS = true;

	protected void saveModel(EObject root, String fileExtension) {
		assert fileExtension != null;
		if (!SAVE_GENERATED_MODELS) {
			return;
		}
		ResourceSet rs = new ResourceSetImpl();
		String fileFolder = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		String fileName = "gen" + System.currentTimeMillis() + '.' + fileExtension; //$NON-NLS-1$
		Resource r = rs.createResource(URI.createFileURI(fileFolder + '/' + fileName));
		r.getContents().add(root);
		try {
			r.save(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void validate(EObject obj) {
		Assert.assertNotNull(obj);
		Diagnostic diag = Diagnostician.INSTANCE.validate(obj);
		Assert.assertTrue(diag.toString(), diag.getSeverity() == Diagnostic.OK);
	}

	protected String getName(EModelElement element, String name) {
		if (name != null) {
			return name;
		}
		assert element instanceof ENamedElement : "Name should be specified for unnamed domain element: " + element; //$NON-NLS-1$
		return ((ENamedElement) element).getName();
	}

	protected abstract Iterator<EObject> getAllDomainModelContents();

	protected void processDomainModel() {
		for (Iterator<EObject> contents = getAllDomainModelContents(); contents.hasNext();) {
			EObject next = contents.next();
			if (!(next instanceof EModelElement)) {
				continue;
			}
			EModelElement element = (EModelElement) next;
			List<Parameter> params = getParameters(element);
			for (Parameter param : params) {
				if ("canvas".equals(param.name)) { //$NON-NLS-1$
					processCanvas(element, param.value, params);
				} else if ("node".equals(param.name)) { //$NON-NLS-1$
					processNode(element, param.value, params);
				} else if ("compartment".equals(param.name)) { //$NON-NLS-1$
					processCompartment(element, param.value, params);
				} else if ("link".equals(param.name)) { //$NON-NLS-1$
					processLink(element, param.value, params);
				} else if ("label".equals(param.name)) { //$NON-NLS-1$
					processLabel(element, param.value, params);
				}
			}
		}
	}

	protected void processCanvas(EModelElement element, String name, List<Parameter> params) {
	}

	protected void processNode(EModelElement element, String name, List<Parameter> params) {
	}

	protected void processCompartment(EModelElement element, String name, List<Parameter> params) {
	}

	protected void processLink(EModelElement element, String name, List<Parameter> params) {
	}

	protected void processLabel(EModelElement element, String name, List<Parameter> params) {
	}

	/**
	 * Finds the first reference in type with specified details entry name.
	 */
	protected EReference findReference(EClass type, String aDetailsName) {
		for (EReference ref : type.getEReferences()) {
			List<Parameter> params = getParameters(ref);
			for (Parameter param : params) {
				if (aDetailsName.equals(param.name)) {
					return ref;
				}
			}
		}
		return null;
	}

	/**
	 * Finds reference by qualified name. Qualified name is stored in parameter
	 * with specified name.
	 */
	protected EReference findReferenceByQName(EPackage ePackage, List<Parameter> params, String name) {

		// find qualified ref name
		String qName = null;
		for (Parameter param : params) {
			if (name.equals(param.name)) {
				qName = param.value;
				break;
			}
		}
		if (qName == null) {
			return null;
		}

		// find ref in model
		int dotix = qName.indexOf('.');
		assert dotix > 0 && dotix < qName.length() - 1;
		String className = qName.substring(0, dotix);
		String refName = qName.substring(dotix + 1);
		EClass type = (EClass) ePackage.getEClassifier(className);
		return (EReference) type.getEStructuralFeature(refName);
	}

	/**
	 * Returns list of element parameters extracted from annotations.
	 */
	protected List<Parameter> getParameters(EModelElement element) {
		List<Parameter> params = new ArrayList<Parameter>();
		for (EAnnotation annotation : (List<? extends EAnnotation>) element.getEAnnotations()) {
			if ("gmf".equals(annotation.getSource())) { //$NON-NLS-1$
				for (Map.Entry<String, String> entry : annotation.getDetails()) {
					params.add(new Parameter(entry.getKey(), entry.getValue()));
				}
			}
		}
		return params;
	}

	protected static class Parameter {

		public Parameter(String name, String value) {
			this.name = name;
			this.value = value;
		}

		public String name;

		public String value;
	}
}
