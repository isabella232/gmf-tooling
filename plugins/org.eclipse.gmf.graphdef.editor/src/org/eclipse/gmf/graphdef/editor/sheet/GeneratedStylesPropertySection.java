/*
 *  Copyright (c) 2006, 2007 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.sheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import java.util.List;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.Shape;
import org.eclipse.gmf.graphdef.editor.part.GMFGraphDiagramEditorPlugin;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * @generated
 */
public class GeneratedStylesPropertySection extends AbstractCustomSectionParent {

	/**
	 * @generated
	 */
	private ModelHelper myModelHelper;

	/**
	 * @generated
	 */
	private Group myLineKindGroup;

	/**
	 * @generated
	 */
	private Button myLINESOLIDRadio;

	/**
	 * @generated
	 */
	private Image myLINESOLIDRadio_image;

	/**
	 * @generated
	 */
	private Button myLINEDASHRadio;

	/**
	 * @generated
	 */
	private Image myLINEDASHRadio_image;

	/**
	 * @generated
	 */
	private Button myLINEDOTRadio;

	/**
	 * @generated
	 */
	private Image myLINEDOTRadio_image;

	/**
	 * @generated
	 */
	private Button myLINEDASHDOTRadio;

	/**
	 * @generated
	 */
	private Image myLINEDASHDOTRadio_image;

	/**
	 * @generated
	 */
	private Button myLINEDASHDOTDOTRadio;

	/**
	 * @generated
	 */
	private Image myLINEDASHDOTDOTRadio_image;

	/**
	 * @generated
	 */
	private Button myLINECUSTOMRadio;

	/**
	 * @generated
	 */
	private Image myLINECUSTOMRadio_image;

	/**
	 * @generated
	 */
	private Group myLineWidthGroup;

	/**
	 * @generated
	 */
	private Spinner myLineWidthSpin;

	/**
	 * @generated
	 */
	private Group myMixStylesGroup;

	/**
	 * @generated
	 */
	private Button myFillCheckbox;

	/**
	 * @generated
	 */
	private Button myOutlineCheckbox;

	/**
	 * @generated
	 */
	private Button myXorFillCheckbox;

	/**
	 * @generated
	 */
	private Button myXorOutlineCheckbox;

	/**
	 * @generated
	 */
	private Group myRoundedRectangleGroup;

	/**
	 * @generated
	 */
	private Spinner myCornerWidthSpin;

	/**
	 * @generated
	 */
	private Spinner myCornerHeightSpin;

	/**
	 * @generated
	 */
	public void doCreateControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		Composite mainComposite = createMainWidget(parent);
		myLineKindGroup = createGroupWidget(mainComposite, "Line Style", null, null, null, null, true, true, false, false);

		myLINESOLIDRadio = createRadioButton(myLineKindGroup, "", null, null, null, null, true, true, false, false);
		myLINESOLIDRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_solid.png").createImage();
		myLINESOLIDRadio.setImage(myLINESOLIDRadio_image);

		getListener().startListeningTo(myLINESOLIDRadio);

		myLINEDASHRadio = createRadioButton(myLineKindGroup, "", null, myLINESOLIDRadio, null, null, false, true, false, false);
		myLINEDASHRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dash.png").createImage();
		myLINEDASHRadio.setImage(myLINEDASHRadio_image);

		getListener().startListeningTo(myLINEDASHRadio);

		myLINEDOTRadio = createRadioButton(myLineKindGroup, "", null, myLINEDASHRadio, null, null, false, true, false, false);
		myLINEDOTRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dot.png").createImage();
		myLINEDOTRadio.setImage(myLINEDOTRadio_image);

		getListener().startListeningTo(myLINEDOTRadio);

		myLINEDASHDOTRadio = createRadioButton(myLineKindGroup, "", null, myLINEDOTRadio, null, null, false, true, false, false);
		myLINEDASHDOTRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dashdot.png").createImage();
		myLINEDASHDOTRadio.setImage(myLINEDASHDOTRadio_image);

		getListener().startListeningTo(myLINEDASHDOTRadio);

