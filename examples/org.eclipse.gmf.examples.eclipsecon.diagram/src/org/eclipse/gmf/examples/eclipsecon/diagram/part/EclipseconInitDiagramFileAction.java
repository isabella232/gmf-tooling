package org.eclipse.gmf.examples.eclipsecon.diagram.part;

import java.io.IOException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gmf.examples.eclipsecon.Conference;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.Handout;
import org.eclipse.gmf.examples.eclipsecon.Schedule;
import org.eclipse.gmf.examples.eclipsecon.Tutorial;

import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconElementTypes;

import org.eclipse.gmf.runtime.diagram.core.services.ViewService;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.emf.core.edit.MRunnable;

import org.eclipse.gmf.runtime.emf.core.util.OperationUtil;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.action.IAction;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;

import org.eclipse.swt.widgets.Shell;

import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import org.eclipse.ui.ide.IDE;

/**
 * @generated
 */
public class EclipseconInitDiagramFileAction implements IObjectActionDelegate,
		IInputValidator {

	/**
	 * @generated
	 */
	private IWorkbenchPart myPart;

	/**
	 * @generated
	 */
	private IFile mySelectedModelFile;

	/**
	 * @generated
	 */
	private IStructuredSelection mySelection;

	/**
	 * @generated
	 */
	private Map myLinkVID2EObjectMap = new HashMap();

	/**
	 * @generated
	 */
	private Map myEObject2NodeMap = new HashMap();

	/**
	 * @generated
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
	}

	/**
	 * @generated
	 */
	private Shell getShell() {
		return myPart.getSite().getShell();
	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		mySelectedModelFile = null;
		mySelection = StructuredSelection.EMPTY;
		action.setEnabled(false);
		if (selection instanceof IStructuredSelection == false
				|| selection.isEmpty()) {
			return;
		}
		mySelection = (IStructuredSelection) selection;
		mySelectedModelFile = (IFile) ((IStructuredSelection) selection)
				.getFirstElement();
		action.setEnabled(true);
	}

	/**
	 * @generated
	 */
	public String isValid(String newText) {
		IStatus status = ResourcesPlugin.getWorkspace().validateName(newText,
				IResource.FILE);
		if (!status.isOK()) {
			return status.getMessage();
		}
		if (mySelectedModelFile
				.getParent()
				.getFile(
						new Path(newText)
								.addFileExtension("editorGen.getDiagramFileExtension()"))
				.exists()) {
			return "File already exists, choose another name";
		}
		return null;
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		NewDiagramFileWizard wizard = new NewDiagramFileWizard();
		IDialogSettings pluginDialogSettings = EclipseconDiagramEditorPlugin
				.getInstance().getDialogSettings();
		IDialogSettings initDiagramFileSettings = pluginDialogSettings
				.getSection("InisDiagramFile"); //$NON-NLS-1$
		if (initDiagramFileSettings == null) {
			initDiagramFileSettings = pluginDialogSettings
					.addNewSection("InisDiagramFile"); //$NON-NLS-1$
		}
		wizard.setDialogSettings(initDiagramFileSettings);
		wizard.setForcePreviousAndNextButtons(false);
		wizard.setWindowTitle("Initialize new Eclipsecon diagram file");

		WizardDialog dialog = new WizardDialog(myPart.getSite().getShell(),
				wizard);
		dialog.create();
		dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x),
				500);
		dialog.open();
	}

	/**
	 * @generated
	 */
	private class NewDiagramFileWizard extends Wizard {

		/**
		 * @generated
		 */
		private WizardNewFileCreationPage myFileCreationPage;

		/**
		 * @generated
		 */
		public void addPages() {
			myFileCreationPage = new WizardNewFileCreationPage(
					"Initialize new Ecore diagram file", mySelection);
			myFileCreationPage.setFileName(mySelectedModelFile
					.getProjectRelativePath().removeFileExtension()
					.addFileExtension("eclipsecon_diagram").lastSegment());
			myFileCreationPage.setTitle("Diagram file");
			myFileCreationPage
					.setDescription("Create new diagram and initialize it using specified Eclipsecon model content");
			addPage(myFileCreationPage);
		}

		/**
		 * @generated
		 */
		public boolean performFinish() {
			final EObject diagramModelObject = load();
			if (diagramModelObject == null) {
				MessageDialog.openError(getShell(), "Error",
						"Failed to load user model");
				return false;
			}

			myFileCreationPage.getFileName();

			OperationUtil.runAsUnchecked(new MRunnable() {

				public Object run() {
					EObject diagram = create(diagramModelObject);
					if (diagram == null) {
						MessageDialog.openError(getShell(), "Error",
								"Failed to create diagram object");
						return null;
					}
					IFile destFile = myFileCreationPage.createNewFile();
					save(destFile.getLocation().toOSString(), diagram);
					try {
						IDE.openEditor(myPart.getSite().getPage(), destFile);
					} catch (PartInitException ex) {
						EclipseconDiagramEditorPlugin.getInstance().logError(
								"Unable to open editor", ex);
					}
					return null;
				}
			});
			return true;
		}

	}

	/**
	 * @generated
	 */
	private EObject load() {
		String resourcePath = mySelectedModelFile.getLocation().toOSString();
		Resource modelResource = ResourceUtil.findResource(resourcePath);
		if (modelResource == null) {
			modelResource = ResourceUtil.create(resourcePath);
		}
		if (!modelResource.isLoaded()) {
			try {
				ResourceUtil.load(modelResource);
			} catch (Exception e) {
				EclipseconDiagramEditorPlugin.getInstance().logError(
						"Unable to load resource: " + resourcePath, e);
				return null;
			}
		}
		return (EObject) modelResource.getContents().get(0);
	}

	/**
	 * @generated
	 */
	private void save(String filePath, EObject canvas) {
		Resource resource = ResourceUtil.create(filePath, null);
		resource.getContents().add(canvas);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException ex) {
			EclipseconDiagramEditorPlugin.getInstance().logError(
					"Save operation failed for: " + filePath, ex);
		}
	}

	/**
	 * @generated
	 */
	private EObject create(EObject diagramModel) {
		int diagramVID = EclipseconVisualIDRegistry.INSTANCE
				.getDiagramVisualID(diagramModel);
		if (diagramVID != 79) {
			return null;
		}
		myLinkVID2EObjectMap.put(new Integer(3001), new LinkedList());
		myLinkVID2EObjectMap.put(new Integer(3002), new LinkedList());
		myLinkVID2EObjectMap.put(new Integer(3003), new LinkedList());
		Diagram diagram = ViewService.createDiagram(diagramModel, "Eclipsecon",
				EclipseconDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		createConference_79Children(diagram, diagramModel);
		createLinks();
		myLinkVID2EObjectMap.clear();
		myEObject2NodeMap.clear();
		return diagram;
	}

	/**
	 * @generated
	 */
	private void createPresenter_1001Children(View viewObject,
			EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createSchedule_1002Children(View viewObject,
			EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((Schedule) modelObject).getSlices().iterator(); values
				.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
					viewObject, nextValue, "");
			if (2001 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null,
						EclipseconDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createTimeSlot_2001Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createTutorial_1003Children(View viewObject,
			EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createResource_1004Children(View viewObject,
			EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createTimeSlot_2001Children(View viewObject,
			EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createConference_79Children(View viewObject,
			EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((Conference) modelObject).getAttendees()
				.iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
					viewObject, nextValue, "");
			if (1001 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null,
						EclipseconDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createPresenter_1001Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((Conference) modelObject).getDays().iterator(); values
				.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
					viewObject, nextValue, "");
			if (1002 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null,
						EclipseconDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createSchedule_1002Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((Conference) modelObject).getTutorials()
				.iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
					viewObject, nextValue, "");
			if (1003 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null,
						EclipseconDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createTutorial_1003Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((Conference) modelObject).getEclipsezilla()
				.iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EclipseconVisualIDRegistry.INSTANCE.getNodeVisualID(
					viewObject, nextValue, "");
			if (1004 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null,
						EclipseconDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createResource_1004Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 *@generated
	 */
	private void storeLinks(EObject container, Diagram diagram) {
		EClass containerMetaclass = container.eClass();
		storeFeatureModelFacetLinks(container, containerMetaclass, diagram);
		storeTypeModelFacetLinks(container, containerMetaclass);
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks(EObject container,
			EClass containerMetaclass) {
		if (-1 != containerMetaclass.getFeatureID(EclipseconPackage.eINSTANCE
				.getTutorial_Handouts())) {
			Object featureValue = ((Tutorial) container).getHandouts();
			for (Iterator values = ((Collection) featureValue).iterator(); values
					.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = EclipseconVisualIDRegistry.INSTANCE
						.getLinkWithClassVisualID(nextValue);
				if (3001 == linkVID) {
					((Collection) myLinkVID2EObjectMap.get(new Integer(3001)))
							.add(nextValue);
				}
			}
		}
	}

	/**
	 *@generated
	 */
	private void storeFeatureModelFacetLinks(EObject container,
			EClass containerMetaclass, Diagram diagram) {
		if (-1 != containerMetaclass.getFeatureID(EclipseconPackage.eINSTANCE
				.getTutorial_Presenters())) {
			((Collection) myLinkVID2EObjectMap.get(new Integer(3002)))
					.add(container);
		}
		if (-1 != containerMetaclass.getFeatureID(EclipseconPackage.eINSTANCE
				.getTutorial_Assigned())) {
			((Collection) myLinkVID2EObjectMap.get(new Integer(3003)))
					.add(container);
		}
	}

	/**
	 * @generated
	 */
	private void createLinks() {
		Collection linkElements;
		linkElements = (Collection) myLinkVID2EObjectMap.get(new Integer(3001));
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			EObject linkElement = (EObject) it.next();
			EObject src = linkElement.eContainer();
			Node srcNode = (Node) myEObject2NodeMap.get(src);
			if (srcNode == null) {
				continue;
			}
			Object structuralFeatureResult = ((Handout) linkElement)
					.getEclipsezilla();
			if (structuralFeatureResult instanceof EObject == false) {
				continue;
			}
			EObject dst = (EObject) structuralFeatureResult;
			Node dstNode = (Node) myEObject2NodeMap.get(dst);
			if (dstNode != null) {
				ViewService.createEdge(srcNode, dstNode, linkElement, null,
						EclipseconDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			}
		}
		linkElements = (Collection) myLinkVID2EObjectMap.get(new Integer(3002));
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			EObject linkElement = (EObject) it.next();
			EObject src = linkElement;
			Node srcNode = (Node) myEObject2NodeMap.get(src);
			if (srcNode == null) {
				continue;
			}
			Object structuralFeatureResult = ((Tutorial) linkElement)
					.getPresenters();
			if (structuralFeatureResult instanceof Collection == false) {
				continue;
			}
			for (Iterator destinations = ((Collection) structuralFeatureResult)
					.iterator(); destinations.hasNext();) {
				EObject dst = (EObject) destinations.next();
				Node dstNode = (Node) myEObject2NodeMap.get(dst);
				if (dstNode != null) {
					Edge edge = (Edge) ViewService.getInstance().createEdge(
							new IAdaptable() {
								public Object getAdapter(Class adapter) {
									if (IElementType.class.equals(adapter)) {
										return EclipseconElementTypes.TutorialPresenters_3002;
									}
									return null;
								}
							},
							srcNode.getDiagram(),
							"",
							ViewUtil.APPEND,
							EclipseconDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
					if (edge != null) {
						edge.setSource(srcNode);
						edge.setTarget(dstNode);
					}
				}
			}
		}
		linkElements = (Collection) myLinkVID2EObjectMap.get(new Integer(3003));
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			EObject linkElement = (EObject) it.next();
			EObject src = linkElement;
			Node srcNode = (Node) myEObject2NodeMap.get(src);
			if (srcNode == null) {
				continue;
			}
			Object structuralFeatureResult = ((Tutorial) linkElement)
					.getAssigned();
			if (structuralFeatureResult instanceof EObject == false) {
				continue;
			}
			EObject dst = (EObject) structuralFeatureResult;
			Node dstNode = (Node) myEObject2NodeMap.get(dst);
			if (dstNode != null) {
				Edge edge = (Edge) ViewService.getInstance().createEdge(
						new IAdaptable() {
							public Object getAdapter(Class adapter) {
								if (IElementType.class.equals(adapter)) {
									return EclipseconElementTypes.TutorialAssigned_3003;
								}
								return null;
							}
						}, srcNode.getDiagram(), "", ViewUtil.APPEND,
						EclipseconDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if (edge != null) {
					edge.setSource(srcNode);
					edge.setTarget(dstNode);
				}
			}
		}
	}

}
