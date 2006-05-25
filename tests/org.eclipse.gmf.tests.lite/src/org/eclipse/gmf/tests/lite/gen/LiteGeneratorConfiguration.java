/*
 * Copyright (c) 2006 Borland Software Corporation
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

import java.util.Collection;

import junit.framework.Assert;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.EMFCommandOperation;
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
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.EPath;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;
import org.eclipse.gmf.tests.setup.GeneratorConfiguration;
import org.eclipse.gmf.tests.setup.NoUpdateViewer;
import org.eclipse.gmf.tests.setup.SessionSetup;


public class LiteGeneratorConfiguration extends RuntimeBasedGeneratorConfiguration {
	public GeneratorBase createGenerator(GenDiagram diagram) {
		return new Generator(diagram.getEditorGen());
	}

	protected GeneratorConfiguration.ViewerConfiguration createViewerConfiguration(SessionSetup sessionSetup, EditPartViewer viewer) throws Exception {
		return new LiteViewerConfiguration(sessionSetup, viewer);
	}

	protected EditPartViewer createViewerInstance() {
		return new FakeLiteViewer();
	}

	private static class LiteViewerConfiguration extends RuntimeBasedGeneratorConfiguration.DefaultViewerConfiguration {
		public LiteViewerConfiguration(SessionSetup sessionSetup, EditPartViewer viewer) throws Exception {
			super(sessionSetup, viewer);
		}

		public Command getCreateNodeCommand(View parentView, GenCommonBase nodeType) {
			try {
				Class requestClass = loadGeneratedClass(getGenModel().getGenDiagram().getPalette().getFactoryQualifiedClassName() + "$CreateRequestEx");
				CreateRequest req = (CreateRequest) requestClass.getConstructor(new Class[] {int[].class}).newInstance(new Object[] {new int[] {nodeType.getVisualID()}});
				req.setLocation(new Point(0,0));
				req.setSize(new Dimension(100, 100));
				Class factoryClass = loadGeneratedClass(getGenModel().getGenDiagram().getPalette().getFactoryQualifiedClassName() + "$ModelCreationFactory");
				CreationFactory factory = (CreationFactory) factoryClass.getConstructor(new Class[] {Class.class}).newInstance(new Object[] {Node.class});
				req.setFactory(factory);
				return findEditPart(parentView).getCommand(req);
			} catch (Exception e) {
				return null;
			}
		}

		public Command getCreateLinkCommand(View source, View target, GenCommonBase linkType) {
			try {
				Class requestClass = loadGeneratedClass(getGenModel().getGenDiagram().getPalette().getFactoryQualifiedClassName() + "$CreateConnectionRequestEx");
				CreateConnectionRequest req = (CreateConnectionRequest) requestClass.getConstructor(new Class[] {int[].class}).newInstance(new Object[] {new int[] {linkType.getVisualID()}});
				req.setType(RequestConstants.REQ_CONNECTION_END);
				EditPart sourceEditPart = findEditPart(source);
				Assert.assertNotNull(sourceEditPart);
				req.setSourceEditPart(sourceEditPart);
				EditPart targetEditPart = findEditPart(target);
				Assert.assertNotNull(targetEditPart);
				req.setTargetEditPart(targetEditPart);
				req.setStartCommand(getStartLinkCommand(source, linkType));
				return targetEditPart.getCommand(req);
			} catch (Exception e) {
				return null;
			}
		}

		public Command getStartLinkCommand(View source, GenCommonBase linkType) {
			try {
				Class requestClass = loadGeneratedClass(getGenModel().getGenDiagram().getPalette().getFactoryQualifiedClassName() + "$CreateConnectionRequestEx");
				CreateConnectionRequest req = (CreateConnectionRequest) requestClass.getConstructor(new Class[] {int[].class}).newInstance(new Object[] {new int[] {linkType.getVisualID()}});
				req.setType(RequestConstants.REQ_CONNECTION_START);
				EditPart sourceEditPart = findEditPart(source);
				Assert.assertNotNull(sourceEditPart);
				req.setSourceEditPart(sourceEditPart);
				return sourceEditPart.getCommand(req);
			} catch (Exception e) {
				return null;
			}
		}

		public Command getSetBusinessElementStructuralFeatureCommand(View view, String featureName, final Object value) {
			final EObject instance = view.getElement();
			Assert.assertNotNull("No business element bound to notation element", instance); //$NON-NLS-1$
			EObject resultObj = EPath.findLocalFeature(instance.eClass(), featureName);
			if (!(resultObj instanceof EStructuralFeature)) {
				throw new IllegalArgumentException("Not existing feature: " + featureName); //$NON-NLS-1$
			}
			final EStructuralFeature feature = (EStructuralFeature) resultObj;
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
						((Collection) instance.eGet(feature)).remove(value);
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
						((Collection) instance.eGet(feature)).add(value);

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

		protected TransactionalEditingDomain getEditDomain(EditPart editPart) {
			return TransactionUtil.getEditingDomain(editPart.getModel());
		}
		protected TransactionalEditingDomain getEditDomain(EObject object) {
			return TransactionUtil.getEditingDomain(object);
		}
	}

	private static class FakeLiteViewer extends NoUpdateViewer {
	}

	private static class WrappingCommand extends Command {
		private final IUndoableOperation operation;

		public WrappingCommand(TransactionalEditingDomain editingDomain,
				org.eclipse.emf.common.command.Command emfCommand) {
			this.operation = new EMFCommandOperation(editingDomain, emfCommand);
		}

		public void execute() {
			try {
				operation.execute(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Assert.fail("Exception occurred while executing operation");
			}
		}

		public boolean canExecute() {
			return operation.canExecute();
		}

		public void undo() {
			try {
				operation.undo(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Assert.fail("Exception occurred while executing operation");
			}
		}

		public boolean canUndo() {
			return operation.canUndo();
		}

		public void redo() {
			try {
				operation.redo(new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				Assert.fail("Exception occurred while executing operation");
			}
		}
	}
}
