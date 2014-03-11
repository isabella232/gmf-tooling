package client.icons

import client.ClientClassTemplate
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class Icons extends ClientClassTemplate {
	
	override generate(GenEditorGenerator it) '''
		package «packageName»;

		import com.google.gwt.resources.client.ClientBundle;
		import com.google.gwt.resources.client.ImageResource;

		«generatedClassComment»
		public interface Icons extends ClientBundle {
		
			 «body»
		
		}
	'''

	override packageName(GenEditorGenerator it) '''«baseIconsPackage»'''
	
	override protected body(GenEditorGenerator it)
	'''
		«generatedMemberComment»
		@Source("prop_ps.png")
		public ImageResource properties();

		«generatedMemberComment»
		@Source("filenav_nav.png")
		public ImageResource navigator();

		«generatedMemberComment»
		@Source("palette_view.gif")
		public ImageResource palette();

		«generatedMemberComment»
		@Source("undo_edit.png")
		public ImageResource undo();

		«generatedMemberComment»
		@Source("redo_edit.png")
		public ImageResource redo();

		«generatedMemberComment»
		@Source("file_obj.png")
		public ImageResource file();

		«generatedMemberComment»
		@Source("zoom_in.gif")
		public ImageResource zoomIn();
		
		«generatedMemberComment»
		@Source("zoom_out.gif")
		public ImageResource zoomOut();

		«generatedMemberComment»
		@Source("delete.png")
		public ImageResource delete();
	'''

}