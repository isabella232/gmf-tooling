package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;

public class ItemSemanticEditPolicyGenerator {
 
  protected static String nl;
  public static synchronized ItemSemanticEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ItemSemanticEditPolicyGenerator result = new ItemSemanticEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;" + NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gef.commands.UnexecutableCommand;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;" + NL + "import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IEditHelperContext;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " extends SemanticEditPolicy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getSemanticCommand(IEditCommandRequest request) {" + NL + "\t\tIEditCommandRequest completedRequest = completeRequest(request);" + NL + "\t\tObject editHelperContext = completedRequest.getEditHelperContext();" + NL + "\t\tif (editHelperContext instanceof View || (editHelperContext instanceof IEditHelperContext && ((IEditHelperContext) editHelperContext).getEObject() instanceof View)) {" + NL + "\t\t\t// no semantic commands are provided for pure design elements" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tif (editHelperContext == null) {" + NL + "\t\t\teditHelperContext = ViewUtil.resolveSemanticElement((View) getHost().getModel());" + NL + "\t\t}" + NL + "\t\tIElementType elementType = ElementTypeRegistry.getInstance().getElementType(editHelperContext);" + NL + "\t\tif (elementType == ElementTypeRegistry.getInstance().getType(\"org.eclipse.gmf.runtime.emf.type.core.default\")) { //$NON-NLS-1$ ";
  protected final String TEXT_8 = NL + "\t\t\telementType = null;" + NL + "\t\t}" + NL + "\t\tCommand epCommand = getSemanticCommandSwitch(completedRequest);" + NL + "\t\tif (epCommand != null) {" + NL + "\t\t\tICommand command = epCommand instanceof ICommandProxy ? ((ICommandProxy) epCommand).getICommand() : new CommandProxy(epCommand);" + NL + "\t\t\tcompletedRequest.setParameter(";
  protected final String TEXT_9 = ".EDIT_POLICY_COMMAND, command);" + NL + "\t\t}" + NL + "\t\tCommand ehCommand = null;" + NL + "\t\tif (elementType != null) {" + NL + "\t\t\tICommand command = elementType.getEditCommand(completedRequest);" + NL + "\t\t\tif (command != null) {" + NL + "\t\t\t\tif (!(command instanceof CompositeTransactionalCommand)) {" + NL + "\t\t\t\t\tTransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();" + NL + "\t\t\t\t\tcommand = new CompositeTransactionalCommand(editingDomain, null).compose(command);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tehCommand = new ICommandProxy(command);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tboolean shouldProceed = true;" + NL + "\t\tif (completedRequest instanceof DestroyRequest) {" + NL + "\t\t\tshouldProceed = shouldProceed((DestroyRequest) completedRequest);" + NL + "\t\t}" + NL + "\t\tif (shouldProceed) {" + NL + "\t\t\tif (completedRequest instanceof DestroyRequest) {" + NL + "\t\t\t\tTransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();" + NL + "\t\t\t\tCommand deleteViewCommand = new ICommandProxy(new DeleteCommand(editingDomain, (View) getHost().getModel()));" + NL + "\t\t\t\tehCommand = ehCommand == null ? deleteViewCommand : ehCommand.chain(deleteViewCommand);" + NL + "\t\t\t}" + NL + "\t\t\treturn ehCommand;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getSemanticCommandSwitch(IEditCommandRequest req) {" + NL + "\t\tif (req instanceof CreateRelationshipRequest) {" + NL + "\t\t\treturn getCreateRelationshipCommand((CreateRelationshipRequest) req);" + NL + "\t\t} else if (req instanceof CreateElementRequest) {" + NL + "\t\t\treturn getCreateCommand((CreateElementRequest) req);" + NL + "\t\t} else if (req instanceof ConfigureRequest) {" + NL + "\t\t\treturn getConfigureCommand((ConfigureRequest) req);" + NL + "\t\t} else if (req instanceof DestroyElementRequest) {" + NL + "\t\t\treturn getDestroyElementCommand((DestroyElementRequest) req);" + NL + "\t\t} else if (req instanceof DestroyReferenceRequest) {" + NL + "\t\t\treturn getDestroyReferenceCommand((DestroyReferenceRequest) req);" + NL + "\t\t} else if (req instanceof DuplicateElementsRequest) {" + NL + "\t\t\treturn getDuplicateCommand((DuplicateElementsRequest) req);" + NL + "\t\t} else if (req instanceof GetEditContextRequest) {" + NL + "\t\t\treturn getEditContextCommand((GetEditContextRequest) req);" + NL + "\t\t} else if (req instanceof MoveRequest) {" + NL + "\t\t\treturn getMoveCommand((MoveRequest) req);" + NL + "\t\t} else if (req instanceof ReorientReferenceRelationshipRequest) {" + NL + "\t\t\treturn getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);" + NL + "\t\t} else if (req instanceof ReorientRelationshipRequest) {" + NL + "\t\t\treturn getReorientRelationshipCommand((ReorientRelationshipRequest) req);" + NL + "\t\t} else if (req instanceof SetRequest) {" + NL + "\t\t\treturn getSetCommand((SetRequest) req);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getConfigureCommand(ConfigureRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateCommand(CreateElementRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getSetCommand(SetRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getEditContextCommand(GetEditContextRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDuplicateCommand(DuplicateElementsRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getMoveCommand(MoveRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {" + NL + "\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {" + NL + "\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getMSLWrapper(ICommand cmd) {" + NL + "\t\treturn new ICommandProxy(cmd);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getSemanticElement() {" + NL + "\t\treturn ViewUtil.resolveSemanticElement((View) getHost().getModel());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Finds container element for the new relationship of the specified type." + NL + "\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t * the specified element and returns the first element that is instance of" + NL + "\t * the specified container class." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getRelationshipContainer(EObject element, EClass containerClass, IElementType relationshipType) {" + NL + "\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\treturn element;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tprotected static class ";
  protected final String TEXT_10 = " {";
  protected final String TEXT_11 = NL + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate static final String OPPOSITE_END_VAR = \"";
  protected final String TEXT_12 = "\"; //$NON-NLS-1$";
  protected final String TEXT_13 = NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprivate static ";
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = "_SourceExpression;" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tstatic {";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = " ";
  protected final String TEXT_18 = " = new ";
  protected final String TEXT_19 = "(3);";
  protected final String TEXT_20 = ".put(\"";
  protected final String TEXT_21 = "\", ";
  protected final String TEXT_22 = "); //$NON-NLS-1$";
  protected final String TEXT_23 = NL + "\t\t\t";
  protected final String TEXT_24 = "_SourceExpression = ";
  protected final String TEXT_25 = "null";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = "(";
  protected final String TEXT_28 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_29 = ", ";
  protected final String TEXT_30 = ")";
  protected final String TEXT_31 = ".";
  protected final String TEXT_32 = "(";
  protected final String TEXT_33 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_34 = ")";
  protected final String TEXT_35 = "new ";
  protected final String TEXT_36 = "(";
  protected final String TEXT_37 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_38 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_39 = " self = (";
  protected final String TEXT_40 = ")context;";
  protected final String TEXT_41 = "\t" + NL + "\t\t";
  protected final String TEXT_42 = " ";
  protected final String TEXT_43 = " = (";
  protected final String TEXT_44 = ")env.get(\"";
  protected final String TEXT_45 = "\"); //$NON-NLS-1$";
  protected final String TEXT_46 = NL + "\t\treturn ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = "(self";
  protected final String TEXT_49 = ", ";
  protected final String TEXT_50 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_51 = NL + ";" + NL + "\t\t}";
  protected final String TEXT_52 = NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprivate static ";
  protected final String TEXT_53 = " ";
  protected final String TEXT_54 = "_TargetExpression;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tstatic {";
  protected final String TEXT_55 = NL;
  protected final String TEXT_56 = " ";
  protected final String TEXT_57 = " = new ";
  protected final String TEXT_58 = "(3);";
  protected final String TEXT_59 = ".put(\"";
  protected final String TEXT_60 = "\", ";
  protected final String TEXT_61 = "); //$NON-NLS-1$";
  protected final String TEXT_62 = NL + "\t\t\t";
  protected final String TEXT_63 = "_TargetExpression = ";
  protected final String TEXT_64 = "null";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = "(";
  protected final String TEXT_67 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_68 = ", ";
  protected final String TEXT_69 = ")";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = "(";
  protected final String TEXT_72 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_73 = ")";
  protected final String TEXT_74 = "new ";
  protected final String TEXT_75 = "(";
  protected final String TEXT_76 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_77 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_78 = " self = (";
  protected final String TEXT_79 = ")context;";
  protected final String TEXT_80 = "\t" + NL + "\t\t";
  protected final String TEXT_81 = " ";
  protected final String TEXT_82 = " = (";
  protected final String TEXT_83 = ")env.get(\"";
  protected final String TEXT_84 = "\"); //$NON-NLS-1$";
  protected final String TEXT_85 = NL + "\t\treturn ";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = "(self";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_90 = NL + ";" + NL + "\t\t}";
  protected final String TEXT_91 = NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tpublic static boolean canCreate";
  protected final String TEXT_92 = "(";
  protected final String TEXT_93 = " container, ";
  protected final String TEXT_94 = " source, ";
  protected final String TEXT_95 = " target) {";
  protected final String TEXT_96 = NL + "\t\t\tif (";
  protected final String TEXT_97 = " != null) {";
  protected final String TEXT_98 = NL + "\t\t\t\tif (";
  protected final String TEXT_99 = " != null) {";
  protected final String TEXT_100 = NL + "\t\t\t\tif (";
  protected final String TEXT_101 = ".size() >= ";
  protected final String TEXT_102 = ") {";
  protected final String TEXT_103 = NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}";
  protected final String TEXT_104 = NL + "\t\t\t\tif (";
  protected final String TEXT_105 = " != null) {";
  protected final String TEXT_106 = NL + "\t\t\t\tif (";
  protected final String TEXT_107 = ".size() >= ";
  protected final String TEXT_108 = ") {";
  protected final String TEXT_109 = NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}";
  protected final String TEXT_110 = NL + "\t\t\t}";
  protected final String TEXT_111 = NL + "\t\t\tif (source != null) {";
  protected final String TEXT_112 = NL + "\t\t\t\tif (";
  protected final String TEXT_113 = " != null) {";
  protected final String TEXT_114 = NL + "\t\t\t\tif (";
  protected final String TEXT_115 = ".size() >= ";
  protected final String TEXT_116 = " || ";
  protected final String TEXT_117 = ".contains(target)) {";
  protected final String TEXT_118 = NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}";
  protected final String TEXT_119 = NL + "\t\t\t\tif (";
  protected final String TEXT_120 = ".contains(target)) {" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}";
  protected final String TEXT_121 = NL + "\t\t\t}";
  protected final String TEXT_122 = NL + "\t\t\tif (!";
  protected final String TEXT_123 = ".";
  protected final String TEXT_124 = "(source, target).booleanValue()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_125 = NL + "\t\t\tif (!evaluate(";
  protected final String TEXT_126 = "_SourceExpression, source, target, false)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_127 = NL + "\t\t\tif (!";
  protected final String TEXT_128 = ".";
  protected final String TEXT_129 = "(target, source).booleanValue()) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_130 = NL + "\t\t\tif (!evaluate(";
  protected final String TEXT_131 = "_TargetExpression, target, source, true)) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}";
  protected final String TEXT_132 = NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_133 = NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tprivate static boolean evaluate(";
  protected final String TEXT_134 = " constraint, Object sourceEnd, Object oppositeEnd, boolean clearEnv) {" + NL + "\t\t\tif (sourceEnd == null) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_135 = " evalEnv = ";
  protected final String TEXT_136 = ".singletonMap(OPPOSITE_END_VAR, oppositeEnd);\t\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\tObject val = constraint.evaluate(sourceEnd, evalEnv);" + NL + "\t\t\t\treturn (val instanceof Boolean) ? ((Boolean) val).booleanValue() : false;" + NL + "\t\t\t} catch(Exception e) {\t" + NL + "\t\t\t\t";
  protected final String TEXT_137 = ".getInstance().logError(\"Link constraint evaluation error\", e); //$NON-NLS-1$" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_138 = "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static class ";
  protected final String TEXT_139 = " {";
  protected final String TEXT_140 = NL;
  protected final String TEXT_141 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_142 = " ";
  protected final String TEXT_143 = "(";
  protected final String TEXT_144 = " self";
  protected final String TEXT_145 = ", ";
  protected final String TEXT_146 = " ";
  protected final String TEXT_147 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_148 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_149 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_150 = NL;
  protected final String TEXT_151 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_152 = " ";
  protected final String TEXT_153 = "(";
  protected final String TEXT_154 = " self";
  protected final String TEXT_155 = ", ";
  protected final String TEXT_156 = " ";
  protected final String TEXT_157 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_158 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_159 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_160 = NL + "\t\t} // ";
  protected final String TEXT_161 = "\t" + NL + "\t}" + NL + "" + NL + "}\t";

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				if (feature.getTypeGenClass() != null) {
					result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
				} else {
					// EDataType
					result.append(importManager.getImportedName(feature.getTypeGenClassifier().getEcoreClassifier().getInstanceClassName()));
				}

			}
			result.append(")");
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eGet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("()))");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".");
			result.append(feature.getGetAccessor());
			result.append("()");
		}
		return result.toString();
	}
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eSet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("(), ");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			if (feature.isListType()) {
				result.append(".");
				result.append(feature.getGetAccessor());
				result.append("().add(");
			} else {
				result.append(".set");
				result.append(feature.getAccessorName());
				result.append("(");
			}
		}
		return result.toString();
	}
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportAssistant importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
final String javaExprContainer = "JavaConstraints";
final String oppositeEndVarName = "oppositeEnd";
importManager.registerInnerClass(javaExprContainer);
importManager.registerInnerClass(genDiagram.getLinkCreationConstraintsClassName());

    stringBuffer.append(TEXT_5);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getBaseItemSemanticEditPolicyClassName());
    stringBuffer.append(TEXT_7);
     /*
			< % = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()) % >.getInstance().logInfo("Failed to get element type for " + editHelperContext); / / $NON-NLS-1$ */ 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseEditHelperQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_10);
    final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();
