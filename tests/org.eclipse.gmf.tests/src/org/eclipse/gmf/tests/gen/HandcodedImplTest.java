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
package org.eclipse.gmf.tests.gen;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.jdt.core.JavaConventions;

/**
 * Tests for handcoded method implementations in GMFGen model
 * @author artem
 */
public class HandcodedImplTest extends TestCase {
	private GenDiagram myGenModel;

	public HandcodedImplTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		// FIXME need complex genmodel with a lot of nodes and links to make tests effective 
		myGenModel = SessionSetup.getGenModel().getGenDiagram();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testUniqueIdentifier_IsUnique() {
		HashSet allIds = new HashSet(1<<7);
		for (GenCommonBaseIterator it = new GenCommonBaseIterator(myGenModel); it.hasNext();) {
			GenCommonBase next = it.nextElement();
			assertFalse("There should be no two same 'unique' identifiers in GMFGen", allIds.contains(next.getUniqueIdentifier()));
			allIds.add(next.getUniqueIdentifier());
		}
		assertTrue("Test is not valid unless few elements were checked", allIds.size() > 1);
		allIds.clear();
	}

	public void testUniqueIdentifier_IsConstant() {
		LinkedList/*<String>*/ allIdsOrdered = new LinkedList/*<String>*/();
		for (GenCommonBaseIterator it = new GenCommonBaseIterator(myGenModel); it.hasNext();) {
			GenCommonBase next = it.nextElement();
			allIdsOrdered.add(next.getUniqueIdentifier());
		}
		assertTrue("Test is not valid unless there are few elements to check", allIdsOrdered.size() > 1);
		Iterator itSaved = allIdsOrdered.iterator();
		GenCommonBaseIterator it = new GenCommonBaseIterator(myGenModel);
		for (; it.hasNext() && itSaved.hasNext();) {
			GenCommonBase next = it.nextElement();
			String savedID = itSaved.next().toString();
			assertEquals("Subsequent invocations of getUniqueIdentifier produce different results", savedID, next.getUniqueIdentifier());
		}
		assertEquals("Lists are not equal in size", itSaved.hasNext(), it.hasNext());
		allIdsOrdered.clear();
	}

	public void testCompartmentClassNamePrefix() {
		GenCompartment c = GMFGenFactory.eINSTANCE.createGenCompartment();
		IStatus s = JavaConventions.validateJavaTypeName(c.getClassNamePrefix());
		assertTrue("Default prefix (no title set):" + s.getMessage(), s.getSeverity() != IStatus.ERROR);
		c.setTitle("<>?#!. =\"'\n\t\\");
		s = JavaConventions.validateJavaTypeName(c.getClassNamePrefix());
		assertTrue(s.getMessage(), s.getSeverity() != IStatus.ERROR);
	}

