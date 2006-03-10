package org.eclipse.gmf.common.codegen;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.codegen.jmerge.JControlModel;
import org.eclipse.emf.codegen.jmerge.JMerger;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.TextEdit;
import org.w3c.dom.Element;

public abstract class GeneratorBase implements Runnable {
	private JControlModel myJControlModel;
	private CodeFormatter myCodeFormatter;
	private IProgressMonitor myProgress = new NullProgressMonitor();

	// myDestRoot.getJavaProject().getElementName() == myDestProject.getName()
	private IPackageFragmentRoot myDestRoot;
	private IProject myDestProject;
	private final List/*<IStatus>*/ myExceptions;
	private IStatus myRunStatus = Status.CANCEL_STATUS;

	protected abstract URL getJMergeControlFile();
	
	protected abstract void customRun() throws InterruptedException, JETException, UnexpectedBehaviourException;
	
	protected abstract void setupProgressMonitor();
		
	public static interface Emitter {
		public String generate(IProgressMonitor monitor, Object arguments) throws JETException ;
	}
	
	public GeneratorBase(){
		myExceptions = new LinkedList/*<IStatus>*/();
	}
	
	public void run(IProgressMonitor progress) throws InterruptedException {
		setProgressMonitor(progress);
		doRun();
	}
	
	public void run() {
		clearExceptionsList();
		try {
			doRun();
		} catch (InterruptedException ex) {
			myRunStatus = new Status(IStatus.CANCEL, "org.eclipse.gmf.codegen", 0, GeneratorBaseMessages.interrupted, ex);
		}
	}
	
	/**
	 * Provides information about success/failures during {@link #run()}
	 * @return state of the generator run, or CANCEL if generator was not yet run.
	 */
	public IStatus getRunStatus() {
		return myRunStatus;
	}

	/**
	 * Optionally, specify progressMonitor to use. Should be called prior to {@link #run()}
	 * @param progress
	 */
	public void setProgressMonitor(IProgressMonitor progress) {
		myProgress = progress;
	}

	protected final void handleException(CoreException ex){
		handleException(ex.getStatus());
	}
	
	protected final void handleException(UnexpectedBehaviourException e){
		
	}
	
	protected final void handleException(IStatus status){
		myExceptions.add(status);
	}
	
	protected final IProject getDestProject() {
		return myDestProject;
	}
	
	protected final IProgressMonitor getProgress() {
		return myProgress;
	}
	
	protected final void setupProgressMonitor(String task, int total) {
		if (myProgress == null) {
			myProgress = new NullProgressMonitor();
			return;
			// no need to set it up
		}
		myProgress.beginTask(task, total);
	}
	
	protected final IProgressMonitor getNextStepMonitor() throws InterruptedException {
		if (myProgress.isCanceled()) {
			throw new InterruptedException();
		}
		return new SubProgressMonitor(myProgress, 1);
	}
	
	protected final void initializeEditorProject(String pluginId, List referencedProjects) throws UnexpectedBehaviourException, InterruptedException {
		myDestProject = ResourcesPlugin.getWorkspace().getRoot().getProject(pluginId);
		final Path srcPath = new Path('/' + myDestProject.getName() + "/src"); //$NON-NLS-1$
		final Path projectLocation = null; // use default
		final int style = org.eclipse.emf.codegen.ecore.Generator.EMF_PLUGIN_PROJECT_STYLE;
		// pluginVariables is NOT used when style is EMF_PLUGIN_PROJECT_STYLE
		final List pluginVariables = null;
		final IProgressMonitor pm = getNextStepMonitor();

		org.eclipse.emf.codegen.ecore.Generator.createEMFProject(srcPath, projectLocation, referencedProjects, pm, style, pluginVariables);

		try {
			myDestRoot = JavaCore.create(myDestProject).findPackageFragmentRoot(srcPath);
		} catch (JavaModelException ex) {
			throw new UnexpectedBehaviourException(ex.getMessage());
		}
		if (myDestRoot == null) {
			throw new UnexpectedBehaviourException("no source root can be found");
		}
	}
	