boolean hasJavaConstraints = false;
boolean hasOCLConstraints = false;
if (expressionProviders != null) {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(oppositeEndVarName);
    stringBuffer.append(TEXT_12);
    	for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
		GenLink nextLink = (GenLink) it.next();
		GenLinkConstraints linkConstraints = nextLink.getCreationConstraints();
		if (linkConstraints == null || !linkConstraints.isValid()) {
			continue;
		}
		String importedAbstractExprCls = importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName());
		String __javaOperationContainer = javaExprContainer;
		String __outEnvVarName = "env";
		if (linkConstraints.getSourceEnd() != null) {
			if (expressionProviders.getProvider(linkConstraints.getSourceEnd()) instanceof GenJavaExpressionProvider) {
				hasJavaConstraints = true;
			} else if (expressionProviders.getProvider(linkConstraints.getSourceEnd()) instanceof GenExpressionInterpreter) {
				hasOCLConstraints = true;
				Map __exprEnvVariables = new java.util.HashMap();
				GenClassifier __genExprContext = linkConstraints.getSourceEndContextClass();
				ValueExpression __genValueExpression = linkConstraints.getSourceEnd();
				__exprEnvVariables.put(oppositeEndVarName, linkConstraints.getTargetEndContextClass());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_15);
    
{ /*begin the scope*/
/*
java.util.Map __exprEnvVariables;
String __outEnvVarName;
ValueExpression __genValueExpression;
*/
if(!__exprEnvVariables.isEmpty() && genDiagram.getEditorGen().getExpressionProviders() != null && 
	genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) 
	instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {	

    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_19);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String nextVariableName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
		String varTypeEClassifierAccess = nextVariableType.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + nextVariableType.getClassifierAccessorName()+"()";			


    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(varTypeEClassifierAccess);
    stringBuffer.append(TEXT_22);
    	
	} 
}

    
} /*end the scope*/

    stringBuffer.append(TEXT_23);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_24);
    
