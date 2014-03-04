package org.eclipse.gmf.codegen.xtend.ui.handlers;

import java.util.List;

import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.util.CodegenEmitters;
import org.eclipse.gmf.codegen.util.ExtensionTemplatesProviderImpl;
import org.eclipse.gmf.codegen.util.GMFGeneratorModule;
import org.eclipse.gmf.codegen.util.IExtensionTemplatesProvider;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.JavaClassEmitter;

import com.google.inject.Guice;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class CodegenEmittersWithXtend2 extends CodegenEmitters {

	private final Injector myInjector;

	private IExtensionTemplatesProvider myExtensionTemplateProvider = null;

	public CodegenEmittersWithXtend2(GenEditorGenerator genModel) {
		this(!genModel.isDynamicTemplates(), genModel.getTemplateDirectory(), genModel.getModelAccess() != null);
	}

	public CodegenEmittersWithXtend2(boolean useBaseTemplatesOnly, String templateDirectory, boolean includeDynamicModelTemplates) {
		super(useBaseTemplatesOnly, templateDirectory, includeDynamicModelTemplates);
		if (templateDirectory != null && !templateDirectory.isEmpty()) {
			myExtensionTemplateProvider = new ExtensionTemplatesProviderImpl(templateDirectory,!useBaseTemplatesOnly);
		}
		myInjector = Guice.createInjector(new GMFGeneratorModule(myExtensionTemplateProvider));
	}

	//-----------------------------------------------------------------------------------------

	/**
	 * FIXME: [MG] make separate xtend templates calling shared code, not vise versa
	 */
	@Override
	public JavaClassEmitter getTextNonResizableEditPolicyEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("xpt::diagram::editpolicies::TextNonResizableEditPolicy", "TextNonResizableEditPolicy"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * FIXME: [MG] make separate xtend templates calling shared code, not vise versa
	 */
	@Override
	public JavaClassEmitter getTextSelectionEditPolicyEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("xpt::diagram::editpolicies::TextSelectionEditPolicy", "TextSelectionEditPolicy"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	@Override
	public JavaClassEmitter getPropertySheetLabelProviderEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("xpt::propsheet::LabelProvider", "LabelProvider"); //$NON-NLS-1$
	}
	
	@Override
	public JavaClassEmitter getPropertySectionEmitter() throws UnexpectedBehaviourException {
		return  getXtendEmitter("xpt::propsheet::PropertySection", "PropertySection"); //$NON-NLS-1$
	}
	
	private JavaClassEmitter getXtendEmitter(String templateFqn, String mainMethod) {
		String classFqn = templateFqn.replace("::", ".");
		Class<?> clazz = null;
		try {
			clazz = Class.forName(classFqn);
		} catch (ClassNotFoundException e) {
			if (myExtensionTemplateProvider != null) {
				List<Class<?>> customClasses = myExtensionTemplateProvider.getCustomTemplateClasses();
				for (Class<?> _class : customClasses) {
					String name = _class.getName();
					if (name.equals(classFqn)) {
						clazz = _class;
						break;
					}
				}
			}
			if (clazz == null) {
				throw new IllegalStateException("Can't load: " + classFqn, e);
			}
		}
		return new Xtend2ClassEmitter(myInjector, clazz, mainMethod);
	}

	public void disposeEmitters() {
		if (myExtensionTemplateProvider != null) {
			myExtensionTemplateProvider.dispose();
		}
	}
	
	@Override
	protected JavaClassEmitter createJavaClassEmitter(String templateName, String mainMethod) {
		return getXtendEmitter(templateName, mainMethod);
	}
}
