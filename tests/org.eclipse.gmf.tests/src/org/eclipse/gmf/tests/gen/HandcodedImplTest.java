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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer;
import org.eclipse.gmf.codegen.gmfgen.GenAuditRule;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorView;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.Palette;
import org.eclipse.gmf.tests.ConfiguredTestCase;
import org.eclipse.jdt.core.JavaConventions;

/**
 * Tests for handcoded method implementations in GMFGen model
 * @author artem
 */
public class HandcodedImplTest extends ConfiguredTestCase {
	private GenDiagram myGenModel;

	public HandcodedImplTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		// FIXME need complex genmodel with a lot of nodes and links to make tests effective 
		myGenModel = getSetup().getGenModel().getGenDiagram();
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

	public void testPackageNames() {
		GenDiagram genDiagram = myGenModel;
		Set state = new HashSet();

		// package names check
		checkPackageName(state, "PackageNames:editCommands", genDiagram.getEditCommandsPackageName());
		checkPackageName(state, "PackageNames:editParts", genDiagram.getEditPartsPackageName());
		checkPackageName(state, "PackageNames:editPolicies", genDiagram.getEditPoliciesPackageName());
		checkPackageName(state, "GenEditorView:packageName", genDiagram.getEditorGen().getEditor().getPackageName());
		checkPackageName(state, "PackageNames:providers", genDiagram.getProvidersPackageName());
		checkPackageName(state, "PackageNames:notationViewFactories", genDiagram.getNotationViewFactoriesPackageName());

		// coverage check
		for (Iterator classifiers = GMFGenPackage.eINSTANCE.getEClassifiers().iterator(); classifiers.hasNext();) {
			Object next = classifiers.next();
			if (next instanceof EClass) {
				checkPackageNamesCoverage(state, (EClass) next);
			}
		}
	}

