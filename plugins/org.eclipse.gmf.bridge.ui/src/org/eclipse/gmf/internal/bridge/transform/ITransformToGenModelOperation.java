package org.eclipse.gmf.internal.bridge.transform;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.mappings.Mapping;

public interface ITransformToGenModelOperation {

	public TransformOptions getOptions();

	public ResourceSet getResourceSet();

	public Diagnostic getGMFGenValidationResult();

	public Diagnostic getMapmodelValidationResult();

	public GenModel findGenmodel() throws CoreException;

	public GenModelDetector getGenModelDetector();

	public void setGenURI(URI gmfGen);

	public IStatus executeTransformation(IProgressMonitor pm);

	public Mapping loadMappingModel(URI uri, IProgressMonitor pm) throws CoreException;

	public IStatus getStaleGenmodelStatus();
	
	public GenModel loadGenModel(URI uri, IProgressMonitor pm) throws CoreException;

}
