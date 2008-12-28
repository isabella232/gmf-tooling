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
package org.eclipse.gmf.internal.xpand.migration.ui;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.gmf.internal.xpand.RootManager;
import org.eclipse.gmf.internal.xpand.build.OawBuilder;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.migration.ExpressionMigrationFacade;
import org.eclipse.gmf.internal.xpand.migration.MigrationException;
import org.eclipse.gmf.internal.xpand.util.OawMarkerManager;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

public class MigrateXpandProject extends WorkspaceModifyOperation implements IObjectActionDelegate {

	public static final String MIGRATED_ROOT_EXTENSION = "migrated";
	
	private static final String PLUGIN_CLOSING_TAG = "</plugin>";

	private static final String PLUGIN_OPENNING_TAG = "<plugin>";

	private static final String LF = ExpressionMigrationFacade.LF;

	private static final String PLUGIN_XML_CHARSET = "UTF8";

	private static final String PLUGIN_XML_FILE_NAME = "plugin.xml";

	private static final int BIG_NUMBER = 100;

	private static final String NATIVE_EXTENSIONS_SRC_FOLDER = ".qvtlib";

	private static final String NEW_BUILDER_ID = "org.eclipse.gmf.xpand.xpandBuilder";
	
	private static final String QVT_BUILDER_ID = "org.eclipse.m2m.qvt.oml.QvtBuilder";
	
	private static final String QVT_BUIDLER_SRC_CONTAINER_ARG = "src_container";
	
	private static final String TRANSFORMATION_NATURE_ID = "org.eclipse.m2m.qvt.oml.project.TransformationNature";

	private IWorkbenchPart workbenchPart;

	private IJavaProject selectedJavaProject;

	private RootManager rootManager;

