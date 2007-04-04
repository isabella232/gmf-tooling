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
import org.eclipse.gmf.gmfgraph.Alignment;
import org.eclipse.gmf.gmfgraph.BorderLayout;
import org.eclipse.gmf.gmfgraph.BorderLayoutData;
import org.eclipse.gmf.gmfgraph.CustomLayout;
import org.eclipse.gmf.gmfgraph.CustomLayoutData;
import org.eclipse.gmf.gmfgraph.Dimension;
import org.eclipse.gmf.gmfgraph.FlowLayout;
import org.eclipse.gmf.gmfgraph.GMFGraphFactory;
import org.eclipse.gmf.gmfgraph.GridLayout;
import org.eclipse.gmf.gmfgraph.GridLayoutData;
import org.eclipse.gmf.gmfgraph.Layout;
import org.eclipse.gmf.gmfgraph.LayoutData;
import org.eclipse.gmf.gmfgraph.Layoutable;
import org.eclipse.gmf.gmfgraph.Point;
import org.eclipse.gmf.gmfgraph.StackLayout;
import org.eclipse.gmf.gmfgraph.XYLayout;
import org.eclipse.gmf.gmfgraph.XYLayoutData;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * @generated
 */
public class GeneratedLayoutPropertySection extends AbstractCustomSectionParent {

	/**
	 * @generated
	 */
	private ModelHelper myModelHelper;

	/**
	 * @generated
	 */
	private Group myMyLayoutGroupGroup;

	/**
	 * @generated
	 */
	private Composite myMyLayoutKindGroupMyLayoutGroupComposite;

	/**
	 * @generated
	 */
	private Button myMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Composite myMyExpandBarMyLayoutGroupComposite;

	/**
	 * @generated
	 */
	private ExpandableComposite myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite;

	/**
	 * @generated
	 */
	private Group mySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupGroup;

	/**
	 * @generated
	 */
	private Spinner myDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin;

	/**
	 * @generated
	 */
	private Spinner myDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin;

	/**
	 * @generated
	 */
	private ExpandableComposite myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite;

	/**
	 * @generated
	 */
	private Group myLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup;

	/**
	 * @generated
	 */
	private Button mySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox;

	/**
	 * @generated
	 */
	private Button myMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox;

	/**
	 * @generated
	 */
	private Group mySpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup;

	/**
	 * @generated
	 */
	private Spinner myMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin;

	/**
	 * @generated
	 */
	private Spinner myMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin;

	/**
	 * @generated
	 */
	private Group myMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup;

	/**
	 * @generated
	 */
	private CLabel myMinorTopEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupLabel;

	/**
	 * @generated
	 */
	private Button myMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Group myMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup;

	/**
	 * @generated
	 */
	private CLabel myMajorTopEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupLabel;

	/**
	 * @generated
	 */
	private Button myMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private Button myMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio;

	/**
	 * @generated
	 */
	private ExpandableComposite myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite;

	/**
	 * @generated
	 */
	private Group myLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup;

	/**
	 * @generated
	 */
	private Spinner myNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin;

	/**
	 * @generated
	 */
	private Button myEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox;

	/**
	 * @generated
	 */
	private Group myMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup;

	/**
	 * @generated
	 */
	private Spinner myDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin;

	/**
	 * @generated
	 */
	private Spinner myDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin;

	/**
	 * @generated
	 */
	private Group mySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup;

	/**
	 * @generated
	 */
	private Spinner myDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin;

	/**
	 * @generated
	 */
	private Spinner myDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin;

	/**
	 * @generated
	 */
	private ExpandableComposite myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableComposite;

	/**
	 * @generated
	 */
	private Group myLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupGroup;

	/**
	 * @generated
	 */
	private Text myBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText;

	/**
	 * @generated
	 */
	private Text myQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText;

	/**
	 * @generated
	 */
	private Composite myMyLayoutDataCompositeComposite;

	/**
	 * @generated
	 */
	private Group myBorderLayoutDataGroupMyLayoutDataCompositeGroup;

	/**
	 * @generated
	 */
	private Composite myWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeComposite;

	/**
	 * @generated
	 */
	private CLabel myUpperEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeLabel;

	/**
	 * @generated
	 */
	private Button myBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Button myBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Button myBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Button myBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Button myBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Group myMyXYLayoutDataGroupMyLayoutDataCompositeGroup;

	/**
	 * @generated
	 */
	private Group myMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeGroup;

	/**
	 * @generated
	 */
	private Spinner myMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin;

	/**
	 * @generated
	 */
	private Spinner myMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin;

	/**
	 * @generated
	 */
	private Group myMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeGroup;

	/**
	 * @generated
	 */
	private Spinner myMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin;

	/**
	 * @generated
	 */
	private Spinner myMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin;

	/**
	 * @generated
	 */
	private Group myMyGridLayoutDataGroupMyLayoutDataCompositeGroup;

	/**
	 * @generated
	 */
	private Button myGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox;

	/**
	 * @generated
	 */
	private Button myGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox;

	/**
	 * @generated
	 */
	private Group myVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup;

	/**
	 * @generated
	 */
	private Button myBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Button myCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Button myENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Button myFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Group myHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup;

	/**
	 * @generated
	 */
	private Button myBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Button myCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Button myENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Button myFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio;

	/**
	 * @generated
	 */
	private Group mySpanningsMyGridLayoutDataGroupMyLayoutDataCompositeGroup;

	/**
	 * @generated
	 */
	private Spinner myVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin;

	/**
	 * @generated
	 */
	private Spinner myHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin;

	/**
	 * @generated
	 */
	private Group mySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeGroup;

	/**
	 * @generated
	 */
	private Spinner myDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin;

	/**
	 * @generated
	 */
	private Spinner myDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin;

	/**
	 * @generated
	 */
	private Spinner myHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin;

	/**
	 * @generated
	 */
	private Group myMyCustomLayoutDataGroupMyLayoutDataCompositeGroup;

	/**
	 * @generated
	 */
	private Text myBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText;

	/**
	 * @generated
	 */
	private Text myQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText;

	/**
	 * @generated
	 */
	public void doCreateControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		Composite mainComposite = createMainWidget(parent);
		myMyLayoutGroupGroup = createGroupWidget(mainComposite, "Layout Manager", null, null, null, null, true, true, false, false);

		myMyLayoutKindGroupMyLayoutGroupComposite = createCompositeWidget(myMyLayoutGroupGroup, "", null, null, null, null, true, true, false, false);

		myMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio = createRadioButton(myMyLayoutKindGroupMyLayoutGroupComposite, getModelHelper()
				.getNameMyMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel(), null, null, null, null, true, true, false, false);

