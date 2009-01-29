/*
 * Copyright (c) 2008, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.ant;

import java.util.LinkedList;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.apache.tools.ant.TaskContainer;
import org.apache.tools.ant.UnknownElement;

public class CodegenFlowTask extends AbstractTemplateTask implements TaskContainer {

	private final LinkedList<Task> myTasks = new LinkedList<Task>();

	public CodegenFlowTask() {
	}

	public void addTask(Task task) {
		myTasks.add(task);
	}

	public void setOutputRoot(String outputRoot) {
	}

	@Override
	public void execute() throws BuildException {
		ProgressSupport ps = new ProgressSupport(this);
		ps.beginTask(getTaskName(), myTasks.size() + 2);
		XpandFacade xf = createFacade();
		for (Task t : myTasks) {
			if (t instanceof UnknownElement) {
				UnknownElement ue = (UnknownElement) t;
				if ("eclipse.org/gmf/2008/xpand".equals(ue.getNamespace()) && "template".equals(ue.getTag())) {
					t.maybeConfigure();
					if (((UnknownElement) t).getTask() != null) {
						t = ((UnknownElement) t).getTask();
					}
				}
			}
			if (t instanceof InvokeTemplateTask) {
				((InvokeTemplateTask) t).setFacade(xf);
				((InvokeTemplateTask) t).setTemplateTarget(getInput());
			}
		}
		ps.worked(2);
		try {
			ps.pushSubProgress(myTasks.size());
			for (Task t : myTasks) {
				t.perform();
			}
		} finally {
			ps.popSubProgress();
			ps.done();
		}
	}

}
