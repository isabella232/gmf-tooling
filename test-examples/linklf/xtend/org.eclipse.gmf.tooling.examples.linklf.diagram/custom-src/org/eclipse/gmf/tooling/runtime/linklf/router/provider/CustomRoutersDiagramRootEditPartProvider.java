package org.eclipse.gmf.tooling.runtime.linklf.router.provider;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.render.internal.providers.DiagramUIRenderEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateRootEditPartOperation;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

public class CustomRoutersDiagramRootEditPartProvider extends DiagramUIRenderEditPartProvider implements IExecutableExtension {

	private final Set<String> myApplicableDiagramTypes = new HashSet<String>();

	@Override
	public boolean provides(IOperation operation) {
		if (operation instanceof CreateRootEditPartOperation) {
			CreateRootEditPartOperation op = (CreateRootEditPartOperation) operation;
			View view = op.getView();
			boolean result = view != null && myApplicableDiagramTypes.contains(view.getType());
			return result;
		}
		return false;
	}

	@Override
	public RootEditPart createRootEditPart(Diagram diagram) {
		return new CustomRoutersDiagramRootEditPart(diagram.getMeasurementUnit());
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) throws CoreException {
		IConfigurationElement[] applicability = config.getChildren(ExtensionSchema.ELEM_APPLICABLE_DIAGRAM);
		for (IConfigurationElement next : applicability) {
			String nextType = next.getAttribute(ExtensionSchema.ATTR_TYPE);
			if (nextType != null) {
				myApplicableDiagramTypes.add(nextType);
			}
		}
	}

	private static interface ExtensionSchema {

		public static final String ELEM_APPLICABLE_DIAGRAM = "applicable-diagram";

		public static final String ATTR_TYPE = "type";
	}

}
