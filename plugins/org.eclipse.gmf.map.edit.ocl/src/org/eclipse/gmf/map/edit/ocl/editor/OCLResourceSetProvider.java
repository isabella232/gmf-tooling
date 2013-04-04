package org.eclipse.gmf.map.edit.ocl.editor;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class OCLResourceSetProvider extends XtextResourceSetProvider {
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	private XtextResourceSet nullProjectResourceSet = null;

	@Override
	public ResourceSet get(IProject project) {			// FIXME Workaround for Bug 339640
		if (project != null) {
			return super.get(project);
		} else {
			if (nullProjectResourceSet == null) {
				nullProjectResourceSet = resourceSetProvider.get();
			}
			return nullProjectResourceSet;
		}
	}

}