		myLINEDASHDOTDOTRadio = createRadioButton(myLineKindGroup, "", null, myLINEDASHDOTRadio, null, null, false, true, false, false);
		myLINEDASHDOTDOTRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dashdotdot.png").createImage();
		myLINEDASHDOTDOTRadio.setImage(myLINEDASHDOTDOTRadio_image);

		getListener().startListeningTo(myLINEDASHDOTDOTRadio);

		myLINECUSTOMRadio = createRadioButton(myLineKindGroup, "", null, myLINEDASHDOTDOTRadio, null, null, false, true, false, false);
		myLINECUSTOMRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_custom.png").createImage();
		myLINECUSTOMRadio.setImage(myLINECUSTOMRadio_image);

		getListener().startListeningTo(myLINECUSTOMRadio);

		myLineWidthGroup = createGroupWidget(mainComposite, "Line Width", myLineKindGroup, null, null, null, true, false, false, false);

		myLineWidthSpin = createSpinnerWidget(myLineWidthGroup, "", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myLineWidthSpin);

		myMixStylesGroup = createGroupWidget(mainComposite, "Mix Styles", null, myLineWidthGroup, null, null, false, true, false, false);

		myFillCheckbox = createCheckboxButton(myMixStylesGroup, getModelHelper().getNameMyFillCheckboxFromMetamodel(), null, null, null, null, true, true, false, false);

		getListener().startListeningTo(myFillCheckbox);

		myOutlineCheckbox = createCheckboxButton(myMixStylesGroup, getModelHelper().getNameMyOutlineCheckboxFromMetamodel(), null, myFillCheckbox, null, null, false, true, true, false);

		getListener().startListeningTo(myOutlineCheckbox);

		myXorFillCheckbox = createCheckboxButton(myMixStylesGroup, getModelHelper().getNameMyXorFillCheckboxFromMetamodel(), myFillCheckbox, null, null, null, true, false, false, true);

		getListener().startListeningTo(myXorFillCheckbox);

		myXorOutlineCheckbox = createCheckboxButton(myMixStylesGroup, getModelHelper().getNameMyXorOutlineCheckboxFromMetamodel(), myOutlineCheckbox, null, null, null, true, false, true, true);

		getListener().startListeningTo(myXorOutlineCheckbox);

		myRoundedRectangleGroup = createGroupWidget(mainComposite, "Corner Dimensions", null, myMixStylesGroup, null, null, false, true, false, false);

		myCornerWidthSpin = createSpinnerWidget(myRoundedRectangleGroup, "Width", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myCornerWidthSpin);

