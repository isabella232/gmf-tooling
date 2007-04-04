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
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.gmfgraph.LineKind;
import org.eclipse.gmf.gmfgraph.RoundedRectangle;
import org.eclipse.gmf.gmfgraph.Shape;
import org.eclipse.gmf.graphdef.editor.part.GMFGraphDiagramEditorPlugin;
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
	private Button myLINESOLIDLineKindRadio;

	/**
	 * @generated
	 */
	private Image myLINESOLIDLineKindRadio_image;

	/**
	 * @generated
	 */
	private Button myLINEDASHLineKindRadio;

	/**
	 * @generated
	 */
	private Image myLINEDASHLineKindRadio_image;

	/**
	 * @generated
	 */
	private Button myLINEDOTLineKindRadio;

	/**
	 * @generated
	 */
	private Image myLINEDOTLineKindRadio_image;

	/**
	 * @generated
	 */
	private Button myLINEDASHDOTLineKindRadio;

	/**
	 * @generated
	 */
	private Image myLINEDASHDOTLineKindRadio_image;

	/**
	 * @generated
	 */
	private Button myLINEDASHDOTDOTLineKindRadio;

	/**
	 * @generated
	 */
	private Image myLINEDASHDOTDOTLineKindRadio_image;

	/**
	 * @generated
	 */
	private Button myLINECUSTOMLineKindRadio;

	/**
	 * @generated
	 */
	private Image myLINECUSTOMLineKindRadio_image;

	/**
	 * @generated
	 */
	private Group myLineWidthGroup;

	/**
	 * @generated
	 */
	private Spinner myLineWidthLineWidthSpin;

	/**
	 * @generated
	 */
	private Group myMixStylesGroup;

	/**
	 * @generated
	 */
	private Button myFillMixStylesCheckbox;

	/**
	 * @generated
	 */
	private Button myOutlineMixStylesCheckbox;

	/**
	 * @generated
	 */
	private Button myXorFillMixStylesCheckbox;

	/**
	 * @generated
	 */
	private Button myXorOutlineMixStylesCheckbox;

	/**
	 * @generated
	 */
	private Group myRoundedRectangleGroup;

	/**
	 * @generated
	 */
	private Spinner myCornerWidthRoundedRectangleSpin;

	/**
	 * @generated
	 */
	private Spinner myCornerHeightRoundedRectangleSpin;

	/**
	 * @generated
	 */
	public void doCreateControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		Composite mainComposite = createMainWidget(parent);
		myLineKindGroup = createGroupWidget(mainComposite, "Line Style", null, null, null, null, true, true, false, false);

		myLINESOLIDLineKindRadio = createRadioButton(myLineKindGroup, "", null, null, null, null, true, true, false, false);
		myLINESOLIDLineKindRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_solid.png").createImage();
		myLINESOLIDLineKindRadio.setImage(myLINESOLIDLineKindRadio_image);

		getListener().startListeningTo(myLINESOLIDLineKindRadio);

		myLINEDASHLineKindRadio = createRadioButton(myLineKindGroup, "", null, myLINESOLIDLineKindRadio, null, null, false, true, false, false);
		myLINEDASHLineKindRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dash.png").createImage();
		myLINEDASHLineKindRadio.setImage(myLINEDASHLineKindRadio_image);

		getListener().startListeningTo(myLINEDASHLineKindRadio);

		myLINEDOTLineKindRadio = createRadioButton(myLineKindGroup, "", null, myLINEDASHLineKindRadio, null, null, false, true, false, false);
		myLINEDOTLineKindRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dot.png").createImage();
		myLINEDOTLineKindRadio.setImage(myLINEDOTLineKindRadio_image);

		getListener().startListeningTo(myLINEDOTLineKindRadio);

		myLINEDASHDOTLineKindRadio = createRadioButton(myLineKindGroup, "", null, myLINEDOTLineKindRadio, null, null, false, true, false, false);
		myLINEDASHDOTLineKindRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dashdot.png").createImage();
		myLINEDASHDOTLineKindRadio.setImage(myLINEDASHDOTLineKindRadio_image);

		getListener().startListeningTo(myLINEDASHDOTLineKindRadio);

		myLINEDASHDOTDOTLineKindRadio = createRadioButton(myLineKindGroup, "", null, myLINEDASHDOTLineKindRadio, null, null, false, true, false, false);
		myLINEDASHDOTDOTLineKindRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_dashdotdot.png").createImage();
		myLINEDASHDOTDOTLineKindRadio.setImage(myLINEDASHDOTDOTLineKindRadio_image);

		getListener().startListeningTo(myLINEDASHDOTDOTLineKindRadio);

		myLINECUSTOMLineKindRadio = createRadioButton(myLineKindGroup, "", null, myLINEDASHDOTDOTLineKindRadio, null, null, false, true, false, false);
		myLINECUSTOMLineKindRadio_image = GMFGraphDiagramEditorPlugin.findImageDescriptor("icons/line_custom.png").createImage();
		myLINECUSTOMLineKindRadio.setImage(myLINECUSTOMLineKindRadio_image);

		getListener().startListeningTo(myLINECUSTOMLineKindRadio);

		myLineWidthGroup = createGroupWidget(mainComposite, "Line Width", myLineKindGroup, null, null, null, true, false, false, false);

		myLineWidthLineWidthSpin = createSpinnerWidget(myLineWidthGroup, "", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myLineWidthLineWidthSpin);

		myMixStylesGroup = createGroupWidget(mainComposite, "Mix Styles", null, myLineWidthGroup, null, null, false, true, false, false);

		myFillMixStylesCheckbox = createCheckboxButton(myMixStylesGroup, getModelHelper().getNameMyFillMixStylesCheckboxFromMetamodel(), null, null, null, null, true, true, false, false);

		getListener().startListeningTo(myFillMixStylesCheckbox);

		myOutlineMixStylesCheckbox = createCheckboxButton(myMixStylesGroup, getModelHelper().getNameMyOutlineMixStylesCheckboxFromMetamodel(), null, myFillMixStylesCheckbox, null, null, false, true,
				true, false);

		getListener().startListeningTo(myOutlineMixStylesCheckbox);

		myXorFillMixStylesCheckbox = createCheckboxButton(myMixStylesGroup, getModelHelper().getNameMyXorFillMixStylesCheckboxFromMetamodel(), myFillMixStylesCheckbox, null, null, null, true, false,
				false, true);

		getListener().startListeningTo(myXorFillMixStylesCheckbox);

		myXorOutlineMixStylesCheckbox = createCheckboxButton(myMixStylesGroup, getModelHelper().getNameMyXorOutlineMixStylesCheckboxFromMetamodel(), myOutlineMixStylesCheckbox, null, null, null,
				true, false, true, true);

		getListener().startListeningTo(myXorOutlineMixStylesCheckbox);

		myRoundedRectangleGroup = createGroupWidget(mainComposite, "Corner Dimensions", null, myMixStylesGroup, null, null, false, true, false, false);

		myCornerWidthRoundedRectangleSpin = createSpinnerWidget(myRoundedRectangleGroup, "Width", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myCornerWidthRoundedRectangleSpin);

		myCornerHeightRoundedRectangleSpin = createSpinnerWidget(myRoundedRectangleGroup, "Height", 0, 999, 1, 100, myCornerWidthRoundedRectangleSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myCornerHeightRoundedRectangleSpin);

	}

	/**
	 * @generated
	 */
	public void doDispose() {
		getListener().stopListeningTo(myLINESOLIDLineKindRadio);

		myLINESOLIDLineKindRadio_image.dispose();
		myLINESOLIDLineKindRadio_image = null;

		getListener().stopListeningTo(myLINEDASHLineKindRadio);

		myLINEDASHLineKindRadio_image.dispose();
		myLINEDASHLineKindRadio_image = null;

		getListener().stopListeningTo(myLINEDOTLineKindRadio);

		myLINEDOTLineKindRadio_image.dispose();
		myLINEDOTLineKindRadio_image = null;

		getListener().stopListeningTo(myLINEDASHDOTLineKindRadio);

		myLINEDASHDOTLineKindRadio_image.dispose();
		myLINEDASHDOTLineKindRadio_image = null;

		getListener().stopListeningTo(myLINEDASHDOTDOTLineKindRadio);

		myLINEDASHDOTDOTLineKindRadio_image.dispose();
		myLINEDASHDOTDOTLineKindRadio_image = null;

		getListener().stopListeningTo(myLINECUSTOMLineKindRadio);

		myLINECUSTOMLineKindRadio_image.dispose();
		myLINECUSTOMLineKindRadio_image = null;

		getListener().stopListeningTo(myLineWidthLineWidthSpin);

		getListener().stopListeningTo(myFillMixStylesCheckbox);

		getListener().stopListeningTo(myOutlineMixStylesCheckbox);

		getListener().stopListeningTo(myXorFillMixStylesCheckbox);

		getListener().stopListeningTo(myXorOutlineMixStylesCheckbox);

		getListener().stopListeningTo(myCornerWidthRoundedRectangleSpin);

		getListener().stopListeningTo(myCornerHeightRoundedRectangleSpin);

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
			{
				myLINESOLIDLineKindRadio.setSelection(getModelHelper().getValueForMyLINESOLIDLineKindRadio(target));
			}
			{
				myLINEDASHLineKindRadio.setSelection(getModelHelper().getValueForMyLINEDASHLineKindRadio(target));
			}
			{
				myLINEDOTLineKindRadio.setSelection(getModelHelper().getValueForMyLINEDOTLineKindRadio(target));
			}
			{
				myLINEDASHDOTLineKindRadio.setSelection(getModelHelper().getValueForMyLINEDASHDOTLineKindRadio(target));
			}
			{
				myLINEDASHDOTDOTLineKindRadio.setSelection(getModelHelper().getValueForMyLINEDASHDOTDOTLineKindRadio(target));
			}
			{
				myLINECUSTOMLineKindRadio.setSelection(getModelHelper().getValueForMyLINECUSTOMLineKindRadio(target));
			}
		}
		{
			{
				myLineWidthLineWidthSpin.setSelection(getModelHelper().getValueForMyLineWidthLineWidthSpin(target));
			}
		}
		{
			{
				myFillMixStylesCheckbox.setSelection(getModelHelper().getValueForMyFillMixStylesCheckbox(target));
			}
			{
				myOutlineMixStylesCheckbox.setSelection(getModelHelper().getValueForMyOutlineMixStylesCheckbox(target));
			}
			{
				myXorFillMixStylesCheckbox.setSelection(getModelHelper().getValueForMyXorFillMixStylesCheckbox(target));
			}
			{
				myXorOutlineMixStylesCheckbox.setSelection(getModelHelper().getValueForMyXorOutlineMixStylesCheckbox(target));
			}
		}
		boolean isMyRoundedRectangleGroupVisible = getModelHelper().isVisibleMyRoundedRectangleGroup(target);

		myRoundedRectangleGroup.setVisible(isMyRoundedRectangleGroupVisible);
		if (isMyRoundedRectangleGroupVisible) {
			{
				myCornerWidthRoundedRectangleSpin.setSelection(getModelHelper().getValueForMyCornerWidthRoundedRectangleSpin(target));
			}
			{
				myCornerHeightRoundedRectangleSpin.setSelection(getModelHelper().getValueForMyCornerHeightRoundedRectangleSpin(target));
			}
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
	public void applyChangesFrom(final Widget widget, int kind) {
		String commandName = "Modifying model with ui data from " + widget.toString();
		ArrayList commands = new ArrayList(getSavedSelection().size());
		for (Iterator it = getSavedSelection().iterator(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof Shape) {
				final Shape target = (Shape) next;
				commands.add(createCommand(commandName, target, getModelModifierFor(target, widget, kind)));
			}
		}
		executeAsCompositeCommand(commandName, commands);
		//refresh();
	}

	/**
	 * @generated
	 */
	public Runnable getModelModifierFor(final Shape target, final Widget widget, int kind) {
		if (widget == myLINESOLIDLineKindRadio && myLINESOLIDLineKindRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myLINESOLIDLineKindRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyLINESOLIDLineKindRadio(target, value);
					}
				}
			};
		}

		if (widget == myLINEDASHLineKindRadio && myLINEDASHLineKindRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myLINEDASHLineKindRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyLINEDASHLineKindRadio(target, value);
					}
				}
			};
		}

		if (widget == myLINEDOTLineKindRadio && myLINEDOTLineKindRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myLINEDOTLineKindRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyLINEDOTLineKindRadio(target, value);
					}
				}
			};
		}

		if (widget == myLINEDASHDOTLineKindRadio && myLINEDASHDOTLineKindRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myLINEDASHDOTLineKindRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyLINEDASHDOTLineKindRadio(target, value);
					}
				}
			};
		}

		if (widget == myLINEDASHDOTDOTLineKindRadio && myLINEDASHDOTDOTLineKindRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myLINEDASHDOTDOTLineKindRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyLINEDASHDOTDOTLineKindRadio(target, value);
					}
				}
			};
		}

		if (widget == myLINECUSTOMLineKindRadio && myLINECUSTOMLineKindRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myLINECUSTOMLineKindRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyLINECUSTOMLineKindRadio(target, value);
					}
				}
			};
		}

		if (widget == myLineWidthLineWidthSpin && myLineWidthLineWidthSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myLineWidthLineWidthSpin.getSelection();
					getModelHelper().setValueForMyLineWidthLineWidthSpin(target, value);
				}
			};
		}

		if (widget == myFillMixStylesCheckbox && myFillMixStylesCheckbox.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myFillMixStylesCheckbox.getSelection();
					getModelHelper().setValueForMyFillMixStylesCheckbox(target, value);
				}
			};
		}

		if (widget == myOutlineMixStylesCheckbox && myOutlineMixStylesCheckbox.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myOutlineMixStylesCheckbox.getSelection();
					getModelHelper().setValueForMyOutlineMixStylesCheckbox(target, value);
				}
			};
		}

		if (widget == myXorFillMixStylesCheckbox && myXorFillMixStylesCheckbox.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myXorFillMixStylesCheckbox.getSelection();
					getModelHelper().setValueForMyXorFillMixStylesCheckbox(target, value);
				}
			};
		}

		if (widget == myXorOutlineMixStylesCheckbox && myXorOutlineMixStylesCheckbox.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myXorOutlineMixStylesCheckbox.getSelection();
					getModelHelper().setValueForMyXorOutlineMixStylesCheckbox(target, value);
				}
			};
		}

		if (widget == myCornerWidthRoundedRectangleSpin && myCornerWidthRoundedRectangleSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myCornerWidthRoundedRectangleSpin.getSelection();
					getModelHelper().setValueForMyCornerWidthRoundedRectangleSpin(target, value);
				}
			};
		}

		if (widget == myCornerHeightRoundedRectangleSpin && myCornerHeightRoundedRectangleSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myCornerHeightRoundedRectangleSpin.getSelection();
					getModelHelper().setValueForMyCornerHeightRoundedRectangleSpin(target, value);
				}
			};
		}

		// default:
		return new Runnable() {

			public void run() {
				// does nothing
			}
		};
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
		public boolean getValueForMyLINESOLIDLineKindRadio(Shape shape) {
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
		public void setValueForMyLINESOLIDLineKindRadio(Shape shape, boolean value) {

			shape.setLineKind(LineKind.LINE_SOLID_LITERAL);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINEDASHLineKindRadio(Shape shape) {
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
		public void setValueForMyLINEDASHLineKindRadio(Shape shape, boolean value) {

			shape.setLineKind(LineKind.LINE_DASH_LITERAL);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINEDOTLineKindRadio(Shape shape) {
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
		public void setValueForMyLINEDOTLineKindRadio(Shape shape, boolean value) {

			shape.setLineKind(LineKind.LINE_DOT_LITERAL);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINEDASHDOTLineKindRadio(Shape shape) {
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
		public void setValueForMyLINEDASHDOTLineKindRadio(Shape shape, boolean value) {

			shape.setLineKind(LineKind.LINE_DASHDOT_LITERAL);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINEDASHDOTDOTLineKindRadio(Shape shape) {
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
		public void setValueForMyLINEDASHDOTDOTLineKindRadio(Shape shape, boolean value) {

			shape.setLineKind(LineKind.LINE_DASHDOTDOT_LITERAL);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyLINECUSTOMLineKindRadio(Shape shape) {
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
		public void setValueForMyLINECUSTOMLineKindRadio(Shape shape, boolean value) {

			shape.setLineKind(LineKind.LINE_CUSTOM_LITERAL);

		}

		/**
		 * @generated
		 */
		public int getValueForMyLineWidthLineWidthSpin(Shape shape) {
			int value = 0;
			value = shape.getLineWidth();

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyLineWidthLineWidthSpin(Shape shape, int value) {

			shape.setLineWidth(value);

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyFillMixStylesCheckbox(Shape shape) {
			boolean value = false;
			value = shape.isFill();

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyFillMixStylesCheckbox(Shape shape, boolean value) {

			shape.setFill(value);

		}

		/**
		 * @generated
		 */
		public String getNameMyFillMixStylesCheckboxFromMetamodel() {
			return "Fill";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyOutlineMixStylesCheckbox(Shape shape) {
			boolean value = false;
			value = shape.isOutline();

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyOutlineMixStylesCheckbox(Shape shape, boolean value) {

			shape.setOutline(value);

		}

		/**
		 * @generated
		 */
		public String getNameMyOutlineMixStylesCheckboxFromMetamodel() {
			return "Outline";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyXorFillMixStylesCheckbox(Shape shape) {
			boolean value = false;
			value = shape.isXorFill();

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyXorFillMixStylesCheckbox(Shape shape, boolean value) {

			shape.setXorFill(value);

		}

		/**
		 * @generated
		 */
		public String getNameMyXorFillMixStylesCheckboxFromMetamodel() {
			return "XorFill";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyXorOutlineMixStylesCheckbox(Shape shape) {
			boolean value = false;
			value = shape.isXorOutline();

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyXorOutlineMixStylesCheckbox(Shape shape, boolean value) {

			shape.setXorOutline(value);

		}

		/**
		 * @generated
		 */
		public String getNameMyXorOutlineMixStylesCheckboxFromMetamodel() {
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
		public int getValueForMyCornerWidthRoundedRectangleSpin(Shape shape) {
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
		public void setValueForMyCornerWidthRoundedRectangleSpin(Shape shape, int value) {

			if (shape instanceof RoundedRectangle) {
				RoundedRectangle roundedRectangle = ((RoundedRectangle) shape);
				roundedRectangle.setCornerWidth(value);

			}

		}

		/**
		 * @generated
		 */
		public int getValueForMyCornerHeightRoundedRectangleSpin(Shape shape) {
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
		public void setValueForMyCornerHeightRoundedRectangleSpin(Shape shape, int value) {

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
