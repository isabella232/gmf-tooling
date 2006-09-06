/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.popup.actions;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

/**
 * XXX may introduce LinkEventListener.run(String linkHref, Callback dialog) later
 * Callback.closeWithReturnCode(int);
 * @author artem
 */
class LinkMessageDialog extends MessageDialog {
	private final String myMessage;

	// XXX consider expanding use of this class (with subclasses) to implement common
	// DialogEx behaviour (like toggle, button labels and retcodes)
	// also, may be reasonable to have these fields as final, with various constructor options
	static class Config {
		// don't want to have shell here to avoid any unnecessary references to it
		public String title = null;
		public String message = "";
		public Image titleImage = null;
		public int imageType = MessageDialog.NONE;
		public String[] buttonLabels;
		public int defaultIndex = 0;
	}

	public LinkMessageDialog(Shell shell, Config cfg) {
		super(shell, cfg.title, cfg.titleImage, null, cfg.imageType, cfg.buttonLabels, cfg.defaultIndex);
		myMessage = cfg.message;
	}

	@Override
	protected Control createMessageArea(Composite composite) {
		super.createMessageArea(composite);
        Link messageLabel = new Link(composite, SWT.NONE);
        messageLabel.setText(myMessage);
		// layoutData copied from IconAndMessageDialog#createMessageArea
        final GridData data = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
        data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.MINIMUM_MESSAGE_AREA_WIDTH);
        messageLabel.setLayoutData(data);
        messageLabel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dispatchLinkSelected(e.text);
			}
		});
		return composite;
	}

	protected void dispatchLinkSelected(String linkHref) {
	}
}