	public void testClassNames() {
		GenDiagram genDiagram = myGenModel;
		Set state = new HashSet();
		GenEditorView  genEditor = myGenModel.getEditorGen().getEditor();

		// class names check
		checkClassName(state, "EditPartCandies:ReorientConnectionViewCommand", genDiagram.getReorientConnectionViewCommandClassName(), genDiagram.getReorientConnectionViewCommandQualifiedClassName());
		checkClassName(state, "EditPartCandies:EditPartFactory", genDiagram.getEditPartFactoryClassName(), genDiagram.getEditPartFactoryQualifiedClassName());
		checkClassName(state, "EditPartCandies:BaseExternalNodeLabelEditPart", genDiagram.getBaseExternalNodeLabelEditPartClassName(), genDiagram.getBaseExternalNodeLabelEditPartQualifiedClassName());
		checkClassName(state, "EditPartCandies:BaseItemSemanticEditPolicy", genDiagram.getBaseItemSemanticEditPolicyClassName(), genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName());
		checkClassName(state, "EditPartCandies:BaseGraphicalNodeEditPolicy", genDiagram.getBaseGraphicalNodeEditPolicyClassName(), genDiagram.getBaseGraphicalNodeEditPolicyQualifiedClassName());
		checkClassName(state, "EditPartCandies:ReferenceConnectionEditPolicy", genDiagram.getReferenceConnectionEditPolicyClassName(), genDiagram.getReferenceConnectionEditPolicyQualifiedClassName());
		checkClassName(state, "EditPartCandies:CanonicalEditPolicy", genDiagram.getCanonicalEditPolicyClassName(), genDiagram.getCanonicalEditPolicyQualifiedClassName());
		checkClassName(state, "EditPartCandies:TextSelectionEditPolicy", genDiagram.getTextSelectionEditPolicyClassName(), genDiagram.getTextSelectionEditPolicyQualifiedClassName());
		checkClassName(state, "ProviderClassNames:ElementTypes", genDiagram.getElementTypesClassName(), genDiagram.getElementTypesQualifiedClassName());
		checkClassName(state, "ProviderClassNames:SemanticHints", genDiagram.getSemanticHintsClassName(), genDiagram.getSemanticHintsQualifiedClassName());
		checkClassName(state, "ProviderClassNames:NotationViewProvider", genDiagram.getNotationViewProviderClassName(), genDiagram.getNotationViewProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:EditPartProvider", genDiagram.getEditPartProviderClassName(), genDiagram.getEditPartProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:PaletteProvider", genDiagram.getPaletteProviderClassName(), genDiagram.getPaletteProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:ModelingAssistantProvider", genDiagram.getModelingAssistantProviderClassName(), genDiagram.getModelingAssistantProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:PropertyProvider", genDiagram.getPropertyProviderClassName(), genDiagram.getPropertyProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:IconProvider", genDiagram.getIconProviderClassName(), genDiagram.getIconProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:ParserProvider", genDiagram.getParserProviderClassName(), genDiagram.getParserProviderQualifiedClassName());
		checkClassName(state, "ProviderClassNames:AbstractParser", genDiagram.getAbstractParserClassName(), genDiagram.getAbstractParserQualifiedClassName());
		checkClassName(state, "ProviderClassNames:StructuralFeatureParser", genDiagram.getStructuralFeatureParserClassName(), genDiagram.getStructuralFeatureParserQualifiedClassName());
		checkClassName(state, "ProviderClassNames:StructuralFeaturesParser", genDiagram.getStructuralFeaturesParserClassName(), genDiagram.getStructuralFeaturesParserQualifiedClassName());
		checkClassName(state, "GenEditorView:ActionBarContributor", genEditor.getActionBarContributorClassName(), genEditor.getActionBarContributorQualifiedClassName());
		checkClassName(state, "EditorCandies:CreationWizard", genDiagram.getCreationWizardClassName(), genDiagram.getCreationWizardQualifiedClassName());
		checkClassName(state, "EditorCandies:CreationWizardPage", genDiagram.getCreationWizardPageClassName(), genDiagram.getCreationWizardPageQualifiedClassName());
		checkClassName(state, "EditorCandies:DiagramEditorUtil", genDiagram.getDiagramEditorUtilClassName(), genDiagram.getDiagramEditorUtilQualifiedClassName());
		checkClassName(state, "EditorCandies:DiagramFileCreator", genDiagram.getDiagramFileCreatorClassName(), genDiagram.getDiagramFileCreatorQualifiedClassName());
		checkClassName(state, "EditorCandies:DocumentProvider", genDiagram.getDocumentProviderClassName(), genDiagram.getDocumentProviderQualifiedClassName());
		checkClassName(state, "GenEditorView:className", genEditor.getClassName(), genEditor.getQualifiedClassName());
		checkClassName(state, "EditorCandies:InitDiagramFileAction", genDiagram.getInitDiagramFileActionClassName(), genDiagram.getInitDiagramFileActionQualifiedClassName());
		checkClassName(state, "EditorCandies:MatchingStrategy", genDiagram.getMatchingStrategyClassName(), genDiagram.getMatchingStrategyQualifiedClassName());
		checkClassName(state, "EditorCandies:PreferenceInitializer", genDiagram.getPreferenceInitializerClassName(), genDiagram.getPreferenceInitializerQualifiedClassName());
		checkClassName(state, "EditorCandies:VisualIDRegistry", genDiagram.getVisualIDRegistryClassName(), genDiagram.getVisualIDRegistryQualifiedClassName());
		checkClassName(state, "EditorCandies:LoadResourceAction", genDiagram.getLoadResourceActionClassName(), genDiagram.getLoadResourceActionQualifiedClassName());
		checkClassName(state, "LinkConstraints:LinkCreationConstraints", genDiagram.getLinkCreationConstraintsClassName(), genDiagram.getLinkCreationConstraintsQualifiedClassName());
		checkClassName(state, "Shortcuts:CreateShortcutAction", genDiagram.getCreateShortcutActionClassName(), genDiagram.getCreateShortcutActionQualifiedClassName());
		checkClassName(state, "EditorCandies:ElementChooser", genDiagram.getElementChooserClassName(), genDiagram.getElementChooserQualifiedClassName());
		checkClassName(state, "BatchValidation:ValidationProvider", genDiagram.getValidationProviderClassName(), genDiagram.getValidationProviderQualifiedClassName());
		checkClassName(state, "BatchValidation:MarkerNavigationProvider", genDiagram.getMarkerNavigationProviderClassName(), genDiagram.getMarkerNavigationProviderQualifiedClassName());		
		
		Palette palette = genDiagram.getPalette();
		if (palette != null) {
			checkClassName(state, "Palette:Factory", palette.getFactoryClassName(), palette.getFactoryQualifiedClassName());
		} else {
			state.add("Palette:Factory");
		}
		GenPlugin genPlugin = genDiagram.getEditorGen().getPlugin();
		checkClassName(state, "GenPlugin:Activator", genPlugin.getActivatorClassName(), genPlugin.getActivatorQualifiedClassName());

		for (GenCommonBaseIterator entities = new GenCommonBaseIterator(genDiagram); entities.hasNext();) {
			GenCommonBase nextEntity = entities.nextElement();
			checkClassName(state, "GenCommonBase:EditPart", nextEntity.getEditPartClassName(), nextEntity.getEditPartQualifiedClassName());
			checkClassName(state, "GenCommonBase:ItemSemanticEditPolicy", nextEntity.getItemSemanticEditPolicyClassName(), nextEntity.getItemSemanticEditPolicyQualifiedClassName());
			checkClassName(state, "GenCommonBase:NotationViewFactory", nextEntity.getNotationViewFactoryClassName(), nextEntity.getNotationViewFactoryQualifiedClassName());
			if (nextEntity instanceof GenChildContainer) {
				GenChildContainer genContainer = (GenChildContainer) nextEntity;
				checkClassName(state, "GenChildContainer:CanonicalEditPolicy", genContainer.getCanonicalEditPolicyClassName(), genContainer.getCanonicalEditPolicyQualifiedClassName());
			}
			if (nextEntity instanceof GenNode) {
				GenNode genNode = (GenNode) nextEntity;
				checkClassName(state, "GenNode:GraphicalNodeEditPolicy", genNode.getGraphicalNodeEditPolicyClassName(), genNode.getGraphicalNodeEditPolicyQualifiedClassName());
			}
		}

		GenAuditContainer audits = genDiagram.getEditorGen().getAudits();
		if(audits != null && !audits.getAllAuditRules().isEmpty()) {
			Set checkedContexts = new HashSet();			
			for (Iterator it = audits.getAllAuditRules().iterator(); it.hasNext();) {
				GenAuditRule nextAudit = (GenAuditRule) it.next();
				if(!checkedContexts.contains(nextAudit.getContextSelectorQualifiedClassName())) {
					checkClassName(state, "GenAuditRule:ContextSelector", nextAudit.getContextSelectorClassName(), nextAudit.getContextSelectorQualifiedClassName());
					checkedContexts.add(nextAudit.getContextSelectorQualifiedClassName());					
				}				
			}
		} else {
			state.add("GenAuditRule:ContextSelector");
		}
		
		// test model may not contain them
		state.add("GenCommonBase:EditPart");
		state.add("GenCommonBase:ItemSemanticEditPolicy");
		state.add("GenCommonBase:NotationViewFactory");
		state.add("GenContainer:CanonicalEditPolicy");
		state.add("GenNode:GraphicalNodeEditPolicy");
		// disable explicitly
		state.add("FigureViewmap:Figure");
		state.add("ExternalLabel:TextEditPart");
		state.add("ExternalLabel:TextNotationViewFactory");

		// coverage check
		for (Iterator classifiers = GMFGenPackage.eINSTANCE.getEClassifiers().iterator(); classifiers.hasNext();) {
			Object next = classifiers.next();
			if (next instanceof EClass) {
				checkClassNamesCoverage(state, (EClass) next);
			}
		}
	}

