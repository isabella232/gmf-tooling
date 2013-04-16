package org.eclipse.gmf.map.edit.ocl.editor;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.map.edit.ocl.OCLActivator;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerListener;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.essentialocl.EssentialOCLStandaloneSetup;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseDocument;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class OCLEmbeddedEditor implements MetaModelManagerListener {

	private EmbeddedEditor handle;
	private MetaModelManager nullMetaModelManager = null;

	public OCLEmbeddedEditor(Composite parent) {
		create(parent);	
	}

	private void create(Composite parent) {
		IEditedResourceProvider resourceProvider = new IEditedResourceProvider() {
			@Override public XtextResource createResource() {
				EssentialOCLStandaloneSetup.doSetup();

				ResourceSet resourceSet = new ResourceSetImpl();
				Resource resource = resourceSet.createResource(URI.createURI("embedded.essentialocl"));

				return (XtextResource) resource;
			}
		};

		OCLActivator activator = OCLActivator.getInstance();
		Injector injector = activator.getInjector(EssentialOCLPlugin.LANGUAGE_ID);

		EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);
		handle = factory
				.newEditor(resourceProvider)
				.showErrorAndWarningAnnotations()
				.withParent(parent);
		handle.createPartialEditor();

		handle.getViewer().addTextInputListener(new ITextInputListener() {
			@Override
			public void inputDocumentChanged(final IDocument oldInput, final IDocument newInput) {}
			@Override
			public void inputDocumentAboutToBeChanged(final IDocument oldInput, final IDocument newInput) {}
		});
	}

	public void setContext(final EClassifier context, final Map<String, EClassifier> parameters) {
		if (handle != null) {
			final XtextDocument document = handle.getDocument();
			if (document instanceof BaseDocument) {
				((BaseDocument) document).modify(new IUnitOfWork<Object, XtextResource>() {
					@Override
					public Object exec(XtextResource state) throws Exception {
						((BaseDocument) document).setContext(context, parameters);
						state.reparse(document.get());
						return null;
					}
				});
			}
		}
	}

	@Override
	public void metaModelManagerDisposed(@NonNull MetaModelManager metaModelManager) {
		metaModelManager.removeListener(this);
	}

	private @NonNull MetaModelManager getMetaModelManager(@Nullable EObject contextObject) {
		MetaModelManager metaModelManager = contextObject != null ? PivotUtil.findMetaModelManager(contextObject) : null;
		if (metaModelManager != null) {
			return metaModelManager;
		}
		MetaModelManager nullMetaModelManager2 = nullMetaModelManager;
		if (nullMetaModelManager2 == null) {
			nullMetaModelManager2 = nullMetaModelManager = new MetaModelManager();
			nullMetaModelManager2.addListener(this);
		}
		return nullMetaModelManager2;
	}

	public String getValue() {
		if (handle != null) {
			return handle.getDocument().get();
		} else {
			return null;
		}
	}

}
