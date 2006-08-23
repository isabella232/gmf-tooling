package org.eclipse.gmf.internal.common.codegen;

import org.eclipse.emf.codegen.merge.properties.PropertyMerger;

/**
 * @author dstadnik
 */
public class PropertiesTextMerger extends TextMerger {

	public String process(String oldText, String newText) {
        PropertyMerger propertyMerger = new PropertyMerger();
        propertyMerger.setSourceProperties(newText);
        propertyMerger.setTargetProperties(oldText);
        propertyMerger.merge();
        return propertyMerger.getTargetProperties();
	}
}
