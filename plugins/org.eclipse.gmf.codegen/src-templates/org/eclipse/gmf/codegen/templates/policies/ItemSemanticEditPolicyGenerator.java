package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;
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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gef.commands.UnexecutableCommand;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;" + NL + "import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.SemanticEditPolicy;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeModelCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends SemanticEditPolicy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getSemanticCommand(IEditCommandRequest request) {" + NL + "\t\tIEditCommandRequest completedRequest = completeRequest(request);" + NL + "\t\tCommand semanticCommand = getSemanticCommandSwitch(completedRequest);" + NL + "\t\tif (semanticCommand == null) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tboolean shouldProceed = true;" + NL + "\t\tif (completedRequest instanceof DestroyRequest) {" + NL + "\t\t\tshouldProceed = shouldProceed((DestroyRequest) completedRequest);" + NL + "\t\t}" + NL + "\t\tif (shouldProceed) {" + NL + "\t\t\tif (completedRequest instanceof DestroyRequest) {" + NL + "\t\t\t\tICommand deleteCommand = new DeleteCommand((View) getHost().getModel());" + NL + "\t\t\t\tsemanticCommand.chain(new EtoolsProxyCommand(deleteCommand));" + NL + "\t\t\t}" + NL + "\t\t\treturn semanticCommand;" + NL + "\t\t}" + NL + "\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getSemanticCommandSwitch(IEditCommandRequest req) {" + NL + "\t\tif (req instanceof CreateRelationshipRequest) {" + NL + "\t\t\treturn getCreateRelationshipCommand((CreateRelationshipRequest) req);" + NL + "\t\t} else if (req instanceof CreateElementRequest) {" + NL + "\t\t\treturn getCreateCommand((CreateElementRequest) req);" + NL + "\t\t} else if (req instanceof ConfigureRequest) {" + NL + "\t\t\treturn getConfigureCommand((ConfigureRequest) req);" + NL + "\t\t} else if (req instanceof DestroyElementRequest) {" + NL + "\t\t\treturn getDestroyElementCommand((DestroyElementRequest) req);" + NL + "\t\t} else if (req instanceof DestroyReferenceRequest) {" + NL + "\t\t\treturn getDestroyReferenceCommand((DestroyReferenceRequest) req);" + NL + "\t\t} else if (req instanceof DuplicateElementsRequest) {" + NL + "\t\t\treturn getDuplicateCommand((DuplicateElementsRequest) req);" + NL + "\t\t} else if (req instanceof GetEditContextRequest) {" + NL + "\t\t\treturn getEditContextCommand((GetEditContextRequest) req);" + NL + "\t\t} else if (req instanceof MoveRequest) {" + NL + "\t\t\treturn getMoveCommand((MoveRequest) req);" + NL + "\t\t} else if (req instanceof ReorientReferenceRelationshipRequest) {" + NL + "\t\t\treturn getReorientReferenceRelationshipCommand((ReorientReferenceRelationshipRequest) req);" + NL + "\t\t} else if (req instanceof ReorientRelationshipRequest) {" + NL + "\t\t\treturn getReorientRelationshipCommand((ReorientRelationshipRequest) req);" + NL + "\t\t} else if (req instanceof SetRequest) {" + NL + "\t\t\treturn getSetCommand((SetRequest) req);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getConfigureCommand(ConfigureRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getCreateCommand(CreateElementRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getSetCommand(SetRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getEditContextCommand(GetEditContextRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDuplicateCommand(DuplicateElementsRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getMoveCommand(MoveRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getReorientRelationshipCommand(ReorientRelationshipRequest req) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getMSLWrapper(ICommand cmd) {" + NL + "\t\tCompositeModelCommand modelCmd = new CompositeModelCommand(cmd.getLabel());" + NL + "\t\tmodelCmd.compose(cmd);" + NL + "\t\treturn new EtoolsProxyCommand(modelCmd);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getSemanticElement() {" + NL + "\t\treturn ViewUtil.resolveSemanticElement((View) getHost().getModel());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Finds container element for the new relationship of the specified type." + NL + "\t * Default implementation goes up by containment hierarchy starting from" + NL + "\t * the specified element and returns the first element that is instance of" + NL + "\t * the specified container class." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getRelationshipContainer(EObject element, EClass containerClass, IElementType relationshipType) {" + NL + "\t\tfor (; element != null; element = element.eContainer()) {" + NL + "\t\t\tif (containerClass.isSuperTypeOf(element.eClass())) {" + NL + "\t\t\t\treturn element;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL;
  protected final String TEXT_6 = NL + "\t/**" + NL + "\t * @generated " + NL + "\t */" + NL + "\tprotected static class ";
  protected final String TEXT_7 = " {";
  protected final String TEXT_8 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */" + NL + "\t\tpublic static final ";
  protected final String TEXT_9 = " ";
  protected final String TEXT_10 = " = new ";
  protected final String TEXT_11 = "(" + NL + "\t\t\tnew LinkEndConstraint(" + NL + "\t\t\t\t";
  protected final String TEXT_12 = ", //$NON-NLS-1$" + NL + "\t\t\t\t";
  protected final String TEXT_13 = ")," + NL + "\t\t\tnew LinkEndConstraint(" + NL + "\t\t\t\t";
  protected final String TEXT_14 = ", //$NON-NLS-1$" + NL + "\t\t\t\t";
  protected final String TEXT_15 = ")," + NL + "\t\t\t\t";
  protected final String TEXT_16 = ");";
  protected final String TEXT_17 = NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate static final String OPPOSITE_END_VAR = \"oppositeEnd\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate static final String LINK_VAR = \"link\"; //$NON-NLS-1$\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_18 = " varOppositeEndToSource;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_19 = " varOppositeEndToTarget;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_20 = " varLinkObject;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_21 = " srcEndInv;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate ";
  protected final String TEXT_22 = " targetEndInv;" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tpublic ";
  protected final String TEXT_23 = "(LinkEndConstraint sourceEnd, LinkEndConstraint targetEnd, ";
  protected final String TEXT_24 = " linkClass) {" + NL + "\t\t\tif(linkClass != null) {" + NL + "\t\t\t\tthis.varLinkObject = createVar(LINK_VAR, linkClass);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(sourceEnd != null && sourceEnd.context != null && sourceEnd.body != null) {\t\t\t\t" + NL + "\t\t\t\tif(targetEnd != null && targetEnd.context != null) {" + NL + "\t\t\t\t\tthis.varOppositeEndToTarget = createVar(OPPOSITE_END_VAR, targetEnd.context);\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\tthis.srcEndInv = createQuery(sourceEnd, varOppositeEndToTarget);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif(targetEnd != null && targetEnd.context != null && targetEnd.body != null) {" + NL + "\t\t\t\tif(sourceEnd != null && sourceEnd.context != null) {" + NL + "\t\t\t\t\tthis.varOppositeEndToSource = createVar(OPPOSITE_END_VAR, sourceEnd.context);\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\tthis.targetEndInv = createQuery(targetEnd, varOppositeEndToSource);\t\t\t" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tpublic boolean canCreateLink(";
  protected final String TEXT_25 = " req, boolean isBackDirected) {" + NL + "\t\t\tObject source = req.getSource();" + NL + "\t\t\tObject target = req.getTarget();" + NL + "\t\t\tObject link = req.getNewElement(); " + NL + "\t\t\tQuery sourceConstraint = isBackDirected ? targetEndInv : srcEndInv;" + NL + "\t\t\tQuery targetConstraint = null;" + NL + "\t\t\tif(req.getTarget() != null) {" + NL + "\t\t\t\ttargetConstraint = isBackDirected ? srcEndInv : targetEndInv;" + NL + "\t\t\t}" + NL + "\t\t\tboolean isSourceAccepted = sourceConstraint != null ? evaluate(sourceConstraint, source, target, link, false) : true;" + NL + "\t\t\tif(isSourceAccepted && targetConstraint != null) {" + NL + "\t\t\t\treturn evaluate(targetConstraint, target, source, link, true);" + NL + "\t\t\t}" + NL + "\t\t\treturn isSourceAccepted;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t" + NL + "\t\tprivate Query createQuery(LinkEndConstraint constraint, ";
  protected final String TEXT_26 = " oppositeEndDecl) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_27 = " env = ";
  protected final String TEXT_28 = ".ECORE_INSTANCE.createClassifierContext(constraint.context);" + NL + "\t\t\t\tif(oppositeEndDecl != null) env.addElement(oppositeEndDecl.getName(), oppositeEndDecl, true);" + NL + "\t\t\t\tif(varLinkObject != null) env.addElement(LINK_VAR, varLinkObject, true);\t\t\t" + NL + "" + NL + "\t\t\t\treturn ";
  protected final String TEXT_29 = ".eINSTANCE.createQuery(" + NL + "\t\t\t\t\t";
  protected final String TEXT_30 = ".createInvariant(env, constraint.body, true));" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprivate static boolean evaluate(";
  protected final String TEXT_31 = " query, Object sourceEnd, Object oppositeEnd, Object link, boolean clearEnv) {" + NL + "\t\t\t";
  protected final String TEXT_32 = " evalEnv = query.getEvaluationEnvironment();" + NL + "\t\t\tevalEnv.replace(OPPOSITE_END_VAR, oppositeEnd);" + NL + "\t\t\tevalEnv.replace(LINK_VAR, link);\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\tObject val = query.evaluate(sourceEnd);\t\t\t" + NL + "\t\t\t\treturn (val instanceof Boolean) ? ((Boolean)val).booleanValue() : false;" + NL + "\t\t\t} catch(Exception e) {\t\t" + NL + "\t\t\t\te.printStackTrace();\t\t\t" + NL + "\t\t\t\tif(evalEnv != null) evalEnv.clear();\t\t\t" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t} finally {" + NL + "\t\t\t\tif(clearEnv) evalEnv.clear();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated " + NL + "\t\t */\t\t" + NL + "\t\tprivate static ";
  protected final String TEXT_33 = " createVar(String name, ";
  protected final String TEXT_34 = " type) {" + NL + "\t\t\t";
  protected final String TEXT_35 = " var = ";
  protected final String TEXT_36 = ".eINSTANCE.createVariableDeclaration();" + NL + "\t\t\tvar.setName(name);" + NL + "\t\t\tvar.setType(";
  protected final String TEXT_37 = ".getOclType(type));\t\t" + NL + "\t\t\treturn var;" + NL + "\t\t}\t" + NL + "\t}" + NL + "\t/**" + NL + "\t * @generated " + NL + "\t */\t" + NL + "\tstatic class LinkEndConstraint {" + NL + "\t\tfinal ";
  protected final String TEXT_38 = " context;" + NL + "\t\tfinal String body;" + NL + "\t\tLinkEndConstraint(String body, ";
  protected final String TEXT_39 = " context) {" + NL + "\t\t\tthis.context = context;" + NL + "\t\t\tthis.body = body;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_40 = "\t" + NL + "}";
  protected final String TEXT_41 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportUtil importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
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
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportUtil importManager) {
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
			result.append(".set");
			result.append(feature.getAccessorName());
			result.append("(");
		}
		return result.toString();
	}
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportUtil importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
	public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram diagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(diagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(diagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(diagram.getBaseItemSemanticEditPolicyClassName());
    stringBuffer.append(TEXT_5);
    
if(diagram.hasLinkCreationConstraints()) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(diagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_7);
    
	for (Iterator it = diagram.getLinks().iterator(); it.hasNext();) {
		GenLink nextLink = (GenLink) it.next();
		GenLinkConstraints linkConstraints = nextLink.getCreationConstraints();
		if(linkConstraints != null) {						
			String srcConstraint = linkConstraints.getSourceEnd() != null ? linkConstraints.getSourceEnd().getBody() : null;
			String targetConstraint = linkConstraints.getTargetEnd() != null ? linkConstraints.getTargetEnd().getBody(): null;
			GenClass srcContext = linkConstraints.getSourceEndContextClass();
			GenClass targetContext = linkConstraints.getTargetEndContextClass();
			GenClass linkClass = linkConstraints.getLinkClass();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(diagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(linkConstraints.getConstraintsInstanceFieldName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(diagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(srcConstraint != null ? "\"" + srcConstraint + "\"" : null);
    stringBuffer.append(TEXT_12);
    stringBuffer.append((srcContext!=null) ? getMetaClassAccessor(srcContext, importManager) : null);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(targetConstraint != null ? "\"" + targetConstraint + "\"" : null);
    stringBuffer.append(TEXT_14);
    stringBuffer.append((targetContext!=null) ? getMetaClassAccessor(targetContext, importManager) : null);
    stringBuffer.append(TEXT_15);
    stringBuffer.append((linkClass!=null) ? getMetaClassAccessor(linkClass, importManager) : null);
    stringBuffer.append(TEXT_16);
    
		} // end of LinkConstraints if
	} // end of link iteration

    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.expressions.VariableDeclaration"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.expressions.VariableDeclaration"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.expressions.VariableDeclaration"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.Query"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.Query"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(diagram.getLinkCreationConstraintsClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClassifier"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.expressions.VariableDeclaration"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.parser.Environment"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.parser.EcoreEnvironmentFactory"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.QueryFactory"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.expressions.util.ExpressionsUtil"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.query.Query"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.parser.EvaluationEnvironment"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.expressions.VariableDeclaration"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClassifier"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.expressions.VariableDeclaration"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.expressions.ExpressionsFactory"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ocl.parser.EcoreEnvironment"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClassifier"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClassifier"));
    stringBuffer.append(TEXT_39);
    } //end of LinkConstraints 
    stringBuffer.append(TEXT_40);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}