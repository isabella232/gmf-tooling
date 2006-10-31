/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: dvorak - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.popup.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.gmf.internal.codegen.CodeGenUIPlugin;

/**
 * Provides various functinality useful for model validation, for instances
 * progress monitoring, resource markers creation.
 */
public class ValidationHelper {

	/**
	 * Enhanced diagnostician class supporting progress monitoring and object labels. 
	 */
	private static class SmartDiagnostician extends Diagnostician {
		
		private static ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		
		private IProgressMonitor monitor;

		/**
		 * Constructs diagnostician with progress monitor.
		 * 
		 * @param progressMonitor non-null progress monitor to track validation progress
		 */
		SmartDiagnostician(IProgressMonitor progressMonitor) {
			this.monitor = progressMonitor;
		}
		
		/*
		 * Utilizes the adapter factory registry to provide labels. 
		 */
		@Override		
		public String getObjectLabel(EObject eObject) {
			if(eObject != null) {
				IItemLabelProvider itemLabelProvider = (IItemLabelProvider)adapterFactory.adapt(eObject, IItemLabelProvider.class);
				if (itemLabelProvider != null) {
					return itemLabelProvider.getText(eObject);
				}	
			} else {
				return ""; //$NON-NLS-1$
			}
			return super.getObjectLabel(eObject);
		}

		/*
		 * Notifies the monitor about the unit of work done.
		 */
		@Override
        public boolean validate(EClass eClass, EObject eObject, DiagnosticChain diagnostics, Map context)
        {
          monitor.worked(1);
          return super.validate(eClass, eObject, diagnostics, context);
        }
	}	
		
	/**
	 * Helper class for binding validation diagnostics to corresponding problem markers.
	 */
	private static class GMFMarkerHelper extends EditUIMarkerHelper {
		
		private LinkedHashMap<Diagnostic, IMarker> diagnostic2Marker;
		
		GMFMarkerHelper() {
			super();
		}
		
		public IFile getFileFromDiagnostic(Diagnostic diagnostic) {
			return getFile(diagnostic);
		}
		
		@Override
		protected void adjustMarker(IMarker marker, Diagnostic diagnostic, Diagnostic parentDiagnostic) throws CoreException {
			getDiagnostic2MarkerMap().put(diagnostic, marker);

			// adjust marker to support IGotoMarker for standard EMF generated editors 
			List data = diagnostic.getData();
			if (!data.isEmpty()) {
				Object target = data.get(0);
				if (target instanceof EObject) {
					marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI((EObject) target).toString());
				}
			}

			super.adjustMarker(marker, diagnostic, parentDiagnostic);
		}
				
		@Override
		protected IFile getFile(Object datum) {
			if (datum instanceof EObject) {
				EObject eObject = (EObject) datum;
				if(eObject.eResource() != null) {
					URI uri = eObject.eResource().getURI();
					IFile file = getFile(uri);
					if(file != null) {
						return file;
					}
				}
			}
			return super.getFile(datum);
		}
		
		
		
		@Override
		protected String getMarkerID() {		
			return EValidator.MARKER;
		}

