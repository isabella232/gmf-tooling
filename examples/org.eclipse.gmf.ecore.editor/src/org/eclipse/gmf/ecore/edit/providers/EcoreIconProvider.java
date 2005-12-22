package org.eclipse.gmf.ecore.edit.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.GetIconOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class EcoreIconProvider extends AbstractProvider implements IIconProvider {

	/**
	 * @generated
	 */
	public Image getIcon(IAdaptable hint, int flags) {
		return EcoreElementTypes.getImage(hint);
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetIconOperation) {
			IAdaptable hint = ((GetIconOperation) operation).getHint();
			return getIcon(hint, IconOptions.NONE.intValue()) != null;
		}
		return false;
	}
}