{ /*begin the scope*/
/*
ValueExpression __genValueExpression;
GenClassifier __genExprContext
java.util.Map __exprEnvVariables
String __outEnvVarName;
String __javaOperationContainer;
*/
	org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
	String __ctxEClassifierAccess = importManager.getImportedName(__genExprContext.getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + __genExprContext.getClassifierAccessorName()+"()";
	String __importedAbstractClass = __genExprProvider != null ? importManager.getImportedName(__genExprProvider.getContainer().getAbstractExpressionQualifiedClassName()) : null;

	if(__genExprProvider == null || __importedAbstractClass == null) {

    stringBuffer.append(TEXT_25);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_30);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_34);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_35);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_40);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_45);
    		} 
    stringBuffer.append(TEXT_46);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_47);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_48);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_49);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_50);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_51);
    			}
		}
		if (linkConstraints.getTargetEnd() != null) {
			if (expressionProviders.getProvider(linkConstraints.getTargetEnd()) instanceof GenJavaExpressionProvider) {
				hasJavaConstraints = true;
			} else if (expressionProviders.getProvider(linkConstraints.getTargetEnd()) instanceof GenExpressionInterpreter) {
				hasOCLConstraints = true;
				Map __exprEnvVariables = new java.util.HashMap();
				GenClassifier __genExprContext = linkConstraints.getTargetEndContextClass();
				ValueExpression __genValueExpression = linkConstraints.getTargetEnd();			
				__exprEnvVariables.put(oppositeEndVarName, linkConstraints.getSourceEndContextClass());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_54);
    
{ /*begin the scope*/
/*
java.util.Map __exprEnvVariables;
String __outEnvVarName;
ValueExpression __genValueExpression;
*/
if(!__exprEnvVariables.isEmpty() && genDiagram.getEditorGen().getExpressionProviders() != null && 
	genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) 
	instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {	

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_58);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String nextVariableName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
		String varTypeEClassifierAccess = nextVariableType.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + nextVariableType.getClassifierAccessorName()+"()";			


    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(varTypeEClassifierAccess);
    stringBuffer.append(TEXT_61);
    	
	} 
}

    
} /*end the scope*/

    stringBuffer.append(TEXT_62);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_63);
    
