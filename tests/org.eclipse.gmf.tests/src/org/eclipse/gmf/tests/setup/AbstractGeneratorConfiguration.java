/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import java.lang.reflect.Field;

import org.junit.Assert;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.ScalableLayeredPane;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.editparts.ScalableRootEditPart;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.gmfgraph.BasicFont;
import org.eclipse.gmf.gmfgraph.Font;
import org.eclipse.gmf.gmfgraph.FontStyle;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;


public abstract class AbstractGeneratorConfiguration implements GeneratorConfiguration, ViewerConfiguration.Factory {
	
	public ViewerConfiguration createViewerConfiguration(Composite parent, Diagram canvas, GeneratedDiagramPlugin genPlugin) {
		try {
			EditPartViewer viewer = createViewer(parent, canvas, genPlugin);
			return createViewerConfiguration(viewer, genPlugin);
		} catch (Exception ex) {
			Assert.fail(ex.toString());
		}
		return null;
	}

	public EditPartViewer createViewer(Composite parent, Diagram canvas, GeneratedDiagramPlugin genPlugin) throws Exception {
		// make sure there's display for current thread
		Display.getDefault();
	
		EditPartViewer gv = createViewerInstance();
		gv.createControl(parent);
		DiagramEditDomain ded = new DiagramEditDomain(null);
		gv.setEditDomain(ded);
		gv.getEditDomain().setCommandStack(new DiagramCommandStack(ded));

		String epFactoryClassName = genPlugin.getGenDiagram().getEditPartFactoryQualifiedClassName();
		Class<?> epFactory = genPlugin.loadGeneratedClass(epFactoryClassName);
		assert EditPartFactory.class.isAssignableFrom(epFactory);
		gv.setEditPartFactory((EditPartFactory) epFactory.newInstance());
		gv.setContents(canvas);
		
		return gv;
	}

	protected abstract EditPartViewer createViewerInstance();
	
	protected static abstract class AbstractViewerConfiguration implements ViewerConfiguration {
		
		private final EditPartViewer myViewer;
		private final GeneratedDiagramPlugin myGeneratedPlugin;
		private PreferencesHint myDefaultPreferences;

		public AbstractViewerConfiguration(EditPartViewer viewer, GeneratedDiagramPlugin genPlugin) {
			myViewer = viewer;
			myGeneratedPlugin = genPlugin;
		}
		
		public EditPartViewer getViewer() {
			return myViewer;
		}
		
		public EditPart findEditPart(View notationElement) {
			return (EditPart) myViewer.getEditPartRegistry().get(notationElement);
		}
		
		public Font getDefaultFont() {
			BasicFont result = GMFGraphFactory.eINSTANCE.createBasicFont();
			FontData defaultFontData = PreferenceConverter.getDefaultFontData(getDefaultPreferences(), IPreferenceConstants.PREF_DEFAULT_FONT);
			result.setFaceName(defaultFontData.getName());
			result.setHeight(defaultFontData.getHeight());
			result.setStyle(FontStyle.get(defaultFontData.getStyle()));
			return result;
		}
		
		protected final Class<?> loadGeneratedClass(String qualifiedClassName) throws Exception {
			return myGeneratedPlugin.loadGeneratedClass(qualifiedClassName);
		}
		
		protected GenDiagram getGenModel() {
			return myGeneratedPlugin.getGenDiagram();
		}
		
		protected IPreferenceStore getDefaultPreferences() {
			return (IPreferenceStore) getDefaultPreferencesHint().getPreferenceStore();
		}
		
		protected PreferencesHint getDefaultPreferencesHint() {
			if (myDefaultPreferences == null){
				try {
					Class<?> activatorClazz = loadGeneratedClass(myGeneratedPlugin.getGenDiagram().getEditorGen().getPlugin().getActivatorQualifiedClassName());
					Field field = activatorClazz.getField("DIAGRAM_PREFERENCES_HINT");
					myDefaultPreferences = (PreferencesHint)field.get(null);
				} catch (Exception e) {
					myDefaultPreferences = PreferencesHint.USE_DEFAULTS;
				}
			}
			return myDefaultPreferences;
		}
		
	}
	
	// TODO: Merge with NoUpdateViewer
	protected static abstract class AbstractFakeViewer extends NoUpdateViewer {
		protected void createDefaultRoot() {
			// Important for MapModeUtil.getMapMode() method implementation.
			setRootEditPart(new ScalableRootEditPart() {
				protected ScalableLayeredPane createScaledLayers() {
					class LayeredPane extends ScalableLayeredPane implements IMapMode {

						public int DPtoLP(int deviceUnit) {
							return deviceUnit;
						}

						public Translatable DPtoLP(Translatable t) {
							t.performScale(1.0);
							return t;
						}

						public int LPtoDP(int logicalUnit) {
							return logicalUnit;
						}

						public Translatable LPtoDP(Translatable t) {
							t.performScale(1.0);
							return t;
						}
						
					}
					ScalableLayeredPane layers = new LayeredPane();
					layers.add(createGridLayer(), GRID_LAYER);
					layers.add(getPrintableLayers(), PRINTABLE_LAYERS);
					FreeformLayer feedbackLayer = new FreeformLayer();
					feedbackLayer.setEnabled(false);
					layers.add(feedbackLayer, SCALED_FEEDBACK_LAYER);
					return layers;
				}
			});
			//code from <...>GenDiagramEditor -- required to work with external labels
			LayerManager root = (LayerManager) getRootEditPart();
			LayeredPane printableLayers = (LayeredPane) root.getLayer(LayerConstants.PRINTABLE_LAYERS);
			FreeformLayer extLabelsLayer = new FreeformLayer();
			extLabelsLayer.setLayoutManager(new DelegatingLayout());
			printableLayers.addLayerAfter(extLabelsLayer, "External Node Labels", LayerConstants.PRIMARY_LAYER);
		}
	}

}
