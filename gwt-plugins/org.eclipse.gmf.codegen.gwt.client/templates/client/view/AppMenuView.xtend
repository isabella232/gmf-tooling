package client.view

import client.presenter.AppController
import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator

class AppMenuView extends BinderView {

	@Inject AppController appController
	
	override getImports(GenEditorGenerator it) '''
		import com.google.gwt.core.client.GWT;
		import com.google.gwt.event.dom.client.ClickEvent;
		import com.google.gwt.event.dom.client.ClickHandler;
		import com.google.gwt.uibinder.client.UiBinder;
		import com.google.gwt.uibinder.client.UiField;
		import com.google.gwt.user.client.ui.Composite;
		import com.google.gwt.user.client.ui.HTMLPanel;
		import com.google.gwt.user.client.ui.Widget;
	'''

	override implementDefinition(GenEditorGenerator it) '''«appController.qualifiedClassName(it)».MenuView'''
	
	override attrs(GenEditorGenerator it) '''
		«generatedMemberComment»
		@UiField HTMLPanel menuButton;

		«generatedMemberComment»
		@UiField HTMLPanel paletteButton;

		«generatedMemberComment»
		@UiField HTMLPanel propertyButton;

		«generatedMemberComment»
		@UiField HTMLPanel deleteButton;

		«generatedMemberComment»
		@UiField HTMLPanel undoButton;

		«generatedMemberComment»
		@UiField HTMLPanel redoButton;

		«generatedMemberComment»
		@UiField HTMLPanel zoomInButton;

		«generatedMemberComment»
		@UiField HTMLPanel zoomOutButton;
	'''

	override addMethods(GenEditorGenerator it) '''
		«generatedMemberComment»
		@Override
		public void addControlViewHandler(final «appController.qualifiedClassName(it)».MenuViewHandler handler) {
			paletteButton.addDomHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					handler.onClickPalette();
				}
			}, ClickEvent.getType());

			propertyButton.addDomHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					handler.onClickProperty();
				}
			}, ClickEvent.getType());

			deleteButton.addDomHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					handler.onDelete();
				}
			}, ClickEvent.getType());

			undoButton.addDomHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					handler.onUndo();
				}
			}, ClickEvent.getType());

			redoButton.addDomHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					handler.onRedo();
				}
			}, ClickEvent.getType());

			zoomInButton.addDomHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					handler.onZoomIn();
				}
			}, ClickEvent.getType());

			zoomOutButton.addDomHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					handler.onZoomOut();
				}
			}, ClickEvent.getType());
		}
	'''

}