	private static IProgressMonitor createSubProgressMonitor(IProgressMonitor monitor, String taskName, int numberOfTicks) throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException("Process was canceled");
		}
		SubProgressMonitor spm = new SubProgressMonitor(monitor, numberOfTicks);
		if (taskName != null) {
			spm.setTaskName(taskName);
		}
		return spm;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		workbenchPart = targetPart;
	}

	public void run(IAction action) {
		try {
			new ProgressMonitorDialog(getShell()).run(true, true, this);
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			if (cause instanceof XpandResourceMigrationException) {
				reportMigrationException((XpandResourceMigrationException) cause);
			} else if (cause instanceof UnsupportedEncodingException) {
				showError("Unsupported encoding", "Specified encoding \"" + MigrationVisitor.CHARSET + "\" is not supported by the platform: " + cause.getMessage());
			} else if (cause != null) {
				String message = cause.getMessage();
				if (message == null || message.length() == 0) {
					final CharArrayWriter writer = new CharArrayWriter();
					final int[] lineCounter = new int[] {0};
					final String[] messageContainer = new String[] {null};
					cause.printStackTrace(new PrintWriter(writer) {
						public void println() {
							lineCounter[0] = lineCounter[0] + 1;
							if (lineCounter[0] == 6) {
								messageContainer[0] = new String(writer.toCharArray());			
							}
							super.println();
						};
					});
					writer.close();
					message = messageContainer[0] == null ? new String(writer.toCharArray()) : messageContainer[0];
				}
				showError("Exception", message);
			} else {
				showError("Invocation target exception", e.getMessage());
			}
		} catch (InterruptedException e) {
			// Cancel pressed
		}
	}

	private void reportMigrationException(XpandResourceMigrationException ex) {
		MigrationException migrationException = ex.getMigrationException();
		StringBuilder sb = new StringBuilder(ex.getTemplateFile().getProjectRelativePath().toString());
		sb.append(" migration error\n");
		switch (migrationException.getType()) {
		case ANALYZATION_PROBLEMS:
			sb.append("Following analyzation problems present:\n\n");
			for (AnalysationIssue issue : migrationException.getIssues()) {
				sb.append(issue.toString());
				sb.append("\n");
			}
			showError("Unable to load xtend resource", sb.toString());
			return;
		default:
			showError("Migration exception", sb.append(migrationException.getMessage()).toString());
		}
	}

	@Override
	protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		monitor.setTaskName("Migrating Xpand project");
		List<IFolder> xpandRoots = rootManager.getXpandRootFolders();
		monitor.beginTask("Migrating Xpand project", xpandRoots.size() + BIG_NUMBER * xpandRoots.size() + 3);
		int totalNumberOfSteps = 0;
		for (IFolder rootFolder : xpandRoots) {
			// each root migration requires two additional steps
			totalNumberOfSteps += 2 + getNumberOfSteps(rootFolder, createSubProgressMonitor(monitor, "Counting xpand resources in: " + rootFolder.getName(), 1));
		}
		IProgressMonitor subMonitor = createSubProgressMonitor(monitor, "Migrating all available xpand root folders", BIG_NUMBER * xpandRoots.size());
		subMonitor.beginTask("Migrating all available xpand root folders", totalNumberOfSteps);
		List<CharSequence> nativeLibraryDeclarations = new ArrayList<CharSequence>();
		for (IFolder rootFolder : xpandRoots) {
			migrateXpandRoot(rootFolder, nativeLibraryDeclarations, subMonitor);
		}
		registerNativeLibraries(nativeLibraryDeclarations, createSubProgressMonitor(monitor, "Registering native libraries", 1));
		switchToNewXpandBuilder(createSubProgressMonitor(monitor, "Registering new Xpand builder for the project", 1));
		try {
			rootManager.saveRoots(createSubProgressMonitor(monitor, "Saving modified Xpand roots information", 1));
		} catch (UnsupportedEncodingException e) {
			throw new InvocationTargetException(e);
		}
	}

	private void switchToNewXpandBuilder(IProgressMonitor monitor) throws CoreException, InterruptedException {
		monitor.beginTask("Registering new Xpand builder for the project", 2);
		IProjectDescription pd = selectedJavaProject.getProject().getDescription();
		ArrayList<ICommand> newBuildCommands = new ArrayList<ICommand>();
		ICommand[] buildCommands = pd.getBuildSpec();
		boolean addNewXpandBuilder = true;
		boolean addQVTBuilder = true;
		for (int i = 0; i < buildCommands.length; i++) {
			String builderName = buildCommands[i].getBuilderName();
			if (OawBuilder.getBUILDER_ID().equals(builderName)) {
				continue;
			}
			if (NEW_BUILDER_ID.equals(builderName)) {
				addNewXpandBuilder = false;
			}
			if (QVT_BUILDER_ID.equals(builderName)) {
				addQVTBuilder = false;
			}
			newBuildCommands.add(buildCommands[i]);
		}
		if (addQVTBuilder) {
			ICommand newCommand = pd.newCommand();
			newCommand.setBuilderName(QVT_BUILDER_ID);
			if (rootManager.getXpandRootFolders().size() > 0) {
				Map arguments = newCommand.getArguments();
				if (arguments == null) {
					arguments = new HashMap();
				}
				IFolder mainXpandRootFolder = rootManager.getXpandRootFolders().get(0);
				arguments.put(QVT_BUIDLER_SRC_CONTAINER_ARG, mainXpandRootFolder instanceof IProject ? "/" : mainXpandRootFolder.getProjectRelativePath().toString());
				newCommand.setArguments(arguments);
			}
			newBuildCommands.add(newCommand);
		}
		if (addNewXpandBuilder) {
			ICommand newCommand = pd.newCommand();
			newCommand.setBuilderName(NEW_BUILDER_ID);
			newBuildCommands.add(newCommand);
		}
		pd.setBuildSpec(newBuildCommands.toArray(new ICommand[newBuildCommands.size()]));
		
		ArrayList<String> newNatureIDs = new ArrayList<String>(Arrays.asList(pd.getNatureIds()));
		if (!newNatureIDs.contains(TRANSFORMATION_NATURE_ID)) {
			newNatureIDs.add(TRANSFORMATION_NATURE_ID);
			pd.setNatureIds(newNatureIDs.toArray(new String[newNatureIDs.size()]));
		}
		
		OawMarkerManager.deleteMarkers(selectedJavaProject.getProject());
		monitor.worked(1);
		selectedJavaProject.getProject().setDescription(pd, createSubProgressMonitor(monitor, "Saving modified project description", 1));
	}

	private void registerNativeLibraries(List<CharSequence> nativeLibraryDeclarations, IProgressMonitor progressMonitor) throws CoreException, InvocationTargetException, InterruptedException {
		if (nativeLibraryDeclarations.size() == 0) {
			progressMonitor.done();
			return;
		}
		progressMonitor.beginTask("Registering native libraries", 2);
		IFile pluginXml = selectedJavaProject.getProject().getFile(PLUGIN_XML_FILE_NAME);
		StringBuilder pluginXmlContent = new StringBuilder();
		int insertPosition;
		if (pluginXml.exists()) {
			InputStream is = new BufferedInputStream(pluginXml.getContents());
			try {
				for (int ch = is.read(); ch != -1; ch = is.read()) {
					if (progressMonitor.isCanceled()) {
						throw new InterruptedException();
					}
					pluginXmlContent.append((char) ch);
				}
			} catch (IOException e) {
				throw new InvocationTargetException(e);
			}
			insertPosition = pluginXmlContent.lastIndexOf(PLUGIN_CLOSING_TAG);
			if (insertPosition < 0) {
				throw new InvocationTargetException(new Exception("Incorrect " + PLUGIN_XML_FILE_NAME + " file - " + PLUGIN_CLOSING_TAG + " tag was not found"));
			}
		} else {
			pluginXmlContent.append(PLUGIN_OPENNING_TAG);
			pluginXmlContent.append(LF);
			insertPosition = pluginXmlContent.length();
			pluginXmlContent.append(PLUGIN_CLOSING_TAG);
		}
		progressMonitor.worked(1);

		pluginXmlContent.insert(insertPosition, getNativeLibraryExtensionPoint(nativeLibraryDeclarations));
		try {
			ByteArrayInputStream inputStream = new ByteArrayInputStream(pluginXmlContent.toString().getBytes(PLUGIN_XML_CHARSET));
			IProgressMonitor subProgressMonitor = createSubProgressMonitor(progressMonitor, "Saving new " + PLUGIN_XML_FILE_NAME + "content", 1);
			if (pluginXml.exists()) {
				pluginXml.setContents(inputStream, IFile.FORCE | IFile.KEEP_HISTORY, subProgressMonitor);
			} else {
				pluginXml.create(inputStream, true, subProgressMonitor);
			}
		} catch (UnsupportedEncodingException e) {
			throw new InvocationTargetException(e);
		}
	}

	private StringBuilder getNativeLibraryExtensionPoint(List<CharSequence> nativeLibraryDeclarations) {
		StringBuilder result = new StringBuilder("\t<extension point=\"org.eclipse.m2m.qvt.oml.javaBlackboxUnits\">");
		result.append(LF);
		for (CharSequence declaration : nativeLibraryDeclarations) {
			result.append("\t\t");
			result.append(declaration);
		}
		result.append("\t</extension>");
		return result.append(LF);
	}

	private void migrateXpandRoot(IFolder rootFolder, List<CharSequence> nativeLibraryDeclarations, IProgressMonitor progressMonitor) throws InterruptedException, CoreException,
			InvocationTargetException {
		IFolder templatesOutputFolder = getTemplatesOutputFolder(rootFolder, createSubProgressMonitor(progressMonitor, "Calculating new templates root folder name", 1));
		IFolder nativeExtensionsRoot = getNativeExtensionsSourceRoot(rootFolder, createSubProgressMonitor(progressMonitor, "Creating new source rolot for native extensions", 1));

		MigrationVisitor visitor = new MigrationVisitor(rootFolder, templatesOutputFolder, nativeExtensionsRoot, selectedJavaProject, rootManager, progressMonitor);
		acceptVisitor(rootFolder, visitor);
		visitor.done();
		nativeLibraryDeclarations.addAll(visitor.getNativeLibraryDeclarations());
		rootManager.updateXpandRootFolder(rootFolder, templatesOutputFolder);
	}

	private int getNumberOfSteps(IFolder rootFolder, IProgressMonitor progressMonitor) throws CoreException, InterruptedException, InvocationTargetException {
		progressMonitor.beginTask("Counting xpand resources in: " + rootFolder.getName(), 1);
		ResourceCountingVisitor counter = new ResourceCountingVisitor(progressMonitor);
		acceptVisitor(rootFolder, counter);
		progressMonitor.done();
		return counter.getNumberOfFiles();
	}

	private void acceptVisitor(IResource resource, AbstractMigrationVisitor visitor) throws InterruptedException, CoreException, InvocationTargetException {
		try {
			resource.accept(visitor);
		} catch (CoreException e) {
			if (e.getCause() instanceof InterruptedException) {
				throw (InterruptedException) e.getCause();
			} else if (e.getCause() != null) {
				throw new InvocationTargetException(e.getCause());
			} else {
				throw e;
			}
		}
	}

	private IFolder getTemplatesOutputFolder(IFolder rootFolder, IProgressMonitor progressMonitor) {
		progressMonitor.beginTask("Calculating new templates root folder name", 1);
		IContainer parent = rootFolder.getParent();
		IPath relativePathBasis = rootFolder.getProjectRelativePath().removeFirstSegments(parent.getProjectRelativePath().segmentCount());
		IPath relativePath = relativePathBasis.addFileExtension(MIGRATED_ROOT_EXTENSION);
		for (int i = 1; parent.getFolder(relativePath).exists(); i++) {
			relativePath = relativePathBasis.addFileExtension(MIGRATED_ROOT_EXTENSION + i);
		}
		progressMonitor.done();
		return parent.getFolder(relativePath);
	}

	private IFolder getNativeExtensionsSourceRoot(IFolder rootFolder, IProgressMonitor progressMonitor) throws CoreException, InterruptedException {
		progressMonitor.beginTask("Calculating source root for native extensions", 1);
		IProject project = selectedJavaProject.getProject();
		String folderName = rootFolder.getName() + NATIVE_EXTENSIONS_SRC_FOLDER;
		for (int i = 1; project.getFolder(folderName).exists(); i++) {
			folderName = rootFolder.getName() + NATIVE_EXTENSIONS_SRC_FOLDER + i;
		}
		progressMonitor.done();
		return project.getFolder(folderName);
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1 && structuredSelection.getFirstElement() instanceof IJavaProject) {
				selectedJavaProject = (IJavaProject) structuredSelection.getFirstElement();
				rootManager = new RootManager(selectedJavaProject.getProject());
				action.setEnabled(rootManager.hasConfig());
				return;
			}
		}
		action.setEnabled(false);
	}

	private Shell getShell() {
		return workbenchPart.getSite().getShell();
	}

	private void showError(String title, String contents) {
		MessageDialog.openError(getShell(), title, contents);
	}

}