	protected void checkPackageName(Set state, String id, String packageName) {
		IStatus s = JavaConventions.validatePackageName(packageName);
		assertTrue(id + " package name is not valid : " + s.getMessage(), s.getSeverity() != IStatus.ERROR);
		state.add(packageName); // for unique package name check
		state.add(id); // for coverage check
	}

	protected void checkClassName(Set state, String id, String simpleClassName, String qualifiedClassName) {
		IStatus s = JavaConventions.validateJavaTypeName(simpleClassName);
		assertTrue(id + " simple class name is not valid : " + s.getMessage(), s.getSeverity() != IStatus.ERROR);
		s = JavaConventions.validateJavaTypeName(qualifiedClassName);
		assertTrue(id + " qualified class name is not valid : " + s.getMessage(), s.getSeverity() != IStatus.ERROR);
		assertTrue(id + " simple class name does not match the qualified one : '" + simpleClassName + "', '" + qualifiedClassName + "'", qualifiedClassName.endsWith('.' + simpleClassName));
		assertFalse(qualifiedClassName + " is not unique", state.contains(qualifiedClassName));
		state.add(qualifiedClassName); // for unique class name check
		state.add(id); // for coverage check
	}

	protected void checkPackageNamesCoverage(Set state, EClass eClass) {
		final String PN = "PackageName";
		for (Iterator attributes = eClass.getEAttributes().iterator(); attributes.hasNext();) {
			EAttribute attribute = (EAttribute) attributes.next();
			if (attribute.getName().endsWith(PN) && attribute.getName().length() > PN.length()) {
				String packageName = attribute.getName();
				packageName = packageName.substring(0, packageName.length() - PN.length());
				String id = eClass.getName() + ':' + packageName;
				//System.err.println("check " + id);
				assertTrue(id + " package name is not checked", state.contains(id));
			}
		}
	}

	protected void checkClassNamesCoverage(Set state, EClass eClass) {
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
