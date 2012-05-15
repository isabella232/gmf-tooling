package org.eclipse.gmf.examples.layers.subdiagrams;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * @deprecated find a way to plug the real per-diagram save options (XXXDiagramEditorUtil.getSaveOptions) here.
 */
@Deprecated
public class DefaultSaveOptions {

	/**
	 * XXX: We don't have a way to plug the actual diagram save options (XXXDiagramEditorUtil.getSaveOptions) here. 
	 * For now we will use the default ones, but it may lead to a problem if actual diagram has this method generated NOT.
	 * 
	 * @deprecated find a way to plug the real per-diagram save options (XXXDiagramEditorUtil.getSaveOptions) here.  
	 */
	@Deprecated
	public static Map<?, ?> getSaveOptions() {
		HashMap<String, Object> saveOptions = new HashMap<String, Object>();
		saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
		saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
		return saveOptions;
	}

}
