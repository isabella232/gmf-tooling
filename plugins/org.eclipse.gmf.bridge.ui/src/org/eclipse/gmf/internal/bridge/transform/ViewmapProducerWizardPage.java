/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Fedorov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.transform;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.internal.bridge.ui.Plugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

/*
 * XXX: duplicates functionality of org.eclipse.gmf.internal.graphdef.codegen.ui.FigureGeneratorOptionsDialog
 */
class ViewmapProducerWizardPage extends WizardPage {
	
    private Button generateRCPButton;
    private Button useMapModeButton;
    private Button useRuntimeFiguresButton;
	private Text templatesPathText;
	private Text qvtoFileControl;
	private Text preReconcileTranfsormText;
	private Text postReconcileTranfsormText;
	private Button radioDGMT;
	private Button radioQVT;
	private Button preReconcileTransformBtn;
	private Button postReconcileTransformBtn;

	protected ViewmapProducerWizardPage(String pageName) {
		super(pageName);
		setTitle(Messages.TransformToGenModelWizard_title_options);
		setDescription(Messages.TransformToGenModelWizard_descr_options);
	}
	
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		createControls(composite);
		initControls();
		validatePage();

		setControl(composite);
		Dialog.applyDialogFont(composite);
	}

	private void createControls(Composite result) {
        useMapModeButton = new Button(result, SWT.CHECK);
        useMapModeButton.setText(Messages.ViewmapProducerWizardPage_btn_mapmode);
        useMapModeButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.VERTICAL_ALIGN_CENTER));
        useRuntimeFiguresButton = new Button(result, SWT.CHECK);
        useRuntimeFiguresButton.setText(Messages.ViewmapProducerWizardPage_btn_runtime);
        useRuntimeFiguresButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.VERTICAL_ALIGN_CENTER));
        generateRCPButton = new Button(result, SWT.CHECK);
        generateRCPButton.setText(Messages.ViewmapProducerWizardPage_btn_rcp);
        generateRCPButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING | GridData.VERTICAL_ALIGN_CENTER));
        SelectionListener selectionListener = new SelectionListener() {
        	public void widgetDefaultSelected(SelectionEvent e) {
        		widgetSelected(e);
        	}

			public void widgetSelected(SelectionEvent e) {
				if (generateRCPButton == e.widget) {
					getOperation().getOptions().setGenerateRCP(generateRCPButton.getSelection());
				} else if (useMapModeButton == e.widget) {
					getOperation().getOptions().setUseMapMode(useMapModeButton.getSelection());
				} else if (useRuntimeFiguresButton == e.widget) {
					getOperation().getOptions().setUseRuntimeFigures(useRuntimeFiguresButton.getSelection());
				}
				validatePage();
			}
		};
        useMapModeButton.addSelectionListener(selectionListener);
        useRuntimeFiguresButton.addSelectionListener(selectionListener);
        generateRCPButton.addSelectionListener(selectionListener);
        createAdvancedControls(result);
        Composite glue = new Composite(result, SWT.NONE);
        glue.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
	}

	private void createAdvancedControls(Composite result) {
		Group parent = new Group(result, SWT.SHADOW_ETCHED_IN);
		parent.setText("Provisional");
		parent.setLayout(new FillLayout());
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		ExpandBar c = new ExpandBar(parent, SWT.NONE);
		c.setBackground(parent.getBackground());
        templatesPathText = new Text(c, SWT.SINGLE | SWT.BORDER);
		Listener modifyListener = new Listener() {
			public void handleEvent(Event event) {
				validatePage();
			}
		};
		templatesPathText.addListener(SWT.Modify, modifyListener);
        ExpandItem item = new ExpandItem(c, SWT.NONE, 0);
        item.setText("GMFGraph dynamic templates");
		item.setHeight(templatesPathText.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		item.setControl(templatesPathText);
		if (getOperation().getOptions().getFigureTemplatesPath() != null) {
			// reveal the value to avoid confusion.
			// FIXME extract expand bar with template path as separate control and
			// move expand logic there (based on setInitialValue event
			item.setExpanded(true);
		}
		//
		Composite map2genControls = new Composite(c, SWT.NONE);
		map2genControls.setLayout(new FillLayout(SWT.VERTICAL));
		radioDGMT = new Button(map2genControls, SWT.RADIO);
		radioDGMT.setText("Use Java transformation");
		radioQVT = new Button(map2genControls, SWT.RADIO);
		radioQVT.setText("Use QVTO transformation");
		qvtoFileControl = new Text(map2genControls, SWT.SINGLE | SWT.BORDER);
		qvtoFileControl.addListener(SWT.Modify, modifyListener);
		Listener l = new Listener() {
			public void handleEvent(Event event) {
				qvtoFileControl.setEnabled(radioQVT.getSelection());
			}
		};
		radioDGMT.addListener(SWT.Selection, l);
		radioQVT.addListener(SWT.Selection, l);
		preReconcileTransformBtn = new Button(map2genControls, SWT.CHECK);
		preReconcileTransformBtn.setText("Extra in-place gmfgen transformation before a reconcile step");
		preReconcileTranfsormText = new Text(map2genControls, SWT.SINGLE | SWT.BORDER);
		postReconcileTransformBtn = new Button(map2genControls, SWT.CHECK);
		postReconcileTransformBtn.setText("Extra in-place gmfgen transformation after a reconcile step");
		postReconcileTranfsormText = new Text(map2genControls, SWT.SINGLE | SWT.BORDER);
		l = new Listener() {
			public void handleEvent(Event event) {
				if (event.widget == preReconcileTransformBtn) {
					preReconcileTranfsormText.setEnabled(preReconcileTransformBtn.getSelection());
				} else if (event.widget == postReconcileTransformBtn) {
					postReconcileTranfsormText.setEnabled(postReconcileTransformBtn.getSelection());
				}
			}
		};
		preReconcileTransformBtn.addListener(SWT.Selection, l);
		postReconcileTransformBtn.addListener(SWT.Selection, l);
		preReconcileTranfsormText.addListener(SWT.Modify, modifyListener);
		postReconcileTranfsormText.addListener(SWT.Modify, modifyListener);
		item = new ExpandItem(c, SWT.NONE, 1);
		item.setText("Map to Gen transformation");
		item.setHeight(map2genControls.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		item.setControl(map2genControls);
		//
	}
	
	void validatePage() {
		setStatus(Status.OK_STATUS);
		boolean hasLite = TransformOptions.checkLiteOptionPresent();
		if (hasLite) {
			if (!useRuntimeFiguresButton.getSelection() && useMapModeButton.getSelection()) {
				setStatus(Plugin.createInfo(Messages.ViewmapProducerWizardPage_i_not_recommended));
			}
		}
		TransformOptions options = getOperation().getOptions();
		// safe to set option value now as they get flushed into storage only on Wizard.performFinish
		options.setFigureTemplatesPath(checkTextFieldURI(templatesPathText, true));
		options.setTransformation(checkTextFieldURI(qvtoFileControl, false));
		options.setPreReconcileTransform(checkTextFieldURI(preReconcileTranfsormText, false));
		options.setPostReconcileTransform(checkTextFieldURI(postReconcileTranfsormText, false));
	}

	private URL checkTextFieldURI(Text widget, boolean resolve) {
		if (!widget.isEnabled()) {
			return null;
		}
		if (widget.getText().trim().length() > 0) {
			try {
				return new URL(guessAndResolvePathURL(widget.getText().trim(), resolve));
			} catch (MalformedURLException ex) {
				setStatus(Plugin.createWarning(ex.getMessage()));
			}
		}
		return null;
	}

	private void initControls() {
		TransformOptions options = getOperation().getOptions();
		generateRCPButton.setSelection(options.getGenerateRCP());
		useRuntimeFiguresButton.setSelection(options.getUseRuntimeFigures());
		useMapModeButton.setSelection(options.getUseMapMode());
		if (null != options.getFigureTemplatesPath()) {
			templatesPathText.setText(options.getFigureTemplatesPath().toString());
		}
		radioDGMT.setSelection(options.getMainTransformation() == null);
		radioQVT.setSelection(!radioDGMT.getSelection());
		qvtoFileControl.setEnabled(radioQVT.getSelection());
		preReconcileTransformBtn.setSelection(options.getPreReconcileTransform() != null);
		preReconcileTranfsormText.setEnabled(preReconcileTransformBtn.getSelection());
		preReconcileTranfsormText.setText(options.getPreReconcileTransform() != null ? options.getPreReconcileTransform().toString() : "");
		postReconcileTransformBtn.setSelection(options.getPostReconcileTransform() != null);
		postReconcileTranfsormText.setEnabled(postReconcileTransformBtn.getSelection());
		postReconcileTranfsormText.setText(options.getPostReconcileTransform() != null ? options.getPostReconcileTransform().toString() : "");
	}

	private TransformToGenModelOperation getOperation() {
		return ((TransformToGenModelWizard) getWizard()).getTransformOperation();
	}

	private void setStatus(IStatus s) {
		if (s.isOK()) {
			setMessage(null);
			setPageComplete(true);
		} else {
    		setMessage(s.getMessage(), IMessageProvider.INFORMATION);
			setPageComplete(s.getSeverity() < IStatus.WARNING);
		}
	}

	private static String guessAndResolvePathURL(String path, boolean resolve) {
		assert path != null;
		URI templatesURI = path.indexOf(':') == -1 ? URI.createPlatformResourceURI(path, true) : URI.createURI(path);
		return resolve ? CommonPlugin.resolve(templatesURI).toString() : templatesURI.toString();
	}
}
