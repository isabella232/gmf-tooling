/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.runtime.emf.type.core;

import org.eclipse.gmf.dev.EditPartTraceUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelper;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

/**
 * @author dstadnik
 */
public aspect ExtEditPartTracer {

	pointcut makingCommandInEditHelper(IEditHelper editHelper, IEditCommandRequest request) : execution(ICommand IEditHelper.getEditCommand(IEditCommandRequest)) && target(editHelper) && args(request);

	ICommand around(IEditHelper editHelper, IEditCommandRequest request) : makingCommandInEditHelper(editHelper, request) {
		ICommand command = proceed(editHelper, request);
		if (command != null) {
			EditPartTraceUtil.addSource(command, editHelper);
		}
		return command;
	}

	pointcut makingCommandInEditHelperAdvice(IEditHelperAdvice advice, IEditCommandRequest request) : (execution(ICommand IEditHelperAdvice.getBeforeEditCommand(IEditCommandRequest)) || execution(ICommand IEditHelperAdvice.getAfterEditCommand(IEditCommandRequest))) && target(advice) && args(request);

	ICommand around(IEditHelperAdvice advice, IEditCommandRequest request) : makingCommandInEditHelperAdvice(advice, request) {
		ICommand command = proceed(advice, request);
		if (command != null) {
			EditPartTraceUtil.addSource(command, advice);
		}
		return command;
	}
}
