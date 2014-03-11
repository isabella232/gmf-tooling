package client.view

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class PaletteView extends BinderView {

	override getImports(GenEditorGenerator it) '''
		«super.getImports(it)»
		import com.google.gwt.uibinder.client.UiField;
		import com.google.gwt.user.client.ui.HTMLPanel;

		import org.eclipse.swt.SWT;

		import org.eclipse.gef.palette.PaletteRoot;
		import org.eclipse.gef.ui.palette.PaletteViewer;
		import org.eclipse.gef.ui.palette.PaletteViewerProvider;
	'''
	
	override attrs(GenEditorGenerator it) '''
		@UiField HTMLPanel palettePanel;

		private final org.eclipse.swt.widgets.Composite paletteComposite;
	'''

	override ctorBody() '''
		paletteComposite = new org.eclipse.swt.widgets.Composite(null, SWT.NONE);
	'''

	override addMethods(GenEditorGenerator it) '''
		public void setPalette(PaletteRoot paletteRoot, PaletteViewerProvider provider) {
			PaletteViewer paletteViewer = provider.createPaletteViewer(paletteComposite);
			paletteViewer.setContents(paletteRoot);
			paletteComposite.setSize(120, 200);
			
			Widget widget = paletteComposite.getGwtWidget();		
			palettePanel.add(widget);
		}
	'''
	
}