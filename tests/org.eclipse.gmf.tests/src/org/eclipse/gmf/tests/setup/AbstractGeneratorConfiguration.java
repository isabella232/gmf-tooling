/**
 * Copyright (c) 2006 Eclipse.org
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
import org.osgi.framework.Bundle;


public abstract class AbstractGeneratorConfiguration implements GeneratorConfiguration {
	
	public ViewerConfiguration createViewerConfiguration(Composite parent, SessionSetup sessionSetup, Diagram canvas) throws Exception {
		EditPartViewer viewer = createViewer(parent, sessionSetup, canvas);
		return createViewerConfiguration(sessionSetup, viewer);
	}

	public EditPartViewer createViewer(Composite parent, SessionSetup sessionSetup, Diagram canvas) throws Exception {
		// make sure there's display for current thread
		Display.getDefault();
	
		EditPartViewer gv = createViewerInstance();
		gv.createControl(parent);
		DiagramEditDomain ded = new DiagramEditDomain(null);
		gv.setEditDomain(ded);
		gv.getEditDomain().setCommandStack(new DiagramCommandStack(ded));

		String epFactoryClassName = sessionSetup.getGenModel().getGenDiagram().getEditPartFactoryQualifiedClassName();
		Class epFactory = sessionSetup.getGenProject().getBundle().loadClass(epFactoryClassName);
		assert EditPartFactory.class.isAssignableFrom(epFactory);
		gv.setEditPartFactory((EditPartFactory) epFactory.newInstance());
		gv.setContents(canvas);
		
		return gv;
	}

	protected abstract EditPartViewer createViewerInstance();
	
	public abstract ViewerConfiguration createViewerConfiguration(SessionSetup sessionSetup, EditPartViewer viewer) throws Exception;
	
	protected static abstract class AbstractViewerConfiguration implements ViewerConfiguration {
		
		private EditPartViewer myViewer;
		private SessionSetup mySessionSetup;
		private Bundle myGenProject;
		private PreferencesHint myDefaultPreferences;

		public AbstractViewerConfiguration(SessionSetup sessionSetup, EditPartViewer viewer) throws Exception {
			myViewer = viewer;
			mySessionSetup = sessionSetup;
			myGenProject = sessionSetup.getGenProject().getBundle();
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
		
		protected final Class loadGeneratedClass(String qualifiedClassName) throws ClassNotFoundException {
			return myGenProject.loadClass(qualifiedClassName);
		}
		
		protected DiaGenSource getGenModel() {
			return mySessionSetup.getGenModel();
		}
		
		protected IPreferenceStore getDefaultPreferences() {
			if (myDefaultPreferences == null){
				try {
					Class activatorClazz = loadGeneratedClass(mySessionSetup.getGenModel().getGenDiagram().getEditorGen().getPlugin().getActivatorQualifiedClassName());
					Field field = activatorClazz.getField("DIAGRAM_PREFERENCES_HINT");
					myDefaultPreferences = (PreferencesHint)field.get(null);
				} catch (ClassNotFoundException e) {
					myDefaultPreferences = PreferencesHint.USE_DEFAULTS;
				} catch (SecurityException e) {
					myDefaultPreferences = PreferencesHint.USE_DEFAULTS;
				} catch (NoSuchFieldException e) {
					myDefaultPreferences = PreferencesHint.USE_DEFAULTS;
				} catch (IllegalAccessException e) {
					myDefaultPreferences = PreferencesHint.USE_DEFAULTS;
				}
			}
			return (IPreferenceStore) myDefaultPreferences.getPreferenceStore();
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
