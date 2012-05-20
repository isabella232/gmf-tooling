/*
 * Copyright (c) 2006, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.gmf.internal.xpand;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.internal.xpand.RootManager.RootDescription;
import org.eclipse.gmf.internal.xpand.build.MetaModelSource;
import org.eclipse.gmf.internal.xpand.build.WorkspaceResourceManager;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	private static Activator anInstance;

	public Activator() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		anInstance = this;
		ResourcesPlugin.getWorkspace().addResourceChangeListener(myRootsTracker);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(myRootsTracker);
		anInstance = null;
		super.stop(context);
	}

	public static String getId() {
		return anInstance == null ? String.valueOf(anInstance) : anInstance.getBundle().getSymbolicName();
	}

	public static void logWarn(String message) {
		log(new Status(IStatus.WARNING, getId(), 0, message, null));
	}

	public static void logError(Exception e) {
		if (e instanceof CoreException) {
			log(((CoreException) e).getStatus());
		} else {
			log(new Status(IStatus.ERROR, getId(), 0, e.getMessage(), e));
		}
	}

	public static void log(IStatus status) {
		if (anInstance != null) {
			anInstance.getLog().log(status);
		} else {
			System.err.println(status);
		}
	}

	private final Map<IProject, RootManager> rootManagers = new HashMap<IProject, RootManager>();

	public static RootManager getRootManager(IProject project) {
		synchronized (anInstance.myRootsTracker) {
			RootManager result = anInstance.rootManagers.get(project);
			if (result == null) {
				result = new RootManager(project);
				anInstance.rootManagers.put(project, result);
			}
			return result;
		}
	}

	public static WorkspaceResourceManager createWorkspaceResourceManager(IProject project, RootDescription rootDescription) {
		return rootDescription != null ? new WorkspaceResourceManager(project, rootDescription.getRoots().toArray(new IPath[rootDescription.getRoots().size()]))
				: new WorkspaceResourceManager(project);
	}

	private final IResourceChangeListener myRootsTracker = new IResourceChangeListener() {

		public synchronized void resourceChanged(IResourceChangeEvent event) {
			if (event == null || event.getDelta() == null) {
				return;
			}
			Set<RootManager> affectedRootManagers = new HashSet<RootManager>();
			IResourceDelta rootDelta = event.getDelta();
			for (IResourceDelta projectDelta : rootDelta.getAffectedChildren()) {
				IProject affectedProject = (IProject) projectDelta.getResource();
				if (isRemovedOrClosed(projectDelta)) {
					rootManagers.remove(affectedProject);
				} else {
					IResourceDelta configFileDelta = projectDelta.findMember(RootManager.PROJECT_RELATIVE_PATH_TO_CONFIG_FILE);
					if (configFileDelta != null && rootManagers.containsKey(affectedProject) && affectsConfigFile(configFileDelta)) {
						affectedRootManagers.add(getRootManager(affectedProject));
					}
				}
			}
			//Opening/closing or creating/deleting a project may affect roots with absolute paths.
			for (IResourceDelta projectDelta : rootDelta.getAffectedChildren()) {
				if (mayAffectOtherResourceManagers(projectDelta)) {
					IPath projectPath = projectDelta.getFullPath();
					for (RootManager nextManager : rootManagers.values()) {
						if (nextManager.containsProject(projectPath)) {
							affectedRootManagers.add(nextManager);
						}
					}
				}
			}
			for (RootManager nextManager : affectedRootManagers) {
				nextManager.rootsChanged();
			}
		}

		private boolean affectsConfigFile(IResourceDelta configFileDelta) {
			if ((configFileDelta.getKind() & (IResourceDelta.ADDED | IResourceDelta.REMOVED)) > 0) {
				return true;
			}
			if ((configFileDelta.getFlags() & (IResourceDelta.CONTENT | IResourceDelta.ENCODING | IResourceDelta.SYNC | IResourceDelta.TYPE | IResourceDelta.REPLACED)) > 0) {
				return true;
			}
			return false;
		}

		private boolean isRemovedOrClosed(IResourceDelta projectDelta) {
			if (projectDelta.getKind() == IResourceDelta.REMOVED) {
				return true;
			}
			if ((projectDelta.getFlags() & IResourceDelta.OPEN) > 0) {
				return !projectDelta.getResource().isAccessible();
			}
			return false;
		}

		private boolean mayAffectOtherResourceManagers(IResourceDelta projectDelta) {
			if ((projectDelta.getKind() & (IResourceDelta.REMOVED | IResourceDelta.ADDED)) > 0) {
				return true;
			}
			if ((projectDelta.getFlags() & IResourceDelta.OPEN) > 0) {
				return !projectDelta.getResource().isAccessible();
			}
			return false;
		}
	};

	private final Set<MetaModelSource> modelSources = new LinkedHashSet<MetaModelSource>();

	public static void registerModelSource(MetaModelSource modelSource) {
		assert modelSource != null;
		anInstance.modelSources.add(modelSource);
	}

	public static EPackage findMetaModel(String nsURI) {
		if (anInstance == null) {
			// this is for tests execution (which doesn't take place in plugin env)
			return null;
		}
		for (MetaModelSource s : anInstance.modelSources) {
			EPackage p = s.find(nsURI);
			if (p != null) {
				return p;
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(nsURI);
	}

	/**
	 * {@link EcorePlugin#computePlatformURIMap()} analog for GMF Xpand templates.
	 * Fills supplied registry with metamodels available in the workspace, accessible both with platform:/resource/ and nsURI.
	 * 
	 * <p>For mymodel.ecore file in the workspace (which defines mymodelpackage EPackage) this method produces a map with two entries:<ul>
	 * <li> nsURI -> mymodelpackage
	 * <li> platform:/resource/.../mymodel.ecore -> mymodelpackage 
	 * </ul>
	 * 
	 * <p>Clients that expect their templates to work with workspace (dynamic) model instances/metamodels shall make entries of the registry available in 
	 * {@link ResourceSet} they use to load EMF object(s) they pass as template input, like that:
	 * <pre><code>
	 *   ResourceSet rs = new ResourceSetImpl();
	 *   Activator.fillWorkspaceMetaModelsMap(rs.getPackageRegistry());
	 * </code></pre>
	 * alternately, you may supply you own PackageRegistry implementation, like:
	 * <pre><code>
	 *   EPackage.Registry registry = new EPackageRegistryImpl(EPackage.Registry.INSTANCE) { ... };
	 *   rs.setPackageRegistry(Activator.fillWorkspaceMetaModelsMap(registry));
	 * </code></pre>
	 * With these precautions, loaded dynamic instances would result having the same metamodel, as available by nsURI, i.e.
	 * <pre><code>
	 *   EObject dynamicInstance = rs.getResource(URI.createURI("platform:/resource/.../mymodelinstance.xmi"), true).getContents().get(0);
	 *   EPackage packageByNamespaceURI = rs.getPackageRegistry().getEPackage("mymodelpackage.nsURI");
	 *   assert dynamicInstance.eClass().getEPackage() == packageByNamespaceURI;
	 * </code></pre>
	 * 
	 * <p>Filled map represents a snapshot, and is not updated on subsequent workspace changes. 
	 * 
	 * @param registry - map to fill with platform:/resource/... and nsURI entries for workspace metamodels
	 * @return passed argument for convenience
	 */
	public static EPackage.Registry fillWorkspaceMetaModelsMap(EPackage.Registry registry) {
		if (anInstance == null) {
			return registry;
		}
		for (MetaModelSource s : anInstance.modelSources) {
			for (EPackage p : s.all()) {
				if (p.eResource() != null && p.eResource().getURI() != null && p.eResource().getURI().isPlatformResource()) {
					registry.put(p.getNsURI(), p);
					registry.put(p.eResource().getURI().toString(), p);
				}
			}
		}
		return registry;
	}

	private ResourceSet workspaceMetamodelRS;

	public static ResourceSet getWorkspaceMetamodelsResourceSet() {
		if (anInstance != null && anInstance.workspaceMetamodelRS != null) {
			return anInstance.workspaceMetamodelRS;
		}
		final ResourceSetImpl resourceSetImpl = new ResourceSetImpl() // 
//		{
//
//			@Override
//			public String toString() {
//				return "Activator.getWorkspaceMetamodelsResourceSet(): " + super.toString();
//			}
//
//			@Override
//			public Resource getResource(URI uri, boolean loadOnDemand) {
//				int sizeBefore = getResources().size();
//				Resource result = super.getResource(uri, loadOnDemand);
//				if (sizeBefore < getResources().size()) {
//					logWarn("Activator.getWorkspaceMetamodelsResourceSet().: was: " + sizeBefore + //
//							",\n now: " + getResources().size() + //
//							",\n requested uri: " + uri + //
//							",\n loaded: " + result + //
//							",\n size: " + (result == null ? "null" : result.getContents().size()));
//					if (!result.getContents().isEmpty()) {
//						EObject first = result.getContents().get(0);
//						if (first instanceof EPackage) {
//							EPackage firstEPackage = (EPackage) first;
//							logWarn("loaded: package:" + first + //
//									",\n nsUri: " + firstEPackage.getNsURI() + //
//									",\n identityHashCode: " + System.identityHashCode(firstEPackage));
//						} else {
//							logWarn("loaded: NOT a package:" + first);
//						}
//					}
//				}
//				return result;
//			}
//		}
		;
		resourceSetImpl.setURIResourceMap(new EPackageRegistryBasedURIResourceMap(resourceSetImpl.getURIConverter()));
		// TODO: EcorePlugin.computePlatformURIMap() can return different maps
		// if some of the project were opened/closed, so it is necessary to
		// either update it or not keep any shared resourceSet for meta-models.
		// In case of second solution we can better keep meta-model URIs and
		// pre-load all necessary meta-models into the newly created ResourceSet
		// just before Xpand execution (build or evaluation). 
		resourceSetImpl.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
		if (anInstance != null) {
			anInstance.workspaceMetamodelRS = resourceSetImpl;
		}
		return resourceSetImpl;
	}
}