		getListener().startListeningTo(myMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		myMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio = createRadioButton(myMyLayoutKindGroupMyLayoutGroupComposite, getModelHelper()
				.getNameMyMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel(), null, myMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		myMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio = createRadioButton(myMyLayoutKindGroupMyLayoutGroupComposite, getModelHelper()
				.getNameMyMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel(), null, myMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		myMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio = createRadioButton(myMyLayoutKindGroupMyLayoutGroupComposite, getModelHelper()
				.getNameMyMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel(), null, myMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		myMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio = createRadioButton(myMyLayoutKindGroupMyLayoutGroupComposite, getModelHelper()
				.getNameMyMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel(), null, myMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		myMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio = createRadioButton(myMyLayoutKindGroupMyLayoutGroupComposite, getModelHelper()
				.getNameMyMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel(), null, myMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		myMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio = createRadioButton(myMyLayoutKindGroupMyLayoutGroupComposite, "No Layout", null, myMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio,
				null, null, false, true, false, false);

		getListener().startListeningTo(myMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		myMyExpandBarMyLayoutGroupComposite = createCompositeWidget(myMyLayoutGroupGroup, "", myMyLayoutKindGroupMyLayoutGroupComposite, null, null, null, true, false, false, false);

		myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite = createExpandableComposite(myMyExpandBarMyLayoutGroupComposite, getModelHelper()
				.getNameMyMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeFromMetamodel(), null, null, null, null, true, true, false, false);
		Composite myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl = createCompositeWidget(myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite, "",
				null, null, null, null, true, true, false, false);

		mySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupGroup = createGroupWidget(myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl, getModelHelper()
				.getNameMySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupGroupFromMetamodel(), null, null, null, null, true, true, false, false);

		myDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin = createSpinnerWidget(mySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupGroup, "Horizontal", 0, 999, 1, 100, null,
				null, null, null, true, true, false, false);
		getListener().startListeningTo(myDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin);

		myDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin = createSpinnerWidget(mySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupGroup, "Vertical", 0, 999, 1, 100,
				myDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin);

		myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.setClient(myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl);
		myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.addExpansionListener(getExpansionListener(myMyExpandBarMyLayoutGroupComposite));

		myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite = createExpandableComposite(myMyExpandBarMyLayoutGroupComposite, getModelHelper()
				.getNameMyMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeFromMetamodel(), null, myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite, null, null,
				false, true, false, false);
		Composite myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl = createCompositeWidget(myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite, "", null,
				myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite, null, null, false, true, false, false);

		myLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup = createGroupWidget(myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl, "Layout Parameters",
				null, null, null, null, true, true, false, false);

		mySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox = createCheckboxButton(myLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				getModelHelper().getNameMySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckboxFromMetamodel(), null, null, null, null, true, true, false, false);

		getListener().startListeningTo(mySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox);

		myMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox = createCheckboxButton(myLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				getModelHelper().getNameMyMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckboxFromMetamodel(),
				mySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox);

		mySpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup = createGroupWidget(myLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup, "Spacings", null,
				mySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox, null, null, false, true, false, false);

		myMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin = createSpinnerWidget(mySpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"Minor", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin);

		myMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin = createSpinnerWidget(mySpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"Major", 0, 999, 1, 100, myMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin);

		myMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup = createGroupWidget(myLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup, getModelHelper()
				.getNameMyMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroupFromMetamodel(), null,
				mySpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup, null, null, false, true, false, false);

		myMinorTopEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupLabel = createLabelWidget(myMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"       ", null, null, null, null, true, true, false, false);

		myMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio = createRadioButton(myMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"N", myMinorTopEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupLabel, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio = createRadioButton(myMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"E", null, myMinorTopEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupLabel, null, null, false, true, false, false);

		getListener().startListeningTo(myMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio = createRadioButton(myMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"C", myMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio = createRadioButton(myMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"W", myMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio = createRadioButton(myMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"S", null, myMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup = createGroupWidget(myLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup, getModelHelper()
				.getNameMyMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroupFromMetamodel(),
				myMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup, null, null, null, true, false, false, false);

		myMajorTopEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupLabel = createLabelWidget(myMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"       ", null, null, null, null, true, true, false, false);

		myMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio = createRadioButton(myMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"N", myMajorTopEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupLabel, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio = createRadioButton(myMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"E", null, myMajorTopEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupLabel, null, null, false, true, false, false);

		getListener().startListeningTo(myMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio = createRadioButton(myMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"C", myMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio = createRadioButton(myMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"W", myMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio = createRadioButton(myMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroup,
				"S", null, myMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.setClient(myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl);
		myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.addExpansionListener(getExpansionListener(myMyExpandBarMyLayoutGroupComposite));

		myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite = createExpandableComposite(myMyExpandBarMyLayoutGroupComposite, getModelHelper()
				.getNameMyMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeFromMetamodel(), null, myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite, null, null,
				false, true, false, false);
		Composite myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl = createCompositeWidget(myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite, "", null,
				myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite, null, null, false, true, false, false);

		myLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup = createGroupWidget(myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl, "Layout Parameters",
				null, null, null, null, true, true, false, false);

		myNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin = createSpinnerWidget(myLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup, getModelHelper()
				.getNameMyNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpinFromMetamodel(), 1, 99, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin);

		myEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox = createCheckboxButton(myLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup,
				getModelHelper().getNameMyEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckboxFromMetamodel(),
				myNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin, null, null, null, true, false, false, false);

		getListener().startListeningTo(myEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox);

		myMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup = createGroupWidget(myLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup, getModelHelper()
				.getNameMyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroupFromMetamodel(), null,
				myNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin, null, null, false, true, false, false);

		myDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin = createSpinnerWidget(myMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup,
				"Horizontal", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin);

		myDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin = createSpinnerWidget(myMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup, "Vertical",
				0, 999, 1, 100, myDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin);

		mySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup = createGroupWidget(myLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup, getModelHelper()
				.getNameMySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroupFromMetamodel(), null,
				myMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup, null, null, false, true, false, false);

		myDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin = createSpinnerWidget(mySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup, "X", 0,
				999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin);

		myDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin = createSpinnerWidget(mySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroup, "Y", 0,
				999, 1, 100, myDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin);

		myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.setClient(myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl);
		myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.addExpansionListener(getExpansionListener(myMyExpandBarMyLayoutGroupComposite));

		myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableComposite = createExpandableComposite(myMyExpandBarMyLayoutGroupComposite, getModelHelper()
				.getNameMyMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeFromMetamodel(), null, myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite, null, null,
				false, true, false, false);
		Composite myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl = createCompositeWidget(myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableComposite, "",
				null, myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite, null, null, false, true, false, false);

		myLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupGroup = createGroupWidget(myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl,
				"Layout Parameters", null, null, null, null, true, true, false, false);

		myBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText = createTextWidget(myLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupGroup, getModelHelper()
				.getNameMyBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupTextFromMetamodel(), null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText);

		myQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText = createTextWidget(myLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupGroup,
				getModelHelper().getNameMyQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupTextFromMetamodel(), null,
				myBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText, null, null, false, true, false, false);
		getListener().startListeningTo(myQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText);

		myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.setClient(myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeControl);
		myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.addExpansionListener(getExpansionListener(myMyExpandBarMyLayoutGroupComposite));

		myMyLayoutDataCompositeComposite = createCompositeWidget(mainComposite, "", myMyLayoutGroupGroup, null, null, null, true, false, false, true);

		myBorderLayoutDataGroupMyLayoutDataCompositeGroup = createGroupWidget(myMyLayoutDataCompositeComposite, getModelHelper()
				.getNameMyBorderLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel(), null, null, null, null, true, true, false, false);

		myWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeComposite = createCompositeWidget(myBorderLayoutDataGroupMyLayoutDataCompositeGroup, "", null, null, null, null, true, true, false, false);

		myUpperEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeLabel = createLabelWidget(myWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeComposite, "       ", null, null, null, null, true,
				true, false, false);

		myBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeComposite, "N",
				myUpperEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeLabel, null, null, null, true, false, false, false);

		getListener().startListeningTo(myBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio);

		myBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeComposite, "E", null,
				myUpperEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeLabel, null, null, false, true, false, false);

		getListener().startListeningTo(myBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio);

		myBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeComposite, "C",
				myBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio, null, null, null, true, false, false, false);

		getListener().startListeningTo(myBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio);

		myBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeComposite, "W",
				myBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio, null, null, null, true, false, false, true);

		getListener().startListeningTo(myBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio);

		myBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeComposite, "S", null,
				myBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio, null, null, false, true, true, false);

		getListener().startListeningTo(myBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio);

		myMyXYLayoutDataGroupMyLayoutDataCompositeGroup = createGroupWidget(myMyLayoutDataCompositeComposite, getModelHelper().getNameMyMyXYLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel(),
				null, null, null, null, true, true, false, false);

		myMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeGroup = createGroupWidget(myMyXYLayoutDataGroupMyLayoutDataCompositeGroup, "Top Left Position", null, null, null, null, true,
				true, false, false);

		myMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin = createSpinnerWidget(myMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpinFromMetamodel(), 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin);

		myMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin = createSpinnerWidget(myMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpinFromMetamodel(), 0, 999, 1, 100,
				myMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin);

		myMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeGroup = createGroupWidget(myMyXYLayoutDataGroupMyLayoutDataCompositeGroup, "Size Constraints", null,
				myMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeGroup, null, null, false, true, false, false);

		myMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin = createSpinnerWidget(myMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeGroup, "X", 0, 999, 1, 100,
				null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin);

		myMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin = createSpinnerWidget(myMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeGroup, "Y", 0, 999, 1, 100,
				myMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin);

		myMyGridLayoutDataGroupMyLayoutDataCompositeGroup = createGroupWidget(myMyLayoutDataCompositeComposite, getModelHelper()
				.getNameMyMyGridLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel(), null, null, null, null, true, true, false, false);

		myGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox = createCheckboxButton(myMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckboxFromMetamodel(), null, null, null, null, true, true, false, false);

		getListener().startListeningTo(myGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox);

		myGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox = createCheckboxButton(myMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckboxFromMetamodel(), null,
				myGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox, null, null, false, true, false, false);

		getListener().startListeningTo(myGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox);

		myVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup = createGroupWidget(myMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel(), null, myGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox, null,
				null, false, true, false, false);

		myBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel(), null, null, null, null, true, true, false, false);

		getListener().startListeningTo(myBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		myCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel(), null, myBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio,
				null, null, false, true, false, false);

		getListener().startListeningTo(myCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		myENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel(), null, myCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio, null,
				null, false, true, false, false);

		getListener().startListeningTo(myENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		myFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel(), null, myENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio, null, null,
				false, true, false, false);

		getListener().startListeningTo(myFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		myHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup = createGroupWidget(myMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel(), myVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup, null, null, null,
				true, false, false, false);

		myBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel(), null, null, null, null, true, true, false, false);

		getListener().startListeningTo(myBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		myCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel(), null, myBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio,
				null, null, false, true, false, false);

		getListener().startListeningTo(myCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		myENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel(), null, myCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio, null,
				null, false, true, false, false);

		getListener().startListeningTo(myENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		myFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio = createRadioButton(myHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel(), null, myENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio, null,
				null, false, true, false, false);

		getListener().startListeningTo(myFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		mySpanningsMyGridLayoutDataGroupMyLayoutDataCompositeGroup = createGroupWidget(myMyGridLayoutDataGroupMyLayoutDataCompositeGroup, "Spannings", null,
				myVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroup, null, null, false, true, false, false);

		myVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin = createSpinnerWidget(mySpanningsMyGridLayoutDataGroupMyLayoutDataCompositeGroup, "Vertical", 1, 99, 1, 100, null, null,
				null, null, true, true, false, false);
		getListener().startListeningTo(myVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin);

		myHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin = createSpinnerWidget(mySpanningsMyGridLayoutDataGroupMyLayoutDataCompositeGroup, "Horizontal", 1, 99, 1, 100,
				myVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin);

		mySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeGroup = createGroupWidget(myMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel(), null, mySpanningsMyGridLayoutDataGroupMyLayoutDataCompositeGroup, null, null, false, true, false,
				false);

		myDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin = createSpinnerWidget(mySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeGroup, "X", 0, 999, 1, 100, null, null, null, null, true,
				true, false, false);
		getListener().startListeningTo(myDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin);

		myDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin = createSpinnerWidget(mySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeGroup, "Y", 0, 999, 1, 100,
				myDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin);

		myHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin = createSpinnerWidget(myMyGridLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpinFromMetamodel(), 0, 99, 1, 100, null, mySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeGroup, null, null,
				false, true, false, false);
		getListener().startListeningTo(myHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin);

		myMyCustomLayoutDataGroupMyLayoutDataCompositeGroup = createGroupWidget(myMyLayoutDataCompositeComposite, getModelHelper()
				.getNameMyMyCustomLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel(), null, null, null, null, true, true, false, false);

		myBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText = createTextWidget(myMyCustomLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeTextFromMetamodel(), null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText);

		myQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText = createTextWidget(myMyCustomLayoutDataGroupMyLayoutDataCompositeGroup, getModelHelper()
				.getNameMyQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeTextFromMetamodel(), null, myBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText, null, null, false,
				true, false, false);
		getListener().startListeningTo(myQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText);

	}

	/**
	 * @generated
	 */
	public void doDispose() {
		getListener().stopListeningTo(myMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		getListener().stopListeningTo(myMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		getListener().stopListeningTo(myMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		getListener().stopListeningTo(myMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		getListener().stopListeningTo(myMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		getListener().stopListeningTo(myMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		getListener().stopListeningTo(myMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio);

		getListener().stopListeningTo(myDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin);

		getListener().stopListeningTo(myDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin);

		myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.removeExpansionListener(getExpansionListener(null));
		getListener().stopListeningTo(mySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox);

		getListener().stopListeningTo(myMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox);

		getListener().stopListeningTo(myMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin);

		getListener().stopListeningTo(myMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin);

		getListener().stopListeningTo(myMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		getListener().stopListeningTo(myMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		getListener().stopListeningTo(myMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		getListener().stopListeningTo(myMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		getListener().stopListeningTo(myMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		getListener().stopListeningTo(myMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		getListener().stopListeningTo(myMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		getListener().stopListeningTo(myMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		getListener().stopListeningTo(myMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		getListener().stopListeningTo(myMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio);

		myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.removeExpansionListener(getExpansionListener(null));
		getListener().stopListeningTo(myNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin);

		getListener().stopListeningTo(myEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox);

		getListener().stopListeningTo(myDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin);

		getListener().stopListeningTo(myDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin);

		getListener().stopListeningTo(myDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin);

		getListener().stopListeningTo(myDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin);

		myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.removeExpansionListener(getExpansionListener(null));
		getListener().stopListeningTo(myBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText);

		getListener().stopListeningTo(myQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText);

		myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.removeExpansionListener(getExpansionListener(null));

		getListener().stopListeningTo(myBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin);

		getListener().stopListeningTo(myMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin);

		getListener().stopListeningTo(myMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin);

		getListener().stopListeningTo(myMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin);

		getListener().stopListeningTo(myGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox);

		getListener().stopListeningTo(myGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox);

		getListener().stopListeningTo(myBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio);

		getListener().stopListeningTo(myVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin);

		getListener().stopListeningTo(myHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin);

		getListener().stopListeningTo(myDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin);

		getListener().stopListeningTo(myDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin);

		getListener().stopListeningTo(myHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin);

		getListener().stopListeningTo(myBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText);

		getListener().stopListeningTo(myQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText);

	}

	/**
	 * @generated
	 */
	public void refresh() {
		getListener().startNonUserChange();
		for (Iterator it = getSavedSelection().iterator(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof Layoutable) {
				final Layoutable target = (Layoutable) next;
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
	public void updateFromModel(Layoutable target) {
		boolean needToRelayoutExpandBar = false;

		{

			{
				{
					myMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.setSelection(getModelHelper().getValueForMyMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target));
				}
				{
					myMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.setSelection(getModelHelper().getValueForMyMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target));
				}
				{
					myMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.setSelection(getModelHelper().getValueForMyMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target));
				}
				{
					myMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.setSelection(getModelHelper().getValueForMyMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target));
				}
				{
					myMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.setSelection(getModelHelper().getValueForMyMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target));
				}
				{
					myMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.setSelection(getModelHelper().getValueForMyMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target));
				}
				{
					myMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.setSelection(getModelHelper().getValueForMyMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target));
				}
			}
			{

				boolean isMyMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible = getModelHelper()
						.isVisibleMyMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite(target);
				if (myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.isExpanded() != isMyMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible) {
					needToRelayoutExpandBar = true;
				}

				myMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.setExpanded(isMyMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible);
				if (isMyMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible) {

					{
						{
							myDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin.setSelection(getModelHelper().getValueForMyDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin(
									target));
						}
						{
							myDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin.setSelection(getModelHelper().getValueForMyDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin(
									target));
						}
					}
				}
				boolean isMyMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible = getModelHelper().isVisibleMyMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite(
						target);
				if (myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.isExpanded() != isMyMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible) {
					needToRelayoutExpandBar = true;
				}

				myMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.setExpanded(isMyMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible);
				if (isMyMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible) {

					{
						{
							mySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox.setSelection(getModelHelper()
									.getValueForMySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox(target));
						}
						{
							myMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox.setSelection(getModelHelper()
									.getValueForMyMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox(target));
						}
						{
							{
								myMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin.setSelection(getModelHelper()
										.getValueForMyMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin(target));
							}
							{
								myMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin.setSelection(getModelHelper()
										.getValueForMyMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin(target));
							}
						}
						{
							{
								String modelText = "       ";
								if (modelText == null) {
									modelText = EMPTY_STRING;
								}
								myMinorTopEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupLabel.setText(modelText);
							}
							{
								myMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.setSelection(getModelHelper()
										.getValueForMyMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target));
							}
							{
								myMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.setSelection(getModelHelper()
										.getValueForMyMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target));
							}
							{
								myMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.setSelection(getModelHelper()
										.getValueForMyMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target));
							}
							{
								myMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.setSelection(getModelHelper()
										.getValueForMyMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target));
							}
							{
								myMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.setSelection(getModelHelper()
										.getValueForMyMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target));
							}
						}
						{
							{
								String modelText = "       ";
								if (modelText == null) {
									modelText = EMPTY_STRING;
								}
								myMajorTopEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupLabel.setText(modelText);
							}
							{
								myMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.setSelection(getModelHelper()
										.getValueForMyMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target));
							}
							{
								myMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.setSelection(getModelHelper()
										.getValueForMyMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target));
							}
							{
								myMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.setSelection(getModelHelper()
										.getValueForMyMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target));
							}
							{
								myMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.setSelection(getModelHelper()
										.getValueForMyMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target));
							}
							{
								myMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.setSelection(getModelHelper()
										.getValueForMyMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target));
							}
						}
					}
				}
				boolean isMyMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible = getModelHelper().isVisibleMyMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite(
						target);
				if (myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.isExpanded() != isMyMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible) {
					needToRelayoutExpandBar = true;
				}

				myMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.setExpanded(isMyMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible);
				if (isMyMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible) {

					{
						{
							myNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.setSelection(getModelHelper()
									.getValueForMyNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(target));
						}
						{
							myEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox.setSelection(getModelHelper()
									.getValueForMyEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox(target));
						}
						{
							{
								myDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.setSelection(getModelHelper()
										.getValueForMyDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(target));
							}
							{
								myDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.setSelection(getModelHelper()
										.getValueForMyDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(target));
							}
						}
						{
							{
								myDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.setSelection(getModelHelper()
										.getValueForMyDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(target));
							}
							{
								myDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.setSelection(getModelHelper()
										.getValueForMyDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(target));
							}
						}
					}
				}
				boolean isMyMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible = getModelHelper()
						.isVisibleMyMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableComposite(target);
				if (myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.isExpanded() != isMyMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible) {
					needToRelayoutExpandBar = true;
				}

				myMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableComposite.setExpanded(isMyMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible);
				if (isMyMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeVisible) {

					{
						{
							String modelText = getModelHelper().getValueForMyBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText(target);
							if (modelText == null) {
								modelText = EMPTY_STRING;
							}
							myBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText.setText(modelText);
						}
						{
							String modelText = getModelHelper().getValueForMyQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText(target);
							if (modelText == null) {
								modelText = EMPTY_STRING;
							}
							myQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText.setText(modelText);
						}
					}
				}
			}
		}
		{

			boolean isMyBorderLayoutDataGroupMyLayoutDataCompositeGroupVisible = getModelHelper().isVisibleMyBorderLayoutDataGroupMyLayoutDataCompositeGroup(target);

			myBorderLayoutDataGroupMyLayoutDataCompositeGroup.setVisible(isMyBorderLayoutDataGroupMyLayoutDataCompositeGroupVisible);
			if (isMyBorderLayoutDataGroupMyLayoutDataCompositeGroupVisible) {

				{
					{
						String modelText = "       ";
						if (modelText == null) {
							modelText = EMPTY_STRING;
						}
						myUpperEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeLabel.setText(modelText);
					}
					{
						myBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper().getValueForMyBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(
								target));
					}
					{
						myBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper().getValueForMyBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(
								target));
					}
					{
						myBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper().getValueForMyBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(
								target));
					}
					{
						myBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper().getValueForMyBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(
								target));
					}
					{
						myBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper().getValueForMyBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(
								target));
					}
				}
			}
			boolean isMyMyXYLayoutDataGroupMyLayoutDataCompositeGroupVisible = getModelHelper().isVisibleMyMyXYLayoutDataGroupMyLayoutDataCompositeGroup(target);

			myMyXYLayoutDataGroupMyLayoutDataCompositeGroup.setVisible(isMyMyXYLayoutDataGroupMyLayoutDataCompositeGroupVisible);
			if (isMyMyXYLayoutDataGroupMyLayoutDataCompositeGroupVisible) {

				{
					{
						myMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.setSelection(getModelHelper()
								.getValueForMyMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(target));
					}
					{
						myMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.setSelection(getModelHelper()
								.getValueForMyMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(target));
					}
				}
				{
					{
						myMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.setSelection(getModelHelper()
								.getValueForMyMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(target));
					}
					{
						myMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.setSelection(getModelHelper()
								.getValueForMyMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(target));
					}
				}
			}
			boolean isMyMyGridLayoutDataGroupMyLayoutDataCompositeGroupVisible = getModelHelper().isVisibleMyMyGridLayoutDataGroupMyLayoutDataCompositeGroup(target);

			myMyGridLayoutDataGroupMyLayoutDataCompositeGroup.setVisible(isMyMyGridLayoutDataGroupMyLayoutDataCompositeGroupVisible);
			if (isMyMyGridLayoutDataGroupMyLayoutDataCompositeGroupVisible) {
				{
					myGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox.setSelection(getModelHelper()
							.getValueForMyGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox(target));
				}
				{
					myGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox.setSelection(getModelHelper()
							.getValueForMyGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox(target));
				}
				{
					{
						myBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper()
								.getValueForMyBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target));
					}
					{
						myCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper()
								.getValueForMyCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target));
					}
					{
						myENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper()
								.getValueForMyENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target));
					}
					{
						myFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper()
								.getValueForMyFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target));
					}
				}
				{
					{
						myBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper()
								.getValueForMyBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target));
					}
					{
						myCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper()
								.getValueForMyCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target));
					}
					{
						myENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper()
								.getValueForMyENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target));
					}
					{
						myFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.setSelection(getModelHelper()
								.getValueForMyFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target));
					}
				}
				{
					{
						myVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin.setSelection(getModelHelper()
								.getValueForMyVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin(target));
					}
					{
						myHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin.setSelection(getModelHelper()
								.getValueForMyHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin(target));
					}
				}
				{
					{
						myDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin.setSelection(getModelHelper().getValueForMyDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin(target));
					}
					{
						myDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin.setSelection(getModelHelper().getValueForMyDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin(target));
					}
				}
				{
					myHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin.setSelection(getModelHelper().getValueForMyHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin(target));
				}
			}
			boolean isMyMyCustomLayoutDataGroupMyLayoutDataCompositeGroupVisible = getModelHelper().isVisibleMyMyCustomLayoutDataGroupMyLayoutDataCompositeGroup(target);

			myMyCustomLayoutDataGroupMyLayoutDataCompositeGroup.setVisible(isMyMyCustomLayoutDataGroupMyLayoutDataCompositeGroupVisible);
			if (isMyMyCustomLayoutDataGroupMyLayoutDataCompositeGroupVisible) {
				{
					String modelText = getModelHelper().getValueForMyBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText(target);
					if (modelText == null) {
						modelText = EMPTY_STRING;
					}
					myBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText.setText(modelText);
				}
				{
					String modelText = getModelHelper().getValueForMyQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText(target);
					if (modelText == null) {
						modelText = EMPTY_STRING;
					}
					myQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText.setText(modelText);
				}
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
				GeneratedLayoutPropertySection.this.applyChangesFrom(widget, kind);
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
			if (next instanceof Layoutable) {
				final Layoutable target = (Layoutable) next;
				commands.add(createCommand(commandName, target, getModelModifierFor(target, widget, kind)));
			}
		}
		executeAsCompositeCommand(commandName, commands);
		//refresh();
	}

	/**
	 * @generated
	 */
	public Runnable getModelModifierFor(final Layoutable target, final Widget widget, int kind) {
		if (widget == myMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio && myMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio && myMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio && myMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio && myMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio && myMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio && myMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio && myMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin && myDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin.getSelection();
					getModelHelper().setValueForMyDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin(target, value);
				}
			};
		}

		if (widget == myDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin && myDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin.getSelection();
					getModelHelper().setValueForMyDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin(target, value);
				}
			};
		}

		if (widget == mySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox
				&& mySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = mySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox.getSelection();
					getModelHelper().setValueForMySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox(target, value);
				}
			};
		}

		if (widget == myMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox
				&& myMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox.getSelection();
					getModelHelper().setValueForMyMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox(target, value);
				}
			};
		}

		if (widget == myMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin
				&& myMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin.getSelection();
					getModelHelper().setValueForMyMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin(target, value);
				}
			};
		}

		if (widget == myMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin
				&& myMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin.getSelection();
					getModelHelper().setValueForMyMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin(target, value);
				}
			};
		}

		if (widget == myMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio
				&& myMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio
				&& myMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio
				&& myMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio
				&& myMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio
				&& myMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio
				&& myMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio
				&& myMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio
				&& myMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio
				&& myMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio
				&& myMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(target, value);
					}
				}
			};
		}

		if (widget == myNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin && myNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.getSelection();
					getModelHelper().setValueForMyNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(target, value);
				}
			};
		}

		if (widget == myEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox
				&& myEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox.getSelection();
					getModelHelper().setValueForMyEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox(target, value);
				}
			};
		}

		if (widget == myDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin && myDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.getSelection();
					getModelHelper().setValueForMyDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(target, value);
				}
			};
		}

		if (widget == myDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin && myDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.getSelection();
					getModelHelper().setValueForMyDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(target, value);
				}
			};
		}

		if (widget == myDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin && myDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.getSelection();
					getModelHelper().setValueForMyDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(target, value);
				}
			};
		}

		if (widget == myDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin && myDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin.getSelection();
					getModelHelper().setValueForMyDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(target, value);
				}
			};
		}

		if (widget == myBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText
				&& myBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText.isVisible()) {
			return new Runnable() {

				public void run() {
					final String value = myBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText.getText();
					getModelHelper().setValueForMyBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText(target, value);
				}
			};
		}

		if (widget == myQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText
				&& myQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText.isVisible()) {
			return new Runnable() {

				public void run() {
					final String value = myQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText.getText();
					getModelHelper().setValueForMyQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText(target, value);
				}
			};
		}

		if (widget == myBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio && myBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio && myBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio && myBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio && myBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio && myBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin && myMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.getSelection();
					getModelHelper().setValueForMyMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(target, value);
				}
			};
		}

		if (widget == myMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin && myMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.getSelection();
					getModelHelper().setValueForMyMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(target, value);
				}
			};
		}

		if (widget == myMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin && myMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.getSelection();
					getModelHelper().setValueForMyMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(target, value);
				}
			};
		}

		if (widget == myMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin && myMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin.getSelection();
					getModelHelper().setValueForMyMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(target, value);
				}
			};
		}

		if (widget == myGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox && myGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox.getSelection();
					getModelHelper().setValueForMyGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox(target, value);
				}
			};
		}

		if (widget == myGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox && myGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox.getSelection();
					getModelHelper().setValueForMyGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox(target, value);
				}
			};
		}

		if (widget == myBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio && myBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio && myCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio && myENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio && myFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio && myBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio && myCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio && myENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio && myFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.isVisible()) {
			return new Runnable() {

				public void run() {
					final boolean value = myFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio.getSelection();
					if (value) {
						getModelHelper().setValueForMyFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(target, value);
					}
				}
			};
		}

		if (widget == myVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin && myVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin.getSelection();
					getModelHelper().setValueForMyVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin(target, value);
				}
			};
		}

		if (widget == myHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin && myHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin.getSelection();
					getModelHelper().setValueForMyHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin(target, value);
				}
			};
		}

		if (widget == myDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin && myDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin.getSelection();
					getModelHelper().setValueForMyDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin(target, value);
				}
			};
		}

		if (widget == myDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin && myDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin.getSelection();
					getModelHelper().setValueForMyDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin(target, value);
				}
			};
		}

		if (widget == myHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin && myHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin.isVisible()) {
			return new Runnable() {

				public void run() {
					final int value = myHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin.getSelection();
					getModelHelper().setValueForMyHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin(target, value);
				}
			};
		}

		if (widget == myBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText && myBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText.isVisible()) {
			return new Runnable() {

				public void run() {
					final String value = myBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText.getText();
					getModelHelper().setValueForMyBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText(target, value);
				}
			};
		}

		if (widget == myQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText && myQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText.isVisible()) {
			return new Runnable() {

				public void run() {
					final String value = myQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText.getText();
					getModelHelper().setValueForMyQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText(target, value);
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

		/*############################ begin additions ############################*/

		/**
		 * @generated NOT
		 */
		protected void setLayoutDataToChildren(org.eclipse.gmf.gmfgraph.Layoutable layoutable, org.eclipse.gmf.gmfgraph.LayoutData layoutData) {
			if (layoutable instanceof org.eclipse.gmf.gmfgraph.Figure) {
				org.eclipse.gmf.gmfgraph.Figure figure = (org.eclipse.gmf.gmfgraph.Figure) layoutable;
				for (java.util.Iterator it = figure.getChildren().iterator(); it.hasNext();) {
					Object next = it.next();
					if (next instanceof org.eclipse.gmf.gmfgraph.Layoutable) {
						org.eclipse.gmf.gmfgraph.Layoutable nextLayoutableChild = (org.eclipse.gmf.gmfgraph.Layoutable) next;
						org.eclipse.gmf.gmfgraph.LayoutData haveLayoutData = nextLayoutableChild.getLayoutData();
						if (!layoutData.getClass().isInstance(haveLayoutData)) {
							nextLayoutableChild.setLayoutData(layoutData);
						}
					}
				}
			}
		}

		/**
		 * @generated NOT
		 */
		protected boolean getFlowLayoutVerticalKind(org.eclipse.gmf.gmfgraph.Layoutable layoutable) {
			boolean result = false;
			if (layoutable.getLayout() != null) {
				org.eclipse.gmf.gmfgraph.Layout layout = layoutable.getLayout();
				if (layout instanceof org.eclipse.gmf.gmfgraph.FlowLayout) {
					org.eclipse.gmf.gmfgraph.FlowLayout flowLayout = ((org.eclipse.gmf.gmfgraph.FlowLayout) layout);
					result = flowLayout.isVertical();
				}
			}
			return result;
		}

		/**
		 * @generated NOT
		 */
		protected void setFlowLayoutVerticalKind(org.eclipse.gmf.gmfgraph.Layoutable layoutable, boolean vertical) {
			if (layoutable.getLayout() != null) {
				org.eclipse.gmf.gmfgraph.Layout layout = layoutable.getLayout();
				if (layout instanceof org.eclipse.gmf.gmfgraph.FlowLayout) {
					org.eclipse.gmf.gmfgraph.FlowLayout flowLayout = ((org.eclipse.gmf.gmfgraph.FlowLayout) layout);
					flowLayout.setVertical(vertical);
				}
			}
		}

		/**
		 * @generated NOT
		 */
		protected boolean getBorderLayoutDataVerticalKind(org.eclipse.gmf.gmfgraph.Layoutable layoutable) {
			boolean result = false;
			if (layoutable.getLayoutData() != null) {
				org.eclipse.gmf.gmfgraph.LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof org.eclipse.gmf.gmfgraph.BorderLayoutData) {
					org.eclipse.gmf.gmfgraph.BorderLayoutData borderLayoutData = ((org.eclipse.gmf.gmfgraph.BorderLayoutData) layoutData);
					result = borderLayoutData.isVertical();
				}
			}
			return result;
		}

		/**
		 * @generated NOT
		 */
		protected void setBorderLayoutDataVerticalKind(org.eclipse.gmf.gmfgraph.Layoutable layoutable, boolean vertical) {
			if (layoutable.getLayoutData() != null) {
				org.eclipse.gmf.gmfgraph.LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof org.eclipse.gmf.gmfgraph.BorderLayoutData) {
					org.eclipse.gmf.gmfgraph.BorderLayoutData borderLayoutData = ((org.eclipse.gmf.gmfgraph.BorderLayoutData) layoutData);
					borderLayoutData.setVertical(vertical);
				}
			}
		}

		/**
		 * @generated NOT
		 */
		protected org.eclipse.emf.ecore.EObject cloneVars(org.eclipse.emf.ecore.EObject target) {
			if (target instanceof org.eclipse.gmf.gmfgraph.Dimension) {
				org.eclipse.gmf.gmfgraph.Dimension source = (org.eclipse.gmf.gmfgraph.Dimension) target;
				org.eclipse.gmf.gmfgraph.Dimension cloned = org.eclipse.gmf.gmfgraph.GMFGraphFactory.eINSTANCE.createDimension();
				cloned.setDx(source.getDx());
				cloned.setDy(source.getDy());
				return cloned;
			}
			if (target instanceof org.eclipse.gmf.gmfgraph.Point) {
				org.eclipse.gmf.gmfgraph.Point source = (org.eclipse.gmf.gmfgraph.Point) target;
				org.eclipse.gmf.gmfgraph.Point cloned = org.eclipse.gmf.gmfgraph.GMFGraphFactory.eINSTANCE.createPoint();
				cloned.setX(source.getX());
				cloned.setY(source.getY());
				return cloned;
			}
			return cloneVarsGen(target);
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setLayoutDataToChildren(layoutable, GMFGraphFactory.eINSTANCE.createBorderLayoutData());
			setValueForMyMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setLayoutDataToChildren(layoutable, GMFGraphFactory.eINSTANCE.createCustomLayoutData());
			setValueForMyMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setLayoutDataToChildren(layoutable, GMFGraphFactory.eINSTANCE.createGridLayoutData());
			setValueForMyMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;

			setValueForMyMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;

			setValueForMyMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setLayoutDataToChildren(layoutable, GMFGraphFactory.eINSTANCE.createXYLayoutData());
			setValueForMyMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;

			setValueForMyMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable);
			result = result && getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, true);
			setValueForMyMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable);
			result = result && !getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, false);
			setValueForMyMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable);
			result = result && !getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, false);
			setValueForMyMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable);
			result = result && getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, true);
			setValueForMyMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable);
			result = result && getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, true);
			setValueForMyMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable);
			result = result && !getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, false);
			setValueForMyMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable);
			result = result && !getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, false);
			setValueForMyMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable);
			result = result && getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, true);
			setValueForMyMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(layoutable);
			result = result && getBorderLayoutDataVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setBorderLayoutDataVerticalKind(layoutable, true);
			setValueForMyBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(layoutable);
			result = result && !getBorderLayoutDataVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setBorderLayoutDataVerticalKind(layoutable, false);
			setValueForMyBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(layoutable);
			result = result && !getBorderLayoutDataVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setBorderLayoutDataVerticalKind(layoutable, false);
			setValueForMyBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(layoutable);
			result = result && getBorderLayoutDataVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setBorderLayoutDataVerticalKind(layoutable, true);
			setValueForMyBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(layoutable, valueToSet);
		}

		/*############################ end additions ############################*/

		/**
		 * @generated
		 */
		public String getNameMyGeneratedLayoutGroupFromMetamodel() {
			return "Layoutable";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				value = (layout instanceof BorderLayout);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			BorderLayout newInstance = GMFGraphFactory.eINSTANCE.createBorderLayout();
			layoutable.setLayout(newInstance);

		}

		/**
		 * @generated
		 */
		public String getNameMyMyBorderLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel() {
			return "BorderLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				value = (layout instanceof CustomLayout);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			CustomLayout newInstance = GMFGraphFactory.eINSTANCE.createCustomLayout();
			layoutable.setLayout(newInstance);

		}

		/**
		 * @generated
		 */
		public String getNameMyMyCustomLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel() {
			return "CustomLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				value = (layout instanceof GridLayout);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			GridLayout newInstance = GMFGraphFactory.eINSTANCE.createGridLayout();
			layoutable.setLayout(newInstance);

		}

		/**
		 * @generated
		 */
		public String getNameMyMyGridLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel() {
			return "GridLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				value = (layout instanceof FlowLayout);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			FlowLayout newInstance = GMFGraphFactory.eINSTANCE.createFlowLayout();
			layoutable.setLayout(newInstance);

		}

		/**
		 * @generated
		 */
		public String getNameMyMyFlowLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel() {
			return "FlowLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				value = (layout instanceof StackLayout);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			StackLayout newInstance = GMFGraphFactory.eINSTANCE.createStackLayout();
			layoutable.setLayout(newInstance);

		}

		/**
		 * @generated
		 */
		public String getNameMyMyStackLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel() {
			return "StackLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				value = (layout instanceof XYLayout);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			XYLayout newInstance = GMFGraphFactory.eINSTANCE.createXYLayout();
			layoutable.setLayout(newInstance);

		}

		/**
		 * @generated
		 */
		public String getNameMyMyXYLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioFromMetamodel() {
			return "XYLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadio(Layoutable layoutable) {
			boolean value = false;

			Layout layout = layoutable.getLayout();
			value = (layout == null);

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyNoLayoutRadioMyLayoutKindGroupMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			layoutable.setLayout(null);

		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableComposite(Layoutable targetVar) {
			boolean value = false;
			if (targetVar.getLayout() != null) {
				Layout layout = targetVar.getLayout();
				value = (layout instanceof BorderLayout);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public String getNameMyMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeFromMetamodel() {
			return "BorderLayout";
		}

		/**
		 * @generated
		 */
		public String getNameMySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupGroupFromMetamodel() {
			return "Spacing";
		}

		/**
		 * @generated
		 */
		public int getValueForMyDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof BorderLayout) {
					BorderLayout borderLayout = ((BorderLayout) layout);
					if (borderLayout.getSpacing() != null) {
						Dimension dimension = borderLayout.getSpacing();
						value = dimension.getDx();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyDxSpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof BorderLayout) {
					BorderLayout borderLayout = ((BorderLayout) layout);

					if (borderLayout.getSpacing() == null) {
						borderLayout.setSpacing(GMFGraphFactory.eINSTANCE.createDimension());
					}

					if (borderLayout.getSpacing() != null) {
						Dimension dimension = borderLayout.getSpacing();
						dimension.setDx(value);
						borderLayout.setSpacing((Dimension) cloneVars(dimension));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public int getValueForMyDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof BorderLayout) {
					BorderLayout borderLayout = ((BorderLayout) layout);
					if (borderLayout.getSpacing() != null) {
						Dimension dimension = borderLayout.getSpacing();
						value = dimension.getDy();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyDySpacingMyLayoutBorderExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof BorderLayout) {
					BorderLayout borderLayout = ((BorderLayout) layout);

					if (borderLayout.getSpacing() == null) {
						borderLayout.setSpacing(GMFGraphFactory.eINSTANCE.createDimension());
					}

					if (borderLayout.getSpacing() != null) {
						Dimension dimension = borderLayout.getSpacing();
						dimension.setDy(value);
						borderLayout.setSpacing((Dimension) cloneVars(dimension));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableComposite(Layoutable targetVar) {
			boolean value = false;
			if (targetVar.getLayout() != null) {
				Layout layout = targetVar.getLayout();
				value = (layout instanceof FlowLayout);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public String getNameMyMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeFromMetamodel() {
			return "FlowLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					value = flowLayout.isForceSingleLine();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					flowLayout.setForceSingleLine(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMySingleLineLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckboxFromMetamodel() {
			return "ForceSingleLine";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					value = flowLayout.isMatchMinorSize();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckbox(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					flowLayout.setMatchMinorSize(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyMinorSizeLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupCheckboxFromMetamodel() {
			return "MatchMinorSize";
		}

		/**
		 * @generated
		 */
		public int getValueForMyMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					value = flowLayout.getMinorSpacing();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMinorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					flowLayout.setMinorSpacing(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public int getValueForMyMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					value = flowLayout.getMajorSpacing();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMajorSpacingsLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					flowLayout.setMajorSpacing(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroupFromMetamodel() {
			return "MinorAlignment";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					if (flowLayout.getMinorAlignment() != null) {
						Alignment alignment = flowLayout.getMinorAlignment();
						value = (alignment.getValue() == Alignment.BEGINNING);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMinorNMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);

					flowLayout.setMinorAlignment(Alignment.BEGINNING_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					if (flowLayout.getMinorAlignment() != null) {
						Alignment alignment = flowLayout.getMinorAlignment();
						value = (alignment.getValue() == Alignment.BEGINNING);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMinorEMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);

					flowLayout.setMinorAlignment(Alignment.BEGINNING_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					if (flowLayout.getMinorAlignment() != null) {
						Alignment alignment = flowLayout.getMinorAlignment();
						value = (alignment.getValue() == Alignment.CENTER);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMinorCMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);

					flowLayout.setMinorAlignment(Alignment.CENTER_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					if (flowLayout.getMinorAlignment() != null) {
						Alignment alignment = flowLayout.getMinorAlignment();
						value = (alignment.getValue() == Alignment.END);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMinorWMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);

					flowLayout.setMinorAlignment(Alignment.END_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					if (flowLayout.getMinorAlignment() != null) {
						Alignment alignment = flowLayout.getMinorAlignment();
						value = (alignment.getValue() == Alignment.END);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMinorSMinorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);

					flowLayout.setMinorAlignment(Alignment.END_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupGroupFromMetamodel() {
			return "MajorAlignment";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					if (flowLayout.getMajorAlignment() != null) {
						Alignment alignment = flowLayout.getMajorAlignment();
						value = (alignment.getValue() == Alignment.BEGINNING);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMajorNMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);

					flowLayout.setMajorAlignment(Alignment.BEGINNING_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					if (flowLayout.getMajorAlignment() != null) {
						Alignment alignment = flowLayout.getMajorAlignment();
						value = (alignment.getValue() == Alignment.BEGINNING);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMajorEMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);

					flowLayout.setMajorAlignment(Alignment.BEGINNING_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					if (flowLayout.getMajorAlignment() != null) {
						Alignment alignment = flowLayout.getMajorAlignment();
						value = (alignment.getValue() == Alignment.CENTER);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMajorCMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);

					flowLayout.setMajorAlignment(Alignment.CENTER_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					if (flowLayout.getMajorAlignment() != null) {
						Alignment alignment = flowLayout.getMajorAlignment();
						value = (alignment.getValue() == Alignment.END);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMajorWMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);

					flowLayout.setMajorAlignment(Alignment.END_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);
					if (flowLayout.getMajorAlignment() != null) {
						Alignment alignment = flowLayout.getMajorAlignment();
						value = (alignment.getValue() == Alignment.END);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMajorSMajorAlignLayoutParametersMyLayoutFlowExpandGroupMyExpandBarMyLayoutGroupRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof FlowLayout) {
					FlowLayout flowLayout = ((FlowLayout) layout);

					flowLayout.setMajorAlignment(Alignment.END_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableComposite(Layoutable targetVar) {
			boolean value = false;
			if (targetVar.getLayout() != null) {
				Layout layout = targetVar.getLayout();
				value = (layout instanceof GridLayout);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public String getNameMyMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeFromMetamodel() {
			return "GridLayout";
		}

		/**
		 * @generated
		 */
		public int getValueForMyNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);
					value = gridLayout.getNumColumns();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);
					gridLayout.setNumColumns(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyNumColumnsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpinFromMetamodel() {
			return "NumColumns";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);
					value = gridLayout.isEqualWidth();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckbox(Layoutable layoutable, boolean value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);
					gridLayout.setEqualWidth(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyEqualWidthLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupCheckboxFromMetamodel() {
			return "EqualWidth";
		}

		/**
		 * @generated
		 */
		public String getNameMyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroupFromMetamodel() {
			return "Margins";
		}

		/**
		 * @generated
		 */
		public int getValueForMyDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);
					if (gridLayout.getMargins() != null) {
						Dimension dimension = gridLayout.getMargins();
						value = dimension.getDx();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyDxMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);

					if (gridLayout.getMargins() == null) {
						gridLayout.setMargins(GMFGraphFactory.eINSTANCE.createDimension());
					}

					if (gridLayout.getMargins() != null) {
						Dimension dimension = gridLayout.getMargins();
						dimension.setDx(value);
						gridLayout.setMargins((Dimension) cloneVars(dimension));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public int getValueForMyDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);
					if (gridLayout.getMargins() != null) {
						Dimension dimension = gridLayout.getMargins();
						value = dimension.getDy();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyDyMarginsLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);

					if (gridLayout.getMargins() == null) {
						gridLayout.setMargins(GMFGraphFactory.eINSTANCE.createDimension());
					}

					if (gridLayout.getMargins() != null) {
						Dimension dimension = gridLayout.getMargins();
						dimension.setDy(value);
						gridLayout.setMargins((Dimension) cloneVars(dimension));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupGroupFromMetamodel() {
			return "Spacing";
		}

		/**
		 * @generated
		 */
		public int getValueForMyDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);
					if (gridLayout.getSpacing() != null) {
						Dimension dimension = gridLayout.getSpacing();
						value = dimension.getDx();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyDxSpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);

					if (gridLayout.getSpacing() == null) {
						gridLayout.setSpacing(GMFGraphFactory.eINSTANCE.createDimension());
					}

					if (gridLayout.getSpacing() != null) {
						Dimension dimension = gridLayout.getSpacing();
						dimension.setDx(value);
						gridLayout.setSpacing((Dimension) cloneVars(dimension));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public int getValueForMyDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);
					if (gridLayout.getSpacing() != null) {
						Dimension dimension = gridLayout.getSpacing();
						value = dimension.getDy();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyDySpacingLayoutParametersMyLayoutGridExpandGroupMyExpandBarMyLayoutGroupSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof GridLayout) {
					GridLayout gridLayout = ((GridLayout) layout);

					if (gridLayout.getSpacing() == null) {
						gridLayout.setSpacing(GMFGraphFactory.eINSTANCE.createDimension());
					}

					if (gridLayout.getSpacing() != null) {
						Dimension dimension = gridLayout.getSpacing();
						dimension.setDy(value);
						gridLayout.setSpacing((Dimension) cloneVars(dimension));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableComposite(Layoutable targetVar) {
			boolean value = false;
			if (targetVar.getLayout() != null) {
				Layout layout = targetVar.getLayout();
				value = (layout instanceof CustomLayout);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public String getNameMyMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupExpandableCompositeFromMetamodel() {
			return "CustomLayout";
		}

		/**
		 * @generated
		 */
		public String getValueForMyBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText(Layoutable layoutable) {
			String value = EMPTY_STRING;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof CustomLayout) {
					CustomLayout customLayout = ((CustomLayout) layout);
					value = customLayout.getBundleName();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText(Layoutable layoutable, String value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof CustomLayout) {
					CustomLayout customLayout = ((CustomLayout) layout);
					customLayout.setBundleName(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyBundleNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupTextFromMetamodel() {
			return "BundleName";
		}

		/**
		 * @generated
		 */
		public String getValueForMyQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText(Layoutable layoutable) {
			String value = EMPTY_STRING;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof CustomLayout) {
					CustomLayout customLayout = ((CustomLayout) layout);
					value = customLayout.getQualifiedClassName();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupText(Layoutable layoutable, String value) {

			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();

				if (layout instanceof CustomLayout) {
					CustomLayout customLayout = ((CustomLayout) layout);
					customLayout.setQualifiedClassName(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyQualifiedClassNameLayoutParametersMyLayoutCustomExpandGroupMyExpandBarMyLayoutGroupTextFromMetamodel() {
			return "QualifiedClassName";
		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyBorderLayoutDataGroupMyLayoutDataCompositeGroup(Layoutable targetVar) {
			boolean value = false;
			if (targetVar.getLayoutData() != null) {
				LayoutData layoutData = targetVar.getLayoutData();
				value = (layoutData instanceof BorderLayoutData);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public String getNameMyBorderLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel() {
			return "BorderLayoutData";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof BorderLayoutData) {
					BorderLayoutData borderLayoutData = ((BorderLayoutData) layoutData);
					if (borderLayoutData.getAlignment() != null) {
						Alignment alignment = borderLayoutData.getAlignment();
						value = (alignment.getValue() == Alignment.BEGINNING);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBorderNWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof BorderLayoutData) {
					BorderLayoutData borderLayoutData = ((BorderLayoutData) layoutData);

					borderLayoutData.setAlignment(Alignment.BEGINNING_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof BorderLayoutData) {
					BorderLayoutData borderLayoutData = ((BorderLayoutData) layoutData);
					if (borderLayoutData.getAlignment() != null) {
						Alignment alignment = borderLayoutData.getAlignment();
						value = (alignment.getValue() == Alignment.BEGINNING);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBorderEWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof BorderLayoutData) {
					BorderLayoutData borderLayoutData = ((BorderLayoutData) layoutData);

					borderLayoutData.setAlignment(Alignment.BEGINNING_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof BorderLayoutData) {
					BorderLayoutData borderLayoutData = ((BorderLayoutData) layoutData);
					if (borderLayoutData.getAlignment() != null) {
						Alignment alignment = borderLayoutData.getAlignment();
						value = (alignment.getValue() == Alignment.CENTER);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBorderCWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof BorderLayoutData) {
					BorderLayoutData borderLayoutData = ((BorderLayoutData) layoutData);

					borderLayoutData.setAlignment(Alignment.CENTER_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof BorderLayoutData) {
					BorderLayoutData borderLayoutData = ((BorderLayoutData) layoutData);
					if (borderLayoutData.getAlignment() != null) {
						Alignment alignment = borderLayoutData.getAlignment();
						value = (alignment.getValue() == Alignment.END);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBorderWWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof BorderLayoutData) {
					BorderLayoutData borderLayoutData = ((BorderLayoutData) layoutData);

					borderLayoutData.setAlignment(Alignment.END_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean getValueForMyBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof BorderLayoutData) {
					BorderLayoutData borderLayoutData = ((BorderLayoutData) layoutData);
					if (borderLayoutData.getAlignment() != null) {
						Alignment alignment = borderLayoutData.getAlignment();
						value = (alignment.getValue() == Alignment.END);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBorderSWorldPartsBorderLayoutDataGroupMyLayoutDataCompositeRadioGen(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof BorderLayoutData) {
					BorderLayoutData borderLayoutData = ((BorderLayoutData) layoutData);

					borderLayoutData.setAlignment(Alignment.END_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyMyXYLayoutDataGroupMyLayoutDataCompositeGroup(Layoutable targetVar) {
			boolean value = false;
			if (targetVar.getLayoutData() != null) {
				LayoutData layoutData = targetVar.getLayoutData();
				value = (layoutData instanceof XYLayoutData);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public String getNameMyMyXYLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel() {
			return "XYLayoutData";
		}

		/**
		 * @generated
		 */
		public int getValueForMyMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof XYLayoutData) {
					XYLayoutData xYLayoutData = ((XYLayoutData) layoutData);
					if (xYLayoutData.getTopLeft() != null) {
						Point point = xYLayoutData.getTopLeft();
						value = point.getX();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof XYLayoutData) {
					XYLayoutData xYLayoutData = ((XYLayoutData) layoutData);

					if (xYLayoutData.getTopLeft() == null) {
						xYLayoutData.setTopLeft(GMFGraphFactory.eINSTANCE.createPoint());
					}

					if (xYLayoutData.getTopLeft() != null) {
						Point point = xYLayoutData.getTopLeft();
						point.setX(value);
						xYLayoutData.setTopLeft((Point) cloneVars(point));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyMyXYDataXSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpinFromMetamodel() {
			return "X";
		}

		/**
		 * @generated
		 */
		public int getValueForMyMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof XYLayoutData) {
					XYLayoutData xYLayoutData = ((XYLayoutData) layoutData);
					if (xYLayoutData.getTopLeft() != null) {
						Point point = xYLayoutData.getTopLeft();
						value = point.getY();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof XYLayoutData) {
					XYLayoutData xYLayoutData = ((XYLayoutData) layoutData);

					if (xYLayoutData.getTopLeft() == null) {
						xYLayoutData.setTopLeft(GMFGraphFactory.eINSTANCE.createPoint());
					}

					if (xYLayoutData.getTopLeft() != null) {
						Point point = xYLayoutData.getTopLeft();
						point.setY(value);
						xYLayoutData.setTopLeft((Point) cloneVars(point));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyMyXYDataYSpinMyXYDataTopLeftGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpinFromMetamodel() {
			return "Y";
		}

		/**
		 * @generated
		 */
		public int getValueForMyMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof XYLayoutData) {
					XYLayoutData xYLayoutData = ((XYLayoutData) layoutData);
					if (xYLayoutData.getSize() != null) {
						Dimension dimension = xYLayoutData.getSize();
						value = dimension.getDx();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyXYDataSizeXSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof XYLayoutData) {
					XYLayoutData xYLayoutData = ((XYLayoutData) layoutData);

					if (xYLayoutData.getSize() == null) {
						xYLayoutData.setSize(GMFGraphFactory.eINSTANCE.createDimension());
					}

					if (xYLayoutData.getSize() != null) {
						Dimension dimension = xYLayoutData.getSize();
						dimension.setDx(value);
						xYLayoutData.setSize((Dimension) cloneVars(dimension));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public int getValueForMyMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof XYLayoutData) {
					XYLayoutData xYLayoutData = ((XYLayoutData) layoutData);
					if (xYLayoutData.getSize() != null) {
						Dimension dimension = xYLayoutData.getSize();
						value = dimension.getDy();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyXYDataSizeYSpinMyXYDataSizeGroupMyXYLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof XYLayoutData) {
					XYLayoutData xYLayoutData = ((XYLayoutData) layoutData);

					if (xYLayoutData.getSize() == null) {
						xYLayoutData.setSize(GMFGraphFactory.eINSTANCE.createDimension());
					}

					if (xYLayoutData.getSize() != null) {
						Dimension dimension = xYLayoutData.getSize();
						dimension.setDy(value);
						xYLayoutData.setSize((Dimension) cloneVars(dimension));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyMyGridLayoutDataGroupMyLayoutDataCompositeGroup(Layoutable targetVar) {
			boolean value = false;
			if (targetVar.getLayoutData() != null) {
				LayoutData layoutData = targetVar.getLayoutData();
				value = (layoutData instanceof GridLayoutData);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public String getNameMyMyGridLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel() {
			return "GridLayoutData";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					value = gridLayoutData.isGrabExcessHorizontalSpace();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					gridLayoutData.setGrabExcessHorizontalSpace(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyGrabExcessHorizontalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckboxFromMetamodel() {
			return "GrabExcessHorizontalSpace";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					value = gridLayoutData.isGrabExcessVerticalSpace();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckbox(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					gridLayoutData.setGrabExcessVerticalSpace(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyGrabExcessVerticalSpaceMyGridLayoutDataGroupMyLayoutDataCompositeCheckboxFromMetamodel() {
			return "GrabExcessVerticalSpace";
		}

		/**
		 * @generated
		 */
		public String getNameMyVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel() {
			return "VerticalAlignment";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					if (gridLayoutData.getVerticalAlignment() != null) {
						Alignment alignment = gridLayoutData.getVerticalAlignment();
						value = (alignment.getValue() == Alignment.BEGINNING);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);

					gridLayoutData.setVerticalAlignment(Alignment.BEGINNING_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyBEGINNINGVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel() {
			return "Beginning";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					if (gridLayoutData.getVerticalAlignment() != null) {
						Alignment alignment = gridLayoutData.getVerticalAlignment();
						value = (alignment.getValue() == Alignment.CENTER);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);

					gridLayoutData.setVerticalAlignment(Alignment.CENTER_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyCENTERVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel() {
			return "Center";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					if (gridLayoutData.getVerticalAlignment() != null) {
						Alignment alignment = gridLayoutData.getVerticalAlignment();
						value = (alignment.getValue() == Alignment.END);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);

					gridLayoutData.setVerticalAlignment(Alignment.END_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyENDVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel() {
			return "End";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					if (gridLayoutData.getVerticalAlignment() != null) {
						Alignment alignment = gridLayoutData.getVerticalAlignment();
						value = (alignment.getValue() == Alignment.FILL);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);

					gridLayoutData.setVerticalAlignment(Alignment.FILL_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyFILLVerticalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel() {
			return "Fill";
		}

		/**
		 * @generated
		 */
		public String getNameMyHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel() {
			return "HorizontalAlignment";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					if (gridLayoutData.getHorizontalAlignment() != null) {
						Alignment alignment = gridLayoutData.getHorizontalAlignment();
						value = (alignment.getValue() == Alignment.BEGINNING);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);

					gridLayoutData.setHorizontalAlignment(Alignment.BEGINNING_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyBEGINNINGHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel() {
			return "Beginning";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					if (gridLayoutData.getHorizontalAlignment() != null) {
						Alignment alignment = gridLayoutData.getHorizontalAlignment();
						value = (alignment.getValue() == Alignment.CENTER);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);

					gridLayoutData.setHorizontalAlignment(Alignment.CENTER_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyCENTERHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel() {
			return "Center";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					if (gridLayoutData.getHorizontalAlignment() != null) {
						Alignment alignment = gridLayoutData.getHorizontalAlignment();
						value = (alignment.getValue() == Alignment.END);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);

					gridLayoutData.setHorizontalAlignment(Alignment.END_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyENDHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel() {
			return "End";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable) {
			boolean value = false;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					if (gridLayoutData.getHorizontalAlignment() != null) {
						Alignment alignment = gridLayoutData.getHorizontalAlignment();
						value = (alignment.getValue() == Alignment.FILL);

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadio(Layoutable layoutable, boolean value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);

					gridLayoutData.setHorizontalAlignment(Alignment.FILL_LITERAL);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyFILLHorizontalAlignmentMyGridLayoutDataGroupMyLayoutDataCompositeRadioFromMetamodel() {
			return "Fill";
		}

		/**
		 * @generated
		 */
		public int getValueForMyVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					value = gridLayoutData.getVerticalSpan();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyVerticalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					gridLayoutData.setVerticalSpan(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public int getValueForMyHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					value = gridLayoutData.getHorizontalSpan();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyHorizontalSpanSpanningsMyGridLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					gridLayoutData.setHorizontalSpan(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel() {
			return "SizeHint";
		}

		/**
		 * @generated
		 */
		public int getValueForMyDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					if (gridLayoutData.getSizeHint() != null) {
						Dimension dimension = gridLayoutData.getSizeHint();
						value = dimension.getDx();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyDxSizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);

					if (gridLayoutData.getSizeHint() == null) {
						gridLayoutData.setSizeHint(GMFGraphFactory.eINSTANCE.createDimension());
					}

					if (gridLayoutData.getSizeHint() != null) {
						Dimension dimension = gridLayoutData.getSizeHint();
						dimension.setDx(value);
						gridLayoutData.setSizeHint((Dimension) cloneVars(dimension));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public int getValueForMyDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					if (gridLayoutData.getSizeHint() != null) {
						Dimension dimension = gridLayoutData.getSizeHint();
						value = dimension.getDy();

					}

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyDySizeHintMyGridLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);

					if (gridLayoutData.getSizeHint() == null) {
						gridLayoutData.setSizeHint(GMFGraphFactory.eINSTANCE.createDimension());
					}

					if (gridLayoutData.getSizeHint() != null) {
						Dimension dimension = gridLayoutData.getSizeHint();
						dimension.setDy(value);
						gridLayoutData.setSizeHint((Dimension) cloneVars(dimension));
					}

				}

			}

		}

		/**
		 * @generated
		 */
		public int getValueForMyHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable) {
			int value = 0;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					value = gridLayoutData.getHorizontalIndent();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpin(Layoutable layoutable, int value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof GridLayoutData) {
					GridLayoutData gridLayoutData = ((GridLayoutData) layoutData);
					gridLayoutData.setHorizontalIndent(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyHorizontalIndentMyGridLayoutDataGroupMyLayoutDataCompositeSpinFromMetamodel() {
			return "HorizontalIndent";
		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyMyCustomLayoutDataGroupMyLayoutDataCompositeGroup(Layoutable targetVar) {
			boolean value = false;
			if (targetVar.getLayoutData() != null) {
				LayoutData layoutData = targetVar.getLayoutData();
				value = (layoutData instanceof CustomLayoutData);

			}

			return value;
		}

		/**
		 * @generated
		 */
		public String getNameMyMyCustomLayoutDataGroupMyLayoutDataCompositeGroupFromMetamodel() {
			return "CustomLayoutData";
		}

		/**
		 * @generated
		 */
		public String getValueForMyBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText(Layoutable layoutable) {
			String value = EMPTY_STRING;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof CustomLayoutData) {
					CustomLayoutData customLayoutData = ((CustomLayoutData) layoutData);
					value = customLayoutData.getBundleName();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeText(Layoutable layoutable, String value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof CustomLayoutData) {
					CustomLayoutData customLayoutData = ((CustomLayoutData) layoutData);
					customLayoutData.setBundleName(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyBundleNameMyCustomLayoutDataGroupMyLayoutDataCompositeTextFromMetamodel() {
			return "BundleName";
		}

		/**
		 * @generated
		 */
		public String getValueForMyQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText(Layoutable layoutable) {
			String value = EMPTY_STRING;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof CustomLayoutData) {
					CustomLayoutData customLayoutData = ((CustomLayoutData) layoutData);
					value = customLayoutData.getQualifiedClassName();

				}

			}

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeText(Layoutable layoutable, String value) {

			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();

				if (layoutData instanceof CustomLayoutData) {
					CustomLayoutData customLayoutData = ((CustomLayoutData) layoutData);
					customLayoutData.setQualifiedClassName(value);

				}

			}

		}

		/**
		 * @generated
		 */
		public String getNameMyQualifiedClassNameMyCustomLayoutDataGroupMyLayoutDataCompositeTextFromMetamodel() {
			return "QualifiedClassName";
		}

		/**
		 * @generated
		 */
		protected EObject cloneVarsGen(EObject target) {
			return target;
		}

	}

}
