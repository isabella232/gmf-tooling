/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests;

import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

/**
 * Utility that checks various assumptions on the generated code. Currently, only the correct placement of <code>&#64;generated</code> tags is checked.
 */
public class JDTUtil {
	private final IJavaProject myJavaProject;
	private ViolationAggregator myAggregator;

	private static interface IMemberProcessor {
		public IStatus processMember(IMember member, boolean isLocalMember) throws JavaModelException;
	}

	private static class ViolationAggregator {
		private MultiStatus myStatus = new MultiStatus(Plugin.getPluginID(), 0, "JDT Violations", null);

		public void add(IStatus status) {
			myStatus.merge(status);
		}

		public IStatus getStatus() {
			if (myStatus.isOK()) {
				return Status.OK_STATUS;
			}
			StringBuffer buffer = new StringBuffer();
			IStatus[] children = myStatus.getChildren();
			for(int i = 0; i < children.length; i++) {
				if (children[i].matches(myStatus.getSeverity())) {
					buffer.append(children[i].getMessage()).append("\n");
				}
			}
			return new Status(myStatus.getSeverity(), Plugin.getPluginID(), 0, buffer.toString(), null);
		}
	}

	public JDTUtil(IJavaProject javaProject) {
		myJavaProject = javaProject;
	}

	public JDTUtil(IProject p) {
		this(JavaCore.create(p));
	}

	public IStatus collectProblems() {
		return collectProblems(new IMemberProcessor[] {new GeneratedTagEnsurer(), new GeneratedTagAbsenceInLocalMembersEnsurer()});
	}

	private IStatus collectProblems(IMemberProcessor[] processors) {
		if (myAggregator == null) {
			myAggregator = new ViolationAggregator();
			collectProblems(myJavaProject, processors);
		}
		return myAggregator.getStatus();
	}

	private void collectProblems(IJavaElement jElement, IMemberProcessor[] processors) {
		try {
			switch (jElement.getElementType()) {
			case IJavaElement.JAVA_PROJECT:
				{
					IJavaProject jProject = (IJavaProject) jElement;
					IPackageFragmentRoot[] roots = jProject.getPackageFragmentRoots();
					for(int i = 0; i < roots.length; i++) {
						if (roots[i].getKind() == IPackageFragmentRoot.K_SOURCE) {
							collectProblems(roots[i], processors);
						}
					}
				}
				break;
			case IJavaElement.PACKAGE_FRAGMENT_ROOT:
				{
					IPackageFragmentRoot root = (IPackageFragmentRoot) jElement;
					IJavaElement[] children = root.getChildren();
					for(int i = 0; i < children.length; i++) {
						collectProblems(children[i], processors);
					}
				}
				break;
			case IJavaElement.PACKAGE_FRAGMENT:
				{
					IPackageFragment pf = (IPackageFragment) jElement;
					ICompilationUnit[] compilationUnits = pf.getCompilationUnits();
					for(int i = 0; i < compilationUnits.length; i++) {
						collectProblems(compilationUnits[i], processors);
					}
				}
				break;
			case IJavaElement.COMPILATION_UNIT:
				{
					ICompilationUnit compilationUnit = (ICompilationUnit) jElement;
					IType[] types = compilationUnit.getTypes();
					for(int i = 0; i < types.length; i++) {
						collectProblems(types[i], processors);
					}
				}
				break;
			case IJavaElement.TYPE:
				{
					IMember member = (IMember) jElement;
					collectProblems(member, processors, false);
				}
				break;
			}
		} catch (JavaModelException e) {
			myAggregator.add(e.getStatus());
		}
	}

	private void collectProblems(IMember member, IMemberProcessor[] processors, boolean isLocalMember) throws JavaModelException {
		for (int i = 0; i < processors.length; i++) {
			IStatus status = processors[i].processMember(member, isLocalMember);
			if (status != null && !status.isOK()) {
				myAggregator.add(status);
			}
		}
		isLocalMember |= !(member instanceof IType);
		IJavaElement[] children = member.getChildren();
		for(int i = 0; i < children.length; i++) {
			collectProblems((IMember) children[i], processors, isLocalMember);
		}
	}

	private abstract static class JavadocMemberProcessor implements IMemberProcessor {
		protected static final String GENERATED = "@generated";	//$NON-NLS-1$
		protected final String getJavadoc(IMember member) throws JavaModelException {
			ISourceRange javadocRange = member.getJavadocRange();
			if (javadocRange == null) {
				return "";	//$NON-NLS-1$
			}
			return member.getCompilationUnit().getSource().substring(javadocRange.getOffset(), javadocRange.getLength() + javadocRange.getOffset());
		}
	}

	public static class GeneratedTagEnsurer extends JavadocMemberProcessor {
		public IStatus processMember(IMember member, boolean isLocalMember) throws JavaModelException {
			if (isLocalMember) {
				return null;
			}
			if (member.getElementType() == IJavaElement.INITIALIZER && member.getOccurrenceCount() > 1) {
				return newViolation(member, "Multiple sibling initializers should be avoided in the generated code: they may not always be merged correctly");
			}
			String javadoc = getJavadoc(member);
			int index = javadoc.lastIndexOf(GENERATED);
			if (index == -1) {
				return newViolation(member, "@generated is missing");
			}
			if (javadoc.indexOf(GENERATED) != index) {
				return newViolation(member, "There is more than one @generated tag");
			}
			String afterGenerated = javadoc.substring(index + GENERATED.length()).trim();
			String asteriskIgnored = afterGenerated.replace('*', ' ').trim();
			if (asteriskIgnored.length() == 0) {
				return newViolation(member, "JavaDoc comment with @generated tag is not terminated properly");
			}
			switch (asteriskIgnored.charAt(0)) {
			case '@':
				//Next tag starts here, thus @generated is OK
				break;
			case '/':
				//Most likely, this is an end of a JavaDoc comment terminator.
				//TODO: check this assumption using the content of afterGenerated
				break;
			default:
				return newViolation(member, "@generated tag will be interpreted as @generated NOT");
			}
			return null;
		}
	}

	private static class GeneratedTagAbsenceInLocalMembersEnsurer extends JavadocMemberProcessor {
		public IStatus processMember(IMember member, boolean isLocalMember) throws JavaModelException {
			if (!isLocalMember) {
				return null;
			}
			String javadoc = getJavadoc(member);
			if (javadoc.indexOf(GENERATED) != -1) {
				return newViolation(member, "@generated tag in local members is misleading");
			}
			return null;
		}
	}

	private static IStatus newViolation(IMember member, String description) {
		return new Status(IStatus.ERROR, Plugin.getPluginID(), 0, MessageFormat.format("{0} has problem: {1}", member.getHandleIdentifier(), description), null);
	}
}