		myCornerHeightSpin = createSpinnerWidget(myRoundedRectangleGroup, "Height", 0, 999, 1, 100, myCornerWidthSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myCornerHeightSpin);

	}

	/**
	 * @generated
	 */
	public void doDispose() {
		getListener().stopListeningTo(myLINESOLIDRadio);

		myLINESOLIDRadio_image.dispose();
		myLINESOLIDRadio_image = null;

		getListener().stopListeningTo(myLINEDASHRadio);

		myLINEDASHRadio_image.dispose();
		myLINEDASHRadio_image = null;

		getListener().stopListeningTo(myLINEDOTRadio);

		myLINEDOTRadio_image.dispose();
		myLINEDOTRadio_image = null;

		getListener().stopListeningTo(myLINEDASHDOTRadio);

		myLINEDASHDOTRadio_image.dispose();
		myLINEDASHDOTRadio_image = null;

		getListener().stopListeningTo(myLINEDASHDOTDOTRadio);

		myLINEDASHDOTDOTRadio_image.dispose();
		myLINEDASHDOTDOTRadio_image = null;

		getListener().stopListeningTo(myLINECUSTOMRadio);

		myLINECUSTOMRadio_image.dispose();
		myLINECUSTOMRadio_image = null;

		getListener().stopListeningTo(myLineWidthSpin);

		getListener().stopListeningTo(myFillCheckbox);

		getListener().stopListeningTo(myOutlineCheckbox);

		getListener().stopListeningTo(myXorFillCheckbox);

		getListener().stopListeningTo(myXorOutlineCheckbox);

		getListener().stopListeningTo(myCornerWidthSpin);

		getListener().stopListeningTo(myCornerHeightSpin);

	}

	/**
	 * @generated
	 */
	public void refresh() {
		getListener().startNonUserChange();
		for (Iterator it = getSavedSelection().iterator(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof Shape) {
				final Shape target = (Shape) next;
				executeAsReadAction(new Runnable() {

					public void run() {
						updateFromModel(target);
					}
				});
			}
		}
		getListener().finishNonUserChange();
	}

	/**
	 * @generated
	 */
	public void updateFromModel(Shape target) {
		boolean needToRelayoutExpandBar = false;

		{
			myLINESOLIDRadio.setSelection(getModelHelper().getValueForMyLINESOLIDRadio(target));
			myLINEDASHRadio.setSelection(getModelHelper().getValueForMyLINEDASHRadio(target));
			myLINEDOTRadio.setSelection(getModelHelper().getValueForMyLINEDOTRadio(target));
			myLINEDASHDOTRadio.setSelection(getModelHelper().getValueForMyLINEDASHDOTRadio(target));
			myLINEDASHDOTDOTRadio.setSelection(getModelHelper().getValueForMyLINEDASHDOTDOTRadio(target));
			myLINECUSTOMRadio.setSelection(getModelHelper().getValueForMyLINECUSTOMRadio(target));
		}
		{
			myLineWidthSpin.setSelection(getModelHelper().getValueForMyLineWidthSpin(target));
		}
		{
			myFillCheckbox.setSelection(getModelHelper().getValueForMyFillCheckbox(target));
			myOutlineCheckbox.setSelection(getModelHelper().getValueForMyOutlineCheckbox(target));
			myXorFillCheckbox.setSelection(getModelHelper().getValueForMyXorFillCheckbox(target));
			myXorOutlineCheckbox.setSelection(getModelHelper().getValueForMyXorOutlineCheckbox(target));
		}
		boolean isMyRoundedRectangleGroupVisible = getModelHelper().isVisibleMyRoundedRectangleGroup(target);

		myRoundedRectangleGroup.setVisible(isMyRoundedRectangleGroupVisible);
		if (isMyRoundedRectangleGroupVisible) {
			myCornerWidthSpin.setSelection(getModelHelper().getValueForMyCornerWidthSpin(target));
			myCornerHeightSpin.setSelection(getModelHelper().getValueForMyCornerHeightSpin(target));
		}
		if (needToRelayoutExpandBar) {
			relayoutExpandBar(null);
		}
	}

	/**
	 * @generated
	 */
	public ModelUpdater createModelUpdater() {
		return new ModelUpdater() {

			public void applyChangesFrom(Widget widget, int kind) {
				GeneratedStylesPropertySection.this.applyChangesFrom(widget, kind);
			}
		};
	}

	/**
	 * @generated
	 */
	public void applyChangesFrom(final Widget widget, int kindP) {
		final String commandName = "Modifying model with ui data from " + widget.toString();
		final int kind = kindP; // just to overcome jmerge limitation
		ArrayList commands = new ArrayList(getSavedSelection().size());
		for (Iterator it = getSavedSelection().iterator(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof Shape) {
				final Shape target = (Shape) next;
				final List files = Collections.singletonList(WorkspaceSynchronizer.getFile(target.eResource()));
				AbstractTransactionalCommand command = new AbstractTransactionalCommand(getEditingDomain(), commandName, files) {

					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						// XXX perhaps, should pass collection of targets instead of multiple commands?
						applyModelModifier(target, widget, kind);
						return CommandResult.newOKCommandResult();
					}
				};

				commands.add(command);
			}
		}
		executeAsCompositeCommand(commandName, commands);
		//refresh();
	}

	/**
	 * @generated
	 */
	void applyModelModifier(final Shape target, final Widget widget, int kind) {
		if (widget == myLINESOLIDRadio && myLINESOLIDRadio.isVisible()) {
			if (myLINESOLIDRadio.getSelection()) {
				getModelHelper().setValueForMyLINESOLIDRadio(target, true);
			}
			return;
		}
		if (widget == myLINEDASHRadio && myLINEDASHRadio.isVisible()) {
			if (myLINEDASHRadio.getSelection()) {
				getModelHelper().setValueForMyLINEDASHRadio(target, true);
			}
			return;
		}
		if (widget == myLINEDOTRadio && myLINEDOTRadio.isVisible()) {
			if (myLINEDOTRadio.getSelection()) {
				getModelHelper().setValueForMyLINEDOTRadio(target, true);
			}
			return;
		}
		if (widget == myLINEDASHDOTRadio && myLINEDASHDOTRadio.isVisible()) {
			if (myLINEDASHDOTRadio.getSelection()) {
				getModelHelper().setValueForMyLINEDASHDOTRadio(target, true);
			}
			return;
		}
		if (widget == myLINEDASHDOTDOTRadio && myLINEDASHDOTDOTRadio.isVisible()) {
			if (myLINEDASHDOTDOTRadio.getSelection()) {
				getModelHelper().setValueForMyLINEDASHDOTDOTRadio(target, true);
			}
			return;
		}
		if (widget == myLINECUSTOMRadio && myLINECUSTOMRadio.isVisible()) {
			if (myLINECUSTOMRadio.getSelection()) {
				getModelHelper().setValueForMyLINECUSTOMRadio(target, true);
			}
			return;
		}
		if (widget == myLineWidthSpin && myLineWidthSpin.isVisible()) {
			getModelHelper().setValueForMyLineWidthSpin(target, myLineWidthSpin.getSelection());
			return;
		}
		if (widget == myFillCheckbox && myFillCheckbox.isVisible()) {
			getModelHelper().setValueForMyFillCheckbox(target, myFillCheckbox.getSelection());
			return;
		}
		if (widget == myOutlineCheckbox && myOutlineCheckbox.isVisible()) {
			getModelHelper().setValueForMyOutlineCheckbox(target, myOutlineCheckbox.getSelection());
			return;
		}
		if (widget == myXorFillCheckbox && myXorFillCheckbox.isVisible()) {
			getModelHelper().setValueForMyXorFillCheckbox(target, myXorFillCheckbox.getSelection());
			return;
		}
		if (widget == myXorOutlineCheckbox && myXorOutlineCheckbox.isVisible()) {
			getModelHelper().setValueForMyXorOutlineCheckbox(target, myXorOutlineCheckbox.getSelection());
			return;
		}
		if (widget == myCornerWidthSpin && myCornerWidthSpin.isVisible()) {
			getModelHelper().setValueForMyCornerWidthSpin(target, myCornerWidthSpin.getSelection());
			return;
		}
		if (widget == myCornerHeightSpin && myCornerHeightSpin.isVisible()) {
			getModelHelper().setValueForMyCornerHeightSpin(target, myCornerHeightSpin.getSelection());
			return;
		}
	}

	/**
	 * @generated
	 */
	protected ModelHelper getModelHelper() {
		if (myModelHelper == null) {
			myModelHelper = new ModelHelper();
		}
		return myModelHelper;
	}

	/**
	 * @generated
	 */
	public final class ModelHelper {

		/**
		 * @generated
		 */
		public String getNameMyGeneratedStylesGroupFromMetamodel() {
			return "Shape";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINESOLIDRadio(Shape shape) {
			boolean value = false;
			if (shape.getLineKind() != null) {
				LineKind lineKind = shape.getLineKind();
				value = (lineKind.getValue() == LineKind.LINE_SOLID);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyLINESOLIDRadio(Shape shape, boolean value) {
			shape.setLineKind(LineKind.LINE_SOLID_LITERAL);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINEDASHRadio(Shape shape) {
			boolean value = false;
			if (shape.getLineKind() != null) {
				LineKind lineKind = shape.getLineKind();
				value = (lineKind.getValue() == LineKind.LINE_DASH);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyLINEDASHRadio(Shape shape, boolean value) {
			shape.setLineKind(LineKind.LINE_DASH_LITERAL);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINEDOTRadio(Shape shape) {
			boolean value = false;
			if (shape.getLineKind() != null) {
				LineKind lineKind = shape.getLineKind();
				value = (lineKind.getValue() == LineKind.LINE_DOT);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyLINEDOTRadio(Shape shape, boolean value) {
			shape.setLineKind(LineKind.LINE_DOT_LITERAL);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINEDASHDOTRadio(Shape shape) {
			boolean value = false;
			if (shape.getLineKind() != null) {
				LineKind lineKind = shape.getLineKind();
				value = (lineKind.getValue() == LineKind.LINE_DASHDOT);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyLINEDASHDOTRadio(Shape shape, boolean value) {
			shape.setLineKind(LineKind.LINE_DASHDOT_LITERAL);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINEDASHDOTDOTRadio(Shape shape) {
			boolean value = false;
			if (shape.getLineKind() != null) {
				LineKind lineKind = shape.getLineKind();
				value = (lineKind.getValue() == LineKind.LINE_DASHDOTDOT);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyLINEDASHDOTDOTRadio(Shape shape, boolean value) {
			shape.setLineKind(LineKind.LINE_DASHDOTDOT_LITERAL);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINECUSTOMRadio(Shape shape) {
			boolean value = false;
			if (shape.getLineKind() != null) {
				LineKind lineKind = shape.getLineKind();
				value = (lineKind.getValue() == LineKind.LINE_CUSTOM);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyLINECUSTOMRadio(Shape shape, boolean value) {
			shape.setLineKind(LineKind.LINE_CUSTOM_LITERAL);

		}

		/**
		 * @generated
		 */
		public int getValueForMyLineWidthSpin(Shape shape) {
			int value = 0;
			value = shape.getLineWidth();

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyLineWidthSpin(Shape shape, int value) {

			shape.setLineWidth(value);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyFillCheckbox(Shape shape) {
			boolean value = false;
			value = shape.isFill();

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyFillCheckbox(Shape shape, boolean value) {

			shape.setFill(value);

		}

		/**
		 * @generated
		 */
		public String getNameMyFillCheckboxFromMetamodel() {
			return "Fill";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyOutlineCheckbox(Shape shape) {
			boolean value = false;
			value = shape.isOutline();

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyOutlineCheckbox(Shape shape, boolean value) {

			shape.setOutline(value);

		}

		/**
		 * @generated
		 */
		public String getNameMyOutlineCheckboxFromMetamodel() {
			return "Outline";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyXorFillCheckbox(Shape shape) {
			boolean value = false;
			value = shape.isXorFill();

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyXorFillCheckbox(Shape shape, boolean value) {

			shape.setXorFill(value);

		}

		/**
		 * @generated
		 */
		public String getNameMyXorFillCheckboxFromMetamodel() {
			return "XorFill";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyXorOutlineCheckbox(Shape shape) {
			boolean value = false;
			value = shape.isXorOutline();

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyXorOutlineCheckbox(Shape shape, boolean value) {

			shape.setXorOutline(value);

		}

		/**
		 * @generated
		 */
		public String getNameMyXorOutlineCheckboxFromMetamodel() {
			return "XorOutline";
		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyRoundedRectangleGroup(Shape targetVar) {
			boolean value = false;
			value = (targetVar instanceof RoundedRectangle);

			return value;
		}

		/**
		 * @generated
		 */
		public int getValueForMyCornerWidthSpin(Shape shape) {
			int value = 0;
			if (shape instanceof RoundedRectangle) {
				RoundedRectangle roundedRectangle = ((RoundedRectangle) shape);
				value = roundedRectangle.getCornerWidth();

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyCornerWidthSpin(Shape shape, int value) {

			if (shape instanceof RoundedRectangle) {
				RoundedRectangle roundedRectangle = ((RoundedRectangle) shape);
				roundedRectangle.setCornerWidth(value);

			}

		}

		/**
		 * @generated
		 */
		public int getValueForMyCornerHeightSpin(Shape shape) {
			int value = 0;
			if (shape instanceof RoundedRectangle) {
				RoundedRectangle roundedRectangle = ((RoundedRectangle) shape);
				value = roundedRectangle.getCornerHeight();

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyCornerHeightSpin(Shape shape, int value) {

			if (shape instanceof RoundedRectangle) {
				RoundedRectangle roundedRectangle = ((RoundedRectangle) shape);
				roundedRectangle.setCornerHeight(value);

			}

		}

		/**
		 * @generated
		 */
		protected EObject cloneVars(EObject target) {
			return target;
		}
	}

}