	public void testClassNames() {
		GenDiagram genDiagram = myGenModel;
		Set state = new HashSet();

		// class names check
		checkClassName(state, "GenDiagram:EditPartFactory", genDiagram.getEditPartFactoryClassName(), genDiagram.getEditPartFactoryQualifiedClassName());
		checkClassName(state, "GenDiagram:BaseItemSemanticEditPolicy", genDiagram.getBaseItemSemanticEditPolicyClassName(), genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName());
		checkClassName(state, "GenDiagram:ReferenceConnectionEditPolicy", genDiagram.getReferenceConnectionEditPolicyClassName(), genDiagram.getReferenceConnectionEditPolicyQualifiedClassName());
		checkClassName(state, "GenDiagram:ElementTypes", genDiagram.getElementTypesClassName(), genDiagram.getElementTypesQualifiedClassName());
		checkClassName(state, "GenDiagram:SemanticHints", genDiagram.getSemanticHintsClassName(), genDiagram.getSemanticHintsQualifiedClassName());
		checkClassName(state, "GenDiagram:ViewProvider", genDiagram.getViewProviderClassName(), genDiagram.getViewProviderQualifiedClassName());
		checkClassName(state, "GenDiagram:EditPartProvider", genDiagram.getEditPartProviderClassName(), genDiagram.getEditPartProviderQualifiedClassName());
		checkClassName(state, "GenDiagram:MetamodelSupportProvider", genDiagram.getMetamodelSupportProviderClassName(), genDiagram.getMetamodelSupportProviderQualifiedClassName());
		checkClassName(state, "GenDiagram:ModelingAssistantProvider", genDiagram.getModelingAssistantProviderClassName(), genDiagram.getModelingAssistantProviderQualifiedClassName());
		checkClassName(state, "GenDiagram:IconProvider", genDiagram.getIconProviderClassName(), genDiagram.getIconProviderQualifiedClassName());
		checkClassName(state, "GenDiagram:StructuralFeatureParser", genDiagram.getStructuralFeatureParserClassName(), genDiagram.getStructuralFeatureParserQualifiedClassName());
		checkClassName(state, "GenDiagram:ActionBarContributor", genDiagram.getActionBarContributorClassName(), genDiagram.getActionBarContributorQualifiedClassName());
		checkClassName(state, "GenDiagram:CreationWizard", genDiagram.getCreationWizardClassName(), genDiagram.getCreationWizardQualifiedClassName());
		checkClassName(state, "GenDiagram:CreationWizardPage", genDiagram.getCreationWizardPageClassName(), genDiagram.getCreationWizardPageQualifiedClassName());
		checkClassName(state, "GenDiagram:DiagramEditorUtil", genDiagram.getDiagramEditorUtilClassName(), genDiagram.getDiagramEditorUtilQualifiedClassName());
		checkClassName(state, "GenDiagram:DiagramFileCreator", genDiagram.getDiagramFileCreatorClassName(), genDiagram.getDiagramFileCreatorQualifiedClassName());
		checkClassName(state, "GenDiagram:DocumentProvider", genDiagram.getDocumentProviderClassName(), genDiagram.getDocumentProviderQualifiedClassName());
		checkClassName(state, "GenDiagram:Editor", genDiagram.getEditorClassName(), genDiagram.getEditorQualifiedClassName());
		checkClassName(state, "GenDiagram:InitDiagramFileAction", genDiagram.getInitDiagramFileActionClassName(), genDiagram.getInitDiagramFileActionQualifiedClassName());
		checkClassName(state, "GenDiagram:MatchingStrategy", genDiagram.getMatchingStrategyClassName(), genDiagram.getMatchingStrategyQualifiedClassName());
		checkClassName(state, "GenDiagram:Plugin", genDiagram.getPluginClassName(), genDiagram.getPluginQualifiedClassName());
		checkClassName(state, "GenDiagram:PreferenceInitializer", genDiagram.getPreferenceInitializerClassName(), genDiagram.getPreferenceInitializerQualifiedClassName());
		checkClassName(state, "GenDiagram:VisualIDRegistry", genDiagram.getVisualIDRegistryClassName(), genDiagram.getVisualIDRegistryQualifiedClassName());
		Palette palette = genDiagram.getPalette();
		checkClassName(state, "Palette:Factory", palette.getFactoryClassName(), palette.getFactoryQualifiedClassName());
		for (GenCommonBaseIterator entities = new GenCommonBaseIterator(genDiagram); entities.hasNext();) {
			GenCommonBase nextEntity = entities.nextElement();
			checkClassName(state, "GenCommonBase:EditPart", nextEntity.getEditPartClassName(), nextEntity.getEditPartQualifiedClassName());
			checkClassName(state, "GenCommonBase:ItemSemanticEditPolicy", nextEntity.getItemSemanticEditPolicyClassName(), nextEntity.getItemSemanticEditPolicyQualifiedClassName());
			checkClassName(state, "GenCommonBase:NotationViewFactory", nextEntity.getNotationViewFactoryClassName(), nextEntity.getNotationViewFactoryQualifiedClassName());
			if (nextEntity instanceof GenLink) {
				for (Iterator labels = ((GenLink) nextEntity).getLabels().iterator(); labels.hasNext();) {
					GenLinkLabel nextLabel = (GenLinkLabel) labels.next();
					checkClassName(state, "GenLinkLabel:TextNotationViewFactory", nextLabel.getTextNotationViewFactoryClassName(), nextLabel.getTextNotationViewFactoryQualifiedClassName());
				}
			}
		}
		// test model may not contain them
		state.add("GenCommonBase:EditPart");
		state.add("GenCommonBase:ItemSemanticEditPolicy");
		state.add("GenCommonBase:NotationViewFactory");
		state.add("GenLinkLabel:TextNotationViewFactory");
		// disable explicitly
		state.add("FigureViewmap:Figure");

		// coverage check
		for (Iterator classifiers = GMFGenPackage.eINSTANCE.getEClassifiers().iterator(); classifiers.hasNext();) {
			Object next = classifiers.next();
			if (next instanceof EClass) {
				checkCoverage(state, (EClass) next);
			}
		}
	}