	protected final void doGenerateFile(JETEmitter emitter, IPath filePath, Object param) throws JETException, InterruptedException {
		doGenerateFile(new JetAdapter(emitter), filePath, param);
	}
	
	/**
	 * Generate ordinary file. No merge is performed at the moment.
	 * @param emitter template to use
	 * @param filePath - project-relative path to file, e.g. META-INF/MANIFEST.MF
	 * @param param TODO
	 * @throws JETException
	 * @throws InterruptedException
	 */
	protected final void doGenerateFile(Emitter emitter, IPath filePath, Object param) throws JETException, InterruptedException {
		assert !myDestProject.getName().equals(filePath.segment(0));
		IProgressMonitor pm = getNextStepMonitor();
		try {
			pm.beginTask(filePath.lastSegment(), 4);
			IPath containerPath = myDestProject.getFullPath().append(filePath.removeLastSegments(1));
			CodeGenUtil.findOrCreateContainer(containerPath, false, (IPath) null, new SubProgressMonitor(pm, 1));
			String genText = emitter.generate(new SubProgressMonitor(pm, 1), param);
			IFile f = myDestProject.getFile(filePath);
			// FIXME merge!
			if (f.exists()) {
				if (!contains(f, new ByteArrayInputStream(genText.getBytes()))) {
					f.setContents(new ByteArrayInputStream(genText.getBytes()), true, true, new SubProgressMonitor(pm, 1));
				} else {
					pm.worked(1);
				}
			} else {
				f.create(new ByteArrayInputStream(genText.getBytes()), true, new SubProgressMonitor(pm, 1));
			}
			f.getParent().refreshLocal(IResource.DEPTH_ONE, new SubProgressMonitor(pm, 1));
		} catch (CoreException ex) {
			handleException(ex);
		} finally {
			pm.done();
		}
	}

