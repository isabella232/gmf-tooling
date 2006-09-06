/*
 * Copyright (c) 2005,2006 Borland Software Corporation
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
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.gmfgraph.util.RuntimeFQNSwitch;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.internal.bridge.VisualIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelProducer;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.internal.bridge.genmodel.SpecificDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediatorImpl;
import org.eclipse.gmf.internal.codegen.CodeGenUIPlugin;
import org.eclipse.gmf.internal.codegen.GMFGenConfig;
import org.eclipse.gmf.internal.common.migrate.ModelLoadHelper;
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

/**
 * .gmfmap to .gmfgen
 * @author artem
 */
public class TransformToGenModel implements IObjectActionDelegate {
	private static final String ASK_WARN = "ask_warn";

	private IFile myMapFile;
	private IWorkbenchPart myPart;
	private IFile myDestFile;
	private static final Boolean THERE_IS_NO_SPECIFIC_RT = Boolean.TRUE;

	private ResourceSet myResourceSet;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
	}

	protected ResourceSet getResourceSet() {
		if (myResourceSet == null) {
			myResourceSet = new ResourceSetImpl();
		}
		return myResourceSet;
	}

	protected void forgetResourceSet() {
		myResourceSet = null;
	}

	public void run(IAction action) {
		initDestinationFile();
		if (myDestFile == null) {
			return;
		}
		ModelLoadHelper loadHelper = new ModelLoadHelper(getResourceSet(), getMapModelURI());
		if(!canProcessMappingModel(loadHelper, action)) {			
			return;			
		}		

		final Mapping mapping = (Mapping) loadHelper.getContentsRoot();		
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

		final GenModelDetector gmDetector = new GenModelDetector(myMapFile);
		final IStatus findStatus = gmDetector.find(getShell(), mapping);
		if (findStatus.getSeverity() == IStatus.CANCEL) {
			return;
		}
		GenModel domainGenModel = null;
		if (findStatus.isOK()) {
			domainGenModel = gmDetector.get(getResourceSet());
		}

		final DiagramRunTimeModelHelper drtModelHelper = detectRunTimeModel();

		final ViewmapProducer viewmapProducer = detectViewmapProducer(getShell());
		if (viewmapProducer == null) {
			return;
		}

		final VisualIdentifierDispenserProvider idDispenser = getVisualIdDispenser();
		idDispenser.acquire();

		GenModelProducer t = createGenModelProducer(domainGenModel, drtModelHelper, viewmapProducer, idDispenser.get());

		final Job transformJob = createTransformJob(mapping, action.getText(), t);
		transformJob.schedule();
		if (transformJob.getResult().getSeverity() != IStatus.CANCEL) {
			idDispenser.release();
		}
		forgetResourceSet();
	}

	/**
	 * Job should not be async
	 */
	private Job createTransformJob(final Mapping mapping, String title, final GenModelProducer t) {
		//final ISchedulingRule rule = MultiRule.combine(myMapFile, myDestFile);
		return new Job(title) {
			{
				setUser(true);
				setPriority(SHORT);
				//setRule(rule); //  <crmcsi$8mi$1@www.eclipse.org>
			}

			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask(getName(), 4);
				try {
					GenEditorGenerator genEditor = t.process(mapping, new SubProgressMonitor(monitor, 1));
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
			@SuppressWarnings("unchecked")
			private void save(GenEditorGenerator genBurdern) throws IOException {
				Resource dgmmRes = getResourceSet().createResource(getGenModelURI());
				dgmmRes.getContents().add(genBurdern);				
				dgmmRes.save(getSaveOptions());
			}
			protected Map getSaveOptions() {
				HashMap<String, Object> saveOptions = new HashMap<String, Object>();
				saveOptions.put(XMIResource.OPTION_ENCODING, "UTF-8");
				return saveOptions;
			}
			private void reconcile(GenEditorGenerator genBurdern) {
				GenEditorGenerator old = null;
				Resource resource = null;
				try {
					resource = getResourceSet().getResource(getGenModelURI(), true);
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
		};
	}

	private GenModelProducer createGenModelProducer(GenModel domainGenModel, final DiagramRunTimeModelHelper drtModelHelper, final ViewmapProducer viewmapProducer, final VisualIdentifierDispenser idDespenser) {
		final DiagramGenModelTransformer t = new DiagramGenModelTransformer(drtModelHelper, new GenModelNamingMediatorImpl(), viewmapProducer, idDespenser);
		if (domainGenModel != null) {
			t.setEMFGenModel(domainGenModel);
		}
		return new GenModelProducer() {
			public GenEditorGenerator process(Mapping mapping, IProgressMonitor progress) {
				progress.beginTask(null, 1);
				try {
					t.transform(mapping);
					return t.getResult();
				} finally {
					progress.done();
				}
			}
		};
	}

	/**
	 * Checks if loaded mapping model can be processed further
	 * 
	 * @param loadHelper helper used to load the mapping model
	 * @param action the action in execution
	 * @return <code>true</code> if mapping model is available with OK status or in case of 
	 * 	load problems, user decided to proceed. Returns <code>false</code> otherwise.
	 */
	private boolean canProcessMappingModel(ModelLoadHelper loadHelper, IAction action) {
		if(!loadHelper.getStatus().isOK()) {			
			String[] buttons = new String[] {IDialogConstants.PROCEED_LABEL, IDialogConstants.CANCEL_LABEL };
			int[] buttonIDs = new int[] {IDialogConstants.PROCEED_ID, IDialogConstants.CANCEL_ID };
			
			if(!(loadHelper.getContentsRoot() instanceof Mapping)) {
				// we cannot proceed further as there is no mapping, allow only cancel
				buttons = new String[] { buttons[1] };
				buttonIDs = new int[] { buttonIDs[1] };
			}
			ErrorDialogEx dlg = new ErrorDialogEx(getShell(), action.getText(), 
					CodeGenUIPlugin.getBundleString("transform.err"), 
					loadHelper.getStatus(), buttons, buttonIDs, 0);
			if (dlg.open() == IDialogConstants.CANCEL_ID) {
				return false;
			}
		}
		return true;
	}

	private VisualIdentifierDispenserProvider getVisualIdDispenser() {
		return new VisualIdentifierDispenserProvider(getGenModelURI());
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
	
	private static boolean checkLiteOptionPresent() {
		return Platform.getBundle("org.eclipse.gmf.codegen.lite") != null;
	}

	private DiagramRunTimeModelHelper detectRunTimeModel() {
		DiagramRunTimeModelHelper drtModelHelper = null;
		URI specificRTGenModelURI = decideOnRunTimeModel();
		if (specificRTGenModelURI != null) {
			Resource drtGenModelRes = getResourceSet().getResource(specificRTGenModelURI, true);
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
}