	protected void checkClassName(Set state, String className, String simpleClassName, String qualifiedClassName) {
		IStatus s = JavaConventions.validateJavaTypeName(simpleClassName);
		assertTrue(className + " simple class name is not valid : " + s.getMessage(), s.getSeverity() != IStatus.ERROR);
		s = JavaConventions.validateJavaTypeName(qualifiedClassName);
		assertTrue(className + " qualified class name is not valid : " + s.getMessage(), s.getSeverity() != IStatus.ERROR);
		assertTrue(className + " simple class name does not match the qualified one : '" + simpleClassName + "', '" + qualifiedClassName + "'", qualifiedClassName.endsWith('.' + simpleClassName));
		assertFalse(qualifiedClassName + " is not unique", state.contains(qualifiedClassName));
		state.add(qualifiedClassName); // for unique class name check
		state.add(className); // for coverage check
	}

	protected void checkCoverage(Set state, EClass eClass) {
		final String CN = "ClassName";
		final String QCN = "QualifiedClassName";
		final String GET = "get";
		for (Iterator attributes = eClass.getEAttributes().iterator(); attributes.hasNext();) {
			EAttribute attribute = (EAttribute) attributes.next();
			if (attribute.getName().endsWith(QCN) && attribute.getName().length() > QCN.length()) {
				// TODO : attribute with fqn; ignore for now
			} else if (attribute.getName().endsWith(CN) && attribute.getName().length() > CN.length()) {
				String className = attribute.getName();
				className = className.substring(0, className.length() - CN.length());
				className = Character.toUpperCase(className.charAt(0)) + className.substring(1);
				String id = eClass.getName() + ':' + className;
				//System.err.println("check simple " + id);
				assertTrue(id + " simple class name is not checked", state.contains(id));
			}
		}
		for (Iterator operations = eClass.getEOperations().iterator(); operations.hasNext();) {
			EOperation operation = (EOperation) operations.next();
			if (operation.getName().startsWith(GET) && operation.getName().endsWith(QCN)
					&& operation.getName().length() > GET.length() + QCN.length()) {
				String className = operation.getName();
				className = className.substring(GET.length(), className.length() - QCN.length());
				String id = eClass.getName() + ':' + className;
				//System.err.println("check qualified " + id);
				assertTrue(id + " qualified class name is not checked", state.contains(id));
			}
		}
	}

	private static class GenCommonBaseIterator implements Iterator {
		private GenCommonBase nextBase;
		private Iterator wrappedIterator;

		public GenCommonBaseIterator(GenDiagram genDiagram) {
			assert genDiagram != null;
			nextBase = genDiagram;
			wrappedIterator = genDiagram.eAllContents();
		}
		public boolean hasNext() {
			return nextBase != null;
		}
		public GenCommonBase nextElement() {
			if (nextBase == null) {
				throw new NoSuchElementException();
			}
			GenCommonBase rv = nextBase;
			advance();
			return rv;
		}
		public Object next() {
			return nextElement();
		}
		private void advance() {
			nextBase = null;
			while (wrappedIterator.hasNext()) {
				Object next = wrappedIterator.next();
				if (next instanceof GenCommonBase) {
					nextBase = (GenCommonBase) next;
					break;
				}
			}
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
