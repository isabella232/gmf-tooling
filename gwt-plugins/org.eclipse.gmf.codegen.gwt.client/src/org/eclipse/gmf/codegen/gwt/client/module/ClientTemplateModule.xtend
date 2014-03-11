package org.eclipse.gmf.codegen.gwt.client.module

import client.ClientFactory
import client.EntryPoint
import client.GWTModule
import client.events.OpenDiagramEvent
import client.events.ShowPaneEvent
import client.icons.Icons
import client.presenter.AppController
import client.presenter.DiagramPresenter
import client.presenter.FeatureEditPresenter
import client.presenter.FeatureListEditPresenter
import client.presenter.FeatureUniqueEditPresenter
import client.presenter.Presenter
import client.presenter.PropertySheetPresenter
import client.view.AppMenuView
import client.view.AppMenuViewUi
import client.view.AppView
import client.view.AppViewUi
import client.view.DiagramView
import client.view.DiagramViewUi
import client.view.PaletteView
import client.view.PaletteViewUi
import client.view.properties.PropertySheetSectionView
import client.view.properties.PropertySheetSectionViewUi
import client.view.properties.PropertySheetView
import client.view.properties.PropertySheetViewUi
import client.view.properties.widgets.CheckBoxView
import client.view.properties.widgets.CheckBoxViewUi
import client.view.properties.widgets.DateView
import client.view.properties.widgets.DateViewUi
import client.view.properties.widgets.MultipleListView
import client.view.properties.widgets.MultipleListViewUi
import client.view.properties.widgets.SingleListView
import client.view.properties.widgets.SingleListViewUi
import client.view.properties.widgets.TextAreaView
import client.view.properties.widgets.TextAreaViewUi
import client.view.properties.widgets.TextView
import client.view.properties.widgets.TextViewUi
import client.view.sidebar.SidePaneView
import client.view.sidebar.SidePaneViewUi
import com.google.inject.AbstractModule

class ClientTemplateModule extends AbstractModule {

	override protected configure() {
		bindEntryPoint
		bindClientFactory
		bindGWTModule

		bindShowPaneEvent
		bindOpenDiagramEvent

		bindIcons

		bindPresenter
		bindAppController
		bindDiagramPresenter
		bindFeatureEditPresenter
		bindFeatureUniqueEditPresenter
		bindFeatureListEditPresenter
		bindPropertySheetPresenter

		bindAppView
		bindAppViewUi
		bindDiagramView
		bindDiagramViewUi
		bindMenuView
		bindMenuViewUi
		bindPaletteView
		bindPaletteViewUi

		bindPropertySheetView
		bindPropertySheetViewUi
		bindPropertySheetSectionView
		bindPropertySheetSectionViewUi

		bindCheckBoxView
		bindCheckBoxViewUi
		bindDateView
		bindDateViewUi
		bindTextView
		bindTextViewUi
		bindTextAreaView
		bindTextAreaViewUi
		bindSingleListView
		bindSingleListViewUi
		bindMultipleListView
		bindMultipleListViewUi

		bindSidePaneView
		bindSidePaneViewUi
	}
	
	def bindEntryPoint() { bind(EntryPoint) }
	def bindClientFactory() { bind(ClientFactory) }
	def bindGWTModule() { bind(GWTModule) }

	def bindShowPaneEvent() { bind(ShowPaneEvent) }
	def bindOpenDiagramEvent() { bind(OpenDiagramEvent) }
	
	def bindIcons() { bind(Icons) }

	def bindPresenter() { bind(Presenter) }
	def bindAppController() { bind(AppController) }
	def bindDiagramPresenter() { bind(DiagramPresenter) }
	def bindFeatureEditPresenter() { bind(FeatureEditPresenter) }
	def bindFeatureListEditPresenter() { bind(FeatureListEditPresenter) }
	def bindFeatureUniqueEditPresenter() { bind(FeatureUniqueEditPresenter) }
	def bindPropertySheetPresenter() { bind(PropertySheetPresenter) }
	
	def bindAppView() { bind(AppView) }
	def bindAppViewUi() { bind(AppViewUi) }
	def bindDiagramView() { bind(DiagramView)}
	def bindDiagramViewUi() { bind(DiagramViewUi)}
	def bindMenuView() { bind(AppMenuView) }
	def bindMenuViewUi() { bind(AppMenuViewUi) }
	def bindPaletteView() { bind(PaletteView) }
	def bindPaletteViewUi() { bind(PaletteViewUi) }
	
	def bindPropertySheetView() { bind(PropertySheetView) }
	def bindPropertySheetViewUi() { bind(PropertySheetViewUi) }
	def bindPropertySheetSectionView() { bind(PropertySheetSectionView) }
	def bindPropertySheetSectionViewUi() { bind(PropertySheetSectionViewUi) }

	def bindCheckBoxView() { bind(CheckBoxView) }
	def bindCheckBoxViewUi() { bind(CheckBoxViewUi) }
	def bindDateView() { bind(DateView) }
	def bindDateViewUi() { bind(DateViewUi) }
	def bindTextView() { bind(TextView) }
	def bindTextViewUi() { bind(TextViewUi) }
	def bindTextAreaView() { bind(TextAreaView) }
	def bindTextAreaViewUi() { bind(TextAreaViewUi) }
	def bindSingleListView() { bind(SingleListView) }
	def bindSingleListViewUi() { bind(SingleListViewUi) }
	def bindMultipleListView() { bind(MultipleListView) }
	def bindMultipleListViewUi() { bind(MultipleListViewUi) }

	def bindSidePaneView() { bind(SidePaneView) }
	def bindSidePaneViewUi() { bind(SidePaneViewUi) }

}