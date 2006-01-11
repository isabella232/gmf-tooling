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
package org.eclipse.gmf.tests.setup;

import java.io.IOException;

import junit.framework.Assert;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.tests.EPath;
import org.eclipse.gmf.tests.Plugin;


public class LinksSessionSetup extends SessionSetup {
	private static String modelURI = "/models/links/links.ecore"; //$NON-NLS-1$
	
	private MapSetup mapDefSource;

	private LinksSessionSetup() {
	}

	public static SessionSetup newInstance() {
		if (factoryClosed) {
			return null;
		}
		return new LinksSessionSetup();
	}

	protected DomainModelSource createDomainModel() {
		DomainModelFileSetup modelSetup = new DomainModelFileSetup() {
			public EClass getDiagramElement() {
				return (EClass) EPath.ECORE.lookup(getModel(), "Root");
			}
			public NodeData getNodeA() {
				EClass n = (EClass) EPath.ECORE.lookup(getModel(), "Container");
				EReference c = (EReference) EPath.ECORE.lookup(getModel(), "Root::elements");
				return new NodeData(n, null, c);
			}
			public NodeData getNodeB() {
				EClass n = (EClass) EPath.ECORE.lookup(getModel(), "Node");
				EReference c = (EReference) EPath.ECORE.lookup(getModel(), "Root::elements");
				return new NodeData(n, null, c);
			}
			public LinkData getLinkAsClass() {
				EClass l = (EClass) EPath.ECORE.lookup(getModel(), "Link");
				EReference t = (EReference) EPath.ECORE.lookup(getModel(), "Link::target");
				EReference c = (EReference) EPath.ECORE.lookup(getModel(), "Container::childNodes");
				return new LinkData(l, t, c);
			}
			public EReference getLinkAsRef() {
				return (EReference) EPath.ECORE.lookup(getModel(), "Container::referenceOnlyLink");
			}
		};
		try {
			modelSetup.init(Plugin.createURI(modelURI)); //$NON-NLS-1$
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Failed to setup the domain model. " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		return modelSetup;
	}
	
	protected DiaGenSource createGenModel() {
		return new DiaGenSetup().init(getMapDefSource());
	}

	/**
	 * XXX perhaps, just move to superclass for uniformity, override createMapDefSource here.
	 */
	public MapDefSource getMapDefSource() {
		if(mapDefSource != null) {
			return mapDefSource;
		}
		
		this.mapDefSource = new MapSetup() {
			protected void setupClassLinkMapping(LinkMapping lme) {
				addCreationConstraints(lme, null, "self.acceptLinkKind = oppositeEnd.acceptLinkKind"); //$NON-NLS-1$
			}
			protected void setupReferenceLinkMapping(LinkMapping lme) {
				addCreationConstraints(lme, 
						"not self.acceptLinkKind.oclIsUndefined()", //$NON-NLS-1$
						"self.acceptLinkKind = oppositeEnd.acceptLinkKind"); //$NON-NLS-1$
			}
		};
		this.mapDefSource.init(new DiaDefSetup(null).init(), getDomainModel(), new ToolDefSetup());

		// TODO - uncomment when multiple elements with the same domainMetaElement do not cause compilation problem		
		//LinkMapping FIRST_CHILD_LINK_MAPPING = mapDefSource.mapClassLink("Link", "Container::firstChildNode", "Link::target"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		// TODO implement as separate test (i.g. just pass different link in MapSource and the same test code
		//LinkMapping MANY_REFERENCE_LINKS_MAPPING = mapDefSource.mapRefLink("Container::manyReferenceOnlyLinks"); //$NON-NLS-1$ //$NON-NLS-2$			
		
		return mapDefSource;
	}
}
