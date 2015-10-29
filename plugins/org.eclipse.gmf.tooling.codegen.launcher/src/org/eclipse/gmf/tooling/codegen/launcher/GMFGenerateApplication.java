package org.eclipse.gmf.tooling.codegen.launcher;

import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.xtend.ui.handlers.CodegenEmittersWithXtend2;
import org.eclipse.gmf.codegen.xtend.ui.handlers.GeneratorWithXtend2;
import org.eclipse.gmf.internal.common.codegen.CodeFormatterFactory;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;
import org.eclipse.gmf.tooling.codegen.launcher.utils.GMFGeneratorUtil;
import org.eclipse.gmf.tooling.codegen.launcher.utils.SerializedCodeFormatterFactory;
import org.eclipse.gmf.tooling.codegen.launcher.utils.WorkspaceHelper;
import org.osgi.framework.Bundle;

public class GMFGenerateApplication implements IApplication {

	private WorkspaceHelper myWorkspaceHelper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.IApplicationContext)
	 */
	@Override
	public Object start(IApplicationContext context) throws Exception {
		myWorkspaceHelper = new WorkspaceHelper();
		ArgumentsParser runnerArguments = null;
		try {
			runnerArguments = new ArgumentsParser(context);

			List<String> projectsToImport = new LinkedList<String>(runnerArguments.getRelatedProjects());
			projectsToImport.add(runnerArguments.getGMFGENProjectLocation());
			initWorkspace(projectsToImport);

			GenEditorGenerator editorGen = GMFGeneratorUtil.loadEditorGen(runnerArguments.getGMFGENProjectLocation(), runnerArguments.getGMFGENResourceLocation());

			initPluginProject(runnerArguments.getGenerateProjectLocation(), editorGen.getPluginDirectory());

			CodegenEmittersWithXtend2 emitters = getCodegenEmitters(editorGen, runnerArguments.getCustomEmitterBundleName(), runnerArguments.getCustomEmitterClassName());
			CodeFormatterFactory codeFormatterFactory = loadFormatter(runnerArguments.getFormatter());

			GeneratorBase generator = new GeneratorWithXtend2(editorGen, emitters, codeFormatterFactory);

			generator.run(new NullProgressMonitor());
		} catch (Exception e) {
			Activator.getDefault().error(e);
			if (runnerArguments != null && runnerArguments.shouldTrace()) {
				e.printStackTrace();
			}
			throw e;
		}
		return IApplicationContext.EXIT_ASYNC_RESULT;
	}

	private void initPluginProject(String filesystemLocation, String gmfgenPluginDirectory) throws CoreException {
		String pluginProjectName = new Path(gmfgenPluginDirectory).segment(0);
		IPath location = new Path(filesystemLocation);
		if (!location.lastSegment().equals(pluginProjectName)) {
			location.append(pluginProjectName);
		}

		myWorkspaceHelper.createProject(pluginProjectName, location);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop(org.eclipse.equinox.app.IApplicationContext)
	 */
	@Override
	public void stop() {
		myWorkspaceHelper = null;
	}

	protected void initWorkspace(List<String> projects) throws CoreException {
		myWorkspaceHelper.clearWorkspace();

		for (String path : projects) {
			myWorkspaceHelper.importProject(path);
		}
	}

	@SuppressWarnings("unchecked")
	protected CodegenEmittersWithXtend2 getCodegenEmitters(GenEditorGenerator editorGen, String bundleName, String className) {
		CodegenEmittersWithXtend2 emitters = null;

		if (className != null && bundleName != null) {
			Bundle bundle = Platform.getBundle(bundleName);
			Class<? extends CodegenEmittersWithXtend2> customEmittersClass;
			try {
				customEmittersClass = (Class<? extends CodegenEmittersWithXtend2>) bundle.loadClass(className);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Custom emitter not found. "
						+ "Class: " + className + ". "
						+ "Bundle:" + bundleName, e);
			}
			Constructor<? extends CodegenEmittersWithXtend2> constructor;
			try {
				constructor = customEmittersClass.getConstructor(GenEditorGenerator.class);
			} catch (Exception e) {
				throw new RuntimeException("Constructor with" + GenEditorGenerator.class.getCanonicalName() + " parameter not found", e);
			}

			try {
				emitters = (CodegenEmittersWithXtend2) constructor.newInstance(editorGen);
			} catch (Exception e) {
				throw new RuntimeException("Cannot create instance of" + className, e);
			}
		} else {
			emitters = new CodegenEmittersWithXtend2(editorGen);
		}
		return emitters;
	}

	private CodeFormatterFactory loadFormatter(String path) {
		if (path != null) {
			return new SerializedCodeFormatterFactory(path);
		}
		return CodeFormatterFactory.DEFAULT;
	}
}
