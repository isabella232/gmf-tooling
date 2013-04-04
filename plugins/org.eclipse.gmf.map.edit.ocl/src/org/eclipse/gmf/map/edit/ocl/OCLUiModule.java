package org.eclipse.gmf.map.edit.ocl;

import org.eclipse.gmf.map.edit.ocl.editor.OCLIssueModificationContext;
import org.eclipse.gmf.map.edit.ocl.editor.OCLResourceSetProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.EssentialOCLUiModule;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

public class OCLUiModule extends EssentialOCLUiModule {

	public OCLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends IssueModificationContext> bindIssueModificationContext() {
		return OCLIssueModificationContext.class;
	}

	@Override
	public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		return OCLResourceSetProvider.class;
	}

}