{ /*begin the scope*/
/*
ValueExpression __genValueExpression;
GenClassifier __genExprContext
java.util.Map __exprEnvVariables
String __outEnvVarName;
String __javaOperationContainer;
*/
	org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
	String __ctxEClassifierAccess = importManager.getImportedName(__genExprContext.getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + __genExprContext.getClassifierAccessorName()+"()";
	String __importedAbstractClass = __genExprProvider != null ? importManager.getImportedName(__genExprProvider.getContainer().getAbstractExpressionQualifiedClassName()) : null;

	if(__genExprProvider == null || __importedAbstractClass == null) {

    stringBuffer.append(TEXT_64);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_69);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_73);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_74);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_79);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_84);
    		} 
    stringBuffer.append(TEXT_85);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_86);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_87);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_88);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_89);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_90);
    			}
		}
	}
}
	
for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	boolean separateContainer;
	GenClass outgoingClass;
	GenClass incomingClass;
	GenClass containerClass = null;
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
		GenFeature sourceFeature = modelFacet.getSourceMetaFeature();
		separateContainer = sourceFeature != null;
		if (separateContainer) {
			outgoingClass = sourceFeature.getTypeGenClass();
			containerClass = containmentFeature.getGenClass();
		} else {
			outgoingClass = containmentFeature.getGenClass();
		}
		incomingClass = modelFacet.getTargetMetaFeature().getTypeGenClass();
	} else if (nextLink.getModelFacet() instanceof FeatureLinkModelFacet) {
		GenFeature metaFeature = ((FeatureLinkModelFacet) nextLink.getModelFacet()).getMetaFeature();
		outgoingClass = metaFeature.getGenClass();
		incomingClass = metaFeature.getTypeGenClass();
		separateContainer = false;
	} else {
		continue;
	}
    stringBuffer.append(TEXT_91);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_92);
    if (separateContainer) {
    stringBuffer.append(importManager.getImportedName(containerClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_93);
    }
    stringBuffer.append(importManager.getImportedName(outgoingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName(incomingClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_95);
    	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		GenFeature containmentFeature = modelFacet.getContainmentMetaFeature();
		GenFeature childFeature = modelFacet.getChildMetaFeature();

		int upperContainmentBound = containmentFeature.getEcoreFeature().getUpperBound();
		int upperChildBound = childFeature.getEcoreFeature().getUpperBound();
		boolean checkChildFeatureUpperBound = !childFeature.equals(containmentFeature) && upperChildBound > 0;
		String containerVarName = separateContainer ? "container" : "source";
		if (upperContainmentBound > 0 || checkChildFeatureUpperBound) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(containerVarName);
    stringBuffer.append(TEXT_97);
    /* check that containment feature is not set / has capacity for the new element */ 
			if (upperContainmentBound > 0) {
				if (upperContainmentBound == 1) {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(getFeatureValueGetter(containerVarName, containmentFeature, false, importManager));
    stringBuffer.append(TEXT_99);
    				} else {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(getFeatureValueGetter(containerVarName, containmentFeature, false, importManager));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(upperContainmentBound);
    stringBuffer.append(TEXT_102);
    				}
    stringBuffer.append(TEXT_103);
    			}
			if (checkChildFeatureUpperBound) {
				if (upperChildBound == 1) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(getFeatureValueGetter(containerVarName, childFeature, false, importManager));
    stringBuffer.append(TEXT_105);
    				} else {
    stringBuffer.append(TEXT_106);
    stringBuffer.append(getFeatureValueGetter(containerVarName, childFeature, false, importManager));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(upperChildBound);
    stringBuffer.append(TEXT_108);
    				}
    stringBuffer.append(TEXT_109);
    			}
    stringBuffer.append(TEXT_110);
    		}		
	} else { /* nextLink.getModelFacet() instanceof FeatureLinkModelFacet */
		GenFeature metaFeature = ((FeatureLinkModelFacet) nextLink.getModelFacet()).getMetaFeature();
		int upperBound = metaFeature.getEcoreFeature().getUpperBound();
    stringBuffer.append(TEXT_111);
     /* check that feature is not set / has capacity for the new value / is unique */
		if (upperBound > 0) {
			if (upperBound == 1) {
    stringBuffer.append(TEXT_112);
    stringBuffer.append(getFeatureValueGetter("source", metaFeature, false, importManager));
    stringBuffer.append(TEXT_113);
    			} else {
    stringBuffer.append(TEXT_114);
    stringBuffer.append(getFeatureValueGetter("source", metaFeature, false, importManager));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(upperBound);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(getFeatureValueGetter("source", metaFeature, false, importManager));
    stringBuffer.append(TEXT_117);
    			}
    stringBuffer.append(TEXT_118);
    		} else {
    stringBuffer.append(TEXT_119);
    stringBuffer.append(getFeatureValueGetter("source", metaFeature, false, importManager));
    stringBuffer.append(TEXT_120);
    		}
    stringBuffer.append(TEXT_121);
    	}
	
	if (expressionProviders != null && nextLink.getCreationConstraints() != null && nextLink.getCreationConstraints().isValid()) {
		GenLinkConstraints constraints = nextLink.getCreationConstraints();
		if (constraints.getSourceEnd() != null) {
			ValueExpression sourceExpression = constraints.getSourceEnd();
			GenExpressionProviderBase expressionProvider = expressionProviders.getProvider(sourceExpression);
			if (expressionProvider instanceof GenJavaExpressionProvider) {
    stringBuffer.append(TEXT_122);
    stringBuffer.append(javaExprContainer);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(((GenJavaExpressionProvider) expressionProvider).getOperationName(sourceExpression));
    stringBuffer.append(TEXT_124);
    			} else if (expressionProvider instanceof GenExpressionInterpreter) {
    stringBuffer.append(TEXT_125);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_126);
    			}
		}
		if (constraints.getTargetEnd() != null) {
			ValueExpression targetExpression = constraints.getTargetEnd();
			GenExpressionProviderBase expressionProvider = expressionProviders.getProvider(targetExpression);
			if (expressionProvider instanceof GenJavaExpressionProvider) {
    stringBuffer.append(TEXT_127);
    stringBuffer.append(javaExprContainer);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(((GenJavaExpressionProvider) expressionProvider).getOperationName(targetExpression));
    stringBuffer.append(TEXT_129);
    			} else if (expressionProvider instanceof GenExpressionInterpreter) {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_131);
    			}
		}
	}
    stringBuffer.append(TEXT_132);
    }
	
