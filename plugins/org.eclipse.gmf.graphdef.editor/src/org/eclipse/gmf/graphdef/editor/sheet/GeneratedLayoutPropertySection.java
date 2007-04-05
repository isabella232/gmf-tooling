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
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
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
	private Composite myMyLayoutKindGroupComposite;

	/**
	 * @generated
	 */
	private Button myMyBorderLayoutRadioRadio;

	/**
	 * @generated
	 */
	private Button myMyCustomLayoutRadioRadio;

	/**
	 * @generated
	 */
	private Button myMyGridLayoutRadioRadio;

	/**
	 * @generated
	 */
	private Button myMyFlowLayoutRadioRadio;

	/**
	 * @generated
	 */
	private Button myMyStackLayoutRadioRadio;

	/**
	 * @generated
	 */
	private Button myMyXYLayoutRadioRadio;

	/**
	 * @generated
	 */
	private Button myMyNoLayoutRadioRadio;

	/**
	 * @generated
	 */
	private Composite myMyExpandBarComposite;

	/**
	 * @generated
	 */
	private ExpandableComposite myLayoutBorderExpandGroupExpandableComposite;

	/**
	 * @generated
	 */
	private Group myBorderParamsGroup;

	/**
	 * @generated
	 */
	private Spinner myDxSpin;

	/**
	 * @generated
	 */
	private Spinner myDySpin;

	/**
	 * @generated
	 */
	private ExpandableComposite myLayoutFlowExpandGroupExpandableComposite;

	/**
	 * @generated
	 */
	private Group myFlowParamsGroup;

	/**
	 * @generated
	 */
	private Button mySingleLineCheckbox;

	/**
	 * @generated
	 */
	private Button myMinorSizeCheckbox;

	/**
	 * @generated
	 */
	private Group mySpacingsGroup;

	/**
	 * @generated
	 */
	private Spinner myMinorSpin;

	/**
	 * @generated
	 */
	private Spinner myMajorSpin;

	/**
	 * @generated
	 */
	private Group myMinorAlignGroup;

	/**
	 * @generated
	 */
	private CLabel myMinorTopELabel;

	/**
	 * @generated
	 */
	private Button myMinorNRadio;

	/**
	 * @generated
	 */
	private Button myMinorERadio;

	/**
	 * @generated
	 */
	private Button myMinorCRadio;

	/**
	 * @generated
	 */
	private Button myMinorWRadio;

	/**
	 * @generated
	 */
	private Button myMinorSRadio;

	/**
	 * @generated
	 */
	private Group myMajorAlignGroup;

	/**
	 * @generated
	 */
	private CLabel myMajorTopELabel;

	/**
	 * @generated
	 */
	private Button myMajorNRadio;

	/**
	 * @generated
	 */
	private Button myMajorERadio;

	/**
	 * @generated
	 */
	private Button myMajorCRadio;

	/**
	 * @generated
	 */
	private Button myMajorWRadio;

	/**
	 * @generated
	 */
	private Button myMajorSRadio;

	/**
	 * @generated
	 */
	private ExpandableComposite myLayoutGridExpandGroupExpandableComposite;

	/**
	 * @generated
	 */
	private Group myGridParamsGroup;

	/**
	 * @generated
	 */
	private Spinner myNumColumnsSpin;

	/**
	 * @generated
	 */
	private Button myEqualWidthCheckbox;

	/**
	 * @generated
	 */
	private Group myMarginsGroup;

	/**
	 * @generated
	 */
	private Spinner myDx$1Spin;

	/**
	 * @generated
	 */
	private Spinner myDy$1Spin;

	/**
	 * @generated
	 */
	private Group mySpacingGroup;

	/**
	 * @generated
	 */
	private Spinner myDx$2Spin;

	/**
	 * @generated
	 */
	private Spinner myDy$2Spin;

	/**
	 * @generated
	 */
	private ExpandableComposite myLayoutCustomExpandGroupExpandableComposite;

	/**
	 * @generated
	 */
	private Group myCustomParamsGroup;

	/**
	 * @generated
	 */
	private Text myBundleNameText;

	/**
	 * @generated
	 */
	private Text myQualifiedClassNameText;

	/**
	 * @generated
	 */
	private Composite myMyLayoutDataCompositeComposite;

	/**
	 * @generated
	 */
	private Group myBorderLayoutDataGroupGroup;

	/**
	 * @generated
	 */
	private Composite myWorldPartsComposite;

	/**
	 * @generated
	 */
	private CLabel myUpperELabel;

	/**
	 * @generated
	 */
	private Button myBorderNRadio;

	/**
	 * @generated
	 */
	private Button myBorderERadio;

	/**
	 * @generated
	 */
	private Button myBorderCRadio;

	/**
	 * @generated
	 */
	private Button myBorderWRadio;

	/**
	 * @generated
	 */
	private Button myBorderSRadio;

	/**
	 * @generated
	 */
	private Group myMyXYLayoutDataGroupGroup;

	/**
	 * @generated
	 */
	private Group myMyXYDataTopLeftGroupGroup;

	/**
	 * @generated
	 */
	private Spinner myMyXYDataXSpinSpin;

	/**
	 * @generated
	 */
	private Spinner myMyXYDataYSpinSpin;

	/**
	 * @generated
	 */
	private Group myMyXYDataSizeGroupGroup;

	/**
	 * @generated
	 */
	private Spinner myMyXYDataSizeXSpinSpin;

	/**
	 * @generated
	 */
	private Spinner myMyXYDataSizeYSpinSpin;

	/**
	 * @generated
	 */
	private Group myMyGridLayoutDataGroupGroup;

	/**
	 * @generated
	 */
	private Button myGrabExcessHorizontalSpaceCheckbox;

	/**
	 * @generated
	 */
	private Button myGrabExcessVerticalSpaceCheckbox;

	/**
	 * @generated
	 */
	private Group myVerticalAlignmentGroup;

	/**
	 * @generated
	 */
	private Button myBEGINNINGRadio;

	/**
	 * @generated
	 */
	private Button myCENTERRadio;

	/**
	 * @generated
	 */
	private Button myENDRadio;

	/**
	 * @generated
	 */
	private Button myFILLRadio;

	/**
	 * @generated
	 */
	private Group myHorizontalAlignmentGroup;

	/**
	 * @generated
	 */
	private Button myBEGINNING$1Radio;

	/**
	 * @generated
	 */
	private Button myCENTER$1Radio;

	/**
	 * @generated
	 */
	private Button myEND$1Radio;

	/**
	 * @generated
	 */
	private Button myFILL$1Radio;

	/**
	 * @generated
	 */
	private Group mySpanningsGroup;

	/**
	 * @generated
	 */
	private Spinner myVerticalSpanSpin;

	/**
	 * @generated
	 */
	private Spinner myHorizontalSpanSpin;

	/**
	 * @generated
	 */
	private Group mySizeHintGroup;

	/**
	 * @generated
	 */
	private Spinner myDx$3Spin;

	/**
	 * @generated
	 */
	private Spinner myDy$3Spin;

	/**
	 * @generated
	 */
	private Spinner myHorizontalIndentSpin;

	/**
	 * @generated
	 */
	private Group myMyCustomLayoutDataGroupGroup;

	/**
	 * @generated
	 */
	private Text myBundleName$1Text;

	/**
	 * @generated
	 */
	private Text myQualifiedClassName$1Text;

	/**
	 * @generated
	 */
	public void doCreateControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		Composite mainComposite = createMainWidget(parent);
		myMyLayoutGroupGroup = createGroupWidget(mainComposite, "Layout Manager", null, null, null, null, true, true, false, false);

		myMyLayoutKindGroupComposite = createCompositeWidget(myMyLayoutGroupGroup, "", null, null, null, null, true, true, false, false);

		myMyBorderLayoutRadioRadio = createRadioButton(myMyLayoutKindGroupComposite, getModelHelper().getNameMyMyBorderLayoutRadioRadioFromMetamodel(), null, null, null, null, true, true, false,
				false);

		getListener().startListeningTo(myMyBorderLayoutRadioRadio);

		myMyCustomLayoutRadioRadio = createRadioButton(myMyLayoutKindGroupComposite, getModelHelper().getNameMyMyCustomLayoutRadioRadioFromMetamodel(), null, myMyBorderLayoutRadioRadio, null, null,
				false, true, false, false);

		getListener().startListeningTo(myMyCustomLayoutRadioRadio);

		myMyGridLayoutRadioRadio = createRadioButton(myMyLayoutKindGroupComposite, getModelHelper().getNameMyMyGridLayoutRadioRadioFromMetamodel(), null, myMyCustomLayoutRadioRadio, null, null,
				false, true, false, false);

		getListener().startListeningTo(myMyGridLayoutRadioRadio);

		myMyFlowLayoutRadioRadio = createRadioButton(myMyLayoutKindGroupComposite, getModelHelper().getNameMyMyFlowLayoutRadioRadioFromMetamodel(), null, myMyGridLayoutRadioRadio, null, null, false,
				true, false, false);

		getListener().startListeningTo(myMyFlowLayoutRadioRadio);

		myMyStackLayoutRadioRadio = createRadioButton(myMyLayoutKindGroupComposite, getModelHelper().getNameMyMyStackLayoutRadioRadioFromMetamodel(), null, myMyFlowLayoutRadioRadio, null, null,
				false, true, false, false);

		getListener().startListeningTo(myMyStackLayoutRadioRadio);

		myMyXYLayoutRadioRadio = createRadioButton(myMyLayoutKindGroupComposite, getModelHelper().getNameMyMyXYLayoutRadioRadioFromMetamodel(), null, myMyStackLayoutRadioRadio, null, null, false,
				true, false, false);

		getListener().startListeningTo(myMyXYLayoutRadioRadio);

		myMyNoLayoutRadioRadio = createRadioButton(myMyLayoutKindGroupComposite, "No Layout", null, myMyXYLayoutRadioRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myMyNoLayoutRadioRadio);

		myMyExpandBarComposite = createCompositeWidget(myMyLayoutGroupGroup, "", myMyLayoutKindGroupComposite, null, null, null, true, false, false, false);

		myLayoutBorderExpandGroupExpandableComposite = createExpandableComposite(myMyExpandBarComposite, getModelHelper().getNameMyLayoutBorderExpandGroupExpandableCompositeFromMetamodel(), null,
				null, null, null, true, true, false, false);
		Composite myLayoutBorderExpandGroupExpandableCompositeControl = createCompositeWidget(myLayoutBorderExpandGroupExpandableComposite, "", null, null, null, null, true, true, false, false);

		myBorderParamsGroup = createGroupWidget(myLayoutBorderExpandGroupExpandableCompositeControl, getModelHelper().getNameMyBorderParamsGroupFromMetamodel(), null, null, null, null, true, true,
				false, false);

		myDxSpin = createSpinnerWidget(myBorderParamsGroup, "Horizontal", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myDxSpin);

		myDySpin = createSpinnerWidget(myBorderParamsGroup, "Vertical", 0, 999, 1, 100, myDxSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myDySpin);

		myLayoutBorderExpandGroupExpandableComposite.setClient(myLayoutBorderExpandGroupExpandableCompositeControl);
		myLayoutBorderExpandGroupExpandableComposite.addExpansionListener(getExpansionListener(myMyExpandBarComposite));

		myLayoutFlowExpandGroupExpandableComposite = createExpandableComposite(myMyExpandBarComposite, getModelHelper().getNameMyLayoutFlowExpandGroupExpandableCompositeFromMetamodel(), null,
				myLayoutBorderExpandGroupExpandableComposite, null, null, false, true, false, false);
		Composite myLayoutFlowExpandGroupExpandableCompositeControl = createCompositeWidget(myLayoutFlowExpandGroupExpandableComposite, "", null, myLayoutBorderExpandGroupExpandableComposite, null,
				null, false, true, false, false);

		myFlowParamsGroup = createGroupWidget(myLayoutFlowExpandGroupExpandableCompositeControl, "Layout Parameters", null, null, null, null, true, true, false, false);

		mySingleLineCheckbox = createCheckboxButton(myFlowParamsGroup, getModelHelper().getNameMySingleLineCheckboxFromMetamodel(), null, null, null, null, true, true, false, false);

		getListener().startListeningTo(mySingleLineCheckbox);

		myMinorSizeCheckbox = createCheckboxButton(myFlowParamsGroup, getModelHelper().getNameMyMinorSizeCheckboxFromMetamodel(), mySingleLineCheckbox, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMinorSizeCheckbox);

		mySpacingsGroup = createGroupWidget(myFlowParamsGroup, "Spacings", null, mySingleLineCheckbox, null, null, false, true, false, false);

		myMinorSpin = createSpinnerWidget(mySpacingsGroup, "Minor", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myMinorSpin);

		myMajorSpin = createSpinnerWidget(mySpacingsGroup, "Major", 0, 999, 1, 100, myMinorSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myMajorSpin);

		myMinorAlignGroup = createGroupWidget(myFlowParamsGroup, getModelHelper().getNameMyMinorAlignGroupFromMetamodel(), null, mySpacingsGroup, null, null, false, true, false, false);

		myMinorTopELabel = createLabelWidget(myMinorAlignGroup, "       ", null, null, null, null, true, true, false, false);

		myMinorNRadio = createRadioButton(myMinorAlignGroup, "N", myMinorTopELabel, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMinorNRadio);

		myMinorERadio = createRadioButton(myMinorAlignGroup, "E", null, myMinorTopELabel, null, null, false, true, false, false);

		getListener().startListeningTo(myMinorERadio);

		myMinorCRadio = createRadioButton(myMinorAlignGroup, "C", myMinorERadio, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMinorCRadio);

		myMinorWRadio = createRadioButton(myMinorAlignGroup, "W", myMinorCRadio, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMinorWRadio);

		myMinorSRadio = createRadioButton(myMinorAlignGroup, "S", null, myMinorCRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myMinorSRadio);

		myMajorAlignGroup = createGroupWidget(myFlowParamsGroup, getModelHelper().getNameMyMajorAlignGroupFromMetamodel(), myMinorAlignGroup, null, null, null, true, false, false, false);

		myMajorTopELabel = createLabelWidget(myMajorAlignGroup, "       ", null, null, null, null, true, true, false, false);

		myMajorNRadio = createRadioButton(myMajorAlignGroup, "N", myMajorTopELabel, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMajorNRadio);

		myMajorERadio = createRadioButton(myMajorAlignGroup, "E", null, myMajorTopELabel, null, null, false, true, false, false);

		getListener().startListeningTo(myMajorERadio);

		myMajorCRadio = createRadioButton(myMajorAlignGroup, "C", myMajorERadio, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMajorCRadio);

		myMajorWRadio = createRadioButton(myMajorAlignGroup, "W", myMajorCRadio, null, null, null, true, false, false, false);

		getListener().startListeningTo(myMajorWRadio);

		myMajorSRadio = createRadioButton(myMajorAlignGroup, "S", null, myMajorCRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myMajorSRadio);

		myLayoutFlowExpandGroupExpandableComposite.setClient(myLayoutFlowExpandGroupExpandableCompositeControl);
		myLayoutFlowExpandGroupExpandableComposite.addExpansionListener(getExpansionListener(myMyExpandBarComposite));

		myLayoutGridExpandGroupExpandableComposite = createExpandableComposite(myMyExpandBarComposite, getModelHelper().getNameMyLayoutGridExpandGroupExpandableCompositeFromMetamodel(), null,
				myLayoutFlowExpandGroupExpandableComposite, null, null, false, true, false, false);
		Composite myLayoutGridExpandGroupExpandableCompositeControl = createCompositeWidget(myLayoutGridExpandGroupExpandableComposite, "", null, myLayoutFlowExpandGroupExpandableComposite, null,
				null, false, true, false, false);

		myGridParamsGroup = createGroupWidget(myLayoutGridExpandGroupExpandableCompositeControl, "Layout Parameters", null, null, null, null, true, true, false, false);

		myNumColumnsSpin = createSpinnerWidget(myGridParamsGroup, getModelHelper().getNameMyNumColumnsSpinFromMetamodel(), 1, 99, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myNumColumnsSpin);

		myEqualWidthCheckbox = createCheckboxButton(myGridParamsGroup, getModelHelper().getNameMyEqualWidthCheckboxFromMetamodel(), myNumColumnsSpin, null, null, null, true, false, false, false);

		getListener().startListeningTo(myEqualWidthCheckbox);

		myMarginsGroup = createGroupWidget(myGridParamsGroup, getModelHelper().getNameMyMarginsGroupFromMetamodel(), null, myNumColumnsSpin, null, null, false, true, false, false);

		myDx$1Spin = createSpinnerWidget(myMarginsGroup, "Horizontal", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myDx$1Spin);

		myDy$1Spin = createSpinnerWidget(myMarginsGroup, "Vertical", 0, 999, 1, 100, myDx$1Spin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myDy$1Spin);

		mySpacingGroup = createGroupWidget(myGridParamsGroup, getModelHelper().getNameMySpacingGroupFromMetamodel(), null, myMarginsGroup, null, null, false, true, false, false);

		myDx$2Spin = createSpinnerWidget(mySpacingGroup, "X", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myDx$2Spin);

		myDy$2Spin = createSpinnerWidget(mySpacingGroup, "Y", 0, 999, 1, 100, myDx$2Spin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myDy$2Spin);

		myLayoutGridExpandGroupExpandableComposite.setClient(myLayoutGridExpandGroupExpandableCompositeControl);
		myLayoutGridExpandGroupExpandableComposite.addExpansionListener(getExpansionListener(myMyExpandBarComposite));

		myLayoutCustomExpandGroupExpandableComposite = createExpandableComposite(myMyExpandBarComposite, getModelHelper().getNameMyLayoutCustomExpandGroupExpandableCompositeFromMetamodel(), null,
				myLayoutGridExpandGroupExpandableComposite, null, null, false, true, false, false);
		Composite myLayoutCustomExpandGroupExpandableCompositeControl = createCompositeWidget(myLayoutCustomExpandGroupExpandableComposite, "", null, myLayoutGridExpandGroupExpandableComposite, null,
				null, false, true, false, false);

		myCustomParamsGroup = createGroupWidget(myLayoutCustomExpandGroupExpandableCompositeControl, "Layout Parameters", null, null, null, null, true, true, false, false);

		myBundleNameText = createTextWidget(myCustomParamsGroup, getModelHelper().getNameMyBundleNameTextFromMetamodel(), null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myBundleNameText);

		myQualifiedClassNameText = createTextWidget(myCustomParamsGroup, getModelHelper().getNameMyQualifiedClassNameTextFromMetamodel(), null, myBundleNameText, null, null, false, true, false, false);
		getListener().startListeningTo(myQualifiedClassNameText);

		myLayoutCustomExpandGroupExpandableComposite.setClient(myLayoutCustomExpandGroupExpandableCompositeControl);
		myLayoutCustomExpandGroupExpandableComposite.addExpansionListener(getExpansionListener(myMyExpandBarComposite));

		myMyLayoutDataCompositeComposite = createCompositeWidget(mainComposite, "", myMyLayoutGroupGroup, null, null, null, true, false, false, true);

		myBorderLayoutDataGroupGroup = createGroupWidget(myMyLayoutDataCompositeComposite, getModelHelper().getNameMyBorderLayoutDataGroupGroupFromMetamodel(), null, null, null, null, true, true,
				false, false);

		myWorldPartsComposite = createCompositeWidget(myBorderLayoutDataGroupGroup, "", null, null, null, null, true, true, false, false);

		myUpperELabel = createLabelWidget(myWorldPartsComposite, "       ", null, null, null, null, true, true, false, false);

		myBorderNRadio = createRadioButton(myWorldPartsComposite, "N", myUpperELabel, null, null, null, true, false, false, false);

		getListener().startListeningTo(myBorderNRadio);

		myBorderERadio = createRadioButton(myWorldPartsComposite, "E", null, myUpperELabel, null, null, false, true, false, false);

		getListener().startListeningTo(myBorderERadio);

		myBorderCRadio = createRadioButton(myWorldPartsComposite, "C", myBorderERadio, null, null, null, true, false, false, false);

		getListener().startListeningTo(myBorderCRadio);

		myBorderWRadio = createRadioButton(myWorldPartsComposite, "W", myBorderCRadio, null, null, null, true, false, false, true);

		getListener().startListeningTo(myBorderWRadio);

		myBorderSRadio = createRadioButton(myWorldPartsComposite, "S", null, myBorderCRadio, null, null, false, true, true, false);

		getListener().startListeningTo(myBorderSRadio);

		myMyXYLayoutDataGroupGroup = createGroupWidget(myMyLayoutDataCompositeComposite, getModelHelper().getNameMyMyXYLayoutDataGroupGroupFromMetamodel(), null, null, null, null, true, true, false,
				false);

		myMyXYDataTopLeftGroupGroup = createGroupWidget(myMyXYLayoutDataGroupGroup, "Top Left Position", null, null, null, null, true, true, false, false);

		myMyXYDataXSpinSpin = createSpinnerWidget(myMyXYDataTopLeftGroupGroup, getModelHelper().getNameMyMyXYDataXSpinSpinFromMetamodel(), 0, 999, 1, 100, null, null, null, null, true, true, false,
				false);
		getListener().startListeningTo(myMyXYDataXSpinSpin);

		myMyXYDataYSpinSpin = createSpinnerWidget(myMyXYDataTopLeftGroupGroup, getModelHelper().getNameMyMyXYDataYSpinSpinFromMetamodel(), 0, 999, 1, 100, myMyXYDataXSpinSpin, null, null, null, true,
				false, false, false);
		getListener().startListeningTo(myMyXYDataYSpinSpin);

		myMyXYDataSizeGroupGroup = createGroupWidget(myMyXYLayoutDataGroupGroup, "Size Constraints", null, myMyXYDataTopLeftGroupGroup, null, null, false, true, false, false);

		myMyXYDataSizeXSpinSpin = createSpinnerWidget(myMyXYDataSizeGroupGroup, "X", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myMyXYDataSizeXSpinSpin);

		myMyXYDataSizeYSpinSpin = createSpinnerWidget(myMyXYDataSizeGroupGroup, "Y", 0, 999, 1, 100, myMyXYDataSizeXSpinSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myMyXYDataSizeYSpinSpin);

		myMyGridLayoutDataGroupGroup = createGroupWidget(myMyLayoutDataCompositeComposite, getModelHelper().getNameMyMyGridLayoutDataGroupGroupFromMetamodel(), null, null, null, null, true, true,
				false, false);

		myGrabExcessHorizontalSpaceCheckbox = createCheckboxButton(myMyGridLayoutDataGroupGroup, getModelHelper().getNameMyGrabExcessHorizontalSpaceCheckboxFromMetamodel(), null, null, null, null,
				true, true, false, false);

		getListener().startListeningTo(myGrabExcessHorizontalSpaceCheckbox);

		myGrabExcessVerticalSpaceCheckbox = createCheckboxButton(myMyGridLayoutDataGroupGroup, getModelHelper().getNameMyGrabExcessVerticalSpaceCheckboxFromMetamodel(), null,
				myGrabExcessHorizontalSpaceCheckbox, null, null, false, true, false, false);

		getListener().startListeningTo(myGrabExcessVerticalSpaceCheckbox);

		myVerticalAlignmentGroup = createGroupWidget(myMyGridLayoutDataGroupGroup, getModelHelper().getNameMyVerticalAlignmentGroupFromMetamodel(), null, myGrabExcessVerticalSpaceCheckbox, null,
				null, false, true, false, false);

		myBEGINNINGRadio = createRadioButton(myVerticalAlignmentGroup, getModelHelper().getNameMyBEGINNINGRadioFromMetamodel(), null, null, null, null, true, true, false, false);

		getListener().startListeningTo(myBEGINNINGRadio);

		myCENTERRadio = createRadioButton(myVerticalAlignmentGroup, getModelHelper().getNameMyCENTERRadioFromMetamodel(), null, myBEGINNINGRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myCENTERRadio);

		myENDRadio = createRadioButton(myVerticalAlignmentGroup, getModelHelper().getNameMyENDRadioFromMetamodel(), null, myCENTERRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myENDRadio);

		myFILLRadio = createRadioButton(myVerticalAlignmentGroup, getModelHelper().getNameMyFILLRadioFromMetamodel(), null, myENDRadio, null, null, false, true, false, false);

		getListener().startListeningTo(myFILLRadio);

		myHorizontalAlignmentGroup = createGroupWidget(myMyGridLayoutDataGroupGroup, getModelHelper().getNameMyHorizontalAlignmentGroupFromMetamodel(), myVerticalAlignmentGroup, null, null, null,
				true, false, false, false);

		myBEGINNING$1Radio = createRadioButton(myHorizontalAlignmentGroup, getModelHelper().getNameMyBEGINNING$1RadioFromMetamodel(), null, null, null, null, true, true, false, false);

		getListener().startListeningTo(myBEGINNING$1Radio);

		myCENTER$1Radio = createRadioButton(myHorizontalAlignmentGroup, getModelHelper().getNameMyCENTER$1RadioFromMetamodel(), null, myBEGINNING$1Radio, null, null, false, true, false, false);

		getListener().startListeningTo(myCENTER$1Radio);

		myEND$1Radio = createRadioButton(myHorizontalAlignmentGroup, getModelHelper().getNameMyEND$1RadioFromMetamodel(), null, myCENTER$1Radio, null, null, false, true, false, false);

		getListener().startListeningTo(myEND$1Radio);

		myFILL$1Radio = createRadioButton(myHorizontalAlignmentGroup, getModelHelper().getNameMyFILL$1RadioFromMetamodel(), null, myEND$1Radio, null, null, false, true, false, false);

		getListener().startListeningTo(myFILL$1Radio);

		mySpanningsGroup = createGroupWidget(myMyGridLayoutDataGroupGroup, "Spannings", null, myVerticalAlignmentGroup, null, null, false, true, false, false);

		myVerticalSpanSpin = createSpinnerWidget(mySpanningsGroup, "Vertical", 1, 99, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myVerticalSpanSpin);

		myHorizontalSpanSpin = createSpinnerWidget(mySpanningsGroup, "Horizontal", 1, 99, 1, 100, myVerticalSpanSpin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myHorizontalSpanSpin);

		mySizeHintGroup = createGroupWidget(myMyGridLayoutDataGroupGroup, getModelHelper().getNameMySizeHintGroupFromMetamodel(), null, mySpanningsGroup, null, null, false, true, false, false);

		myDx$3Spin = createSpinnerWidget(mySizeHintGroup, "X", 0, 999, 1, 100, null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myDx$3Spin);

		myDy$3Spin = createSpinnerWidget(mySizeHintGroup, "Y", 0, 999, 1, 100, myDx$3Spin, null, null, null, true, false, false, false);
		getListener().startListeningTo(myDy$3Spin);

		myHorizontalIndentSpin = createSpinnerWidget(myMyGridLayoutDataGroupGroup, getModelHelper().getNameMyHorizontalIndentSpinFromMetamodel(), 0, 99, 1, 100, null, mySizeHintGroup, null, null,
				false, true, false, false);
		getListener().startListeningTo(myHorizontalIndentSpin);

		myMyCustomLayoutDataGroupGroup = createGroupWidget(myMyLayoutDataCompositeComposite, getModelHelper().getNameMyMyCustomLayoutDataGroupGroupFromMetamodel(), null, null, null, null, true, true,
				false, false);

		myBundleName$1Text = createTextWidget(myMyCustomLayoutDataGroupGroup, getModelHelper().getNameMyBundleName$1TextFromMetamodel(), null, null, null, null, true, true, false, false);
		getListener().startListeningTo(myBundleName$1Text);

		myQualifiedClassName$1Text = createTextWidget(myMyCustomLayoutDataGroupGroup, getModelHelper().getNameMyQualifiedClassName$1TextFromMetamodel(), null, myBundleName$1Text, null, null, false,
				true, false, false);
		getListener().startListeningTo(myQualifiedClassName$1Text);

	}

	/**
	 * @generated
	 */
	public void doDispose() {
		getListener().stopListeningTo(myMyBorderLayoutRadioRadio);

		getListener().stopListeningTo(myMyCustomLayoutRadioRadio);

		getListener().stopListeningTo(myMyGridLayoutRadioRadio);

		getListener().stopListeningTo(myMyFlowLayoutRadioRadio);

		getListener().stopListeningTo(myMyStackLayoutRadioRadio);

		getListener().stopListeningTo(myMyXYLayoutRadioRadio);

		getListener().stopListeningTo(myMyNoLayoutRadioRadio);

		getListener().stopListeningTo(myDxSpin);

		getListener().stopListeningTo(myDySpin);

		myLayoutBorderExpandGroupExpandableComposite.removeExpansionListener(getExpansionListener(null));
		getListener().stopListeningTo(mySingleLineCheckbox);

		getListener().stopListeningTo(myMinorSizeCheckbox);

		getListener().stopListeningTo(myMinorSpin);

		getListener().stopListeningTo(myMajorSpin);

		getListener().stopListeningTo(myMinorNRadio);

		getListener().stopListeningTo(myMinorERadio);

		getListener().stopListeningTo(myMinorCRadio);

		getListener().stopListeningTo(myMinorWRadio);

		getListener().stopListeningTo(myMinorSRadio);

		getListener().stopListeningTo(myMajorNRadio);

		getListener().stopListeningTo(myMajorERadio);

		getListener().stopListeningTo(myMajorCRadio);

		getListener().stopListeningTo(myMajorWRadio);

		getListener().stopListeningTo(myMajorSRadio);

		myLayoutFlowExpandGroupExpandableComposite.removeExpansionListener(getExpansionListener(null));
		getListener().stopListeningTo(myNumColumnsSpin);

		getListener().stopListeningTo(myEqualWidthCheckbox);

		getListener().stopListeningTo(myDx$1Spin);

		getListener().stopListeningTo(myDy$1Spin);

		getListener().stopListeningTo(myDx$2Spin);

		getListener().stopListeningTo(myDy$2Spin);

		myLayoutGridExpandGroupExpandableComposite.removeExpansionListener(getExpansionListener(null));
		getListener().stopListeningTo(myBundleNameText);

		getListener().stopListeningTo(myQualifiedClassNameText);

		myLayoutCustomExpandGroupExpandableComposite.removeExpansionListener(getExpansionListener(null));

		getListener().stopListeningTo(myBorderNRadio);

		getListener().stopListeningTo(myBorderERadio);

		getListener().stopListeningTo(myBorderCRadio);

		getListener().stopListeningTo(myBorderWRadio);

		getListener().stopListeningTo(myBorderSRadio);

		getListener().stopListeningTo(myMyXYDataXSpinSpin);

		getListener().stopListeningTo(myMyXYDataYSpinSpin);

		getListener().stopListeningTo(myMyXYDataSizeXSpinSpin);

		getListener().stopListeningTo(myMyXYDataSizeYSpinSpin);

		getListener().stopListeningTo(myGrabExcessHorizontalSpaceCheckbox);

		getListener().stopListeningTo(myGrabExcessVerticalSpaceCheckbox);

		getListener().stopListeningTo(myBEGINNINGRadio);

		getListener().stopListeningTo(myCENTERRadio);

		getListener().stopListeningTo(myENDRadio);

		getListener().stopListeningTo(myFILLRadio);

		getListener().stopListeningTo(myBEGINNING$1Radio);

		getListener().stopListeningTo(myCENTER$1Radio);

		getListener().stopListeningTo(myEND$1Radio);

		getListener().stopListeningTo(myFILL$1Radio);

		getListener().stopListeningTo(myVerticalSpanSpin);

		getListener().stopListeningTo(myHorizontalSpanSpin);

		getListener().stopListeningTo(myDx$3Spin);

		getListener().stopListeningTo(myDy$3Spin);

		getListener().stopListeningTo(myHorizontalIndentSpin);

		getListener().stopListeningTo(myBundleName$1Text);

		getListener().stopListeningTo(myQualifiedClassName$1Text);

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
				myMyBorderLayoutRadioRadio.setSelection(getModelHelper().getValueForMyMyBorderLayoutRadioRadio(target));
				myMyCustomLayoutRadioRadio.setSelection(getModelHelper().getValueForMyMyCustomLayoutRadioRadio(target));
				myMyGridLayoutRadioRadio.setSelection(getModelHelper().getValueForMyMyGridLayoutRadioRadio(target));
				myMyFlowLayoutRadioRadio.setSelection(getModelHelper().getValueForMyMyFlowLayoutRadioRadio(target));
				myMyStackLayoutRadioRadio.setSelection(getModelHelper().getValueForMyMyStackLayoutRadioRadio(target));
				myMyXYLayoutRadioRadio.setSelection(getModelHelper().getValueForMyMyXYLayoutRadioRadio(target));
				myMyNoLayoutRadioRadio.setSelection(getModelHelper().getValueForMyMyNoLayoutRadioRadio(target));
			}
			{

				boolean isMyLayoutBorderExpandGroupExpandableCompositeVisible = getModelHelper().isVisibleMyLayoutBorderExpandGroupExpandableComposite(target);
				if (myLayoutBorderExpandGroupExpandableComposite.isExpanded() != isMyLayoutBorderExpandGroupExpandableCompositeVisible) {
					needToRelayoutExpandBar = true;
				}

				myLayoutBorderExpandGroupExpandableComposite.setExpanded(isMyLayoutBorderExpandGroupExpandableCompositeVisible);
				if (isMyLayoutBorderExpandGroupExpandableCompositeVisible) {

					{
						myDxSpin.setSelection(getModelHelper().getValueForMyDxSpin(target));
						myDySpin.setSelection(getModelHelper().getValueForMyDySpin(target));
					}
				}
				boolean isMyLayoutFlowExpandGroupExpandableCompositeVisible = getModelHelper().isVisibleMyLayoutFlowExpandGroupExpandableComposite(target);
				if (myLayoutFlowExpandGroupExpandableComposite.isExpanded() != isMyLayoutFlowExpandGroupExpandableCompositeVisible) {
					needToRelayoutExpandBar = true;
				}

				myLayoutFlowExpandGroupExpandableComposite.setExpanded(isMyLayoutFlowExpandGroupExpandableCompositeVisible);
				if (isMyLayoutFlowExpandGroupExpandableCompositeVisible) {

					{
						mySingleLineCheckbox.setSelection(getModelHelper().getValueForMySingleLineCheckbox(target));
						myMinorSizeCheckbox.setSelection(getModelHelper().getValueForMyMinorSizeCheckbox(target));

						{
							myMinorSpin.setSelection(getModelHelper().getValueForMyMinorSpin(target));
							myMajorSpin.setSelection(getModelHelper().getValueForMyMajorSpin(target));
						}
						{
							myMinorTopELabel.setText("       ");
							myMinorNRadio.setSelection(getModelHelper().getValueForMyMinorNRadio(target));
							myMinorERadio.setSelection(getModelHelper().getValueForMyMinorERadio(target));
							myMinorCRadio.setSelection(getModelHelper().getValueForMyMinorCRadio(target));
							myMinorWRadio.setSelection(getModelHelper().getValueForMyMinorWRadio(target));
							myMinorSRadio.setSelection(getModelHelper().getValueForMyMinorSRadio(target));
						}
						{
							myMajorTopELabel.setText("       ");
							myMajorNRadio.setSelection(getModelHelper().getValueForMyMajorNRadio(target));
							myMajorERadio.setSelection(getModelHelper().getValueForMyMajorERadio(target));
							myMajorCRadio.setSelection(getModelHelper().getValueForMyMajorCRadio(target));
							myMajorWRadio.setSelection(getModelHelper().getValueForMyMajorWRadio(target));
							myMajorSRadio.setSelection(getModelHelper().getValueForMyMajorSRadio(target));
						}
					}
				}
				boolean isMyLayoutGridExpandGroupExpandableCompositeVisible = getModelHelper().isVisibleMyLayoutGridExpandGroupExpandableComposite(target);
				if (myLayoutGridExpandGroupExpandableComposite.isExpanded() != isMyLayoutGridExpandGroupExpandableCompositeVisible) {
					needToRelayoutExpandBar = true;
				}

				myLayoutGridExpandGroupExpandableComposite.setExpanded(isMyLayoutGridExpandGroupExpandableCompositeVisible);
				if (isMyLayoutGridExpandGroupExpandableCompositeVisible) {

					{
						myNumColumnsSpin.setSelection(getModelHelper().getValueForMyNumColumnsSpin(target));
						myEqualWidthCheckbox.setSelection(getModelHelper().getValueForMyEqualWidthCheckbox(target));

						{
							myDx$1Spin.setSelection(getModelHelper().getValueForMyDx$1Spin(target));
							myDy$1Spin.setSelection(getModelHelper().getValueForMyDy$1Spin(target));
						}
						{
							myDx$2Spin.setSelection(getModelHelper().getValueForMyDx$2Spin(target));
							myDy$2Spin.setSelection(getModelHelper().getValueForMyDy$2Spin(target));
						}
					}
				}
				boolean isMyLayoutCustomExpandGroupExpandableCompositeVisible = getModelHelper().isVisibleMyLayoutCustomExpandGroupExpandableComposite(target);
				if (myLayoutCustomExpandGroupExpandableComposite.isExpanded() != isMyLayoutCustomExpandGroupExpandableCompositeVisible) {
					needToRelayoutExpandBar = true;
				}

				myLayoutCustomExpandGroupExpandableComposite.setExpanded(isMyLayoutCustomExpandGroupExpandableCompositeVisible);
				if (isMyLayoutCustomExpandGroupExpandableCompositeVisible) {

					{
						myBundleNameText.setText(getModelHelper().getValueForMyBundleNameText(target));
						myQualifiedClassNameText.setText(getModelHelper().getValueForMyQualifiedClassNameText(target));
					}
				}
			}
		}
		{

			boolean isMyBorderLayoutDataGroupGroupVisible = getModelHelper().isVisibleMyBorderLayoutDataGroupGroup(target);

			myBorderLayoutDataGroupGroup.setVisible(isMyBorderLayoutDataGroupGroupVisible);
			if (isMyBorderLayoutDataGroupGroupVisible) {

				{
					myUpperELabel.setText("       ");
					myBorderNRadio.setSelection(getModelHelper().getValueForMyBorderNRadio(target));
					myBorderERadio.setSelection(getModelHelper().getValueForMyBorderERadio(target));
					myBorderCRadio.setSelection(getModelHelper().getValueForMyBorderCRadio(target));
					myBorderWRadio.setSelection(getModelHelper().getValueForMyBorderWRadio(target));
					myBorderSRadio.setSelection(getModelHelper().getValueForMyBorderSRadio(target));
				}
			}
			boolean isMyMyXYLayoutDataGroupGroupVisible = getModelHelper().isVisibleMyMyXYLayoutDataGroupGroup(target);

			myMyXYLayoutDataGroupGroup.setVisible(isMyMyXYLayoutDataGroupGroupVisible);
			if (isMyMyXYLayoutDataGroupGroupVisible) {

				{
					myMyXYDataXSpinSpin.setSelection(getModelHelper().getValueForMyMyXYDataXSpinSpin(target));
					myMyXYDataYSpinSpin.setSelection(getModelHelper().getValueForMyMyXYDataYSpinSpin(target));
				}
				{
					myMyXYDataSizeXSpinSpin.setSelection(getModelHelper().getValueForMyMyXYDataSizeXSpinSpin(target));
					myMyXYDataSizeYSpinSpin.setSelection(getModelHelper().getValueForMyMyXYDataSizeYSpinSpin(target));
				}
			}
			boolean isMyMyGridLayoutDataGroupGroupVisible = getModelHelper().isVisibleMyMyGridLayoutDataGroupGroup(target);

			myMyGridLayoutDataGroupGroup.setVisible(isMyMyGridLayoutDataGroupGroupVisible);
			if (isMyMyGridLayoutDataGroupGroupVisible) {
				myGrabExcessHorizontalSpaceCheckbox.setSelection(getModelHelper().getValueForMyGrabExcessHorizontalSpaceCheckbox(target));
				myGrabExcessVerticalSpaceCheckbox.setSelection(getModelHelper().getValueForMyGrabExcessVerticalSpaceCheckbox(target));

				{
					myBEGINNINGRadio.setSelection(getModelHelper().getValueForMyBEGINNINGRadio(target));
					myCENTERRadio.setSelection(getModelHelper().getValueForMyCENTERRadio(target));
					myENDRadio.setSelection(getModelHelper().getValueForMyENDRadio(target));
					myFILLRadio.setSelection(getModelHelper().getValueForMyFILLRadio(target));
				}
				{
					myBEGINNING$1Radio.setSelection(getModelHelper().getValueForMyBEGINNING$1Radio(target));
					myCENTER$1Radio.setSelection(getModelHelper().getValueForMyCENTER$1Radio(target));
					myEND$1Radio.setSelection(getModelHelper().getValueForMyEND$1Radio(target));
					myFILL$1Radio.setSelection(getModelHelper().getValueForMyFILL$1Radio(target));
				}
				{
					myVerticalSpanSpin.setSelection(getModelHelper().getValueForMyVerticalSpanSpin(target));
					myHorizontalSpanSpin.setSelection(getModelHelper().getValueForMyHorizontalSpanSpin(target));
				}
				{
					myDx$3Spin.setSelection(getModelHelper().getValueForMyDx$3Spin(target));
					myDy$3Spin.setSelection(getModelHelper().getValueForMyDy$3Spin(target));
				}
				myHorizontalIndentSpin.setSelection(getModelHelper().getValueForMyHorizontalIndentSpin(target));
			}
			boolean isMyMyCustomLayoutDataGroupGroupVisible = getModelHelper().isVisibleMyMyCustomLayoutDataGroupGroup(target);

			myMyCustomLayoutDataGroupGroup.setVisible(isMyMyCustomLayoutDataGroupGroupVisible);
			if (isMyMyCustomLayoutDataGroupGroupVisible) {
				myBundleName$1Text.setText(getModelHelper().getValueForMyBundleName$1Text(target));
				myQualifiedClassName$1Text.setText(getModelHelper().getValueForMyQualifiedClassName$1Text(target));
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
	public void applyChangesFrom(final Widget widget, int kindP) {
		final String commandName = "Modifying model with ui data from " + widget.toString();
		final int kind = kindP; // just to overcome jmerge limitation
		ArrayList commands = new ArrayList(getSavedSelection().size());
		for (Iterator it = getSavedSelection().iterator(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof Layoutable) {
				final Layoutable target = (Layoutable) next;
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
	void applyModelModifier(final Layoutable target, final Widget widget, int kind) {
		if (widget == myMyBorderLayoutRadioRadio && myMyBorderLayoutRadioRadio.isVisible()) {
			if (myMyBorderLayoutRadioRadio.getSelection()) {
				getModelHelper().setValueForMyMyBorderLayoutRadioRadio(target, true);
			}
			return;
		}
		if (widget == myMyCustomLayoutRadioRadio && myMyCustomLayoutRadioRadio.isVisible()) {
			if (myMyCustomLayoutRadioRadio.getSelection()) {
				getModelHelper().setValueForMyMyCustomLayoutRadioRadio(target, true);
			}
			return;
		}
		if (widget == myMyGridLayoutRadioRadio && myMyGridLayoutRadioRadio.isVisible()) {
			if (myMyGridLayoutRadioRadio.getSelection()) {
				getModelHelper().setValueForMyMyGridLayoutRadioRadio(target, true);
			}
			return;
		}
		if (widget == myMyFlowLayoutRadioRadio && myMyFlowLayoutRadioRadio.isVisible()) {
			if (myMyFlowLayoutRadioRadio.getSelection()) {
				getModelHelper().setValueForMyMyFlowLayoutRadioRadio(target, true);
			}
			return;
		}
		if (widget == myMyStackLayoutRadioRadio && myMyStackLayoutRadioRadio.isVisible()) {
			if (myMyStackLayoutRadioRadio.getSelection()) {
				getModelHelper().setValueForMyMyStackLayoutRadioRadio(target, true);
			}
			return;
		}
		if (widget == myMyXYLayoutRadioRadio && myMyXYLayoutRadioRadio.isVisible()) {
			if (myMyXYLayoutRadioRadio.getSelection()) {
				getModelHelper().setValueForMyMyXYLayoutRadioRadio(target, true);
			}
			return;
		}
		if (widget == myMyNoLayoutRadioRadio && myMyNoLayoutRadioRadio.isVisible()) {
			if (myMyNoLayoutRadioRadio.getSelection()) {
				getModelHelper().setValueForMyMyNoLayoutRadioRadio(target, true);
			}
			return;
		}
		if (widget == myDxSpin && myDxSpin.isVisible()) {
			getModelHelper().setValueForMyDxSpin(target, myDxSpin.getSelection());
			return;
		}
		if (widget == myDySpin && myDySpin.isVisible()) {
			getModelHelper().setValueForMyDySpin(target, myDySpin.getSelection());
			return;
		}
		if (widget == mySingleLineCheckbox && mySingleLineCheckbox.isVisible()) {
			getModelHelper().setValueForMySingleLineCheckbox(target, mySingleLineCheckbox.getSelection());
			return;
		}
		if (widget == myMinorSizeCheckbox && myMinorSizeCheckbox.isVisible()) {
			getModelHelper().setValueForMyMinorSizeCheckbox(target, myMinorSizeCheckbox.getSelection());
			return;
		}
		if (widget == myMinorSpin && myMinorSpin.isVisible()) {
			getModelHelper().setValueForMyMinorSpin(target, myMinorSpin.getSelection());
			return;
		}
		if (widget == myMajorSpin && myMajorSpin.isVisible()) {
			getModelHelper().setValueForMyMajorSpin(target, myMajorSpin.getSelection());
			return;
		}
		if (widget == myMinorNRadio && myMinorNRadio.isVisible()) {
			if (myMinorNRadio.getSelection()) {
				getModelHelper().setValueForMyMinorNRadio(target, true);
			}
			return;
		}
		if (widget == myMinorERadio && myMinorERadio.isVisible()) {
			if (myMinorERadio.getSelection()) {
				getModelHelper().setValueForMyMinorERadio(target, true);
			}
			return;
		}
		if (widget == myMinorCRadio && myMinorCRadio.isVisible()) {
			if (myMinorCRadio.getSelection()) {
				getModelHelper().setValueForMyMinorCRadio(target, true);
			}
			return;
		}
		if (widget == myMinorWRadio && myMinorWRadio.isVisible()) {
			if (myMinorWRadio.getSelection()) {
				getModelHelper().setValueForMyMinorWRadio(target, true);
			}
			return;
		}
		if (widget == myMinorSRadio && myMinorSRadio.isVisible()) {
			if (myMinorSRadio.getSelection()) {
				getModelHelper().setValueForMyMinorSRadio(target, true);
			}
			return;
		}
		if (widget == myMajorNRadio && myMajorNRadio.isVisible()) {
			if (myMajorNRadio.getSelection()) {
				getModelHelper().setValueForMyMajorNRadio(target, true);
			}
			return;
		}
		if (widget == myMajorERadio && myMajorERadio.isVisible()) {
			if (myMajorERadio.getSelection()) {
				getModelHelper().setValueForMyMajorERadio(target, true);
			}
			return;
		}
		if (widget == myMajorCRadio && myMajorCRadio.isVisible()) {
			if (myMajorCRadio.getSelection()) {
				getModelHelper().setValueForMyMajorCRadio(target, true);
			}
			return;
		}
		if (widget == myMajorWRadio && myMajorWRadio.isVisible()) {
			if (myMajorWRadio.getSelection()) {
				getModelHelper().setValueForMyMajorWRadio(target, true);
			}
			return;
		}
		if (widget == myMajorSRadio && myMajorSRadio.isVisible()) {
			if (myMajorSRadio.getSelection()) {
				getModelHelper().setValueForMyMajorSRadio(target, true);
			}
			return;
		}
		if (widget == myNumColumnsSpin && myNumColumnsSpin.isVisible()) {
			getModelHelper().setValueForMyNumColumnsSpin(target, myNumColumnsSpin.getSelection());
			return;
		}
		if (widget == myEqualWidthCheckbox && myEqualWidthCheckbox.isVisible()) {
			getModelHelper().setValueForMyEqualWidthCheckbox(target, myEqualWidthCheckbox.getSelection());
			return;
		}
		if (widget == myDx$1Spin && myDx$1Spin.isVisible()) {
			getModelHelper().setValueForMyDx$1Spin(target, myDx$1Spin.getSelection());
			return;
		}
		if (widget == myDy$1Spin && myDy$1Spin.isVisible()) {
			getModelHelper().setValueForMyDy$1Spin(target, myDy$1Spin.getSelection());
			return;
		}
		if (widget == myDx$2Spin && myDx$2Spin.isVisible()) {
			getModelHelper().setValueForMyDx$2Spin(target, myDx$2Spin.getSelection());
			return;
		}
		if (widget == myDy$2Spin && myDy$2Spin.isVisible()) {
			getModelHelper().setValueForMyDy$2Spin(target, myDy$2Spin.getSelection());
			return;
		}
		if (widget == myBundleNameText && myBundleNameText.isVisible()) {
			getModelHelper().setValueForMyBundleNameText(target, myBundleNameText.getText());
			return;
		}
		if (widget == myQualifiedClassNameText && myQualifiedClassNameText.isVisible()) {
			getModelHelper().setValueForMyQualifiedClassNameText(target, myQualifiedClassNameText.getText());
			return;
		}
		if (widget == myBorderNRadio && myBorderNRadio.isVisible()) {
			if (myBorderNRadio.getSelection()) {
				getModelHelper().setValueForMyBorderNRadio(target, true);
			}
			return;
		}
		if (widget == myBorderERadio && myBorderERadio.isVisible()) {
			if (myBorderERadio.getSelection()) {
				getModelHelper().setValueForMyBorderERadio(target, true);
			}
			return;
		}
		if (widget == myBorderCRadio && myBorderCRadio.isVisible()) {
			if (myBorderCRadio.getSelection()) {
				getModelHelper().setValueForMyBorderCRadio(target, true);
			}
			return;
		}
		if (widget == myBorderWRadio && myBorderWRadio.isVisible()) {
			if (myBorderWRadio.getSelection()) {
				getModelHelper().setValueForMyBorderWRadio(target, true);
			}
			return;
		}
		if (widget == myBorderSRadio && myBorderSRadio.isVisible()) {
			if (myBorderSRadio.getSelection()) {
				getModelHelper().setValueForMyBorderSRadio(target, true);
			}
			return;
		}
		if (widget == myMyXYDataXSpinSpin && myMyXYDataXSpinSpin.isVisible()) {
			getModelHelper().setValueForMyMyXYDataXSpinSpin(target, myMyXYDataXSpinSpin.getSelection());
			return;
		}
		if (widget == myMyXYDataYSpinSpin && myMyXYDataYSpinSpin.isVisible()) {
			getModelHelper().setValueForMyMyXYDataYSpinSpin(target, myMyXYDataYSpinSpin.getSelection());
			return;
		}
		if (widget == myMyXYDataSizeXSpinSpin && myMyXYDataSizeXSpinSpin.isVisible()) {
			getModelHelper().setValueForMyMyXYDataSizeXSpinSpin(target, myMyXYDataSizeXSpinSpin.getSelection());
			return;
		}
		if (widget == myMyXYDataSizeYSpinSpin && myMyXYDataSizeYSpinSpin.isVisible()) {
			getModelHelper().setValueForMyMyXYDataSizeYSpinSpin(target, myMyXYDataSizeYSpinSpin.getSelection());
			return;
		}
		if (widget == myGrabExcessHorizontalSpaceCheckbox && myGrabExcessHorizontalSpaceCheckbox.isVisible()) {
			getModelHelper().setValueForMyGrabExcessHorizontalSpaceCheckbox(target, myGrabExcessHorizontalSpaceCheckbox.getSelection());
			return;
		}
		if (widget == myGrabExcessVerticalSpaceCheckbox && myGrabExcessVerticalSpaceCheckbox.isVisible()) {
			getModelHelper().setValueForMyGrabExcessVerticalSpaceCheckbox(target, myGrabExcessVerticalSpaceCheckbox.getSelection());
			return;
		}
		if (widget == myBEGINNINGRadio && myBEGINNINGRadio.isVisible()) {
			if (myBEGINNINGRadio.getSelection()) {
				getModelHelper().setValueForMyBEGINNINGRadio(target, true);
			}
			return;
		}
		if (widget == myCENTERRadio && myCENTERRadio.isVisible()) {
			if (myCENTERRadio.getSelection()) {
				getModelHelper().setValueForMyCENTERRadio(target, true);
			}
			return;
		}
		if (widget == myENDRadio && myENDRadio.isVisible()) {
			if (myENDRadio.getSelection()) {
				getModelHelper().setValueForMyENDRadio(target, true);
			}
			return;
		}
		if (widget == myFILLRadio && myFILLRadio.isVisible()) {
			if (myFILLRadio.getSelection()) {
				getModelHelper().setValueForMyFILLRadio(target, true);
			}
			return;
		}
		if (widget == myBEGINNING$1Radio && myBEGINNING$1Radio.isVisible()) {
			if (myBEGINNING$1Radio.getSelection()) {
				getModelHelper().setValueForMyBEGINNING$1Radio(target, true);
			}
			return;
		}
		if (widget == myCENTER$1Radio && myCENTER$1Radio.isVisible()) {
			if (myCENTER$1Radio.getSelection()) {
				getModelHelper().setValueForMyCENTER$1Radio(target, true);
			}
			return;
		}
		if (widget == myEND$1Radio && myEND$1Radio.isVisible()) {
			if (myEND$1Radio.getSelection()) {
				getModelHelper().setValueForMyEND$1Radio(target, true);
			}
			return;
		}
		if (widget == myFILL$1Radio && myFILL$1Radio.isVisible()) {
			if (myFILL$1Radio.getSelection()) {
				getModelHelper().setValueForMyFILL$1Radio(target, true);
			}
			return;
		}
		if (widget == myVerticalSpanSpin && myVerticalSpanSpin.isVisible()) {
			getModelHelper().setValueForMyVerticalSpanSpin(target, myVerticalSpanSpin.getSelection());
			return;
		}
		if (widget == myHorizontalSpanSpin && myHorizontalSpanSpin.isVisible()) {
			getModelHelper().setValueForMyHorizontalSpanSpin(target, myHorizontalSpanSpin.getSelection());
			return;
		}
		if (widget == myDx$3Spin && myDx$3Spin.isVisible()) {
			getModelHelper().setValueForMyDx$3Spin(target, myDx$3Spin.getSelection());
			return;
		}
		if (widget == myDy$3Spin && myDy$3Spin.isVisible()) {
			getModelHelper().setValueForMyDy$3Spin(target, myDy$3Spin.getSelection());
			return;
		}
		if (widget == myHorizontalIndentSpin && myHorizontalIndentSpin.isVisible()) {
			getModelHelper().setValueForMyHorizontalIndentSpin(target, myHorizontalIndentSpin.getSelection());
			return;
		}
		if (widget == myBundleName$1Text && myBundleName$1Text.isVisible()) {
			getModelHelper().setValueForMyBundleName$1Text(target, myBundleName$1Text.getText());
			return;
		}
		if (widget == myQualifiedClassName$1Text && myQualifiedClassName$1Text.isVisible()) {
			getModelHelper().setValueForMyQualifiedClassName$1Text(target, myQualifiedClassName$1Text.getText());
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
		public void setValueForMyMyBorderLayoutRadioRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setLayoutDataToChildren(layoutable, GMFGraphFactory.eINSTANCE.createBorderLayoutData());
			setValueForMyMyBorderLayoutRadioRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyCustomLayoutRadioRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setLayoutDataToChildren(layoutable, GMFGraphFactory.eINSTANCE.createCustomLayoutData());
			setValueForMyMyCustomLayoutRadioRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyGridLayoutRadioRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setLayoutDataToChildren(layoutable, GMFGraphFactory.eINSTANCE.createGridLayoutData());
			setValueForMyMyGridLayoutRadioRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyFlowLayoutRadioRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;

			setValueForMyMyFlowLayoutRadioRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyStackLayoutRadioRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;

			setValueForMyMyStackLayoutRadioRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyXYLayoutRadioRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setLayoutDataToChildren(layoutable, GMFGraphFactory.eINSTANCE.createXYLayoutData());
			setValueForMyMyXYLayoutRadioRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMyNoLayoutRadioRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;

			setValueForMyMyNoLayoutRadioRadioGen(layoutable, valueToSet);
			GeneratedLayoutPropertySection.this.refresh();
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMinorNRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMinorNRadioGen(layoutable);
			result = result && getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMinorNRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, true);
			setValueForMyMinorNRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMinorERadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMinorERadioGen(layoutable);
			result = result && !getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMinorERadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, false);
			setValueForMyMinorERadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMinorWRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMinorWRadioGen(layoutable);
			result = result && !getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMinorWRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, false);
			setValueForMyMinorWRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMinorSRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMinorSRadioGen(layoutable);
			result = result && getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMinorSRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, true);
			setValueForMyMinorSRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMajorNRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMajorNRadioGen(layoutable);
			result = result && getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMajorNRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, true);
			setValueForMyMajorNRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMajorERadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMajorERadioGen(layoutable);
			result = result && !getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMajorERadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, false);
			setValueForMyMajorERadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMajorWRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMajorWRadioGen(layoutable);
			result = result && !getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMajorWRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, false);
			setValueForMyMajorWRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyMajorSRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyMajorSRadioGen(layoutable);
			result = result && getFlowLayoutVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyMajorSRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setFlowLayoutVerticalKind(layoutable, true);
			setValueForMyMajorSRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyBorderNRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyBorderNRadioGen(layoutable);
			result = result && getBorderLayoutDataVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyBorderNRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setBorderLayoutDataVerticalKind(layoutable, true);
			setValueForMyBorderNRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyBorderERadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyBorderERadioGen(layoutable);
			result = result && !getBorderLayoutDataVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyBorderERadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setBorderLayoutDataVerticalKind(layoutable, false);
			setValueForMyBorderERadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyBorderWRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyBorderWRadioGen(layoutable);
			result = result && !getBorderLayoutDataVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyBorderWRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setBorderLayoutDataVerticalKind(layoutable, false);
			setValueForMyBorderWRadioGen(layoutable, valueToSet);
		}

		/**
		 * @generated NOT
		 */
		public boolean getValueForMyBorderSRadio(Layoutable layoutable) {
			boolean result;
			result = getValueForMyBorderSRadioGen(layoutable);
			result = result && getBorderLayoutDataVerticalKind(layoutable);
			return result;
		}

		/**
		 * @generated NOT
		 */
		public void setValueForMyBorderSRadio(Layoutable layoutable, boolean value) {
			boolean valueToSet;
			valueToSet = value;
			setBorderLayoutDataVerticalKind(layoutable, true);
			setValueForMyBorderSRadioGen(layoutable, valueToSet);
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
		public boolean getValueForMyMyBorderLayoutRadioRadio(Layoutable layoutable) {
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
		public void setValueForMyMyBorderLayoutRadioRadioGen(Layoutable layoutable, boolean value) {
			layoutable.setLayout(GMFGraphFactory.eINSTANCE.createBorderLayout());

		}

		/**
		 * @generated
		 */
		public String getNameMyMyBorderLayoutRadioRadioFromMetamodel() {
			return "BorderLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyCustomLayoutRadioRadio(Layoutable layoutable) {
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
		public void setValueForMyMyCustomLayoutRadioRadioGen(Layoutable layoutable, boolean value) {
			layoutable.setLayout(GMFGraphFactory.eINSTANCE.createCustomLayout());

		}

		/**
		 * @generated
		 */
		public String getNameMyMyCustomLayoutRadioRadioFromMetamodel() {
			return "CustomLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyGridLayoutRadioRadio(Layoutable layoutable) {
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
		public void setValueForMyMyGridLayoutRadioRadioGen(Layoutable layoutable, boolean value) {
			layoutable.setLayout(GMFGraphFactory.eINSTANCE.createGridLayout());

		}

		/**
		 * @generated
		 */
		public String getNameMyMyGridLayoutRadioRadioFromMetamodel() {
			return "GridLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyFlowLayoutRadioRadio(Layoutable layoutable) {
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
		public void setValueForMyMyFlowLayoutRadioRadioGen(Layoutable layoutable, boolean value) {
			layoutable.setLayout(GMFGraphFactory.eINSTANCE.createFlowLayout());

		}

		/**
		 * @generated
		 */
		public String getNameMyMyFlowLayoutRadioRadioFromMetamodel() {
			return "FlowLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyStackLayoutRadioRadio(Layoutable layoutable) {
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
		public void setValueForMyMyStackLayoutRadioRadioGen(Layoutable layoutable, boolean value) {
			layoutable.setLayout(GMFGraphFactory.eINSTANCE.createStackLayout());

		}

		/**
		 * @generated
		 */
		public String getNameMyMyStackLayoutRadioRadioFromMetamodel() {
			return "StackLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyXYLayoutRadioRadio(Layoutable layoutable) {
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
		public void setValueForMyMyXYLayoutRadioRadioGen(Layoutable layoutable, boolean value) {
			layoutable.setLayout(GMFGraphFactory.eINSTANCE.createXYLayout());

		}

		/**
		 * @generated
		 */
		public String getNameMyMyXYLayoutRadioRadioFromMetamodel() {
			return "XYLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMyNoLayoutRadioRadio(Layoutable layoutable) {
			boolean value = false;

			Layout layout = layoutable.getLayout();
			value = (layout == null);

			return value;
		}

		/**
		 * @generated
		 */
		public void setValueForMyMyNoLayoutRadioRadioGen(Layoutable layoutable, boolean value) {
			layoutable.setLayout(null);

		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyLayoutBorderExpandGroupExpandableComposite(Layoutable targetVar) {
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
		public String getNameMyLayoutBorderExpandGroupExpandableCompositeFromMetamodel() {
			return "BorderLayout";
		}

		/**
		 * @generated
		 */
		public String getNameMyBorderParamsGroupFromMetamodel() {
			return "Spacing";
		}

		/**
		 * @generated
		 */
		public int getValueForMyDxSpin(Layoutable layoutable) {
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
		public void setValueForMyDxSpin(Layoutable layoutable, int value) {

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
		public int getValueForMyDySpin(Layoutable layoutable) {
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
		public void setValueForMyDySpin(Layoutable layoutable, int value) {

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
		public boolean isVisibleMyLayoutFlowExpandGroupExpandableComposite(Layoutable targetVar) {
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
		public String getNameMyLayoutFlowExpandGroupExpandableCompositeFromMetamodel() {
			return "FlowLayout";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMySingleLineCheckbox(Layoutable layoutable) {
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
		public void setValueForMySingleLineCheckbox(Layoutable layoutable, boolean value) {

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
		public String getNameMySingleLineCheckboxFromMetamodel() {
			return "ForceSingleLine";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMinorSizeCheckbox(Layoutable layoutable) {
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
		public void setValueForMyMinorSizeCheckbox(Layoutable layoutable, boolean value) {

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
		public String getNameMyMinorSizeCheckboxFromMetamodel() {
			return "MatchMinorSize";
		}

		/**
		 * @generated
		 */
		public int getValueForMyMinorSpin(Layoutable layoutable) {
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
		public void setValueForMyMinorSpin(Layoutable layoutable, int value) {

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
		public int getValueForMyMajorSpin(Layoutable layoutable) {
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
		public void setValueForMyMajorSpin(Layoutable layoutable, int value) {

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
		public String getNameMyMinorAlignGroupFromMetamodel() {
			return "MinorAlignment";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMinorNRadioGen(Layoutable layoutable) {
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
		public void setValueForMyMinorNRadioGen(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyMinorERadioGen(Layoutable layoutable) {
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
		public void setValueForMyMinorERadioGen(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyMinorCRadio(Layoutable layoutable) {
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
		public void setValueForMyMinorCRadio(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyMinorWRadioGen(Layoutable layoutable) {
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
		public void setValueForMyMinorWRadioGen(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyMinorSRadioGen(Layoutable layoutable) {
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
		public void setValueForMyMinorSRadioGen(Layoutable layoutable, boolean value) {

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
		public String getNameMyMajorAlignGroupFromMetamodel() {
			return "MajorAlignment";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyMajorNRadioGen(Layoutable layoutable) {
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
		public void setValueForMyMajorNRadioGen(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyMajorERadioGen(Layoutable layoutable) {
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
		public void setValueForMyMajorERadioGen(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyMajorCRadio(Layoutable layoutable) {
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
		public void setValueForMyMajorCRadio(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyMajorWRadioGen(Layoutable layoutable) {
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
		public void setValueForMyMajorWRadioGen(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyMajorSRadioGen(Layoutable layoutable) {
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
		public void setValueForMyMajorSRadioGen(Layoutable layoutable, boolean value) {

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
		public boolean isVisibleMyLayoutGridExpandGroupExpandableComposite(Layoutable targetVar) {
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
		public String getNameMyLayoutGridExpandGroupExpandableCompositeFromMetamodel() {
			return "GridLayout";
		}

		/**
		 * @generated
		 */
		public int getValueForMyNumColumnsSpin(Layoutable layoutable) {
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
		public void setValueForMyNumColumnsSpin(Layoutable layoutable, int value) {

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
		public String getNameMyNumColumnsSpinFromMetamodel() {
			return "NumColumns";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyEqualWidthCheckbox(Layoutable layoutable) {
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
		public void setValueForMyEqualWidthCheckbox(Layoutable layoutable, boolean value) {

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
		public String getNameMyEqualWidthCheckboxFromMetamodel() {
			return "EqualWidth";
		}

		/**
		 * @generated
		 */
		public String getNameMyMarginsGroupFromMetamodel() {
			return "Margins";
		}

		/**
		 * @generated
		 */
		public int getValueForMyDx$1Spin(Layoutable layoutable) {
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
		public void setValueForMyDx$1Spin(Layoutable layoutable, int value) {

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
		public int getValueForMyDy$1Spin(Layoutable layoutable) {
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
		public void setValueForMyDy$1Spin(Layoutable layoutable, int value) {

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
		public String getNameMySpacingGroupFromMetamodel() {
			return "Spacing";
		}

		/**
		 * @generated
		 */
		public int getValueForMyDx$2Spin(Layoutable layoutable) {
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
		public void setValueForMyDx$2Spin(Layoutable layoutable, int value) {

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
		public int getValueForMyDy$2Spin(Layoutable layoutable) {
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
		public void setValueForMyDy$2Spin(Layoutable layoutable, int value) {

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
		public boolean isVisibleMyLayoutCustomExpandGroupExpandableComposite(Layoutable targetVar) {
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
		public String getNameMyLayoutCustomExpandGroupExpandableCompositeFromMetamodel() {
			return "CustomLayout";
		}

		/**
		 * @generated
		 */
		public String getValueForMyBundleNameText(Layoutable layoutable) {
			String value = EMPTY_STRING;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof CustomLayout) {
					CustomLayout customLayout = ((CustomLayout) layout);
					value = customLayout.getBundleName();

				}

			}

			if (value != null) {
				return value;
			}
			return EMPTY_STRING;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBundleNameText(Layoutable layoutable, String value) {

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
		public String getNameMyBundleNameTextFromMetamodel() {
			return "BundleName";
		}

		/**
		 * @generated
		 */
		public String getValueForMyQualifiedClassNameText(Layoutable layoutable) {
			String value = EMPTY_STRING;
			if (layoutable.getLayout() != null) {
				Layout layout = layoutable.getLayout();
				if (layout instanceof CustomLayout) {
					CustomLayout customLayout = ((CustomLayout) layout);
					value = customLayout.getQualifiedClassName();

				}

			}

			if (value != null) {
				return value;
			}
			return EMPTY_STRING;
		}

		/**
		 * @generated
		 */
		public void setValueForMyQualifiedClassNameText(Layoutable layoutable, String value) {

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
		public String getNameMyQualifiedClassNameTextFromMetamodel() {
			return "QualifiedClassName";
		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyBorderLayoutDataGroupGroup(Layoutable targetVar) {
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
		public String getNameMyBorderLayoutDataGroupGroupFromMetamodel() {
			return "BorderLayoutData";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyBorderNRadioGen(Layoutable layoutable) {
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
		public void setValueForMyBorderNRadioGen(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyBorderERadioGen(Layoutable layoutable) {
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
		public void setValueForMyBorderERadioGen(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyBorderCRadio(Layoutable layoutable) {
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
		public void setValueForMyBorderCRadio(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyBorderWRadioGen(Layoutable layoutable) {
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
		public void setValueForMyBorderWRadioGen(Layoutable layoutable, boolean value) {

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
		public boolean getValueForMyBorderSRadioGen(Layoutable layoutable) {
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
		public void setValueForMyBorderSRadioGen(Layoutable layoutable, boolean value) {

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
		public boolean isVisibleMyMyXYLayoutDataGroupGroup(Layoutable targetVar) {
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
		public String getNameMyMyXYLayoutDataGroupGroupFromMetamodel() {
			return "XYLayoutData";
		}

		/**
		 * @generated
		 */
		public int getValueForMyMyXYDataXSpinSpin(Layoutable layoutable) {
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
		public void setValueForMyMyXYDataXSpinSpin(Layoutable layoutable, int value) {

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
		public String getNameMyMyXYDataXSpinSpinFromMetamodel() {
			return "X";
		}

		/**
		 * @generated
		 */
		public int getValueForMyMyXYDataYSpinSpin(Layoutable layoutable) {
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
		public void setValueForMyMyXYDataYSpinSpin(Layoutable layoutable, int value) {

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
		public String getNameMyMyXYDataYSpinSpinFromMetamodel() {
			return "Y";
		}

		/**
		 * @generated
		 */
		public int getValueForMyMyXYDataSizeXSpinSpin(Layoutable layoutable) {
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
		public void setValueForMyMyXYDataSizeXSpinSpin(Layoutable layoutable, int value) {

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
		public int getValueForMyMyXYDataSizeYSpinSpin(Layoutable layoutable) {
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
		public void setValueForMyMyXYDataSizeYSpinSpin(Layoutable layoutable, int value) {

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
		public boolean isVisibleMyMyGridLayoutDataGroupGroup(Layoutable targetVar) {
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
		public String getNameMyMyGridLayoutDataGroupGroupFromMetamodel() {
			return "GridLayoutData";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyGrabExcessHorizontalSpaceCheckbox(Layoutable layoutable) {
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
		public void setValueForMyGrabExcessHorizontalSpaceCheckbox(Layoutable layoutable, boolean value) {

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
		public String getNameMyGrabExcessHorizontalSpaceCheckboxFromMetamodel() {
			return "GrabExcessHorizontalSpace";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyGrabExcessVerticalSpaceCheckbox(Layoutable layoutable) {
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
		public void setValueForMyGrabExcessVerticalSpaceCheckbox(Layoutable layoutable, boolean value) {

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
		public String getNameMyGrabExcessVerticalSpaceCheckboxFromMetamodel() {
			return "GrabExcessVerticalSpace";
		}

		/**
		 * @generated
		 */
		public String getNameMyVerticalAlignmentGroupFromMetamodel() {
			return "VerticalAlignment";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyBEGINNINGRadio(Layoutable layoutable) {
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
		public void setValueForMyBEGINNINGRadio(Layoutable layoutable, boolean value) {

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
		public String getNameMyBEGINNINGRadioFromMetamodel() {
			return "Beginning";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyCENTERRadio(Layoutable layoutable) {
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
		public void setValueForMyCENTERRadio(Layoutable layoutable, boolean value) {

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
		public String getNameMyCENTERRadioFromMetamodel() {
			return "Center";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyENDRadio(Layoutable layoutable) {
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
		public void setValueForMyENDRadio(Layoutable layoutable, boolean value) {

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
		public String getNameMyENDRadioFromMetamodel() {
			return "End";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyFILLRadio(Layoutable layoutable) {
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
		public void setValueForMyFILLRadio(Layoutable layoutable, boolean value) {

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
		public String getNameMyFILLRadioFromMetamodel() {
			return "Fill";
		}

		/**
		 * @generated
		 */
		public String getNameMyHorizontalAlignmentGroupFromMetamodel() {
			return "HorizontalAlignment";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyBEGINNING$1Radio(Layoutable layoutable) {
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
		public void setValueForMyBEGINNING$1Radio(Layoutable layoutable, boolean value) {

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
		public String getNameMyBEGINNING$1RadioFromMetamodel() {
			return "Beginning";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyCENTER$1Radio(Layoutable layoutable) {
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
		public void setValueForMyCENTER$1Radio(Layoutable layoutable, boolean value) {

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
		public String getNameMyCENTER$1RadioFromMetamodel() {
			return "Center";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyEND$1Radio(Layoutable layoutable) {
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
		public void setValueForMyEND$1Radio(Layoutable layoutable, boolean value) {

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
		public String getNameMyEND$1RadioFromMetamodel() {
			return "End";
		}

		/**
		 * @generated
		 */
		public boolean getValueForMyFILL$1Radio(Layoutable layoutable) {
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
		public void setValueForMyFILL$1Radio(Layoutable layoutable, boolean value) {

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
		public String getNameMyFILL$1RadioFromMetamodel() {
			return "Fill";
		}

		/**
		 * @generated
		 */
		public int getValueForMyVerticalSpanSpin(Layoutable layoutable) {
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
		public void setValueForMyVerticalSpanSpin(Layoutable layoutable, int value) {

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
		public int getValueForMyHorizontalSpanSpin(Layoutable layoutable) {
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
		public void setValueForMyHorizontalSpanSpin(Layoutable layoutable, int value) {

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
		public String getNameMySizeHintGroupFromMetamodel() {
			return "SizeHint";
		}

		/**
		 * @generated
		 */
		public int getValueForMyDx$3Spin(Layoutable layoutable) {
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
		public void setValueForMyDx$3Spin(Layoutable layoutable, int value) {

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
		public int getValueForMyDy$3Spin(Layoutable layoutable) {
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
		public void setValueForMyDy$3Spin(Layoutable layoutable, int value) {

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
		public int getValueForMyHorizontalIndentSpin(Layoutable layoutable) {
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
		public void setValueForMyHorizontalIndentSpin(Layoutable layoutable, int value) {

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
		public String getNameMyHorizontalIndentSpinFromMetamodel() {
			return "HorizontalIndent";
		}

		/**
		 * @generated
		 */
		public boolean isVisibleMyMyCustomLayoutDataGroupGroup(Layoutable targetVar) {
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
		public String getNameMyMyCustomLayoutDataGroupGroupFromMetamodel() {
			return "CustomLayoutData";
		}

		/**
		 * @generated
		 */
		public String getValueForMyBundleName$1Text(Layoutable layoutable) {
			String value = EMPTY_STRING;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof CustomLayoutData) {
					CustomLayoutData customLayoutData = ((CustomLayoutData) layoutData);
					value = customLayoutData.getBundleName();

				}

			}

			if (value != null) {
				return value;
			}
			return EMPTY_STRING;
		}

		/**
		 * @generated
		 */
		public void setValueForMyBundleName$1Text(Layoutable layoutable, String value) {

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
		public String getNameMyBundleName$1TextFromMetamodel() {
			return "BundleName";
		}

		/**
		 * @generated
		 */
		public String getValueForMyQualifiedClassName$1Text(Layoutable layoutable) {
			String value = EMPTY_STRING;
			if (layoutable.getLayoutData() != null) {
				LayoutData layoutData = layoutable.getLayoutData();
				if (layoutData instanceof CustomLayoutData) {
					CustomLayoutData customLayoutData = ((CustomLayoutData) layoutData);
					value = customLayoutData.getQualifiedClassName();

				}

			}

			if (value != null) {
				return value;
			}
			return EMPTY_STRING;
		}

		/**
		 * @generated
		 */
		public void setValueForMyQualifiedClassName$1Text(Layoutable layoutable, String value) {

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
		public String getNameMyQualifiedClassName$1TextFromMetamodel() {
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
