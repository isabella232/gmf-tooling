/*
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Boris Blajer (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.gen;

import java.lang.reflect.Field;
import java.util.Collection;

import junit.framework.Assert;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.internal.codegen.lite.Generator;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.lite.edit.parts.update.TransactionalUpdateManager;
import org.eclipse.gmf.runtime.lite.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx;
import org.eclipse.gmf.runtime.lite.requests.CreateRequestEx;
import org.eclipse.gmf.runtime.lite.requests.ModelCreationFactory;
import org.eclipse.gmf.runtime.lite.services.IViewDecorator;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.setup.AbstractGeneratorConfiguration;
import org.eclipse.gmf.tests.setup.GeneratedDiagramPlugin;
import org.eclipse.gmf.tests.setup.ViewerConfiguration;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.plugin.AbstractUIPlugin;


public class LiteGeneratorConfiguration extends AbstractGeneratorConfiguration {

	public GeneratorBase createGenerator(GenDiagram diagram) {
		return new Generator(diagram.getEditorGen());
	}

	public ViewerConfiguration createViewerConfiguration(EditPartViewer viewer, GeneratedDiagramPlugin genPlugin){
		return new LiteViewerConfiguration(viewer, genPlugin);
	}

	protected EditPartViewer createViewerInstance() {
		return new FakeLiteViewer();
	}

	public static Diagram createDiagram(EObject domainElement, GeneratedDiagramPlugin genPlugin) {
		try {
			Diagram result = NotationFactory.eINSTANCE.createDiagram();
			result.setElement(domainElement);
			String diagramDecoratorClass = genPlugin.getGenDiagram().getNotationViewFactoryQualifiedClassName();
			Class<?> pluginClass = genPlugin.loadGeneratedClass(diagramDecoratorClass);
			Field field = pluginClass.getField("INSTANCE");
			IViewDecorator decorator = (IViewDecorator) field.get(null);
			decorator.decorateView(result);
			return result;
		} catch (Exception ex) {
			Assert.fail(ex.toString());
		}
		return null;
	}

	private static class LiteViewerConfiguration extends AbstractViewerConfiguration {
		public LiteViewerConfiguration(EditPartViewer viewer, GeneratedDiagramPlugin genPlugin) {
			super(viewer, genPlugin);
		}

		public Command getCreateNodeCommand(View parentView, GenCommonBase nodeType) {
			CreateRequest req = new CreateRequestEx(nodeType.getDiagram().getEditorGen().getModelID(), new int[] {nodeType.getVisualID()});
			req.setLocation(new Point(0,0));
			req.setSize(new Dimension(100, 100));
			CreationFactory factory = new ModelCreationFactory(Node.class);
			req.setFactory(factory);
			return findEditPart(parentView).getCommand(req);
		}

		public Command getCreateLinkCommand(View source, View target, GenCommonBase linkType) {
			CreateConnectionRequest req = new CreateConnectionRequestEx(linkType.getDiagram().getEditorGen().getModelID(), new int[] {linkType.getVisualID()});
			req.setType(RequestConstants.REQ_CONNECTION_END);
			EditPart sourceEditPart = findEditPart(source);
			Assert.assertNotNull(sourceEditPart);
			req.setSourceEditPart(sourceEditPart);
			EditPart targetEditPart = findEditPart(target);
			Assert.assertNotNull(targetEditPart);
			req.setTargetEditPart(targetEditPart);
			req.setStartCommand(getStartLinkCommand(source, linkType));
			return targetEditPart.getCommand(req);
		}

		public Command getStartLinkCommand(View source, GenCommonBase linkType) {
			CreateConnectionRequest req = new CreateConnectionRequestEx(linkType.getDiagram().getEditorGen().getModelID(), new int[] {linkType.getVisualID()});
			req.setType(RequestConstants.REQ_CONNECTION_START);
			EditPart sourceEditPart = findEditPart(source);
			Assert.assertNotNull(sourceEditPart);
			req.setTargetEditPart(sourceEditPart);
			return sourceEditPart.getCommand(req);
		}

		public Command getSetBusinessElementStructuralFeatureCommand(View view, String featureName, final Object value) {
			final EObject instance = view.getElement();
			Assert.assertNotNull("No business element bound to notation element", instance); //$NON-NLS-1$
			final EStructuralFeature feature = instance.eClass().getEStructuralFeature(featureName);
			if (feature == null) {
				throw new IllegalArgumentException("Not existing feature: " + featureName); //$NON-NLS-1$
			}
			TransactionalEditingDomain txEditDomain = getEditDomain(instance);
			return new WrappingCommand(txEditDomain, new AbstractCommand() {
				private Object oldValue;
				private boolean wasSet;
				public boolean canExecute() {
					return true;
				}
				public boolean canUndo() {
					return true;
				}
				public void undo() {
					if (!wasSet) {
						instance.eUnset(feature);
						return;
					}
					if (FeatureMapUtil.isMany(instance,feature)) {
						@SuppressWarnings("unchecked") Collection<Object> coll = (Collection<Object>) instance.eGet(feature);
						coll.remove(value);
					} else {
						instance.eSet(feature, oldValue);
					}
				}
				public void redo() {
					execute();
				}
				public void execute() {
					wasSet = instance.eIsSet(feature);
					if (FeatureMapUtil.isMany(instance,feature)) {
						@SuppressWarnings("unchecked") Collection<Object> coll = (Collection<Object>) instance.eGet(feature);
						coll.add(value);

					} else {
						oldValue = instance.eGet(feature);
						instance.eSet(feature, value);
					}
				}
			});
		}

		public Command getSetNotationalElementStructuralFeature(final View view, final EStructuralFeature feature, final Object value) {
			TransactionalEditingDomain txEditDomain = getEditDomain(view);
			return new WrappingCommand(txEditDomain, new AbstractCommand() {
				private Object oldValue;
				public boolean canExecute() {
					return true;
				}
				public boolean canUndo() {
					return true;
				}
				public void undo() {
					ViewUtil.setStructuralFeatureValue(view, feature, oldValue);
				}
				public void redo() {
					execute();
				}
				public void execute() {
					oldValue = ViewUtil.getStructuralFeatureValue(view, feature);
					ViewUtil.setStructuralFeatureValue(view, feature, value);
				}
			});
		}

		public RGB getDefaultLinkColor() {
			return PreferenceConverter.getColor(getDefaultPreferences(), IPreferenceConstants.LINE_COLOR);
		}

		@Override
		protected IPreferenceStore getDefaultPreferences() {
			if (myPreferenceStore == null) {
				try {
					Class<?> activatorClazz = loadGeneratedClass(getGenModel().getEditorGen().getPlugin().getActivatorQualifiedClassName());
					AbstractUIPlugin pluginInstance = (AbstractUIPlugin) activatorClazz.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
					myPreferenceStore = pluginInstance.getPreferenceStore();
				} catch (Throwable e) {
					Assert.fail("Failed to obtain default preferences");
				}
			}
			return myPreferenceStore;
		}

		protected TransactionalEditingDomain getEditDomain(EObject object) {
			return TransactionUtil.getEditingDomain(object);
		}

		private IPreferenceStore myPreferenceStore;
	}

	private static class FakeLiteViewer extends AbstractFakeViewer {
		@Override
		public Control createControl(Composite composite) {
			Control result = super.createControl(composite);
			final TransactionalUpdateManager updateManager = new TransactionalUpdateManager(this);
			setProperty(TransactionalUpdateManager.class.getName(), updateManager);
			result.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					updateManager.dispose();
				}
			});
			return result;
		}
	}
}
