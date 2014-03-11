package org.eclipse.gmf.codegen.gwt.client

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
import com.google.inject.Inject

class TemplateProvider {
	
	@Inject public EntryPoint entryPoint
	@Inject public ClientFactory clientFactory
	@Inject public GWTModule gwtModule

	@Inject public ShowPaneEvent showPaneEvent
	@Inject public OpenDiagramEvent openDiagramEvent

	@Inject public Icons icons

	@Inject public Presenter presenter
	@Inject public AppController appController
	@Inject public DiagramPresenter diagramPresenter
	@Inject public FeatureEditPresenter featureEditPresenter
	@Inject public FeatureUniqueEditPresenter featureUniqueEditPresenter
	@Inject public FeatureListEditPresenter featureListEditPresenter
	@Inject public PropertySheetPresenter propertySheetPresenter

	@Inject public AppView appView
	@Inject public AppViewUi appViewUi
	@Inject public DiagramView diagramView
	@Inject public DiagramViewUi diagramViewUi
	@Inject public AppMenuView menuView
	@Inject public AppMenuViewUi menuViewUi
	@Inject public PaletteView paletteView
	@Inject public PaletteViewUi paletteViewUi
	
	@Inject public PropertySheetView propertySheetView
	@Inject public PropertySheetViewUi propertySheetViewUi
	@Inject public PropertySheetSectionView propertySheetSectionView
	@Inject public PropertySheetSectionViewUi propertySheetSectionViewUi

	@Inject public CheckBoxView checkBoxView
	@Inject public CheckBoxViewUi checkBoxViewUi
	@Inject public DateView dateView
	@Inject public DateViewUi dateViewUi
	@Inject public MultipleListView multipleListView
	@Inject public MultipleListViewUi multipleListViewUi
	@Inject public SingleListView singleListView
	@Inject public SingleListViewUi singleListViewUi
	@Inject public TextAreaView textAreaView
	@Inject public TextAreaViewUi textAreaViewUi
	@Inject public TextView textView
	@Inject public TextViewUi textViewUi

	@Inject public SidePaneView sidePaneView
	@Inject public SidePaneViewUi sidePaneViewUi

}