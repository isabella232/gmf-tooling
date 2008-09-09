/**
 * Copyright (c) 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.util.CodeGenUtil.EclipseUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.SpecializationType;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.TextEmitter;
import org.eclipse.gmf.internal.common.codegen.XpandTextEmitter;
import org.eclipse.gmf.internal.xpand.util.BundleResourceManager;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.gmf.mappings.FeatureValueSpec;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.Language;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.gmf.tests.gef.AbstractDiagramEditorTest;
import org.eclipse.gmf.tests.setup.DiaDefSource;
import org.eclipse.gmf.tests.setup.DomainModelSource;
import org.eclipse.gmf.tests.setup.GenProjectSetup;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.MapDefSource;
import org.eclipse.gmf.tests.setup.MapSetup;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.eclipse.gmf.tests.setup.SessionSetup;
import org.eclipse.gmf.tests.setup.ToolDefSource;
import org.osgi.framework.BundleException;

public class EditHelpersTest extends AbstractDiagramEditorTest {

	private static final String BEFORE_PREFIX = "before";

	private static final String AFTER_PREFIX = "after";

	private static final String MARKER_COMMAND_LABEL = "MarkerCommand";

	public static final SessionSetup setup = new EditHelpersSessionSetup();

	public EditHelpersTest(String name) {
		super(name);
		configure(setup);
	}

	public void testSingleEditHelperAdviceNode() {
		assertTrue(getSetup().getGenModel().getNodeA().getElementType() instanceof MetamodelType);
		Command command = getSetNewTopLeveNodeNameCommand(getSetup().getGenModel().getNodeA(), getSetup().getDomainModel().getNodeA().getNameAttr().getName());
		Collection<IUndoableOperation> allMarkerCommands = getAllMarkerCommands(command);
		Collection<IUndoableOperation> beforeCommands = getBeforeCommands(allMarkerCommands);
		Collection<IUndoableOperation> afterCommands = getAfterCommands(allMarkerCommands);
		// One before and one after command should be associated with this
		// element type
		assertTrue(beforeCommands.size() == 1);
		assertTrue(getEditHelperVisualID(beforeCommands.iterator().next()) == getSetup().getGenModel().getNodeA().getVisualID());
		assertTrue(afterCommands.size() == 1);
		assertTrue(getEditHelperVisualID(afterCommands.iterator().next()) == getSetup().getGenModel().getNodeA().getVisualID());
	}

	public void testTwoEditHelperAdvicesNode() {
		assertTrue(getSetup().getGenModel().getNodeB().getElementType() instanceof SpecializationType);
		Command command = getSetNewTopLeveNodeNameCommand(getSetup().getGenModel().getNodeB(), getSetup().getDomainModel().getNodeB().getNameAttr().getName());
		Collection<IUndoableOperation> allMarkerCommands = getAllMarkerCommands(command);
		Collection<IUndoableOperation> beforeCommands = getBeforeCommands(allMarkerCommands);
		Collection<IUndoableOperation> afterCommands = getAfterCommands(allMarkerCommands);
		// Two before and two after commands should be associated with this
		// element type
		assertTrue(beforeCommands.size() == 2);
		assertTrue(hasCommand(beforeCommands, getSetup().getGenModel().getNodeA().getVisualID()));
		assertTrue(hasCommand(beforeCommands, getSetup().getGenModel().getNodeB().getVisualID()));

		assertTrue(afterCommands.size() == 2);
		assertTrue(hasCommand(afterCommands, getSetup().getGenModel().getNodeA().getVisualID()));
		assertTrue(hasCommand(afterCommands, getSetup().getGenModel().getNodeB().getVisualID()));
	}

	private boolean hasCommand(Collection<IUndoableOperation> beforeCommands, int visualID) {
		for (IUndoableOperation operation : beforeCommands) {
			if (getEditHelperVisualID(operation) == visualID) {
				return true;
			}
		}
		return false;
	}

	private Command getSetNewTopLeveNodeNameCommand(GenNode genNode, String nameAttribute) {
		Node node = createNode(genNode, getDiagram());
		assertNotNull(node);
		EditPart nodeEditPart = getViewerConfiguration().findEditPart(node);
		assertNotNull(nodeEditPart);
		EObject nodeElement = node.getElement();
		SetRequest setReq = new SetRequest(nodeElement, nodeElement.eClass().getEStructuralFeature(nameAttribute), "newName");
		Command command = nodeEditPart.getCommand(new EditCommandRequestWrapper(setReq));
		assertNotNull(command);
		assertTrue(command.canExecute());
		return command;
	}

	private Collection<IUndoableOperation> getAllMarkerCommands(Command command) {
		if (command instanceof CompoundCommand) {
			Collection<IUndoableOperation> result = new ArrayList<IUndoableOperation>();
			for (Object object : ((CompoundCommand) command).getCommands()) {
				result.addAll(getAllMarkerCommands((Command) object));
			}
			return result;
		}
		if (command instanceof ICommandProxy) {
			ICommandProxy commandProxy = (ICommandProxy) command;
			return getAllMarkerCommands(commandProxy.getICommand());
		}
		return Collections.emptyList();
	}

	private Collection<IUndoableOperation> getAllMarkerCommands(IUndoableOperation operation) {
		if (operation instanceof ICompositeCommand) {
			ICompositeCommand compositeCommand = (ICompositeCommand) operation;
			Collection<IUndoableOperation> result = new ArrayList<IUndoableOperation>();
			for (Iterator<?> it = compositeCommand.iterator(); it.hasNext();) {
				result.addAll(getAllMarkerCommands((IUndoableOperation) it.next()));
			}
			return result;
		}
		if (isMarkerCommand(operation)) {
			return Collections.singletonList(operation);
		}
		return Collections.emptyList();
	}

	private boolean isMarkerCommand(IUndoableOperation operation) {
		String label = operation.getLabel();
		return label != null && label.indexOf(MARKER_COMMAND_LABEL) > -1;
	}

	private Collection<IUndoableOperation> getBeforeCommands(Collection<IUndoableOperation> markerCommands) {
		Collection<IUndoableOperation> result = new ArrayList<IUndoableOperation>();
		for (IUndoableOperation command : markerCommands) {
			if (isBeforeMarkerCommand(command)) {
				result.add(command);
			}
		}
		return result;
	}

	private Collection<IUndoableOperation> getAfterCommands(Collection<IUndoableOperation> markerCommands) {
		Collection<IUndoableOperation> result = new ArrayList<IUndoableOperation>();
		for (IUndoableOperation command : markerCommands) {
			if (isAfterMarkerCommand(command)) {
				result.add(command);
			}
		}
		return result;
	}

	private boolean isBeforeMarkerCommand(IUndoableOperation operation) {
		assertTrue("Should be marker operation", isMarkerCommand(operation));
		String label = operation.getLabel();
		return BEFORE_PREFIX.equals(label.substring(0, label.indexOf(MARKER_COMMAND_LABEL)));
	}

	private boolean isAfterMarkerCommand(IUndoableOperation operation) {
		assertTrue("Should be marker operation", isMarkerCommand(operation));
		String label = operation.getLabel();
		return AFTER_PREFIX.equals(label.substring(0, label.indexOf(MARKER_COMMAND_LABEL)));
	}

	private int getEditHelperVisualID(IUndoableOperation operation) {
		assertTrue("Should be marker operation", isMarkerCommand(operation));
		String label = operation.getLabel();
		return Integer.valueOf(label.substring(label.indexOf(MARKER_COMMAND_LABEL) + MARKER_COMMAND_LABEL.length()));
	}

	private static final class EditHelpersSessionSetup extends SessionSetup {

		private EditHelpersSessionSetup() {
			super(new RuntimeBasedGeneratorConfiguration());
		}

		@Override
		protected DomainModelSource createDomainModel() {
			return new EditHelpersModelSource();
		}

		@Override
		protected GenProjectSetup createGenProject() throws BundleException, Exception {
			return new EditHelpersProjectSetup(getGeneratorConfiguration()).init(getGenModel());
		}

		@Override
		public MapDefSource createMapModel() {
			return new EditHelpersMapSetup().init(getGraphDefModel(), getDomainModel(), getToolDefModel());
		}
	}

	private static final class EditHelpersMapSetup extends MapSetup {

		@Override
		public MapSetup init(DiaDefSource ddSource, DomainModelSource domainSource, ToolDefSource toolDef) {
			super.init(ddSource, domainSource, toolDef);
			addConstraint(getNodeA(), "nodeName2.oclIsUndefined()");
			addNameInitializer(getNodeA(), domainSource.getNodeA().getNameAttr(), "'name'");
			addConstraint(getNodeB(), "nodeName1.oclIsUndefined()");
			addNameInitializer(getNodeB(), domainSource.getNodeB().getNameAttr(), "'name'");
			return this;
		}

		private void addConstraint(NodeMapping node, String body) {
			node.setDomainSpecialization(GMFMapFactory.eINSTANCE.createConstraint());
			node.getDomainSpecialization().setLanguage(Language.OCL_LITERAL);
			node.getDomainSpecialization().setBody(body);
		}

		private void addNameInitializer(NodeMapping node, EStructuralFeature feature, String value) {
			FeatureSeqInitializer root = GMFMapFactory.eINSTANCE.createFeatureSeqInitializer();
			node.setDomainInitializer(root);
			FeatureValueSpec nameSpecification = GMFMapFactory.eINSTANCE.createFeatureValueSpec();
			root.getInitializers().add(nameSpecification);
			nameSpecification.setFeature(feature);
			Constraint valueExpr = GMFMapFactory.eINSTANCE.createConstraint();
			nameSpecification.setValue(valueExpr);
			valueExpr.setBody(value);
			valueExpr.setLanguage(Language.OCL_LITERAL);
		}

	}

	private static final class EditHelpersProjectSetup extends GenProjectSetup {

		private String myBundleName;

		private BundleResourceManager myResourceManager;

		private EditHelpersProjectSetup(GeneratorConfiguration generatorFactory) {
			super(generatorFactory);
			URL templatesURL = Plugin.getBundleContext().getBundle().getEntry("templates/edithelpers");
			myResourceManager = new BundleResourceManager(templatesURL);
		}

		@Override
		protected void generateDiagramPrerequisites(GenDiagram d) throws Exception {
			super.generateDiagramPrerequisites(d);
			generateEditHelpersProject(d);
		}

		private void generateEditHelpersProject(GenDiagram d) {
			myBundleName = Utils.createUniquePluginID() + ".edithelpers";
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(myBundleName);
			final Path srcPath = new Path('/' + project.getName() + "/src"); //$NON-NLS-1$
			final int style = Generator.EMF_PLUGIN_PROJECT_STYLE;
			final List<?> pluginVariables = null;
			Generator.createEMFProject(srcPath, null, Collections.<IProject> emptyList(), new NullProgressMonitor(), style, pluginVariables);
			createManifestMF();
			for (GenTopLevelNode node : d.getTopLevelNodes()) {
				if (node.getElementType() == null) {
					continue;
				}
				createEditHelper(node.getElementType());
			}
			createPluginXML(d);
			projectsToInit.add(myBundleName);
		}

		public void createManifestMF() {
			XpandTextEmitter emiter = new XpandTextEmitter(myResourceManager, "manifest::main", getClass().getClassLoader(), null);
			doGenerateFile(emiter, new Path("/" + myBundleName + "/META-INF/MANIFEST.MF"), myBundleName);
		}

		public void createEditHelper(ElementType elementType) {
			String className;
			if (elementType instanceof MetamodelType) {
				className = ((MetamodelType) elementType).getEditHelperClassName() + "ExternalAdvice";
			} else if (elementType instanceof SpecializationType) {
				className = ((SpecializationType) elementType).getEditHelperAdviceClassName() + "ExternalAdvice";
			} else {
				return;
			}
			XpandTextEmitter emiter = new XpandTextEmitter(myResourceManager, "edithelper::main", getClass().getClassLoader(), null);
			doGenerateFile(emiter, new Path("/" + myBundleName + "/src/" + className + ".java"), elementType);
		}

		public void createPluginXML(GenDiagram d) {
			XpandTextEmitter emiter = new XpandTextEmitter(myResourceManager, "plugin::main", getClass().getClassLoader(), null);
			doGenerateFile(emiter, new Path("/" + myBundleName + "/plugin.xml"), d);
		}

		private void doGenerateFile(TextEmitter emitter, IPath filePath, Object... param) {
			try {
				IPath containerPath = filePath.removeLastSegments(1);
				EclipseUtil.findOrCreateContainer(containerPath, false, (IPath) null, new NullProgressMonitor());
				String genText = emitter.generate(new NullProgressMonitor(), param);
				IFile f = ResourcesPlugin.getWorkspace().getRoot().getFile(filePath);
				f.create(new ByteArrayInputStream(genText.getBytes(f.getCharset())), true, new NullProgressMonitor());
			} catch (InvocationTargetException ex) {
				fail(ex.getMessage());
			} catch (UnexpectedBehaviourException ex) {
				fail(ex.getMessage());
			} catch (CoreException ex) {
				fail(ex.getMessage());
			} catch (UnsupportedEncodingException ex) {
				fail(ex.getMessage());
			} catch (InterruptedException ex) {
				fail(ex.getMessage());
			}
		}
	}

	private static final class EditHelpersModelSource implements DomainModelSource {

		private EClass myDiagramElement;

		private EPackage myPackage;

		private NodeData myNode1;

		private LinkData myClassLink;

		private NodeData myNode2;

		private EReference myRefLink;
		{
			myPackage = EcoreFactory.eINSTANCE.createEPackage();
			myPackage.setName("eh");
			myPackage.setNsPrefix("sampleEH");
			Calendar c = Calendar.getInstance();
			myPackage.setNsURI("uri://eclipse/gmf/tests/sample/eh/" + c.get(Calendar.HOUR_OF_DAY) + '/' + c.get(Calendar.MINUTE) + '/');

			myDiagramElement = EcoreFactory.eINSTANCE.createEClass();
			myDiagramElement.setName("DiagramElement");
			myPackage.getEClassifiers().add(myDiagramElement);

			EClass node = EcoreFactory.eINSTANCE.createEClass();
			node.setName("Node");
			myPackage.getEClassifiers().add(node);
			EAttribute node1Name = EcoreFactory.eINSTANCE.createEAttribute();
			node1Name.setName("nodeName1");
			node1Name.setEType(EcorePackage.eINSTANCE.getEString());
			node.getEStructuralFeatures().add(node1Name);
			EAttribute node2Name = EcoreFactory.eINSTANCE.createEAttribute();
			node2Name.setName("nodeName2");
			node2Name.setEType(EcorePackage.eINSTANCE.getEString());
			node.getEStructuralFeatures().add(node2Name);

			EReference nodeContainment = EcoreFactory.eINSTANCE.createEReference();
			nodeContainment.setName("nodeContainment");
			nodeContainment.setContainment(true);
			nodeContainment.setUpperBound(-1);
			nodeContainment.setEType(node);
			myDiagramElement.getEStructuralFeatures().add(nodeContainment);

			EClass classLink = EcoreFactory.eINSTANCE.createEClass();
			classLink.setName("Link");
			myPackage.getEClassifiers().add(classLink);

			EReference linkContainment = EcoreFactory.eINSTANCE.createEReference();
			linkContainment.setName("linkContainment");
			linkContainment.setEType(classLink);
			linkContainment.setUpperBound(-1);
			linkContainment.setContainment(true);
			node.getEStructuralFeatures().add(linkContainment);

			EReference linkTarget = EcoreFactory.eINSTANCE.createEReference();
			linkTarget.setName("target");
			linkTarget.setEType(node);
			linkTarget.setUpperBound(1);
			classLink.getEStructuralFeatures().add(linkTarget);

			myRefLink = EcoreFactory.eINSTANCE.createEReference();
			myRefLink.setName("refLink");
			myRefLink.setEType(node);
			myRefLink.setUpperBound(-1);
			node.getEStructuralFeatures().add(myRefLink);

			new ResourceImpl(URI.createURI("uri://org.eclipse.gmf.eh/tests/DomainModelSetup")).getContents().add(myPackage);

			myNode1 = new NodeData(node, node1Name, nodeContainment);
			myNode2 = new NodeData(node, node2Name, nodeContainment);
			myClassLink = new LinkData(classLink, linkTarget, linkContainment);
		}

		public EClass getDiagramElement() {
			return myDiagramElement;
		}

		public LinkData getLinkAsClass() {
			return myClassLink;
		}

		public EReference getLinkAsRef() {
			return myRefLink;
		}

		public EPackage getModel() {
			return myPackage;
		}

		public NodeData getNodeA() {
			return myNode1;
		}

		public NodeData getNodeB() {
			return myNode2;
		}
	}

}
