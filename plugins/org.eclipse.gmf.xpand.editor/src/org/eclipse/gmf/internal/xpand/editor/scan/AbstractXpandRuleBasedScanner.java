/*
 * <copyright>
 *
 * Copyright (c) 2005-2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.gmf.internal.xpand.editor.scan;

import org.eclipse.gmf.internal.xpand.editor.Activator;
import org.eclipse.gmf.internal.xpand.editor.ColorProvider;
import org.eclipse.gmf.internal.xpand.editor.PreferencesConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;

public abstract class AbstractXpandRuleBasedScanner extends RuleBasedScanner {

    protected Token terminals;

    protected Token keyword;

    protected Token string;

    protected Token text;

    protected Token define;

    protected Token comment;

    protected Token other;

    public AbstractXpandRuleBasedScanner() {
        setTokens();
        setDefaultReturnToken(other);
    }

    protected synchronized void setTokens() {
        final IPreferenceStore aPreferenceStore = Activator.getDefault().getPreferenceStore();
        final ColorProvider provider = Activator.getColorProvider();
        terminals = new Token(new TextAttribute(provider.getColor(PreferenceConverter.getColor(aPreferenceStore,
                PreferencesConstants.HIGHLIGHT_TERMINALS))));

        keyword = new Token(new TextAttribute(provider.getColor(PreferenceConverter.getColor(aPreferenceStore,
                PreferencesConstants.HIGHLIGHT_KEYWORDS)), null, SWT.BOLD));

        string = new Token(new TextAttribute(provider.getColor(PreferenceConverter.getColor(aPreferenceStore,
                PreferencesConstants.HIGHLIGHT_STRING))));

        define = new Token(new TextAttribute(provider.getColor(PreferenceConverter.getColor(aPreferenceStore,
                PreferencesConstants.HIGHLIGHT_DEFINE)), null, SWT.BOLD));

        text = new Token(new TextAttribute(provider.getColor(PreferenceConverter.getColor(aPreferenceStore,
                PreferencesConstants.HIGHLIGHT_TEXT))));
        comment = new Token(new TextAttribute(provider.getColor(PreferenceConverter.getColor(aPreferenceStore,
                PreferencesConstants.HIGHLIGHT_COMMENT))));

        other = new Token(new TextAttribute(provider.getColor(PreferenceConverter.getColor(aPreferenceStore,
                PreferencesConstants.HIGHLIGHT_OTHER))));
    }

}
