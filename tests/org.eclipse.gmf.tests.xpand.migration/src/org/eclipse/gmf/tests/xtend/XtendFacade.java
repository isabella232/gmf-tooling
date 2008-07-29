/*******************************************************************************
 * Copyright (c) 2005, 2006 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *******************************************************************************/
package org.eclipse.gmf.tests.xtend;

import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.BuiltinMetaModel;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.expression.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.xtend.ast.Extension;

/**
 * Might migrate into core plug-in if needed.
 *
 */
public class XtendFacade {

    private ExecutionContext ctx;

    public XtendFacade(final ExecutionContext ctx) {
        this.ctx = ctx;
    }

    public final static XtendFacade create(ResourceManager resourceManager, final String extFile) {
		return new XtendFacade(new ExecutionContextImpl(resourceManager, resourceManager.loadXtendResource(extFile), null, null));
    }

    public Object call(final String ext, final Object[] params) {
        final Extension extension = ctx.getExtension(ext, detectTypes(params));
        if (extension == null) {
			throw new IllegalArgumentException("Couldn't find extension " + ext);
		}
        return extension.evaluate(params, ctx);
    }

    private EClassifier[] detectTypes(Object[] objects) {
		final EClassifier[] rv = new EClassifier[objects.length];
		for (int i = 0; i < objects.length; i++) {
			rv[i] = BuiltinMetaModel.getType(objects[i]);
		}
		return rv;
	}

    public Object call(final String ext) {
        return call(ext, new Object[]{});
    }

    public Object call(final String ext, Object p1) {
        return call(ext, new Object[]{p1});
    }

    public Object call(final String ext, Object p1, Object p2) {
        return call(ext, new Object[]{p1, p2});
    }

    public Object call(final String ext, Object p1, Object p2, Object p3) {
        return call(ext, new Object[]{p1, p2, p3});
    }

    public EClassifier analyze(final String string, Object[] objects, final Set<AnalysationIssue> issues) {
        if (objects == null) {
            objects = new Object[0];
        }
        final EClassifier[] params = detectTypes(objects);
		final Extension extension = ctx.getExtension(string, params);
        return extension.getReturnType(params, ctx, issues);
    }
}
