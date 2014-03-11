package diagram

import org.eclipse.gmf.codegen.gmfgen.DefaultSizeAttributes
import org.eclipse.gmf.codegen.gmfgen.LabelOffsetAttributes
import org.eclipse.gmf.codegen.gmfgen.ResizeConstraints
import org.eclipse.gmf.codegen.gmfgen.StyleAttributes
import org.eclipse.gmf.codegen.gmfgen.Viewmap
import org.eclipse.gmf.codegen.gmfgen.ViewmapLayoutType

class ViewmapAttributesUtilsHelper {

	def boolean isStoringChildPositions(ViewmapLayoutType layoutType) {
		ViewmapLayoutType::XY_LAYOUT == layoutType
	}

	def boolean isFixedFont(Viewmap xptSelf) {
		xptSelf != null && xptSelf.attributes.filter(typeof(StyleAttributes)).exists[fixedFont]
	}

	def boolean isFixedForeground(Viewmap xptSelf) {
		xptSelf != null && xptSelf.attributes.filter(typeof(StyleAttributes)).exists[fixedForeground]
	}

	def boolean isFixedBackground(Viewmap xptSelf) {
		xptSelf != null && xptSelf.attributes.filter(typeof(StyleAttributes)).exists[fixedBackground]
	}

	def boolean canUseShapeStyle(Viewmap xptSelf) {
		xptSelf != null && !(xptSelf.isFixedFont() || xptSelf.isFixedForeground() || xptSelf.isFixedBackground())
	}

	def ResizeConstraints getResizeConstraints(Viewmap viewmap) {
		if (viewmap == null) 
			null
		else 
			viewmap.attributes.filter(typeof(ResizeConstraints)).head
	}

	def DefaultSizeAttributes getDefaultSizeAttributes(Viewmap viewmap) {
		if (viewmap == null) 
			null
		else 
			viewmap.attributes.filter(typeof(DefaultSizeAttributes)).head
	}

	def LabelOffsetAttributes getLabelOffsetAttributes(Viewmap viewmap) {
		if (viewmap == null) 
			null
		else viewmap.attributes.filter(typeof(LabelOffsetAttributes)).head
	}

	def int defaultSizeWidth(Viewmap viewmap, int defaultValue) {
		var result = getDefaultSizeAttributes(viewmap)
		if (result == null) 
			defaultValue 
		else result.width
	}

	def int defaultSizeHeight(Viewmap viewmap, int defaultValue) {
		var result = getDefaultSizeAttributes(viewmap)
		if (result == null) 
			defaultValue 
		else result.height
	}

	def int labelOffsetX(Viewmap viewmap, int defaultValue) {
		var result = getLabelOffsetAttributes(viewmap)
		if (result == null) 
			defaultValue 
		else result.x
	}

	def int labelOffsetY(Viewmap viewmap, int defaultValue) {
		var result = getLabelOffsetAttributes(viewmap)
		if (result == null)
			defaultValue
		else result.y
	}

}