	/**
	 * @return <code>true</code> if the file contains the input stream contents
	 */
	protected boolean contains(IFile f, InputStream is) {
		int fc = 0;
		int ic = 0;
		InputStream fs = null;
		try {
			fs = f.getContents(true);
			while ((fc = fs.read()) == (ic = is.read()) && fc >= 0);
		} catch (CoreException ce) {
		} catch (IOException ioe) {
		} finally {
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException ioe) {
				}
			}
		}
		return fc <0 && ic < 0;
	}

	/**
	 * NOTE: potential problem - packageName and className should match those specified in 
	 * the template. Besides, getQualifiedXXX helpers in diagram GenModel should also correctly
	 * return qualified class names.  
	 */
	protected final void doGenerateJavaClass(JETEmitter emitter, String packageName, String className, Object input) throws InterruptedException {
		doGenerateJavaClass(new JetAdapter(emitter, packageName), packageName, className, input);
	}
	
	/**
	 * NOTE: potential problem - packageName and className should match those specified in 
	 * the template. Besides, getQualifiedXXX helpers in diagram GenModel should also correctly
	 * return qualified class names.  
	 */
	protected final void doGenerateJavaClass(Emitter emitter, String packageName, String className, Object input) throws InterruptedException {
		IProgressMonitor pm = getNextStepMonitor();
		try {
			pm.beginTask(className, 4);
			String genText = emitter.generate(new SubProgressMonitor(pm, 1), input);
			IPackageFragment pf = myDestRoot.createPackageFragment(packageName, true, new SubProgressMonitor(pm, 1));
			ICompilationUnit cu = pf.getCompilationUnit(className + ".java"); //$NON-NLS-1$
			if (cu.exists() && canMerge()) {
				genText = merge(genText, cu.getSource(), new SubProgressMonitor(pm, 1));
			} else {
				pm.worked(1);
			}
			genText = formatCode(genText);
			if (!cu.exists() || !genText.equals(cu.getSource())) {
				pf.createCompilationUnit(cu.getElementName(), genText, true, new SubProgressMonitor(pm, 1));
			} else {
				pm.worked(1);
			}
		} catch (NullPointerException ex) {
			handleException(new Status(IStatus.ERROR, "org.eclipse.gmf.codegen", 0, ex.getMessage(), ex));
		} catch (JETException ex) {
			handleException(ex.getStatus());
		} catch (CoreException ex) {
			handleException(ex);		
		} finally {
			pm.done();
		}
	}
	
	protected final boolean canMerge() {
		return getJControlModel() != null;
	}

	protected final String merge(String generatedText, String oldContents, IProgressMonitor pm) {
		if (!canMerge()){
			throw new IllegalStateException("Can not initialize JMerge model");
		}
		pm.beginTask(GeneratorBaseMessages.merge, 1);
		JMerger jMerge = new JMerger();
		jMerge.setControlModel(getJControlModel());
		jMerge.setSourceCompilationUnit(jMerge.createCompilationUnitForContents(generatedText));
		jMerge.setTargetCompilationUnit(jMerge.createCompilationUnitForContents(oldContents));
		jMerge.merge();
		pm.done();
		return jMerge.getTargetCompilationUnitContents();
	}

	protected final String formatCode(String text) {
		IDocument doc = new Document(text);
		TextEdit edit = getCodeFormatter().format(CodeFormatter.K_COMPILATION_UNIT, doc.get(), 0, doc.get().length(), 0, null);

		try {
			// check if text formatted successfully 
			if(edit != null) {
				edit.apply(doc);
				text = doc.get();				
			}		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return text;
	}

	private void doRun() throws InterruptedException {
		try {
			setupProgressMonitor();
			customRun();
			myRunStatus = getExceptionsStatus();
		} catch (NullPointerException ex) {
			myRunStatus = new Status(IStatus.ERROR, "org.eclipse.gmf.codegen", 0, NullPointerException.class.getName(), ex);
		} catch (JETException ex) {
			myRunStatus = ex.getStatus();
		} catch (UnexpectedBehaviourException ex) {
			myRunStatus = new Status(Status.ERROR, "org.eclipse.gmf.codegen", 0, GeneratorBaseMessages.unexpected, ex);
		} finally {
			getProgress().done();
			clearExceptionsList();
		}
	}

	private JControlModel getJControlModel() {
		if (myJControlModel == null) {
			URL controlFile = getJMergeControlFile();
			if (controlFile != null){
				myJControlModel = new JControlModel(controlFile.toString());
			}
		}
		return myJControlModel;
	}

	private JControlModel createEmptyJControlModel() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		org.w3c.dom.Document document;
		try {
			document = factory.newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			throw new RuntimeException("Can not initialize DOM", e);
		}
		Element root = (Element)document.appendChild(document.createElement("fake"));
		return new JControlModel(root);
	}

	private CodeFormatter getCodeFormatter() {
		if (myCodeFormatter == null) {
			myCodeFormatter = ToolFactory.createCodeFormatter(null);
		}
		return myCodeFormatter;
	}
	
	private final void clearExceptionsList(){
		myExceptions.clear();
	}
	
	private final IStatus getExceptionsStatus(){
		if (myExceptions == null || myExceptions.isEmpty()){
			return Status.OK_STATUS;
		} else {
			IStatus[] s = (IStatus[]) myExceptions.toArray(new IStatus[myExceptions.size()]);
			return new MultiStatus("org.eclipse.gmf.codegen", 0, s, GeneratorBaseMessages.problems, null);
		}
	}

	private static class JetAdapter implements Emitter {
		private final JETEmitter myEmitter;
		private final ImportAssistant myImportAssistant;

		public JetAdapter(JETEmitter emitter, ImportAssistant importAssistant){
			myEmitter = emitter;
			myImportAssistant = importAssistant;
		}
		
		public JetAdapter(JETEmitter emitter){
			this(emitter, (ImportAssistant)null);
		}
		
		public JetAdapter(JETEmitter emitter, String packageName){
			this(emitter, new ImportUtil(packageName));
		}
		
		public String generate(IProgressMonitor monitor, Object param) throws JETException {
			Object[] jetArgs = shouldAddImports() ? 
					new Object[] {new Object[] {param, myImportAssistant}} :
					new Object[] {param};
			return myEmitter.generate(monitor, jetArgs);
		}

		private boolean shouldAddImports() {
			return myImportAssistant != null;
		}
	}

	
}