		LinkedHashMap<Diagnostic, IMarker> getDiagnostic2MarkerMap() {
			if(diagnostic2Marker == null) {
				diagnostic2Marker = new LinkedHashMap<Diagnostic, IMarker>();
			}
			return diagnostic2Marker;
		}		
	}	
		
	/**
	 * Diagnostic to marker map data holder class.
	 * <p>
	 * Note: The map iterators respect the order of marker creation.
	 */
	public static class DiagnosticMarkerMap {
		private Map<Diagnostic, IMarker> map;
		
		/**
		 * Constraint diagnostic marker from the given map data.
		 * @param markerMap map data to be encapsulated by the resulting object.
		 */
		DiagnosticMarkerMap(LinkedHashMap<Diagnostic, IMarker> markerMap) {
			this.map = Collections.unmodifiableMap(markerMap);
		}
						
		/**
		 * Gets the map data for this diagnostic marker map.
		 * @return read-only map object
		 */
		public Map<Diagnostic, IMarker> getMap() {
			return map;
		}
	}	
	
	/**
	 * No instances, just an utility class.
	 */
	private ValidationHelper() {
		super();
	}
	
	
	/**
	 * Indicates whether the severiti of the given diagnostic matches the given 
	 * bitmask.
	 * @param diagnostic a diagnostic to test for severity match
	 * @param severityBitMask a mask formed by bitwise or'ing severity mask constants
	 * 	(<code>ERROR</code>, <code>WARNING</code>, <code>INFO</code>, <code>CANCEL</code>)
	 * 
	 * @return <code>true</code> if there is at least one match, <code>false</code> otherwise
	 * 
	 * @see Diagnostic#ERROR
	 * @see Diagnostic#WARNING
	 * @see Diagnostic#INFO
	 * @see Diagnostic#CANCEL   
	 */
    public static boolean matches(Diagnostic diagnostic, int severityBitMask) {
    	return (diagnostic.getSeverity() & severityBitMask) != 0;
    }	

    /**
	 * Validates the given <code>EObject</code> and its all contents.
	 * <p>
	 * If the EMF basic validation results in <code>Diagnostic.CANCEL</code>
	 * severity, no problem markers are created at all.
	 * 
	 * The problem markers created by this operation are added as extra-data to
	 * the returned diagnostic and are accessible via
	 * {@link #getDiagnosticMarkerMap(Diagnostic)}.
	 * 
	 * @param createMarkers
	 *            if <code>true</code> this operation produces validation
	 *            problems markers provided that eObject.eResource() represents
	 *            a file existing in the workspace. If <code>true</code> no
	 *            attempt to create markers is performed.
	 * 
	 * @param progressMonitor
	 *            the progress monitor to track validation progress, or
	 *            <code>null</code> if no progress monitoring is required
	 * 
	 * @return the validation result diagnostic
	 */
	public static Diagnostic validate(EObject eObject, boolean createMarkers, IProgressMonitor progressMonitor) {		
		IProgressMonitor monitor = (progressMonitor != null) ? progressMonitor : new NullProgressMonitor(); 
		try {
			int count = 0;
			for (Iterator i = eObject.eAllContents(); i.hasNext(); i.next()) {
				++count;
			}

		    monitor.beginTask("", count); //$NON-NLS-1$
		    
			Diagnostic validationStatus = new SmartDiagnostician(monitor).validate(eObject);
			if(validationStatus.getSeverity() == Diagnostic.CANCEL) {
				return validationStatus;
			}
				
			List<Object> data = validationStatus.getData();
			if(createMarkers) {
				DiagnosticMarkerMap markerMap = createMarkers(validationStatus);			
				data = new ArrayList<Object>(data.size() + 1);
				data.add(markerMap);
			}
			
			BasicDiagnostic result = new BasicDiagnostic(
					validationStatus.getSource(), validationStatus.getCode(),
					validationStatus.getMessage(), data.toArray());
	
			result.addAll(validationStatus);
			return result;
			
		} finally {
			monitor.done();
		} 
	}
	
    /**
	 * Validates the given <code>EObject</code> and its all contents.
	 * <p>
	 * This method is progress monitoring ignorant shorthand of {@link #validate(EObject, boolean, IProgressMonitor)}
	 * 
	 * @param createMarkers
	 *            if <code>true</code> this operation produces validation
	 *            problems markers provided that eObject.eResource() represents
	 *            a file existing in the workspace. If <code>true</code> no
	 *            attempt to create markers is performed.
	 * 
	 * @return the validation result diagnostic
	 * 
	 * @see #validate(EObject, boolean, IProgressMonitor)
	 */	
	public static Diagnostic validate(EObject eObject, boolean createMarkers) {
		return validate(eObject, createMarkers, null);
	}
	
	/**
	 * Gets the diagnostic marker map associated with the given validation
	 * diagnostic.
	 * 
	 * @param diagnostic
	 *            a non-null validation diagnostic which resulted from calling
	 *            {@link #validate(EObject, boolean, IProgressMonitor)}}
	 * 
	 * @see #validate(EObject, boolean, IProgressMonitor)
	 */
	public static DiagnosticMarkerMap getDiagnosticMarkerMap(Diagnostic diagnostic) {
		for (Iterator it = diagnostic.getData().iterator(); it.hasNext();) {
			Object dataItem = it.next();
			if (dataItem instanceof DiagnosticMarkerMap) {
				return (DiagnosticMarkerMap) dataItem;
			}			
		}
		return null;
	}

	/**
	 * Extracts the file of the validated model instance referenced by the given
	 * diagnostic.
	 * 
	 * @param diagnostic
	 *            a non-null validation diagnostic
	 * @return the file object or <code>null</code> in case the resource
	 *         associated with the validated object does not represents a file
	 *         existing in the workspace.
	 */
	public static IFile getFileFromDiagnostic(Diagnostic diagnostic) {
		return new GMFMarkerHelper().getFileFromDiagnostic(diagnostic);
	}
	
	public static DiagnosticMarkerMap createMarkers(Diagnostic diagnostic) {
		GMFMarkerHelper markerHelper = new GMFMarkerHelper();
		try {
			markerHelper.deleteMarkers(diagnostic, true, IResource.DEPTH_ZERO);
			markerHelper.createMarkers(diagnostic);
		} catch (CoreException e) {
			IStatus status = new Status(IStatus.ERROR, CodeGenUIPlugin.getPluginID(), 0, "Marker creation failure", e); //$NON-NLS-1$ 
			CodeGenUIPlugin.getDefault().getLog().log(status);
		}
		return new DiagnosticMarkerMap(markerHelper.getDiagnostic2MarkerMap());
	}	
}