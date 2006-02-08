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
package org.eclipse.gmf.internal.codegen.popup.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.gmf.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.SpecificDiagramRunTimeModelHelper;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.internal.bridge.naming.gen.GenModelNamingMediatorImpl;
import org.eclipse.gmf.internal.codegen.CodeGenUIPlugin;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
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
			ErrorDialog.openError(getShell(), action.getText(), CodeGenUIPlugin.getBundleString("transform.err"), mapIsValid);
			return;
		}
		if ((mapIsValid.matches(IStatus.INFO | IStatus.WARNING))) {
			if (!MessageDialogWithToggle.ALWAYS.equals(getPreferences().getString(ASK_WARN))) {
				if (MessageDialogWithToggle.OK != MessageDialogWithToggle.openOkCancelConfirm(getShell(), action.getText(), CodeGenUIPlugin.getBundleString("transform.warn"), CodeGenUIPlugin.getBundleString("transform.neverwarn"), false, getPreferences(), ASK_WARN).getReturnCode()) {
					return;
				}
			}
		}

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

		//final ISchedulingRule rule = MultiRule.combine(myMapFile, myDestFile);
		final DiagramGenModelTransformer t = new DiagramGenModelTransformer(drtModelHelper, new GenModelNamingMediatorImpl());

		new Job(action.getText()) {
			{
				//setUser(true); // waiting for regression #115873 to be fixed
				setPriority(SHORT);
				//setRule(rule); //  <crmcsi$8mi$1@www.eclipse.org>
			}

			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask(getName(), 3);
				try {
					GenEditorGenerator genEditor = transform(mapping);
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
					return CodeGenUIPlugin.createError("", ex);
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
			}
		}.schedule();
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
}
