/*
 * Copyright (c) 2005, 2008 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 *     Artem Tikhomirov (Borland) - LPG migration
 */
package org.eclipse.gmf.internal.xpand.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.model.AnalysationIssue;
import org.eclipse.gmf.internal.xpand.util.ParserException.ErrorLocationInfo;

/**
 */
public class XpandMarkerManager {

	public static void addMarkers(final IFile file, AnalysationIssue... issues) {
		MarkerData[] data = new MarkerData[issues.length];
		int i = 0;
		for (AnalysationIssue issue : issues) {
			data[i++] = createMarkerData(issue);
		}
		internalAddMarker(file, data);
	}

	public static void addMarkers(IFile file, ErrorLocationInfo... issues) {
		MarkerData[] data = new MarkerData[issues.length];
		int i = 0;
		for (ErrorLocationInfo iss : issues) {
			data[i++] = new MarkerData(iss.message, IMarker.SEVERITY_ERROR, iss.startOffset, iss.endOffset, iss.startLine);
		}
		internalAddMarker(file, data);
	}

	public static void addErrorMarker(final IFile file, final String message, final int start, final int end) {
		internalAddMarker(file, new MarkerData(message, IMarker.SEVERITY_ERROR, start, end));
	}

	private static MarkerData createMarkerData(AnalysationIssue issue) {
		int start = -1, end = -1, line = -1;
		start = issue.getStart();
		end = issue.getEnd();
		line = issue.getLine();
		int severity = issue.isWarningNotError() ? IMarker.SEVERITY_WARNING : IMarker.SEVERITY_ERROR;
		return new MarkerData(issue.getMessage(), severity, start, end, line);
	}

	private static class MarkerData {
		final String message;
		final int severity;
		// zero-relative global file/buffer index, or -1
		final int start;
		final int end;
		final int line;

		MarkerData(String message, int severity, int start, int end) {
			this(message, severity, start, end, -1);
		}

		MarkerData(String message, int severity, int start, int end, int line) {
			this.message = message;
			this.severity = severity;
			this.start = start;
			this.end = end == -1 ? -1 : end + 1;
			this.line = line;
		}

		void createMarker(IFile file) throws CoreException {
			final IMarker marker = file.createMarker(getMARKER_TYPE());
            marker.setAttribute(IMarker.MESSAGE, message);
            marker.setAttribute(IMarker.SEVERITY, severity);
            marker.setAttribute(IMarker.LOCATION, toLocationString());
        	if (start != -1 && end != -1) {
        		// Could use MarkerUtilities#setCharStart(), etc.
        		// although MarkerUtilities takes texteditor dependency
        		marker.setAttribute(IMarker.CHAR_START, start);
        		marker.setAttribute(IMarker.CHAR_END, end);
        	}
            if (line != -1) {
            	marker.setAttribute(IMarker.LINE_NUMBER, line);
            }
		}

		private String toLocationString() {
			StringBuilder sb = new StringBuilder();
			if (line != -1) {
				sb.append("line: ");
				sb.append(line);
			}
			if (start != -1 && end != -1) {
				boolean theOnlyData = sb.length() == 0;
				if (!theOnlyData) {
					sb.append(" (");
				}
				sb.append(start);
				sb.append(" .. ");
				sb.append(end);
				if (!theOnlyData) {
					sb.append(")");
				}
			}
			return sb.toString();
		}
	}

	private static final String getMARKER_TYPE() {
		return Activator.getId() + ".xpandProblem";
	}

	private final static void internalAddMarker(final IFile file, final MarkerData... markerData) {
        try {
            file.getWorkspace().run(new IWorkspaceRunnable() {

            	public void run(IProgressMonitor monitor) throws CoreException {
					for (MarkerData d : markerData) {
						d.createMarker(file);
					}
                }
            }, file.getWorkspace().getRuleFactory().markerRule(file), 0, new NullProgressMonitor());
        } catch (final CoreException e) {
            Activator.log(e.getStatus());
        }
    }

	public static void deleteMarkers(final IResource file) {
		try {
			if (!file.exists()) {
				return;
			}
			file.getWorkspace().run(new IWorkspaceRunnable() {

				public void run(final IProgressMonitor monitor) throws CoreException {
					file.deleteMarkers(getMARKER_TYPE(), true, IResource.DEPTH_INFINITE);
				}

			}, file.getWorkspace().getRuleFactory().markerRule(file), 0, new NullProgressMonitor());
		} catch (CoreException ce) {
			Activator.log(ce.getStatus());
		}
	}
}
