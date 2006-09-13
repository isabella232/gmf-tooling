/*
 * Copyright (c) 2005, 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.popup.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.internal.bridge.NaiveIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.StatefulVisualIdentifierDispencer;
import org.eclipse.gmf.internal.bridge.VisualIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.BasicGenModelAccess;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.FileGenModelAccess;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelAccess;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.internal.bridge.genmodel.SpecificDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediatorImpl;
import org.eclipse.gmf.internal.codegen.CodeGenUIPlugin;
import org.eclipse.gmf.internal.codegen.GMFGenConfig;
import org.eclipse.gmf.internal.common.reconcile.Reconciler;
import org.eclipse.gmf.internal.graphdef.codegen.ui.FigureGeneratorOptionsDialog;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.osgi.framework.Bundle;

/**
 * .gmfmap to .gmfgen
 * @author artem
 */
public class TransformToGenModel implements IObjectActionDelegate {
	private static final String ASK_WARN = "ask_warn";

	private IFile myMapFile;
	private IWorkbenchPart myPart;
	private IFile myDestFile;
	private Map mySaveOptions = null;
	private static final Boolean THERE_IS_NO_SPECIFIC_RT = Boolean.TRUE;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
	}

	public void run(IAction action) {
		initDestinationFile();
		if (myDestFile == null) {
			return;
		}
		final ResourceSet resSet = new ResourceSetImpl();

		Resource mapRes = resSet.getResource(getMapModelURI(), true);
		final Mapping mapping = (Mapping) mapRes.getContents().get(0);

		IStatus mapIsValid = validate(mapping);
		if (mapIsValid.matches(IStatus.CANCEL)) {
			return;
		}
		if (mapIsValid.matches(IStatus.ERROR)) {
			final String[] buttons = new String[] {IDialogConstants.PROCEED_LABEL, IDialogConstants.CANCEL_LABEL };
			final int[] buttonIDs = new int[] {IDialogConstants.PROCEED_ID, IDialogConstants.CANCEL_ID };
			final String msg = CodeGenUIPlugin.getBundleString("transform.err");
			ErrorDialogEx dlg = new ErrorDialogEx(getShell(), action.getText(), msg, mapIsValid, buttons, buttonIDs, 0);
			if (dlg.open() == IDialogConstants.CANCEL_ID) {
				return;
			}
		} else if ((mapIsValid.matches(IStatus.INFO | IStatus.WARNING))) {
			if (!MessageDialogWithToggle.ALWAYS.equals(getPreferences().getString(ASK_WARN))) {
				if (MessageDialogWithToggle.OK != MessageDialogWithToggle.openOkCancelConfirm(getShell(), action.getText(), CodeGenUIPlugin.getBundleString("transform.warn"), CodeGenUIPlugin.getBundleString("transform.neverwarn"), false, getPreferences(), ASK_WARN).getReturnCode()) {
					return;
				}
			}
		}

		final GenModelDetector gmDetector = new GenModelDetector();
		final IStatus findStatus = gmDetector.find(getShell(), mapping);
		if (findStatus.getSeverity() == IStatus.CANCEL) {
			return;
		}
		GenModel domainGenModel = null;
		if (findStatus.isOK()) {
			domainGenModel = gmDetector.get(resSet);
		}

		final DiagramRunTimeModelHelper drtModelHelper = detectRunTimeModel(resSet);

		final ViewmapProducer viewmapProducer = detectViewmapProducer(getShell());
		if (viewmapProducer == null) {
			return;
		}

		final VisualIdentifierDispenser idDespenser = getVisualIdDespenser(resSet);
		//final ISchedulingRule rule = MultiRule.combine(myMapFile, myDestFile);
		final DiagramGenModelTransformer t = new DiagramGenModelTransformer(drtModelHelper, new GenModelNamingMediatorImpl(), viewmapProducer, idDespenser);
		if (domainGenModel != null) {
			t.setEMFGenModel(domainGenModel);
		}

		new Job(action.getText()) {
			{
				setUser(true);
				setPriority(SHORT);
				//setRule(rule); //  <crmcsi$8mi$1@www.eclipse.org>
			}

			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask(getName(), 4);
				try {
					GenEditorGenerator genEditor = transform(mapping);
					monitor.worked(1);
					if (monitor.isCanceled()) {
						return Status.CANCEL_STATUS;
					}
					
					if (CodeGenUIPlugin.needsReconcile()) {
						reconcile(genEditor);
					}
					monitor.worked(1);
					if (monitor.isCanceled()) {
						return Status.CANCEL_STATUS;
					}

					save(genEditor);
					monitor.worked(1);
					if (monitor.isCanceled()) {
						return Status.CANCEL_STATUS;
					}
					
					return validate(genEditor);
				} catch (IOException ex) {
					return CodeGenUIPlugin.createError(ex.getMessage(), ex);
				} catch (IllegalArgumentException ex) {
					return CodeGenUIPlugin.createError(ex.getMessage(), ex);
				} finally {
					monitor.done();
				}
			}
			private GenEditorGenerator transform(Mapping m) {
				t.transform(m);
				return t.getResult();
			}
			private IStatus validate(GenEditorGenerator genBurdern) {
				Diagnostic d = Diagnostician.INSTANCE.validate(genBurdern);
				if (d.getSeverity() == Diagnostic.OK) {
					return Status.OK_STATUS;
				}
				if ((d.getSeverity() & Diagnostic.CANCEL) != 0) {
					return Status.CANCEL_STATUS;
				} else {
					return BasicDiagnostic.toIStatus(d);
				}
			}
			private void save(GenEditorGenerator genBurdern) throws IOException {
				Resource dgmmRes = resSet.createResource(getGenModelURI());
				dgmmRes.getContents().add(genBurdern);				
				dgmmRes.save(getSaveOptions());
				
				if (idDespenser instanceof StatefulVisualIdentifierDispencer) {
					((StatefulVisualIdentifierDispencer) idDespenser).saveState();
				}
			}
			
			private void reconcile(GenEditorGenerator genBurdern) {
				GenEditorGenerator old = null;
				Resource resource = null;
				try {
					resource = resSet.getResource(getGenModelURI(), true);
					List contents = resource.getContents();
					if (!contents.isEmpty() && contents.get(0) instanceof GenEditorGenerator){
						old = (GenEditorGenerator)contents.get(0);
					}
					if (old != null){
						new Reconciler(new GMFGenConfig()).reconcileTree(genBurdern, old);
					}
				} catch (RuntimeException e){
					old = null;
				} finally {
					if (resource != null){
						resource.unload();
					}
				}
			}
		}.schedule();
	}

	private VisualIdentifierDispenser getVisualIdDespenser(ResourceSet resSet) {
		Bundle tracePluginBundle = Platform.getBundle("org.eclipse.gmf.bridge.trace");
		if (tracePluginBundle != null) {
			try {
				Class despenserClass = tracePluginBundle.loadClass("org.eclipse.gmf.internal.bridge.trace.MergingIdentifierDispenser");
				Object dispencer = despenserClass.newInstance();
				if (dispencer instanceof StatefulVisualIdentifierDispencer) {
					StatefulVisualIdentifierDispencer statefulDispencer = (StatefulVisualIdentifierDispencer) dispencer;
					statefulDispencer.loadState(getGenModelURI());
					return statefulDispencer;
				}
			} catch (ClassNotFoundException e) {
				CodeGenUIPlugin.getDefault().getLog().log(CodeGenUIPlugin.createError("MergingIdentifierDispenser was not found in org.eclipse.gmf.bridge.trace bundle", e));
			} catch (InstantiationException e) {
				CodeGenUIPlugin.getDefault().getLog().log(CodeGenUIPlugin.createError("MergingIdentifierDispenser was not instantiated", e));
			} catch (IllegalAccessException e) {
				CodeGenUIPlugin.getDefault().getLog().log(CodeGenUIPlugin.createError("IllegalAccessException while instantiating MergingIdentifierDispenser", e));
			}
		}
		return new NaiveIdentifierDispenser();
	}

	private ViewmapProducer detectViewmapProducer(Shell shell) {
		if (!checkLiteOptionPresent()) {
			MapModeCodeGenStrategy strategy;
			final String msg = "Would you like to use IMapMode?";
			if (MessageDialog.openQuestion(shell, "Create Generator Model", msg)) {
				strategy = new MapModeCodeGenStrategy.RuntimeUnspecifiedMapMode();
			} else {
				strategy = new MapModeCodeGenStrategy.StaticIdentityMapMode();
			}
			return new InnerClassViewmapProducer(new RuntimeFQNSwitch(), strategy);
		}
		FigureGeneratorOptionsDialog dlg = new FigureGeneratorOptionsDialog(shell, "Create Generator Model", true, true);
		if (dlg.open() != IDialogConstants.OK_ID) {
			return null;
		}
		return new InnerClassViewmapProducer(dlg.getFigureQualifiedNameSwitch(), dlg.getMapModeCodeGenStrategy());
	}
	
	private boolean checkLiteOptionPresent() {
		return Platform.getBundle("org.eclipse.gmf.codegen.lite") != null;
	}

	private DiagramRunTimeModelHelper detectRunTimeModel(final ResourceSet resSet) {
		DiagramRunTimeModelHelper drtModelHelper = null;
		URI specificRTGenModelURI = decideOnRunTimeModel();
		if (specificRTGenModelURI != null) {
			Resource drtGenModelRes = resSet.getResource(specificRTGenModelURI, true);
			if (drtGenModelRes != null) {
				GenModel drtGenModel = (GenModel) drtGenModelRes.getContents().get(0);
				drtModelHelper = new SpecificDiagramRunTimeModelHelper(drtGenModel);
			}
		}
		if (drtModelHelper == null) {
			drtModelHelper = new BasicDiagramRunTimeModelHelper();
		}
		return drtModelHelper;
	}

	protected Map getSaveOptions() {
		if (mySaveOptions == null) {
			mySaveOptions = new HashMap();
			mySaveOptions.put(XMIResource.OPTION_ENCODING, "UTF-8");
		}
		return mySaveOptions;
	}

	private IStatus validate(Mapping mapping) {
		return BasicDiagnostic.toIStatus(Diagnostician.INSTANCE.validate(mapping));
	}

	public void selectionChanged(IAction action, ISelection selection) {
		myMapFile = (IFile) ((IStructuredSelection) selection).getFirstElement();
	}

	private void initDestinationFile() {
		myDestFile = null;
		final IPath destPath = myMapFile.getFullPath().removeFileExtension().addFileExtension("gmfgen");
		final IPath destLocation = destPath.removeLastSegments(1);
		final String defFileName = destPath.lastSegment();
		InputDialog dlg = new InputDialog(getShell(), "Target model file", "Please specify name of the file to save diagram genmodel to", defFileName, new IInputValidator() {
			public String isValid(String newText) {
				IStatus s = ResourcesPlugin.getWorkspace().validatePath(destLocation.append(newText).toOSString(), IResource.FILE);
				return s.isOK() ? null : s.getMessage();
			}
		});
		if (dlg.open() != InputDialog.OK) {
			return;
		}
		myDestFile = ResourcesPlugin.getWorkspace().getRoot().getFile(destLocation.append(dlg.getValue()));
	}

	public IFile getGenModelFile() {
		return myDestFile;
	}

	URI getMapModelURI() {
		return URI.createPlatformResourceURI(myMapFile.getFullPath().toString());
	}
	
	URI getGenModelURI() {
		return URI.createPlatformResourceURI(myDestFile.getFullPath().toString());
	}
	
	private Shell getShell() {
		return myPart.getSite().getShell();
	}

	private URI decideOnRunTimeModel() {
		if (THERE_IS_NO_SPECIFIC_RT.booleanValue()) {
			return null;
		}
		IPath p = myMapFile.getFullPath();
		String defValue = p.removeLastSegments(1).append(p.removeFileExtension().lastSegment() + "-drt").addFileExtension("genmodel").toString();
		InputDialog dlg = new InputDialog(getShell(), "Diagram RunTime Model", "Please specify path to genmodel file that describes specific diagram runtime model, or press Cancel if you don't need one", defValue, null);
		if (dlg.open() == InputDialog.OK) {
			return URI.createPlatformResourceURI(dlg.getValue());
		}
		return null;
	}

	private static IPreferenceStore getPreferences() {
		return CodeGenUIPlugin.getDefault().getPreferenceStore();
	}

	private class GenModelDetector {
		private GenModelAccess myGMAccess;

		public IStatus find(Shell shell, Mapping mapping) { 
			HashSet packages = new HashSet();
			for (Iterator it = EcoreUtil.ExternalCrossReferencer.find(mapping).keySet().iterator(); it.hasNext();) {
				Object next = it.next();
				if (next instanceof EClass) {
					packages.add(((EClass) next).getEPackage());
				}
			}
			for (Iterator it = packages.iterator(); it.hasNext();) {
				EPackage next = (EPackage) it.next();
				if (next.getESuperPackage() != null && EcoreUtil.isAncestor(packages, next.getESuperPackage())) {
					it.remove();
				}
			}
			IFile workspaceFile;
			if (packages.isEmpty()) {
				myGMAccess = new GenModelAccess.Adapter(null);
				return Status.OK_STATUS;
			} else if (packages.size() == 1) {
				final EPackage solePack = (EPackage) packages.iterator().next();
				BasicGenModelAccess gma = new BasicGenModelAccess(solePack);
				gma.initDefault();
				if (gma.load(new ResourceSetImpl()).isOK()) {
					gma.unload();
					myGMAccess = gma;
					return Status.OK_STATUS;
				} else {
					workspaceFile = askGenModelFile(shell, "Can't find genmodel for package " + solePack.getName() + "(" + solePack.getNsURI() + ")");
				}
			} else {
				workspaceFile = askGenModelFile(shell, "Need genmodel to cover all referenced domain packages (" + packages.size() + ")");
			}
			if (workspaceFile == null) {
				return Status.CANCEL_STATUS;
			}
			myGMAccess = new FileGenModelAccess(workspaceFile);
			return Status.OK_STATUS;
		}

		private IFile askGenModelFile(Shell shell, String message) {
			ResourceSelectionDialog d = new ResourceSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), message);
			if (ResourceSelectionDialog.OK != d.open()) {
				return null;
			}
			Object[] result = d.getResult();
			if (result == null || result.length != 1 || false == result[0] instanceof IFile) {
				MessageDialog.openError(shell, "GenModel selection", "Needs exactly one .genmodel file");
				return null;
			}
			return (IFile) result[0];
		}

		public GenModel get(ResourceSet resSet) {
			IStatus s = myGMAccess.load(resSet);
			if (!s.isOK()) {
				throw new IllegalStateException(s.getMessage());
			}
			return myGMAccess.model();
		}
	}
}
