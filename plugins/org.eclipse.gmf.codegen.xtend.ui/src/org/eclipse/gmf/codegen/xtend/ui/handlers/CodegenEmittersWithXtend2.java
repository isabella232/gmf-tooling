package org.eclipse.gmf.codegen.xtend.ui.handlers;

import org.eclipse.gmf.codegen.util.CodegenEmitters;
import org.eclipse.gmf.codegen.util.GMFGeneratorModule;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.TextEmitter;

import com.google.inject.Guice;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class CodegenEmittersWithXtend2 extends CodegenEmitters {

	private final Injector myInjector;

	public CodegenEmittersWithXtend2(boolean useBaseTemplatesOnly, String templateDirectory, boolean includeDynamicModelTemplates) {
		super(useBaseTemplatesOnly, templateDirectory, includeDynamicModelTemplates);
		myInjector = Guice.createInjector(new GMFGeneratorModule());
	}

	@Override
	public TextEmitter getEditPartFactoryEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::editparts::EditPartFactory"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getBaseEditHelperEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::edithelpers::BaseEditHelper"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getEditHelperAdviceEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::edithelpers::EditHelperAdvice"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getEditHelperEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::edithelpers::EditHelper"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getReorientLinkViewCommandEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::commands::ReorientLinkViewCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCreateShortcutDecorationsCommandEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::commands::CreateShortcutDecorationsCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getReorientRefLinkCommandEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::commands::ReorientRefLinkCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getReorientLinkCommandEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::commands::ReorientLinkCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCreateLinkCommandEmitter() throws UnexpectedBehaviourException {
		return getXtendEmitter("xpt::diagram::commands::CreateLinkCommand::Main"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCreateNodeCommandEmitter() throws UnexpectedBehaviourException {
		return getPrimaryXtendEmitter("xpt::diagram::commands::CreateNodeCommand"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCustomActionEmitter() {
		return getXtendEmitter("impl::actions::CustomAction::Main"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNodeItemSemanticEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::NodeItemSemanticEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getBaseItemSemanticEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::BaseItemSemanticEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getLinkItemSemanticEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::LinkItemSemanticEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCompartmentItemSemanticEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::CompartmentItemSemanticEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDiagramItemSemanticEditPolicyEmitter() {
		return getPrimaryXtendEmitter("xpt::diagram::editpolicies::DiagramItemSemanticEditPolicy"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNodeEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::NodeEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getCompartmentEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::CompartmentEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getChildNodeLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::ChildNodeLabelEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getDiagramEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::DiagramEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getExternalNodeLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::ExternalNodeLabelEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getLinkEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::LinkEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getLinkLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::LinkLabelEditPart"); //$NON-NLS-1$
	}

	@Override
	public TextEmitter getNodeLabelEditPartEmitter() throws UnexpectedBehaviourException {
		return getMainXtendEmitter("diagram::editparts::NodeLabelEditPart"); //$NON-NLS-1$
	}

	private TextEmitter getMainXtendEmitter(String templateFilePath) {
		return getXtendEmitter(templateFilePath + PATH_SEPARATOR + "Main"); //$NON-NLS-1$
	}

	private Xtend2Emitter getPrimaryXtendEmitter(String templateFqn) {
		String[] parts = templateFqn.split("::");
		String classFqn = templateFqn.replace("::", ".");
		Class<?> clazz;
		try {
			clazz = Class.forName(classFqn);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Can't load: " + classFqn, e);
		}
		return new Xtend2Emitter(myInjector, clazz, parts[parts.length - 1]);
	}

	private Xtend2Emitter getXtendEmitter(String templateFqn) {
		String[] parts = templateFqn.split("::");
		String classFqn = templateFqn.substring(0, templateFqn.lastIndexOf("::")).replace("::", ".");
		Class<?> clazz;
		try {
			clazz = Class.forName(classFqn);
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Can't load: " + classFqn, e);
		}
		return new Xtend2Emitter(myInjector, clazz, parts[parts.length - 1]);
	}

}