if (expressionProviders != null && hasOCLConstraints) {
	String importedAbstractExprCls = importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importedAbstractExprCls);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_137);
    }
	
if(expressionProviders != null && hasJavaConstraints) {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(javaExprContainer);
    stringBuffer.append(TEXT_139);
    
	for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
		GenLinkConstraints linkConstraints = ((GenLink)it.next()).getCreationConstraints();
		if(linkConstraints == null) continue;
		GenClass srcContext = linkConstraints.getSourceEndContextClass();
		GenClass targetContext = linkConstraints.getTargetEndContextClass();
		if(srcContext == null || targetContext == null) continue;
		String __genExprResultType = "java.lang.Boolean";
		Map __exprEnvVariables = new java.util.HashMap();
		GenClassifier __genExprContext = srcContext;
		ValueExpression __genValueExpression = linkConstraints.getSourceEnd();
		if(expressionProviders.getProvider(__genValueExpression) instanceof GenJavaExpressionProvider) {				
			__exprEnvVariables.put(oppositeEndVarName, targetContext);

    stringBuffer.append(TEXT_140);
    
/* 
ValueExpression __genValueExpression
java.util.Map __exprEnvVariables
GenClassifier __genExprContext
GenClassifier || String/qualifiedClassName/__genExprResultType
*/
org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) {
	String __importedAbstractExpr = importManager.getImportedName(__genExprProvider.getContainer().getAbstractExpressionQualifiedClassName());
	String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
	// support GenClassifier and also String based qualified java class name
	Object __genExprResultTypeObj = __genExprResultType;
	String __exprResultTypeQualifiedName = null;
	if(__genExprResultTypeObj instanceof String) 
		__exprResultTypeQualifiedName = (String)__genExprResultTypeObj;
	else if(__genExprResultTypeObj instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)
		__exprResultTypeQualifiedName = __genExprProvider.getQualifiedInstanceClassName((org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__genExprResultTypeObj);
	String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);

    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_144);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_147);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_149);
    
} /* end of GenJavaExpressionProvider */

    
		}
		__genValueExpression = linkConstraints.getTargetEnd();
		if(expressionProviders.getProvider(__genValueExpression) instanceof GenJavaExpressionProvider) {		
			__genExprContext = targetContext;
			__exprEnvVariables.put(oppositeEndVarName, srcContext);

    stringBuffer.append(TEXT_150);
    
/* 
ValueExpression __genValueExpression
java.util.Map __exprEnvVariables
GenClassifier __genExprContext
GenClassifier || String/qualifiedClassName/__genExprResultType
*/
org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) {
	String __importedAbstractExpr = importManager.getImportedName(__genExprProvider.getContainer().getAbstractExpressionQualifiedClassName());
	String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
	// support GenClassifier and also String based qualified java class name
	Object __genExprResultTypeObj = __genExprResultType;
	String __exprResultTypeQualifiedName = null;
	if(__genExprResultTypeObj instanceof String) 
		__exprResultTypeQualifiedName = (String)__genExprResultTypeObj;
	else if(__genExprResultTypeObj instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)
		__exprResultTypeQualifiedName = __genExprProvider.getQualifiedInstanceClassName((org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__genExprResultTypeObj);
	String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);

    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_154);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_157);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_159);
    
} /* end of GenJavaExpressionProvider */

    
		}
	} /*java constraints iteration*/

    stringBuffer.append(TEXT_160);
    stringBuffer.append(javaExprContainer);
    
} /* end of hasJavaConstraints */

    stringBuffer.append(TEXT_161);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}